package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetStore {
    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }
    
    public void validacionRespuesta(int statusCode) {
        Assert.assertEquals("Validacion de Respuesta", statusCode, response.statusCode());
    }


    public void Postorder(String IdOrder, String IdPet) {
        String body="{\n" +
                "  \"id\": "+IdOrder+",\n" +
                "  \"petId\": "+IdPet+",\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2024-12-17T05:06:24.876Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type","application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public void Getorder(String IdOrder) {
        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type","application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get("/store/order/"+IdOrder)
                .then()
                .log().all()
                .extract().response();
    }
}
