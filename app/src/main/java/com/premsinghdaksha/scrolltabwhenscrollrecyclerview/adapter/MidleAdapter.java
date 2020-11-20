package com.premsinghdaksha.scrolltabwhenscrollrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.R;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.model.HeaderModel;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.model.ItemModel;

import java.util.ArrayList;

public class MidleAdapter extends RecyclerView.Adapter<MidleAdapter.MidleViewHolder> {
    ArrayList<HeaderModel> changeList;
    View view;
    Context mContext;
    ItemAdapter itemAdapter;
    AddItem addItem;
    ArrayList<String> listItem = new ArrayList<>();

    public MidleAdapter(ArrayList<HeaderModel> changeList, Context mContext, AddItem addItem) {
        this.changeList = changeList;
        this.mContext = mContext;
        this.addItem = addItem;
    }

    @NonNull
    @Override
    public MidleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_scroll, parent, false);
        return new MidleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MidleViewHolder holder, int position) {
        HeaderModel model = changeList.get(position);
        holder.header_title.setText(model.getData10());
        childListRv(holder, position, model.getServiceProblem());

    }

    @Override
    public int getItemCount() {
        return changeList.size();
    }

    public void updateReceiptsList(int value) {
        this.notifyDataSetChanged();
    }

    public class MidleViewHolder extends RecyclerView.ViewHolder {
        RecyclerView scroll_list_rv;
        TextView header_title;

        public MidleViewHolder(@NonNull View itemView) {
            super(itemView);
            scroll_list_rv = itemView.findViewById(R.id.scroll_list_rv);
            header_title = itemView.findViewById(R.id.header_title);
        }
    }

    private void childListRv(MidleViewHolder holder, int position, ArrayList<ItemModel> list) {
        itemAdapter = new ItemAdapter(list, mContext, new ItemAdapter.OnClickModelItem() {
            @Override
            public void onClickModelItem(ItemModel model, String callFor) {
                String getValue = model.getId();
                if (model.isSelected()) {
                    listItem.add(getValue);
                } else {
                    listItem.remove(getValue);
                }
                //Log.d("listItem-val", String.valueOf(listItem.size()));
                addItem.onClick(String.valueOf(listItem.size()));

            }
        });
        holder.scroll_list_rv.setAdapter(itemAdapter);
        itemAdapter.notifyDataSetChanged();

    }

    public interface AddItem {
        public void onClick(String count);
    }

}
