package com.sd.models.movies;

import java.util.HashMap;
import java.util.Map;

public class MovieFactory {
    // Step 1: Create a static cache (map) to store movie objects
    private static final Map<String, Movie> movieCache = new HashMap<>();

    // Step 2: Factory method to create or return existing movie object
    public static Movie createMovie(int id,String name, int duration) {
        return movieCache.computeIfAbsent(  // Check if the movie exists in cache
                String.valueOf(id),            // Convert id to string (key for the map)
                k -> new Movie(id, name, duration)  // Create a new movie if not in cache
        );
    }
}
