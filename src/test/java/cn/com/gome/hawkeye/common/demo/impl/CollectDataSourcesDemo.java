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
        CollectPoint collectPointDoubleDemo = new CollectPointDoubleDemo();
        CollectPoint collectPointTagDemo = new CollectPointTagDemo();
        CollectBlock collectBlock = new CollectBlock();
        CollectBlock collectBlock2 = new CollectBlock();
        CollectBlocks collectBlocks = new CollectBlocks();

        collectBlock.addCollectPoint(collectPoint);
        collectBlock.addCollectPoint(collectPointDoubleDemo);
        collectBlock2.addCollectPoint(collectPointTagDemo);


        collectBlocks.addCollectBlock(collectBlock);
        collectBlocks.addCollectBlock(collectBlock2);

        return collectBlocks;
    }
}
