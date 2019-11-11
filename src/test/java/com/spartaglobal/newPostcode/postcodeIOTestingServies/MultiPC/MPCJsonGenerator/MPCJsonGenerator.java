package com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCJsonGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.http.entity.StringEntity;

public class MPCJsonGenerator {

    private ObjectMapper objectMapper = new ObjectMapper();
    public StringEntity createMPCJsonQuery(String listOfPCSplitByComma){
        ArrayNode postcodeArrayNode = objectMapper.createArrayNode();
        String MPCBaseNode = "{\"postcodes\":";
        String closingJsonBracket = "}";
        String[] postCodeArray = listOfPCSplitByComma.split(",");

        for ( String postcode:postCodeArray){
            postcodeArrayNode.add(postcode.replaceAll("\\s", ""));
        }

        System.out.println(MPCBaseNode + postcodeArrayNode + closingJsonBracket);
        return new StringEntity(MPCBaseNode + postcodeArrayNode + closingJsonBracket, "UTF-8");
    }
}
