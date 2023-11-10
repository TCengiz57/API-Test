package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_ApiSorgulama {

    /*
C1_Get_ApiSorgulama
https://restful-booker.herokuapp.com/booking/83 url'ine bir GET request
gonderdigimizde donen Response'un,
status code'unun 200,
ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin Cowboy,
ve status Line'in HTTP/1.1 200 OK
ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
 */
    // 1-url belirleyip url adresine gideceğiz
// 2-expected data verilmişse expected data hazırlanır
// 3-Actual data alınacak
// 4-assertion işlemi

    @Test
    public void get01(){

        // 1-url belirleyip url adresine gideceğiz

        String url="https://restful-booker.herokuapp.com/booking/46";

        // 2-expected data acikca verilmişse belirlenecek

        // 3-Actual data alınacak

        Response response=given().when().get(url);
        //response.prettyPrint(); (Sistemi yordugu düşünüldügü icin pek tercih edilmez
        System.out.println("status code :" + response.getStatusCode());//200
        System.out.println("status code :" + response.statusCode());//200
        System.out.println("content Type :" + response.getContentType());//application/json; charset=utf-8
        System.out.println("server Header Degeri :" + response.getHeader("Server"));// Header Degeri :Cowboy
        System.out.println("status line :" + response.getStatusLine());//status line :HTTP/1.1 200 OK
        System.out.println("Get Time :" + response.getTime());//Get Time :3227

    }
}
