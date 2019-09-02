package com.unicom.girl.controller;

import com.unicom.girl.aspect.HttpAspect;
import com.unicom.girl.domain.Girl;
import com.unicom.girl.domain.Result;
import com.unicom.girl.repository.GirlRepository;
import com.unicom.girl.service.GirlService;
import com.unicom.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: girl <br/>
 * @Date: 2019/8/28 9:32 <br/>
 * @Author: yangjiabin
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);


    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        //System.out.println("girlList");
        logger.info("girlList");
        return girlRepository.findAll();
    }


//    /**
//     * 添加一个女生
//     *
//     * @param cupSize
//     * @param age
//     * @return
//     */
//    @PostMapping(value = "/girls")
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
//                        @RequestParam("age") Integer age){
//        Girl girl = new Girl();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//
//        return girlRepository.save(girl);
//    }



    /**
     * 添加一个女生   (对原版进行改进  使用对象接受数据)
     *
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid  Girl girl, BindingResult bindingResult){


//        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//            return null;
//        }
//        girl.setCupSize(girl.getCupSize());
//        girl.setAge(girl.getAge());
//        return girlRepository.save(girl);


        if(bindingResult.hasErrors()){
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }




    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return  girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }


    @PostMapping(value = "/girls/two")
    public void girlTwo() throws RuntimeException {

            girlService.insertTwo();

    }

    @GetMapping(value = "girls/getAge_exception/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
        girlService.getAge(id);
    }


}
