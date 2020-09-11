package com.yutaka.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = reference.child("usuarios");
        Usuario usuario = new Usuario();
        usuario.setNome("Yutaka");
        usuario.setSobrenome("Yasuda");
        usuario.setIdade(20);

        usuarios.push().setValue(usuario);

        /*
        // Deslogar usuário
        //auth.signOut();

        //Logar usuário
        auth.signInWithEmailAndPassword("nami@gmail.com", "123456")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Log.i("SignInr", "Sucesso ao logar usuário");
                        } else {
                            Log.i("SignIn", "Erro ao logar usuário");
                        }
                    }
                });
        */

       /* //Verifica usuario logado
        if(auth.getCurrentUser() != null) {
            Log.i("CreateUser", "Usuário logado");
        } else {
            Log.i("CreateUser", "Usuário não logado");
        } */

        /*// Cadastro de Usuário
        auth.createUserWithEmailAndPassword("nami@gmail.com", "123456")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Log.i("CreateUser", "Sucesso ao cadastrar o usuário");
                        } else {
                            Log.i("CreateUser", "Erro ao cadastrar o usuário");
                        }
                    }
                }); */



        /*
        DatabaseReference usuarios = reference.child("usuarios");
        DatabaseReference produtos = reference.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */
        /* Salvar dados no FIREBASE
        Usuario usuario = new Usuario();
        usuario.setNome("Yutaka");
        usuario.setSobrenome("Yasuda");
        usuario.setIdade(20);

        Produto produto = new Produto();
        produto.setDescricao("Nintendo Switch");
        produto.setMarca("Nintendo");
        produto.setPreco(1600);

        produtos.child("003").setValue(produto);

        //usuarios.child("002").setValue(usuario);
        */



    }
}