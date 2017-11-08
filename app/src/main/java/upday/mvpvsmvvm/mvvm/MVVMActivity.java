package upday.mvpvsmvvm.mvvm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.reactivex.disposables.CompositeDisposable;
import upday.mvpvsmvvm.DroidconApplication;
import upday.mvpvsmvvm.R;
import upday.mvpvsmvvm.datamodel.IDataModel;

public class MVVMActivity extends AppCompatActivity {

    @NonNull
    private CompositeDisposable mCompositeDisposable;

    @NonNull
    private ViewModel mViewModel;

    @Nullable
    private TextView mGreetingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = new ViewModel(getDataModel());
        setupViews();
    }

    private void setupViews() {
        mGreetingView = (TextView) findViewById(R.id.greeting);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bind();
    }

    @Override
    protected void onPause() {
        unBind();
        super.onPause();
    }

    private void bind() {
        mCompositeDisposable = new CompositeDisposable();

        mCompositeDisposable.add(mViewModel.getGreeting()
                                    .subscribe(this::setGreeting));
    }

    private void unBind() {
        mCompositeDisposable.clear();
    }

    private void setGreeting(@NonNull final String greeting) {
        assert mGreetingView != null;

        mGreetingView.setText(greeting);
    }

    @NonNull
    private IDataModel getDataModel() {
        return ((DroidconApplication) getApplication()).getDataModel();
    }
}
