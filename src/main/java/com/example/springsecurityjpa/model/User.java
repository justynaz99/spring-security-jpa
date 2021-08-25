package com.example.springsecurityjpa.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String name;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;


}
