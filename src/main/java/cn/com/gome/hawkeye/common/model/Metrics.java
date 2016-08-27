package cn.com.gome.hawkeye.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class Metrics {

    List<MetricValue> metricValues = new ArrayList<MetricValue>();

    public List<MetricValue> getMetricValues() {
        return metricValues;
    }

    public void setMetricValues(List<MetricValue> metricValues) {
        this.metricValues = metricValues;
    }

    public boolean addMetricValue(MetricValue metricValue) {
        metricValues.add(metricValue);
        return true;
    }

    public boolean addMetricValue(String metric, double value,
                                  String conunterType, String tags) {

        MetricValue mv = new MetricValue();
        mv.setMetric(metric);
        mv.setValue(value);
        mv.setCounterType(conunterType);
        mv.setTags(tags);
        metricValues.add(mv);

        return true;
    }
}
