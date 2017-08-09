/**
 *
 */
package com.nx.commonlibrary.Utils;

import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * @author mhh
 */
public class PhoneInfo {
    private Context context = null;
    /*
     * public void test(){ TelephonyManager tManager = (TelephonyManager)
	 * this.getSystemService(TELEPHONY_SERVICE); int number =
	 * 
	 * SIMCardInfo siminfo = new SIMCardInfo(this);
	 * siminfo.getNativePhoneNumber()); }
	 */
    /**
     * TelephonyManager提供设备上获取通讯服务信息的入口。 应用程序可以使用这个类方法确定的电信服务商和国家 以及某些类型的用户访问信息。
     * 应用程序也可以注册一个监听器到电话收状态的变化。不需要直接实例化这个类
     * 使用Context.getSystemService(Context.TELEPHONY_SERVICE)来获取这个类的实例。
     */
    private TelephonyManager telephonyManager;
    /**
     * 国际移动用户识别码
     */
    private String IMSI;

    public PhoneInfo(Context context) {
        this.context = context;
        telephonyManager = (TelephonyManager) this.context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    /**
     * Role:获取当前设置的电话号码 <BR>
     * Date:2012-3-12 <BR>
     *
     * @author CODYY)peijiangping
     */
    public String getNativePhoneNumber() {
        String NativePhoneNumber = null;
        NativePhoneNumber = telephonyManager.getLine1Number();
        return NativePhoneNumber;
    }

    /**
     * Role:Telecom service providers获取手机服务商信息 <BR>
     * 需要加入权限<uses-permission
     * android:name="android.permission.READ_PHONE_STATE"/> <BR>
     * Date:2012-3-12 <BR>
     *
     * @author CODYY)peijiangping
     */
    public String getProvidersName() {
        String ProvidersName = null;
        // 返回唯一的用户ID;就是这张卡的编号神马的
        IMSI = telephonyManager.getSubscriberId();
        // IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
        if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
            ProvidersName = "中国移动";
        } else if (IMSI.startsWith("46001")) {
            ProvidersName = "中国联通";
        } else if (IMSI.startsWith("46003")) {
            ProvidersName = "中国电信";
        }
        return ProvidersName;
    }

    /**
     * 获取手机串号
     *
     * @return
     */
    public String getPhoineSN() {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceID = null;
        //获取设备号
        try {
            deviceID = telephonyManager.getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取设备序号
        if (StringUtil.isEmpty(deviceID)) {
            try {
                deviceID = telephonyManager.getSimSerialNumber();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //网卡ID
        if (StringUtil.isEmpty(deviceID)) {
            try {
                WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo info = wifi.getConnectionInfo();
                deviceID = info.getMacAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return deviceID;
    }


    /**
     * 获取声音大小
     *
     * @return
     */
    public int getBrightness() {
        int brightness = -1;
        try {
            brightness = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException ex) {
            //new Exception(ex.toString());
        }

        return brightness;
    }

    /**
     * 获取背光
     *
     * @return
     */
    public int getVolume() {
        int volume = -1;
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        return volume;
    }

    /**
     * 获取网络类型
     *
     * @return
     */
    public String getNetworkType() {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = connManager.getActiveNetworkInfo();
        String networkType = "";
        if (networkinfo != null) {
            networkType = networkinfo.getTypeName();
        }

        return networkType;
    }

}
