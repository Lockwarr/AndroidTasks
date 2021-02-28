package com.example.movieadapter2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = this.findViewById(R.id.recycler_view);
        MovieAdapter movieAdapter = new MovieAdapter(createMovieList());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Movie> createMovieList() {
        List<Movie> movieList =  new LinkedList<>();

        Movie movie1 = new Movie("Film1","Title1",2001);
        Movie movie2 = new Movie("Film2","Title2",2002);
        Movie movie3 = new Movie("Film3","Title3",2003);
        Movie movie4 = new Movie("Film4","Title4",2004);
        Movie movie5 = new Movie("Film5","Title5",2005);
        Movie movie6 = new Movie("Film6","Title6",2006);
        Movie movie7 = new Movie("Film7","Title7",2007);
        Movie movie8 = new Movie("Film8","Title8",2008);
        Movie movie9 = new Movie("Film9","Title9",2009);


        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);
        movieList.add(movie5);
        movieList.add(movie6);
        movieList.add(movie7);
        movieList.add(movie8);
        movieList.add(movie9);


        return movieList;
    }
}
