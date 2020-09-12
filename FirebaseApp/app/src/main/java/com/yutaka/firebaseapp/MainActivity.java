package com.yutaka.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

   /* private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth auth = FirebaseAuth.getInstance(); */

   private ImageView imageFoto;
   private Button buttonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonUpload = findViewById(R.id.buttonUpload);
        imageFoto = findViewById(R.id.imageFoto);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            // Configura imagem para ser salva em memória
                imageFoto.setDrawingCacheEnabled(true);
                imageFoto.buildDrawingCache();

                //Recupera um BITMAP da imagem
                Bitmap bitmap = imageFoto.getDrawingCache();

                // Comprimir bitmap para o formato png/jpeg
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos);

                // converte o baos para pixel brutos em uma matriz de bytes
                // dados da imagem
                byte[] dadosImagem = baos.toByteArray();

                // define nós para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference imagens = storageReference.child("imagens");
                StorageReference imagemRef = imagens.child("6b98b211-77ef-464c-a929-5eb9e8afd1ce.jpeg");

                Glide.with(MainActivity.this).load(imagemRef).into(imageFoto);

               /* imagemRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Erro ao deletar o arquivo", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,"Sucesso ao deletar o arquivo", Toast.LENGTH_SHORT).show();
                    }
                }); */

                /*
                // nome da imagem
                String nomeArquivo = UUID.randomUUID().toString();
                final StorageReference imagemRef = imagens.child(nomeArquivo + ".jpeg");

                // Retorna objeto que irá controlar o Upload
                UploadTask uploadTask = imagemRef.putBytes(dadosImagem);

                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Upload da imagem falhou: " + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                uploadTask.addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imagemRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                Uri url = task.getResult();
                                Toast.makeText(MainActivity.this, "Sucesso ao fazer o upload da imagem: " + url.toString(), Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                });*/

            }
        });




      //  DatabaseReference usuarios = reference.child("usuarios");
     /*
       // DatabaseReference usuarioPesquisa = usuarios.child("-MH2H-vS32oUrTdCVKYS");
       // Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Elaiza");
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);

        // maior ou igual
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(24);

        // menor ou igual
        //Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(22);

        // entre dois valores
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(20).endAt(30);

        // filtrar palavras
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("M").endAt("N" + "\uf8ff");


        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                //Log.i("Dados usuario: ", "nome: " + dadosUsuario.getNome() + "idade: " + dadosUsuario.getIdade());
                Log.i("Dados usuario: ", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); */

        /* Usuario usuario = new Usuario();
        usuario.setNome("Naofumi");
        usuario.setSobrenome("Iwatami");
        usuario.setIdade(18);

        usuarios.push().setValue(usuario); */

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