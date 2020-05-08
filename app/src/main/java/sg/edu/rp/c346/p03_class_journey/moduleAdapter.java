package sg.edu.rp.c346.p03_class_journey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class moduleAdapter extends ArrayAdapter<Module> {

    private ArrayList<Module> array;
    private TextView tvName, tvCode;
    private Context context;

    public moduleAdapter(Context context, int resource, ArrayList<Module> objects){
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
        View rowView = inflater.inflate(R.layout.first_ui, parent, false);


        // Get the TextView object
        tvCode = (TextView) rowView.findViewById(R.id.textViewCode);
        tvName = (TextView)  rowView.findViewById(R.id.textViewName);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Module current = array.get(position);
        // Set the TextView to show the food

        tvCode.setText(current.getCode());
        tvName.setText(current.getName());


        // Return the nicely done up View to the ListView
        return rowView;
    }
}
