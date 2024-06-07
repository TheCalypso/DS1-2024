package fr.gaspezia.ds1_2024;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int unite = 0; // 0 pour Celsius, 1 pour Fahrenheit, 2 pour Kelvin
    private TextView textViewunite0, textViewunite1, textViewunite2;
    private EditText editTextvaleur;
    private TextView textViewtemperature1, textViewtemperature2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewunite0 = findViewById(R.id.textViewunite0);
        textViewunite1 = findViewById(R.id.textViewunite1);
        textViewunite2 = findViewById(R.id.textViewunite2);
        editTextvaleur = findViewById(R.id.editTextvaleur);
        textViewtemperature1 = findViewById(R.id.textViewtemperature1);
        textViewtemperature2 = findViewById(R.id.textViewtemperature2);

        findViewById(R.id.imageButtonCelsius).setOnClickListener(view -> setUnite(0));
        findViewById(R.id.imageButtonFahrenheit).setOnClickListener(view -> setUnite(1));
        findViewById(R.id.imageButtonKelvin).setOnClickListener(view -> setUnite(2));

        findViewById(R.id.buttonConvert).setOnClickListener(view -> convertTemperature());
        findViewById(R.id.buttonReset).setOnClickListener(view -> resetFields());
    }

    private void setUnite(int selectedUnite) {
        this.unite = selectedUnite;
        switch (unite) {
            case 0:
                textViewunite0.setText("°C");
                break;
            case 1:
                textViewunite0.setText("°F");
                break;
            case 2:
                textViewunite0.setText("K");
                break;
        }
    }

    private void convertTemperature() {
        if (editTextvaleur.getText().toString().isEmpty()) return;

        double input = Double.parseDouble(editTextvaleur.getText().toString());
        double temp1 = 0, temp2 = 0;

        switch (unite) {
            case 0: // Celsius
                temp1 = (input * 9/5) + 32; // Fahrenheit
                temp2 = input + 273.15; // Kelvin
                textViewunite1.setText("°F");
                textViewunite2.setText("K");
                break;
            case 1: // Fahrenheit
                temp1 = (input - 32) * 5/9; // Celsius
                temp2 = (input - 32) * 5/9 + 273.15; // Kelvin
                textViewunite1.setText("°C");
                textViewunite2.setText("K");
                break;
            case 2: // Kelvin
                temp1 = input - 273.15; // Celsius
                temp2 = (input - 273.15) * 9/5 + 32; // Fahrenheit
                textViewunite1.setText("°C");
                textViewunite2.setText("°F");
                break;
        }

        textViewtemperature1.setText(String.format("%.2f", temp1));
        textViewtemperature2.setText(String.format("%.2f", temp2));
    }


    private void resetFields() {
        editTextvaleur.setText("");
        textViewtemperature1.setText("0");
        textViewtemperature2.setText("0");
    }
}


