package com.example.andoird.venues_mmd.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.RestApi;

import javax.inject.Inject;

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


        Call<String> posts = retrofit.create(RestApi.class).getPosts("new cairo",
                "2HOZRRC3T2LXSZ133LEARQWHAOCSWAN1MXBUG0HW2QD2CJDJ",
                "YYJWSVINY25SHAOVSSNGVGWOAVTRTAS0FMJWTTYY4YURINIJ", "20171205");

        //Enque the call
        posts.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Set the response to the textview
                textView.setText(response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //Set the error to the textview
                textView.setText(t.toString());
            }
        });
    }
}
