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
import com.example.infoplatform.db.Jo_info;

import java.util.List;


public class JoAdapter extends ArrayAdapter {
    private int resourseid;
    public JoAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.resourseid=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Jo_info jo_info= (Jo_info) getItem(position);
        View view;
        ViewHoldwe viewHoldwe;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourseid,null);
            viewHoldwe=new ViewHoldwe();
            viewHoldwe.Jo_id=view.findViewById(R.id.Jo_id);
            viewHoldwe.Jo_location=view.findViewById(R.id.Jo_gpsno);

            view.setTag(viewHoldwe);
        }else {
            view=convertView;
            viewHoldwe= (ViewHoldwe) view.getTag();
        }
        viewHoldwe.Jo_id.setText(jo_info.getId());
        viewHoldwe.Jo_id.setText(jo_info.getGpsno());

        return view;
    }
    class ViewHoldwe{
        TextView Jo_id;
        TextView Jo_location;
    }
}

