package BookMyShow.Controllers;

import BookMyShow.Objects.Movie;
import BookMyShow.Objects.Show;
import BookMyShow.Objects.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<String, List<Theatre>> cityTheatreList;
    List<Theatre> theatreList;

    public TheatreController() {
        this.cityTheatreList = new HashMap<>();
        this.theatreList = new ArrayList<>();
    }
    public void addTheatre(Theatre theatre,String city){
        theatreList.add(theatre);
        List<Theatre> theatres=cityTheatreList.getOrDefault(city,new ArrayList<>());
        theatres.add(theatre);
        cityTheatreList.put(city,theatres);
    }
    public Map<Theatre,List<Show>> getAllShows(Movie movie, String city){
        Map<Theatre,List<Show>> theatreShowMap=new HashMap<>();
        List<Theatre> theatres=cityTheatreList.get(city);
        for(Theatre theatre:theatres){
            List<Show> shows=theatre.getShowList();
            theatreShowMap.put(theatre,shows);
        }
        return  theatreShowMap;
    }
}
