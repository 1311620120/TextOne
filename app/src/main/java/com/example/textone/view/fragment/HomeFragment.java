package com.example.textone.view.fragment;

import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.textone.R;
import com.example.textone.model.json.NewsBean;
import com.example.textone.presenter.MainPersenter;
import com.example.textone.view.adapter.MyAdapter;
import com.example.textone.view.interfaces.IMainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;


/**
 * @Auther: 白俊岭
 * @Date: 2019/2/20 19:08:49
 * @Description:
 */
public class HomeFragment extends Fragment implements IMainView {
 int Page=1;
    private View view;
    private XRecyclerView xrecycler;
    private MainPersenter mainPersenter;
    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.homefragment, container, false);

        initView();
        initData();
        return view;
    }

    private void initData() {
        xrecycler.setPullRefreshEnabled(true);
        xrecycler.setLoadingMoreEnabled(true);

        mainPersenter = new MainPersenter(this);

        mainPersenter.loadDataFromNet(Page);
        mainPersenter.setView(this);
        xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Page=1;
                mainPersenter.loadDataFromNet(Page);
                xrecycler.refreshComplete();
                   myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Page++;
                        mainPersenter.loadDataFromNet(Page);
                        xrecycler.loadMoreComplete();
                        myAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

    }
    private void initView() {
        xrecycler = view.findViewById(R.id.xrecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        xrecycler.setLayoutManager(linearLayoutManager);

    }


    @Override
    public void onSeccuss(Object o) {
        NewsBean newsBean = (NewsBean) o;
        myAdapter = new MyAdapter(getActivity(),newsBean);
        xrecycler.setAdapter(myAdapter);
    }

    @Override
    public void onFail(String Err) {

    }
}
