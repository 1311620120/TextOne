package com.example.textone.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.textone.R;
import com.example.textone.model.json.LoginBean;
import com.example.textone.presenter.LoginPresenter;
import com.example.textone.view.interfaces.IMainView;


public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener {

    private EditText name;
    private EditText pwd;
    private LoginPresenter loginPresenter;
    private String nname;
    private String ppwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    private void initData() {
        loginPresenter = new LoginPresenter(this);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.reg).setOnClickListener(this);

    }

    private void initView() {
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);

    }

    @Override
    public void onSeccuss(Object o) {
        LoginBean loginBean = (LoginBean) o;
        if (nname.equals("")||ppwd.equals("")){
            Toast.makeText(MainActivity.this, "账号或密码为空！", Toast.LENGTH_SHORT).show();
        }else {

        if (loginBean.getStatus().equals("0000")) {
            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ShowActivity.class);
          startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "账号或密码输入有误！", Toast.LENGTH_SHORT).show();
        }
        }
    }

    @Override
    public void onFail(String Err) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                nname = name.getText().toString().trim();
                ppwd = pwd.getText().toString().trim();
                loginPresenter.getLoginData(nname, ppwd);
                loginPresenter.setView(this);
                break;
            case R.id.reg:
                Intent intent = new Intent(MainActivity.this, RegActivity.class);
                startActivity(intent);
                break;
        }
    }
}


