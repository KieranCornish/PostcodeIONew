package com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCHTTPManagment;

import com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCJsonGenerator.MPCJsonGenerator;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.URLConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class MPCHTTPCallManager {
    MPCJsonGenerator mpcJsonGenerator;

    public MPCHTTPCallManager(){
        mpcJsonGenerator = new MPCJsonGenerator();
    }

    public CloseableHttpResponse executeMPCPostRequest (String listOfPCSplitByComma){
        CloseableHttpResponse mpcResponse = null;

        try {
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpPost postMPC = new HttpPost(URLConfig.BASEURL + URLConfig.POSTCODEENDPOINT);
            postMPC.setHeader("Content-type", "application/json");

            postMPC.setEntity(mpcJsonGenerator.createMPCJsonQuery(listOfPCSplitByComma));
            mpcResponse = closeableHttpClient.execute(postMPC);
        }catch (IOException e){
            e.printStackTrace();
        }
        return mpcResponse;
    }
}
