package sg.edu.rp.c346.p03_class_journey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdScreen extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rg;
    Button btnSubmit;
    int week = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        tvWeek = findViewById(R.id.textViewWeekAdd);
        rg = findViewById(R.id.rg);
        btnSubmit = findViewById(R.id.btnSubmit);

        Intent i = getIntent();
        week = i.getIntExtra("week",0);
        week += 1;
        tvWeek.setText("week " + week);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String grade = "";
                int check = rg.getCheckedRadioButtonId();
                RadioButton r = (RadioButton) rg.getChildAt(rg.indexOfChild(rg.findViewById(rg.getCheckedRadioButtonId())));

                DailyCA newCA = new DailyCA(r.getText().toString(), "C347", week);
                Intent i = new Intent();
                i.putExtra("newCa", newCA);
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
