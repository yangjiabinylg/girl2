package com.unicom.girl.enums;

/**
 * @Copyright: Unicom (Zhejiang) Industrial Internet Co., Ltd.    2019 <br/>
 * @Desc: <br/>
 * @ProjectName: girl <br/>
 * @Date: 2019/9/2 14:55 <br/>
 * @Author: yangjiabin
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCES(0,"成功"),
    PRIMARY_SCHOOL(100,"小学"),
    MIDDLE_SCHOOL(101,"初中"),
    UNIVERSITY_SCHOOL(102,"大学")
    ;


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
