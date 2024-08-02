abstract class Movie {
    String mlName;
    String flName;
    String movieName;
    double rating;
    int budget;

    Movie(String mlName, String flName, String movieName, double rating, int budget) {
        this.mlName = mlName;
        this.flName = flName;
        this.movieName = movieName;
        this.rating = rating;
        this.budget = budget;
    }

    abstract String getGenre();
    abstract String getElement();

    String getMovieDetails() {
        return "Movie: " + movieName + "\nMale Lead: " + mlName + "\nFemale Lead: " + flName +
               "\nRating: " + rating + "\nBudget(cr): " + budget + "\nGenre: " + getGenre() + 
               "\nElement: " + getElement();
    }
}

class RomComMovie extends Movie {
    String element;

    RomComMovie(String mlName, String flName, String movieName, double rating, int budget, String element) {
        super(mlName, flName, movieName, rating, budget);
        this.element = element;
    }

    @Override
    String getGenre() {
        return "Romantic Comedy";
    }

    @Override
    String getElement() {
        return element;
    }
}

class ThrillerMovie extends Movie {
    String element;

    ThrillerMovie(String mlName, String flName, String movieName, double rating, int budget, String element) {
        super(mlName, flName, movieName, rating, budget);
        this.element = element;
    }

    @Override
    String getGenre() {
        return "Thriller";
    }

    @Override
    String getElement() {
        return element;
    }
}
public class MovieHierarchy {
    public static void main(String[] args) {
        Movie romComMovie = new RomComMovie("Dhanush", "Shreya", "Kutti", 8.5, 50, "Light-hearted moments");
        Movie thrillerMovie = new ThrillerMovie("Vikram", "Priya", "Chase", 9.0, 70, "Suspense and twists");

        System.out.println(romComMovie.getMovieDetails());
        System.out.println(thrillerMovie.getMovieDetails());
    }
}
