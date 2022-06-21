package com.houser.utils;

public class TestUtility
{
    public static void main(String[] args)
    {
        //测试工具类，输入长度为10的字符串，直接敲回车返回默认语句。
        String s=Utility.readString(10,"请输入内容啊小伙计");
        System.out.println(s);
    }
}
