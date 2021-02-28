package com.example.movieadapter2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewMovieTitle;
    private TextView textViewMovieGenre;
    private TextView textViewMovieYear;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textViewMovieTitle=itemView.findViewById(R.id.title);
        this.textViewMovieGenre=itemView.findViewById(R.id.genre);
        this.textViewMovieYear=itemView.findViewById(R.id.year);
    }

    public TextView getTextViewMovieTitle() {
        return textViewMovieTitle;
    }

    public void setTextViewMovieTitle(String title) {
        this.textViewMovieTitle.setText(title);
    }

    public TextView getTextViewMovieGenre() {
        return textViewMovieGenre;
    }

    public void setTextViewMovieGenre(String genre) {
        this.textViewMovieGenre.setText(genre);
    }

    public TextView getTextViewMovieYear() {
        return textViewMovieYear;
    }

    public void setTextViewMovieYear(String year) {
        this.textViewMovieYear.setText(year);
    }

}
