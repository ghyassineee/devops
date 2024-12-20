package tn.esprit.eventsproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.eventsproject.dao.Event;
import tn.esprit.eventsproject.services.IEventServices;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("event")
@RestController
public class EventRestController {
    private final IEventServices eventService;

    @GetMapping("/retrieve-all-Events")
    public List<Event> getEvents() {
        return eventService.retrieveAllEvents();

    }


    @GetMapping("/retrieve-Event/{Event-id}")
    public Event retrieveEvent(@PathVariable("Event-id") Integer chId) {
        return eventService.retrieveEvent(chId);

    }

    @PostMapping("/add-Event")
    public Event addEvent(@RequestBody Event e) {
        return eventService.addEvent(e);

    }

    @DeleteMapping("/remove-Event/{Event-id}")
    public void removeEvent(@PathVariable("Event-id") Integer chId) {
        eventService.removeEvent(chId);
    }

    @PutMapping("/modify-Event")
    public Event modifyEvent(@RequestBody Event e) {
        return eventService.modifyEvent(e);

    }
}
