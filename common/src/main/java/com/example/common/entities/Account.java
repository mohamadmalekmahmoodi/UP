package com.example.common.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Card card;
    @Column(unique = true,nullable = false)
    private Long accountNumber;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private Long balance;
    @OneToMany(mappedBy = "account",targetEntity = Transaction.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
