package com.sd;

import com.sd.services.BookingService;

public class Main {
    public static void main(String[] args) {

        BookingService bookService = BookingService.getInstance(); //Use a Singleton Pattern
        bookService.initialize();
        bookService.startBookingSession();
    }
}