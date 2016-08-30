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
public class CollectPointDoubleDemo implements CollectPoint {
    private final static double[] VALUES = {1.1, 2.2, 3.3, 4.4, 5.5};

    @Override
    public Metrics collect() {
        Metrics metrics = new Metrics();
        metrics.addMetricValue("java.dobule", this.value(),
                MetricValue.Type.GAUGE.toString(), "");

        return metrics;
    }

    public double value() {
        int idx = Utils.randInt(0, 4);
        return VALUES[idx];
    }
}
