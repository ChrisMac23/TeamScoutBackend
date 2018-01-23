package com.mckinnon.teamTracker;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TeamMapper implements RowMapper<Team>{
		   public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Team team = new Team();
		      team.setId(rs.getInt("teamid"));
		      team.setName(rs.getString("teamName"));
		      team.setteam_num(rs.getInt("teamNum"));
		      team.setTeam_desc(rs.getString("teamDesc"));
		      
		      
		      return team;
		   }
		}

