package sg.edu.rp.c346.p03_class_journey;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Info_for_C347 extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<DailyCA> array;
    Button btnInfo, btnSend, btnAdd;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_for__c347);

        lv = (ListView) this.findViewById(R.id.listView2);
        btnInfo = findViewById(R.id.buttonInfo);
        btnSend = findViewById(R.id.buttonEmail);
        btnAdd = findViewById(R.id.buttonAdd);

        ActionBar ab = getSupportActionBar();

        Intent i = getIntent();
        position = i.getIntExtra("position",0);

        array = new ArrayList<DailyCA>();
        if (position == 1){
            ab.setTitle("Info For C302");
            array.add(new DailyCA("A", "C302", 1));
            array.add(new DailyCA("C", "C302", 2));
            array.add(new DailyCA("A", "C302", 3));
        } else if (position == 0){
            ab.setTitle("Info For C347");
            array.add(new DailyCA("B", "C347", 1));
            array.add(new DailyCA("C", "C347", 2));
            array.add(new DailyCA("A", "C347", 3));
        }

        aa = new arrayAdapter(this, R.layout.layout_daily, array);
        lv.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                if(position == 0){
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                } else {
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                }
                startActivity(rpIntent);

            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "");
                String statement = "Hi faci, \n\nI am ... \nPlease see my remarks so far, thank you !\n\n";
                for (int i = 0; i < array.size(); i++) {
                    statement += "Week " + array.get(i).getWeek() + ": DG: " + array.get(i).getDgGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT,
                        statement);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Info_for_C347.this,
                        ThirdScreen.class);
                i.putExtra("week", array.size());
                startActivityForResult(i, 1);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int
            resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity
                DailyCA newCA = (DailyCA) data.getSerializableExtra("newCa");
                array.add(newCA);
                Log.d("123123123", array.size() + "");
                aa.notifyDataSetChanged();
                Toast.makeText(Info_for_C347.this, newCA.getDgGrade(),
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}
