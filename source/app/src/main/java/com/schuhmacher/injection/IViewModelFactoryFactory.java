package com.schuhmacher.injection;

import android.content.Context;
import com.schuhmacher.viewmodels.ViewModelFactory;


//Generic injection interface
public interface IViewModelFactoryFactory {
    ViewModelFactory provideViewModelFactory(Context context);
}
