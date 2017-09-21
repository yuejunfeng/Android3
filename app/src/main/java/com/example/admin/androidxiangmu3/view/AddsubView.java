package com.example.admin.androidxiangmu3.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.androidxiangmu3.R;

/**
 * Created by admin on 2017/9/21.
 */

public class AddsubView extends LinearLayout implements View.OnClickListener {
    private ImageView add_sub_jia;
    private ImageView add_sub_jian;
    private TextView tv_value;
    private int mValue;

    public AddsubView(Context context) {
        this(context, null);
    }

    public AddsubView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddsubView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context) {
        //把一个布局文件实例化，并且加载到AddsubView类中
        View  view = View.inflate(context,R.layout.item_add_sub,this);
        add_sub_jia = (ImageView) view.findViewById(R.id.add_sub_jia);
        add_sub_jian = (ImageView) view.findViewById(R.id.add_sub_jian);
        tv_value = (TextView) view.findViewById(R.id.tv_value);

        add_sub_jia.setOnClickListener(this);
        add_sub_jian.setOnClickListener(this);
        getValue();
        setValue(value);
    }
    private  int value = 1;
    private int mMaxValue =5;
    private int mMinValue =1;

    public void setmMaxValue(int mMaxValue) {
        this.mMaxValue = mMaxValue;
    }

    public void setmMinValue(int mMinValue) {
        this.mMinValue = mMinValue;
    }

    public int getValue() {
        String trim = tv_value.getText().toString().trim();
        if(!TextUtils.isEmpty(trim)){
            //转换int
            value=Integer.valueOf(trim);

        }

        return value;
    }
    private void setValue(int value) {
        mValue = value;
        tv_value.setText(value+"");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_sub_jia:
                addNumber();
                break;
            case R.id.add_sub_jian:
                subNumber();
                break;
        }

    }

    private void addNumber() {
        if(value < mMaxValue){
            value++;
        }

        setValue(value);
        Toast.makeText(getContext(), "当前值"+value, Toast.LENGTH_SHORT).show();
    }

    private void subNumber() {
        if(value > mMinValue ){
            value--;
        }
        setValue(value);
        Toast.makeText(getContext(), "当前值"+value, Toast.LENGTH_SHORT).show();
    }
    //定义接口
    public interface OnNumberChanger{
        void OnNumber(int value);
    }
    //定义接口对象
    private OnNumberChanger mOnNumberChanger;
    //设置方法接受外界传来的接口对象方法
    public void setOnNumberChanger(OnNumberChanger onnumberChanger){
        mOnNumberChanger = onnumberChanger;
    }
}
