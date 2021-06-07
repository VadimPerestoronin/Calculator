package ru.geekbrains.myfirstcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity implements Serializable {

    private final static String ARG_CNT = "ARG_CNT";
    private TextView numberView;
    private TextView resultView;
    private Calculate calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberView = findViewById(R.id.number_field);
        resultView = findViewById(R.id.result_field);

        int[] numberIds = new int[] {
                R.id.key_0,
                R.id.key_1,
                R.id.key_2,
                R.id.key_3,
                R.id.key_4,
                R.id.key_5,
                R.id.key_6,
                R.id.key_7,
                R.id.key_8,
                R.id.key_9
        };

        int[] actionsIds = new int[] {
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

        

/*        findViewById(R.id.key_0).setOnClickListener(new View.OnClickListener() {
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
        findViewById(R.id.key_backspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredNumbers = numberView.getText().toString();
                numberView.setText(enteredNumbers.substring(0, enteredNumbers.length() -1));
            }
        });*/


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