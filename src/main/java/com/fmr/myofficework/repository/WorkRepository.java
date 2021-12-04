package com.fmr.myofficework.repository;

import com.fmr.myofficework.domain.*;

import java.util.List;

public interface WorkRepository {
    void addNewMeetings(Meetings meetings);

    Task createNewTask(Task task);

    List<Task> getTaskList();

    List<Meetings> getMeetingList();

    List<Status> getAllStatusList();

    void updateTask(Task task);

    Task getTaskById(int id);

    void updateStatus(Status status);

    Status getStatusById(int id);

    void deleteMeetingById(int id);

    void deleteStatusByUd(int id);

    String deleteTaskById(int id);

    void saveNewDictionaryWord(Dictionary dictionary);

    void addNewWord(Dictionary dictionary);

    void addExpenses(Expences expences);

    Meetings getMeetingById(int id);

    void upDateMeeting(Meetings meetings);
}
