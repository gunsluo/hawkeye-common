package cn.com.gome.hawkeye.common.core;


import cn.com.gome.hawkeye.common.config.CollectorConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectorBuilder {

    private CollectorConfig config;
    private List<CollectBlock> collectBlocks = new ArrayList<CollectBlock>();

    public CollectorBuilder setDefaultConfig(CollectorConfig config) {
        this.config = config;
        return this;
    }

    public CollectorBuilder addCollectPoints(List<CollectPoint> collectPoints) {

        int interval = this.config.getInterval();
        return addCollectPoints(collectPoints, interval <= 0 ? 60 : interval);
    }

    public CollectorBuilder addCollectPoints(List<CollectPoint> collectPoints, int interval) {
        if (collectPoints != null && collectPoints.size() > 0) {
            this.collectBlocks.add(new CollectBlock(collectPoints, interval));
        }
        return this;
    }

    public Collector build() {
        return new Collector(this.config, this.collectBlocks);
    }

    public static CollectorBuilder create() {
        return new CollectorBuilder();
    }


}
