package com.nx.commonlibrary.BaseView;

/**
 * @version 1.0ø
 * @类描述： 基础类IBaseView，所有View都需继承使用
 * @项目名称：NX
 * @类名称： IBaseView
 * @包名称： com.nx.commonlibrary.BaseActivity
 * @创建人：张强 boy
 * @创建时间： 17/8/4 23:59
 */
public interface IBaseView {


    /**
     * 显示Toast信息
     *
     * @param message
     */
    void showToastMessage(String message);

    /**
     * 显示正在加载对话框
     *
     * @param message
     */
    void showLoadingDialog(String message);

    /**
     * 取消加载对话框
     */
    void cancelLoadingDialog();

    /**
     * 显示进度
     *
     * @param bytesWritten
     * @param totalSize
     */
    void onProgress(int bytesWritten, int totalSize);


}
