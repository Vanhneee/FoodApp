package com.example.foobapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foobapp.Activity.ShowDetailActivity;
import com.example.foobapp.Domain.FoodDomain;
import com.example.foobapp.R;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    ArrayList<FoodDomain> RecommendedDomains;

    public RecommendedAdapter(ArrayList<FoodDomain> recommendedDomains) {
        this.RecommendedDomains = recommendedDomains  ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.viewholder_recommended , parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(RecommendedDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(RecommendedDomains.get(position).getFee()));



         @SuppressLint("DiscouragedApi") int drawabResourceId = holder.itemView.getContext().getResources()
                 .getIdentifier(RecommendedDomains.get(position).getPic(),"drawable",
                         holder.itemView.getContext().getPackageName());

         Glide.with(holder.itemView.getContext())
                .load(drawabResourceId)
                .into(holder.pic);

         holder.addBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                 intent.putExtra("object", RecommendedDomains.get(position));
                 holder.itemView.getContext().startActivity(intent);
             }
         });
    }


    @Override
    public int getItemCount() {
        return RecommendedDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,fee;
        ImageView pic;
        ImageView addBtn;
//        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
