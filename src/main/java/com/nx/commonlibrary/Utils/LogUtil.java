package com.nx.commonlibrary.Utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志记录
 */
public class LogUtil {
    /**
     * 打印日志的开关
     */
    private static boolean isLogOn = true;
    private static String TAG_NX = "NXAPP:";


    /**
     * 打印Debug日志 使用的方式举例:Loger.d("Info:","I am a testLog","Detail:"+"this is detail message")
     *
     * @param msgs 需要打印的日志
     */
    public static void d(Object... msgs) {
        if (isLogOn) {
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            if (stack != null && stack.length > 0) {
                int index;
                if (stack.length > 3) {
                    index = 3;
                } else {
                    index = stack.length - 1;
                }
                StackTraceElement elment = stack[index];
                String clsName = elment.getClassName();
                String methodName = elment.getMethodName();
                Log.d(TAG_NX + clsName, methodName + "_DetailMessage\n" + buildMsg(msgs));
            }

        }
    }

    /**
     * 打印错误日志 使用的方式举例:Loger.e("Info:","I am a testLog","Detail:"+"this is detail message")
     *
     * @param msgs 需要打印的日志
     */
    public static void e(Object... msgs) {
        if (isLogOn) {
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            if (stack != null && stack.length > 0) {
                int index;
                if (stack.length > 3) {
                    index = 3;
                } else {
                    index = stack.length - 1;
                }
                StackTraceElement elment = stack[index];
                String clsName = elment.getClassName();
                String methodName = elment.getMethodName();
                Log.e(TAG_NX + clsName, methodName + "_DetailMessage\n" + buildMsg(msgs));
            }

        }
    }

    /**
     * 打印Info日志 使用的方式举例:Loger.i("Info:","I am a testLog","Detail:"+"this is detail message")
     *
     * @param msgs 需要打印的日志
     */
    public static void i(Object... msgs) {
        if (isLogOn) {
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            if (stack != null && stack.length > 0) {
                int index;
                if (stack.length > 3) {
                    index = 3;
                } else {
                    index = stack.length - 1;
                }
                StackTraceElement elment = stack[index];
                String clsName = elment.getClassName();
                String methodName = elment.getMethodName();
                Log.i(TAG_NX + clsName, methodName + "_DetailMessage\n" + buildMsg(msgs));
            }

        }
    }

    /**
     * 打印警告日志 使用的方式举例:Loger.w("Info:","I am a testLog","Detail:"+"this is detail message")
     *
     * @param msgs 需要打印的日志
     */
    public static void w(Object... msgs) {
        if (isLogOn) {
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            if (stack != null && stack.length > 0) {
                int index;
                if (stack.length > 3) {
                    index = 3;
                } else {
                    index = stack.length - 1;
                }
                StackTraceElement elment = stack[index];
                String clsName = elment.getClassName();
                String methodName = elment.getMethodName();
                Log.w(TAG_NX + clsName, methodName + "_DetailMessage\n" + buildMsg(msgs));
            }

        }
    }


    /**
     * 详细的log日志打印
     *
     * @param tag 打印日志的唯一表示，一般是类名或者方法名
     * @param msg 准备输出的日志信息
     * @param tr  An exception to log
     */
    public static void v(String tag, String msg, Throwable tr) {
        if (isLogOn)
            Log.v(tag, TAG_NX + msg, tr);
    }


    /**
     * 打印Debug 日志信息
     *
     * @param tag 打印日志的唯一表示，一般是类名或者方法名
     * @param msg 准备输出的日志信息
     * @param tr  An exception to log
     */
    public static void d(String tag, String msg, Throwable tr) {
        if (isLogOn)
            Log.d(tag, TAG_NX + msg, tr);
    }


    /**
     * 打印Info 日志信息
     *
     * @param tag 打印日志的唯一表示，一般是类名或者方法名
     * @param msg 准备输出的日志信息
     * @param tr  An exception to log
     */
    public static void i(String tag, String msg, Throwable tr) {
        if (isLogOn)
            Log.i(tag, TAG_NX + msg, tr);
    }


    /**
     * 打印warn（警告）日志信息
     *
     * @param tag 打印日志的唯一表示，一般是类名或者方法名
     * @param msg 准备输出的日志信息
     * @param tr  an excption to log
     */
    public static void w(String tag, String msg, Throwable tr) {
        if (isLogOn)
            Log.w(tag, TAG_NX + msg, tr);
    }


    /**
     * 打印Error(错误)日志信息
     *
     * @param tag 打印日志的唯一表示，一般是类名或者方法名
     * @param msg 准备输出的日志信息
     * @param tr  an excption to log
     */
    public static void e(String tag, String msg, Throwable tr) {
        if (isLogOn)
            Log.e(tag, TAG_NX + msg, tr);
    }


    /**
     * 向手机写文件
     *
     * @param buffer   需要写入的内容的byte[]
     * @param folder   文件目录
     * @param fileName 文件名
     * @return 写入是否成功
     * @throws IOException
     */
    @SuppressWarnings("resource")
    private static boolean writeFile(byte[] buffer, String folder,
                                     String fileName) throws IOException {
        boolean writeSucc = false;

        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

        if (sdCardExist) {
            String folderPath = Environment.getExternalStorageDirectory()
                    + File.separator + folder + File.separator;
            File fileDir = new File(folderPath);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            File file = new File(folderPath + fileName);
            FileOutputStream out = new FileOutputStream(file, true);
            out.write(buffer);
            out.flush();
        } else {
            writeSucc = false;
        }
        return writeSucc;
    }

    /**
     * @return 返回当前时间
     */
    private static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date date = new Date(System.currentTimeMillis());

        return df.format(date);
    }

    /**
     * 将日志写入指定的文件中,建议在独立线程中使用。
     *
     * @param entity      封装log信息的对象
     * @param dir         日志存放的目录
     * @param logFileName 将要写入日志的文件名称
     */
    @SuppressLint("SimpleDateFormat")
    public static void log2file(LogEntity entity, String dir, String logFileName) {
        if (LogUtil.isLogOn) {
            try {
                writeFile(
                        (getCurrentTime() + "\t" + "|Level:"
                                + entity.getLevel() + "|\tmessage:"
                                + entity.getMsg() + "\n").getBytes("UTF-8"),
                        dir, logFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * s是否打印日志
     *
     * @return
     */
    public static boolean isLogOn() {
        return isLogOn;
    }

    /**
     * 设置Log的开关
     *
     * @param isLogOn
     */
    public static void setLogOn(boolean isLogOn) {
        LogUtil.isLogOn = isLogOn;
    }

    public static void setLogTag(String tag) {
        if (StringUtil.isEmpty(tag)) {
            return;
        }
        TAG_NX = tag;

    }

    private static String buildMsg(Object... msgs) {
        StringBuilder sb = new StringBuilder();
        for (Object msg : msgs) {
            sb.append(msg);
            sb.append("\n");
        }
        return sb.toString();
    }
}
