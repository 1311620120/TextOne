package com.example.textone.presenter;

import com.example.textone.applicontion.Constant;
import com.example.textone.model.HttpUitls;
import com.example.textone.model.json.RegBean;
import com.example.textone.view.activity.RegActivity;
import com.example.textone.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/25 10:04:23
 * @Description:
 */
public class RegPersenter extends BasePresenter<IMainView<RegBean>>{

    private final HttpUitls instansce;

    public RegPersenter(RegActivity regActivity){
        instansce = HttpUitls.getInstance();

     }
         public  void  getRegData(String name ,String pwd){
        instansce.setData(Constant.reg, RegBean.class, name,pwd,new HttpUitls.CallBackData() {
            @Override
            public void onResponse(Object o) {
                getView().onSeccuss((RegBean)o);
            }

            @Override
            public void onFail(String err) {

            }
        });
         }
}
