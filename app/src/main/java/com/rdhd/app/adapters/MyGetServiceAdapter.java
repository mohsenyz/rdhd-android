package com.rdhd.app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.rdhd.app.models.MyGetService;
import com.rdhd.app.repositories.interfaces.ServiceOnClick;

import java.util.List;

public class MyGetServiceAdapter extends RecyclerView.Adapter<MyGetServiceAdapter.GetServiceViewHolder> {

    private Context context;
    private List<MyGetService> getServiceList;
    private ServiceOnClick serviceOnClickListener;

    public MyGetServiceAdapter(Context context, List<MyGetService> getServiceList) {
        this.context = context;
        this.getServiceList = getServiceList;
    }

    public void setServiceOnClickListener(ServiceOnClick serviceOnClickListener) {
        this.serviceOnClickListener = serviceOnClickListener;
    }

    @NonNull
    @Override
    public GetServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GetServiceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return getServiceList.size();
    }


    public class GetServiceViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView phoneNumTv, startDate, endDate;
        public GetServiceViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
