package com.example.kevinbui.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textViewSeekBar;
    private int seekBarPercentage;
    private float enteredBillFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = (EditText)findViewById(R.id.billAmountID);
        seekBar = (SeekBar)findViewById(R.id.percentageSeekBar);
        calculateButton = (Button)findViewById(R.id.calculateButton);
        totalResultTextView = (TextView)findViewById(R.id.resultID);
        textViewSeekBar = (TextView)findViewById(R.id.textViewSeekBar);


        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + "%"); // Changes the value of the textView
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekBarPercentage = seekBar.getProgress(); // Holds the value of the seekBar
            }
        });
    }

    @Override
    public void onClick(View v){
        calculate();
    }

    // calculate logic
    public void calculate(){
        float result = 0.0f;

        // Checks if there is a value in for the bill amount
        if (!enteredAmount.getText().toString().equals("")) {

            enteredBillFloat = Float.parseFloat(enteredAmount.getText().toString()); // Converts the text to float and hold the value
            result = enteredBillFloat * seekBarPercentage / 100; // Multiply entered bill amount by pecentage of the seekBar
            totalResultTextView.setText("Your tip will be $" + String.valueOf(result));

        } else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }

    }
}
