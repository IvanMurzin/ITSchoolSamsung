package ru.ivanmurzin.rickandmorty.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ru.ivanmurzin.rickandmorty.R;
import ru.ivanmurzin.rickandmorty.model.CharacterData;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    ArrayList<CharacterData> data;

    public MyAdapter(ArrayList<CharacterData> data) {
        this.data = data;
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView status;
        ImageView image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            status = itemView.findViewById(R.id.status);
            image = itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        CharacterData character = data.get(position);
        holder.name.setText((character.name.length() > 16) ? character.name.substring(0, 13) + "..." : character.name);
        holder.status.setText(character.status);
        Picasso.get().load(character.image).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
