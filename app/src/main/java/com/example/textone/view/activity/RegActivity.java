package com.example.textone.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import com.example.textone.R;
import com.example.textone.model.json.RegBean;
import com.example.textone.presenter.RegPersenter;
import com.example.textone.view.interfaces.IMainView;


public class RegActivity extends AppCompatActivity implements IMainView, View.OnClickListener {

    private EditText name;
    private EditText pwd;
    private RegPersenter regPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
         initView();
         initData();
    }



    private void initData() {
        regPersenter = new RegPersenter(this);


    }
    private void initView() {
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);
         findViewById(R.id.login).setOnClickListener(this);

    }

    @Override
    public void onSeccuss(Object o) {
        RegBean regBean =(RegBean)o;
        Log.e("+++++",regBean+"");
        Log.e("yiiyiy",regBean.getStatus()+"");
        if (regBean.getStatus().equals("0000")){
            Toast.makeText(RegActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onFail(String Err) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                String uName = name.getText().toString().trim();
                String pass = pwd.getText().toString().trim();
                 regPersenter.getRegData(uName,pass);
                 regPersenter.setView(this);
                break;

        }

    }
}
