package com.spartaglobal.newPostcode.postcodeIOTests;

import static org.junit.Assert.assertTrue;

import com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCHTTPManagment.MPCHTTPCallManager;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCJsonGenerator.MPCJsonGenerator;
import com.spartaglobal.newPostcode.postcodeIOTestingServies.MultiPC.MPCService;
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
    private static MPCService mpcService;



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
        mpcService = new MPCService();
        mpcService.executeMPCPostRequest("SE12 0nb, TS12  3dg");

    }

    @Test
    public void shouldAnswerWithTrue() {
//        Assert.assertEquals(200, spcService.getParsedJSONResponse().getStatus());
//        mpcJsonGenerator.createMPCJsonQuery("SE12 0nb, TS12  3dg");
        System.out.println(mpcService.getParsedJSONResponse().getStatus());
        System.out.println(mpcService.getParsedJSONResponse().getResult().get(1));
    }
}
