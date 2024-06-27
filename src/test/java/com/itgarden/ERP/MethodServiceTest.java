package com.itgarden.ERP;

import com.itgarden.ERP.module.callcenter.master.ripository.AssignedNumberRepository;
import com.itgarden.ERP.module.callcenter.master.services.AssignedNumberService;
import com.itgarden.ERP.module.callcenter.master.services.PrefixTableService;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author libertyerp_local
 */
//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(CdrTempController.class)
public class MethodServiceTest {

    @Autowired
    //@Mock
    PrefixTableService prefixTableService;

//    @Autowired
//    //@Mock
//    AssignedNumberService assignedNumberService;
    @Autowired
    AssignedNumberService assignedNumberService;

    @Autowired
    AssignedNumberRepository assignedNumberRepository;

    //@Mock
//    @Autowired
//    private MockMvc mvc;
//    
    @Test
    public void testmethod() throws Exception {
       assignedNumberService.deleteEntitiesUpdatedBeforeDays(10);
    }

}
