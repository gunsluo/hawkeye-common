package cn.com.gome.hawkeye.common.core;

import cn.com.gome.hawkeye.common.client.AgentClient;
import cn.com.gome.hawkeye.common.client.impl.HttpAgentClient;
import cn.com.gome.hawkeye.common.config.CollectorConfig;
import cn.com.gome.hawkeye.common.model.MetricValue;
import cn.com.gome.hawkeye.common.model.Metrics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static Logger logger = LoggerFactory.getLogger(Collector.class);
    private CollectorConfig config;
    private List<CollectBlock> collectBlocks;
    private AgentClient client;

    Collector(CollectorConfig config, List<CollectBlock> collectBlocks) {
        this.config = config;
        this.collectBlocks = collectBlocks;
        this.init();
    }

    private void init() {
        this.client = new HttpAgentClient(this.config.getUrl(), this.config.getTimeout());
    }

    public void collect() {

        for (final CollectBlock collectBlock : this.collectBlocks) {
            int interval = collectBlock.getInterval();
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    task(collectBlock);
                }
            }, 0, interval, TimeUnit.SECONDS);
        }
    }

    public void task(CollectBlock collectBlock) {
        List<MetricValue> mvs = new ArrayList<MetricValue>();
        long now = System.currentTimeMillis() / 1000L;
        for (final CollectPoint collectPoint : collectBlock.getCollectPoints()) {

            Metrics metrics = collectPoint.collect();
            for (MetricValue mv : metrics.getMetricValues()) {
                mv.setEndpoint(config.getHostname());
                mv.setStep(collectBlock.getInterval());
                mv.setTimestamp((int) now);
                mvs.add(mv);
            }

        }

        try {
            boolean flag = client.send(mvs);
            if (flag == true) {
                logger.info("send data to agent success.");
            } else {
                logger.warn("send data to agent failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
