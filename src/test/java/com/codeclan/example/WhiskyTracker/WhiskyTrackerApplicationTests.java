package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.findByYear(2018);
		assertEquals(6, found.size());
	}

	@Test
	public void canFindDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.findByRegionIgnoreCase("Highland");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindWhiskiesFromDistilleryWithSpecificAge(){
		List<Distillery> found = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, found.size());
	}

	@Test
	public void canFindWhiskyFromParticularRegion(){
		List<Whisky> found = whiskyRepository.findByDistilleryRegionIgnoreCase("Highland");
		assertEquals(7, found.size());
	}

}
