package com.fmr.myofficework.service;

import com.fmr.myofficework.domain.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkService {

    String addNewMeeting(Meetings meetings);

    String createNewTask(Task task);

    String updateTask(Task task);

    String updateTaskStatus(Status status, int taskId);

    List<Task> getAllTaskList();

    void updateStatus(Status status);

    String deleteDataBasedOnParameter(int id, String operationType);

    String addNewDictionaryWord(Dictionary dictionary);

    List<Meetings> getAllMeetingList();

    String addExpenses(Expences expences);

    String changeStatus(int id, String operationType);

    Meetings getMeetingById(int meetingId);

    String updateMeeting(Meetings meeting);
}
