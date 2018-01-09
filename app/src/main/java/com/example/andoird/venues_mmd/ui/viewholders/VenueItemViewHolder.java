package com.example.andoird.venues_mmd.ui.viewholders;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.andoird.venues_mmd.BR;
import com.example.andoird.venues_mmd.api.models.VenueModel;
import com.example.andoird.venues_mmd.databinding.VenueItemSearchListBinding;
import com.example.andoird.venues_mmd.ui.activities.VenueDetailsActivity;

/**
 * Created by mina on 27/12/17.
 */

public class VenueItemViewHolder extends RecyclerView.ViewHolder {

    // we use the class VenueItemSearchListBinding instead of ViewDataBinding to
    // could access the view individually to set click listener for example ..
    private VenueItemSearchListBinding bindings;

    public VenueItemViewHolder(VenueItemSearchListBinding bindingView) {
        super(bindingView.getRoot());
        bindings = bindingView;
    }

    public void bind(@NonNull VenueModel venueModel) {
        //bindings.setVariable(BR.venueModel, venueModel);
        // we use setVenueModel instead of get each view and set data to it ...
        bindings.setVenueModel(venueModel);
        bindings.executePendingBindings();

    }

}