package com.fmr.myofficework.repository.impl;

import com.fmr.myofficework.domain.*;
import com.fmr.myofficework.repository.WorkRepository;
import com.fmr.myofficework.util.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

@Repository
public class WorkRepositoryImpl implements WorkRepository {
    @Override
    public void addNewMeetings(Meetings meetings) {

        Session session
                = HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        session.save(meetings);
        transaction.commit();
        session.close();


    }

    @Override
    public Task createNewTask(Task task) {
        Session session = HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        session.save(task);
        Query query = session.createQuery("from Task order by taskId DESC");
        query.setMaxResults(1);
        Task latestTask = (Task) query.uniqueResult();
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.err.println(generatedString);

        System.out.println(generatedString);
        task.setTaskNumber("TASK"+latestTask.getTaskId()+"CRD"+(int) (latestTask.getCreateDate().getTime()/1000)+generatedString.toUpperCase());
        session.update(task);
        transaction.commit();
        session.close();
        return task;
    }

    @Override
    public List<Task> getTaskList() {
        Session session
                = HibernateUtils.getSession();
        List<Task> taskList = session.createQuery("from Task").list();
        session.close();

        return taskList;
    }

    @Override
    public List<Meetings> getMeetingList() {
        Session session
                = HibernateUtils.getSession();
        List<Meetings> meetingList = session.createQuery("from Meetings").list();
        session.close();
        return meetingList;
    }

    @Override
    public List<Status> getAllStatusList() {
        return HibernateUtils.getSession().createQuery("from Status").list();
    }

    @Override
    public void updateTask(Task task) {
        Session session = HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        session.update(task);
        transaction.commit();
        session.close();
    }

    @Override
    public Task getTaskById(int id) {
        Session session
                = HibernateUtils.getSession();
        Task task =(Task)session.get(Task.class,id);
        session.close();
        return task;
    }

    @Override
    public void updateStatus(Status status) {
        Session session = HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        session.update(status);
        transaction.commit();;
        session.close();
    }

    public Status getStatusById(int id){
        Session session
                = HibernateUtils.getSession();
        Status status
                = (Status) session.get(Status.class,id);
        session.close();
        return status;
    }

    @Override
    public void deleteMeetingById(int id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        Meetings meeting = (Meetings) session.get(Meetings.class,id);
        session.delete(meeting);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteStatusByUd(int id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        Status status = (Status) session.get(Status.class,id);
        session.delete(status);
        transaction.commit();
        session.close();
    }

    @Override
    public String deleteTaskById(int id) {
        Session session = HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        Task task = (Task) session.get(Task.class,id);
        session.delete(task);
        transaction.commit();
        session.close();
        return task.getTaskNumber();
    }

    @Override
    public void saveNewDictionaryWord(Dictionary dictionary) {
        Session session
                =HibernateUtils.getSession();
        Transaction transaction
                =session.beginTransaction();
        session.save(dictionary);
        transaction.commit();
        session.close();
    }

    @Override
    public void addNewWord(Dictionary dictionary) {
        Session session
                =HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        session.save(dictionary);
        transaction.commit();;
        session.close();
    }

    @Override
    public void addExpenses(Expences expences) {
        Session session
                =HibernateUtils.getSession();
        Transaction transaction
                = session.beginTransaction();
        session.save(expences);
        transaction.commit();;
        session.close();
    }

    @Override
    public Meetings getMeetingById(int id) {
        Session session
                =HibernateUtils.getSession();

        Meetings meetings = (Meetings) session.get(Meetings.class,id);
        session.close();

        return meetings;
    }


}
