package sg.edu.rp.c346.julien.sgholidays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lvHolidays;
    TextView tvName;
    ArrayList<Holidays> al;
    HolidayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra("type");
        tvName = (TextView) findViewById(R.id.tvTypeName);
        lvHolidays = (ListView) findViewById(R.id.lvHolidays);
        tvName.setText(message);
        al = new ArrayList<Holidays>();
        if (tvName.getText().equals("Secular")) {
            al.add(new Holidays("New Year's Day", "newyear", "1 Jan 2021"));
            al.add(new Holidays("Labour Day", "labourday", "1 May 2021"));
        } else if (tvName.getText().equals("Ethnic & Religion")){
            al.add(new Holidays("Chinese New Year", "cny", "28-29 Jan 2021"));
            al.add(new Holidays("Good Friday", "goodfriday", "14 April 2021"));
        }
        aa = new HolidayAdapter(this, R.layout.holidayrow, al);
        lvHolidays.setAdapter(aa);

        lvHolidays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selectedHoliday = al.get(position);
                Toast.makeText(SecondActivity.this, selectedHoliday.getName() + " Date: " + selectedHoliday.getDate(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
