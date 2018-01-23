package com.mckinnon.teamTracker;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TeamJDBCTemplate implements TeamDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbctemplateObject;

	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		this.jdbctemplateObject = new JdbcTemplate(ds);
	}
	public void create(String name, Integer num, String desc) {
		// TODO Auto-generated method stub
		String SQL = "insert into team (teamName,teamNum,teamDesc) values (?,?,?)";
		jdbctemplateObject.update(SQL,name,num,desc);
		
	}

	public Team getTeam(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from team where teamid = ?";
	      Team team = jdbctemplateObject.queryForObject(SQL, 
	         new Object[]{id}, new TeamMapper());
	      
	      return team;
		
	}
	
	

	public List<Team> listTeams() {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM team";
		List<Team> teams = jdbctemplateObject.query(SQL, new TeamMapper());
		
		return teams;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "delete from team where teamid = ?";
	      jdbctemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
		
	}

	public void update(Integer id, Integer num) {
		// TODO Auto-generated method stub
		String SQL = "update team set teamNum = ? where teamid = ?";
	      jdbctemplateObject.update(SQL, num, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	}
	

}
