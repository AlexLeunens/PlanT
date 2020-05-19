package com.fjord.plant.Services;

import java.time.LocalDateTime;
import java.util.List;

import com.fjord.plant.Model.Event;
import com.fjord.plant.Repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findBetween(@DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime start,
            @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime end) {
        return eventRepository.findBetween(start, end);
    }

	public void delete(Integer id) {
        eventRepository.deleteById(id);
	}

	public void save(Event event) {
        eventRepository.save(event);
	}

	public Event findOne(Integer id) {
		return eventRepository.findById(id).orElse(null);
    }
    
    public List<Event> findTodayEvents(){
        LocalDateTime today = LocalDateTime.now().minusDays(1);
        LocalDateTime tomorrow = today.plusDays(1);

        return eventRepository.findBetween(today, tomorrow);
    }

}