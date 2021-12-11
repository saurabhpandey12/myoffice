package com.fmr.myofficework.controller;


import com.fmr.myofficework.domain.*;
import com.fmr.myofficework.service.WorkService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;


@RestController
@RequestMapping("/work-management/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkController {

    final static Logger LOGGER= LoggerFactory.getLogger(WorkController.class);

    @Autowired
    private WorkService workService;

    @PostMapping("/addMeeting")
    private ResponseEntity<String> postNewMeeting(@RequestBody @Valid  Meetings  meetings){
        LOGGER.info("New Meeting Create Method Started, {}",meetings);

        String message = "";

        message
                = workService.addNewMeeting(meetings);
        Toolkit.getDefaultToolkit().beep();

        return new ResponseEntity<>("RESPONSE:- "+message+"     ",HttpStatus.OK);
    }

    @PostMapping("/addTask")
    private ResponseEntity<String> createNewTask(@RequestBody @Valid Task task){
      String message =  workService.createNewTask(task);
      return new ResponseEntity<>("Response :- "+message,HttpStatus.OK);
    }

    @PatchMapping("/updateTask")
    ResponseEntity<String> updateTask(@RequestBody Task task){
        String message = "";
        message = workService.updateTask(task);
        return new ResponseEntity<>("Response :-"+ message, HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{taskId}")
    ResponseEntity<String> updateStatus(@RequestBody Status status , @PathVariable int taskId){
        String message = workService.updateTaskStatus(status,taskId);
        return new ResponseEntity<>(message , HttpStatus.OK);
    }


    @GetMapping("/getAllTask")
    ResponseEntity<List<Task>> getTaskList(){
        return new ResponseEntity<>(workService.getAllTaskList(),HttpStatus.OK);
    }

    @PutMapping("/updateStatus")
    String updateStatus(@RequestBody Status status){
        workService.updateStatus(status);
        return "Status Changed Successfully!!!!";
    }

    @DeleteMapping("/deleteTask/{id}/{operationType}")
    ResponseEntity<String> deleteTaskOrStatusOrMeeting(@PathVariable int id, @PathVariable  String operationType){

       String message = workService.deleteDataBasedOnParameter(id,operationType);

       return new ResponseEntity<>("Response:- "+message,HttpStatus.OK);
    }

    @PostMapping("/addDictionary")
    ResponseEntity<String> addNewDictionaryWord(@RequestBody Dictionary dictionary){
        String message = "";
        message = workService.addNewDictionaryWord(dictionary);
        return new ResponseEntity<>("Response:-"+message,HttpStatus.OK);
    }


    @GetMapping("/getAllMeetingList")
    ResponseEntity<List<Meetings>> getAllMeetingList(){
       List<Meetings> meetingsList=workService.getAllMeetingList();
       return new ResponseEntity<>(meetingsList,HttpStatus.OK);
    }

    @PostMapping("/addExpenses")
    ResponseEntity<String> addExpenses(@RequestBody Expences expences){
        String message = workService.addExpenses(expences);
        return new ResponseEntity<>("Response:- "+message,HttpStatus.OK);
    }


    @GetMapping("/changeStatus/{id}/{operationType}")
    ResponseEntity<String> changeStatusOfAnyField(@PathVariable  int id,@PathVariable  String operationType){
        String message = workService.changeStatus(id,operationType);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("/getMeetingById/{meetingId}")
    ResponseEntity<Meetings> getMeetingDetailsById(@PathVariable int meetingId){
        Meetings meeting = workService.getMeetingById(meetingId);
        LOGGER.info("Data fetched getMeetingByID : {}",meeting);
        return new ResponseEntity<>(meeting,HttpStatus.OK);
    }

    @PutMapping("/updateMeeting")
    ResponseEntity<String> updateMeeting(@RequestBody Meetings meetings){
        String response = workService.updateMeeting(meetings);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }




}
