package rugu.yetote.com.zhihuadvertisementdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private MyAdapter adapter;
    private Retrofit retrofit;
    private ArrayList<MyModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
        initViews();

        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MyAdapter(this, list);
        rv.setAdapter(adapter);
//        rv.addItemDecoration(new MyDividerItemDecoration(this,2, Color.BLACK));
        loadData();

    }

    private void loadData() {
        AdvertisementService advertisementService = retrofit.create(AdvertisementService.class);
        advertisementService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myModels -> {
                    list.addAll(myModels);
                    adapter.notifyDataSetChanged();
                });
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://47.95.206.238/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private void initViews() {
        rv = findViewById(R.id.rv);
        list = new ArrayList<>();
    }
}
