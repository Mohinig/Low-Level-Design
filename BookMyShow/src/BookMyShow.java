package BookMyShow;

import BookMyShow.Controllers.MovieController;
import BookMyShow.Controllers.TheatreController;
import BookMyShow.Objects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow() {
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }

    public static void main(String[] args) {
         BookMyShow bookMyShow=new BookMyShow();
         bookMyShow.initialize();
         bookMyShow.createBooking("Bangalore","IronMan",30);
         bookMyShow.createBooking("Bangalore","Avengers",40);
    }

    private void initialize(){
        createMovie();
        createTheatre();
    }
    private void createBooking(String city,String movieName,Integer seatNo){
        List<Movie> movies=movieController.getMoviesByCity(city);
        Movie interestedMovie=null;
        for(Movie movie:movies){
            if((movie.getName()).equals(movieName)){
                interestedMovie=movie;
            }
        }
        Map<Theatre,List<Show>> theatreShowMap=theatreController.getAllShows(interestedMovie,city);
        Map.Entry<Theatre,List<Show>> entry=theatreShowMap.entrySet().iterator().next();
        List<Show> runningShows=entry.getValue();
        Show interestedShow=runningShows.get(0);

        int seat=seatNo;
        List<Integer> bookedSeats=interestedShow.getBookedSeats();
        if(!bookedSeats.contains(seat)){
            bookedSeats.add(seat);
            Booking booking=new Booking();
            List<Seat> myBookedSeats=new ArrayList<>();
            for(Seat screenSeat:interestedShow.getScreen().getSeatList()){
                if(screenSeat.getId()==seat){
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setSeatList(myBookedSeats);
            booking.setShow(interestedShow);
        }
        else{
            System.out.println("Choose some other seat");
            return;
        }
        System.out.println("Booking Successful");
    }


    private void createTheatre() {
        Movie ironManMovie=movieController.getMovieByName("IronMan");
        Movie avengerMovie=movieController.getMovieByName("Avengers");
        List<Integer> bookedTicket=new ArrayList<>();
        bookedTicket.add(1);
        Theatre inoxTheatre=new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setCity("Bangalore");
        inoxTheatre.setScreenList(createScreen());
        List<Show> inoxshowList=new ArrayList<>();
        Show inoxMorningShow1=new Show(1,ironManMovie,inoxTheatre.getScreenList().get(0),1300,bookedTicket);
        Show inoxMorningShow2=new Show(2,avengerMovie,inoxTheatre.getScreenList().get(1),1300,bookedTicket);
        Show inoxEveningShow1=new Show(3,ironManMovie,inoxTheatre.getScreenList().get(0),1700,bookedTicket);
        Show inoxEveningShow2=new Show(4,avengerMovie,inoxTheatre.getScreenList().get(0),1700,bookedTicket);
        inoxshowList.add(inoxMorningShow1);
        inoxshowList.add(inoxMorningShow2);
        inoxshowList.add(inoxEveningShow1);
        inoxshowList.add(inoxEveningShow2);
         inoxTheatre.setShowList(inoxshowList);
        Theatre pvrTheatre=new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setCity("Delhi");
        pvrTheatre.setScreenList(createScreen());
        List<Show> pvrshowList=new ArrayList<>();
        Show pvrMorningShow1=new Show(1,ironManMovie,pvrTheatre.getScreenList().get(0),1300,bookedTicket);
        Show pvrMorningShow2=new Show(2,avengerMovie,pvrTheatre.getScreenList().get(1),1300,bookedTicket);
        Show pvrEveningShow1=new Show(3,ironManMovie,pvrTheatre.getScreenList().get(0),1700,bookedTicket);
        Show pvrEveningShow2=new Show(4,avengerMovie,pvrTheatre.getScreenList().get(0),1700,bookedTicket);
        pvrshowList.add(pvrMorningShow1);
        pvrshowList.add(pvrMorningShow2);
        pvrshowList.add(pvrEveningShow1);
        pvrshowList.add(pvrEveningShow2);
        pvrTheatre.setShowList(pvrshowList);
        theatreController.addTheatre(inoxTheatre,"Bangalore");
        theatreController.addTheatre(pvrTheatre,"Delhi");


    }

    private List<Screen> createScreen() {
        Screen screen1=new Screen();
        screen1.setId(1);
        screen1.setSeatList(createSeat());
        Screen screen2=new Screen();
        screen2.setId(2);
        screen2.setSeatList(createSeat());
        List<Screen> screenList=new ArrayList<>();
        screenList.add(screen1);
        screenList.add(screen2);
        return screenList;
    }

    private List<Seat> createSeat() {
        List<Seat> seatList=new ArrayList<>();
        int row=1;
        for(int i=1;i<=50;i++){
            Seat seat=new Seat();
            seat.setSeatType(SeatType.SILVER);
            seat.setId(i);
            seat.setRow(row);
            if(i%10==0){
                row++;
            }
            seatList.add(seat);
        }
        for(int i=51;i<=80;i++){
            Seat seat=new Seat();
            seat.setSeatType(SeatType.GOLD);
            seat.setId(i);
            seat.setRow(row);
            if(i%10==0){
                row++;
            }
            seatList.add(seat);
        }
        for(int i=81;i<=100;i++){
            Seat seat=new Seat();
            seat.setSeatType(SeatType.PLATINUM);
            seat.setId(i);
            seat.setRow(row);
            if(i%10==0){
                row++;
            }
            seatList.add(seat);
        }
        return seatList;
    }

    private void createMovie(){
        Movie avengers=new Movie(1,"Avengers",180);
        Movie ironman=new Movie(2,"IronMan",120);
        movieController.addMovie(avengers,"Bangalore");
        movieController.addMovie(avengers,"Delhi");
        movieController.addMovie(ironman,"Delhi");
        movieController.addMovie(ironman,"Bangalore");
    }

}
