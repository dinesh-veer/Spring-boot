package com.springBoot.demo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schduler {

	//print from every minute from 9 am to 9.59 am
	 @Scheduled(cron = "0 * 9 * * ?")
	   public void cronJobSch() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	      Date now = new Date();
	      String strDate = sdf.format(now);
	      System.out.println("Java cron job expression:: " + strDate);
	   }
	 
	 //prints after every 1 second doesnot wait for previous task completion
	 @Scheduled(fixedRate=1000)
	 public void fixedRateExample() {
		 SimpleDateFormat sFormat = new SimpleDateFormat("HH:mm:ss");
		 System.out.println("Using fixed Rate : " +sFormat.format(new Date()));
	 }

	 //prints after initial Delay and after that fixed delay of 1.5 sec. It will wait for previous task completion
	 @Scheduled(fixedDelay=1500, initialDelay=10000)
	 public void fixedDelayExample() {
		 SimpleDateFormat sFormat = new SimpleDateFormat("HH:mm:ss");
		 System.out.println("Using intial and fixed delay : " +sFormat.format(new Date()));
	 }

	 
}
