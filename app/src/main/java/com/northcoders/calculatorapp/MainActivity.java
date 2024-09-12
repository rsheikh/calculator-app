package com.northcoders.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.buttonCalculate);
        EditText textInput = findViewById(R.id.TextInput);
        EditText textInput2 = findViewById(R.id.TextInput2);
        TextView resultMessage = findViewById(R.id.addedResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              result = addValues(textInput, textInput2);
              Log.i("****PRINT RESULT", ""+result);

              resultMessage.setText(String.format("The answer is %s ", result));
            }
        });

    }

    private int addValues(EditText textInput, EditText textInput2) {

        int firstNum = Integer.parseInt(textInput.getText().toString());
        int secondNum = Integer.parseInt(textInput2.getText().toString());

        return firstNum + secondNum;
    }
}