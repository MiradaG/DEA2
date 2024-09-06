package org.example.dea2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity  // Specifies that this class is a JPA entity, representing a table in the database
@Data  // Lombok annotation to automatically generate getters, setters, toString, equals, and hashCode methods
public class FeedbackEntity {

    @Id  // Marks this field as the primary key for the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Specifies that the primary key will be generated automatically by the database
    private int id;

    private String feedback;

    private int userId;

    private String userName;

    private int starValue;
}
