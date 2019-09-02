package com.unicom.girl.service;

import com.unicom.girl.domain.Girl;
import com.unicom.girl.enums.ResultEnum;
import com.unicom.girl.exception.GirlException;
import com.unicom.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: girl <br/>
 * @Date: 2019/8/28 13:38 <br/>
 * @Author: yangjiabin
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepository girlRepository;




    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTwo() throws RuntimeException {

            Girl girlA = new Girl();
            girlA.setCupSize("A");
            girlA.setAge(18);
            Girl saveA = girlRepository.save(girlA);

            Girl girlB = new Girl();
            //girlB.setCupSize("B");
            //事务无法回滚是  数据库是MyIsm  InnoDb才行
            girlB.setCupSize("BB");
            girlB.setAge(28);
            Girl saveB = girlRepository.save(girlB);


    }


    @Override
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if( age > 0 && age < 10){
            //throw new Exception("你孩子上小学");
            //throw new GirlException(100,"小学");
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //throw new Exception("你还在上初中");
            //throw new GirlException(101,"中学");
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else if(age > 16){
            //throw new GirlException(102,"大学");
            throw new GirlException(ResultEnum.UNIVERSITY_SCHOOL);
        }

    }


    /**
     * 通过id查询一个女生的信息
     *
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findById(id).get();
    }


}
