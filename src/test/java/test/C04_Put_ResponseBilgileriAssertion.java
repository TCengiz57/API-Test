package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssertion {
/*
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki Json formatindaki body ile
    bir PUT request gonderdigimizde
    {
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
    }
    donen Response'un,
    status code'unun 200,
    ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin cloudflare,
    ve status Line'in HTTP/1.1 200 OK oldugunu assert ediniz
 */

    @Test
    public void put01(){

        String Url="https://jsonplaceholder.typicode.com/posts/71";
        JSONObject reqBody=new JSONObject();
        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 10);
        reqBody.put("id", 70);

        Response response=given()
                                .contentType(ContentType.JSON)
                        .when()
                                .body(reqBody.toString()).put(Url);

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");



    }


}






