package com.example.animaladapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends ArrayAdapter<Animal> {
    private ArrayList<Animal> animalList = new ArrayList();

    public AnimalAdapter(Context context, int resource, ArrayList<Animal> objects) {
        super(context, resource, objects);
        this.animalList = objects;
    }


    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.animal, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView3);
        textView.setText(animalList.get(position).getName());
        imageView.setImageResource(animalList.get(position).getImageView());


        return convertView;
    }
}
