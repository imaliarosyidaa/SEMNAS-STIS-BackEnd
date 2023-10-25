package com.semnasstis.SemnasSTIS.service;

import com.semnasstis.SemnasSTIS.dto.EventDto;
import com.semnasstis.SemnasSTIS.entity.Event;
import com.semnasstis.SemnasSTIS.mapper.EventMapper;
import com.semnasstis.SemnasSTIS.repository.EventRepository;
import com.semnasstis.SemnasSTIS.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ParticipantRepository memberRepository;

    @Override
    public void createEvent(EventDto eventDto) {
        eventRepository.save(EventMapper.mapToEvent(eventDto));
    }
    @Override
    public List<EventDto> getEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDto> eventDtos = events.stream()
                .map((product) -> (EventMapper.mapToEventDto(product)))
                .collect(Collectors.toList());
        return eventDtos;
    }

    @Override
    public List<EventDto> searchEvents(String keyword) {
        List<Event> events;
        if (keyword.length() == 0) {
            events = eventRepository.findAll();
        } else {
            events = eventRepository.findByTitleContainingOrTahunContainingOrTemaContaining(keyword, keyword, keyword);
        }
        List<EventDto> eventDtos = events.stream()
                .map((product) -> (EventMapper.mapToEventDto(product)))
                .collect(Collectors.toList());
        return eventDtos;
    }
}
