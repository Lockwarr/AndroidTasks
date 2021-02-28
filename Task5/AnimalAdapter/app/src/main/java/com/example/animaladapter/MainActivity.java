package com.example.animaladapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);


        Animal animal1 = new Animal("dog", R.drawable.dog);
        Animal animal2 = new Animal("cat", R.drawable.cat);
        Animal animal3 = new Animal("fox", R.drawable.fox);
        Animal animal4 = new Animal("sheep", R.drawable.sheep);
        Animal animal5 = new Animal("snake", R.drawable.snake);

        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        animalList.add(animal5);

        AnimalAdapter animalAdapter = new AnimalAdapter(this,R.layout.animal, animalList);
        listView.setAdapter(animalAdapter);
    }
}
