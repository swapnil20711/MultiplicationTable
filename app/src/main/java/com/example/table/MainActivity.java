package com.example.table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.table.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding v;
    int num;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(v.getRoot());
        v.buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTable();
            }
        });
        v.resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTable();
            }
        });
    }

    private void resetTable() {
        v.table.setText(R.string.table_empty);
    }

    private void showTable() {
        if (v.input.getText().length() == 0) {
            Toast.makeText(this, "Invalid input!!", Toast.LENGTH_SHORT).show();
        } else {
            num = Integer.valueOf(v.input.getText() + "");
            StringBuilder builder = new StringBuilder();
            for (i = 1; i <= 10; i++) {
                builder.append(num + "        X       " + i + "    =   " + num * i + "\n\n\n");
            }
            v.table.setText(builder);
        }

    }
}