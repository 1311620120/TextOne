package com.example.textone.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.textone.R;
import com.example.textone.model.json.NewsBean;

/**
 * @Auther: 白俊岭
 * @Date: 2019/2/25 15:44:09
 * @Description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    NewsBean newsBean;
    public MyAdapter(Context context, NewsBean newsBean) {
       this.context=context;
       this.newsBean=newsBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rec, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(newsBean.getResults().get(position).getTitle());
        Glide.with(context)
                .load(newsBean.getResults().get(position).getUrl())
                .into(holder.img);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                newsBean.getResults().remove(position);
                Toast.makeText(context,"删除成功",Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return newsBean.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        public ViewHolder(View itemView) {

            super(itemView);
            img=   itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }
}
