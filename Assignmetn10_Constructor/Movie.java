/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment9_constructor;

/**
 *
 * @author priya
 */
public class Movie {
    private String title;
    private String director;
    private String genre;
    private int year;
    private double rating;

    public Movie(String title, String director, String genre, int year, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMovieDetails() {
        return "Movie Details:\n" +
               "Title: " + title + "\n" +
               "Director: " + director + "\n" +
               "Genre: " + genre + "\n" +
               "Year: " + year + "\n" +
               "Rating: " + rating;
    }

    public static void main(String[] args) {
        Movie[] movies = new Movie[3];
        movies[0] = new Movie("Baahubali: The Beginning", "S. S. Rajamouli", "Action", 2015, 8.0);
        movies[1] = new Movie("Karnan", "Mari Selvaraj", "Drama", 2021, 8.2);
        movies[2] = new Movie("Master", "Lokesh Kanagaraj", "Action", 2021, 7.8);

        for (Movie movie : movies) {
            System.out.println(movie.getMovieDetails());
            System.out.println();
        }
    }
}
