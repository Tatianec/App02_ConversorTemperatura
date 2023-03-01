package com.example.app2_conversortemperatura;

import com.example.app2_conversortemperatura.interfaces.ConversorTemperatura;

public class CelsiusStrategy implements ConversorTemperatura {

    public CelsiusStrategy(){};
    
    @Override
    public Double getConversion(Double temperatura) {
        double c = (temperatura - 32) / 1.8;
        
        return c;
    }

}
