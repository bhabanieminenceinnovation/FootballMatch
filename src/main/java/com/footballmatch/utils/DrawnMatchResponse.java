package com.footballmatch.utils;

import java.util.List;

import com.footballmatch.entity.FootballMatch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawnMatchResponse {
	private int drawnMatchesCount;
    private List<FootballMatch> drawnMatches;
}
