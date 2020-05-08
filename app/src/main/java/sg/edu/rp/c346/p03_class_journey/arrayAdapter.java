package sg.edu.rp.c346.p03_class_journey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class arrayAdapter extends ArrayAdapter<DailyCA> {

    private ArrayList<DailyCA> array;
    private TextView tvWeek, tvGrade;
    private Context context;

    public arrayAdapter(Context context, int resource, ArrayList<DailyCA> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        array = objects;
        // Store Context object as we would need to use it later
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.layout_daily, parent, false);


        // Get the TextView object
        tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        tvWeek = (TextView)  rowView.findViewById(R.id.textViewWeek);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyCA current = array.get(position);
        // Set the TextView to show the food

        tvWeek.setText("week " + current.getWeek());
        tvGrade.setText(current.getDgGrade());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
