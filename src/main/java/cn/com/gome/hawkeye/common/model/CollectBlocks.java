package cn.com.gome.hawkeye.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectBlocks {

    List<CollectBlock> collectBlocks = new ArrayList<CollectBlock>();

    public boolean addCollectBlock(CollectBlock collectBlock) {
        this.collectBlocks.add(collectBlock);
        return true;
    }

    public List<CollectBlock> getCollectBlocks() {
        return collectBlocks;
    }

    public void setCollectBlocks(List<CollectBlock> collectBlocks) {
        this.collectBlocks = collectBlocks;
    }
}
