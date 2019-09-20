package com.rdhd.app.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.rdhd.app.adapters.ProviderServiceAdapter;

public class SwipeToRemoveCallback extends ItemTouchHelper.SimpleCallback {

    ProviderServiceAdapter psa;
    public SwipeToRemoveCallback(ProviderServiceAdapter psa) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.psa = psa;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        int position = viewHolder.getAdapterPosition();
        psa.deleteItem(position);


    }
}
