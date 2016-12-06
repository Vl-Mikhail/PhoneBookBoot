package ru.misha.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;
    private String name;

    @ManyToOne
    private City city;

    @ManyToOne
    private Street street;

    private String phone;

   //Lombo: Constuructor, Getter, Setter, hashCode, Equals

}
