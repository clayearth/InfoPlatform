package com.example.infoplatform.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infoplatform.R;
import com.example.infoplatform.db.chx_UserBean;

import java.util.List;

public class chx_UserAdapter extends RecyclerView.Adapter<chx_UserAdapter.HomeViewHolder> {
    private List<chx_UserBean> chxUserBeans;
    private Context context;

    public void setUserBeans(List<chx_UserBean> chxUserBeans) {
        this.chxUserBeans = chxUserBeans;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_infobeans, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int position) {
        chx_UserBean wormKnowledgeBean = chxUserBeans.get(position);
        holder.tvAge.setText(wormKnowledgeBean.getAge());
        holder.tvName.setText(wormKnowledgeBean.getName());
        holder.tvPhone.setText(wormKnowledgeBean.getPhone());
        holder.tvSex.setText(wormKnowledgeBean.getSex());

    }

    @Override
    public int getItemCount() {
        return chxUserBeans == null ? 0 : chxUserBeans.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAge, tvName, tvPhone, tvSex;
        private ImageView ivHome;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvSex = itemView.findViewById(R.id.tv_sex);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
