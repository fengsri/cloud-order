package com.feng.order.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Author fengwen
 * @Date 2019/10/2 20:42
 * @Version V1.0
 */
public class RandomNumberUtil {

    public static String getOrderNumber(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        StringBuffer stringBuilder = new StringBuffer();
        stringBuilder.append(calendar.get(Calendar.YEAR)+calendar.get(Calendar.MONTH)+calendar.get(Calendar.DAY_OF_WEEK));
        stringBuilder.append(calendar.get(Calendar.HOUR)+calendar.get(Calendar.MINUTE)+calendar.get(Calendar.SECOND));
        stringBuilder.append(System.currentTimeMillis());
        int t = (int)((Math.random())*1000000);
        stringBuilder.append(t);
        return stringBuilder.toString();
    }


}
