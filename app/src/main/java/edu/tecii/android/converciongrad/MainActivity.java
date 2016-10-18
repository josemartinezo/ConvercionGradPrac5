package edu.tecii.android.converciongrad;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.txtV)
    TextView txtV;
    @Bind(R.id.inputG)
    EditText inputG;
    @Bind(R.id.btnCal)
    Button btnCal;
    @Bind(R.id.txtResu)
    TextView txtResu;
    @Bind(R.id.txtResu1)
    TextView txtResu1;
    @Bind(R.id.txtResu2)
    TextView txtResu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        txtV.setVisibility(View.VISIBLE);
        txtV.setText("Ingresa los °C a convertir");
    }

    @OnClick(R.id.btnCal)
    public void handleClickSubmit() {
        hideKeyboard();
        String num = inputG.getText().toString().trim();
        double num1 = Double.parseDouble(num);
        if (!num.isEmpty()) {

            double f = (num1*1.800) + 32;
            double k = (num1+273.15);
            double r = (num1*1.8000)+491.76;

            String resu = "Grados Fahrenheit: "+f+ "°F \n";
            String resu1 = "Grados Kelvin: "+k+"°K \n";
            String resu2 = "Rankine: "+r+"°R \n";

            //String strTip = String.format(getString(R.string.global_message_tip), tip);
            txtResu.setVisibility(View.VISIBLE);
            txtResu.setText(resu);
            txtResu1.setVisibility(View.VISIBLE);
            txtResu1.setText(resu1);
            txtResu2.setVisibility(View.VISIBLE);
            txtResu2.setText(resu2);

        }
    }


    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        } catch (NullPointerException npe) {
            Log.e(getLocalClassName(), Log.getStackTraceString(npe));
        }
    }
}
