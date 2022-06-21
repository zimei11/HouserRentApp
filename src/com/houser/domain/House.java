package com.houser.domain;

import lombok.*;

/**
 * House的对象表示一个房屋的信息
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class House
{
    private int id;
    private String name;
    private String phone;
    private String address;
    private double monthly_rent;
    private String state;

    @Override
    public String toString()
    {
        return  id +
                "\t" + name  +
                "\t" + phone  +
                "\t" + address  +
                "\t" + monthly_rent +
                "\t" + state ;
    }
}
