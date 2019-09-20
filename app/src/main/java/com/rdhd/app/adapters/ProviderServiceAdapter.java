package com.rdhd.app.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.rdhd.app.R;
import com.rdhd.app.models.ProviderService;
import com.rdhd.app.repositories.interfaces.ServiceOnClick;

import java.util.List;

public class ProviderServiceAdapter extends RecyclerView.Adapter<ProviderServiceAdapter.ServiceViewHolder> {

    private List<ProviderService> providerServices;
    private Context context;
    private ServiceOnClick serviceOnClick;

    public ProviderServiceAdapter(List<ProviderService> providerServices, Context context) {
        if(providerServices.isEmpty()){
            Toast.makeText(context, "in constructor list is empty", Toast.LENGTH_SHORT).show();
        }
        this.providerServices = providerServices;
        this.context = context;
    }

    public void setServiceOnClick(ServiceOnClick serviceOnClick) {
        this.serviceOnClick = serviceOnClick;
    }



    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        final View viewitem = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_recycler_row_item,parent,false);

        final ServiceViewHolder serviceViewHolder = new ServiceViewHolder(viewitem);

        viewitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceOnClick.OnProviderServiceClick(v,serviceViewHolder.getPosition());
            }
        });

        return serviceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {

        holder.name.setText(providerServices.get(position).getName());
        holder.price.setText(providerServices.get(position).getPrice());
        holder.period.setText(providerServices.get(position).getPeriod());
        Toast.makeText(context, "onBindViewHolder: "+ providerServices.get(position).getPrice(), Toast.LENGTH_SHORT).show();
        Log.d("padapter", "onBindViewHolder: "+ providerServices.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return providerServices.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView name;
        AppCompatTextView period;
        AppCompatTextView price;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.service_name);
            period = itemView.findViewById(R.id.service_period);
            price = itemView.findViewById(R.id.service_price);
        }
    }
}

