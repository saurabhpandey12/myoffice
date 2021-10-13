package com.fmr.myofficework.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class TodayLearning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String topic;
    private String category;
    private String subject;
    private String question;
    private String answer;
    private Date createdDate;

    public void setCreatedDate(Date createDate){
        this.createdDate = new Date();
    }
}
