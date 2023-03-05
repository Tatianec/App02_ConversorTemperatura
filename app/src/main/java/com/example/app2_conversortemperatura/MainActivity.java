package com.example.app2_conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener{

    CelsiusStrategy celsiusStrategy = new CelsiusStrategy();
    FahrenheitStrategy fahrenheitStrategy = new FahrenheitStrategy();

    KelvinStrategy kelvinStrategy = new KelvinStrategy();
    private EditText valueEditText;

    private Button converterTemperatura;
    private TextView convertedValueTextView;

    private RadioButton radioButtonCelsius;

    private RadioButton radioButtonFahrenheit;

    private RadioButton radioButtonKelvin;

    @SuppressLint( "MissingInflatedId" )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueEditText = findViewById(R.id.edittext_value);
        convertedValueTextView = findViewById(R.id.textview_value_converted);

        radioButtonCelsius = findViewById(R.id.radio_button_celsius);

        radioButtonFahrenheit = findViewById(R.id.radio_button_fahrenheit);

        radioButtonKelvin = findViewById(R.id.radio_button_kelvin);

        converterTemperatura = findViewById(R.id.button_converter_temperatura);
        converterTemperatura.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        if(radioButtonCelsius.isChecked()){
            getCelsiusConvertion();
        }
        if(radioButtonFahrenheit.isChecked()){
            getFahrenheitConvertion();
        }
        if (radioButtonKelvin.isChecked()){
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