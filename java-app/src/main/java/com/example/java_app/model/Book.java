package com.example.java_app.model;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final String year;
    private final String summary;
    private final String imageUrl;

    // Constructor
    public Book(int id, String title, String author, String year, String summary, String imageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.summary = summary;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getYear() { return year; }
    public String getSummary() { return summary; }
    public String getImageUrl() { return imageUrl; }
}