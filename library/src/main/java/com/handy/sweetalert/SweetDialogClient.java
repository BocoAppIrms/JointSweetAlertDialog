package com.handy.sweetalert;

import android.app.Activity;
import android.util.Log;

/**
 * <pre>
 *  author : LiuJie
 *  desc : 弹出框委托管理类
 *         在Activity的onCreate方法中进行连接
 *         在Activiy的onPause方法中断开连接
 *  blog : https://github.com/liujie045
 *  createtime : 2017/5/11 11:28
 *  updatetime : 2017/5/11 11:28
 * </pre>
 */
public class SweetDialogClient {
    public static Activity activity = null;

    public static void connect(Activity aty) {
        activity = aty;
    }

    public static void disconnect() {
        if (activity != null && activity.isFinishing()) {
            SweetDialogUtil.getInstance().finishAll();
            activity = null;
        } else {
            Log.e("SweetDialog", "SweetDialogClient未连接，请在Activity的onCreate中执行SweetDialogClient.connect(activity);");
        }
    }
}
