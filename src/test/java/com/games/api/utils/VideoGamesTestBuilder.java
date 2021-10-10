package com.games.api.utils;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;
import org.apache.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class VideoGamesTestBuilder {

	

	public void getAllVideoGames() {
		Response resp = RestAssured.given().accept(ContentType.JSON).when().get(VideoGameConstants.Get_VideoGames).then().log()
				.body().and().extract().response();

		assertEquals(resp.getStatusCode(), HttpStatus.SC_OK);
		System.out.println("Status is\n" + resp.getStatusCode());

	}

	public Response postVideoGame(String jsonbody) {

		Response resp = RestAssured.given().contentType(ContentType.JSON).body(jsonbody).when()
				.post(VideoGameConstants.Add_VideoGames).then().statusCode(HttpStatus.SC_OK).extract().response();
		return resp;

	}
	public Response getVideoGameId(int id) {

		Response resp = RestAssured.given().accept(ContentType.JSON)
				.pathParam("videoGameid", id)
				.when()
				.get(VideoGameConstants.Get_Single_VideoGames).then().statusCode(HttpStatus.SC_OK).extract().response();
		return resp;

	}

	public Response updateVideoGame(Integer id, String jsonbody) {

		Response resp = RestAssured.given().contentType(ContentType.JSON).body(jsonbody).pathParam("videoGameid", id)
				.when().put(VideoGameConstants.Update_VideoGames).then().assertThat().statusCode(HttpStatus.SC_OK).extract().response();
		return resp;

	}
	public Response deleteVideoGame(Integer id) {

		Response resp = RestAssured.given().contentType(ContentType.JSON).pathParam("videoGameid", id)
				.when().delete(VideoGameConstants.Delete_VideoGames).then().statusCode(HttpStatus.SC_OK).extract().response();
		return resp;

	}
	public Response getVideoGameIdInvalid(int id) {

		Response resp = RestAssured.given().accept(ContentType.JSON)
				.pathParam("videoGameid", id)
				.when()
				.get(VideoGameConstants.Get_Single_VideoGames).then().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR).extract().response();
		return resp;

	}

}
