package com.example.cis183_homework01_program01;

import android.graphics.Color;

//==================================================================
//Author: Allison DeCarlo
//Date  : 10/05/2025
//Desc  : RGB Homework02
//==================================================================
public class ColorInfo
{
    int R;
    int G;
    int B;
    String hexadecimal;
    int textColor;

    //overloaded constructor
    public ColorInfo(int r, int g, int b, String hexadecimal, int textColor)
    {
        R = r;
        G = g;
        B = b;
        this.hexadecimal = hexadecimal;
        this.textColor = textColor;
    }

    public ColorInfo()
    {

    }

    //getters and setters
    public int getR()
    {
        return R;
    }

    public void setR(int r)
    {
        R = r;
    }

    public int getG()
    {
        return G;
    }

    public void setG(int g)
    {
        G = g;
    }

    public int getB()
    {
        return B;
    }

    public void setB(int b)
    {
        B = b;
    }

    public String getHexadecimal()
    {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal)
    {
        this.hexadecimal = hexadecimal;
    }

    public int getTextColor()
    {
        return textColor;
    }

    public void setTextColor(int textColor)
    {
        this.textColor = textColor;
    }
}
