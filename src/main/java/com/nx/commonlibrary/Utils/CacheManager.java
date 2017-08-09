package com.nx.commonlibrary.Utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * 本应用缓存管理器
 * Created by Jian Chang on 2016-04-29.
 */
public final class CacheManager {

    /**
     * 清除本应用内部缓存
     */
    public static void cleanInternalCache(Context context) {
        deleteDirectory(context.getCacheDir());
    }

    /**
     * 清除本应用外部缓存
     */
    public static void cleanExternalCache(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            deleteDirectory(context.getExternalCacheDir());
    }

    /**
     * * 删除目录
     */
    private static void deleteDirectory(File directory) {
        if (directory == null || !directory.exists())
            return;
        for (File file : directory.listFiles()) {
            if (file.isDirectory() && file.listFiles().length > 0)
                deleteDirectory(file);
            else
                //noinspection ResultOfMethodCallIgnored
                file.delete();
        }
    }

    /**
     * 获取文件大小
     */
    private static long getFileSize(File file) {
        long size = 0;
        if (file.isDirectory())
            for (File subFile : file.listFiles())
                size += getFileSize(subFile);
        else
            return file.length();
        return size;
    }

    /**
     * 获取本应用内部缓存大小
     */
    public static long getInternalCacheSize(Context context) {
        return getFileSize(context.getCacheDir());
    }

    /**
     * 获取本应用外部缓存大小
     */
    public static long getExternalCacheSize(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            return getFileSize(context.getExternalCacheDir());
        return 0;
    }

}
