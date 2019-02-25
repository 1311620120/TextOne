package com.example.textone.view.interfaces;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/25 09:11:07
 * @Description:
 */
public interface IMainView<T> extends  IBaseView {

    void  onSeccuss(T t);
    void  onFail(String Err);
}
