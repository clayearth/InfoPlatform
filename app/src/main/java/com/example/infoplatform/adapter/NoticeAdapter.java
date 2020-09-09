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
import com.example.infoplatform.db.NoticeBean;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.HomeViewHolder> {
    private List<NoticeBean> NoticeBeans;
    private Context context;

    public void setNoticeBeans(List<NoticeBean> NoticeBeans) {
        this.NoticeBeans = NoticeBeans;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticebeans, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int position) {
        NoticeBean wormKnowledgeBean = NoticeBeans.get(position);
        holder.tvTitle.setText(wormKnowledgeBean.getTitle());
        holder.tvBody.setText(wormKnowledgeBean.getBody());
        holder.tvPlace.setText(wormKnowledgeBean.getPlace());
        holder.tvMoney.setText(wormKnowledgeBean.getMoney());
    }

    @Override
    public int getItemCount() {
        return NoticeBeans == null ? 0 : NoticeBeans.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvBody, tvPlace, tvMoney;
        private ImageView ivHome;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvBody = itemView.findViewById(R.id.tv_body);
            tvPlace = itemView.findViewById(R.id.tv_place);
            tvMoney = itemView.findViewById(R.id.tv_money);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
