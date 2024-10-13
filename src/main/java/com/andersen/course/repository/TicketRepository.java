package com.andersen.course.repository;

import com.andersen.course.model.NewTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<NewTicket,Integer> {
}
