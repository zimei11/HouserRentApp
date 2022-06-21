package com.houser;

import com.houser.view.HouseView;

public class HouseRentApp
{
    public static void main(String[] args)
    {
        //创建HouseView对象，并显示主菜单,程序的入口
        new HouseView().mainMenu();
        System.out.println("===你退出了房屋出租系统===");
    }
}
