package ru.geekbrains.myfirstcalculator;

public enum AppTheme {

    CUSTOM(R.style.Theme_MyFirstCalculator_Dark, "dark"),

    DEFAULT(R.style.Theme_MyFirstCalculator, "light");

    private int resource;

    private String key;

    AppTheme(int resource, String key) {
        this.resource = resource;
        this.key = key;
    }



    public int getResource() {
        return resource;
    }

    public String  getKey() {
        return key;
    }
}
