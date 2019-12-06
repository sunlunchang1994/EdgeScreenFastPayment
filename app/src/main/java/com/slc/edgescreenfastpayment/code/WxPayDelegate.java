package com.slc.edgescreenfastpayment.code;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.slc.edgescreenfastpayment.R;
import com.slc.edgescreenfastpayment.utils.Constants;

import eu.chainfire.libsuperuser.Shell;

/**
 * @author slc
 * @date 2019/12/6 11:18
 */
public class WxPayDelegate {
    /**
     * 派遣微信的事件
     *
     * @param intent
     */
    public static void distributeWxAction(Context context, Intent intent) {
        openWxScan(context);
    }

    /**
     * 打开微信扫一扫
     *
     * @param context
     */
    public static void openWxScan(Context context) {
        try {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, R.string.label_wechat_is_not_installed, Toast.LENGTH_LONG);
        }
    }
}
