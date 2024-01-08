package com.app.tester;
import org.hibernate.*;

import com.app.app.dao.TeamsDaoImpl;
import com.app.pojos.Teams;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class DisplayTeamIdAndAbbreviation {

	public static void main(String[] args) {
		//get the SF from utils
		try(SessionFactory sf=getFactory(); Scanner sc = new Scanner(System.in))
		{
			TeamsDaoImpl teamDao = new TeamsDaoImpl();
		
			System.out.println("Enter TeamId and Abbreviation: ");
			
		//call dao's method for persistence
			teamDao.displayTeamidAndAbbreviation().forEach(e->System.out.println(e.getTeamId()+" "+e.getAbbreviation()));
		
		} //sf.close() --> Hibernate will automatically cleanup DBCP
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
