package com.ss.springpos.entity;

import java.util.Set;

import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
}
