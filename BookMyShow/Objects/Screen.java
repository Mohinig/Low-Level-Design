package BookMyShow.Objects;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int id;
    List<Seat> seatList=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
