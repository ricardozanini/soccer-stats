package br.com.meetup.ansible.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.meetup.ansible.domain.Match;
import br.com.meetup.ansible.service.MatchService;

@RestController
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	@GetMapping(path = "/matches/{team}")
	public List<Match> matches(@PathVariable("team") String team) {
		return matchService.listMatchesFromHomeTeam(team);
	} 
	

	@GetMapping(path = "/matches/{homeTeam}/{awayTeam}")
	public List<Match> matches(@PathVariable("homeTeam") String homeTeam, @PathVariable("awayTeam") String awayTeam) {
		return matchService.listExactMatches(homeTeam, awayTeam);
	} 
	
}
