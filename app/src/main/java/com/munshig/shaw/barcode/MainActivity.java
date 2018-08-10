package com.munshig.shaw.barcode;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ListView barcode_list;
    FirebaseFirestore db;
    public List<Barcode> barcodelist, barcode_unique_list;
    List<String> show_list;
    List<String> barcode_unique;
    Barcode barcode, unique_barcode;
    String bar_code;String name;String price;String packet_price;
    int i=0,j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barcode_list = findViewById(R.id.barcode_list);
        db = FirebaseFirestore.getInstance();
        barcodelist = new ArrayList<Barcode>();
        show_list = new ArrayList<>();
        barcode_unique_list = new ArrayList<>();

        // Reading Data
        db.collection("barcode").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (final DocumentSnapshot document : task.getResult()) {
                        db.collection("barcode").document(document.getId()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @TargetApi(Build.VERSION_CODES.N)
                        @Override
                             public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                   if (task.getResult().exists()) {
                                       Log.i(":::", "onComplete: ");



                                       barcode = new Barcode();
                                       bar_code = task.getResult().getData().get("Barcode").toString();
                                       name = task.getResult().getData().get("Name").toString();
                                       price = task.getResult().getData().get("Price").toString();
                                       packet_price = task.getResult().getData().get("Packet Price").toString();
                                    // barcode = new Barcode(bar_code,name,price,packet_price);
                                       barcode.setBarcode(bar_code);barcode.setName(name);barcode.setPrice(price);barcode.setPacket(packet_price);
                                      // Log.i("barcode object info", barcode.getName());
                                       barcodelist.add(barcode);
                                      // Log.i("::::///Bhaiahan hai", barcodelist.get(0).Barcode);
                                       show_list.add(bar_code);
                                   }
 //Store distinct barcodes
                                       //show_list = barcodelist.stream().distinct().collect(Collectors.toList());
                                        barcode_unique = show_list;
                                        for(int i=0;i<show_list.size();i++){

                                            for(int j=0; j<show_list.size();j++){

                                                String k = barcode_unique.get(i);
                                                if(j!=i){
                                                    if(k.equals(barcode_unique.get(j)))
                                                    {
                                                        barcode_unique.remove(j);
                                                    }    }      }      }
                                       Model adapter = new Model(MainActivity.this,barcode_unique);
                                       barcode_list.setAdapter(adapter); }

                        }}); }} }}); //barcode_objects.add(barcode);

      //  Log.i("::::::::::::::::///////", barcodelist.get(1).getBarcode());


        barcode_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String code = barcode_unique.get(position);
                barcode_unique_list.clear();
//                Log.i(":::::::::::", code.toString());
//                // Log.i(":::::::::::", barcodelist.size);

                for (int i = 0; i < barcodelist.size(); i++) {

                    if ((code.trim()).equals(barcodelist.get(i).getBarcode())) {
                        barcode_unique_list.add(barcodelist.get(i));

                    }
                }
                //Log.i("?????//////", barcode_unique_list.get(0).getName());


                Intent intent = new Intent(MainActivity.this,validate.class);
                intent.putExtra("Baloo",  (Serializable) barcode_unique_list);
                startActivity(intent);
            }
        } );
    }
}

