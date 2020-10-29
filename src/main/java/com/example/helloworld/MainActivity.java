package com.example.helloworld;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //创建Button对象   也就是activity_main.xml里所设置的ID
    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_pt;
    Button btn_mul,btn_div,btn_add,btn_sub;
    Button btn_clr,btn_del,btn_eq;
    Button btn_sin,btn_cos,btn_exchange,btn_sqrt;
    EditText et_input;
    boolean clr_flag=true;    //判断et编辑文本框中是否清空
    int s1_up=-1;//判断s1正负
    int s2_up=-1;//判断s2正负

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化对象
        setContentView(R.layout.activity_main);
        btn_0= (Button) findViewById(R.id.btn_0);
        btn_1= (Button) findViewById(R.id.btn_1);
        btn_2= (Button) findViewById(R.id.btn_2);
        btn_3= (Button) findViewById(R.id.btn_3);
        btn_4= (Button) findViewById(R.id.btn_4);
        btn_5= (Button) findViewById(R.id.btn_5);
        btn_6= (Button) findViewById(R.id.btn_6);
        btn_7= (Button) findViewById(R.id.btn_7);
        btn_8= (Button) findViewById(R.id.btn_8);
        btn_9= (Button) findViewById(R.id.btn_9);
        btn_pt= (Button) findViewById(R.id.btn_pt);
        btn_add= (Button) findViewById(R.id.btn_add);
        btn_sub= (Button) findViewById(R.id.btn_sub);
        btn_mul= (Button) findViewById(R.id.btn_mul);
        btn_div= (Button) findViewById(R.id.btn_div);
        btn_clr= (Button) findViewById(R.id.btn_clr);
        btn_del= (Button) findViewById(R.id.btn_del);
        btn_eq= (Button) findViewById(R.id.btn_eq);
        btn_sin=(Button)findViewById(R.id.btn_sin);
        btn_cos=(Button)findViewById(R.id.btn_cos);
        btn_exchange=(Button)findViewById(R.id.btn_exchange);
        btn_sqrt=(Button)findViewById(R.id.btn_sqrt);
        et_input= (EditText) findViewById(R.id.et_input);

        //给按钮设置的点击事件
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_pt.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_clr.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_eq.setOnClickListener(this);
        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_exchange.setOnClickListener(this);
        btn_sqrt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str=et_input.getText().toString();
        switch (v.getId()){
            case   R.id.btn_0:
            case   R.id.btn_1:
            case   R.id.btn_2:
            case   R.id.btn_3:
            case   R.id.btn_4:
            case   R.id.btn_5:
            case   R.id.btn_6:
            case   R.id.btn_7:
            case   R.id.btn_8:
            case   R.id.btn_9:
            case   R.id.btn_pt:
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    et_input.setText("");
                }
                if(str.contains("+")||str.contains("-")||str.contains("×")||str.contains("÷")) {
                    str=str.substring(0,str.indexOf(" "));
                }
                et_input.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.btn_clr:
                clr_flag=true;
                s1_up=-1;
                s2_up=-1;
                str="";
                et_input.setText(str);
                break;
            case R.id.btn_del: //判断是否为空，然后在进行删除
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    et_input.setText(str);
                }
                else if(str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                    if(et_input.getText().length()==0)clr_flag=true;
                }
                break;
            case R.id.btn_exchange:
            {if(clr_flag){
                    clr_flag=false;
                    str="";
                    str=str+"^";
                    et_input.setText(str);
                    s1_up=s1_up*(-1);
                    break;
                }
               else  if(str.length()>3){
                  char k1= str.charAt(str.length()-2);
                  System.out.println("==="+k1);
               if (k1=='+'||k1=='-'||k1=='×'||k1=='÷'||k1=='s'||k1=='t'){
                   System.out.println(str);
                   String dt=str+"^";
                    et_input.setText(dt);
                   System.out.println(dt);
                    s2_up=s2_up*(-1);
                    break;
                } else{break;}
               }
               else{break;}
            }
            case R.id.btn_sin:
                et_input.setText("sin ");
                clr_flag=false;
                break;
            case R.id.btn_cos:
                et_input.setText("cos ");
                clr_flag=false;
                break;
            case R.id.btn_sqrt:
                et_input.setText("sqrt ");
                clr_flag=false;
                break;
            case R.id.btn_eq: //单独运算最后结果
                getResult();//调用下面的方法
                break;
        }
    }

    private void getResult() {
        try{
        String exp=et_input.getText().toString();
        if(exp==null||exp.equals("")) return ;
        //因为没有运算符所以不用运算
        if(!exp.contains(" ")){
            return ;
        }
        if(clr_flag){
            clr_flag=false;
            return;
        }
        clr_flag=true;
        //截取运算符前面的字符串

        String s1=exp.substring((int)((s1_up*0.5+0.5)+0),exp.indexOf(" "));
        //截取的运算符
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        //截取运算符后面的字符串
        String s3=exp.substring(exp.indexOf(" ")+1+(int)(s2_up*0.5+0.5)+0);
        double cnt=0;
        if(s1.contains("s")&&!s3.equals("")&&!s3.contains(" ")){
            if(s1.equals("sin"))cnt=Math.sin(Double.parseDouble(s3));
            else if(s1.equals("cos"))cnt=Math.cos(Double.parseDouble(s3));
            else {
                if(s2_up==1) Toast.makeText(MainActivity.this,"开根数大于0",Toast.LENGTH_SHORT).show();
                else{cnt=Math.sqrt(Double.parseDouble(s3));}
            }
            et_input.setText(cnt+"");

        }

        else if(s3.contains(" ")&&s1.contains("s"))Toast.makeText(MainActivity.this,"输入错误",Toast.LENGTH_SHORT).show();
        else if(!s1.contains("s")){
        String s2=exp.substring(exp.indexOf(" ")+3+(int)(s2_up*0.5+0.5)+0);


        if(!s1.equals("")&&!s2.equals("")&&!s1.contains("s")){
            double d1=Double.parseDouble(s1)*(-1)*s1_up;
            double d2=Double.parseDouble(s2)*(-1)*s2_up;
            if(op.equals("+")){
                cnt=d1+d2;
            }
            if(op.equals("-")){
                cnt=d1-d2;
            }
            if(op.equals("×")){
                cnt=d1*d2;
            }
            if(op.equals("÷")){
                if(d2==0)  Toast.makeText(MainActivity.this,"除数不为零",Toast.LENGTH_SHORT).show();
                else cnt=d1/d2;
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")) {
                int res = (int) cnt;
                et_input.setText(res+"");
            }else {
                et_input.setText(cnt+"");}
        }

        //如果s1是空    s2不是空  就执行下一步
        else if(!s1.equals("")&&s2.equals("")){
            double d1=Double.parseDouble(s1);
            if(op.equals("+")){
                cnt=d1;
            }
            if(op.equals("-")){
                cnt=d1;
            }
            if(op.equals("×")){
                cnt=0;
            }
            if(op.equals("÷")){
                cnt=0;
            }
            if(!s1.contains(".")) {
                int res = (int) cnt;
                et_input.setText(res+"");
            }else {
                et_input.setText(cnt+"");}
        }
        //如果s1是空    s2不是空  就执行下一步
        else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                cnt=d2;
            }
            if(op.equals("-")){
                cnt=0-d2;
            }
            if(op.equals("×")){
                cnt=0;
            }
            if(op.equals("÷")){
                cnt=0;
            }
            if(!s2.contains(".")) {
                int res = (int) cnt;
                et_input.setText(res+"");
            }else {
                et_input.setText(cnt+"");}
        }
        else {
            et_input.setText("");
        }
    s1_up=-1;s2_up=-1;clr_flag=true;
    }
        s1_up=-1;s2_up=-1;clr_flag=true;
    }catch (Exception e){Toast.makeText(MainActivity.this,"输入错误",Toast.LENGTH_SHORT).show();et_input.setText("");}
        finally {
            s1_up=-1;s2_up=-1;clr_flag=true;
        }
    }

}