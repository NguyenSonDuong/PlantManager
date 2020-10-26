package com.hunterdemon.plant.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ReportInfor")
public class ReportInfor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String ID;
    private int numbertreereport;
    private int numberanimalreport;
    private String addressvisit;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDUser")
    public UserInfor userInfor;

}
