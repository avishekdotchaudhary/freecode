package com.abhi.freecode.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class School {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "school")
    @JsonManagedReference //It says no need to serialize the child which is child, to avoid infinite recursion during JSON serialization
    private List<Student> students;
    public School() {

    }

    public School(String name) {
        this.name = name;
    }
}
