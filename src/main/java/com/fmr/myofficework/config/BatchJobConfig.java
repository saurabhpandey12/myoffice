package com.fmr.myofficework.config;

import com.fmr.myofficework.domain.Meetings;
import com.fmr.myofficework.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class BatchJobConfig {
    boolean flag=false;

    BatchJobConfig(){
        this.flag=true;
    }

    private static Logger logger= LoggerFactory.getLogger(BatchJobConfig.class);
    @Autowired
    private WorkService workService;

        @Scheduled(fixedRate = 1000)
        public void fixedRateSch() {
//            System.out.println("Start Time: "+System.currentTimeMillis()/1000);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            Date now = new Date();
            String strDate = sdf.format(now);
//            List<Meetings> meetingList= workService.getAllMeetingList();
//            logger.info("Fetched All Meeting List : {}",meetingList);
//                System.out.println(this.flag);
                String val="Y";
                if(!flag && val.equals("Y")){
//                    System.out.println("Inside Flag");
                }
//            System.out.println("Fixed Rate scheduler:: " + strDate+" Time : "+new Date());
//            System.out.print("End Time :"+System.currentTimeMillis()/1000);
        }
    }
