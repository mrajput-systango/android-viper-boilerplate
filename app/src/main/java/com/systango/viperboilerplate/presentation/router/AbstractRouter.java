package com.systango.viperboilerplate.presentation.router;

import android.content.Context;

/**
 * Created by Mohit Rajput on 12/3/19.
 * TODO: Insert javadoc information here
 */
public abstract class AbstractRouter {
    private Context context;

    public AbstractRouter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
