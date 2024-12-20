
package tn.esprit.eventsproject.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.eventsproject.dao.Event;
import tn.esprit.eventsproject.repositories.EventRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EventServicesImplTest {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventServicesImpl eventService;

    @Test
    @Order(1)
    void addEvent() {
        Event Event = new Event();
        Event.setDescription("desc");

        Event savedEvent = eventService.addEvent(Event);
        assertNotNull(savedEvent);
        assertEquals("desc", savedEvent.getDescription());
        System.out.println("Add Event: Ok");
    }

    @Test
    @Order(2)
    void retrieveAllEvents() {
        List<Event> Events = eventService.retrieveAllEvents();
        assertNotNull(Events);
        assertFalse(Events.isEmpty());
        System.out.println("Retrieve All Events: Ok");
    }

    @Test
    @Order(3)
    void retrieveEvent() {
        Event Event = eventService.retrieveEvent(1); // Adjust ID as necessary
        assertNotNull(Event);
        assertEquals("desc", Event.getDescription()); // Adjust based on your data
        System.out.println("Retrieve Event: Ok");
    }

    @Test
    @Order(4)
    void removeEvent() {
        eventService.removeEvent(1); // Adjust ID as necessary
        assertThrows(EntityNotFoundException.class, () -> eventService.retrieveEvent(1));
        System.out.println("Remove Event: Ok");
    }

    @Test
    @Order(5)
    void modifyEvent() {
        Event Event = new Event();
        Event.setIdEvent(1); // Adjust based on your data
        Event.setDescription("desc");

        Event updatedEvent = eventService.modifyEvent(Event);
        assertNotNull(updatedEvent);
        assertEquals("desc", updatedEvent.getDescription());
        System.out.println("Modify Event: Ok");
    }


}