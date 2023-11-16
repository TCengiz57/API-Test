package testDatas;

import org.json.JSONObject;

public class TestDataDummyRestApiExample {

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
    public int okStatusKodu = 200;
    public String contentType = "application/json";


    public JSONObject dataOlusturJSON() {

        JSONObject data = new JSONObject();
        data.put("id", 4);
        data.put("employee_name", "Cedric Kelly");
        data.put("employee_salary", 433060);
        data.put("employee_age", 22);
        data.put("profile_image", "");
        return data;

    }

    public JSONObject reqBodyOlusturJSON() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("status", "success");
        reqBody.put("data", dataOlusturJSON());
        reqBody.put("message", "Successfully! Record has been fetched.");


        return reqBody;


    }

    public JSONObject expBodyOlusturJSON() {

        JSONObject expData = new JSONObject();
        expData.put("status", "success");
        expData.put("data", dataOlusturJSON());
        expData.put("message", "Successfully! Record has been fetched.");
        return expData;
    }
}