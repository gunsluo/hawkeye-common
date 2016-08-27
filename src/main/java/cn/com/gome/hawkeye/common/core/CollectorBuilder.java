package cn.com.gome.hawkeye.common.core;


import cn.com.gome.hawkeye.common.config.CollectorConfig;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectorBuilder {

    private CollectorConfig config;

    public CollectorBuilder setDefaultConfig(CollectorConfig config) {
        this.config = config;
        return this;
    }

    public Collector build(CollectDataSources collectDataSources) {
        return new Collector(this.config, collectDataSources);
    }

    public static CollectorBuilder create() {
        return new CollectorBuilder();
    }
}
