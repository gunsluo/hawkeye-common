package cn.com.gome.hawkeye.common.demo;

import cn.com.gome.hawkeye.common.config.CollectorConfig;
import cn.com.gome.hawkeye.common.core.CollectPoint;
import cn.com.gome.hawkeye.common.core.Collector;
import cn.com.gome.hawkeye.common.core.CollectorBuilder;
import cn.com.gome.hawkeye.common.demo.impl.CollectPointDoubleDemo;
import cn.com.gome.hawkeye.common.demo.impl.CollectPointRandomDemo;
import cn.com.gome.hawkeye.common.demo.impl.CollectPointTagDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class Demo {
    public static void main(String[] args) {

        CollectorConfig config = CollectorConfig.custom()
                .setHostname("java-test")
                .setUrl("http://10.128.31.138:1988/v1/push")
                .setInterval(60)
                .setTimeout(10000)
                .build();

        //        try {
        //            CollectorConfig config = CollectorConfig.custom()
        //                    .setFilename("config.properties").load();
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }

        List<CollectPoint> collectPoints = new ArrayList<CollectPoint>();
        collectPoints.add(new CollectPointRandomDemo());
        collectPoints.add(new CollectPointDoubleDemo());
        List<CollectPoint> collectPoints2 = new ArrayList<CollectPoint>();
        collectPoints2.add(new CollectPointTagDemo());

        Collector collector = CollectorBuilder.create()
                .setDefaultConfig(config)
                .addCollectPoints(collectPoints)
                .addCollectPoints(collectPoints2, 50)
                .build();
        collector.collect();
    }
}
