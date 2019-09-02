package com.unicom.girl.exception;

import com.unicom.girl.enums.ResultEnum;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: girl <br/>
 * @Date: 2019/9/2 14:30 <br/>
 * @Author: yangjiabin
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
