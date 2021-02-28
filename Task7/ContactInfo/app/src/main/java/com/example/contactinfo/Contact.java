package com.example.contactinfo;

public class Contact {
    private String name;
    private String address;
    private String imageUrl;

    public Contact(String name, String address, String imageUrl) {
        this.name = name;
        this.address = address;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
