package com.example.textone.presenter;

import com.example.textone.applicontion.Constant;
import com.example.textone.model.HttpUitls;
import com.example.textone.model.json.NewsBean;
import com.example.textone.view.fragment.HomeFragment;
import com.example.textone.view.interfaces.IMainView;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/25 09:14:29
 * @Description:
 */
public class MainPersenter extends BasePresenter<IMainView<NewsBean>> {

    private final HttpUitls instansce;

    public  MainPersenter(HomeFragment homeFragment){
        instansce = HttpUitls.getInstance();
    }
    public  void  loadDataFromNet(int  page){
       instansce.getData(Constant.BASE_URL+page,NewsBean.class,new HttpUitls.CallBackData<NewsBean>(){


           public void onResponse(NewsBean newsBean) {
                getView().onSeccuss(newsBean);
           }

           @Override
           public void onFail(String err) {
  getView().onFail(err);
           }
       });
    }
    }

