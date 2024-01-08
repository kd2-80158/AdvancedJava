package com.app.app.dao;

import com.app.pojos.Teams;
import org.hibernate.*;
import static com.app.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;


public class TeamsDaoImpl implements TeamsDao {

	@Override
	public String addNewTeam(Teams newTeam) {
		String msg = "Adding team failed";
		//1. Get session from SF
		Session session = getFactory().getCurrentSession();
		//2. Begin a transaction
		Transaction tx = session.beginTransaction();
		//3. try-save team details. commit
		try {
			Serializable teamId = session.save(newTeam);
			tx.commit();
			msg="Added new teams details with ID="+teamId;
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		//catch: runtime exc : rollback tx, throw e
		return msg;
	}

	@Override
	public List<Teams> displayTeamidAndAbbreviation() {
		
		List<Teams> teams=null;
		
		String jpql = "select new com.app.pojos.Teams(teamId,abbreviation) from Teams t";
		
		//1. Get session from SF
		Session session = getFactory().getCurrentSession();
		//2. Begin a transaction
		Transaction tx = session.beginTransaction();
		//3. try-save team details. commit
		try {
			
			teams = session.createQuery(jpql,Teams.class)
			.getResultList();
			
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		//catch: runtime exc : rollback tx, throw e
		return teams;
	}

	@Override
	public Teams displayTeamDetailsById(Integer id) {
         
		Teams team = null;
		
		//1. Get session from SF
		Session session = getFactory().getCurrentSession();
		//2. Begin a transaction
		Transaction tx = session.beginTransaction();
		//3. try-save team details. commit
		try {
			team=session.get(Teams.class, id);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		//catch: runtime exc : rollback tx, throw e
		return team;
	}

	@Override
	public List<Teams> displayTeamsByMaxAgeAndMinWickets(int maxAge, int wicketTaken) {
		
		List<Teams> teams = null;
//		3.Display all those teams who need , player's max age < specific age 
//		n min no of wickets taken > specified wickets
		String jpql = "select t from Teams t where t.maxAge<:age and t.wicketsTaken>:wckt";
		//1. Get session from SF
				Session session = getFactory().getCurrentSession();
				//2. Begin a transaction
				Transaction tx = session.beginTransaction();
				//3. try-save team details. commit
				try {
					teams=session.createQuery(jpql,Teams.class)
							.setParameter("age", maxAge)
							.setParameter("wckt",wicketTaken)
							.getResultList();
					
					tx.commit();
				}
				catch(RuntimeException e)
				{
					if(tx!=null)
						tx.rollback();
					throw e;
				}
				//catch: runtime exc : rollback tx, throw e
				return teams;
	}

	@Override
	public String updateMaxAgeAndBattingAverage(String name,int maxAge,double battingAvg) {
		
		String msg = "Updation failed";
		Teams team = null;
		String jpql = "select t from Teams t where t.name=:teamName";
		//1. Get session from SF
		Session session = getFactory().getCurrentSession();
		//2. Begin a transaction
		Transaction tx = session.beginTransaction();
		//3. try-save team details. commit
		try {
			team=session.createQuery(jpql,Teams.class)
					.setParameter("teamName", name)
					.getSingleResult();
			team.setMaxAge(maxAge);
			team.setBattingAvg(battingAvg);
			msg="Update successfully for team"+team.getName();
			tx.commit();
			
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		//catch: runtime exc : rollback tx, throw e
		return msg;
	}

	@Override
	public String deleteTeamDetails(Integer teamId) {
		String msg = "Deletion failed";
		
		Teams team=null;
		//1. Get session from SF
		Session session = getFactory().getCurrentSession();
		//2. Begin a transaction
		Transaction tx = session.beginTransaction();
		//3. try-save team details. commit
		try {
			team=session.get(Teams.class, teamId);
			
			session.delete(team);
			msg="Delete successfully for team"+team.getName();
			tx.commit();
			
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		//catch: runtime exc : rollback tx, throw e
		
		return msg;
	}


}
