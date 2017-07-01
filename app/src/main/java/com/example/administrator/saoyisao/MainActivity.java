package com.example.administrator.saoyisao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;

public class MainActivity extends Activity {

    private Button bt_sao;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_sao = (Button) findViewById(R.id.bt_sao);
        tvResult = (TextView) findViewById(R.id.tvResult);

        bt_sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent = new Intent(MainActivity.this , com.xys.libzxing.zxing.activity.CaptureActivity.class);
                startActivity(intent);*/

                startActivityForResult(new Intent(MainActivity.this, CaptureActivity.class), 0);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String a = bundle.getString("result");
            tvResult.setText(a);

            Log.d("MainActivity", a);
        }
    }

}
