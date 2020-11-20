package com.premsinghdaksha.scrolltabwhenscrollrecyclerview;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.adapter.HeaderTabAdapter;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.adapter.ItemAdapter;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.adapter.MidleAdapter;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.model.HeaderModel;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.model.ItemModel;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.responce.DataResponce;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.premsinghdaksha.scrolltabwhenscrollrecyclerview.responce.DataResponce.RESPONCE_;

public class MainActivity extends AppCompatActivity {
    HeaderTabAdapter headerTabAdapter;
    ItemAdapter itemAdapter;
    int selected;
    //String response = "{ \"data\": { \"services\": { \"responseInfo\": { \"status\": 200, \"message\": \"\", \"error\": \"\" }, \"data\": [ { \"id\": \"1\", \"name\": \"Tv\", \"description\": \"You can initiate installation request for this product\", \"type\": \"Request\", \"category\": \"Repair\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/k9u8zgw0/television/r/q/g/mi-l43m4-4ain-original-imafrjtbrhzavehr.jpeg\", \"url_param\": \"daikin\", \"problems\": [ { \"id\": 16, \"name\": \"Mi 4X 108 cm (43) Ultra HD (4K) LED Smart Android TV\", \"url_param\": \"brand=mi\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/k9u8zgw0/television/r/q/g/mi-l43m4-4ain-original-imafrjtbrhzavehr.jpeg\", \"problem_price\": \"7559\", \"name_display\": \"There is no fun in watching your favourite movie or show on a TV where the display quality is poor. Now, don’t ruin the fun and watch them all in good and clear-quality on this 108 cm (43) Mi smart TV. Its 4K display can accentuate your viewing experience and make it even better.\", \"problem_mrp_display\": \"₹ 8399\", \"problem_discount_display\": \"10%\", \"problem_price_display\": \"₹ 7559\", \"model\": { \"id\": 2429, \"url_param\": \"brand=mi\" } }, { \"id\": 15, \"name\": \"Thomson 108cm (43 inch) Ultra HD (4K) LED Smart Android TV with Dolby Vision and Dolby Digital Plus  (43 OATHPRO 2000)\", \"url_param\": \"brand=Thomas\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/kc3p30w0/television/z/b/e/thomson-65-oathpro-2020-original-imaftaquapygjk2w.jpeg\", \"problem_price\": \"1\", \"name_display\": \"From movie marathons to game nights, everything will seem visually appealing when you bring home this TV from Thomson. It is packed with features such as the 4K UHD resolution, Dolby Vision, and the MEMC technology for vivid visuals and great audio.\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"₹ 1\", \"model\": { \"id\": 2427, \"url_param\": \"brand=thomas,id=1;\" } }, { \"id\": 26, \"name\": \"Kodak 7X Pro 108cm (43 inch) Ultra HD (4K) LED Smart Android TV  (43UHDX7XPRO)\", \"url_param\": \"brand=Kodak\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/kfikya80/television/7/7/y/kodak-43uhdx7xpro-original-imafvxs2dvfgwwhg.jpeg\", \"problem_price\": \"\", \"name_display\": \"It produces visuals with lifelike colors, improved brightness and enhanced contrast to offer an excellent viewing experience.\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null } ] }, { \"id\": \"1\", \"name\": \"Mobile\", \"description\": \"Mobile types\", \"type\": \"Mobile Request\", \"category\": \"Request\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/kgiaykw0/mobile/x/9/g/oppo-a33-cph2137-original-imafwqg8ashrnxrb.jpeg\", \"url_param\": \"brand=oppo;\", \"problems\": [ { \"id\": 16, \"name\": \"OPPO A33 (Mint Cream, 32 GB)  (3 GB RAM)\", \"url_param\": \"brand=oppo;\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/kgiaykw0/mobile/x/9/g/oppo-a33-cph2137-original-imafwqg8ashrnxrb.jpeg\", \"problem_price\": \"7559\", \"name_display\": \"Get set to view all visuals clearly and play your favourite games vividly on this smartphone’s 90 Hz Punch-hole display.\", \"problem_mrp_display\": \"₹ 8399\", \"problem_discount_display\": \"10%\", \"problem_price_display\": \"₹ 7559\", \"model\": { \"id\": 2429, \"url_param\": \"brand=oppo\" } }, { \"id\": 15, \"name\": \"Samsung Galaxy M31s (Mirage Black, 128 GB)  (6 GB RA)\", \"url_param\": \"brand\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/keekmfk0/mobile/n/g/p/samsung-galaxy-m31s-sm-m317fzkdins-original-imafv3py9qnwfeft.jpeg\", \"problem_price\": \"1\", \"name_display\": \"With Samsung Galaxy M31s, Samsung introduces a 6000 mAh battery with a 25 Watt Fast charger for the first time in this price segment- along with all round features comprising of a 64 MP rear camera in Quad camera set up and an immersive + sAMOLED Infinity-O Display.\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"₹ 1\", \"model\": { \"id\": 2427, \"url_param\": \"brand=samsung;\" } }, { \"id\": 26, \"name\": \"Apple iPhone 8 Plus (PRODUCT)RED (Red, 64 GB)\", \"url_param\": \"brand=apple;\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/jgffp8w0/mobile/y/4/8/apple-iphone-8-plus-product-red-special-edition-mrt72hn-a-original-imaf4gueermyhqg8.jpeg\", \"problem_price\": \"\", \"name_display\": \"iPhone with iOS 12, EarPods with Lightning Connector, Lightning to USB Cable, USB Power Adapter, Documentation\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null } ] }, { \"id\": \"2\", \"name\": \"Cloths for men\", \"description\": \"You can purchase for this product\", \"type\": \"Request\", \"category\": \"Service\", \"cover\": \"Color Block Men Round Neck Black, Grey T-Shirt\", \"url_param\": \"brand=cloths_for_main;\", \"problems\": [ { \"id\": 12, \"name\": \"Color Block Men Round Neck Black, Grey T-Shirt\", \"url_param\": \"service=order\", \"cover\": \"https://rukminim1.flixcart.com/image/880/1056/kfoapow0-0/t-shirt/l/h/j/s-sporty-casuals-gray-black-wrath-original-imafw2gxsjfty56u.jpeg\", \"problem_price\": \"\", \"name_display\": \"General\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 121, \"name\": \"Color Block Men Round Neck Black, Grey T-Shirt\", \"url_param\": \"service=order\", \"cover\": \"https://rukminim1.flixcart.com/image/880/1056/kfoapow0-0/t-shirt/l/h/j/s-sporty-casuals-gray-black-wrath-original-imafw2gxsjfty56u.jpeg\", \"problem_price\": \"\", \"name_display\": \"General\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 122, \"name\": \"Color Block Men Round Neck Black, Grey T-Shirt\", \"url_param\": \"service=order\", \"cover\": \"https://rukminim1.flixcart.com/image/880/1056/kfoapow0-0/t-shirt/l/h/j/s-sporty-casuals-gray-black-wrath-original-imafw2gxsjfty56u.jpeg\", \"problem_price\": \"\", \"name_display\": \"General\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 123, \"name\": \"Color Block Men Round Neck Black, Grey T-Shirt\", \"url_param\": \"service=order\", \"cover\": \"https://rukminim1.flixcart.com/image/880/1056/kfoapow0-0/t-shirt/l/h/j/s-sporty-casuals-gray-black-wrath-original-imafw2gxsjfty56u.jpeg\", \"problem_price\": \"\", \"name_display\": \"General\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null } ] }, { \"id\": \"3\", \"name\": \"Cloths for Women\", \"description\": \"Women Printed Cotton Rayon Blend Flared Kurta  (Yellow)\", \"type\": \"order\", \"category\": \"kurti\", \"cover\": \"kurti.png\", \"url_param\": \"category=t-kurti;\", \"problems\": [ { \"id\": 11, \"name\": \"Women Printed Cotton Rayon Blend Flared Kurta  (Yellow)\", \"url_param\": \"brand=MAHAGEETA;\", \"cover\": \"https://rukminim1.flixcart.com/image/880/1056/kg8avm80-0/kurta/8/v/8/xl-ku233-mahageeta-original-imafwgc6qeatcjay.jpeg\", \"problem_price\": \"\", \"name_display\": \"Women Printed Cotton Rayon Blend Flared Kurta  (Yellow)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 1, \"name\": \"Embroidered Semi Stitched Lehenga Choli  (Green)\", \"url_param\": \"brand\", \"cover\": \"https://rukminim1.flixcart.com/image/880/1056/jmxrwy80/lehenga-choli/w/y/w/free-ss-green-dreambucket-original-imaf73t8hzd9vkb5.jpeg\", \"problem_price\": \"40\", \"name_display\": \"Embroidered Semi Stitched Lehenga Choli  (Green)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"₹ 40\", \"model\": { \"id\": 2429, \"url_param\": \"brand=null;\" } }, { \"id\": 6, \"name\": \"Solid Daily Wear Poly Georgette Saree  (Grey).\", \"url_param\": \"brand;\", \"cover\": \"https://rukminim1.flixcart.com/image/880/1056/k12go7k0/sari/p/h/c/free-bd030-bollydoll-designer-original-imafgjen5kwbudbm.jpeg\", \"problem_price\": \"9\", \"name_display\": \"https://rukminim1.flixcart.com/image/880/1056/k12go7k0/sari/p/h/c/free-bd030-bollydoll-designer-original-imafgjen5kwbudbm.jpeg.\", \"problem_mrp_display\": \"₹ 10\", \"problem_discount_display\": \"10%\", \"problem_price_display\": \"₹ 9\", \"model\": null }, { \"id\": 1, \"name\": \"Embroidered Semi Stitched Lehenga Choli  (Black)\", \"url_param\": \"brand\", \"cover\": \"https://rukminim1.flixcart.com/image/540/648/kb9ou4w0/lehenga-choli/d/j/a/free-sleeveless-angel-lehengablack-logo-of-alphabet-a-original-imafsnpqvvbgxhar.jpeg\", \"problem_price\": \"40\", \"name_display\": \"Embroidered Semi Stitched Lehenga Choli  (Black)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"₹ 40\", \"model\": { \"id\": 2429, \"url_param\": \"type=choali;\" } }, { \"id\": 1, \"name\": \"Does not operate - I shall maintain a safe distance during visit. I shall maintain a safe distance during visitI shall maintain a safe distance during visit\", \"url_param\": \"problem_id=1;problem_name=Does not operate - I shall maintain a safe distance during visit. I shall maintain a safe distance during visitI shall maintain a safe distance during visit;additional_info=ODU_Serial_No:ABC~ODU_Model_No:111111~Brand_Product_ID:Onedios;model_id=1;first=2000;brand_name=Daikin;provider=OEM;service_provider_name=Daikin;product_name=Split Ac;category_name=Air Conditioner;transaction_type=Request;type=Display;sp_name=select_issue_page;\", \"cover\": \"https://eservify-dev.s3.ap-south-1.amazonaws.com/problems/AsUsXThbjQEcBFodw2qekrh4m1CsxE2z3kMhkkAp.png\", \"problem_price\": \"40\", \"name_display\": \"Complaint - Does not operate - I shall maintain a safe distance during visit. I shall maintain a safe distance during visitI shall maintain a safe distance during visit\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"₹ 40\", \"model\": { \"id\": 2429, \"url_param\": \"sales_model_id=2429;additional_info=ODU_Serial_No:ABC~ODU_Model_No:111111~Brand_Product_ID:Onedios;model_id=1;first=2000;brand_name=Daikin;provider=OEM;service_provider_name=Daikin;product_name=Split Ac;category_name=Air Conditioner;transaction_type=Request;type=Display;sp_name=select_issue_page;\" } }, { \"id\": 11, \"name\": \"Women Printed Cotton Rayon Blend Flared Kurta  (Yellow)\", \"url_param\": \"brand=MAHAGEETA;\", \"cover\": \"https://rukminim1.flixcart.com/image/880/1056/kg8avm80-0/kurta/8/v/8/xl-ku233-mahageeta-original-imafwgc6qeatcjay.jpeg\", \"problem_price\": \"\", \"name_display\": \"Women Printed Cotton Rayon Blend Flared Kurta  (Yellow)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null } ] }, { \"id\": \"3\", \"name\": \"Toys\", \"description\": \"You can raise complaint for this product\", \"type\": \"Request\", \"category\": \"Complaint\", \"cover\": \"toy.png\", \"url_param\": \"brand=toy;\", \"problems\": [ { \"id\": 11, \"name\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/remote-control-toy/f/j/c/rechargeable-rc-bmw-scale-remote-controlled-car-with-3d-light-original-imaer35smwqzyraw.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/remote-control-toy/f/j/c/rechargeable-rc-bmw-scale-remote-controlled-car-with-3d-light-original-imaer35smwqzyraw.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/remote-control-toy/f/j/c/rechargeable-rc-bmw-scale-remote-controlled-car-with-3d-light-original-imaer35smwqzyraw.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/remote-control-toy/f/j/c/rechargeable-rc-bmw-scale-remote-controlled-car-with-3d-light-original-imaer35smwqzyraw.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/remote-control-toy/f/j/c/rechargeable-rc-bmw-scale-remote-controlled-car-with-3d-light-original-imaer35smwqzyraw.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/remote-control-toy/f/j/c/rechargeable-rc-bmw-scale-remote-controlled-car-with-3d-light-original-imaer35smwqzyraw.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/remote-control-toy/f/j/c/rechargeable-rc-bmw-scale-remote-controlled-car-with-3d-light-original-imaer35smwqzyraw.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null } ] }, { \"id\": \"3\", \"name\": \"Home & Furniture\", \"description\": \"Home & Furniture\", \"type\": \"Home & Furniture\", \"category\": \"Home & Furniture\", \"cover\": \"Homefurniture.png\", \"url_param\": \"brand=toy;\", \"problems\": [ { \"id\": 11, \"name\": \"Home Edge Aelinia Sheesham Solid Wood King Hydraulic Bed  (Finish Color - Teak)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/k5ihzm80/bed/h/c/p/king-beige-mango-wood-hop-bed-beige-king-house-of-pataudi-walnut-original-imafz6g9er6k4jgn.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"House of Pataudi Solid Wood King Bed  (Finish Color - Walnut)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/k5ihzm80/bed/h/c/p/king-beige-mango-wood-hop-bed-beige-king-house-of-pataudi-walnut-original-imafz6g9er6k4jgn.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"Home Edge Aelinia Sheesham Solid Wood King Hydraulic Bed  (Finish Color - Teak)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/k5ihzm80/bed/h/c/p/king-beige-mango-wood-hop-bed-beige-king-house-of-pataudi-walnut-original-imafz6g9er6k4jgn.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"House of Pataudi Solid Wood King Bed  (Finish Color - Walnut)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/k5ihzm80/bed/h/c/p/king-beige-mango-wood-hop-bed-beige-king-house-of-pataudi-walnut-original-imafz6g9er6k4jgn.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"Home Edge Aelinia Sheesham Solid Wood King Hydraulic Bed  (Finish Color - Teak)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/k5ihzm80/bed/h/c/p/king-beige-mango-wood-hop-bed-beige-king-house-of-pataudi-walnut-original-imafz6g9er6k4jgn.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null }, { \"id\": 11, \"name\": \"House of Pataudi Solid Wood King Bed  (Finish Color - Walnut)\", \"url_param\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White);\", \"cover\": \"https://rukminim1.flixcart.com/image/352/352/k5ihzm80/bed/h/c/p/king-beige-mango-wood-hop-bed-beige-king-house-of-pataudi-walnut-original-imafz6g9er6k4jgn.jpeg\", \"problem_price\": \"\", \"name_display\": \"jasan Rechargeable RC BMW Scale Remote controlled Car With 3d Light White  (White)\", \"problem_mrp_display\": \"\", \"problem_discount_display\": \"\", \"problem_price_display\": \"\", \"model\": null } ] } ] } } }";
    String response;
    RecyclerView main_rv, headerTabRv;
    MidleAdapter adapter;
    private final ArrayList<HeaderModel> tabList = new ArrayList<>();
    private GridLayoutManager manager;
    DataResponce dataResponce;
    TextView badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataResponce = new DataResponce();
        intieView();

    }

    private void intieView() {
        badge = findViewById(R.id.badge);
        main_rv = findViewById(R.id.main_rv);
        headerTabRv = findViewById(R.id.headerTabRv);
        manager = new GridLayoutManager(MainActivity.this, 1);
        responceParse();
    }

    private void responceParse() {
        String status, message, error;
        response = RESPONCE_;
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject dataObj = jsonObject.getJSONObject("data");
            JSONObject servicesObj = dataObj.getJSONObject("services");
            JSONObject responseInfobject = servicesObj.getJSONObject("responseInfo");
            status = responseInfobject.optString("status");
            message = responseInfobject.optString("message");
            error = responseInfobject.optString("error");

            JSONArray dataArray = servicesObj.getJSONArray("data");
            if (status.equals("200")) {
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject arrayDataObj1 = dataArray.getJSONObject(0);
                    HeaderModel model = new HeaderModel();
                    JSONObject arrayDataObj = dataArray.getJSONObject(i);
                    model.setData9(arrayDataObj.optString("id"));
                    model.setData10(arrayDataObj.optString("name"));
                    model.setData14(arrayDataObj.optString("description"));
                    model.setData15(arrayDataObj.optString("type"));
                    model.setData16(arrayDataObj.optString("category"));
                    model.setData13(arrayDataObj.optString("cover"));
                    model.setUrl_param(arrayDataObj.optString("url_param"));
                    model.setSelected(false);

                    ArrayList<ItemModel> itemList = new ArrayList<>();
                    JSONArray problemArray = arrayDataObj.optJSONArray("problems");
                    for (int k = 0; k < problemArray.length(); k++) {
                        JSONObject prmObj = problemArray.getJSONObject(k);
                        ItemModel itemModel = new ItemModel();
                        itemModel.setId(prmObj.optString("id"));
                        itemModel.setName(prmObj.optString("name"));
                        itemModel.setUrl_param(prmObj.optString("url_param"));
                        itemModel.setCover(prmObj.optString("cover"));
                        itemModel.setName_display(prmObj.optString("name_display"));
                        itemModel.setProblem_mrp_display(prmObj.optString("problem_mrp_display"));

                        itemModel.setProblem_discount_display(prmObj.optString("problem_discount_display"));
                        itemModel.setProblem_price_display(prmObj.optString("problem_price_display"));


                        if (!prmObj.optString("problem_price").equals("")) {
                            itemModel.setProblem_price(prmObj.optString("problem_price"));
                        } else {
                            itemModel.setProblem_price("null");
                        }
                        itemModel.setIsSelected(false);

                        JSONObject modelObj = prmObj.optJSONObject("model");
                        if (modelObj != null) {
                            itemModel.setModel_url_param(modelObj.optString("url_param"));
                        } else {
                            itemModel.setModel_url_param("null");

                        }

                        itemList.add(itemModel);

                    }

                    Log.d("itemList__", String.valueOf(itemList.size()));


                    model.setServiceProblem(itemList);
                    tabList.add(model);

                    Log.d("tabList___", String.valueOf(tabList.size()));

                }


                headerTabAdapterRv(tabList);
                scrollItemRv(tabList);

            }
        } catch (Exception e) {

        }
    }

    private void headerTabAdapterRv(ArrayList<HeaderModel> dataList) {
        headerTabAdapter = new HeaderTabAdapter(MainActivity.this, dataList, new HeaderTabAdapter.onClickTab() {
            @Override
            public void onClickTab(HeaderModel model, int position) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) main_rv.getLayoutManager();
                Log.d("position__", String.valueOf(position));
                main_rv.scrollToPosition(position);
                linearLayoutManager.scrollToPositionWithOffset(position, 0);

            }
        }, selected);
        headerTabRv.setAdapter(headerTabAdapter);
        headerTabAdapter.notifyDataSetChanged();
        headerTabRv.setNestedScrollingEnabled(false);

    }

    private void scrollItemRv(ArrayList<HeaderModel> dataList) {
        adapter = new MidleAdapter(dataList, MainActivity.this, new MidleAdapter.AddItem() {
            @Override
            public void onClick(String count) {
                Log.d("count_val", String.valueOf(count));
                badge.setText(count);
            }
        });
        main_rv.setAdapter(adapter);
        main_rv.setLayoutManager(manager);
        main_rv.setNestedScrollingEnabled(false);
        main_rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // find first complete visibile item position
                //int firstCompleteleyVisibleItemPosition = manager.findFirstCompletelyVisibleItemPosition();
                int completeleyVisible = manager.findFirstVisibleItemPosition();
                selected = completeleyVisible;

                headerTabAdapter.updateReceiptsList(completeleyVisible);
                headerTabRv.smoothScrollToPosition(completeleyVisible);

            }
        });

    }
}