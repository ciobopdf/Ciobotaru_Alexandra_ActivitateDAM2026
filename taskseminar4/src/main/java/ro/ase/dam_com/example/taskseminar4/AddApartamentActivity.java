package ro.ase.dam_com.example.taskseminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddApartamentActivity extends AppCompatActivity {

    private Spinner spCamere;
    private RadioGroup rgTip;
    private CheckBox cbMobilat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartament);

        spCamere = findViewById(R.id.SP_numar_camere);
        rgTip = findViewById(R.id.rgTip);
        cbMobilat = findViewById(R.id.cbMobilat);

        String[] optiuni = {"1 Cameră", "2 Camere", "3 Camere", "4+ Camere"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, optiuni);
        spCamere.setAdapter(adapter);
    }

    public void salveazaDate(View view) {
        EditText etAdresa = findViewById(R.id.ET_adresa);
        RatingBar rbStare = findViewById(R.id.RB_rating);
        Switch swDisponibil = findViewById(R.id.SW_disponibil);

        String adresa = etAdresa.getText().toString().trim();
        if (adresa.isEmpty()) {
            Toast.makeText(this, "Introduceți adresa!", Toast.LENGTH_SHORT).show();
            return;
        }

        String camere = spCamere.getSelectedItem().toString();
        float rating = rbStare.getRating();
        boolean disponibil = swDisponibil.isChecked();
        boolean mobilat = cbMobilat.isChecked();

        int selectedRadioId = rgTip.getCheckedRadioButtonId();
        RadioButton rbSelected = findViewById(selectedRadioId);
        String tipAnunt = (rbSelected != null) ? rbSelected.getText().toString() : "Proprietar";

        Apartament ap = new Apartament(adresa, camere, rating, disponibil, tipAnunt, mobilat);

        Bundle bundle = new Bundle();
        bundle.putSerializable("OBIECT_APARTAMENT", ap);

        Intent it = new Intent();
        it.putExtras(bundle);

        setResult(RESULT_OK, it);
        finish();
    }
}