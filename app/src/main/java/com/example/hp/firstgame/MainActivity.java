package com.example.hp.firstgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,
           btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25;
    TextView fjz,zzz;
    int turn = 0; //回合数,fjz先行
    boolean[] not_used = new boolean[26];//格子是否被点击过
    int[] token = new int[26]; //格子的归属。0为中立，1为fjz，2为zzz。
    int fjzScore,zzzScore;//两人的总分

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化各组件
        init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[1]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[1] = 1;
                        //颜色变成黄色
                        btn1.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn1.getText().toString());
                        //判断是否能进行占领
                        if(token[2]==1 || token[6]==1){
                            if(token[2]==2){
                                token[2] = 1;
                                btn2.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn2.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn2.getText().toString());
                            }else{
                                token[6] = 1;
                                btn6.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn6.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn6.getText().toString());
                            }
                        }
                    //zzz回合
                    }else{
                        token[1] = 2;
                        //颜色变成青色
                        btn1.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn1.getText().toString());
                        //判断是否能进行占领
                        if(token[2]==2 || token[6]==2){
                            if(token[2]==1){
                                token[2] = 2;
                                btn2.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn2.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn2.getText().toString());
                            }else{
                                token[6] = 2;
                                btn6.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn6.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn6.getText().toString());
                            }
                        }
                    }
                    turnOver(1);
                }else{
                    //如果已经被占领，则报错
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[2]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[2] = 1;
                        //颜色变成黄色
                        btn2.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn2.getText().toString());
                        //判断是否能进行占领
                        if(token[1]==1 || token[3]==1 || token[7]==1){
                            if(token[1]==2){
                                token[1] = 1;
                                btn1.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn1.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn1.getText().toString());
                            }
                            if(token[3]==2){
                                token[3] = 1;
                                btn3.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn3.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn3.getText().toString());
                            }
                            if(token[7]==2){
                                token[7] = 1;
                                btn7.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn7.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn7.getText().toString());
                            }
                        }
                    }else{
                        token[2] = 2;
                        //颜色变成青色
                        btn2.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn2.getText().toString());
                        //判断是否能进行占领
                        if(token[1]==2 || token[3]==2 || token[7]==2){
                            if(token[1]==1){
                                token[1] = 2;
                                btn1.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn1.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn1.getText().toString());
                            }
                            if(token[3]==1){
                                token[3] = 2;
                                btn3.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn3.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn3.getText().toString());
                            }
                            if(token[7]==1){
                                token[7] = 2;
                                btn7.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn7.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn7.getText().toString());
                            }
                        }
                    }
                    turnOver(2);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[3]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[3] = 1;
                        //颜色变成黄色
                        btn3.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn3.getText().toString());
                        //判断是否能进行占领
                        if(token[2]==1 || token[4]==1 || token[8]==1){
                            if(token[2]==2){
                                token[2] = 1;
                                btn2.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn2.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn2.getText().toString());
                            }
                            if(token[4]==2){
                                token[4] = 1;
                                btn4.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn4.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn4.getText().toString());
                            }
                            if(token[8]==2){
                                token[8] = 1;
                                btn8.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn8.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn8.getText().toString());
                            }
                        }
                    }else{
                        token[3] = 2;
                        //颜色变成青色
                        btn3.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn3.getText().toString());
                        //判断是否能进行占领
                        if(token[2]==2 || token[4]==2 || token[8]==2){
                            if(token[2]==1){
                                token[2] = 2;
                                btn2.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn2.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn2.getText().toString());
                            }
                            if(token[4]==1){
                                token[4] = 2;
                                btn4.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn4.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn4.getText().toString());
                            }
                            if(token[8]==1){
                                token[8] = 2;
                                btn8.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn8.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn8.getText().toString());
                            }
                        }
                    }
                    turnOver(3);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[4]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[4] = 1;
                        //颜色变成黄色
                        btn4.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn4.getText().toString());
                        //判断是否能进行占领
                        if(token[3]==1 || token[5]==1 || token[9]==1){
                            if(token[3]==2){
                                token[3] = 1;
                                btn3.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn3.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn3.getText().toString());
                            }
                            if(token[5]==2){
                                token[5] = 1;
                                btn5.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn5.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn5.getText().toString());
                            }
                            if(token[9]==2){
                                token[9] = 1;
                                btn9.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn9.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn9.getText().toString());
                            }
                        }
                    }else{
                        token[4] = 2;
                        //颜色变成青色
                        btn4.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn4.getText().toString());
                        //判断是否能进行占领
                        if(token[3]==2 || token[5]==2 || token[9]==2){
                            if(token[3]==1){
                                token[3] = 2;
                                btn3.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn3.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn3.getText().toString());
                            }
                            if(token[5]==1){
                                token[5] = 2;
                                btn5.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn5.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn5.getText().toString());
                            }
                            if(token[9]==1){
                                token[9] = 2;
                                btn9.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn9.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn9.getText().toString());
                            }
                        }
                    }
                    turnOver(4);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[5]){
                    token[5] = 1;
                    //fjz回合
                    if(turn%2 == 0){
                        //颜色变成黄色
                        btn5.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn5.getText().toString());
                        //判断是否能进行占领
                        if(token[4]==1 || token[10]==1){
                            if(token[4]==2){
                                token[4] = 1;
                                btn4.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn4.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn4.getText().toString());
                            }else{
                                token[10] = 1;
                                btn10.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn10.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn10.getText().toString());
                            }
                        }
                        //zzz回合
                    }else{
                        token[5] = 2;
                        //颜色变成青色
                        btn5.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn5.getText().toString());
                        //判断是否能进行占领
                        if(token[4]==2 || token[10]==2){
                            if(token[4]==1){
                                token[4] = 2;
                                btn4.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn4.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn4.getText().toString());
                            }else{
                                token[10] = 2;
                                btn10.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn10.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn10.getText().toString());
                            }
                        }
                    }
                    turnOver(5);
                }else{
                    //如果已经被占领，则报错
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[6]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[6] = 1;
                        //颜色变成黄色
                        btn6.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn6.getText().toString());
                        //判断是否能进行占领
                        if(token[1]==1 || token[7]==1 || token[11]==1){
                            if(token[1]==2){
                                token[1] = 1;
                                btn1.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn1.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn1.getText().toString());
                            }
                            if(token[7]==2){
                                token[7] = 1;
                                btn7.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn7.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn7.getText().toString());
                            }
                            if(token[11]==2){
                                token[11] = 1;
                                btn11.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn11.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn11.getText().toString());
                            }
                        }
                    }else{
                        token[6] = 2;
                        //颜色变成青色
                        btn6.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn6.getText().toString());
                        //判断是否能进行占领
                        if(token[1]==2 || token[7]==2 || token[11]==2){
                            if(token[1]==1){
                                token[1] = 2;
                                btn1.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn1.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn1.getText().toString());
                            }
                            if(token[7]==1){
                                token[7] = 2;
                                btn7.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn7.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn7.getText().toString());
                            }
                            if(token[11]==1){
                                token[11] = 2;
                                btn11.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn11.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn11.getText().toString());
                            }
                        }
                    }
                    turnOver(6);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[7]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[7] = 1;
                        //颜色变成黄色
                        btn7.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn7.getText().toString());
                        //判断是否能进行占领
                        if(token[2]==1 || token[6]==1 || token[8]==1 || token[12]==1){
                            if(token[2]==2){
                                token[2] = 1;
                                btn2.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn2.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn2.getText().toString());
                            }
                            if(token[6]==2){
                                token[6] = 1;
                                btn6.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn6.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn6.getText().toString());
                            }
                            if(token[8]==2){
                                token[8] = 1;
                                btn8.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn8.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn8.getText().toString());
                            }
                            if(token[12]==2){
                                token[12] = 1;
                                btn12.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn12.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn12.getText().toString());
                            }
                        }
                    }else{
                        token[7] = 2;
                        //颜色变成青色
                        btn7.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn7.getText().toString());
                        //判断是否能进行占领
                        if(token[2]==2 || token[6]==2 || token[8]==2 || token[12]==2){
                            if(token[2]==1){
                                token[2] = 2;
                                btn2.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn2.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn2.getText().toString());
                            }
                            if(token[6]==1){
                                token[6] = 2;
                                btn6.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn6.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn6.getText().toString());
                            }
                            if(token[8]==1){
                                token[8] = 2;
                                btn8.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn8.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn8.getText().toString());
                            }
                            if(token[12]==1){
                                token[12] = 2;
                                btn12.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn12.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn12.getText().toString());
                            }
                        }
                    }
                    turnOver(7);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[8]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[8] = 1;
                        //颜色变成黄色
                        btn8.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn8.getText().toString());
                        //判断是否能进行占领
                        if(token[3]==1 || token[7]==1 || token[9]==1 || token[13]==1){
                            if(token[3]==2){
                                token[3] = 1;
                                btn3.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn3.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn3.getText().toString());
                            }
                            if(token[7]==2){
                                token[7] = 1;
                                btn7.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn7.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn7.getText().toString());
                            }
                            if(token[9]==2){
                                token[9] = 1;
                                btn9.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn9.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn9.getText().toString());
                            }
                            if(token[13]==2){
                                token[13] = 1;
                                btn13.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn13.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn13.getText().toString());
                            }
                        }
                    }else{
                        token[8] = 2;
                        //颜色变成青色
                        btn8.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn8.getText().toString());
                        //判断是否能进行占领
                        if(token[3]==2 || token[7]==2 || token[9]==2 || token[13]==2){
                            if(token[3]==1){
                                token[3] = 2;
                                btn3.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn3.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn3.getText().toString());
                            }
                            if(token[7]==1){
                                token[7] = 2;
                                btn7.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn7.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn7.getText().toString());
                            }
                            if(token[9]==1){
                                token[9] = 2;
                                btn9.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn9.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn9.getText().toString());
                            }
                            if(token[13]==1){
                                token[13] = 2;
                                btn13.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn13.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn13.getText().toString());
                            }
                        }
                    }
                    turnOver(8);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[9]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[9] = 1;
                        //颜色变成黄色
                        btn9.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn9.getText().toString());
                        //判断是否能进行占领
                        if(token[4]==1 || token[8]==1 || token[10]==1 || token[14]==1){
                            if(token[4]==2){
                                token[4] = 1;
                                btn4.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn4.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn4.getText().toString());
                            }
                            if(token[8]==2){
                                token[8] = 1;
                                btn8.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn8.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn8.getText().toString());
                            }
                            if(token[10]==2){
                                token[10] = 1;
                                btn10.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn10.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn10.getText().toString());
                            }
                            if(token[14]==2){
                                token[14] = 1;
                                btn14.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn14.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn14.getText().toString());
                            }
                        }
                    }else{
                        token[9] = 2;
                        //颜色变成青色
                        btn9.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn9.getText().toString());
                        //判断是否能进行占领
                        if(token[4]==2 || token[8]==2 || token[10]==2 || token[14]==2){
                            if(token[4]==1){
                                token[4] = 2;
                                btn4.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn4.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn4.getText().toString());
                            }
                            if(token[8]==1){
                                token[8] = 2;
                                btn8.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn8.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn8.getText().toString());
                            }
                            if(token[10]==1){
                                token[10] = 2;
                                btn10.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn10.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn10.getText().toString());
                            }
                            if(token[14]==1){
                                token[14] = 2;
                                btn14.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn14.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn14.getText().toString());
                            }
                        }
                    }
                    turnOver(9);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[10]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[10] = 1;
                        //颜色变成黄色
                        btn10.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn10.getText().toString());
                        //判断是否能进行占领
                        if(token[5]==1 || token[9]==1 || token[15]==1){
                            if(token[5]==2){
                                token[5] = 1;
                                btn5.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn5.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn5.getText().toString());
                            }
                            if(token[9]==2){
                                token[9] = 1;
                                btn9.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn9.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn9.getText().toString());
                            }
                            if(token[15]==2){
                                token[15] = 1;
                                btn15.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn15.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn15.getText().toString());
                            }
                        }
                    }else{
                        token[10] = 2;
                        //颜色变成青色
                        btn10.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn10.getText().toString());
                        //判断是否能进行占领
                        if(token[5]==2 || token[9]==2 || token[15]==2){
                            if(token[5]==1){
                                token[5] = 2;
                                btn5.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn5.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn5.getText().toString());
                            }
                            if(token[9]==1){
                                token[9] = 2;
                                btn9.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn9.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn9.getText().toString());
                            }
                            if(token[15]==1){
                                token[15] = 2;
                                btn15.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn15.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn15.getText().toString());
                            }
                        }
                    }
                    turnOver(10);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[11]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[11] = 1;
                        //颜色变成黄色
                        btn11.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn11.getText().toString());
                        //判断是否能进行占领
                        if(token[6]==1 || token[12]==1 || token[16]==1){
                            if(token[6]==2){
                                token[6] = 1;
                                btn6.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn6.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn6.getText().toString());
                            }
                            if(token[12]==2){
                                token[12] = 1;
                                btn12.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn12.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn12.getText().toString());
                            }
                            if(token[16]==2){
                                token[16] = 1;
                                btn16.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn16.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn16.getText().toString());
                            }
                        }
                    }else{
                        token[11] = 2;
                        //颜色变成青色
                        btn11.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn11.getText().toString());
                        //判断是否能进行占领
                        if(token[6]==2 || token[12]==2 || token[16]==2){
                            if(token[6]==1){
                                token[6] = 2;
                                btn6.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn6.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn6.getText().toString());
                            }
                            if(token[12]==1){
                                token[12] = 2;
                                btn12.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn12.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn12.getText().toString());
                            }
                            if(token[16]==1){
                                token[16] = 2;
                                btn16.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn16.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn16.getText().toString());
                            }
                        }
                    }
                    turnOver(11);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[12]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[12] = 1;
                        //颜色变成黄色
                        btn12.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn12.getText().toString());
                        //判断是否能进行占领
                        if(token[7]==1 || token[11]==1 || token[13]==1 || token[17]==1){
                            if(token[7]==2){
                                token[7] = 1;
                                btn7.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn7.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn7.getText().toString());
                            }
                            if(token[11]==2){
                                token[11] = 1;
                                btn11.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn11.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn11.getText().toString());
                            }
                            if(token[13]==2){
                                token[13] = 1;
                                btn13.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn13.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn13.getText().toString());
                            }
                            if(token[17]==2){
                                token[17] = 1;
                                btn17.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn17.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn17.getText().toString());
                            }
                        }
                    }else{
                        token[12] = 2;
                        //颜色变成青色
                        btn12.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn12.getText().toString());
                        //判断是否能进行占领
                        if(token[7]==2 || token[11]==2 || token[13]==2 || token[17]==2){
                            if(token[7]==1){
                                token[7] = 2;
                                btn7.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn7.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn7.getText().toString());
                            }
                            if(token[11]==1){
                                token[11] = 2;
                                btn11.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn11.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn11.getText().toString());
                            }
                            if(token[13]==1){
                                token[13] = 2;
                                btn13.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn13.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn13.getText().toString());
                            }
                            if(token[17]==1){
                                token[17] = 2;
                                btn17.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn17.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn17.getText().toString());
                            }
                        }
                    }
                    turnOver(12);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[13]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[13] = 1;
                        //颜色变成黄色
                        btn13.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn13.getText().toString());
                        //判断是否能进行占领
                        if(token[8]==1 || token[12]==1 || token[14]==1 || token[18]==1){
                            if(token[8]==2){
                                token[8] = 1;
                                btn8.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn8.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn8.getText().toString());
                            }
                            if(token[12]==2){
                                token[12] = 1;
                                btn12.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn12.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn12.getText().toString());
                            }
                            if(token[14]==2){
                                token[14] = 1;
                                btn14.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn14.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn14.getText().toString());
                            }
                            if(token[18]==2){
                                token[18] = 1;
                                btn18.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn18.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn18.getText().toString());
                            }
                        }
                    }else{
                        token[13] = 2;
                        //颜色变成青色
                        btn13.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn13.getText().toString());
                        //判断是否能进行占领
                        if(token[8]==2 || token[12]==2 || token[14]==2 || token[18]==2){
                            if(token[8]==1){
                                token[8] = 2;
                                btn8.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn8.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn8.getText().toString());
                            }
                            if(token[12]==1){
                                token[12] = 2;
                                btn12.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn12.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn12.getText().toString());
                            }
                            if(token[14]==1){
                                token[14] = 2;
                                btn14.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn14.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn14.getText().toString());
                            }
                            if(token[18]==1){
                                token[18] = 2;
                                btn18.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn18.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn18.getText().toString());
                            }
                        }
                    }
                    turnOver(13);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[14]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[14] = 1;
                        //颜色变成黄色
                        btn14.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn14.getText().toString());
                        //判断是否能进行占领
                        if(token[9]==1 || token[13]==1 || token[15]==1 || token[19]==1){
                            if(token[9]==2){
                                token[9] = 1;
                                btn9.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn9.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn9.getText().toString());
                            }
                            if(token[13]==2){
                                token[13] = 1;
                                btn13.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn13.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn13.getText().toString());
                            }
                            if(token[15]==2){
                                token[15] = 1;
                                btn15.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn15.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn15.getText().toString());
                            }
                            if(token[19]==2){
                                token[19] = 1;
                                btn19.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn19.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn19.getText().toString());
                            }
                        }
                    }else{
                        token[14] = 2;
                        //颜色变成青色
                        btn14.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn14.getText().toString());
                        //判断是否能进行占领
                        if(token[9]==2 || token[13]==2 || token[15]==2 || token[19]==2){
                            if(token[9]==1){
                                token[9] = 2;
                                btn9.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn9.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn9.getText().toString());
                            }
                            if(token[13]==1){
                                token[13] = 2;
                                btn13.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn13.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn13.getText().toString());
                            }
                            if(token[15]==1){
                                token[15] = 2;
                                btn15.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn15.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn15.getText().toString());
                            }
                            if(token[19]==1){
                                token[19] = 2;
                                btn19.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn19.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn19.getText().toString());
                            }
                        }
                    }
                    turnOver(14);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[15]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[15] = 1;
                        //颜色变成黄色
                        btn15.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn15.getText().toString());
                        //判断是否能进行占领
                        if(token[10]==1 || token[14]==1 || token[20]==1){
                            if(token[10]==2){
                                token[10] = 1;
                                btn10.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn10.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn10.getText().toString());
                            }
                            if(token[14]==2){
                                token[14] = 1;
                                btn14.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn14.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn14.getText().toString());
                            }
                            if(token[20]==2){
                                token[20] = 1;
                                btn20.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn20.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn20.getText().toString());
                            }
                        }
                    }else{
                        token[15] = 2;
                        //颜色变成青色
                        btn15.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn15.getText().toString());
                        //判断是否能进行占领
                        if(token[10]==2 || token[14]==2 || token[20]==2){
                            if(token[10]==1){
                                token[10] = 2;
                                btn10.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn10.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn10.getText().toString());
                            }
                            if(token[14]==1){
                                token[14] = 2;
                                btn14.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn14.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn14.getText().toString());
                            }
                            if(token[20]==1){
                                token[20] = 2;
                                btn20.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn20.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn20.getText().toString());
                            }
                        }
                    }
                    turnOver(15);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[16]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[16] = 1;
                        //颜色变成黄色
                        btn16.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn16.getText().toString());
                        //判断是否能进行占领
                        if(token[11]==1 || token[17]==1 || token[21]==1){
                            if(token[11]==2){
                                token[11] = 1;
                                btn11.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn11.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn11.getText().toString());
                            }
                            if(token[17]==2){
                                token[17] = 1;
                                btn17.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn17.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn17.getText().toString());
                            }
                            if(token[21]==2){
                                token[21] = 1;
                                btn21.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn21.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn21.getText().toString());
                            }
                        }
                    }else{
                        token[16] = 2;
                        //颜色变成青色
                        btn16.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn16.getText().toString());
                        //判断是否能进行占领
                        if(token[10]==2 || token[14]==2 || token[20]==2){
                            if(token[11]==1){
                                token[11] = 2;
                                btn11.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn11.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn11.getText().toString());
                            }
                            if(token[17]==1){
                                token[17] = 2;
                                btn17.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn17.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn17.getText().toString());
                            }
                            if(token[21]==1){
                                token[21] = 2;
                                btn21.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn21.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn21.getText().toString());
                            }
                        }
                    }
                    turnOver(16);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[17]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[17] = 1;
                        //颜色变成黄色
                        btn17.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn17.getText().toString());
                        //判断是否能进行占领
                        if(token[12]==1 || token[16]==1 || token[18]==1 || token[22]==1){
                            if(token[12]==2){
                                token[12] = 1;
                                btn12.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn12.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn12.getText().toString());
                            }
                            if(token[16]==2){
                                token[16] = 1;
                                btn16.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn16.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn16.getText().toString());
                            }
                            if(token[18]==2){
                                token[18] = 1;
                                btn18.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn18.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn18.getText().toString());
                            }
                            if(token[22]==2){
                                token[22] = 1;
                                btn22.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn22.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn22.getText().toString());
                            }
                        }
                    }else{
                        token[17] = 2;
                        //颜色变成青色
                        btn17.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn17.getText().toString());
                        //判断是否能进行占领
                        if(token[12]==2 || token[16]==2 || token[18]==2 || token[22]==2){
                            if(token[12]==1){
                                token[12] = 2;
                                btn12.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn12.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn12.getText().toString());
                            }
                            if(token[16]==1){
                                token[16] = 2;
                                btn16.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn16.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn16.getText().toString());
                            }
                            if(token[18]==1){
                                token[18] = 2;
                                btn18.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn18.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn18.getText().toString());
                            }
                            if(token[22]==1){
                                token[22] = 2;
                                btn22.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn22.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn22.getText().toString());
                            }
                        }
                    }
                    turnOver(17);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[18]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[18] = 1;
                        //颜色变成黄色
                        btn18.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn18.getText().toString());
                        //判断是否能进行占领
                        if(token[13]==1 || token[17]==1 || token[19]==1 || token[23]==1){
                            if(token[13]==2){
                                token[13] = 1;
                                btn13.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn13.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn13.getText().toString());
                            }
                            if(token[17]==2){
                                token[17] = 1;
                                btn17.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn17.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn17.getText().toString());
                            }
                            if(token[19]==2){
                                token[19] = 1;
                                btn19.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn19.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn19.getText().toString());
                            }
                            if(token[23]==2){
                                token[23] = 1;
                                btn23.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn23.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn23.getText().toString());
                            }
                        }
                    }else{
                        token[18] = 2;
                        //颜色变成青色
                        btn18.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn18.getText().toString());
                        //判断是否能进行占领
                        if(token[13]==2 || token[17]==2 || token[19]==2 || token[23]==2){
                            if(token[13]==1){
                                token[13] = 2;
                                btn13.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn13.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn13.getText().toString());
                            }
                            if(token[17]==1){
                                token[17] = 2;
                                btn17.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn17.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn17.getText().toString());
                            }
                            if(token[19]==1){
                                token[19] = 2;
                                btn19.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn19.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn19.getText().toString());
                            }
                            if(token[23]==1){
                                token[23] = 2;
                                btn23.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn23.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn23.getText().toString());
                            }
                        }
                    }
                    turnOver(18);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[19]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[19] = 1;
                        //颜色变成黄色
                        btn19.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn19.getText().toString());
                        //判断是否能进行占领
                        if(token[14]==1 || token[18]==1 || token[20]==1 || token[24]==1){
                            if(token[14]==2){
                                token[14] = 1;
                                btn14.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn14.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn14.getText().toString());
                            }
                            if(token[18]==2){
                                token[18] = 1;
                                btn18.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn18.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn18.getText().toString());
                            }
                            if(token[20]==2){
                                token[20] = 1;
                                btn20.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn20.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn20.getText().toString());
                            }
                            if(token[24]==2){
                                token[24] = 1;
                                btn24.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn24.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn24.getText().toString());
                            }
                        }
                    }else{
                        token[19] = 2;
                        //颜色变成青色
                        btn19.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn19.getText().toString());
                        //判断是否能进行占领
                        if(token[14]==2 || token[18]==2 || token[20]==2 || token[24]==2){
                            if(token[14]==1){
                                token[14] = 2;
                                btn14.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn14.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn14.getText().toString());
                            }
                            if(token[18]==1){
                                token[18] = 2;
                                btn18.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn18.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn18.getText().toString());
                            }
                            if(token[20]==1){
                                token[20] = 2;
                                btn20.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn20.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn20.getText().toString());
                            }
                            if(token[24]==1){
                                token[24] = 2;
                                btn24.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn24.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn24.getText().toString());
                            }
                        }
                    }
                    turnOver(19);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[20]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[20] = 1;
                        //颜色变成黄色
                        btn20.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn20.getText().toString());
                        //判断是否能进行占领
                        if(token[15]==1 || token[19]==1 || token[25]==1){
                            if(token[15]==2){
                                token[15] = 1;
                                btn15.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn15.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn15.getText().toString());
                            }
                            if(token[19]==2){
                                token[19] = 1;
                                btn19.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn19.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn19.getText().toString());
                            }
                            if(token[25]==2){
                                token[25] = 1;
                                btn25.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn25.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn25.getText().toString());
                            }
                        }
                    }else{
                        token[20] = 2;
                        //颜色变成青色
                        btn20.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn20.getText().toString());
                        //判断是否能进行占领
                        if(token[15]==2 || token[19]==2 || token[25]==2){
                            if(token[15]==1){
                                token[15] = 2;
                                btn15.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn15.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn15.getText().toString());
                            }
                            if(token[19]==1){
                                token[19] = 2;
                                btn19.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn19.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn19.getText().toString());
                            }
                            if(token[25]==1){
                                token[25] = 2;
                                btn25.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn25.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn25.getText().toString());
                            }
                        }
                    }
                    turnOver(20);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[21]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[21] = 1;
                        //颜色变成黄色
                        btn21.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn21.getText().toString());
                        //判断是否能进行占领
                        if(token[16]==1 || token[22]==1){
                            if(token[16]==2){
                                token[16] = 1;
                                btn16.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn16.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn16.getText().toString());
                            }else{
                                token[22] = 1;
                                btn22.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn22.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn22.getText().toString());
                            }
                        }
                        //zzz回合
                    }else{
                        token[21] = 2;
                        //颜色变成青色
                        btn21.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn21.getText().toString());
                        //判断是否能进行占领
                        if(token[16]==2 || token[22]==2){
                            if(token[16]==1){
                                token[16] = 2;
                                btn16.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn16.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn16.getText().toString());
                            }else{
                                token[22] = 2;
                                btn22.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn22.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn22.getText().toString());
                            }
                        }
                    }
                    turnOver(21);
                }else{
                    //如果已经被占领，则报错
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[22]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[22] = 1;
                        //颜色变成黄色
                        btn22.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn22.getText().toString());
                        //判断是否能进行占领
                        if(token[17]==1 || token[21]==1 || token[23]==1){
                            if(token[17]==2){
                                token[17] = 1;
                                btn17.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn17.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn17.getText().toString());
                            }
                            if(token[21]==2){
                                token[21] = 1;
                                btn21.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn21.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn21.getText().toString());
                            }
                            if(token[23]==2){
                                token[23] = 1;
                                btn23.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn23.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn23.getText().toString());
                            }
                        }
                    }else{
                        token[22] = 2;
                        //颜色变成青色
                        btn22.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn22.getText().toString());
                        //判断是否能进行占领
                        if(token[17]==2 || token[21]==2 || token[23]==2){
                            if(token[17]==1){
                                token[17] = 2;
                                btn17.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn17.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn17.getText().toString());
                            }
                            if(token[21]==1){
                                token[21] = 2;
                                btn21.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn21.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn21.getText().toString());
                            }
                            if(token[23]==1){
                                token[23] = 2;
                                btn23.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn23.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn23.getText().toString());
                            }
                        }
                    }
                    turnOver(22);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[23]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[23] = 1;
                        //颜色变成黄色
                        btn23.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn23.getText().toString());
                        //判断是否能进行占领
                        if(token[18]==1 || token[22]==1 || token[24]==1){
                            if(token[18]==2){
                                token[18] = 1;
                                btn18.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn18.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn18.getText().toString());
                            }
                            if(token[22]==2){
                                token[22] = 1;
                                btn22.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn22.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn22.getText().toString());
                            }
                            if(token[24]==2){
                                token[24] = 1;
                                btn24.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn24.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn24.getText().toString());
                            }
                        }
                    }else{
                        token[23] = 2;
                        //颜色变成青色
                        btn23.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn23.getText().toString());
                        //判断是否能进行占领
                        if(token[18]==2 || token[22]==2 || token[24]==2){
                            if(token[18]==1){
                                token[18] = 2;
                                btn18.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn18.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn18.getText().toString());
                            }
                            if(token[22]==1){
                                token[22] = 2;
                                btn22.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn22.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn22.getText().toString());
                            }
                            if(token[24]==1){
                                token[24] = 2;
                                btn24.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn24.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn24.getText().toString());
                            }
                        }
                    }
                    turnOver(23);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[24]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[24] = 1;
                        //颜色变成黄色
                        btn24.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn24.getText().toString());
                        //判断是否能进行占领
                        if(token[19]==1 || token[23]==1 || token[25]==1){
                            if(token[19]==2){
                                token[19] = 1;
                                btn19.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn19.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn19.getText().toString());
                            }
                            if(token[23]==2){
                                token[23] = 1;
                                btn23.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn23.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn23.getText().toString());
                            }
                            if(token[25]==2){
                                token[25] = 1;
                                btn25.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn25.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn25.getText().toString());
                            }
                        }
                    }else{
                        token[24] = 2;
                        //颜色变成青色
                        btn24.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn24.getText().toString());
                        //判断是否能进行占领
                        if(token[19]==2 || token[23]==2 || token[25]==2){
                            if(token[19]==1){
                                token[19] = 2;
                                btn19.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn19.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn19.getText().toString());
                            }
                            if(token[23]==1){
                                token[23] = 2;
                                btn23.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn23.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn23.getText().toString());
                            }
                            if(token[25]==1){
                                token[25] = 2;
                                btn25.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn25.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn25.getText().toString());
                            }
                        }
                    }
                    turnOver(24);
                }else{
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not_used[25]){
                    //fjz回合
                    if(turn%2 == 0){
                        token[25] = 1;
                        //颜色变成黄色
                        btn25.setBackgroundColor(0xffff8800);
                        //获得此处的分数
                        fjzScore = fjzScore + Integer.parseInt(btn25.getText().toString());
                        //判断是否能进行占领
                        if(token[20]==1 || token[24]==1){
                            if(token[20]==2){
                                token[20] = 1;
                                btn20.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn20.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn20.getText().toString());
                            }else{
                                token[24] = 1;
                                btn24.setBackgroundColor(0xffff8800);
                                fjzScore = fjzScore + Integer.parseInt(btn24.getText().toString());
                                zzzScore = zzzScore - Integer.parseInt(btn24.getText().toString());
                            }
                        }
                        //zzz回合
                    }else{
                        token[25] = 2;
                        //颜色变成青色
                        btn25.setBackgroundColor(0xff00ddff);
                        //获得此处的分数
                        zzzScore = zzzScore + Integer.parseInt(btn25.getText().toString());
                        //判断是否能进行占领
                        if(token[20]==2 || token[24]==2){
                            if(token[20]==1){
                                token[20] = 2;
                                btn20.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn20.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn20.getText().toString());
                            }else{
                                token[24] = 2;
                                btn24.setBackgroundColor(0xff00ddff);
                                fjzScore = fjzScore - Integer.parseInt(btn24.getText().toString());
                                zzzScore = zzzScore + Integer.parseInt(btn24.getText().toString());
                            }
                        }
                    }
                    turnOver(25);
                }else{
                    //如果已经被占领，则报错
                    Toast.makeText(MainActivity.this,"此处已被占领！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    //初始化各组件
    public void init(){
        btn1 = (Button)findViewById(R.id.block_A1);
        btn6 = (Button)findViewById(R.id.block_A2);
        btn11 = (Button)findViewById(R.id.block_A3);
        btn16 = (Button)findViewById(R.id.block_A4);
        btn21 = (Button)findViewById(R.id.block_A5);
        btn2 = (Button)findViewById(R.id.block_B1);
        btn7 = (Button)findViewById(R.id.block_B2);
        btn12 = (Button)findViewById(R.id.block_B3);
        btn17 = (Button)findViewById(R.id.block_B4);
        btn22 = (Button)findViewById(R.id.block_B5);
        btn3 = (Button)findViewById(R.id.block_C1);
        btn8 = (Button)findViewById(R.id.block_C2);
        btn13 = (Button)findViewById(R.id.block_C3);
        btn18 = (Button)findViewById(R.id.block_C4);
        btn23 = (Button)findViewById(R.id.block_C5);
        btn4 = (Button)findViewById(R.id.block_D1);
        btn9 = (Button)findViewById(R.id.block_D2);
        btn14 = (Button)findViewById(R.id.block_D3);
        btn19 = (Button)findViewById(R.id.block_D4);
        btn24 = (Button)findViewById(R.id.block_D5);
        btn5 = (Button)findViewById(R.id.block_E1);
        btn10 = (Button)findViewById(R.id.block_E2);
        btn15 = (Button)findViewById(R.id.block_E3);
        btn20 = (Button)findViewById(R.id.block_E4);
        btn25 = (Button)findViewById(R.id.block_E5);
        //给每个格子设定分数
        int[] score = new int[26];
        for(int i=0;i<26;i++){
            Random random = new Random();
            score[i] = random.nextInt(10)+1;
        }
        btn1.setText(score[1]+"");
        btn2.setText(score[2]+"");
        btn3.setText(score[3]+"");
        btn4.setText(score[4]+"");
        btn5.setText(score[5]+"");
        btn6.setText(score[6]+"");
        btn7.setText(score[7]+"");
        btn8.setText(score[8]+"");
        btn9.setText(score[9]+"");
        btn10.setText(score[10]+"");
        btn11.setText(score[11]+"");
        btn12.setText(score[12]+"");
        btn13.setText(score[13]+"");
        btn14.setText(score[14]+"");
        btn15.setText(score[15]+"");
        btn16.setText(score[16]+"");
        btn17.setText(score[17]+"");
        btn18.setText(score[18]+"");
        btn19.setText(score[19]+"");
        btn20.setText(score[20]+"");
        btn21.setText(score[21]+"");
        btn22.setText(score[22]+"");
        btn23.setText(score[23]+"");
        btn24.setText(score[24]+"");
        btn25.setText(score[25]+"");
        //初始化格子使用情况
        for(int i=0;i<26;i++){
            not_used[i] = true;
        }
        //初始化格子使用情况
        for(int i=0;i<26;i++){
            token[i] = 0;
        }
        //两个计分板
        fjz = (TextView)findViewById(R.id.fjzScore);
        zzz = (TextView)findViewById(R.id.zzzScore);
    }

    public void turnOver(int i){
        //修改记分牌
        fjz.setText(fjzScore + "");
        zzz.setText(zzzScore + "");
        //标记此地为“占领状态”
        not_used[i] = false;
        //回合结束
        turn = turn + 1;
        if(turn == 25){

        }
    }
}
