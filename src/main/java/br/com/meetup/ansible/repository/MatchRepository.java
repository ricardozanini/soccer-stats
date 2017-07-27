package br.com.meetup.ansible.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.meetup.ansible.domain.Match;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {
	
	List<Match> findByHomeTeam(String homeTeam);
	
	List<Match> findByAwayTeam(String awayTeam);
	
	List<Match> findByHomeTeamAndAwayTeam(String homeTeam, String awayTeam);
}

