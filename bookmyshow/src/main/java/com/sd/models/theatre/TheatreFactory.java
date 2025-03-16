package com.sd.models.theatre;

import com.sd.enums.City;

import java.util.ArrayList;
import java.util.List;

public class TheatreFactory {

    public static Theatre createTheatre(int theatreId, String name, City city, List<Show> shows) {
        Theatre theatre = new Theatre();
        theatre.setTheatreId(theatreId);
        theatre.setTheatreName(name);
        theatre.setScreen(createScreens());
        theatre.setCity(city);
        theatre.setShows(shows);
        return theatre;
    }

    public static List<Screen> createScreens() {
        Screen screen = new Screen();
        screen.setScreenId(1);
        screen.setSeats(createSeats());
        return List.of(screen);
    }

    public static List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for(int i=0;i<100;i++){
            seats.add(new Seat());
        }
        return seats;
    }
}
