package com.stuspcloud.user.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data

public class User{
    // id

    //开启主键自动回填

    public Long id;

    // 用户名
    public String userName;

    // 密码
    private String password;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 性别，1男性，2女性
    private Integer sex;

    // 出生日期
    private Date birthday;

    // 创建时间
    private Date created;

    // 更新时间
    private Date updated;

    // 备注
    private String note;
}