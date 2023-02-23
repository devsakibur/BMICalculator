package com.devsakiburlab.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.devsakiburlab.bmicalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    int constantValue;

    String under = "You may need to make lifestyle changes to gain or maintain weight and stay healthy, such as getting more healthy foods in your diet and doing exercises to build muscle";
    String normal = "You are fine.Keep your daily routine healthy.Do not smoke or drink Alcohol.Be happy.";
    String over = " You may need to make lifestyle changes to lose weight and stay healthy, such as changing your diet and getting regular exercise.";
    String overOne = " You may need to make lifestyle changes to lose weight and stay healthy, such as changing your diet and getting regular exercise.";
    String overTwo = " You may need to make lifestyle changes to lose weight and stay healthy, such as changing your diet and getting regular exercise.";
    String overThree = " You may need to make lifestyle changes to lose weight and stay healthy, such as changing your diet and getting regular exercise.";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        constantValue = 100;

        String a =  binding.enterWeight.getText().toString();
        String b =  binding.enterHeight.getText().toString();

        binding.enterHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString().length()> 6){
                    Toast.makeText(MainActivity.this, "Use Valid Number", Toast.LENGTH_SHORT).show();
                    binding.enterHeight.setText("");
                }

            }
        });
        binding.enterWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString().length()> 7){
                    Toast.makeText(MainActivity.this, "Use Valid Number", Toast.LENGTH_SHORT).show();
                    binding.enterWeight.setText("");
                }

            }
        });





        binding.calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x =  binding.enterWeight.getText().toString();
                String y =  binding.enterHeight.getText().toString();

                float in1 = Float.parseFloat(x);
                float in2 = Float.parseFloat(y);
                float in3 = in2 / constantValue;
                float  inResult = in3 * in3;

                float result = in1 / inResult;
                String finalResult = String.format("%.2f" ,result);

                if(finalResult.length() >5){
                    Toast.makeText(MainActivity.this, "Use Valid Number", Toast.LENGTH_SHORT).show();
                }else{
                    binding.bmiDisplay.setText(finalResult);
                    binding.inputLayout.setVisibility(View.INVISIBLE);
                    binding.resultDisplay.setVisibility(View.VISIBLE);
                    if(Float.parseFloat(finalResult) <= 18.4){
                        binding.bmiAddDisplay.setText("Underweight");
                        binding.bmiAdvice.setText(under);
                    }else if(Float.parseFloat(finalResult) > 18.4 && Float.parseFloat(finalResult) <= 24.9){
                        binding.bmiAddDisplay.setText("Normal range");
                        binding.bmiAdvice.setText(normal);
                    }else if(Float.parseFloat(finalResult) > 24.9 && Float.parseFloat(finalResult) <= 29.9){
                        binding.bmiAddDisplay.setText("Overweight (Pre-obese)");
                        binding.bmiAdvice.setText(over);
                    }else if(Float.parseFloat(finalResult) > 29.9 && Float.parseFloat(finalResult) <= 34.9){
                        binding.bmiAddDisplay.setText("Obese (Class I)");
                        binding.bmiAdvice.setText(overOne);
                    }else if(Float.parseFloat(finalResult) > 34.9 && Float.parseFloat(finalResult) <= 39.9){
                        binding.bmiAddDisplay.setText("Obese (Class II)");
                        binding.bmiAdvice.setText(overTwo);
                    }else if(Float.parseFloat(finalResult) > 39.9){
                        binding.bmiAddDisplay.setText( "Obese (Class III)");
                        binding.bmiAdvice.setText(overThree);
                    }





                }




            }
        });


        binding.reCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.bmiAddDisplay.setText( "");
                binding.bmiAdvice.setText("");
                binding.enterWeight.setText("");
                binding.enterHeight.setText("");
                binding.resultDisplay.setVisibility(View.INVISIBLE);
                binding.inputLayout.setVisibility(View.VISIBLE);

            }
        });



    }
}