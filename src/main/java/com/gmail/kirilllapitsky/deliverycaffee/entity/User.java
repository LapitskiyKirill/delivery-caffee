package com.gmail.kirilllapitsky.deliverycaffee.entity;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
