package com.premsinghdaksha.scrolltabwhenscrollrecyclerview.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class HeaderModel extends ArrayList<Parcelable> implements Parcelable {
    public String id;
    public String data1;
    public String data2;
    public String data3;
    public String data4;
    public String data5;
    public String data6;
    public String data7;
    public String data8;
    public String data9;
    public String data10;
    public String data11;
    public String data12;
    public String data13;
    public String data14;
    public String data15;
    public String data16;
    public String data17;
    public String data18;
    public String data19;
    public String data20;
    public String label;
    public String rating;
    public String rating_count;
    public String rating_url;
    public String brand_url;
    public String name_display;
    public String problem_mrp_display;
    public String problem_discount_display;
    public String last_request;
    public String type;
    public String is_editable;
    public String ticket_status;
    public String is_bold;
    public String title1Name ;
    public String title1isbold;
    String rateus;
    public boolean isSelected=false;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getRateus() {
        return rateus;
    }

    public void setRateus(String rateus) {
        this.rateus = rateus;
    }



    public String getTitle1Name() {
        return title1Name;
    }

    public void setTitle1Name(String title1Name) {
        this.title1Name = title1Name;
    }

    public String getTitle1isbold() {
        return title1isbold;
    }

    public void setTitle1isbold(String title1isbold) {
        this.title1isbold = title1isbold;
    }





    public String getTicket_status() {
        return ticket_status;
    }

    public void setTicket_status(String ticket_status) {
        this.ticket_status = ticket_status;
    }

    public String getIs_bold() {
        return is_bold;
    }

    public void setIs_bold(String is_bold) {
        this.is_bold = is_bold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIs_editable() {
        return is_editable;
    }

    public void setIs_editable(String is_editable) {
        this.is_editable = is_editable;
    }


    public String getLast_request() {
        return last_request;
    }

    public void setLast_request(String last_request) {
        this.last_request = last_request;
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


    public String getRating_url() {
        return rating_url;
    }

    public void setRating_url(String rating_url) {
        this.rating_url = rating_url;
    }

    public String getBrand_url() {
        return brand_url;
    }

    public void setBrand_url(String brand_url) {
        this.brand_url = brand_url;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating_count() {
        return rating_count;
    }

    public void setRating_count(String rating_count) {
        this.rating_count = rating_count;
    }


    public String getData21() {
        return data21;
    }

    public void setData21(String data21) {
        this.data21 = data21;
    }

    public String data21;
    public Boolean inventory_available;
    public Boolean link_required;
    public String url_param;


    ArrayList<String> bannerList = new ArrayList<>();
    ArrayList<String> bannerType = new ArrayList<>();
    ArrayList<ItemModel> serviceProblem = new ArrayList<>();

    public ArrayList<ItemModel> getServiceProblem() {
        return serviceProblem;
    }

    public void setServiceProblem(ArrayList<ItemModel> serviceProblem) {
        this.serviceProblem = serviceProblem;
    }

    public ArrayList<String> getBannerType() {
        return bannerType;
    }

    public void setBannerType(ArrayList<String> bannerType) {
        this.bannerType = bannerType;
    }

    public ArrayList<String> getBannerList() {
        return bannerList;
    }

    public void setBannerList(ArrayList<String> bannerList) {
        this.bannerList = bannerList;
    }

    public static Creator<HeaderModel> getCREATOR() {
        return CREATOR;
    }

    public HeaderModel() {
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected HeaderModel(Parcel in) {
        id = in.readString();
        data1 = in.readString();
        data2 = in.readString();
        data3 = in.readString();
        data4 = in.readString();
        data5 = in.readString();
        data6 = in.readString();
        data7 = in.readString();
        data8 = in.readString();
        data9 = in.readString();
        data10 = in.readString();
        data11 = in.readString();
        data12 = in.readString();
        data13 = in.readString();
        data14 = in.readString();
        data15 = in.readString();
        data16 = in.readString();
        data17 = in.readString();
        data18 = in.readString();
        data19 = in.readString();
        data20 = in.readString();
        data21 = in.readString();
        url_param = in.readString();
        label = in.readString();
        rating = in.readString();
        rating_count = in.readString();
        rating_url = in.readString();
        brand_url = in.readString();
        name_display = in.readString();
        problem_mrp_display = in.readString();
        problem_discount_display = in.readString();
        last_request = in.readString();
        type = in.readString();
        is_editable = in.readString();
        ticket_status = in.readString();

        is_bold = in.readString();
        title1Name = in.readString();
        title1isbold = in.readString();
        rateus = in.readString();


//        inventory_available = in.readBoolean();
        // link_required = in.readBoolean();

    }

    public static final Creator<HeaderModel> CREATOR = new Creator<HeaderModel>() {
        @Override
        public HeaderModel createFromParcel(Parcel in) {
            return new HeaderModel(in);
        }

        @Override
        public HeaderModel[] newArray(int size) {
            return new HeaderModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getUrl_param() {
        return url_param;
    }

    public void setUrl_param(String url_param) {
        this.url_param = url_param;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }

    public void setData7(String data7) {
        this.data7 = data7;
    }

    public String getData8() {
        return data8;
    }

    public void setData8(String data8) {
        this.data8 = data8;
    }

    public String getData9() {
        return data9;
    }

    public void setData9(String data9) {
        this.data9 = data9;
    }

    public String getData10() {
        return data10;
    }

    public void setData10(String data10) {
        this.data10 = data10;
    }

    public String getData11() {
        return data11;
    }

    public void setData11(String data11) {
        this.data11 = data11;
    }

    public String getData12() {
        return data12;
    }

    public void setData12(String data12) {
        this.data12 = data12;
    }

    public String getData13() {
        return data13;
    }

    public void setData13(String data13) {
        this.data13 = data13;
    }

    public String getData14() {
        return data14;
    }

    public void setData14(String data14) {
        this.data14 = data14;
    }

    public String getData15() {
        return data15;
    }

    public void setData15(String data15) {
        this.data15 = data15;
    }

    public String getData16() {
        return data16;
    }

    public void setData16(String data16) {
        this.data16 = data16;
    }

    public String getData17() {
        return data17;
    }

    public void setData17(String data17) {
        this.data17 = data17;
    }

    public String getData18() {
        return data18;
    }

    public void setData18(String data18) {
        this.data18 = data18;
    }

    public String getData19() {
        return data19;
    }

    public void setData19(String data19) {
        this.data19 = data19;
    }

    public String getData20() {
        return data20;
    }

    public void setData20(String data20) {
        this.data20 = data20;
    }


    public Boolean getInventory_available() {
        return inventory_available;
    }

    public void setInventory_available(Boolean inventory_available) {
        this.inventory_available = inventory_available;
    }

    public Boolean getLink_required() {
        return link_required;
    }

    public void setLink_required(Boolean link_required) {
        this.link_required = link_required;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(data1);
        dest.writeString(data2);
        dest.writeString(data3);
        dest.writeString(data4);
        dest.writeString(data5);
        dest.writeString(data6);
        dest.writeString(data7);
        dest.writeString(data8);
        dest.writeString(data9);
        dest.writeString(data10);
        dest.writeString(data11);
        dest.writeString(data12);
        dest.writeString(data13);
        dest.writeString(data14);
        dest.writeString(data15);
        dest.writeString(data16);
        dest.writeString(data17);
        dest.writeString(data18);
        dest.writeString(data19);
        dest.writeString(data20);
        dest.writeString(data21);
        dest.writeString(url_param);
        dest.writeString(label);
        dest.writeString(rating);
        dest.writeString(rating_count);
        dest.writeString(rating_url);
        dest.writeString(brand_url);
        dest.writeString(name_display);
        dest.writeString(problem_mrp_display);
        dest.writeString(problem_discount_display);
        dest.writeString(last_request);
        dest.writeString(type);
        dest.writeString(is_editable);
        dest.writeString(ticket_status);

        dest.writeString(is_bold);
        dest.writeString(title1Name);
        dest.writeString(title1isbold);
        dest.writeString(rateus);

    }
}
