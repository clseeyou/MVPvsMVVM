package upday.mvpvsmvvm.mvp;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import upday.mvpvsmvvm.datamodel.IDataModel;

/**
 * Implementation class for the Presenter in the MVP model.
 */
public class Presenter implements IPresenter {

    @NonNull
    private final IDataModel mDataModel;

    @NonNull
    private final IView mView;

    private CompositeDisposable mCompositeDisposable;

    public Presenter(@NonNull final IDataModel dataModel,
                     @NonNull final IView view) {
        mDataModel = dataModel;
        mView = view;
    }

    @Override
    public void bind() {
        mCompositeDisposable = new CompositeDisposable();

        mCompositeDisposable.add(mDataModel.getGreeting()
                                    .subscribe(this::setGreeting));
    }

    @Override
    public void unBind() {
        mCompositeDisposable.clear();
    }

    private void setGreeting(@NonNull final String greeting) {
        mView.setGreeting(greeting);
    }
}
