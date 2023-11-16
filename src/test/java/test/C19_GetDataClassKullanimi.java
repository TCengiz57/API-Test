package test;

import baseUrl.DummyRestApiExampleBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testDatas.TestDataDummyRestApiExample;

import static io.restassured.RestAssured.given;

public class C19_GetDataClassKullanimi extends DummyRestApiExampleBaseUrl {

     /*
     http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un status kodunun 200, content type ın application/json
    ve bodysinin asagidaki gibi oldugunu test edin.

        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */
    @Test
    public void get01(){
        specDummyRestApiExample.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",4);

        TestDataDummyRestApiExample testDataDummyRestApiExample=new TestDataDummyRestApiExample();
        JSONObject reqBody=testDataDummyRestApiExample.reqBodyOlusturJSON();
        JSONObject expBody=testDataDummyRestApiExample.expBodyOlusturJSON();

        Response response=given().spec(specDummyRestApiExample).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        JsonPath resJP = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(resJP.get("status"), expBody.get("status"));
        softAssert.assertEquals(resJP.get("data.id"), expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("data.employee_name"), expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJP.get("data.employee_salary"), expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJP.get("data.employee_age"), expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJP.get("data.profile_image"), expBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(resJP.get("message"), expBody.get("message"));

        softAssert.assertAll();



    }

}
