package ru.geekbrains.myfirstcalculator;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

public class Calculate extends AppCompatActivity implements Parcelable {


    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();
    String strTemp = new String();

    private int actionSelected;

    private State state;

    private enum State {
        firstArgInput,
        operationSelected,
        secondArgInput,
        resultShow
    }

    public Calculate() {
        state = State.firstArgInput;
    }

    public void onNumPressed(int buttonId) {

        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if (state == State.operationSelected) {
            state = State.secondArgInput;
            inputStr.setLength(0);
        }

        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.key_0:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.key_1:
                    inputStr.append("1");
                    break;
                case R.id.key_2:
                    inputStr.append("2");
                    break;
                case R.id.key_3:
                    inputStr.append("3");
                    break;
                case R.id.key_4:
                    inputStr.append("4");
                    break;
                case R.id.key_5:
                    inputStr.append("5");
                    break;
                case R.id.key_6:
                    inputStr.append("6");
                    break;
                case R.id.key_7:
                    inputStr.append("7");
                    break;
                case R.id.key_8:
                    inputStr.append("8");
                    break;
                case R.id.key_9:
                    inputStr.append("9");
                    break;
            }
        }

    }

    public void onActionPressed(int actionId) {
        if (actionId == R.id.key_equals && state == State.secondArgInput && inputStr.length() > 0) {
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.key_plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.key_minus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.key_multiplication:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.key_division:
                    inputStr.append(firstArg / secondArg);
                    break;
            }

        } else if (inputStr.length() > 0 && state == State.firstArgInput && actionId != R.id.key_equals) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.operationSelected;
            actionSelected = actionId;
        }
    }

    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                return inputStr.toString();
            case operationSelected:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .toString();
            case secondArgInput:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(inputStr)
                        .toString();
            case resultShow:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(secondArg)
                        .append(" = ")
                        .append(inputStr.toString())
                        .toString();
        }
    }

    private char getOperationChar() {
        switch (actionSelected) {
            case R.id.key_plus:
                return '+';
            case R.id.key_minus:
                return '-';
            case R.id.key_multiplication:
                return '*';
            case R.id.key_division:
            default:
                return '/';

        }
    }

    public void reset() {
        state = State.firstArgInput;
        inputStr.setLength(0);
    }

    public void backspace() {
        inputStr.delete(inputStr.length()-1, inputStr.length());
    }

    protected Calculate(Parcel in) {

        firstArg = in.readInt();
        secondArg = in.readInt();
        actionSelected = in.readInt();
        strTemp = inputStr.toString();
        strTemp = in.readString();

    }

    public static final Creator<Calculate> CREATOR = new Creator<Calculate>() {
        @Override
        public Calculate createFromParcel(Parcel in) {
            return new Calculate(in);
        }

        @Override
        public Calculate[] newArray(int size) {
            return new Calculate[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(firstArg);
        dest.writeInt(secondArg);
        dest.writeInt(actionSelected);
        dest.writeString(strTemp);
    };


}
