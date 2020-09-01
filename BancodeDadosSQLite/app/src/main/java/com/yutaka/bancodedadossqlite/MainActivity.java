package com.yutaka.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            // Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            // Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3)) ");
            //bancoDados.execSQL("DROP TABLE pessoas");

            // Inserir dados
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Pedro', 15) "); // desse modo vai toda hora adicionar
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('João', 54) ");

            // Update
            //bancoDados.execSQL("UPDATE pessoas SET idade = 10, nome = 'Lucianna' WHERE id = 1");

            // DELETAR
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 3");

            // Recuperar pessoas
            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                    "WHERE nome = 'Yutaka' AND idade = 20 "; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE idade >= 25 OR idade = 20 "; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE idade IN(18,55) "; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE idade BETWEEN 20 AND 55"; */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE nome LIKE '%ta%' "; // %ta -> tem letras antes de ta   ta% tem ta e letras dps */

            String consulta =
                    "SELECT * FROM pessoas " +
                            "WHERE 1=1 ORDER BY idade ASC"; // Ordena de forma ascendente ou descendente ASC / DESC /// LIMIT -> limita quantidade que aparece

            Cursor cursor = bancoDados.rawQuery(consulta, null);

            // indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - id ", id + " / nome: " + nome + " / idade: " + idade);
                cursor.moveToNext();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}