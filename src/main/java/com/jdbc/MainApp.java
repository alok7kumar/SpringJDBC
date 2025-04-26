package com.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
				Repo r1 = context.getBean(Repo.class);
				//Insert
//						r1.insertData(2, "Amar");
//				System.out.println("Record Inserted Successfully !");
				
				//Update
//					r1.updateData(2, "Akshay");
//				System.out.println("Record Updated Successfully !");
				
				//Delete
//						r1.deleteData(2);
//					System.out.println("Record Deleted Successfully !");
				
				//Fetch -multiple row
//					List<String> l1 = r1.fetchData();
//					
//					for (String string : l1) {
//						System.out.println(string);
//					}
					
				//Fetch- single row
					String s1 = r1.fetchById(1);
					System.out.println(s1);
	}

}
