package br.com.meetup.ansible.domain;

import static java.util.Objects.hash;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Match implements Serializable {

	private static final long serialVersionUID = 5868947730788998578L;
			
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String homeTeam;

	private String awayTeam;

	private int homeTeamGoals;

	private int awayTeamGoals;

	public Match() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeTeamGoals() {
		return homeTeamGoals;
	}

	public void setHomeTeamGoals(int homeTeamGoals) {
		this.homeTeamGoals = homeTeamGoals;
	}

	public int getAwayTeamGoals() {
		return awayTeamGoals;
	}

	public void setAwayTeamGoals(int awayTeamGoals) {
		this.awayTeamGoals = awayTeamGoals;
	}

	@Override
	public int hashCode() {
		return hash(this.awayTeam, this.homeTeam, this.date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		return Objects.equals(this.awayTeam, other.getAwayTeam()) && Objects.equals(this.homeTeam, other.getHomeTeam())
				&& Objects.equals(this.date, other.getDate());
	}

}
