package com.fmr.myofficework.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Month;
import java.util.Date;

@Entity
@Setter
@Getter
public class Expences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private float amountSpended;
    private Month onWhichMonth;
    private Date addedDate;

}
