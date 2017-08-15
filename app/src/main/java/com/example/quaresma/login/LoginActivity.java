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
    public static final String  NOME = "NOME";
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        text = (TextView) findViewById(R.id.textView3);

        SharedPreferences settings = getSharedPreferences(PREF, MODE_PRIVATE);

        //Bundle params = getIntent().getExtras();
        String nome = settings.getString("nome", "");

        text.setText(nome);

        Log.i(tag,"onCreate");
    }

   /* @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(NOME, text.getText().toString());
        // Commit the edits!
        editor.commit();

        Log.i(tag,"onStop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putString(NOME, text.getText().toString());

        Log.i(tag,"onSave");

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        text.setText(savedInstanceState.getString(NOME));

        Log.i(tag,"onRestore");
    }*/

    public void clickLogout(View v){

        SharedPreferences settings = getSharedPreferences(PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("nome", "");
        // Commit the edits!
        editor.clear();
        finish();

        Log.i(tag, "clickLogout");

    }
}
