package com.sd.controllers;

import com.sd.enums.City;
import com.sd.models.movies.Movie;
import com.sd.models.theatre.Show;
import com.sd.models.theatre.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityVsTheatre;
    // Nagpur → [PVR, INOX]
    // Mumbai → [Cinepolis, Carnival]

    List<Theatre> allTheatre;
    //allTheatre = [PVR, INOX, Cinepolis, Carnival]

    public TheatreController() {
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        allTheatre.add(theatre);

        List<Theatre> theatreList = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatreList.add(theatre);
        cityVsTheatre.put(city, theatreList);
    }

    public Map<Theatre, List<Show>> getAllShows(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreVsShows  = new HashMap<>();

        List<Theatre> theatres = cityVsTheatre.get(city); // Get all theatres in this city

        for (Theatre theatre : theatres) {  // Loop through each theatre
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();

            for (Show show : shows) { // Loop through each show in that theatre
                if (show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);  // If the show belongs to the movie, add it
                }
            }

            if (!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows); // Store only theatres that have this movie's shows
            }
        }
        return theatreVsShows;
    }
}
