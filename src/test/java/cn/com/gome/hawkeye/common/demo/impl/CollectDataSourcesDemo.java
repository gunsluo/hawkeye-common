package cn.com.gome.hawkeye.common.demo.impl;

import cn.com.gome.hawkeye.common.model.CollectBlock;
import cn.com.gome.hawkeye.common.model.CollectBlocks;
import cn.com.gome.hawkeye.common.core.CollectDataSources;
import cn.com.gome.hawkeye.common.core.CollectPoint;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectDataSourcesDemo implements CollectDataSources {

    @Override
    public CollectBlocks getDataSources() {
        CollectPoint collectPoint = new CollectPointRandomDemo();
        CollectBlock collectBlock = new CollectBlock();
        CollectBlocks collectBlocks = new CollectBlocks();

        collectBlock.addCollectPoint(collectPoint);
        collectBlocks.addCollectBlock(collectBlock);

        return collectBlocks;
    }
}
