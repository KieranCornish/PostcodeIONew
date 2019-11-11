package com.spartaglobal.newPostcode.postcodeIOTestingServies.SinglePC.SPCHTTPManager;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SPCHTTPResponseManager {
    private CloseableHttpResponse SPCResponse;

    public void setFullResponse(CloseableHttpResponse response) {
        SPCResponse = response;
    }

    public String getRespondBody(){
        String responseBody = null;
        try {
            responseBody = EntityUtils.toString(SPCResponse.getEntity());

        }catch (IOException e){
            e.printStackTrace();
        }
        return responseBody;
    }
}
