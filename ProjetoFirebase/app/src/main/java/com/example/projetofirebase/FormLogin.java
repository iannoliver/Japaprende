package com.example.projetofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class FormLogin extends AppCompatActivity {

    private EditText edit_email, edit_password;
    private Button bt_entrar;
    private ProgressBar progressBar;
    private TextView text_tela_cadastro;
    String[] mensagens = {"Preencha todos os campos"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        IniciarComponentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this, FormCadastro.class);
                startActivity(intent);
            }
        });

        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edit_email.getText().toString();
                String password = edit_password.getText().toString();

                if(email.isEmpty() || password.isEmpty()) {
                    InicarSnackBar(view, mensagens[0]);
                } else {
                    fecharTeclado();
                    AutenticarUsuario(view);
                }
            }
        });

    }

    private void AutenticarUsuario(View view) {
        String email = edit_email.getText().toString();
        String password = edit_password.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    progressBar.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TelaPrincipal();
                        }
                    }, 3000);
                } else {
                    String erro;
                    try {
                        throw task.getException();

                    }catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Digite uma senha com no mínimo 6 caracteres";

                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "E-mail ou senha inválidos";

                    } catch (FirebaseAuthInvalidUserException e) {
                        erro = "E-mail não cadastrado";

                    }catch (Exception e) {
                        erro = "Erro ao conectar usuário";
                    }
                    InicarSnackBar(view, erro);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            TelaPrincipal();
        }
    }

    private void fecharTeclado() {
        View view = this.getCurrentFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void TelaPrincipal() {
        Intent intent = new Intent(FormLogin.this, TelaPrincipal.class);
        startActivity(intent);
        finish();
    }

    private void InicarSnackBar(View view, String mensagem) {
        Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_LONG);
        snackbar.setBackgroundTint(Color.WHITE);
        snackbar.setTextColor(Color.BLACK);
        snackbar.show();
    }

    private void IniciarComponentes() {
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        bt_entrar = findViewById(R.id.bt_entrar);
        progressBar = findViewById(R.id.progressBar);
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
    }

}