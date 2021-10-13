package com.fmr.myofficework.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class FutureGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int goalDuration;
    private Date startMonth;
    private Date finishDate;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "FutureGoal")
    private List<Goals> goalsList;

}
