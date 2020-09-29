package com.schuhmacher.injection;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


//Generic injection interface
public interface IInjection<T> {
    T providePersonRepository(Context context);
    public static Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }
}
