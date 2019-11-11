package com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCDTO.MPCDTO;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCHTTPManagment.MPCHTTPCallManager;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCHTTPManagment.MPCResponseManager;

public class MPCService {
    private MPCHTTPCallManager mpchttpCallManager;
    private MPCResponseManager mpcResponseManager;
    private ObjectMapper objectMapper;

    public MPCService(){
        this.mpchttpCallManager = new MPCHTTPCallManager();
        this.mpcResponseManager = new MPCResponseManager();
        this.objectMapper = new ObjectMapper();
    }

    public void executeMPCPostRequest(String listOfPCSplitByComma){
        mpcResponseManager.setFullResponse(mpchttpCallManager.executeMPCPostRequest(listOfPCSplitByComma));
    }

    public MPCDTO getParsedJSONResponse(){
        MPCDTO parsedResponse = null;
        try {
            parsedResponse = objectMapper.readValue(mpcResponseManager.getResponseBody(), MPCDTO.class);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return parsedResponse;
    }
}
