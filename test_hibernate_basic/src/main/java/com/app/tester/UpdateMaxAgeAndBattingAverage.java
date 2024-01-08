package com.app.tester;
import org.hibernate.*;

import com.app.app.dao.TeamsDaoImpl;
import com.app.pojos.Teams;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class UpdateMaxAgeAndBattingAverage {

	public static void main(String[] args) {
		//get the SF from utils
		try(SessionFactory sf=getFactory(); Scanner sc = new Scanner(System.in))
		{
			TeamsDaoImpl teamDao = new TeamsDaoImpl();
			System.out.println("Enter team name,maxAge and battingAvg");
		
			//create team instance
			teamDao.updateMaxAgeAndBattingAverage(sc.next(), sc.nextInt(), sc.nextDouble());
		
		//call dao's method for persistence
		} //sf.close() --> Hibernate will automatically cleanup DBCP
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
