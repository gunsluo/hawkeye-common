package cn.com.gome.hawkeye.common.core;

import cn.com.gome.hawkeye.common.client.AgentClient;
import cn.com.gome.hawkeye.common.client.impl.HttpAgentClient;
import cn.com.gome.hawkeye.common.config.CollectorConfig;
import cn.com.gome.hawkeye.common.model.CollectBlock;
import cn.com.gome.hawkeye.common.model.CollectBlocks;
import cn.com.gome.hawkeye.common.model.MetricValue;
import cn.com.gome.hawkeye.common.model.Metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class Collector {
    private CollectorConfig config;
    private CollectDataSources collectDataSources;
    private AgentClient client;

    Collector(CollectorConfig config, CollectDataSources collectDataSources) {
        this.config = config;
        this.collectDataSources = collectDataSources;
        this.init();
    }

    private void init() {
        this.client = new HttpAgentClient(this.config.getUrl(), this.config.getTimeout());
    }

    public void collect() {

        CollectBlocks collectBlocks = this.collectDataSources.getDataSources();
        for (final CollectBlock collectBlock : collectBlocks.getCollectBlocks()) {
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    task(collectBlock);
                }
            }, 0, config.getInterval(), TimeUnit.SECONDS);
        }
    }

    public synchronized void task(CollectBlock collectBlock) {
        List<MetricValue> mvs = new ArrayList<MetricValue>();
        long now = System.currentTimeMillis() / 1000L;
        for (final CollectPoint collectPoint : collectBlock.getCollectPoints()) {

            Metrics metrics = collectPoint.collect();
            for (MetricValue mv : metrics.getMetricValues()) {
                mv.setEndpoint(config.getHostname());
                mv.setStep(config.getInterval());
                mv.setTimestamp((int) now);
                mvs.add(mv);
            }

        }

        try {
            boolean flag = client.send(mvs);
            if (flag == true) {
                System.out.println("send data to agent success.");
            } else {
                System.out.println("send data to agent failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
