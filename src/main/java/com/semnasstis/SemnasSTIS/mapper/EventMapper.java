package com.semnasstis.SemnasSTIS.mapper;

import com.semnasstis.SemnasSTIS.dto.EventDto;
import com.semnasstis.SemnasSTIS.entity.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto){
        return Event.builder()
                .id(eventDto.getId())
                .title(eventDto.getTitle())
                .tema(eventDto.getTema())
                .tahun(eventDto.getTahun())
                .waktuMulai(eventDto.getWaktuMulai())
                .waktuBerakhir(eventDto.getWaktuBerakhir())
                .status(eventDto.getStatus())
                .build();
    }
    public static EventDto mapToEventDto(Event event){
        return EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .tema(event.getTema())
                .tahun(event.getTahun())
                .waktuMulai(event.getWaktuMulai())
                .waktuBerakhir(event.getWaktuBerakhir())
                .status(event.getStatus())
                .build();
    }
}
