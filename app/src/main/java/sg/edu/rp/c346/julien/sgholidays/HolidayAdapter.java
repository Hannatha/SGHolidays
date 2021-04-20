package sg.edu.rp.c346.julien.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holidays> {

private ArrayList<Holidays> holiday;
        private Context context;
        private TextView tvHolidayName, tvHolidayDate;
        private ImageView ivHolidayImage;

        public HolidayAdapter(Context context, int resources, ArrayList<Holidays> objects) {
        super(context, resources, objects);
        holiday = objects;
        this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.holidayrow, parent, false);

        tvHolidayName = (TextView) rowView.findViewById(R.id.tvHolidayName);
        ivHolidayImage = (ImageView) rowView.findViewById(R.id.imageView);
        tvHolidayDate = (TextView) rowView.findViewById(R.id.tvHolidayDate);


        Holidays currHoliday = holiday.get(position);
        tvHolidayName.setText(currHoliday.getName());
        tvHolidayDate.setText(currHoliday.getDate());

        switch (currHoliday.getImage()) {
                case "newyear":
                        ivHolidayImage.setImageResource(R.drawable.newyear);
                        break;
                case "labourday":
                        ivHolidayImage.setImageResource(R.drawable.labourday);
                        break;
                case "cny":
                        ivHolidayImage.setImageResource(R.drawable.cny);
                        break;
                case "goodfriday":
                        ivHolidayImage.setImageResource(R.drawable.goodfriday);
                        break;
        }

        return rowView;
        }
}
