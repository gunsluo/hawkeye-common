package cn.com.gome.hawkeye.common.core;

import java.util.List;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/29 0029
 */
public class CollectBlock {

    private List<CollectPoint> collectPoints;
    private int interval;

    //    CollectBlock(List<CollectPoint> collectPoints) {
    //        this.collectPoints = collectPoints;
    //        this.interval = 10;
    //    }

    CollectBlock(List<CollectPoint> collectPoints, int interval) {
        this.collectPoints = collectPoints;
        this.interval = interval;
    }

    public List<CollectPoint> getCollectPoints() {
        return collectPoints;
    }

    public void setCollectPoints(List<CollectPoint> collectPoints) {
        this.collectPoints = collectPoints;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
