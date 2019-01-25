package sleepfuriously.com.biggscaloriecounter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //----------------------
    //  constants
    //----------------------

    private static final String TAG = MainActivity.class.getSimpleName();

    //----------------------
    //  widgets
    //----------------------

    /** User-entered food string */
    private EditText mFood_et;

    /** user-entered calories */
    private EditText mCals_et;

    private RecyclerView mFoodHistory_rv;

    //----------------------
    //  data
    //----------------------

    RecyclerView m_rv;

    HistoryAdapter m_adapter;


    //----------------------
    //  methods
    //----------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_rv = findViewById(R.id.history_rv);
        m_rv.setLayoutManager(new LinearLayoutManager(this));

        // some test foods
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("corn", 25, new Date()));
        foods.add(new Food("milk", 90, new Date()));
        foods.add(new Food("candy bar", 225, new Date()));
        foods.add(new Food("oreo", 50, new Date()));

        m_adapter = new HistoryAdapter(this, foods);
        m_rv.setAdapter(m_adapter);


    }
}
