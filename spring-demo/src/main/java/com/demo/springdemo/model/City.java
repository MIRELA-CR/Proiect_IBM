package com.demo.springdemo.model;

import lombok.*;
import org.aspectj.lang.annotation.control.CodeGenerationHint;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_city")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "totalMuseums")
    private int totalMuseums;

}

