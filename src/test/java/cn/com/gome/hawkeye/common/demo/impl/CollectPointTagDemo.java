package cn.com.gome.hawkeye.common.demo.impl;

import cn.com.gome.hawkeye.common.core.CollectPoint;
import cn.com.gome.hawkeye.common.demo.common.Utils;
import cn.com.gome.hawkeye.common.model.MetricValue;
import cn.com.gome.hawkeye.common.model.Metrics;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/30 0030
 */
public class CollectPointTagDemo implements CollectPoint {
    private final static double[] VALUES = {11, 22, 33, 44, 55};

    @Override
    public Metrics collect() {
        Metrics metrics = new Metrics();
        metrics.addMetricValue("java.tags", this.value(),
                MetricValue.Type.GAUGE.toString(), "tag=lj");

        return metrics;
    }

    public double value() {
        int idx = Utils.randInt(0, 4);
        return VALUES[idx];
    }
}
