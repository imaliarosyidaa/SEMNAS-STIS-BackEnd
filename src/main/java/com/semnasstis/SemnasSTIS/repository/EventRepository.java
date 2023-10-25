package com.semnasstis.SemnasSTIS.repository;

import com.semnasstis.SemnasSTIS.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    public List<Event> findByTitleContainingOrTahunContainingOrTemaContaining(String title, String tahun, String tema);

}
