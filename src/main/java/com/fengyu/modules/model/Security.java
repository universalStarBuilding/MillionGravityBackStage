package com.fengyu.modules.model;

import com.fengyu.common.persistence.DataEntity;

/**
 * Created by admin on 2016/6/23.
 * 安全信息
 */
public class Security extends DataEntity<Security>{


    public static void main(String[] args) {
        String str = "15269103792";
        System.out.println(str.replace(str.substring(3,7),"****"));
    }
}
