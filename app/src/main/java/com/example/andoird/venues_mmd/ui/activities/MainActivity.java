package com.example.andoird.venues_mmd.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.RestApi;
import com.example.andoird.venues_mmd.api.models.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getNetComponent().inject(this);

        textView = findViewById(R.id.text_view);


        Observable<BaseModel> posts = retrofit.create(RestApi.class).getPosts("new cairo",
                "2HOZRRC3T2LXSZ133LEARQWHAOCSWAN1MXBUG0HW2QD2CJDJ",
                "YYJWSVINY25SHAOVSSNGVGWOAVTRTAS0FMJWTTYY4YURINIJ", "20171205");

        //Enque the call
        posts.subscribeOn(Schedulers.io()) // "work" on io thread
                .observeOn(AndroidSchedulers.mainThread()) // "listen" on UIThread
                .subscribe(this::handleReposResponse, this::handleError);
        /*posts.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                //Set the response to the textview
                textView.setText(response.body().getMeta().getRequestId());

            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                //Set the error to the textview
                textView.setText(t.toString());
            }
        });*/
    }

    private void handleError(Throwable throwable) {
        textView.setText(throwable.toString());
    }

    private void handleReposResponse(BaseModel baseModel) {
        textView.setText(baseModel.getMeta().getRequestId());
    }
}
