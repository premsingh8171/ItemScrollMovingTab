package com.premsinghdaksha.scrolltabwhenscrollrecyclerview.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.R;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.model.ItemModel;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    ArrayList<ItemModel> arrayList;
    public OnClickModelItem onclick;
    Context context;
    View view;
    int index = -1;

    public ItemAdapter(ArrayList<ItemModel> arrayList, Context context, OnClickModelItem onclick) {
        this.arrayList = arrayList;
        this.onclick = onclick;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        view = LayoutInflater.from(context).inflate(R.layout.item_item_list, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final ItemModel model = arrayList.get(position);
        Log.d("__getName_", model.getName());


        Log.d("cover_Hh", String.valueOf(model.getProblem_price()));
        holder.tv_name_serviceprdChild.setText(model.getName());
        String modelUrl = model.getModel_url_param();

        holder.tv_serviceDate_serviceprdChild.setText("View Details");

        if (!modelUrl.equals("null")) {
            holder.tv_serviceDate_serviceprdChild.setVisibility(View.VISIBLE);
        } else {
            holder.tv_serviceDate_serviceprdChild.setVisibility(View.INVISIBLE);
        }

        //select checkbox
        holder.cb_selectedPrb.setChecked(arrayList.get(position).IsSelected());
        holder.cb_selectedPrb.setTag(arrayList.get(position));

        if (!model.getProblem_price_display().equals("")) {

            holder.tv_servicePrice_.setText(model.getProblem_price_display());
            holder.paymentLayout.setVisibility(View.VISIBLE);
            if (model.getProblem_discount_display().equals("")) {
                holder.tv_company.setVisibility(View.GONE);
                holder.tv_problem_discount_display.setVisibility(View.GONE);
            } else {
                holder.tv_company.setText(model.getProblem_discount_display());
                holder.tv_problem_discount_display.setText(model.getProblem_mrp_display());
                holder.tv_problem_discount_display.setPaintFlags(holder.tv_problem_discount_display.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            }

        } else {
            holder.tv_problem_discount_display.setText("");
            holder.tv_servicePrice_.setText("");
            holder.tv_problem_discount_display.setText("");
            holder.paymentLayout.setVisibility(View.INVISIBLE);
        }
        Log.d("cover_____", model.getCover());
        Glide.with(context)
                .load(model.getCover())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.img_serviceprdChild);


        holder.tv_serviceDate_serviceprdChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick.onClickModelItem(model, "ViewDetails");

            }
        });

        holder.cb_selectedPrb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb = (CheckBox) view;
                ItemModel model_ = (ItemModel) cb.getTag();
                model_.setIsSelected(cb.isChecked());
                arrayList.get(position).setIsSelected(cb.isChecked());
                onclick.onClickModelItem(arrayList.get(position), "Select");
                notifyDataSetChanged();

            }
        });


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        holder.LL_Sp_.setLayoutParams(params);

        if (arrayList.size() - 1 == position) {
            holder.spaceAddLL.setVisibility(View.GONE);
        } else {
            holder.spaceAddLL.setVisibility(View.GONE);

        }
        // Animation animation = AnimationUtils.loadAnimation(context, R.anim.rv_right_left_anim);
        //holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name_serviceprdChild, tv_serviceDate_serviceprdChild, serviceType_serviceprdChild, tv_company, tv_servicePrice_, tv_problem_discount_display;
        private ImageView img_serviceprdChild;
        private LinearLayout linear_serviceprdChild, LL_Sp_, spaceAddLL, cb_selectedPrbLL, paymentLayout;
        private CheckBox cb_selectedPrb;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_servicePrice_ = itemView.findViewById(R.id.tv_servicePrice_);
            tv_company = itemView.findViewById(R.id.tv_company);
            tv_problem_discount_display = itemView.findViewById(R.id.tv_problem_discount_display);
            tv_name_serviceprdChild = itemView.findViewById(R.id.tv_name_serviceprdChild);
            img_serviceprdChild = itemView.findViewById(R.id.img_serviceprdChild);
            tv_serviceDate_serviceprdChild = itemView.findViewById(R.id.tv_serviceDate_serviceprdChild);
            linear_serviceprdChild = itemView.findViewById(R.id.linear_serviceprdChild);
            cb_selectedPrb = itemView.findViewById(R.id.cb_selectedPrb);
            LL_Sp_ = itemView.findViewById(R.id.LL_Sp_);
            spaceAddLL = itemView.findViewById(R.id.spaceAddLL);
            cb_selectedPrbLL = itemView.findViewById(R.id.cb_selectedPrbLL);
            paymentLayout = itemView.findViewById(R.id.paymentLayout);


        }
    }

    public interface OnClickModelItem {
        public void onClickModelItem(ItemModel model, String callFor);
    }
}
