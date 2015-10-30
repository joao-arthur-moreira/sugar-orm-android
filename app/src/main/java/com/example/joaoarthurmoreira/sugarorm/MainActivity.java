package com.example.joaoarthurmoreira.sugarorm;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.joaoarthurmoreira.model.Autor;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /* Persistência de um Autor */
        Autor autor = new Autor("Nelson", "Glauber 2");
        autor.setId(1L);
        autor.save();

        /* Listagem de todos Autores persistidos no banco */
        for (Autor aut : Autor.listAll(Autor.class)) {
            Log.d("SUGAR", "Autor id: " + aut.getId());
            Log.d("SUGAR", "Autor nome: " + aut.getNome());
            Log.d("SUGAR", "Autor sobreNome: " + aut.getSobreNome());
        }

        List<Autor> autors = Autor.find(Autor.class,"sobre_nome = ?","Glauber");
        for (Autor a : autors){
            Log.d("Sugar",String.format("Autor [%d]: %s %s", a.getId(), a.getNome(), a.getSobreNome()));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
