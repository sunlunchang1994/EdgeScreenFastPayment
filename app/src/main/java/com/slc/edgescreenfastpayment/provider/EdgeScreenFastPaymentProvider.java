package com.slc.edgescreenfastpayment.provider;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.samsung.android.sdk.look.cocktailbar.SlookCocktailManager;
import com.samsung.android.sdk.look.cocktailbar.SlookCocktailProvider;
import com.slc.edgescreenfastpayment.R;
import com.slc.edgescreenfastpayment.code.AlipayDelegate;
import com.slc.edgescreenfastpayment.receiver.WxActionBroadcastReceiver;
import com.slc.edgescreenfastpayment.utils.Constants;

/**
 * Created by achang on 2019/3/1.
 */

public class EdgeScreenFastPaymentProvider extends SlookCocktailProvider {
    @Override
    public void onUpdate(Context context, SlookCocktailManager cocktailManager, int[] cocktailIds) {
        super.onUpdate(context, cocktailManager, cocktailIds);
        panelUpdate(context, cocktailManager, cocktailIds);
    }

    private void panelUpdate(Context context, SlookCocktailManager slookCocktailManager, int[] iArr) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.shortcut_edge_screen_fast_payment);
        setPendingIntentByActivity(context, remoteViews);
        if (iArr != null) {
            for (int updateCocktail : iArr) {
                slookCocktailManager.updateCocktail(updateCocktail, remoteViews);
            }
        }
    }

    private void setPendingIntentByActivity(Context context, RemoteViews remoteViews) {
        setPendingIntentByBroadcast(context, R.id.wx_scan, remoteViews);
        setPendingIntentByActivity(context, R.id.alipay_scan, AlipayDelegate.getAlipayScan(), remoteViews);
        setPendingIntentByActivity(context, R.id.alipay_payment_code, AlipayDelegate.getAlipayPayment(), remoteViews);
        setPendingIntentByActivity(context, R.id.alipay_collect_money_code, AlipayDelegate.getAlipayCollectMoney(), remoteViews);
    }

    private void setPendingIntentByActivity(Context context, int i, Intent intent, RemoteViews remoteViews) {
        remoteViews.setOnClickPendingIntent(i, PendingIntent.getActivity(context, i, intent,
                PendingIntent.FLAG_UPDATE_CURRENT));
    }

    private void setPendingIntentByBroadcast(Context context, int i, RemoteViews remoteViews) {
        Intent intent = new Intent(context, WxActionBroadcastReceiver.class);
        intent.setAction(Constants.Wx.ACTION_WX);
        intent.putExtra(Constants.Wx.KEY_PAY_TYPE, i);
        remoteViews.setOnClickPendingIntent(i, PendingIntent.getBroadcast(context, i, intent, PendingIntent.FLAG_UPDATE_CURRENT));
    }
    /*
    private void setPendingIntentByService(Context context, int i, RemoteViews remoteViews) {
        Intent intent = new Intent(context, WxActionService.class);
        intent.putExtra(Constants.KEY_PAY_TYPE, i);
        remoteViews.setOnClickPendingIntent(i, PendingIntent.getService(context, i, intent, PendingIntent.FLAG_UPDATE_CURRENT));
    }*/
}
