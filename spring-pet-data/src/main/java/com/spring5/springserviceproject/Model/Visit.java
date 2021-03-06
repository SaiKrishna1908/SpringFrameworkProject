package com.spring5.springserviceproject.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

    @Column(name = "date")
    private LocalDate localDate;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Override
    public String toString() {
        return "Visit{" +
                "localDate=" + localDate +
                '}';
    }
}
