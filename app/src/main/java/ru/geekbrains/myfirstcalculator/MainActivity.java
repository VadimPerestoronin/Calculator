package ru.geekbrains.myfirstcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements Serializable {

    private final static String ARG_CNT = "ARG_CNT";
    private TextView numberView;
    private Calculate calculate;
    public final static String KEY_APP_THEME = "KEY_APP_THEME";
    private ThemeStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = new ThemeStorage(this);

        setTheme(storage.getTheme().getResource());
        setContentView(R.layout.activity_main);

        String value = getIntent().getStringExtra(KEY_APP_THEME);
        if (KEY_APP_THEME == "dark") {
            storage.setTheme(AppTheme.CUSTOM);
        } else {
            storage.setTheme(AppTheme.DEFAULT);
        }


        numberView = findViewById(R.id.number_field);


        int[] numberIds = new int[]{
                R.id.key_0,
                R.id.key_1,
                R.id.key_2,
                R.id.key_3,
                R.id.key_4,
                R.id.key_5,
                R.id.key_6,
                R.id.key_7,
                R.id.key_8,
                R.id.key_9,
                R.id.key_dot
        };

        int[] actionsIds = new int[]{
                R.id.key_plus,
                R.id.key_minus,
                R.id.key_multiplication,
                R.id.key_division,
                R.id.key_equals
        };


        calculate = new Calculate();

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate.onNumPressed(view.getId());
                numberView.setText(calculate.getText());
            }
        };

        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate.onActionPressed(view.getId());
                numberView.setText(calculate.getText());

            }
        };

        for (int i = 0; i < numberIds.length; i++) {
            findViewById(numberIds[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < actionsIds.length; i++) {
            findViewById(actionsIds[i]).setOnClickListener(actionButtonOnclickListener);
        }

        findViewById(R.id.key_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate.reset();
                numberView.setText(calculate.getText());
            }
        });

        findViewById(R.id.key_backspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate.backspace();
                numberView.setText(calculate.getText());
            }
        });


        findViewById(R.id.button_setup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent runSetup = new Intent(MainActivity.this, SetupActivity.class);
                startActivity(runSetup);
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
        instanceState.putParcelable(ARG_CNT, calculate);
    }


    // Восстановление данных
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calculate = instanceState.getParcelable(ARG_CNT);
        numberView.setText(calculate.getText());

    }


}