package com.mchgmail.pavel.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//ПЕРВЫЙ МЕТОД

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        but = (Button) findViewById(R.id.but);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = tv1.getText().toString();
                String b = tv2.getText().toString();
                tv1.setText(b);
                tv2.setText(a);
                tv1.setTextColor(getResources().getColor(R.color.tv2color));
                tv2.setTextColor(getResources().getColor(R.color.tv1color));
            }
        };
        but.setOnClickListener(ocl);
        tv1.setOnClickListener(ocl);
        tv2.setOnClickListener(ocl);


    }
}


// ..............................ВТОРОЙ МЕТОД
//public class MainActivity extends Activity implements View.OnClickListener {
//    TextView tv1, tv2;
//    Button but;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        tv1 = (TextView) findViewById(R.id.tv1);
//        tv2 = (TextView) findViewById(R.id.tv2);
//        but = (Button) findViewById(R.id.but);
//
//        but.setOnClickListener(this);
//        tv1.setOnClickListener(this);
//        tv2.setOnClickListener(this);
//
//
//
//        public void onClick(View v) {
//                String a = tv1.getText().toString();
//                String b = tv2.getText().toString();
//                tv1.setText(b);
//                tv2.setText(a);
//                tv1.setTextColor(getResources().getColor(R.color.tv2color));
//                tv2.setTextColor(getResources().getColor(R.color.tv1color));
//            }
//        };
//
//
//    }
//}

//..................................ТРЕТИЙ МЕТОД

//public void onClickStart(View v){
//        String a = tv1.getText().toString();
//        String b = tv2.getText().toString();
//        tv1.setText(b);
//        tv2.setText(a);
//        tv1.setTextColor(getResources().getColor(R.color.tv2color));
//        tv2.setTextColor(getResources().getColor(R.color.tv1color));
//        }
