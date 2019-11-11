package com.spartaglobal.newPostcode.postcodeIOTests;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.newPostcode.postcodeIOTestingServies.SinglePC.SPCHTTPManager.SPCHTTPCallManager;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.SinglePC.SPCHTTPManager.SPCHTTPResponseManager;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.SinglePC.SPCService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
//    private static SPCHTTPCallManager SPCHTTPCallManager;
//    private static SPCHTTPResponseManager SPCHTTPResponseManager;
    private static SPCService spcService;

//    @BeforeClass
//    public static void setup(){
//        SPCHTTPCallManager = new SPCHTTPCallManager();
//        SPCHTTPResponseManager = new SPCHTTPResponseManager(SPCHTTPCallManager.executeSPCGetRequest("cm131hx"));
//    }
//
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        System.out.println(SPCHTTPCallManager.executeSPCGetRequest("cm131hx"));
//    }
    @BeforeClass
    public static void setup(){
        spcService = new SPCService();
        spcService.executeSinglePostcodeCall("cm131hx");
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        Assert.assertEquals(200, spcService.getParsedJSONResponse().getStatus());
    }
}
