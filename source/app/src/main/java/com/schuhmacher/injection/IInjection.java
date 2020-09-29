package com.schuhmacher.injection;

import android.content.Context;

import com.schuhmacher.dal.repository.IPersonRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


//Generic injection interface
public interface IInjection {

    public static Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    IPersonRepository providePersonRepository(Context context);

}
