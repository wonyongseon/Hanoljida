package project4_1.cookandroid.com.hanoljida;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by MyPC on 2017-04-19.
 */

public class SensorEventLx implements SensorEventListener {
    public long m_lLastTime;
    public float m_fSpeed;
    public float m_fCurX, m_fCurY, m_fCurZ;
    public float m_fLastX, m_fLastY, m_fLastZ;
    // 임계값 설정
    public static final int SHAKE_THRESHOLD = 2000;
    // 매니저 객체
//    private SensorManager m_senMng;
 //   private Sensor m_senAccelerometer;
    public Context myContext;

    public SensorEventLx(Context cx){
        myContext = cx;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            long lCurTime = System.currentTimeMillis();
            long lGabOfTime = lCurTime - m_lLastTime;

            // 0.1초보다 오래되면 다음을 수행 (100ms)
            if(lGabOfTime > 150)
            {
                m_lLastTime = lCurTime;
                m_fCurX = sensorEvent.values[SensorManager.DATA_X];
                m_fCurY = sensorEvent.values[SensorManager.DATA_Y];
                m_fCurZ = sensorEvent.values[SensorManager.DATA_Z];
                // 변위의 절대값에 / lGabOfTime * 10000 하여 스피드 계산
                m_fSpeed = Math.abs(m_fCurX + m_fCurY + m_fCurZ - m_fLastX - m_fLastY - m_fLastZ) / lGabOfTime * 10000;
                // 임계값보다 크게 움직였을 경우 다음을 수행
                if(m_fSpeed > SHAKE_THRESHOLD)
                {
                    Log.i("kmsTest", "Shake");
                    Toast.makeText(myContext, "흔들었엉~★", Toast.LENGTH_SHORT).show();
                }

                // 마지막 위치 저장
                // m_fLastX = event.values[0]; 그냥 배열의 0번 인덱스가 X값
                m_fLastX = sensorEvent.values[SensorManager.DATA_X];
                m_fLastY = sensorEvent.values[SensorManager.DATA_Y];
                m_fLastZ = sensorEvent.values[SensorManager.DATA_Z];
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
