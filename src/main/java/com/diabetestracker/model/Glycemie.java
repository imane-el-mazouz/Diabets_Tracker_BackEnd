package com.diabetestracker.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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

    private String mealTime;
    private String source;

    public Glycemie(Double value, LocalDateTime date, String unit) {
        this.value = value;
        this.date = date;
//        this.level = level;
        this.unit = unit;
    }

    public Glycemie(Long id, Double value, String unit, LocalDateTime date, String mealTime , String source) {
        this.id = id;
        this.value = value;
        this.unit = unit;
        this.date = date;
        this.mealTime = mealTime;
        this.source = source;
    }
}
