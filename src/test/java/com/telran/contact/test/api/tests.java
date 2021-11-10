package com.telran.contact.test.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.telran.contact.api.dto.AuthRequestDto;
import com.telran.contact.api.dto.AuthResponseDto;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;

public class tests {

    @Test
    public void loginHttpClientTest() throws IOException {

        String email = "kroos@gm.com";
        String password = "Kroos12345~";

        Response response = Request.Post("https://contacts-telran.herokuapp.com/api/login")
                .bodyString("{\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"" + password + "\"\n" +
                        "}", ContentType.APPLICATION_JSON)
                .execute();
        System.out.println(response);

        String responseJson = response.returnContent().asString();
        System.out.println(responseJson);

        JsonElement element = JsonParser.parseString(responseJson);
        JsonElement token = element.getAsJsonObject().get("token");
        System.out.println(token.getAsString());
    }

    @Test

    public void loginHttpClientTestWithDto() throws IOException {
        AuthRequestDto requestDto = AuthRequestDto.builder()

                .email("kroos@gm.com")
                .password("Kroos12345~")
                .build();

        Gson gson = new Gson();
        Response response = Request.Post("https://contacts-telran.herokuapp.com/api/login")
                .bodyString(gson.toJson(requestDto), ContentType.APPLICATION_JSON)
                .execute();
        String responseJson = response.returnContent().asString();
        AuthResponseDto responseDto = gson.fromJson(responseJson, AuthResponseDto.class);
        System.out.println(responseDto.getToken());


    }
}
