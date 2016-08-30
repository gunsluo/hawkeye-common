package cn.com.gome.hawkeye.common.demo.common;

import java.util.Random;

/**
 * @author jerrylou
 * @params
 * @since 2016/8/30 0030
 */
public class Utils {
    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
