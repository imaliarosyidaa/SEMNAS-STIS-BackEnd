package com.semnasstis.SemnasSTIS.service;

import com.semnasstis.SemnasSTIS.dto.EventDto;
import com.semnasstis.SemnasSTIS.entity.Event;

import java.util.List;

public interface EventService {
    public void createEvent(EventDto eventDto);
    public List<EventDto> getEvents();
    public List<EventDto> searchEvents(String keyword);
}
