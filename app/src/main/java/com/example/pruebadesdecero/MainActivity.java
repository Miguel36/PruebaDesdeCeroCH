package com.example.pruebadesdecero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nombreEditText;
    TextView saludoTextview;
    Button buttonIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreEditText = findViewById(R.id.edittext_nombre);
        saludoTextview = findViewById(R.id.textview_saludo);
        buttonIngresar = findViewById(R.id.button_ingresar);

        eventIngresar(buttonIngresar, this);
    }


    private void eventIngresar(Button button, final Activity activity){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(activity);
                String descriptionTextView = getResources().getText(R.string.text_textview).toString();
                String info = nombreEditText.getText().toString();
                saludoTextview.setText(descriptionTextView + " " + info);
            }
        });
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

}
