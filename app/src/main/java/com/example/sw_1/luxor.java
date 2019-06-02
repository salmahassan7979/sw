package com.example.sw_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class luxor extends AppCompatActivity implements feedadapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private feedadapter mfeedAdapter;
    private ArrayList<recycleviewfeed> recycleview;

    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luxor);

        mRecyclerView = findViewById(R.id.recycleluxor);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recycleview = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

        List<String> categories = new ArrayList<>();

    }

    @Override
    public void onItemClick(int position) {
        //  Intent detailIntent = new Intent(this, detailarts.class);
        // getdetails clickedItem = view.get(position);
        recycleviewfeed clickedItem = recycleview.get(position);
        // startActivity(detailIntent);
    }
}
