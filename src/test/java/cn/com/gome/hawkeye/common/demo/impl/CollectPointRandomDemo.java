package cn.com.gome.hawkeye.common.demo.impl;

import cn.com.gome.hawkeye.common.core.CollectPoint;
import cn.com.gome.hawkeye.common.model.MetricValue;
import cn.com.gome.hawkeye.common.model.Metrics;

import java.util.Random;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectPointRandomDemo implements CollectPoint {
    @Override
    public Metrics collect() {

        Metrics metrics = new Metrics();
        metrics.addMetricValue("java.random", this.randInt(0, 100),
                MetricValue.Type.GAUGE.toString(), "tag=test");

        return metrics;
    }

    int randInt(int min, int max) {

        Random rand = new Random();
        ;

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
