package tn.esprit.eventsproject.services;

import tn.esprit.eventsproject.dao.Event;

import java.util.List;

public interface IEventServices {

    Event addEvent(Event event);

    Event modifyEvent(Event c);

    void removeEvent(Integer idEvent);

    Event retrieveEvent(Integer idEvent);
    List<Event> retrieveAllEvents();
}