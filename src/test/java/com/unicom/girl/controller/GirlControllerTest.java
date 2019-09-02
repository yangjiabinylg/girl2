package com.unicom.girl.controller;

import com.unicom.girl.domain.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: girl <br/>
 * @Date: 2019/9/2 15:25 <br/>
 * @Author: yangjiabin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private GirlController girlController;

    @Test
    public void girlList() {
        List<Girl> girls = girlController.girlList();
        for(Girl g : girls){
            System.out.println(g.toString());
        }
    }

    //*********************************************************

    @Autowired
    private MockMvc mvc;

    @Test
    public void girlList2() throws Exception{
      mvc.perform(MockMvcRequestBuilders.get("/girls1111"))
              .andExpect(MockMvcResultMatchers.status().isOk());
    }




}