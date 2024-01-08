package com.app.pojos;
import javax.persistence.*;

import javax.persistence.Entity;

//create table teams (team_id int primary key auto_increment,name varchar(100),abbreviation varchar(10),
//owner varchar(20),max_age int,
//batting_avg double,wickets_taken int);
@Entity
@Table(name="teams")
public class Teams {
	@Id //primary key constraints
//	to specify auto id generation using auto increment stategy
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//
	@Column(name="team_id", unique = true)
	private Integer teamId;//Make ID property explicitly Serializable(All wrapper classes are seriablizable)
	
	@Column(length=100, unique = true)
	private String name;
	@Column(length=10, unique = true)
	private String abbreviation;

	@Column(length=20)
	private String owner;
	@Column(name="max_age")
	private int maxAge;
	@Column(name="batting_avg")
	private double battingAvg;
	@Column(name="wickets_taken")
	private int wicketsTaken;
	
	public Teams() {
		
	}
	//all getters and setters are required
	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Integer getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}
	public double getBattingAvg() {
		return battingAvg;
	}
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketTaken) {
		this.wicketsTaken = wicketTaken;
	}

	public Teams(String name, String abbreviation, String owner, int maxAge, double battingAvg, int wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	
	public Teams(Integer teamId, String abbreviation) {
		super();
		this.teamId = teamId;
		this.abbreviation = abbreviation;
	}
	//for debug purposes
	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	

}
