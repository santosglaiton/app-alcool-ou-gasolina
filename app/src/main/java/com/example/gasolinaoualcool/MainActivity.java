package com.example.gasolinaoualcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoAlcool, precoGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.idAlcool);
        precoGasolina = findViewById(R.id.idGasolina);
        resultado = findViewById(R.id.resultado);
    }

    public void calculaPreco(View view){
        String alcool = precoAlcool.getText().toString();
        String gasolina = precoGasolina.getText().toString();

        Boolean resultadoValidacao = validarCampos(alcool, gasolina);
        if( resultadoValidacao == true){

            Double valorAlcool  = Double.parseDouble(alcool);
            Double valorGasolina = Double.parseDouble(gasolina);

            Double resultadoCalculo = valorAlcool / valorGasolina;
            if(resultadoCalculo >= 0.7){
                resultado.setText("Melhor utilizar Gasolina");
            }else{
                resultado.setText("Melhor utilizar Álcool");
            }

        }else{

            resultado.setText("Preencha todos os campos.");
        }
    }

    public Boolean validarCampos (String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("") || pAlcool == "0"){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("") || pGasolina == "0"){
            camposValidados = false;
        }

        return camposValidados;
    }
}
