package com.telran.contact.test.api;

import com.jayway.restassured.RestAssured;
import com.telran.contact.api.dto.AuthRequestDto;
import com.telran.contact.api.dto.AuthResponseDto;
import com.telran.contact.api.dto.ContactDto;
import com.telran.contact.api.dto.GetAllContactDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredTests {

    @BeforeMethod
    public void ensurePreconditions(){
        RestAssured.baseURI = "https://contacts-telran.herokuapp.com";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginTestAssuredTest(){

        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("kroosss@gm.com")
                .password("Kroos12345~12")
                .build();

        AuthResponseDto responseDto = given()
                .contentType("application/json")
                .body(requestDto)
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println(responseDto.getToken());

        String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Imtyb29zc3NAZ20uY29tIn0.Bq7w2d_CiLnQBd7MkP-aqNTIUCzrb2gPYLIJmq8pDmw";

        AuthResponseDto responseToken = given()
                .contentType("application/json")
                .body(requestDto)
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .body(containsString("token"))
                .body("token", equalTo(token))
                .extract().response().as(AuthResponseDto.class);
        System.out.println(responseToken);

    }

    @Test
    public void getAllContactTest(){

        String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Imtyb29zc3NAZ20uY29tIn0.Bq7w2d_CiLnQBd7MkP-aqNTIUCzrb2gPYLIJmq8pDmw";

        GetAllContactDto responseDto = given()
                .header("Autorization", token)
                .get("contact")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(GetAllContactDto.class);

        for (ContactDto contact: responseDto.getContacts()){
            System.out.println(contact.getId() + "***" + contact.getName() + "***");
            System.out.println("=================================================");
        }
    }
    @Test
    public void deleteContactTest(){
        String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Imtyb29zc3NAZ20uY29tIn0.Bq7w2d_CiLnQBd7MkP-aqNTIUCzrb2gPYLIJmq8pDmw";

        String status = given()
                .header("Autorization", token)
                .delete("contact/18143")
                .then()
                .assertThat().statusCode(200)
                .extract().path("status");
        System.out.println(status);
    }
}
