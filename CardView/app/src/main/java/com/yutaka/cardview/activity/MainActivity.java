package com.yutaka.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.yutaka.cardview.R;
import com.yutaka.cardview.adapter.PostagemAdapter;
import com.yutaka.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        // Definir layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);
        // Definir adapter
        this.prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);
    }

    public void prepararPostagens() {

        Postagem p = new Postagem("Yutaka Yasuda", "Viagem Top", R.drawable.imagem4);
        this.postagens.add(p);

        p = new Postagem("Hotel yTK", "Aproveite nossos descontos", R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Elaiza", "Paris", R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Charmander", "char", R.drawable.imagem1);
        this.postagens.add(p);

    }

}