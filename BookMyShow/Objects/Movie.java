package BookMyShow.Objects;

public class Movie {
    int movieId;
    String name;
    int duration;

    public Movie(int movieId, String name, int duration) {
        this.movieId = movieId;
        this.name = name;
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
