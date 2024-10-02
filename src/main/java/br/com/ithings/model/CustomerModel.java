package br.com.ithings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor; /*lombok serve para facilitar a criação de classes*/
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity /*vai ter uma recrutação no BD*/
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    @Column(length = 1, nullable = false)
    private String gender;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityModel city;

}
