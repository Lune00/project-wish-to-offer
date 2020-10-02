package com.schuhmacher.injection;

import android.content.Context;


//Generic injection interface
public interface IInjection {
    ViewModelFactory provideViewModelFactory(Context context);
}
