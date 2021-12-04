package com.fmr.myofficework;

import com.fmr.myofficework.config.AnalyzeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.*;

@SpringBootApplication(exclude = H2ConsoleAutoConfiguration.class)
@EnableScheduling
public class MyofficeworkApplication {


	public static void main(String[] args) throws Exception {
//		Toolkit.getDefaultToolkit().beep();

		SpringApplication.run(MyofficeworkApplication.class, args
		);
		Toolkit.getDefaultToolkit().beep();
		AnalyzeDocument.extractPdf();
	}


}
