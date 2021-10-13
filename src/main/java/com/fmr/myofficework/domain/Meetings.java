package com.fmr.myofficework.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Meetings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String meetingId;
    private String meetingDescription;
    private int priorityScale;
    private String meetingPasscode;
    private Date createdDate;
    private String startTiming;
    private String endTiming;
    @Deprecated
    private float meetingDuration;
    private boolean status;
    private String duration;
    private String meetingUrl;


}
