package id.inixindosurabaya.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    TextView txt_view;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        // memunculkan icon back pressed
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_view = findViewById(R.id.txt_view);
        btn_ok = findViewById(R.id.btn_ok);
        Log.d("My Log: ", "Login onCreate Stage.");

        Bundle myBundle = getIntent().getExtras();
        txt_view.setText("Username: " + myBundle.getString("username") +
                "\n and Password: " + myBundle.getString("password"));
        Intent myIntent = new Intent();
        myIntent.putExtra("result", "Success.");
        setResult(1, myIntent);

        // event handling button ok
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main4Activity.this, Main3Activity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Main4Activity.this, Main3Activity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}
