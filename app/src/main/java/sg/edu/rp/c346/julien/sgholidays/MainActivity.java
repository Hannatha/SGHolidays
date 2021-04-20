package sg.edu.rp.c346.julien.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;
    TypeAdapter ta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvTypes);

        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic & Religion");
        ta = new TypeAdapter(this, R.layout.typerow, al);
        lv.setAdapter(ta);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedType = al.get(position);
                Log.d("TAG", "onItemClick: " + selectedType);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //based on item add info to intent
                intent.putExtra("type", selectedType);
                startActivity(intent);
            }
        });

    }
}