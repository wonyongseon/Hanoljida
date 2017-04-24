package project4_1.cookandroid.com.hanoljida;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class TxVoiceService extends Service {
    public TxVoiceReceiver txVoiceReceiver;
    public TxVoiceService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int nResult = super.onStartCommand(intent, flags, startId);
        txVoiceReceiver = new TxVoiceReceiver();
        IntentFilter ifVoice = new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL);
        registerReceiver(txVoiceReceiver,ifVoice);
        return nResult;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
