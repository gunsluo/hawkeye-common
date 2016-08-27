package cn.com.gome.hawkeye.common.model;

import cn.com.gome.hawkeye.common.core.CollectPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectBlock {

    List<CollectPoint> collectPoints = new ArrayList<CollectPoint>();

    public boolean addCollectPoint(CollectPoint collectPoint) {

        this.collectPoints.add(collectPoint);
        return true;
    }

    public List<CollectPoint> getCollectPoints() {
        return collectPoints;
    }

    public void setCollectPoints(List<CollectPoint> collectPoints) {
        this.collectPoints = collectPoints;
    }
}
