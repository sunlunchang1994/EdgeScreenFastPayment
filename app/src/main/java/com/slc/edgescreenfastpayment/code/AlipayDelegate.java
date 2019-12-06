package com.slc.edgescreenfastpayment.code;

import android.content.Intent;
import android.net.Uri;

/**
 * @author slc
 * @date 2019/12/6 11:25
 */
public class AlipayDelegate {
    public static Intent getAlipayScan() {
        return new Intent("android.intent.action.VIEW",
                Uri.parse("alipayqr" + "://platformapi/startapp?saId=10000007"));
    }

    public static Intent getAlipayPayment() {
        return new Intent("android.intent.action.VIEW",
                Uri.parse("alipayqr://platformapi/startapp?saId=20000056"));
    }

    public static Intent getAlipayCollectMoney() {
        return new Intent("android.intent.action.VIEW",
                Uri.parse("alipayqr://platformapi/startapp?saId=20000123"));
    }
}
