package com.houser.view;

import com.houser.domain.House;
import com.houser.service.HouseService;
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
    //系统最多5套房子信息
    private HouseService houseService = new HouseService(5);
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
                    //System.out.println("新增");
                    addHouse();
                    break;
                case '2':
                    System.out.println("查找");
                    break;
                case '3':
                    //System.out.println("删除");
                    deleteHouse();
                    break;
                case '4':
                    System.out.println("修改");
                    break;
                case '5':
                    //System.out.println("房屋列表");
                    listHouses();
                    break;
                case '6':
                    //System.out.println("退出");
                    exit();
                    break;
            }
        }while(loop);
    }

    /**
     * 房屋信息界面
     */
    public void listHouses()
    {
        System.out.println("==============房屋列表==============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        House[] house=houseService.list();
        for (int i = 0; i < houseService.getSize(); i++)
        {
            System.out.println(house[i]);
        }
        System.out.println("==============房屋列表展示完毕==============");
    }

    /**
     * 房屋新增界面
     */
    public void addHouse()
    {
        System.out.println("==============房屋新增界面==============");
        System.out.print("房屋拥有者姓名：");
        String name=Utility.readString(10);
        System.out.print("房屋拥有者电话：");
        String phone=Utility.readString(13);
        System.out.print("房屋地址：");
        String address=Utility.readString(50);
        System.out.print("房屋月租：");
        double rent=Utility.readInt();
        System.out.print("房屋状态：");
        String state=Utility.readString(6,"未出租");
        House newHouse=new House(0,name,phone,address,rent,state);
        if(houseService.addHouse(newHouse))
        {
            System.out.println("==============房屋新增成功==============");
        }
        else {
            System.out.println("==============房屋新增失败==============");
        }
    }

    /**
     * 删除房屋界面
     */
    public void deleteHouse()
    {
        System.out.println("==============删除房屋==============");
        System.out.print("请输入待删除的房屋编号（-1退出）：");
        int choose=Utility.readInt();

        if(choose==-1)
        {
            System.out.println("==============放弃删除房屋信息==============");
        }
        else if(choose>0&&choose<= houseService.getSize())
        {
            System.out.println("确认是否删除，请小心选择");
            System.out.print("请输入你的选择(Y/N)：");
            char ifDelete = Utility.readConfirmSelection();
            if(ifDelete=='Y')
            {
                boolean temp = houseService.deleteHouse(choose);
                if (temp)
                {
                    System.out.println("==============删除完成==============");
                } else
                {
                    System.out.println("==============删除失败==============");
                }
            }
            else {
                System.out.println("==============放弃删除=============");
            }
        }
    }

    /**
     * 退出确认
     */
    public void exit()
    {
        char c=Utility.readConfirmSelection();
        if(c=='Y')
        {
            loop=false;
        }
    }
}
