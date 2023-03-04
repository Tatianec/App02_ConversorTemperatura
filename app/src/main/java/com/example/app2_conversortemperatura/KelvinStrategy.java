package com.example.app2_conversortemperatura;

import com.example.app2_conversortemperatura.interfaces.ConversorTemperatura;

public class KelvinStrategy implements ConversorTemperatura {

    public KelvinStrategy(){}
    @Override
    public Double getConversion(Double temperatura) {
        double kelvin = temperatura + 273.0;

        return kelvin;
    }
}
