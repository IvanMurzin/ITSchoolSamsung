package ru.ivanmurzin.listview;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class MyListActivity extends ListActivity {

    String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октярь", "Ноябрь", "Декабрь", "!!!", "!!!", "!!!", "!!!", "!!!", "!!!", "!!!", "!!!"};

    MyAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        arrayAdapter = new MyAdapter(
                this,
                R.layout.list_item,
                months
        );
        setListAdapter(arrayAdapter);
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, (String) getListAdapter().getItem(position), Toast.LENGTH_SHORT).show();
        months[position] += " C: ";
        arrayAdapter.notifyDataSetChanged();
    }


    class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(@NonNull Context context, int resource, String[] data) {
            super(context, resource, data);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
            if (view == null)
                view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
            ((TextView) view.findViewById(R.id.month)).setText(getItem(position));
            ((TextView) view.findViewById(R.id.temp)).setText(new Random().nextInt(10)+"");
            ((CheckBox) view.findViewById(R.id.checkbox)).setChecked(new Random().nextBoolean());
            return view;
        }
    }
}