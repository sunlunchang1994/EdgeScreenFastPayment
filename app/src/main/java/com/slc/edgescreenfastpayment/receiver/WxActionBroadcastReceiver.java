package com.slc.edgescreenfastpayment.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.slc.edgescreenfastpayment.code.WxPayDelegate;
import com.slc.edgescreenfastpayment.utils.Constants;

/**
 * @author slc
 * @date 2019/12/6 10:44
 */
public class WxActionBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Constants.Wx.ACTION_WX.equals(intent.getAction())) {
            WxPayDelegate.distributeWxAction(context,intent);
        }
    }
}
