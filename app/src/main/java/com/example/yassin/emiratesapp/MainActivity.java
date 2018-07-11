package com.example.yassin.emiratesapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.yassin.emiratesapp.adapter.CarsAdapter;
import com.example.yassin.emiratesapp.model.Car;
import com.example.yassin.emiratesapp.model.CarJson;
import com.example.yassin.emiratesapp.service.CarRestServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private CarsAdapter carsAdapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mRefreshLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        recyclerView = findViewById(R.id.cars_list);
        mRefreshLayout = findViewById(R.id.refreshLayout);
        mRefreshLayout.setColorSchemeColors(0xff6b4d9c);
        mRefreshLayout.setRefreshing(true);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshLayout.setRefreshing(true);
                loadData();
            }
        });
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setupToolbar();
        setupAdapter();
        loadData();

    }


    private void setupAdapter() {
        carsAdapter = new CarsAdapter(this, new ArrayList<Car>(), Locale.getDefault().getDisplayLanguage().equals("English"), false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(carsAdapter);
    }

    private void loadData() {
        CarRestServiceFactory.service("http://api.emiratesauction.com/v2/").getCarsJson()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CarJson>() {
                    @Override
                    public void onCompleted() {
                        mRefreshLayout.setRefreshing(false);


                    }

                    @Override
                    public void onError(Throwable e) {
                        mRefreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onNext(CarJson carJson) {
                        countDown(carJson.getCars());
                        mRefreshLayout.setRefreshing(false);
                        carsAdapter.updateCars(carJson.getCars(), false);
                    }
                });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void countDown(final List<Car> cars) {
        new CountDownTimer(300000, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                carsAdapter.updateCars(cars, true);
            }
        }.start();
    }
}