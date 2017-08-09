package com.nx.commonlibrary.Utils;

import android.app.Dialog;
import android.widget.Toast;

import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

/**
 * Created by zhnagqiang on 15/3/30.
 * 字符串操作工具类
 */

public class StringUtil {

    private static final String TAG = "SDK_Sample.Util";

    private static Dialog mProgressDialog;
    private static Toast mToast;

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str.trim()) || "null".equals(str));
    }

    /**
     * 判定字符串是否有空
     * @param str
     * @return
     */
    public static boolean isEmpty(String... str) {
        for (String s : str) {
            boolean emp = (s == null || "".equals(s.trim()) || "null".equals(s));
            if (emp) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判定List集合是否有空元素
     * @param list
     * @return
     */
    public static boolean isEmpty(List<?> list) {
        return (list == null || list.isEmpty());
    }

    /**
     * 判定Map集合是否有空元素
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 判断Object对象长度
     * @param object
     * @return
     */
    public static Long toLong(Object object) {
        if (object == null) {
            return 0L;
        }
        if (object instanceof Long) {
            return (Long) object;
        }
        try {
            return Long.valueOf(String.valueOf(object));
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     * 将Object对象变为Integer对象
     * @param object
     * @return
     */
    public static Integer toInteger(Object object) {
        if (object == null) {
            return 0;
        }
        if (object instanceof Integer) {
            return (Integer) object;
        }
        try {
            return Integer.valueOf(toString(object));
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 将Object对象变为String对象
     * @param object
     * @return
     */
    public static String toString(Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof String) {
            return object.toString();
        }

        /**if(object instanceof  Long) {
         return ((Integer)object )+"";
         }
         if(object instanceof  Integer) {
         return ((Integer)object )+"";
         }**/
        if (object instanceof Double || object instanceof Float) {
            return ((Double) object).longValue() + "";
        }
        return String.valueOf(object);
    }

    /**
     * MD5加密
     * @param str
     * @return
     */
    public static String MD5(String str) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }



    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /*
     * 16进制数字字符集
     */
    private static String hexString = "0123456789ABCDEF";

    /*
     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
     */
    public static String toHexString(String str) {
        // 根据默认编码获取字节数组
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }

    // 转换十六进制编码为字符串
    public static String hexToString(String s) {
        if ("0x".equals(s.substring(0, 2))) {
            s = s.substring(2);
        }
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            s = new String(baKeyword, "utf-8");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * 匹配正则表达式
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static String stringFilter(String str) throws PatternSyntaxException {
        String regEx = "[^\\u0020-\\u007E\\u00A0-\\u00BE\\u2E80-\\uA4CF\\uF900-\\uFAFF\\uFE30-\\uFE4F\\uFF00-\\uFFEF\\u0080-\\u009F\\u2000-\\u201f\\r\\n]";
        return str.replaceAll(regEx,"");
    }
}
