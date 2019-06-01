package com.example.sw_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity implements feedadapter.OnItemClickListener{
    private  static final String TAG="home";
    private Spinner spinner;
    private ImageButton button,bit;
    private RecyclerView mRecyclerView;
    private TextView mtextView;
    private feedadapter mfeedAdapter;
    private ArrayList<recycleviewfeed> recycleview;
  //  private ArrayList<getdetails> view;
    private RequestQueue mRequestQueue;
    private FirebaseDatabase mDatabase;
    private DatabaseReference xDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

// ...
        mDatabase = FirebaseDatabase.getInstance();
        //xdatabase hwa el object bta3y ely 3amlah f el data w b4of el field ely gwah
        xDatabase = mDatabase.getReference("https://software-28893.firebaseio.com/");
        xDatabase.setValue("Hello, World!");

        // ReadData readData=  new ReadData();
      //  xDatabase.addValueEventListener(readData);
        button = findViewById(R.id.bot1);
        mRecyclerView = findViewById(R.id.recyclehome);
        mtextView=findViewById(R.id.textView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recycleview = new ArrayList<>();
      //  view = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        spinner = findViewById(R.id.spinner1);
        // button = findViewById(R.id.selectcategory);
        List<String> categories = new ArrayList<>();
        categories.add(0, "Choose Category");
        categories.add("cairo");
        categories.add("Aswan");
        categories.add("Alex");
        categories.add("luxor");
        categories.add("Sharm EL_Shekhikh");
        categories.add("Other");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        //Dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Category")) {
                    //do nothing
                }
                //tetkarr lkol category
                else if (parent.getItemAtPosition(position).equals("cairo")) {
                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                    //OpenActivity_arts();
                    //anything else you want to do on item selection do here
                } else if (parent.getItemAtPosition(position).equals("luxor")) {
                    String item = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                    //openActivity_carpenter();
                } else if (parent.getItemAtPosition(position).equals("Sharm EL_Sheikh")) {
                    String item = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                    //openActivity_real();
                } else {
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                // TODO Auto-generated method stub
            }
        });


        xDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mtextView.setText(value);
                Log.d(TAG, "Value is: " + value);
                mtextView.setText(dataSnapshot.getValue(String.class));
            }

           @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

   /* public class ReadData implements ValueEventListener{

        @Override
        public void onDataChange( DataSnapshot dataSnapshot) {
           // String var = dataSnapshot.getValue(String.class);
            mtextView.setText(dataSnapshot.getValue(String.class));
        }

        @Override
        public void onCancelled( DatabaseError databaseError) {

        }
    }*/
   @Override
    public void onItemClick(int position) {
       // Intent detailIntent = new Intent(this, DetailActivity.class);
        // getdetails clickedItem = view.get(position);
        recycleviewfeed clickedItem = recycleview.get(position);

        /*detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getservice());
        detailIntent.putExtra(EXTRA_LIKES, clickedItem.getrateCount());
        detailIntent.putExtra(EXTRA_date, clickedItem.getdate());
        detailIntent.putExtra(EXTRA_discrebtion, clickedItem.getdiscrebtion());
        detailIntent.putExtra(EXTRA_time, clickedItem.gettime());
        detailIntent.putExtra(EXTRA_cost, clickedItem.getcost());
        detailIntent.putExtra(EXTRA_direction, clickedItem.getdirection());
        detailIntent.putExtra(EXTRA_server, clickedItem.getspname());


        startActivity(detailIntent);*/
    }
   /* public void OpenActivity_arts(){
        //// Intent intent= new Intent(this,activity_.class);
        Intent intent= new Intent (this,Arts.class);
        startActivity( intent);

    }
    public void openActivity_carpenter(){
        //// Intent intent= new Intent(this,activity_.class);
        Intent intent= new Intent (this,Carpenter.class);
        startActivity( intent);

    }
    public void openActivity_real(){
        //// Intent intent= new Intent(this,activity_.class);
        Intent intent= new Intent (this,Real_Estate.class);
        startActivity( intent);

    }
    public void open_addd_services(){
        Intent intent= new Intent(this,service_add.class);
        startActivity( intent);
    }
    public void req(){
        Intent intent= new Intent(this, profile.class);
        startActivity( intent);
    }*/

}

