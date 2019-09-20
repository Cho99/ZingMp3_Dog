package com.example.appmusicv2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appmusicv2.Adapter.ListCategorybySubjectAdapter;
import com.example.appmusicv2.Model.Kind;
import com.example.appmusicv2.Model.Topic;
import com.example.appmusicv2.R;
import com.example.appmusicv2.Service.APIService;
import com.example.appmusicv2.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesbysubjectActivity extends AppCompatActivity {

    Topic topic;
    Toolbar toolbar;
    RecyclerView recyclerView;
    ListCategorybySubjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoriesbysubject);
        GetInetent();
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Kind>> call = dataservice.GetDataCatergoryBySubject("1");
        call.enqueue(new Callback<List<Kind>>() {
            @Override
            public void onResponse(Call<List<Kind>> call, Response<List<Kind>> response) {
                ArrayList<Kind> array_listkind = (ArrayList<Kind>) response.body();
                adapter = new ListCategorybySubjectAdapter(CategoriesbysubjectActivity.this, array_listkind);
                recyclerView.setLayoutManager(new GridLayoutManager(CategoriesbysubjectActivity.this, 2));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Kind>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerCategorybySubjet);
        toolbar = findViewById(R.id.toobarCategorybysubject);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(topic.getNameTopic());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetInetent() {
        Intent intent = getIntent();
        if (intent.hasExtra("topic")) {
            topic = (Topic) intent.getSerializableExtra("topic");
        }
    }
}
