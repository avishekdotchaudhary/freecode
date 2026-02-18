package com.abhi.freecode.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue
    private Integer id;
    private String bio;
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    public StudentProfile() {

    }

    public StudentProfile(Builder builder){
        this.id = builder.id;
        this.bio = builder.bio;
    }

    public static class Builder{
        private Integer id;
        private String bio;

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder bio(String bio){
            this.bio = bio;
            return this;
        }

        public StudentProfile Build(){
            return new StudentProfile(this);
        }
    }
}
