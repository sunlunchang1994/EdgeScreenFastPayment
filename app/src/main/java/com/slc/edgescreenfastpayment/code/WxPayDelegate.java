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
        switch (intent.getIntExtra(Constants.Wx.KEY_PAY_TYPE, 0)) {
            case R.id.wx_scan:
                if (Shell.SU.available()) {
                    openWxFastPayByCmd(Constants.Wx.CMD_SCAN);
                }else{
                    openWxScan(context);
                }
                break;
            case R.id.wx_payment_code:
                openWxFastPayByCmd(Constants.Wx.CMD_ALIPAY_PAYMENT);
                break;
            case R.id.wx_collect_money_code:
                openWxFastPayByCmd(Constants.Wx.CMD_ALIPAY_COLLECT_MONEY);
                break;
        }
    }

    /**
     * 打开微信相关快捷支付
     *
     * @param cmd
     */
    public static void openWxFastPayByCmd(String cmd) {
        try {
            Shell.Pool.SU.run(cmd);
        } catch (Shell.ShellDiedException e) {
            //e.printStackTrace();
        }
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
