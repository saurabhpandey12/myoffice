package com.fmr.myofficework.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String goalDetails;
    private Date createDate;


}
