package com.gmail.kirilllapitsky.entity;

import com.gmail.kirilllapitsky.enumerable.Role;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "caffee_id")
    private Caffee caffee;
}
