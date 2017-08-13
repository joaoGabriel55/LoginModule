package com.example.quaresma.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String USER = "pref1";
    private static final String PASS = "pref2";
    List<Pessoa> lista = new ArrayList<Pessoa>();
    Context c = this;
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

        Button btnLogin = (Button) findViewById(com.example.quaresma.login.R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                boolean entrou = false;

                for (Pessoa pessoa : lista) {
                    if (user.getText().toString().equals(pessoa.getNome()) &&
                            pass.getText().toString().equals(pessoa.getSenha())){

                        Intent intent = new Intent(c, LoginActivity.class);
                        Bundle params = new Bundle();
                        params.putString("nome", pessoa.getNome());
                        params.putString("senha", pessoa.getSenha());
                        intent.putExtras(params);
                        startActivity(intent);

                        entrou = true;
                        Toast.makeText(MainActivity.this, "Validated !", Toast.LENGTH_SHORT).show();

                        break;
                    }
                }

                if (!entrou)
                    Toast.makeText(MainActivity.this, "Invalidated !", Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
