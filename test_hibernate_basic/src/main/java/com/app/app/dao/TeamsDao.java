package com.app.app.dao;

import java.util.List;

import com.app.pojos.Teams;

public interface TeamsDao {
	
		
		//add a method to add a new team
		String addNewTeam(Teams newTeam);
		
//		Display  team id n abbreviation of all the teams
		
		List<Teams> displayTeamidAndAbbreviation();
		
		//2. Display team details , of a team by it's id
		
		Teams displayTeamDetailsById(Integer id);
		
//		3.Display all those teams who need , player's max age < specific age 
//		n min no of wickets taken > specified wickets
		List<Teams> displayTeamsByMaxAgeAndMinWickets(int maxAge,int wicketTaken);
//4. Update max age n batting avg requirement of a specific team by it's 
//		name (team name is unique)
		String updateMaxAgeAndBattingAverage(String name,int maxAge,double battingAvg);
		
//		Delete team details
		String deleteTeamDetails(Integer teamId);

	}

