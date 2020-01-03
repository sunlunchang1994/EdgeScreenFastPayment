package com.slc.edgescreenfastpayment.code;

import android.content.Context;
import android.content.Intent;

import com.slc.edgescreenfastpayment.R;
import com.slc.edgescreenfastpayment.utils.Constants;
import com.topjohnwu.superuser.Shell;

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
                openWxFastPayByCmd(Constants.Wx.CMD_SCAN);
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
        Shell.su(cmd).submit();
    }
}
