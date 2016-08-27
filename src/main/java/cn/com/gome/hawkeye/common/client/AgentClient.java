package cn.com.gome.hawkeye.common.client;

import cn.com.gome.hawkeye.common.model.MetricValue;

import java.io.IOException;
import java.util.List;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/26 0026
 */
public interface AgentClient {
    boolean send(List<MetricValue> dList) throws Exception;
}
