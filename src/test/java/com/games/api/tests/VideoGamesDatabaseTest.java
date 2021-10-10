package com.games.api.tests;

import org.testng.annotations.Test;

import com.games.api.utils.VideoGamesTestBuilder;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class VideoGamesDatabaseTest {

	private VideoGamesTestBuilder VideogameHelper;

	@BeforeClass
	public void init() {
		VideogameHelper = new VideoGamesTestBuilder();
		
		RestAssured.baseURI = "http://localhost:8080/app";
	}

	@Test(priority = 1)
	public void get_List_Of_Videogames() {
		

		VideogameHelper.getAllVideoGames();

	}

	@Test(priority = 3)
	public void Get_Video_Game_id() {

		
		System.out.println(VideogameHelper.getVideoGameId(30).getBody().asPrettyString());

	}

	@Test(priority = 2)
	public void Post_Video_Game() {
		
		String jsonbody = "{\"id\":30,\"name\":\"Transformer2\"," + "\"releaseDate\":\"2021-10-01T00:16:30.300Z\""
				+ ",\"reviewScore\":4,\"category\":\"Science-Fiction\",\"rating\":\"Universal\"}";

		
		System.out.println(VideogameHelper.postVideoGame(jsonbody).asString());

	}

	@Test(priority = 4)
	public void Put_Video_Game() {
		String jsonbody = "{\"id\":30,\"name\":\"Tomb raider\"," + "\"releaseDate\":\"2021-10-06T00:16:30.300Z\""
				+ ",\"reviewScore\":5,\"category\":\"Fiction\",\"rating\":\"PG-13\"}";
		

		

		System.out.println(VideogameHelper.updateVideoGame(30, jsonbody).getStatusCode());

	}

	@Test(priority = 5)
	public void Delete_Video_Game() {

	
		
		System.out.println(VideogameHelper.deleteVideoGame(30).getStatusLine());
		
	
	}

	@Test(priority = 6)
	public void Get_Video_Game_id_invalid() {

	
		
		System.out.println(VideogameHelper.getVideoGameIdInvalid(30).getStatusLine());

	}
}
