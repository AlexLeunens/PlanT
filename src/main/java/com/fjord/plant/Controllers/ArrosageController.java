package com.fjord.plant.Controllers;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fjord.plant.Model.Event;
import com.fjord.plant.Services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArrosageController {

    @Autowired
    EventService eventService;

    @GetMapping("/arrosage/events")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public @ResponseBody Iterable<Event> events(@RequestParam("start") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime end) {

        return eventService.findBetween(start, end);
    }


    @PostMapping("/arrosage/events/create")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    public @ResponseBody Event createEvent(@RequestBody EventCreateParams params) {

        Event e = new Event();
        e.setStart(params.start);
        e.setEnd(params.end);
        e.setText(params.text);
        eventService.save(e);

        return e;
    }

    @PostMapping("/arrosage/events/move")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    public @ResponseBody Event moveEvent(@RequestBody EventMoveParams params) {

        Event e = eventService.findOne(params.id);
        e.setStart(params.start);
        e.setEnd(params.end);
        eventService.save(e);

        return e;
    }

    @PostMapping("/arrosage/events/setColor")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    public @ResponseBody Event setColor(@RequestBody SetColorParams params) {

        Event e = eventService.findOne(params.id);
        e.setColor(params.color);
        eventService.save(e);

        return e;
    }

    @PostMapping("/arrosage/events/delete")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    public @ResponseBody EventDeleteResponse deleteEvent(@RequestBody EventDeleteParams params) {

        eventService.delete(params.id);

        return new EventDeleteResponse() {{
            message = "Deleted";
        }};
    }

    public static class EventDeleteParams {
        public Integer id;
    }

    public static class EventDeleteResponse {
        public String message;
    }

    public static class EventCreateParams {
        public LocalDateTime start;
        public LocalDateTime end;
        public String text;
    }

    public static class EventMoveParams {
        public Integer id;
        public LocalDateTime start;
        public LocalDateTime end;
    }

    public static class SetColorParams {
        public Integer id;
        public String color;
    }

}