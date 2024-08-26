package br.com.wsp.xlocation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "point_of_interest")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointOfInterest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "x", nullable = false)
    private Long x;

    @Column(name = "y", nullable = false)
    private Long y;
}