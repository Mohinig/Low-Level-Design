package BookMyShow.Objects;

import java.util.List;

public class Show {
    int id;
    Movie movieName;
    Screen screen;
    int startTime;
    List<Integer> bookedSeats;

    public Show(int id, Movie movieName, Screen screen, int startTime,List<Integer> bookedSeats) {
        this.id = id;
        this.movieName = movieName;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeats=bookedSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovieName() {
        return movieName;
    }

    public void setMovieName(Movie movieName) {
        this.movieName = movieName;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
