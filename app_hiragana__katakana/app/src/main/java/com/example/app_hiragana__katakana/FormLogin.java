package com.example.app_hiragana__katakana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormLogin extends AppCompatActivity {

    private Button bt_tela_cadastro, bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);
        IniciarComponentes();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this, activity_form_principal.class);
                startActivity(intent);
            }
        });

        bt_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this, FormCadastro.class);
                startActivity(intent);
            }
        });

    }



    private void IniciarComponentes() {
        bt_tela_cadastro = findViewById(R.id.bt_tela_cadastro);
        bt_login = findViewById(R.id.bt_Login);
    }

}