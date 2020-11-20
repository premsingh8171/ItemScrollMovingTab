package com.premsinghdaksha.scrolltabwhenscrollrecyclerview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemModel implements Parcelable {
    public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel in) {
            return new ItemModel(in);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };
    public String name;
    public String id;
    public String url_param;
    public String model_url_param;
    public String model_id;
    public String cover;
    public String problem_price;
    public String model;
    public boolean isSelected;
    public String name_display;
    public String problem_mrp_display;
    public String problem_discount_display;
    public String problem_price_display;

    public ItemModel() {
    }

    protected ItemModel(Parcel in) {
        name = in.readString();
        url_param = in.readString();
        model_url_param = in.readString();
        cover = in.readString();
        problem_price = in.readString();
        model = in.readString();
        id = in.readString();
        model_id = in.readString();
        isSelected = in.readBoolean();
        name_display = in.readString();
        problem_mrp_display = in.readString();
        problem_discount_display = in.readString();
        problem_price_display = in.readString();
    }

    public static Creator<ItemModel> getCREATOR() {
        return CREATOR;
    }

    public String getProblem_price_display() {
        return problem_price_display;
    }

    public void setProblem_price_display(String problem_price_display) {
        this.problem_price_display = problem_price_display;
    }

    public String getName_display() {
        return name_display;
    }

    public void setName_display(String name_display) {
        this.name_display = name_display;
    }

    public String getProblem_mrp_display() {
        return problem_mrp_display;
    }

    public void setProblem_mrp_display(String problem_mrp_display) {
        this.problem_mrp_display = problem_mrp_display;
    }

    public String getProblem_discount_display() {
        return problem_discount_display;
    }

    public void setProblem_discount_display(String problem_discount_display) {
        this.problem_discount_display = problem_discount_display;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public String getModel_url_param() {
        return model_url_param;
    }

    public void setModel_url_param(String model_url_param) {
        this.model_url_param = model_url_param;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_param() {
        return url_param;
    }

    public void setUrl_param(String url_param) {
        this.url_param = url_param;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getProblem_price() {
        return problem_price;
    }

    public void setProblem_price(String problem_price) {
        this.problem_price = problem_price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean IsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(url_param);
        parcel.writeString(model_url_param);
        parcel.writeString(cover);
        parcel.writeString(problem_price);
        parcel.writeString(model);
        parcel.writeString(id);
        parcel.writeString(model_id);
        parcel.writeBoolean(isSelected);
        parcel.writeString(name_display);
        parcel.writeString(problem_mrp_display);
        parcel.writeString(problem_discount_display);
        parcel.writeString(problem_price_display);
    }
}