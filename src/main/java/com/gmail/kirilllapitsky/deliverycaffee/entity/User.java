package com.gmail.kirilllapitsky.deliverycaffee.entity;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.validation.WorkerTypeValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private Cafe cafe;

    @Column(name = "email")
    private String email;

    public User(String login, String password, Role role, Cafe cafe) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.cafe = cafe;
    }

    public User(String login, String password, Role role, Cafe cafe, String email) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.cafe = cafe;
        this.email = email;
    }
}