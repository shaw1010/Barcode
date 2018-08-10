package com.munshig.shaw.barcode;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class validate_model extends ArrayAdapter<Barcode> {

    private Activity context;
    private List<Barcode> barcodeList;
    Boolean select;
    int pos;
    Unique_barcode codes;
    String name;
    String price;
    String packet;
    int flag;
    Unique_barcode bar;

    public validate_model(Activity context, List<Barcode> barcodeList, int position, Unique_barcode bar) {
        super(context, R.layout.validate, (barcodeList));
        this.context = context;
        this.barcodeList = barcodeList;
        this.pos = position;
        this.bar = bar;
    }

    private class ViewHolder {
        CheckBox name;
        CheckBox price;
        CheckBox packet;
    }

//    public Boolean getSelect() {
//        return select;
//    }
//
//    public void setSelect(Boolean select) {
//        this.select = select;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public String getPacket() {
//        return packet;
//    }
//
//    public void setPacket(String packet) {
//        this.packet = packet;
//    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.validate, null, true);

         CheckBox name = listViewItem.findViewById(R.id.check_name);
         CheckBox price = listViewItem.findViewById(R.id.check_price);
         CheckBox packet_price = listViewItem.findViewById(R.id.check_code);

        holder = new ViewHolder();
        holder.price = (CheckBox) listViewItem.findViewById(R.id.check_price);
        holder.packet = (CheckBox) listViewItem.findViewById(R.id.check_code);
        holder.name = (CheckBox) listViewItem.findViewById(R.id.check_name);

        holder.name.setText(barcodeList.get(position).getName());
        holder.price.setText(barcodeList.get(position).getPrice());
        holder.packet.setText(barcodeList.get(position).getPacket());

        name.setText(barcodeList.get(position).getName());
        price.setText(barcodeList.get(position).getPrice());
        packet_price.setText(barcodeList.get(position).getPacket());
        listViewItem.setTag(holder);

        //convertView.setTag(holder);
       // final ViewHolder finalHolder = holder;
        final ViewHolder finalHolder = holder;

        holder.name.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("onClick: ", "::::::::::: ");
                Log.i( "____________", String.valueOf(finalHolder.name.getText().toString()));

                if (finalHolder.name.isChecked()) {

                    barcodeList.get(position).setSelected_name(true);
                    Log.i( "onClick:////////////// ", barcodeList.get(position).getSelected_name().toString());

                } else {
                    barcodeList.get(position).setSelected_name(false);
                }

            }
        });

        holder.price.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("onClick: ", "::::::::::: ");
                Log.i( "==================", String.valueOf(finalHolder.price.getText().toString()));

                if (finalHolder.price.isChecked()) {

                    barcodeList.get(position).setSelected_price(true);
                    Log.i( "onClick:hhhhhhhhhhhhh ", barcodeList.get(position).getSelected_price().toString());

                } else {
                    barcodeList.get(position).setSelected_price(false);
                }

            }
        });


        holder.packet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("onClick: ", "::::::::::: ");
                Log.i( "^^^^^^^^^^^", String.valueOf(finalHolder.packet.getText().toString()));

                if (finalHolder.packet.isChecked()) {
                    barcodeList.get(position).setSelected_packet(true);

                    Log.i( "onClick:EEEEEEEEEEEE ", barcodeList.get(position).getSelected_packet().toString());


                } else {
                    barcodeList.get(position).setSelected_packet(false);
                }

            }
        });

//        holder.name.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(finalHolder.name.isChecked()){
//                    Log.i( "getView:::::::::::::", finalHolder.name.getText().toString().trim());
//
//                    Toast.makeText(context, finalHolder.name.getText().toString(), Toast.LENGTH_SHORT).show();
//
//                    bar.setName(finalHolder.name.getText().toString());
////                    Log.i( "???????????????", bar.getName());
//                }
//            }
//        });
//
//        holder.price.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//                    if(finalHolder.price.isChecked()){
//                        Log.i( "getView:::::::::::::", finalHolder.price.getText().toString().trim());    }
//                        bar.setPrice((finalHolder.price.getText().toString().trim()));
//
//            }
//        });
//
//
//        holder.packet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(finalHolder.packet.isChecked()){
//                    Log.i( "getView:::::::::::::", finalHolder.packet.getText().toString().trim());    }
//
//                bar.setPacket((finalHolder.packet.getText().toString().trim()));
//
//            }
//        });

//        holder.price.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.i("POT", String.valueOf(position));
//                flag = 2;
//            }
//        });
//        holder.packet.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.i("Mala", String.valueOf(position));
//                flag = 3;
//            }
//        });



//        for (int i = 0; i < barcodeList.size(); i++) {
//
//
//
//            if (holder.price.isChecked()) {
//                barcodeList.get(i).setSelected_price(true);
//
//            } else {
//                barcodeList.get(i).setSelected_price(false);
//            }
//
//            if (holder.packet.isChecked()) {
//
//                barcodeList.get(i).setSelected_price(true);
//
//            } else {
//                barcodeList.get(i).setSelected_packet(false);
//            }
//        }


//            notifyDataSetChanged();
  //          Log.i("getView::////// ", name.toString());

            return listViewItem;
        }
    }



