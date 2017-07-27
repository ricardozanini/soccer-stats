package br.com.meetup.ansible.service.impl;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meetup.ansible.domain.Match;
import br.com.meetup.ansible.repository.MatchRepository;
import br.com.meetup.ansible.service.MatchService;

@Service
class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepository;

	@Override
	public List<Match> listMatchesFromHomeTeam(@NotEmpty String homeTeam) {
		return matchRepository.findByHomeTeam(homeTeam);
	}
	
	@Override
	public List<Match> listExactMatches(@NotEmpty String homeTeam, @NotEmpty String awayTeam) {
		return matchRepository.findByHomeTeamAndAwayTeam(homeTeam, awayTeam);
	}

}
