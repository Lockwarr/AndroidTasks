package com.example.movieadapter2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder>  {
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context=parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View movieView = inflater.inflate(R.layout.rowlayout,parent,false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(movieView);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final Movie movie = movieList.get(position);
        holder.setTextViewMovieTitle(movie.getTitle());
        holder.setTextViewMovieGenre(movie.getGenre());
        holder.setTextViewMovieYear(movie.getYear().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, movie.getTitle() +", "+movie.getGenre() +", "+movie.getYear(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }


}
