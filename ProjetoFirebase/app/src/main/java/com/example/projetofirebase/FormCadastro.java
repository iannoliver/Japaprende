package com.example.projetofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FormCadastro extends AppCompatActivity {

    private EditText edit_name, edit_email, edit_password;
    private Button bt_cadastrar;
    String[] mensagens = {"Preencha todos os campos", "Cadastro realizado com sucesso"};
    String IdUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        IniciarComponentes();

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edit_name.getText().toString();
                String email = edit_email.getText().toString();
                String password = edit_password.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() ) {
                    InicarSnackBar(view, mensagens[0]);
                } else {
                    CadastrarUsuario(view);
                }
            }
        });
    }
    private void CadastrarUsuario(View view) {

        String email = edit_email.getText().toString();
        String password = edit_password.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    SalvarDadosUsuario();
                    InicarSnackBar(view, mensagens[1]);
                    DirecionarLogin();
                } else {
                    String erro;
                    try {
                        throw task.getException();

                    }catch (FirebaseAuthWeakPasswordException e) {
                        erro = "Digite uma senha com no mínimo 6 caracteres";

                    } catch (FirebaseAuthUserCollisionException e) {
                        erro = "Esta conta já foi cadastrada!";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erro = "E-mail inválido";

                    }catch (Exception e) {
                        erro = "Erro ao cadastrar usuário";
                    }

                    InicarSnackBar(view, erro);

                }
            }
        });
    }


    private void DirecionarLogin() {
        Intent intent = new Intent(FormCadastro.this, FormLogin.class);
        startActivity(intent);
    }

    private void SalvarDadosUsuario() {
        String name = edit_name.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> users = new HashMap<>();
        users.put("name", name);
        IdUser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(IdUser);
        documentReference.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db", "Sucesso ao salvar os dados");
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("db_error", "Erro ao salvar os dados " + e.toString());
            }
        });
    }

    private void InicarSnackBar(View view, String mensagem) {
        Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_LONG);
        snackbar.setBackgroundTint(Color.WHITE);
        snackbar.setTextColor(Color.BLACK);
        snackbar.show();
    }

    private void IniciarComponentes() {
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        bt_cadastrar = findViewById(R.id.bt_cadastrar);
    }

}