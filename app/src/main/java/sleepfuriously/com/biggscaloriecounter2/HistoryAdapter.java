package sleepfuriously.com.biggscaloriecounter2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 1/23/19.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    //----------------------
    //  constants
    //----------------------

    //----------------------
    //  data
    //----------------------

    /** the main data for this Adapter */
    private List<Food> m_foods;

    private Context m_ctx;

    //----------------------
    //  methods
    //----------------------

    public HistoryAdapter (@NonNull Context ctx, @NonNull List<Food> startFood) {
        m_foods = startFood;
        m_ctx = ctx;
    }


    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        HistoryViewHolder newViewHolder = new HistoryViewHolder(v);
        return newViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        Food food = m_foods.get(position);
        holder.name_tv.setText(food.name);
        holder.cals_tv.setText(Integer.toString(food.cals));

        String date_str = SimpleDateFormat.getDateInstance().format(food.date);
        holder.date_tv.setText(date_str);
    }

    @Override
    public int getItemCount() {
        return m_foods.size();
    }


    //----------------------
    //  Classes
    //----------------------

    class HistoryViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "HistoryViewHolder";

        TextView name_tv, cals_tv,date_tv;
        ImageButton menu_ib;


        public HistoryViewHolder(View itemView) {
            super(itemView);

            name_tv = itemView.findViewById(R.id.name_tv);
            cals_tv = itemView.findViewById(R.id.calories_tv);
            menu_ib = itemView.findViewById(R.id.more_ib);
            date_tv = itemView.findViewById(R.id.date_tv);

            menu_ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu menu = new PopupMenu(m_ctx, menu_ib);
                    MenuInflater inflater = menu.getMenuInflater();
                    inflater.inflate(R.menu.kabab_menu, menu.getMenu());

                    menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.menu_copy:
                                    Log.v(TAG, "menu copy");
                                    break;

                                case R.id.menu_delete:
                                    Log.v(TAG, "menu delete");
                                    break;

                                case R.id.menu_edit:
                                    Log.v(TAG, "menu edit");
                                    break;

                                default:
                                    Log.e(TAG, "Unknown menu selection!");
                                    break;
                            }

                            return true;    // click completely consumed
                        }
                    });
                    menu.show();
                }
            });
        }
    }


}
