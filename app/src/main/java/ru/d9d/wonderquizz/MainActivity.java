package ru.d9d.wonderquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        int correct = 0;

        EditText answer_star = findViewById(R.id.et_answer_star);
        if (answer_star.getText().toString().trim().equalsIgnoreCase(getString(R.string.sun)))
            correct++;

        EditText answer_dense = findViewById(R.id.et_answer_dense);
        if (answer_dense.getText().toString().trim().equalsIgnoreCase(getString(R.string.earth)))
            correct++;

        RadioButton radio_answer_mercury = findViewById(R.id.radio_answer_mercury);
        if (radio_answer_mercury.isChecked()) correct++;

        RadioButton radio_answer_venus = findViewById(R.id.radio_answer_venus);
        if (radio_answer_venus.isChecked()) correct++;

        RadioButton radio_answer_hot = findViewById(R.id.radio_answer_hot);
        if (radio_answer_hot.isChecked()) correct++;

        RadioButton radio_answer_jupiter = findViewById(R.id.radio_answer_jupiter);
        if (radio_answer_jupiter.isChecked()) correct++;

        RadioButton radio_answer_ancients = findViewById(R.id.radio_answer_ancients);
        if (radio_answer_ancients.isChecked()) correct++;

        CheckBox answer_rings_jupiter = findViewById(R.id.cb_answer_rings_jupiter);
        CheckBox answer_rings_saturn = findViewById(R.id.cb_answer_rings_saturn);
        CheckBox answer_rings_uranus = findViewById(R.id.cb_answer_rings_uranus);
        CheckBox answer_rings_neptune = findViewById(R.id.cb_answer_rings_neptune);
        if (answer_rings_jupiter.isChecked() &&
                answer_rings_saturn.isChecked() &&
                answer_rings_uranus.isChecked() &&
                answer_rings_neptune.isChecked()) correct++;

        if (correct == 8){
            displayToast(getString(R.string.quiz_result_perfect));
        }else{
            displayToast(getString(R.string.quiz_result, Integer.toString(correct)));
        }
    }

    public void displayToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    }
}
