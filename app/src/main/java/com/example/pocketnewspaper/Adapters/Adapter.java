package com.example.pocketnewspaper.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocketnewspaper.Model.ModelClass;
import com.example.pocketnewspaper.R;
import com.example.pocketnewspaper.WebView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    Context context;
    ArrayList<ModelClass> list;

    public Adapter(Context context, ArrayList<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout,null,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(context,WebView.class);
               intent.putExtra("url",list.get(position).getUrl());
               context.startActivity(intent);
            }
        });

        holder.mtime.setText("Published At:-"+list.get(position).getPublishedAt());
        holder.mauthor.setText(list.get(position).getAuthor());
        holder.mheading.setText(list.get(position).getTitle());
        holder.mcontent.setText(list.get(position).getDescription());
        Picasso.get().load(list.get(position).getUrlToImage()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mheading=itemView.findViewById(R.id.title);
            mcontent=itemView.findViewById(R.id.desc);
            mauthor=itemView.findViewById(R.id.author);
            mtime=itemView.findViewById(R.id.time);
            cardView=itemView.findViewById(R.id.cardview);
            imageView=itemView.findViewById(R.id.imgview);
        }
    }
}
