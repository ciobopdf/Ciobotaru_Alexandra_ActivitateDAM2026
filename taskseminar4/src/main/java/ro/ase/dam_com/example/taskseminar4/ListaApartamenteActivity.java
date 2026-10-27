package ro.ase.dam_com.example.taskseminar4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaApartamenteActivity extends AppCompatActivity {

    public static final String CHEIE_LISTA = "CHEIE_LISTA_APARTAMENTE";
    private ListView lvApartamente;
    private ArrayList<Apartament> listaApartamente;
    private ArrayAdapter<Apartament> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_apartamente);

        lvApartamente = findViewById(R.id.lvApartamente);


        if (getIntent() != null && getIntent().hasExtra(CHEIE_LISTA)) {
            listaApartamente = (ArrayList<Apartament>) getIntent().getSerializableExtra(CHEIE_LISTA);
        }

          if (listaApartamente == null) {
            listaApartamente = new ArrayList<>();
        }


        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaApartamente
        );
        lvApartamente.setAdapter(adapter);

        lvApartamente.setOnItemClickListener((parent, view, position, id) -> {
            Apartament apSelectat = listaApartamente.get(position);
            Toast.makeText(
                    ListaApartamenteActivity.this,
                    "Selectat:\n" + apSelectat.toString(),
                    Toast.LENGTH_SHORT
            ).show();
        });

        lvApartamente.setOnItemLongClickListener((parent, view, position, id) -> {
            Apartament apSters = listaApartamente.remove(position);

             adapter.notifyDataSetChanged();

            Toast.makeText(
                    ListaApartamenteActivity.this,
                    "Apartamentul a fost șters!",
                    Toast.LENGTH_SHORT
            ).show();

            return true;
        });
    }
}