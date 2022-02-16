package com.vyacheslavbasovproject.developerapitask.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "developers")
@Getter @Setter @NoArgsConstructor
@ToString
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min=2, max = 50)
    @Pattern(regexp = "^[a-zA-Z].+", message = "It must be name starting with a letter of the alphabet")
    @Column(unique = true, nullable = false)
    private String name;

    @Email(message = "It must be a valid email address")
    @Column(unique = true, nullable = false)
    private String email;

    public Developer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Developer(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Developer developer = (Developer) o;
        return id != null && Objects.equals(id, developer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
