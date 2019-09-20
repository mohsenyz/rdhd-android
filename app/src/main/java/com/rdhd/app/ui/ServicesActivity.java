package com.rdhd.app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rdhd.app.R;
import com.rdhd.app.adapters.ProviderServiceAdapter;
import com.rdhd.app.models.ProviderService;
import com.rdhd.app.repositories.interfaces.ServiceOnClick;
import com.rdhd.app.repositories.interfaces.SubmitDialog;
import com.rdhd.app.dialogs.CustomDialog;
import com.rdhd.app.dialogs.GetServiceDialog;
import com.rdhd.app.utils.SwipeToRemoveCallback;

import java.util.ArrayList;
import java.util.List;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class ServicesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProviderServiceAdapter psa;
    LinearLayoutManager linearLayoutManager;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        recyclerView = findViewById(R.id.services_recyclerView);
        fab = findViewById(R.id.floatingActionButton);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomDialog customDialog = new CustomDialog(ServicesActivity.this, new SubmitDialog() {
                    @Override
                    public void OnSubmitListener(ProviderService providerService) {
                        Toast.makeText(ServicesActivity.this, "this is " + providerService.getName(), Toast.LENGTH_SHORT).show();

                    }
                });
                customDialog.show();
            }
        });
        final List<ProviderService> providerServiceList = new ArrayList<>();

        ProviderService p1 = new ProviderService("بیمه آسیا","1233","2000","دوماه","20","بیمه");

        for (int i=0;i<5;i++){
            providerServiceList.add(p1);
        }

        if(providerServiceList.isEmpty()){
            Toast.makeText(this, "empty ):", Toast.LENGTH_SHORT).show();
        }
        psa = new ProviderServiceAdapter(providerServiceList,this);
        linearLayoutManager = new LinearLayoutManager(this);
        psa.setServiceOnClick(new ServiceOnClick() {
            @Override
            public void OnProviderServiceClick(View itemView, int position) {
               // Toast.makeText(ServicesActivity.this, "داره کار میکنه بابا"+position, Toast.LENGTH_SHORT).show();

                GetServiceDialog getServiceDialog = new GetServiceDialog(ServicesActivity.this);
                getServiceDialog.show();
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(psa);
        SwipeToRemoveCallback swipeToRemoveCallback = new SwipeToRemoveCallback(psa);
        new ItemTouchHelper(swipeToRemoveCallback).attachToRecyclerView(recyclerView);

        psa.notifyDataSetChanged();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomDialog customDialog = new CustomDialog(ServicesActivity.this, new SubmitDialog() {
                    @Override
                    public void OnSubmitListener(ProviderService providerService) {
                        Toast.makeText(ServicesActivity.this, "this is " + providerService.getName(), Toast.LENGTH_SHORT).show();
                        providerServiceList.add(providerService);
                        psa.notifyItemInserted(providerServiceList.size()-1);
                        psa.notifyDataSetChanged();
                    }
                });
                customDialog.show();
            }
        });



    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
