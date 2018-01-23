package com.mckinnon.teamTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mckinnon.teamTracker.FormNode;

import net.minidev.json.parser.JSONParser;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jca.cci.core.RecordCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller	
public class WebController {
	
	ApplicationContext  context = new ClassPathXmlApplicationContext("Beans.xml");	
	
	TeamJDBCTemplate teamJdbcTemplate = (TeamJDBCTemplate) context.getBean("teamJdbcTemplate");
	
	@RequestMapping("/")
	public String test() {
		return "index";
	}
	
	@RequestMapping("/view")	
	public String showData(Model model) {
		/*ArrayList<String> names = null;
		List<Team> teams = teamJDBCTeplate.listTeams();
		for( Team record: teams) {
			names.add(record.getName());
		}*/
		List<String> names = new ArrayList<>();
		List<Integer> id = new ArrayList<>();

        List<Team> teamnameList = teamJdbcTemplate.listTeams();
        for(Team record: teamnameList) {
       	 System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Team Number : " + record.getteam_num());
            names.add(record.getName());
            id.add(record.getId());
            }
        List<String> x = new ArrayList<>(names);
        System.out.println(x);

		model.addAttribute("name", names);
		model.addAttribute("id", id);
		return "ListTeams";
	}
	
	@GetMapping("/start")
	public String teamName(Model model) {
		model.addAttribute("team", new Team());
		FormNode n = new FormNode();
		model.addAttribute("extendee", n.getsecondform());
		return "start";
	}
	
	@PostMapping("/mobile")
	public @ResponseBody String handleMobilePost(@RequestBody String n) {
		
		System.out.println("** "+n);
		Team team = new Gson().fromJson(n, Team.class);
		
		System.out.println("**: "+team.getName());
		
		teamJdbcTemplate.create(team.getName(), team.getteam_num(), team.getTeam_desc());
	
		
		return "Sorry Sucka";
	}
	@PostMapping("/start")
	public @ResponseBody String handlePost(@ModelAttribute Team n){
		
	    	teamJdbcTemplate.create(n.getName(), n.getteam_num(), n.getTeam_desc());
				
	    	
	    	
	    	String s= "Saved";	
	    
	    return s;
	} 
	
	


@RequestMapping(value = "/delete/{team}", method = RequestMethod.GET)
public String delete(@PathVariable("team") int team) {
	teamJdbcTemplate.delete(team);
	
	
	return "delete";
}

@RequestMapping(value= "/team/{id}", method = RequestMethod.GET)
	public @ResponseBody Team viewTeam(@PathVariable("id") int id) {
	Team team = teamJdbcTemplate.getTeam(id);
	/*int num = team.getteam_num();
	String des = team.getTeam_desc();
	String gs = new Gson().toJson(team);*/ 
	
	
	
	
	
	return team;
}
@RequestMapping("/viewAll")
public @ResponseBody String viewAll() {
	String result = new String();
	try {
	String url = "jdbc:mysql://192.168.0.104:3306/scout?serverTimezone=UTC";
	String uname = "timmywin";
	String pass = "Blackmamba";
	
		Connection conn = DriverManager.getConnection(url, uname, pass);
		String json = Team.resultSettoJson(conn , "Select * from teamstest");
		result = json;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
	
	
}
}