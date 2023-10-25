package com.semnasstis.SemnasSTIS.dto;

import com.semnasstis.SemnasSTIS.entity.EStatus;
import com.semnasstis.SemnasSTIS.entity.Participant;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EventDto {
    private Long id;
    @NotEmpty(message = "Judul Buku Wajib Diiisi")
    private String title;
    @NotNull(message = "Tahun Wajib Diiisi")
    private String tahun;
    private String tema;
    private LocalDate waktuMulai;
    private LocalDate waktuBerakhir;
    private EStatus status;
}
