/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment8_classesobject;

/**
 * 4. Create a Movie DTO class
 * Movie Data Transfer Object (DTO) class.
 * Provides a representation of movie information with appropriate access modifiers.
 */
public class MovieDTO {
    private String title;
    private String director;
    private String genre;
    private int releaseYear;
    private double rating;
    private int duration;

    private static final String DEFAULT_GENRE = "Unknown Genre";
    private static final double DEFAULT_RATING = 0.0;
    private static final int DEFAULT_DURATION = 0;

    public MovieDTO() {
        this.genre = DEFAULT_GENRE;
        this.rating = DEFAULT_RATING;
        this.duration = DEFAULT_DURATION;
    }

    public MovieDTO(String title, String director, String genre, int releaseYear, double rating, int duration) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static String getDefaultGenre() {
        return DEFAULT_GENRE;
    }


    public static double getDefaultRating() {
        return DEFAULT_RATING;
    }

    public static int getDefaultDuration() {
        return DEFAULT_DURATION;
    }

    public String getMovieDetails() {
        return "Movie Details:\n" +
               "Title: " + title + "\n" +
               "Director: " + director + "\n" +
               "Genre: " + genre + "\n" +
               "Release Year: " + releaseYear + "\n" +
               "Rating: " + String.format("%.1f", rating) + "\n" +
               "Duration: " + duration + " minutes";
    }

    public static void main(String[] args) {
        MovieDTO movie1 = new MovieDTO("Inception", "Christopher Nolan", "Sci-Fi", 2010, 8.8, 148);
        MovieDTO movie2 = new MovieDTO("The Godfather", "Francis Ford Coppola", "Crime", 1972, 9.2, 175);

        MovieDTO defaultMovie = new MovieDTO();

        /*System.out.println("Default Genre: " + MovieDTO.getDefaultGenre());
        System.out.println("Default Release Year: " + MovieDTO.getDefaultReleaseYear());
        System.out.println("Default Rating: " + MovieDTO.getDefaultRating());
        System.out.println("Default Duration: " + MovieDTO.getDefaultDuration());
        System.out.println();
        */
        
        System.out.println(movie1.getMovieDetails());
        System.out.println();
        System.out.println(movie2.getMovieDetails());
        System.out.println();
        System.out.println(defaultMovie.getMovieDetails());
    }
}
