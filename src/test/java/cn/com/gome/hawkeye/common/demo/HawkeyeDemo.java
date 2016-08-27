package cn.com.gome.hawkeye.common.demo;

import cn.com.gome.hawkeye.common.config.CollectorConfig;
import cn.com.gome.hawkeye.common.core.Collector;
import cn.com.gome.hawkeye.common.core.CollectorBuilder;
import cn.com.gome.hawkeye.common.demo.impl.CollectDataSourcesDemo;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class HawkeyeDemo {
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

        Collector collector = CollectorBuilder.create()
                .setDefaultConfig(config)
                .build(new CollectDataSourcesDemo());
        collector.collect();
    }
}
