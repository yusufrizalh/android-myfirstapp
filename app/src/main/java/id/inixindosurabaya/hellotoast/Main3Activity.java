package id.inixindosurabaya.hellotoast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    EditText edit_username, edit_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // memunculkan icon back pressed
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d("My Log: ", "onCreate STage.");

        edit_username = findViewById(R.id.edit_username);
        edit_password = findViewById(R.id.edit_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("My Log: ", "Login processing initiated.");
                Intent myIntent = new Intent(Main3Activity.this, Main4Activity.class);
                Bundle myBundle = new Bundle();
                myBundle.putString("username", edit_username.getText().toString());
                myBundle.putString("password", edit_password.getText().toString());
                myIntent.putExtras(myBundle);
                startActivityForResult(myIntent, 1);
            }

            public void onActivityResult(int requestCode, int resultCode, Intent resIntent) {
                Log.d("My Log: ", "Started.");
                String result = resIntent.getStringExtra("result");
                Log.d("My Log: ", result);

                TextView txt_view = findViewById(R.id.txt_view);
                txt_view.setText(result);

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Message.....");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("My Log: ", "onStart Stage.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("My Log: ", "onRestart Stage.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("My Log: ", "onPause Stage.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("My Log: ", "onResume Stage.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("My Log: ", "onStop Stage.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("My Log: ", "onDestroy Stage.");
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.d("My Log: ", "onPostCreate Stage.");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("My Log: ", "onPostResume Stage.");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Main3Activity.this, Main2Activity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return true;
    }
}
