package com.premsinghdaksha.scrolltabwhenscrollrecyclerview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.R;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.model.HeaderModel;

import java.util.ArrayList;

public class HeaderTabAdapter extends RecyclerView.Adapter<HeaderTabAdapter.SPViewHolder> {
    public Context context;
    public ArrayList<HeaderModel> arrayList;
    public View view;
    int index = 0;
    public onClickTab onClickTab;
    int valueselected;


    public HeaderTabAdapter(Context context, ArrayList<HeaderModel> arrayList, onClickTab onClickTab, int valueselected) {
        this.context = context;
        this.arrayList = arrayList;
        this.onClickTab = onClickTab;
        this.valueselected = valueselected;
    }

    @NonNull
    @Override
    public SPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_header_tab, parent, false);
        return new SPViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SPViewHolder holder, final int position) {
        final HeaderModel model = arrayList.get(position);
        holder.tab_layout_Tv.setText(model.getData10());
        index = valueselected;
        holder.tab_layout_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = position;
                valueselected = position;
                onClickTab.onClickTab(model, position);
                notifyDataSetChanged();
            }
        });

        Log.d("getName__", index + "---" + position + "--" + model.getData10() + "---" + valueselected + "--" + model.isSelected);

        if (index == position) {
            holder.tab_layout_linear.setBackgroundResource(R.drawable.rectangle_shap);
            holder.tab_layout_Tv.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));

        } else {
            holder.tab_layout_linear.setBackgroundResource(R.drawable.rectangle_shap_un);
            holder.tab_layout_Tv.setTextColor(ContextCompat.getColor(context, R.color.colorWhite));

        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void updateReceiptsList(int value) {
        valueselected = value;
        Log.d("valueselected____", String.valueOf(valueselected));
        this.notifyDataSetChanged();
    }

    public class SPViewHolder extends RecyclerView.ViewHolder {
        private TextView tab_layout_Tv;
        private LinearLayout tab_layout_linear, selectionTab_service;

        public SPViewHolder(@NonNull View itemView) {
            super(itemView);
            tab_layout_linear = itemView.findViewById(R.id.tab_layout_linear);
            tab_layout_Tv = itemView.findViewById(R.id.tab_layout_Tv);
            selectionTab_service = itemView.findViewById(R.id.selectionTab_service);

        }
    }

    public interface onClickTab {
        public void onClickTab(HeaderModel model, int positon);

    }
}