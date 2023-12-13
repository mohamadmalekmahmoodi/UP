package com.example.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 200,nullable = false)
    private String name;
    @Column(nullable = false,length = 200)
    private String family;
    @Column(unique = true,length = 10)
    private String nationalCode;
    @OneToMany(mappedBy = "user")
    private List<Account> account;
}