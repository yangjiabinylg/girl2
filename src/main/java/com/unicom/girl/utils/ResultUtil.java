package com.unicom.girl.utils;

import com.unicom.girl.domain.Result;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: girl <br/>
 * @Date: 2019/9/2 14:00 <br/>
 * @Author: yangjiabin
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }


    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }



}
