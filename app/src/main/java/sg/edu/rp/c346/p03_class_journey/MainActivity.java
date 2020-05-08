package sg.edu.rp.c346.p03_class_journey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter aa;
    ArrayList<Module> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        array = new ArrayList<Module>();
        array.add(new Module("Android Programming II", "C347"));
        array.add(new Module("Web Service", "C302"));

        aa = new moduleAdapter(this, R.layout.first_ui, array);
        listView.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // String selectedHoliday = array.get(position);
                Intent i = new Intent(MainActivity.this, Info_for_C347.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

    }
}
