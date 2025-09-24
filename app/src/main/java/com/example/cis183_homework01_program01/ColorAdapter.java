package com.example.cis183_homework01_program01;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ColorAdapter extends ArrayAdapter<ColorInfo>
{
    //Here is the video tutorial I used for this:
    //https://www.youtube.com/watch?v=6qYNxtG0LNE

    public ColorAdapter(Context context, int resource, List<ColorInfo> colorList)
    {
        super(context, resource, colorList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        ColorInfo colorInfo = getItem(position);

        //initializing all the views
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.color_cell, parent, false);
        }

        TextView tv_j_colorCell_red = (TextView) convertView.findViewById(R.id.tv_v_colorCell_red);
        TextView tv_j_colorCell_green = (TextView) convertView.findViewById(R.id.tv_v_colorCell_green);
        TextView tv_j_colorCell_blue = (TextView) convertView.findViewById(R.id.tv_v_colorCell_blue);
        TextView tv_j_colorCell_redNum = (TextView) convertView.findViewById(R.id.tv_v_colorCell_redNum);
        TextView tv_j_colorCell_greenNum = (TextView) convertView.findViewById(R.id.tv_v_colorCell_greenNum);
        TextView tv_j_colorCell_blueNum = (TextView) convertView.findViewById(R.id.tv_v_colorCell_blueNum);
        TextView tv_j_colorCell_hex = (TextView) convertView.findViewById(R.id.tv_v_colorCell_hex);
        TextView tv_j_colorCell_hexNum = (TextView) convertView.findViewById(R.id.tv_v_colorCell_hexNum);

        //setting the text
        tv_j_colorCell_redNum.setText(Integer.valueOf(colorInfo.getR()).toString());
        tv_j_colorCell_greenNum.setText(Integer.valueOf(colorInfo.getG()).toString());
        tv_j_colorCell_blueNum.setText(Integer.valueOf(colorInfo.getB()).toString());
        tv_j_colorCell_hexNum.setText(colorInfo.getHexadecimal());

        //setting the color of the text
        tv_j_colorCell_red.setTextColor(colorInfo.getTextColor());
        tv_j_colorCell_green.setTextColor(colorInfo.getTextColor());
        tv_j_colorCell_blue.setTextColor(colorInfo.getTextColor());
        tv_j_colorCell_hex.setTextColor(colorInfo.getTextColor());
        tv_j_colorCell_redNum.setTextColor(colorInfo.getTextColor());
        tv_j_colorCell_greenNum.setTextColor(colorInfo.getTextColor());
        tv_j_colorCell_blueNum.setTextColor(colorInfo.getTextColor());
        tv_j_colorCell_hexNum.setTextColor(colorInfo.getTextColor());


        String hex = "#" + tv_j_colorCell_hexNum.getText().toString();
        convertView.setBackgroundColor(Color.parseColor(hex));

        return convertView;


    }
}
