package com.example.appmusicv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Model.Kind;
import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListCategorybySubjectAdapter extends RecyclerView.Adapter<ListCategorybySubjectAdapter.ViewHolder> {
    Context context;
    ArrayList<Kind> array_kind;


    public ListCategorybySubjectAdapter(Context context, ArrayList<Kind> array_kind) {
        this.context = context;
        this.array_kind = array_kind;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_categorybysubject, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Kind kind = array_kind.get(position);
        Picasso.get().load(kind.getImageKind()).into(holder.img);
        holder.txtNameKind.setText(kind.getNameKind());

    }

    @Override
    public int getItemCount() {
        return array_kind.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtNameKind, txtNameSinger;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageviewCategorybySubject);
            txtNameKind = itemView.findViewById(R.id.textviewCategoryBysubject);
            txtNameSinger = itemView.findViewById(R.id.textviewNameSingerCategoryBySubject);
        }
    }
}
