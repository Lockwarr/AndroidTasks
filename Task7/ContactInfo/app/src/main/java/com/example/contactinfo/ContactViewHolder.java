package com.example.contactinfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


public class ContactViewHolder extends RecyclerView.ViewHolder{
    private ImageView image;
    private TextView name;
    private TextView type;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.textView3);
        type = itemView.findViewById(R.id.textView4);
    }

    public void setImage(String url) {
        Picasso.get().load(url).placeholder(R.drawable.contact_icon2).resize(100, 100).into(image);

    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setType(String type) {
        this.type.setText(type);
    }
}
