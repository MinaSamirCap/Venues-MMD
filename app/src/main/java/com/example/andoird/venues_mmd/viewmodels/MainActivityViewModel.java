package com.example.andoird.venues_mmd.viewmodels;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.api.calls.RestApi;
import com.example.andoird.venues_mmd.api.models.BaseModel;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by mina on 07/12/17.
 */

public class MainActivityViewModel extends BaseObservable {

    @Inject
    Retrofit retrofit;

    public ObservableField<String> text = new ObservableField<>();

    public MainActivityViewModel(Activity activity) {

        ((App) activity.getApplication()).getNetComponent().inject(this);

        loadData();
    }

    private void loadData() {
        Observable<BaseModel> posts = retrofit.create(RestApi.class).getPosts("new cairo",
                ApiUtils.CLIENT_ID,ApiUtils.CLIENT_SECRET, ApiUtils.DATE_VERSION);

        getObservable(posts).subscribe(this::handleReposResponse, this::handleError);
    }

    private void handleError(Object o) {
        Throwable throwable = (Throwable) o;
        text.set(throwable.toString());
    }

    private void handleReposResponse(Object o) {
        BaseModel baseModel = (BaseModel) o;
        text.set(baseModel.getMeta().getRequestId());
    }


    private void handleError(Throwable throwable) {
        text.set(throwable.toString());
    }

    private void handleReposResponse(BaseModel baseModel) {
        text.set(baseModel.getMeta().getRequestId());
    }

    public <T> Observable getObservable(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()) // "work" on io thread
                .observeOn(AndroidSchedulers.mainThread()); // "listen" on UIThread
    }
}
