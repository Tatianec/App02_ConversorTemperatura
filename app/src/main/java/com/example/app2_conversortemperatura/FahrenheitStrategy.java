package com.example.app2_conversortemperatura;

import com.example.app2_conversortemperatura.interfaces.ConversorTemperatura;

public class FahrenheitStrategy implements ConversorTemperatura {

    public FahrenheitStrategy() {
    }

    @Override
    public Double getConversion(Double temperatura) {

        double f = 1.8 * temperatura + 32;

        return f;
    }
}
