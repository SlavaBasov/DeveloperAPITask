package com.vyacheslavbasovproject.developerapitask.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "developers")
@Getter @Setter @NoArgsConstructor @ToString
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min=2, max = 50)
    @Pattern(regexp = "^[a-z].+")
    @Column(unique = true, nullable = false)
    private String name;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    public Developer(String name, String email) {
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
