package com.pencil.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "username",nullable = false,length = 40)
    private String username;

    @Column(name = "pwd",nullable = false,length = 40)
    private String pwd;



}
