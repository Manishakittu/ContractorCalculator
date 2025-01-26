package com.example.contractorcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextLaborCost;
    private EditText editTextMaterialCost;
    private TextView textViewSubTotal;
    private TextView textViewTax;
    private TextView textViewTotal;
    private static final double TAX_RATE = 0.05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLaborCost = findViewById(R.id.editTextLaborCost);
        editTextMaterialCost = findViewById(R.id.editTextMaterialCost);
        textViewSubTotal = findViewById(R.id.textViewSubTotal);
        textViewTax = findViewById(R.id.textViewTax);
        textViewTotal = findViewById(R.id.textViewTotal);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCosts();
            }
        });
    }

    private void calculateCosts() {
        double laborCost = Double.parseDouble(editTextLaborCost.getText().toString());
        double materialCost = Double.parseDouble(editTextMaterialCost.getText().toString());
        double subTotal = laborCost + materialCost;
        double tax = subTotal * TAX_RATE;
        double total = subTotal + tax;

        textViewSubTotal.setText(String.format("%.2f", subTotal));
        textViewTax.setText(String.format("%.2f", tax));
        textViewTotal.setText(String.format("%.2f", total));
    }
}
