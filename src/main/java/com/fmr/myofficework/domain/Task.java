package com.fmr.myofficework.domain;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    @Column(unique = true)
    private String taskNumber;
    private String taskName;
    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Status> statusList;
    private boolean status;
    private Date createDate;
    private Date completeDate;
    private Date updateDate;

}
