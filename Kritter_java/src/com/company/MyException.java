package com.company;

class MyException extends Exception
{
    public MyException(String str)
    {
        System.out.println(str);
    }
}
