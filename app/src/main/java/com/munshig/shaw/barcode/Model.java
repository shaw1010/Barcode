package com.munshig.shaw.barcode;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Model extends ArrayAdapter<String> {

    private Activity context;
    private List<String> barcodeList;



    public Model (Activity context, List<String> barcodeList){
        super(context, R.layout.barcodelist, barcodeList);
        this.context = context;
        this.barcodeList = barcodeList;}


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.barcodelist, null, true);

        TextView barcodes = (TextView) listViewItem.findViewById(R.id.barcodes);


        String item = barcodeList.get(position);

        barcodes.setText(item);


        return listViewItem;

    }

}
