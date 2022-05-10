package testData;

import org.json.JSONObject;

public class RegresInTestData {
    public JSONObject setUpPutData(){

        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("name", "morpheus");
        expectedRequest.put("job", "zion resident");
        return expectedRequest;
    }
    public JSONObject setUpPatchRequest(){

        JSONObject patchData=new JSONObject();
        patchData.put("name", "morpheus");
        patchData.put("job", "zion resident");

        return patchData;
    }
}
