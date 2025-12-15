package BookMyShow.Controllers;

import BookMyShow.Objects.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<String, List<Movie>> cityMovieList;
    List<Movie> allMovies;

    public MovieController() {
        this.cityMovieList = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, String city) {
        allMovies.add(movie);
        List<Movie> movies=cityMovieList.getOrDefault(city,new ArrayList<>());
        movies.add(movie);
        cityMovieList.put(city,movies);
    }
    public Movie getMovieByName(String movieName){
        for(Movie movie:allMovies){
            if((movie.getName()).equals(movieName)){
                return movie;
            }
        }
        return null;
    }
    public List<Movie> getMoviesByCity(String city){
        return cityMovieList.get(city);
    }
}
