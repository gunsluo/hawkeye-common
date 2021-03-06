package cn.com.gome.hawkeye.common.demo.impl;

import cn.com.gome.hawkeye.common.core.CollectPoint;
import cn.com.gome.hawkeye.common.demo.common.Utils;
import cn.com.gome.hawkeye.common.model.MetricValue;
import cn.com.gome.hawkeye.common.model.Metrics;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectPointRandomDemo implements CollectPoint {
    @Override
    public Metrics collect() {

        Metrics metrics = new Metrics();
        metrics.addMetricValue("java.random", Utils.randInt(0, 100),
                MetricValue.Type.GAUGE.toString(), "");

        return metrics;
    }
}
