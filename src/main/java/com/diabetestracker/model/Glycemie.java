package com.diabetestracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Glycemie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
//    @Enumerated(EnumType.STRING)
//    private Level level;
    private String unit;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    public Glycemie(Double value, LocalDateTime date, String unit) {
        this.value = value;
        this.date = date;
//        this.level = level;
        this.unit = unit;
    }
}
