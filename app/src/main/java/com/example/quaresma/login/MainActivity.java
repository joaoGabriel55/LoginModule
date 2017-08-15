package com.example.quaresma.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private static final String USER = "pref1";
    //private static final String PASS = "pref2";
    List<Pessoa> lista = new ArrayList<Pessoa>();
    //Context c = this;
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pessoa p = new Pessoa("Joao", "123");
        Pessoa p2 = new Pessoa("Dalton", "456");
        Pessoa p3 = new Pessoa("Leo", "159");

        lista.add(p);
        lista.add(p2);
        lista.add(p3);

        user = (EditText) findViewById(com.example.quaresma.login.R.id.username);
        pass = (EditText) findViewById(com.example.quaresma.login.R.id.password);

        SharedPreferences sp = getSharedPreferences("SP",Activity.MODE_PRIVATE);

        String nome = sp.getString("nome","");
        String senha = sp.getString("senha","");

        if(!nome.isEmpty() && !senha.isEmpty()){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }


    }

    public void entrar(View v) {
        SharedPreferences sp = getSharedPreferences("SP", Activity.MODE_PRIVATE);

        boolean entrou = false;

        for (Pessoa pessoa : lista) {
            if (user.getText().toString().equals(pessoa.getNome()) &&
                    pass.getText().toString().equals(pessoa.getSenha())){

                Intent intent = new Intent(this, LoginActivity.class);
                Bundle params = new Bundle();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("nome", pessoa.getNome());
                editor.putString("senha", pessoa.getSenha());
                intent.putExtras(params);
                editor.commit();

                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);

                entrou = true;
                Toast.makeText(MainActivity.this, "Validated !", Toast.LENGTH_SHORT).show();

                break;
            }
        }

        if (!entrou)
            Toast.makeText(MainActivity.this, "Invalidated !", Toast.LENGTH_SHORT).show();

    }
}
