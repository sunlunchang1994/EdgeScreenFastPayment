package com.slc.edgescreenfastpayment.utils;

/**
 * Created by achang on 2019/3/1.
 */

public class Constants {


    public static class Alipay {
    }

    public static class Wx {
        public final static String KEY_PAY_TYPE = "pay_type";
        public final static String ACTION_WX = "com.slc.edgescreenfastpayment.WxAction";
        public static final String CMD_BASE_START_WX_ACTIVITY = "am start -n com.tencent.mm/";
        public static final String CMD_SCAN = CMD_BASE_START_WX_ACTIVITY + "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
        public static final String CMD_ALIPAY_PAYMENT = CMD_BASE_START_WX_ACTIVITY + "com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI";
        public static final String CMD_ALIPAY_COLLECT_MONEY = CMD_BASE_START_WX_ACTIVITY + "com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI";
    }
}
