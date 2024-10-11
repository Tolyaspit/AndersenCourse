package com.andersen.course;

import com.andersen.course.model.NewTicket;
import com.andersen.course.model.NewUser;
import com.andersen.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.andersen.course.repository.TicketRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.andersen.course.model"})
public class TicketsApp {

    public static void main(String[] args) {
        SpringApplication.run(TicketsApp.class, args);
    }
}
