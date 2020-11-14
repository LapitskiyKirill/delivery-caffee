package com.gmail.kirilllapitsky.deliverycaffee.entity;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
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

    public User(String login, String password, Role role, Caffee caffee) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.caffee = caffee;
    }
}
