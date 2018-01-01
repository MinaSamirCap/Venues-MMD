package com.example.andoird.venues_mmd.viewmodels;

import android.content.Context;


import org.reactivestreams.Subscription;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public abstract class NetWorkViewModel<T> extends BaseViewModel<T> {

    private CompositeDisposable mCompositeDisposable;

    protected NetWorkViewModel(Context context, T model) {
        super(context, model);
        mCompositeDisposable = new CompositeDisposable();
    }

    protected void makeNetworkRequest(final Observable observable, final ProgressController progressController) {
        makeNetworkRequest(observable, null, null, progressController);
    }

    protected void makeNetworkRequest(final Observable observable, final Consumer<Throwable> onError, final ProgressController progressController) {
        makeNetworkRequest(observable, null, onError, progressController);
    }

    protected <D> void makeNetworkRequest(final Observable<D> observable, final Consumer<D> onNext,
                                          final Consumer<Throwable> onError, final ProgressController progressController) {
        if (progressController != null)
            progressController.setProgress();

        mCompositeDisposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<D>() {
                    @Override
                    public void accept(D d) {

                        if (progressController != null)
                            progressController.removeProgress();

                        try {
                            setModel((T) d);

                            if (onNext != null)
                                onNext.accept(d);

                        } catch (Exception e) {
                            e.printStackTrace();
                            if (onError != null) {
                                //onError.accept(e);
                            } else {
                                //ErrorHandler.handelError(context, e);
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        if (progressController != null)
                            progressController.removeProgress();

                        throwable.printStackTrace();

                        if (onError != null) {
                            //onError.accept(throwable);
                        } else {
                            //ErrorHandler.handelError(context, throwable);
                        }
                    }
                }));
    }

    public void dispose() {
        if (mCompositeDisposable != null )
            mCompositeDisposable.dispose();
    }

    protected interface ProgressController {
        void setProgress();
        void removeProgress();
    }
}
