package org.example.dea2.entity;

// Importing necessary packages and classes
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Generates getters, setters, toString, equals, and hashCode methods using Lombok
@AllArgsConstructor  // Generates a constructor with all fields using Lombok
@NoArgsConstructor  // Generates a no-argument constructor using Lombok
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Specifies that the primary key is auto-incremented by the database
    private Long id;

    private String name;

    @Lob
    @Column(length = 1000000000)
    private byte[] data;

    // Constructors, getters, and setters
}
