package com.fmr.myofficework.service.impl;

import com.fmr.myofficework.domain.*;
import com.fmr.myofficework.repository.WorkRepository;
import com.fmr.myofficework.service.WorkService;
import com.fmr.myofficework.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    private static Logger LOGGER = LoggerFactory.getLogger(WorkServiceImpl.class);

    @Autowired
    private WorkRepository workRepository;

    @Override
    public String addNewMeeting(Meetings meetings) {

        String message = "";
        boolean isDataValid = false;
        try {
            if ((meetings.getMeetingDescription().equals("") || meetings.getMeetingDescription().equals(null))
                    || (meetings.getMeetingId().equals("") || meetings.getMeetingId().equals(null))
            ) {
                isDataValid = true;
            }
        } catch (NullPointerException e) {
            isDataValid = true;
            message = e.getMessage();
            System.out.println(e.getMessage());
        }

        if (isDataValid) {
            message = "Data Invalid please check the details before save! " + meetings.getMeetingId() + " Meeting id and description is must";
        } else {
            meetings.setCreatedDate(new Date());

            try {
                Time startTiming = Util.convertStringToSqlTime(meetings.getStartTiming());
                Time endTiming = Util.convertStringToSqlTime(meetings.getEndTiming());
                long time = startTiming.getTime() - endTiming.getTime();
                long diffSeconds = time / 1000 % 60;
                long diffMinutes = time / (60 * 1000) % 60;
                long diffHours = time / (60 * 60 * 1000) % 24;
                long diffDays = time / (24 * 60 * 60 * 1000);

                System.out.print(diffDays + " days, ");
                System.out.print(diffHours + " hours, ");
                System.out.print(diffMinutes + " minutes, ");
                System.out.print(diffSeconds + " seconds.");
                meetings.setMeetingDuration(Float.valueOf(time));
                meetings.setDuration("Meeting Time Duration IS for:- " + diffHours + " Hours and " + diffMinutes + " Minutes");

            } catch (Exception e) {
                LOGGER.error("Cannot parese date for the ud : {}", meetings.getMeetingId());
            }
            workRepository.addNewMeetings(meetings);
            message = "New Meeting Careted for id " + meetings.getMeetingId() + " **** Cheers!";

        }


        return message;
    }

    @Override
    public String createNewTask(Task task) {

//        workRepository.createNewTask(task);

        boolean isValid = false;
        String taskNumber = "";
        String message = "";

        if (task.getTaskName() != null || task.getTaskName() != "") {
            isValid = true;
        }
        if (isValid) {
            task.setCreateDate(new Date());
            task.setStatus(true);
            Task latestTask = workRepository.createNewTask(task);
            taskNumber = latestTask.getTaskNumber();
            message = "New Task is create with TASK Number : " + taskNumber + " ***CHEERS!";

        } else {
            message = "Invalid Data! TaskName is null----> Plase Provide task Name";
        }

        return message;
    }

    @Override
    public String updateTask(Task task) {
        Task savedTask = workRepository.getTaskById(task.getTaskId());
        if (task.getTaskName() != null) {
            savedTask.setTaskName(task.getTaskName());
        }

        String message = "";
        boolean isOpen = task.isStatus();
        if (isOpen) {
            savedTask.setUpdateDate(new Date());
            message = "Task Number" + savedTask.getTaskNumber() + "is updated successfully! TASK Number  **** CHEERS!";
        } else {
            savedTask.setCompleteDate(new Date());
            savedTask.setStatus(false);
            message = "Task Number " + savedTask.getTaskNumber() + "completed successfully <h1>CONGATULATIONS!!</h1>";
        }
        workRepository.updateTask(savedTask);
        return message;
    }

    @Override
    public String updateTaskStatus(Status status, int taskId) {
        Task task = workRepository.getTaskById(taskId);
        List<Status> statusList = new ArrayList<>();
        statusList.add(status);
        status.setTask(task);
        status.setCreatedDate(new Date());
        status.setOpen(true);
        task.setStatusList(statusList);
        workRepository.updateTask(task);
        return "For Task ID :- " + task.getTaskNumber() + " Status is updated successfully! CONGO!!";
    }

    @Override
    public List<Task> getAllTaskList() {
        return workRepository.getTaskList();
    }

    @Override
    public void updateStatus(Status status) {
        Status oldStatus = workRepository.getStatusById(status.getStatusId());
        oldStatus.setOpen(status.isOpen());
        oldStatus.setCloseDate(new Date());
        workRepository.updateStatus(oldStatus);
    }

    @Override
    public String deleteDataBasedOnParameter(int id, String operationType) {
        String message = "";
        if (operationType.equals("task")) {
            String taskNumber = workRepository.deleteTaskById(id);
            message = "Task No. " + taskNumber + " Deleted Successfully..   ******CHEERS!!";
        } else if (operationType.equals("status")) {
            workRepository.deleteStatusByUd(id);
            message = "Status Deleted Successfully!!!";
        } else if (operationType.equals("meeting")) {
            workRepository.deleteMeetingById(id);
            message = "Meeting Deleted Successfully!! **** CHEERS!!";
        }
        return message;
    }

    @Override
    public String addNewDictionaryWord(Dictionary dictionary) {
        workRepository.addNewWord(dictionary);
        return "Data Addedd Succesfully!";
    }

    @Override
    public List<Meetings> getAllMeetingList() {
        return workRepository.getMeetingList();
    }

    @Override
    public String addExpenses(Expences expences) {
        String message = "Data Added Successfully!";
        workRepository.addExpenses(expences);
        return message;
    }

    @Override
    public String changeStatus(int id, String operationType) {
        String message = "";
        if (operationType.equals("task")) {
            try {
                Task task = workRepository.getTaskById(id);
                task.setStatus(true);
            } catch (Exception e) {
                LOGGER.error("No Match found for the id====", id);
            }

        } else if (operationType.equals("meeting")) {

        } else if (operationType.equals("status")) {

        }
        return message;
    }
}



