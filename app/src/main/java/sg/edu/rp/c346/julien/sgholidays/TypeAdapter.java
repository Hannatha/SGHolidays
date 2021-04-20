package sg.edu.rp.c346.julien.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TypeAdapter extends ArrayAdapter<String> {
    private ArrayList<String> type;
    private Context context;
    private TextView tvYear;

    public TypeAdapter(Context context, int resources, ArrayList<String> objects) {
        super(context, resources, objects);
        type = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.typerow, parent, false);

        tvYear = (TextView) rowView.findViewById(R.id.tvType);

        String currType = type.get(position) != null ? type.get(position) : "none";
        tvYear.setText(currType);

        return rowView;
    }
}
