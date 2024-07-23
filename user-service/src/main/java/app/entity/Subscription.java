package app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subscription")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(length = 6)
    private float price;

    private String description;

    @OneToMany
    private List<User> users;
}
