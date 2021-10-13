package com.fmr.myofficework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompletedHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int taskid;
    private int meetingId;
    private int todayGoalId;
    private int statusId;
    private int dictionaryId;
}
