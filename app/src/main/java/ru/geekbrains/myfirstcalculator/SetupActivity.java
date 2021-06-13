package ru.geekbrains.myfirstcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SetupActivity extends AppCompatActivity {

    private ThemeStorage storage;
    private static String KEY_APP_THEME = "KEY_APP_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        storage = new ThemeStorage(this);

        setTheme(storage.getTheme().getResource());

        setContentView(R.layout.activity_setup);

        findViewById(R.id.button_dark_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage.setTheme(AppTheme.CUSTOM);
                KEY_APP_THEME = "dark";

                recreate();
            }
        });

        findViewById(R.id.button_light_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage.setTheme(AppTheme.DEFAULT);
                KEY_APP_THEME = "light";

                recreate();
            }
        });

        findViewById(R.id.button_back_to_calculator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMain = new Intent(SetupActivity.this, MainActivity.class);
                backToMain.putExtra(MainActivity.KEY_APP_THEME, KEY_APP_THEME);
                startActivity(backToMain);
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

}