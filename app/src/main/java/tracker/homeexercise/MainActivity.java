package tracker.homeexercise;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import tracker.homeexercise.Adapter.Adapter;
import tracker.homeexercise.Model.Event;
import tracker.homeexercise.Model.LeasureActivity;
import tracker.homeexercise.Model.Lecture;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    Handler handler;
    List data;
    ProgressBar progressBar;

    public void showProgrssbar(final boolean show){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        generateData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Adapter(data, new Adapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Log.d("TAG","onItemClick"+position);
            }
        }, new Adapter.OnBottomListener() {
            @Override
            public void onBottom(int position) {
                loadMoreData(data,data.size(),10);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void insertMoreData(final int startPosition, final int numberOfNews, List<Event> list)
    {
        for(int i = startPosition;i < (startPosition+numberOfNews);i++){
            if (i % 2 == 0)
                list.add(new Lecture("I.2.10",new Date(10000000L),"Mobile"));
            else
                list.add(new LeasureActivity("Malen", new Date()));
        }
    }
    private void generateData()
    {
        data = new LinkedList();
        for(int i = 0;i < 10;i++){
            if (i % 2 == 0)
                data.add(new Lecture("I.2.10",new Date(10000000L),"Mobile"));
            else
                data.add(new LeasureActivity("Malen", new Date()));
        }
    }

    private void notifyAdapter(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }
    private void waitSomeTime(final int milis){
        try{
            Thread.sleep(milis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void loadMoreData(final List<Event> data, final int startPosition, final int nuberOfNews)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                showProgrssbar(true);
                waitSomeTime(1000);
                insertMoreData(startPosition,nuberOfNews,data);
                notifyAdapter();
                showProgrssbar(false);
            }
        }).start();
    }
}
