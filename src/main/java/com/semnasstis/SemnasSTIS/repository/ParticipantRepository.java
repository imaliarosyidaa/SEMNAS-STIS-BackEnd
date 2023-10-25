package com.semnasstis.SemnasSTIS.repository;

import com.semnasstis.SemnasSTIS.entity.Participant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "participant", path = "participant")
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long>, CrudRepository<Participant, Long> {
    List<Participant> findByName(@Param("name") String name);
    @Query("SELECT m FROM Participant m WHERE m.participantID = :participant_id")
    List<Participant> findByParticipantID(@Param("participant_id") String participant_id);
}
