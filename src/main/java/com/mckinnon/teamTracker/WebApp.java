package com.mckinnon.teamTracker;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Timmy
 *
 */
@SpringBootApplication
public class WebApp 
{
	
    
    
    public static void main( String[] args )
    {
    	ApplicationContext  context = new ClassPathXmlApplicationContext("Beans.xml");

    	SpringApplication.run(WebApp.class, args);
    	
    		/*TeamJDBCTemplate teamJdbcTemplate = (TeamJDBCTemplate) context.getBean("teamJdbcTemplate");
    	
    	System.out.println("------Records Creation--------" );
    	teamJdbcTemplate.create("dsd", 3);
    	teamJdbcTemplate.create("dds", 43);
    	
    	 System.out.println("------Listing Multiple Records--------" );
         List<Team> teamList = teamJdbcTemplate.listTeams();
         
         for(Team record: teamList) {
        	 System.out.print("ID : " + record.getId() );
             System.out.print(", Name : " + record.getName() );
             System.out.println(", Age : " + record.getteam_num());
         }
         
         System.out.println("----Updating Record with ID = 2 -----" );
         teamJdbcTemplate.update(2, 20);
         
         System.out.println("----Listing Record with ID = 2 -----" );
         Team team = teamJdbcTemplate.getTeam(2);
         System.out.print("ID : " + team.getId() );
         System.out.print(", Name : " + team.getName() );
         System.out.println(", Age : " + team.getteam_num());
         */
    }
}
