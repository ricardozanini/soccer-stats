package br.com.meetup.ansible.rest;

import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.meetup.ansible.domain.Match;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MatchControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void testMatchesString() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("/matches/juventus", List.class);
        List<Match> matches = responseEntity.getBody();

        assertThat(matches, not(emptyCollectionOf(Match.class)));
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void testMatchesStringString() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("/matches/juventus/lazio", List.class);
        List<Match> matches = responseEntity.getBody();

        assertThat(matches, not(emptyCollectionOf(Match.class)));
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    }

}
