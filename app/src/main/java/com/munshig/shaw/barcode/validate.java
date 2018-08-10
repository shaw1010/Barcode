package com.munshig.shaw.barcode;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class validate extends AppCompatActivity {

    ListView validate_list;
    TextView textView_barcode;
    List<Barcode> display_info;
    List<Barcode> barcode;
    validate_model model_adapter = null;
    validate_model display, barcode_data;
    private ArrayAdapter<Barcode> listAdapter;
    FirebaseFirestore data;
    int ppo= 0;
    Unique_barcode bar_data=null;
    Button validate_button;
    String bar_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);
        display_info = new ArrayList<>();
        validate_list = findViewById(R.id.validate_list);
        textView_barcode = findViewById(R.id.textView_barcode);
        data = FirebaseFirestore.getInstance();
        validate_button = findViewById(R.id.validate_submit);

        Intent i = getIntent();

        barcode = (List<Barcode>) i.getSerializableExtra("Baloo");
        bar_code = barcode.get(0).getBarcode();
        textView_barcode.setText(bar_code);

        display = new validate_model(validate.this, barcode, ppo, bar_data);

        validate_list.setAdapter(display);
        //Log.i( "onItemClick:||||||||| ", "Mein yahan");


        validate_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Barcode bar = barcode.get(i);
                Log.i("onItemClick:||||||||| ", String.valueOf(i));
                model_adapter = new validate_model(validate.this, barcode, i, bar_data);
                validate_list.setAdapter(model_adapter);

            }
        });

        validate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = null;
                String price_un = null,packet=null;

                for(int i=0;i < barcode.size();i++){

                        Barcode bar= barcode.get(i);

                        if(bar.selected_name){
                            Log.i("NAMEEEEEEEEEE ", bar.Name);
                            name = bar.Name;
                        }
                        if(bar.selected_price){
                            Log.i("Priceeeeeee ", bar.Price);
                            price_un=bar.Price;

                        }
                        if(bar.selected_packet){
                            Log.i("PACKETTTTT ", bar.Packet_Price);
                            packet=bar.Packet_Price;
                        }
                    }

                    Unique_barcode bar = new Unique_barcode(name, price_un, packet);

                    data.collection("Unique").document(barcode.get(0).getBarcode()).set(bar).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(validate.this, "Successful ", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}