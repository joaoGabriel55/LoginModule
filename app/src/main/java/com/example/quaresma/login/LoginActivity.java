package com.example.quaresma.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private static final String tag = "log";
    private static final String PREF = "pref";
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences settings = getSharedPreferences(PREF, MODE_PRIVATE);

        //Bundle params = getIntent().getExtras();
        String nome = settings.getString("nome", "");

        text = (TextView) findViewById(R.id.textView3);
        text.setText(nome + ", seja bem vindo.");
    }

    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("nome", text.getText().toString());
        // Commit the edits!
        editor.commit();
    }

    public void clickLogout(View v){

        SharedPreferences settings = getSharedPreferences(PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("nome", "");
        // Commit the edits!
        editor.clear();
        finish();

        Log.i(tag, "LOOOOOOOOOOOL");

    }
}
