package mch.pavel.dz3;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

public class MainActivitydz3 extends AppCompatActivity {

    Button btn;
    ImageView imgv;
    EditText edt;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitydz3);

        imgv = (ImageView) findViewById(R.id.imgv);
        btn = (Button) findViewById(R.id.btn);
        edt = (EditText) findViewById(R.id.edt);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String a = edt.getText().toString();
                progressBar.setVisibility(View.VISIBLE);


                Picasso.get()
                        .load(a)
                        .transform(new CircleTransform())
                        .into(imgv, new Callback() {
                            @Override
                            public void onSuccess() {
                                progressBar.setVisibility(View.GONE);

                                Toast.makeText(MainActivitydz3.this,"Картинка загружена", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Exception e) {

                                Toast.makeText(MainActivitydz3.this, "Ошибка при загрузке", Toast.LENGTH_LONG).show();

                            }
                        });



            }
               };
//            final ProgressBar progressBar = null;
//                if (imgv != null) {
//                progressBar.setVisibility(View.VISIBLE);
//        }


        btn.setOnClickListener(ocl);


    }


    public class CircleTransform implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size/2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }
}
