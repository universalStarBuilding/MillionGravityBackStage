package com.fengyu.modules.webservice.user.vo;

import com.fengyu.common.utils.Constant;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by admin on 2016/6/27.
 */
@XmlRootElement
public class FormVo {


    //@Email
    private String email;

    @Pattern(message = Constant.EmailInvalidError,regexp = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
