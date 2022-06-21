package com.houser.service;

import com.houser.domain.House;
import lombok.Data;

@Data
public class HouseService
{
    private int size=1;
    private House[] houses;
    public HouseService(int size)
    {
        this.houses = new House[size];
        //系统默认有一套房子
        houses[0]=new House(1,"jack","139","江苏徐州",1200,"出租中");
    }
    /**
     * 返回所有房屋信息
     */
    public House[] list()
    {
        return houses;
    }

    /**
     * 添加房屋
     */
    public boolean addHouse(House house)
    {
        if(getSize()>=houses.length)
        {
            System.out.println("房屋数量已达系统上限!");
            return false;
        }
        else
        {
            houses[getSize()] = new House(getSize(), house.getName(),house.getPhone(),
                    house.getAddress(),house.getMonthly_rent(),
                    house.getState());
            houses[getSize()].setId(getSize()+1);
            setSize(getSize() + 1);
            return true;
        }
    }

    /**
     * 删除房子
     */
    public boolean deleteHouse(int choose)
    {
        if(getSize()>0)
        {
            for (int i = choose - 1; i < getSize()-1; i++)
            {
                houses[i] = houses[i + 1];
                houses[i].setId(houses[i].getId()-1);//房子删除，编号前移
            }
            houses[getSize()-1]=null;
            setSize(getSize() - 1);
            return true;
        }
        else {
            System.out.println("系统已经没有任何房子信息");
            return false;
        }
    }

}
