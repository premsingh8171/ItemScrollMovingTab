package com.premsinghdaksha.scrolltabwhenscrollrecyclerview.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.Multipart.MultipartRequest;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.Multipart.NetworkOperationHelper;
import com.premsinghdaksha.scrolltabwhenscrollrecyclerview.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class uploadDoc extends AppCompatActivity {
    ImageView uploadImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_doc);
        uploadImg = findViewById(R.id.uploadImg);

        uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectCoverImage();
            }
        });
    }

    private void selectCoverImage() {
        CropImage.activity().setGuidelines(CropImageView.Guidelines.OFF).start(uploadDoc.this);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {

            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);

                if (resultCode == RESULT_OK) {
                    Uri resulturi = CropImage.getActivityResult(data).getUri();
                    File file = new File(resulturi.getPath());
                    //resultUr = result.getUri();
                    String strWarranty = resulturi.getPath();
                    Log.d("strWarrantyddd", strWarranty);
                    uploadDocument(file);

//                     Glide.with(ActivateProductUploadDocuments.this).load(strWarranty)
//                            .placeholder(R.drawable.ed)
//                            .error(R.drawable.ed)
//                            .into(warrantyImgdoc1);
                }
            }

        } catch (Exception e) {
        }
    }

    private void uploadDocument(File fileee) {

        MultipartRequest req = null;
        HashMap<String, String> map = new HashMap<>();
        map.put("CompanyId", "1");
        map.put("AmountReceived", "2500");
        map.put("BankDetail", "icici bank");
        map.put("InstrumentNumber", "5666");
        map.put("Otp", "1234");
        map.put("BillNumber", "");
        map.put("PaymentReceivedDate", "");
        map.put("SalesmanId", "1");
        map.put("RetailerInvoiceId", "2");
        map.put("InstrumentDate", "");
        map.put("ChequeNumber", "12345678");
        map.put("ChequeDate", "2020-11-02");
        map.put("PaymentMode", "Cheque");

        String url = "http://webapi.rippller.com/api/ReceivedChequePayment/ReceiveChequePayment";
        try {
            req = new MultipartRequest(url, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(uploadDoc.this, "" + error, Toast.LENGTH_SHORT).show();

                    return;
                }
            }, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String message = jsonObject.getString("message");

                        Toast.makeText(uploadDoc.this, "" + message, Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, map);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        req.addImageData("file", fileee);
        NetworkOperationHelper.getInstance(uploadDoc.this).addToRequestQueue(req);
        req.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
            }
        });
    }


}