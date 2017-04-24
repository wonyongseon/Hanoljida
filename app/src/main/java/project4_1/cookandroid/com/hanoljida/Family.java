package project4_1.cookandroid.com.hanoljida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by D507-29 on 2017-04-15.
 */

public class Family extends AppCompatActivity {

    Button Quest,Sch,Call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family);

        Quest = (Button)findViewById(R.id.Quest);
        Sch = (Button)findViewById(R.id.Sch);
        Call = (Button)findViewById(R.id.Call);

        Quest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Family.this,Quest.class);
                startActivity(intent);
            }
        });

        Sch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Family.this,Schedule.class);
                startActivity(intent);
            }
        });
        Call.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });



    }

}
