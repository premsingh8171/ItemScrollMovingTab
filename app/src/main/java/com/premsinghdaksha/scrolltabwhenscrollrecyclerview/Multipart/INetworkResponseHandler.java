package com.premsinghdaksha.scrolltabwhenscrollrecyclerview.Multipart;



/**
 * Created by Admin on 29-03-2016.
 */
public interface INetworkResponseHandler<T> {

    void onNetworkResponse(NetworkRequestType type, NetworkResponse response);
}
