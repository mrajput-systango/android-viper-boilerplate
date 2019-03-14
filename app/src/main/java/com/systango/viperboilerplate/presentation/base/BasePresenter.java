package com.systango.viperboilerplate.presentation.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Mohit Rajput on 13/3/19.
 * TODO: Insert javadoc information here
 */
public abstract class BasePresenter<V> implements Presenter {
    protected final V view;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected BasePresenter(V view) {
        this.view = view;
    }

    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    private void clearDisposables() {
        compositeDisposable.clear();
    }

    void onDestroy() {
        clearDisposables();
    }
}
