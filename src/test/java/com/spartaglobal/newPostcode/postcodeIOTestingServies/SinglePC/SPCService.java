package com.spartaglobal.newPostcode.postcodeIOTestingServies.SinglePC;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.SinglePC.SPCDTO.SPCDTO;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.SinglePC.SPCHTTPManager.SPCHTTPCallManager;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.SinglePC.SPCHTTPManager.SPCHTTPResponseManager;

public class SPCService {
    private SPCHTTPCallManager spchttpCallManager;
    private SPCHTTPResponseManager spchttpResponseManager;
    private ObjectMapper objectMapper;

    public SPCService() {
        spchttpCallManager = new SPCHTTPCallManager();
        spchttpResponseManager = new SPCHTTPResponseManager();
        objectMapper = new ObjectMapper();
    }

    public void executeSinglePostcodeCall(String postcode){
        spchttpResponseManager.setFullResponse(spchttpCallManager.executeSPCGetRequest(postcode));
    }

    public SPCDTO getParsedJSONResponse(){
        try {
            return objectMapper.readValue(spchttpResponseManager.getRespondBody(),SPCDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return getParsedJSONResponse();
    }
}
