package com.footballmatch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.footballmatch.entity.FootballMatch;
import com.footballmatch.utils.ApiCaller;
import com.footballmatch.utils.DrawnMatchResponse;
import com.footballmatch.utils.FootballMatchResponse;

@RestController
@RequestMapping("/api")
public class FootballmatchController{
	
	@Autowired
	private RestTemplate restTemplate;

	public FootballmatchController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/matches/draws")
    public ResponseEntity<DrawnMatchResponse> run(@RequestParam("year") int year) throws InterruptedException, ExecutionException {
        ApiCaller apiCaller=new ApiCaller(restTemplate, year);
        FootballMatchResponse response = apiCaller.fetch();
        if(response != null) {
        	List<FootballMatch> totalDrawnMatch = totalDrawnMatch(response.getData());
        	int drawnMatchCount = totalDrawnMatch.size();
        	DrawnMatchResponse drawnMatchResponse=new DrawnMatchResponse(drawnMatchCount, totalDrawnMatch);
        	return ResponseEntity.ok(drawnMatchResponse);
        }
        return ResponseEntity.ok(new DrawnMatchResponse(0, new ArrayList<>()));
    }
	private List<FootballMatch> totalDrawnMatch(List<FootballMatch> matches) {
		List<FootballMatch> drawnMatches = new ArrayList<>();
		for (FootballMatch match : matches) {
            if (match.getTeam1goals() == match.getTeam2goals()) {
                drawnMatches.add(match);
            }
        }
		return drawnMatches;
	}

}
