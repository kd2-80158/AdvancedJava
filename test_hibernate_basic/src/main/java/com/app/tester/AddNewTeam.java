package com.app.tester;
import org.hibernate.*;

import com.app.app.dao.TeamsDaoImpl;
import com.app.pojos.Teams;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class AddNewTeam {

	public static void main(String[] args) {
		//get the SF from utils
		try(SessionFactory sf=getFactory(); Scanner sc = new Scanner(System.in))
		{
			TeamsDaoImpl teamDao = new TeamsDaoImpl();
			System.out.println("Enter team details: name,abbreviation, owner,maxAge,battingAvg, wicketsTaken");
		
			//create team instance
			Teams team = new Teams(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
		
		//call dao's method for persistence
			System.out.println(teamDao.addNewTeam(team));
		} //sf.close() --> Hibernate will automatically cleanup DBCP
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
