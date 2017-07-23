package com.rae.cnblogs.sdk.db;

import com.activeandroid.ActiveAndroid;

import java.io.File;

/**
 * 本地数据库工厂
 * Created by ChenRui on 2017/2/19 01:09.
 */
public final class DbFactory {

    private static DbFactory sFactory;
    private DbCategory mCategory;
    private DbAdvert mAdvert;

    public static DbFactory getInstance() {
        if (sFactory == null) {
            synchronized (DbFactory.class) {
                if (sFactory == null) {
                    sFactory = new DbFactory();
                }
            }
        }

        return sFactory;
    }

    private DbFactory() {

    }

    private DbBlog mDbBlog;

    public DbBlog getBlog() {
        if (mDbBlog == null) {
            mDbBlog = new DbBlog();
        }
        return mDbBlog;
    }


    public DbCategory getCategory() {
        if (mCategory == null) {
            mCategory = new DbCategory();
        }
        return mCategory;
    }

    public DbAdvert getAdvert() {
        if (mAdvert == null) {
            mAdvert = new DbAdvert();
        }
        return mAdvert;
    }

    /**
     * 清除缓存数据
     */
    public void clearCache() {
        // 删除博客数据
        ActiveAndroid.clearCache();
        getBlog().clearCache();
        getAdvert().clearCache();
    }

    /**
     * 获取数据库缓存大小
     *
     * @return 文件长度
     */
    public long getCacheSize() {
        String path = ActiveAndroid.getDatabase().getPath();
        File file = new File(path);
        if (!file.exists() && !file.canRead()) {
            return 0;
        }
        return file.length();
    }
}
