package com.example.textone.presenter;

import com.example.textone.applicontion.Constant;
import com.example.textone.model.HttpUitls;
import com.example.textone.model.json.LoginBean;
import com.example.textone.view.activity.MainActivity;
import com.example.textone.view.interfaces.IMainView;


/**
 * @Auther: 白俊岭
 * @Date: 2019/2/25 10:04:07
 * @Description:
 */
public class LoginPresenter  extends  BasePresenter<IMainView<LoginBean>>{

    private final HttpUitls instansce;

    public  LoginPresenter (MainActivity mainActivity){
        instansce = HttpUitls.getInstance();

   }


    public  void  getLoginData(String name, String pwd){
        instansce.setData(Constant.LOGIN, LoginBean.class, name,pwd,new HttpUitls.CallBackData() {
            @Override
            public void onResponse(Object o) {
                 getView().onSeccuss((LoginBean)o);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }
}
