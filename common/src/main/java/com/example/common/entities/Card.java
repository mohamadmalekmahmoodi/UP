package com.example.common.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true,length = 16)
    private Long cardNumber;
    @Column(length = 4)
    private Integer cvv2;
    private String expireDate;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Account account;

}
