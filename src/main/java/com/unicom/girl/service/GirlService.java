package com.unicom.girl.service;

import com.unicom.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: girl <br/>
 * @Date: 2019/8/28 13:38 <br/>
 * @Author: yangjiabin
 */

public interface GirlService {

      void insertTwo() throws RuntimeException;

      public void getAge(Integer id) throws Exception;
      public Girl findOne(Integer id);
}
