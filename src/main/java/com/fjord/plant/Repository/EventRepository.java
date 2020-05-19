package com.fjord.plant.Repository;

import java.time.LocalDateTime;
import java.util.List;

import com.fjord.plant.Model.Event;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    @Query("from Event e where not(e.end < :from or e.start > :to)")
    public List<Event> findBetween(@Param("from") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime start,
            @Param("to") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime end);

}