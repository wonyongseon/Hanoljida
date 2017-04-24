package project4_1.cookandroid.com.hanoljida;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TxVoiceReceiver extends BroadcastReceiver {
    public String sTxNumber;
    public TxVoiceReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)){
            sTxNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        }
        else if (intent.getAction().equals(Intent.ACTION_CALL_BUTTON)){
            sTxNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        }
    }
}
