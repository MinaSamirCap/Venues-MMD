package com.example.andoird.venues_mmd.ui.viewholders;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.example.andoird.venues_mmd.BR;
import com.example.andoird.venues_mmd.api.models.VenueModel;

/**
 * Created by mina on 27/12/17.
 */

public class VenueItemViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding bindings;

    public VenueItemViewHolder(ViewDataBinding bindingView) {
        super(bindingView.getRoot());
        bindings = bindingView;

    }

    public void bind(@NonNull VenueModel venueModel) {
        bindings.setVariable(BR.venueModel, venueModel);
        bindings.executePendingBindings();
    }


}