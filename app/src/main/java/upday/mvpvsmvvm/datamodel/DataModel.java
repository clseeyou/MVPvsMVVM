package upday.mvpvsmvvm.datamodel;

import android.support.annotation.NonNull;

import io.reactivex.Flowable;

public class DataModel implements IDataModel {

    @NonNull
    @Override
    public Flowable<String> getGreeting() {
        return Flowable.just("Hello, World!");
    }
}
