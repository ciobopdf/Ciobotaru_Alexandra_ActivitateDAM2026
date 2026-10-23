package ro.ase.dam_com.example.taskseminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvRezultat;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvRezultat = findViewById(R.id.TV_rezultat);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle bundle = result.getData().getExtras();
                        if (bundle != null && bundle.containsKey("OBIECT_APARTAMENT")) {
                            Apartament ap = (Apartament) bundle.getSerializable("OBIECT_APARTAMENT");
                            if (ap != null) {
                                tvRezultat.setText(ap.toString());
                                Toast.makeText(this, "Adăugat cu succes:\n" + ap.toString(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );
    }

    public void deschideAdaugareStandard(View view) {
        Intent it = new Intent(this, AddApartamentActivity.class);
        launcher.launch(it);
    }

    public void deschideAdaugareAI(View view) {
        Intent it = new Intent(this, AddApartamentAiActivity.class);
        launcher.launch(it);
    }
}