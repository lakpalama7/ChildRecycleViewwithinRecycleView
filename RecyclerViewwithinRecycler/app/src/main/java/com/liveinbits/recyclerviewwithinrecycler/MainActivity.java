package com.liveinbits.recyclerviewwithinrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.onSelectListener {


    List<MainModel> mainModelList;
    List<SubModel> subModelList;
    List<SubModel> foodlist;
    List<SubModel> animallist;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.first_recyclerview);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mainModelList=new ArrayList<>();
        subModelList=new ArrayList<>();
        animallist=new ArrayList<>();
        foodlist=new ArrayList<>();
        subModelList.add(new SubModel(R.drawable.afganistan,"Afganistan"));
        subModelList.add(new SubModel(R.drawable.india,"India"));
        subModelList.add(new SubModel(R.drawable.bangladesh,"Bangladesh"));
        subModelList.add(new SubModel(R.drawable.bhutan,"Bhutan"));
        subModelList.add(new SubModel(R.drawable.china,"China"));

        foodlist.add(new SubModel(R.drawable.cheeseburger,"CheeseBurger"));
        foodlist.add(new SubModel(R.drawable.chickenmomo,"chickenmomo"));
        foodlist.add(new SubModel(R.drawable.chikenburger,"Chickenburger"));
        foodlist.add(new SubModel(R.drawable.chickenpizz,"Chickenpizza"));

        animallist.add(new SubModel(R.drawable.elephant,"Elephant"));
        animallist.add(new SubModel(R.drawable.dog,"Dog"));
        animallist.add(new SubModel(R.drawable.kangaro,"Kangaroo"));
        animallist.add(new SubModel(R.drawable.lion,"Lion"));
        animallist.add(new SubModel(R.drawable.horse,"Horse"));


        mainModelList.add(new MainModel("Country",subModelList));
        mainModelList.add(new MainModel("Food",foodlist));
        mainModelList.add(new MainModel("Animal",animallist));

        recyclerView.setAdapter(new MainAdapter(mainModelList,this));
        

    }



    @Override
    public void onClickSelect(int mainposition, int childposition) {
            Toast.makeText(this,mainModelList.get(mainposition).getSubModelList().get(childposition).getImagetitle(),Toast.LENGTH_LONG).show();
    }
}
