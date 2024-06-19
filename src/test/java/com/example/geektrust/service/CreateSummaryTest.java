package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.StationStatistics;

public class CreateSummaryTest {
    CardExecutionServiceImpl service;
	
	@BeforeEach
	void setUp() {
		service=new CardExecutionServiceImpl(); 
	}

    @Test
	public void createSummaryTest() {
		String station="AIRPORT";
		
		List<StationStatistics> stationStatsList=new ArrayList<>();
		StationStatistics stationStatsAdult=new StationStatistics("ADULT");
		stationStatsAdult.setCount(2);
		stationStatsAdult.setTotalCharge(300);
		stationStatsAdult.setTotalDiscount(100);
		stationStatsList.add(stationStatsAdult);
		
		StationStatistics stationStatsSeniorCitizen=new StationStatistics("SENIOR_CITIZEN");
		stationStatsSeniorCitizen.setCount(1);
		stationStatsSeniorCitizen.setTotalCharge(100);
		stationStatsSeniorCitizen.setTotalDiscount(0);
		stationStatsList.add(stationStatsSeniorCitizen);
				
		String expectedOutput="ADULT 2\nSENIOR_CITIZEN 1\n";
		
		String actualOutput=service.createSummary(station, stationStatsList);
		assertEquals(expectedOutput, actualOutput);
	}
}
