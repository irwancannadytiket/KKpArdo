package com.example.irwancannady.kkpardo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.irwancannady.kkpardo.R;
import com.example.irwancannady.kkpardo.model.EntityRequest;

import java.util.List;

/**
 * Created by Irwan Cannady on 5/21/17.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {

    private List<EntityRequest> entityRequests;
    private Context mContext;

    public AdapterMain(List<EntityRequest> entityRequests, Context mContext) {
        this.entityRequests = entityRequests;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EntityRequest entityRequest = entityRequests.get(position);
        holder.mTextViewRumah.setText(entityRequest.getId());
    }

    @Override
    public int getItemCount() {
        return entityRequests.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {

         TextView mTextViewRumah;
         TextView mTextViewWaktu;
         Switch mSwitch;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewRumah = (TextView) itemView.findViewById(R.id.tv_no_rumah);
            mTextViewWaktu = (TextView) itemView.findViewById(R.id.tv_waktu);
            mSwitch = (Switch) itemView.findViewById(R.id.sw_switch);

        }
    }
}
