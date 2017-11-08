package upday.mvpvsmvvm.mvvm;

import android.support.annotation.NonNull;

import io.reactivex.Flowable;
import upday.mvpvsmvvm.datamodel.IDataModel;

/**
 * View model for the main activity.
 */
public class ViewModel {

    @NonNull
    private final IDataModel mDataModel;

    public ViewModel(@NonNull final IDataModel dataModel) {
        mDataModel = dataModel;
    }

    @NonNull
    public Flowable<String> getGreeting() {
        return mDataModel.getGreeting();
    }
}
