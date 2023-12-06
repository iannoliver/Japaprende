package com.example.projetofirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TelaPrincipal extends AppCompatActivity {

    private TextView user_name, user_email, delete_account;
    private Button btDeslogar;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String IdUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        InicarComponentes();

        btDeslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(TelaPrincipal.this, FormLogin.class);
                startActivity(intent);
                finish();

            }
        });
        delete_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteUser(view);
                DirecionarLogin();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        IdUser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(IdUser);

        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null) {
                    user_name.setText(documentSnapshot.getString("name"));
                    user_email.setText(email);
                }
            }
        });

    }

    private void DirecionarLogin() {
        Intent intent = new Intent(TelaPrincipal.this, FormLogin.class);
        startActivity(intent);
    }

    private void DeleteUser(View view) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }

    private void InicarSnackBar(View view, String mensagem) {
        Snackbar snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_LONG);
        snackbar.setBackgroundTint(Color.WHITE);
        snackbar.setTextColor(Color.BLACK);
        snackbar.show();
    }

    private void InicarComponentes() {
        user_name = findViewById(R.id.textUserName);
        user_email = findViewById(R.id.textUserEmail);
        btDeslogar = findViewById(R.id.btDeslogar);
        delete_account = findViewById(R.id.text_excluir_cadastro);
    }

}