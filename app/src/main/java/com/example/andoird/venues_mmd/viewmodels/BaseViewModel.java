package com.example.andoird.venues_mmd.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;

public abstract class BaseViewModel<T> extends BaseObservable {

    protected Context context;
    protected T model;

    public BaseViewModel(final Context context, final T model) {
        this.context = context;
        this.model = model;
    }

    protected void setModel(T model) {
        this.model = model;
    }
}
