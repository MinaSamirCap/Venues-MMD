package com.example.andoird.venues_mmd.viewmodels;

import android.app.Activity;
import android.databinding.ObservableField;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.api.calls.RestApi;
import com.example.andoird.venues_mmd.api.models.SearchVenueModel;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by mina on 07/12/17.
 */

public class MainActivityViewModel extends BaseViewModel<SearchVenueModel> {

    @Inject
    Retrofit retrofit;

    public ObservableField<String> text = new ObservableField<>();

    public MainActivityViewModel(Activity activity) {
        super(activity, new SearchVenueModel());
        ((App) activity.getApplication()).getNetComponent().inject(this);

        loadData();
    }

    private void loadData() {
        Observable<SearchVenueModel> posts = retrofit.create(RestApi.class).getPosts("new cairo",
                ApiUtils.CLIENT_ID,ApiUtils.CLIENT_SECRET, ApiUtils.DATE_VERSION);

        getObservable(posts).subscribe(this::handleReposResponse, this::handleError);
    }

    private void handleError(Object o) {
        Throwable throwable = (Throwable) o;
        text.set(throwable.toString());
    }

    private void handleReposResponse(Object o) {
        SearchVenueModel baseModel = (SearchVenueModel) o;
        text.set(baseModel.getMeta().getRequestId()+ "\t" + baseModel.getResponse().isConfident() + "\n" +
        baseModel.getResponse().getVenuesList().get(0).getContact().getPhone());
    }


    private void handleError(Throwable throwable) {
        text.set(throwable.toString());
    }

    private void handleReposResponse(SearchVenueModel baseModel) {
        text.set(baseModel.getMeta().getRequestId());
    }

    public <T> Observable getObservable(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()) // "work" on io thread
                .observeOn(AndroidSchedulers.mainThread()); // "listen" on UIThread
    }
}
