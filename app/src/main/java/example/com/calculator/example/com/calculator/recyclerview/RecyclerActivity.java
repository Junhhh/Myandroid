package example.com.calculator.example.com.calculator.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import example.com.calculator.BaseActivity;
import example.com.calculator.R;

public class RecyclerActivity extends BaseActivity {

    private List<item> Data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        inititem();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        //设置瀑布流
        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //设置竖向布局
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置网格布局
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(gridLayoutManager);
        itemAdapter Adapter = new itemAdapter(Data);
        recyclerView.setAdapter(Adapter);
        recyclerView.addItemDecoration(new RecycleViewDivider(RecyclerActivity.this,LinearLayoutManager.HORIZONTAL,1,getResources().getColor(R.color.colorView)));
    }

    private void inititem(){
        for(int i = 0; i < 2; i++){
            item item1 = new item("计算器",R.mipmap.ic_launcher);
            Data.add(item1);
            item item2 = new item("登录界面",R.mipmap.ic_launcher);
            Data.add(item2);
            item item3 = new item("LifeActivity",R.mipmap.ic_launcher);
            Data.add(item3);
            item item4 = new item("广播机制",R.mipmap.ic_launcher);
            Data.add(item4);
            item item5 = new item("BroadcastBest",R.mipmap.ic_launcher);
            Data.add(item5);
            item item6 = new item("IO流",R.mipmap.ic_launcher);
            Data.add(item6);
            item item7 = new item("Database",R.mipmap.ic_launcher);
            Data.add(item7);
            item item8 = new item("LitePal",R.mipmap.ic_launcher);
            Data.add(item8);
            item item9 = new item("内容提供器",R.mipmap.ic_launcher);
            Data.add(item9);
            item item10 = new item("获取联系人信息",R.mipmap.ic_launcher);
            Data.add(item10);
            item item11 = new item("通知",R.mipmap.ic_launcher);
            Data.add(item11);
            item item12 = new item("相机",R.mipmap.ic_launcher);
            Data.add(item12);
            item item13 = new item("音乐播放",R.mipmap.ic_launcher);
            Data.add(item13);
            item item14 = new item("视频播放",R.mipmap.ic_launcher);
            Data.add(item14);
            item item15 = new item("HTTP",R.mipmap.ic_launcher);
            Data.add(item15);
            item item16 = new item("Thread",R.mipmap.ic_launcher);
            Data.add(item16);
            item item17 = new item("Service",R.mipmap.ic_launcher);
            Data.add(item17);
            item item18 = new item("下载",R.mipmap.ic_launcher);
            Data.add(item18);
        }
    }
}
