package com.houser.view;

import com.houser.utils.Utility;

/**
 * 1.显示界面
 * 2.接受用户的输入
 * 3.调用HouseService完成对房屋的各种操作
 */
public class HouseView
{
    private boolean loop=true;
    private char key=' ';
    public void mainMenu()
    {
        do{
            System.out.println("==============房屋出租系统==============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退 出");
            System.out.println("请输入你的选择（1-6）：");
            key= Utility.readChar();
            switch(key)
            {
                case '1':
                    System.out.println("新增");
                    break;
                case '2':
                    System.out.println("查找");
                    break;
                case '3':
                    System.out.println("删除");
                    break;
                case '4':
                    System.out.println("修改");
                    break;
                case '5':
                    System.out.println("房屋列表");
                    break;
                case '6':
                    System.out.println("退出");
                    loop=false;
                    break;
            }
        }while(loop);
    }
}
