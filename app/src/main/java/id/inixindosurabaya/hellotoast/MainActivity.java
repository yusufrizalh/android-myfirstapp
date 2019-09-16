package id.inixindosurabaya.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// nama class harus sama dg nama file
public class MainActivity extends AppCompatActivity {
    // 1. inisialisasi komponen dalam layout
    Button btn_toast, btn_count, btn_reset, btn_send;
    TextView txt_display;
    int myCount = 0;

    // method yg wajib ada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate Stage.", Toast.LENGTH_SHORT).show();

        // 2. kenali semua komponen dalam layout
        btn_toast = findViewById(R.id.btn_toast);
        btn_count = findViewById(R.id.btn_count);
        txt_display = findViewById(R.id.txt_display);
        btn_reset = findViewById(R.id.btn_reset);
        btn_send = findViewById(R.id.btn_send);

        // 3. membuat event handling untuk semua komponen
        // event handling untuk button toast
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // membuat perintah untuk toast
                Toast myToast = Toast.makeText(getApplicationContext(),
                        "Anda mengklik Toast!", Toast.LENGTH_LONG);
                myToast.setGravity(Gravity.CENTER, 0, 0);
                myToast.show();
            }
        });

        // event handling untuk button count
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // membuat perintah untuk count
                myCount++;
                txt_display.setText(Integer.toString(myCount));
            }
        });

        // event handling untuk button reset
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCount = 0;
                txt_display.setText(Integer.toString(myCount));
            }
        });

        // event handling button send
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // perintah untuk berpindah activity
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                // perintah ambil data yg mau dikirim
                String data = txt_display.getText().toString();
                // perintah meletakkan data kedalam myIntent
                myIntent.putExtra(Intent.EXTRA_TEXT, data);

                // kirim data melalui intent ke activity yg baru
                startActivity(myIntent);
            }
        });
    }

    // lifecycle onStart()
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart Stage.", Toast.LENGTH_SHORT).show();
    }

    // lifecycle onResume()
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume Stage.", Toast.LENGTH_SHORT).show();
    }

    // lifecycle onPause()
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause Stage.", Toast.LENGTH_SHORT).show();
    }

    // lifecycle onStop()
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop Stage.", Toast.LENGTH_SHORT).show();
    }

    // lifecycle onRestart()
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart Stage.", Toast.LENGTH_SHORT).show();
    }

    // lifecycle onDestroy()
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy Stage.", Toast.LENGTH_SHORT).show();
    }
}
