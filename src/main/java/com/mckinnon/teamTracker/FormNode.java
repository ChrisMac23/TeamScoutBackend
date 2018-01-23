package com.mckinnon.teamTracker;

public class FormNode {
	
	//private String secondform = "Hello World "+"<br>";
	public FormNode() {}
	private String secondform = "<div class='form-group'>" + 
			"    <label for='number'>Team Number:</label>" + 
			"    <input type='number' class='form-control' th:field=${team.team_num}" + 
			"    </div>" +
			"<button type='submit' class='btn-default btn-lg' id='submit'>New Team</button>";
				
	public String getsecondform() {
		return secondform;
	}

	private String yes;

}
