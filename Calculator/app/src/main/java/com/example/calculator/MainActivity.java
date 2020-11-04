package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    int state=1;
    int op1, op2;
    int op=0;
    TextView textResutlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResutlt=findViewById(R.id.number);

        findViewById(R.id.btn0).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn1).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn2).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn3).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn4).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn5).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn6).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn7).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn8).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btn9).setOnClickListener((View.OnClickListener) this);

        findViewById(R.id.btnCong).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btnTru).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btnNhan).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.btnChia).setOnClickListener((View.OnClickListener) this);

        findViewById(R.id.btnCe).setOnClickListener((View.OnClickListener)this);
        findViewById(R.id.btnC).setOnClickListener((View.OnClickListener)this);
        findViewById(R.id.btnBS).setOnClickListener((View.OnClickListener)this);
        findViewById(R.id.btnBang).setOnClickListener((View.OnClickListener)this);
        findViewById(R.id.btnCongTru).setOnClickListener((View.OnClickListener)this);

    }


    public  void  OnClick(View v){
        int id=v.getId();
        if(id==R.id.btn0)
            addDigit(0);
        else if(id==R.id.btn1)
            addDigit(1);
        else if(id==R.id.btn2)
            addDigit(2);
        else if(id==R.id.btn3)
            addDigit(3);
        else if(id==R.id.btn4)
            addDigit(4);
        else if(id==R.id.btn5)
            addDigit(5);
        else if(id==R.id.btn6)
            addDigit(6);
        else if(id==R.id.btn7)
            addDigit(7);
        else if(id==R.id.btn8)
            addDigit(8);
        else if(id==R.id.btn9)
            addDigit(9);
        else if (id == R.id.btnCong)
            setOperator(1);
        else if (id == R.id.btnTru)
            setOperator(2);
        else if (id == R.id.btnNhan)
            setOperator(3);
        else if (id == R.id.btnChia)
            setOperator(4);
        else if (id == R.id.btnBang)
            calc();
        else if (id == R.id.btnBS)
            removeDigit();
        else if (id == R.id.btnCongTru)
            reverseOperand();
        else if (id == R.id.btnCe)
            resetOperand();
        else if (id == R.id.btnC)
            resetOperator();

    }
    private void resetOperator() {
        state = 1;
        op = 0;
        op1 = 0;
        op2 = 0;
        textResutlt.setText(String.valueOf(op1));
    }

    private void resetOperand() {
        if (state == 1) {
            op1 = 0;
            textResutlt.setText(String.valueOf(op1));
        } else {
            op2 = 0;
            textResutlt.setText(String.valueOf(op2));
        }
    }
    private  void reverseOperand() {
        if (state == 1) {
            op1 = -op1;
            textResutlt.setText(String.valueOf(op1));
        } else {
            op2 = -op2;
            textResutlt.setText(String.valueOf(op2));
        }
    }

    private void removeDigit() {
        if (state == 1) {
            op1 = op1 / 10;
            textResutlt.setText(String.valueOf(op1));
        } else {
            op2 = op2 / 10;
            textResutlt.setText(String.valueOf(op2));
        }
    }

    private void calc() {
        int result = 0;
        if (op == 1)
            result = op1 + op2;
        else if (op == 2)
            result = op1 - op2;
        else if (op == 3)
            result = op1 * op2;
        else if (op == 4)
            result = op1 / op2;
        textResutlt.setText(String.valueOf(result));

        state = 1;
        op1 = 0;
        op2 = 0;
    }

    private void setOperator(int type) {
        state = 2;
        op = type;
        textResutlt.setText(String.valueOf(op2));
    }
    private void addDigit(int digit) {
        if (state == 1) {
            op1 = op1 * 10 + digit;
            textResutlt.setText(String.valueOf(op1));
        } else {
            op2 = op2 * 10 + digit;
            textResutlt.setText(String.valueOf(op2));
        }
    }


}