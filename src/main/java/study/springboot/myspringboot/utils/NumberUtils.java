package study.springboot.myspringboot.utils;

import java.text.DecimalFormat;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/2121:31
 */
public class NumberUtils {
    public static double keep2DecimalPlaces(Double value){
        DecimalFormat df   = new DecimalFormat("######0.00");
        return Double.valueOf(df.format(value));
    }
}
