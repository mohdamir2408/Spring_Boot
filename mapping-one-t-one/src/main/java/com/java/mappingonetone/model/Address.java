package com.java.mappingonetone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "add_id")
    private Long addressId;
    private String city;
    private String addressType;

    //@OneToOne(mappedBy = "address")
    @ManyToOne
    @Transient
    @JsonIgnore
    @JoinColumn( referencedColumnName = "empId")
    private Employee employee;


}
