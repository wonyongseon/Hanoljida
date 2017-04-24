package project4_1.cookandroid.com.hanoljida;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


// SensorEventListener를 구현하며 Activity를 상속받고 있는 클래스

public class SEListener extends AppCompatActivity
{

// 맴버변수 (마지막과 현재값을 비교하여 변위를 계산하는 방식)


// 임계값 설정

// 매니저 객체
    public static Context mContext;
    public SensorManager m_senMng;
    public Sensor m_senAccelerometer;
    public SensorEventLx m_sensorEventLx;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));

        // 시스템 서비스에서 센서메니져 획득
        m_senMng = (SensorManager)getSystemService(SENSOR_SERVICE);
        // TYPE_ACCELEROMETER의 기본 센서객체를 획득
        m_senAccelerometer = m_senMng.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        m_sensorEventLx = new SensorEventLx(this);
        mContext = this;
    }

    // 흔들기가 시작되면 호출되는 함수
    public void onStart()
    {
        Log.i("kmsTest", "onStart()");
        super.onStart();
        if(m_senAccelerometer != null)
            m_senMng.registerListener(m_sensorEventLx, m_senAccelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    // 흔들기가 끝나면 호출되는 함수
    public void onStop()
    {
        Log.i("kmsTest", "onStop()");
        super.onStop();
        if(m_senMng != null)
            m_senMng.unregisterListener(m_sensorEventLx);
    }

}










