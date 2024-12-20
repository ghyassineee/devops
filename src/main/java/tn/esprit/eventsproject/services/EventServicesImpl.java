package tn.esprit.eventsproject.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.eventsproject.dao.Event;
import tn.esprit.eventsproject.repositories.EventRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EventServicesImpl implements IEventServices{
    private final EventRepository eventRepository;

    @Override
    public List<Event> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event addEvent(Event event) {


        return eventRepository.save(event);
    }

    @Override
    public void removeEvent(Integer idEvent) {
        eventRepository.deleteById(idEvent);
    }
    @Override
    public Event modifyEvent(Event c) {
        return eventRepository.save(c);
    }
    @Override
    public Event retrieveEvent(Integer idEvent) {
        return eventRepository.findById(idEvent).orElseThrow(() -> new EntityNotFoundException("Event not found with ID: " + idEvent));
    }

}

