package project4_1.cookandroid.com.hanoljida;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class RxVoiceService extends Service {


    public RxVoiceListener rxVoiceListener;
    public RxVoiceService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int nResult = super.onStartCommand(intent,flags,startId);

        rxVoiceListener = new RxVoiceListener(this);
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(rxVoiceListener,PhoneStateListener.LISTEN_CALL_STATE);

        return nResult;
    }

    @Override
    public void onDestroy() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(rxVoiceListener,PhoneStateListener.LISTEN_NONE);
        super.onDestroy();
    }
}

