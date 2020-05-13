package com.example.gitrepo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.gitrepo.api.GitRepoResponse;
import com.example.gitrepo.api.InterPreter;
import com.example.gitrepo.daggers.MyApplication;
import com.example.gitrepo.daggers.RetrofitComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recy_issues)
    RecyclerView recyclerIssue;

    private IssueAdapter adapter;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerIssue.setLayoutManager(new LinearLayoutManager(this));

        ((MyApplication)getApplication()).getRetrofitComponent().inject(this);

        retrofit.create(InterPreter.class).getIssues()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GitRepoResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<GitRepoResponse> gitRepoResponses) {
                        adapter = new IssueAdapter(gitRepoResponses,MainActivity.this);
                        recyclerIssue.setAdapter(adapter);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG","completed");
                    }
                });
    }
}
