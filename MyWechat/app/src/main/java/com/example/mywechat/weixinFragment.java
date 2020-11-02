package com.example.mywechat;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class weixinFragment extends Fragment {

    private RecyclerView recyclerView; //定义ReclerView控件
    private View view;//定义view来设置fragment中的layout
    private ArrayList<GoodsEntity> goodsEntities = new ArrayList<GoodsEntity>();
    private myadpater myadpater;

    public weixinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab01,container,false);
        initRecyclerView();
        initData();
        return view;
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView)view.findViewById(R.id.id_content1);
        myadpater = new myadpater(getActivity(),goodsEntities);
        recyclerView.setAdapter(myadpater);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        myadpater.setOnItemClickListener(new myadpater.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, GoodsEntity data) {
                Toast.makeText(getActivity(),"无", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //
    private void initData(){
        for (int i=0;i<20;i++){
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setGoodsName("W");
            goodsEntity.setGoodsPrice("648");
            goodsEntities.add(goodsEntity);

        }
    }

}
