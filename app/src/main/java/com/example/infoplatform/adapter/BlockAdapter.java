package com.example.infoplatform.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.infoplatform.R;
import com.example.infoplatform.db.Block_info;

import java.util.List;


public class BlockAdapter extends ArrayAdapter {
    private int resourseid;
    public BlockAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.resourseid=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Block_info block_info= (Block_info) getItem(position);
        View view;
        ViewHoldwe viewHoldwe;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourseid,null);
            viewHoldwe=new ViewHoldwe();
            viewHoldwe.Block_id=view.findViewById(R.id.Block_id);
            viewHoldwe.Block_location=view.findViewById(R.id.Block_location);

            view.setTag(viewHoldwe);
        }else {
            view=convertView;
            viewHoldwe= (ViewHoldwe) view.getTag();
        }
        viewHoldwe.Block_id.setText(block_info.getId());
        viewHoldwe.Block_location.setText(block_info.getLocation());

        return view;
    }
    class ViewHoldwe{
        TextView Block_id;
        TextView Block_location;
    }
}

