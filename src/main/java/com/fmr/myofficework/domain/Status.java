package com.fmr.myofficework.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statusId;
    private String statusDescription;
    private Date createdDate;
    private boolean open;
    private Date closeDate;
    @ManyToOne
    @JsonIgnore
    private Task task;



}
