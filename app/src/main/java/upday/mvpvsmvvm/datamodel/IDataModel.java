package upday.mvpvsmvvm.datamodel;

import android.support.annotation.NonNull;

import io.reactivex.Flowable;

public interface IDataModel {

    @NonNull
    Flowable<String> getGreeting();

}
