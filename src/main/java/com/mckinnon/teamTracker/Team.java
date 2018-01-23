package com.mckinnon.teamTracker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.google.gson.Gson;

public class Team  {

	public static String resultSettoJson(Connection connection, String query) {
		List<Map<String, Object>> listOfMaps = null;
		try {
			QueryRunner queryRunner =  new QueryRunner();
			listOfMaps = queryRunner.query(connection, query, new MapListHandler());
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(connection);
		}
		return new Gson().toJson(listOfMaps);
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teamid;
	
	@NotNull
	private String teamName;
	
	@NotNull
	private int teamNum;
	
	private String teamDesc;
	
	public int getId() {
		return teamid;
	}

	public void setId(int id) {
		this.teamid = id;
	}

	public String getName() {
		return teamName;
	}

	public void setName(String name) {
		this.teamName = name;
	}

	public int getteam_num() {
		return teamNum;
	}

	public void setteam_num(int team_num) {
		this.teamNum = team_num;
	}

	public String getTeam_desc() {
		return teamDesc;
	}

	public void setTeam_desc(String team_desc) {
		this.teamDesc = team_desc;
	}

	

	
	
}
