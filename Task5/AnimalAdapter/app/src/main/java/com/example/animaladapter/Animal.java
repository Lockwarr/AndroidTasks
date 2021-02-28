package com.example.animaladapter;

public class Animal {
    String name;
    int imageView;

    public Animal(String name, int imageView) {
        this.name = name;
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
