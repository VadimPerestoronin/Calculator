package ru.geekbrains.myfirstcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements Serializable {

    private final static String ARG_CNT = "ARG_CNT";
    private TextView numberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberView = findViewById(R.id.number_field);


        findViewById(R.id.key_0).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "0");

            }
        });
        findViewById(R.id.key_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "1");
            }
        });
        findViewById(R.id.key_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "2");
            }
        });
        findViewById(R.id.key_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "3");
            }
        });
        findViewById(R.id.key_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "4");
            }
        });
        findViewById(R.id.key_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "5");
            }
        });
        findViewById(R.id.key_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "6");
            }
        });
        findViewById(R.id.key_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "7");
            }
        });
        findViewById(R.id.key_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "8");
            }
        });
        findViewById(R.id.key_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "9");
            }
        });
        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + ".");
            }
        });
        findViewById(R.id.key_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText("");
            }
        });
        findViewById(R.id.key_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "+");
            }
        });
        findViewById(R.id.key_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "-");
            }
        });
        findViewById(R.id.key_multiplication).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "*");
            }
        });
        findViewById(R.id.key_division).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "/");
            }
        });
        findViewById(R.id.key_percent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberView.setText(numberView.getText().toString() + "%");
            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // Сохранение данных
    @Override
    protected void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(ARG_CNT, (Serializable) numberView);
    }


    // Восстановление данных
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        numberView = (TextView) instanceState.getSerializable(ARG_CNT);

    }


}