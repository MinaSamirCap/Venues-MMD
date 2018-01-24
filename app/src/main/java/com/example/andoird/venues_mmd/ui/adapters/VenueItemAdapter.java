package com.example.andoird.venues_mmd.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andoird.venues_mmd.BR;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.models.VenueModel;
import com.example.andoird.venues_mmd.databinding.VenueItemSearchListBinding;
import com.example.andoird.venues_mmd.ui.activities.VenueDetailsActivity;
import com.example.andoird.venues_mmd.ui.viewholders.VenueItemViewHolder;

import java.util.List;

/**
 * Created by mina on 27/12/17.
 */

public class VenueItemAdapter extends RecyclerView.Adapter<VenueItemViewHolder> {
    private List<VenueModel> data;

    public VenueItemAdapter(Context context, List<VenueModel> categoryObjectList) {
        this.data = categoryObjectList;
    }

    @Override
    public VenueItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        VenueItemSearchListBinding bind = DataBindingUtil.inflate(inflater, R.layout.venue_item_search_list, parent, false);
        return new VenueItemViewHolder(bind);
    }

    @Override
    public void onBindViewHolder(VenueItemViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}