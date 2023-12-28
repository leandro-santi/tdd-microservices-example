package com.example.tdd;

import com.example.tdd.models.BookingModel;
import com.example.tdd.repository.BookingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.tdd.service.BookingService;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    /*
    TDD flow ->
        Write a test
        Fail this test
        Fix the test
        Repeat
    */

    @TestConfiguration
    static class BookingServiceTestConfiguration {

        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }

    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookTestServiceDaysCalculator() {
        String name = "Leandro";
        int days = bookingService.daysCalculatorWithDatabase(name);

        Assertions.assertEquals(days, 10);
    }

    @Before // Method is executed before anything
    public void setup() {
        LocalDate checkIn = LocalDate.parse("2023-12-20");
        LocalDate checkOut = LocalDate.parse("2023-12-30");
        BookingModel bookingModel = new BookingModel("1", "Leandro", checkIn, checkOut, 2);

        Mockito.when(bookingRepository.findBookingModelByReserveName(bookingModel.getReserveName())).
                thenReturn(Optional.of(bookingModel));
    }

}