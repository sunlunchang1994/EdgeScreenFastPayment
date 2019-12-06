package com.slc.edgescreenfastpayment.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.slc.edgescreenfastpayment.code.WxPayDelegate;

/**
 * Created by achang on 2019/3/1.
 */

public class WxActionService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        WxPayDelegate.distributeWxAction(this,intent);
        return super.onStartCommand(intent, flags, startId);
    }

}
