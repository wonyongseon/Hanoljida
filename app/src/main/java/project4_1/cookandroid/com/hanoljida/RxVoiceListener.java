package project4_1.cookandroid.com.hanoljida;


import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * Created by 512 on 2016-11-08.
 */
public class RxVoiceListener extends PhoneStateListener {
    public Context myContext;
    public RxVoiceListener(Context cx){//래퍼런스 가속정보받아옴
        myContext = cx;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {


        super.onCallStateChanged(state, incomingNumber);//전화추적
        if (state == TelephonyManager.CALL_STATE_RINGING){//전화가 와서 울릴때 표시
        }
        else if (state == TelephonyManager.CALL_STATE_OFFHOOK){//전화받앗다
            ((SEListener)SEListener.mContext).onStart();
        }
        else if (state == TelephonyManager.CALL_STATE_IDLE){
            ((SEListener)SEListener.mContext).onStop();
        }
    }
}
