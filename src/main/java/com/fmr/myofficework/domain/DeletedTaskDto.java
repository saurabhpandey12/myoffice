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
public class DeletedTaskDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private int taskid;
    private int meetingId;
    private Date deletedDate;
    private Date createDate;
    private int statusId;
    private int workId;
}
