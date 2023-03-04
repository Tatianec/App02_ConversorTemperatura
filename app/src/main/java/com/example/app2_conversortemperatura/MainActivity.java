package com.example.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener{

    CelsiusStrategy celsiusStrategy = new CelsiusStrategy();
    FahrenheitStrategy fahrenheitStrategy = new FahrenheitStrategy();

    KelvinStrategy kelvinStrategy = new KelvinStrategy();
    private EditText valueEditText;
    private Button converterCelsiusButton;

    private Button converterKelvinButton;
    private Button converterFahrenheitButton;
    private TextView convertedValueTextView;

    @SuppressLint( "MissingInflatedId" )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueEditText = findViewById(R.id.edittext_value);
        convertedValueTextView = findViewById(R.id.textview_value_converted);

        converterCelsiusButton = findViewById(R.id.button_converter_celsius);
        converterCelsiusButton.setOnClickListener(this);

        converterFahrenheitButton = findViewById(R.id.button_converter_fahrenheit);
        converterFahrenheitButton.setOnClickListener(this);

        converterKelvinButton = findViewById(R.id.button_converter_kelvin);
        converterKelvinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == converterCelsiusButton){
            getCelsiusConvertion();
        }
        if (view == converterFahrenheitButton){
            getFahrenheitConvertion();
        }
        if (view == converterKelvinButton){
            getKelvinConvertion();
        }
    }

    private double getValueCelsius(){
        double value;
        double temperatura = 0.0;

        try {
            value = getValue();
            temperatura = celsiusStrategy.getConversion(value);

        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor inválido.", Toast.LENGTH_SHORT).show();
        }

        return temperatura;
    }

    private double getValueFahrenheit(){
        double value;
        double temperatura = 0.0;

        try {
            value = getValue();
            temperatura = fahrenheitStrategy.getConversion(value);

        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor inválido.", Toast.LENGTH_SHORT).show();
        }

        return temperatura;
    }

    private double getValueKelvin(){
        double value;
        double temperatura = 0.0;

        try {
            value = getValue();
            temperatura = kelvinStrategy.getConversion(value);

        }catch (NumberFormatException e){
            Toast.makeText(this, "Valor inválido.", Toast.LENGTH_SHORT).show();
        }

        return temperatura;
    }

    private double getValue(){
        double value;
        String valueString;
        valueString = valueEditText.getText().toString();

        value = Double.valueOf(valueString);

        return value;
    }
    private void getCelsiusConvertion(){
        double temperatura = getValueCelsius();
        convertedValueTextView.setText(String.format("%.2f ºC", temperatura));
    }

    private void getFahrenheitConvertion(){
        double temperatura = getValueFahrenheit();
        convertedValueTextView.setText(String.format("%.2f ºF", temperatura));
    }

    private void getKelvinConvertion() {
        double temperatura = getValueKelvin();
        convertedValueTextView.setText(String.format("%.2f K", temperatura));
    }

}