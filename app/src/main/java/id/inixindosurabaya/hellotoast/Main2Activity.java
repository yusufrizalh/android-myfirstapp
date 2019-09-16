package id.inixindosurabaya.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    // 1. inisialisasi komponen
    TextView txt_display_2;
    Button btn_back, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // memunculkan icon back pressed
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 2. mengenali komponen
        txt_display_2 =findViewById(R.id.txt_display_2);
        btn_back = findViewById(R.id.btn_back);
        btn_next = findViewById(R.id.btn_next);

        // 3. event handling
        // event handling untuk menangkap data dari layout 1
        Intent myIntent = getIntent();
        String displayData = myIntent.getStringExtra(Intent.EXTRA_TEXT);

        // tampilkan dalam text view
        txt_display_2.setText(displayData);

        // event handling button back
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // perintah untuk kembali ke layout 1
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
                // kembali dan reset nilai menjadi 0
                finish();
            }
        });

        // event handling button next
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });
    }

    // membuat icon back pressed
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Main2Activity.this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}
