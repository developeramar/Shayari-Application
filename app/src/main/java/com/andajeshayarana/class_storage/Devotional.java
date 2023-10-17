package com.andajeshayarana.class_storage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.andajeshayarana.R;
import com.andajeshayarana.Shayari_Documentation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Devotional extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_previous,btn_next,btn_copy,btn_share;
    TextView shayari_text,count_txt;

    List<String> shayari_list;
    DatabaseReference databaseReference;
    Shayari_Documentation shayri_documentation;
    int position=1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_display);




        shayari_text=findViewById(R.id.shayari_text);
        btn_previous=findViewById(R.id.btn_previous);
        btn_next=findViewById(R.id.btn_next);
        btn_share=findViewById(R.id.btn_share);
        btn_copy=findViewById(R.id.btn_copy);
        count_txt=findViewById(R.id.count_txt);

        btn_previous.setOnClickListener(this);
        btn_copy.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_next.setOnClickListener(this);





        databaseReference= FirebaseDatabase.getInstance().getReference("Devotional");
        shayari_list=new ArrayList<>();
        shayri_documentation=new Shayari_Documentation();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds: snapshot.getChildren()){

                    shayri_documentation=ds.getValue(Shayari_Documentation.class);
                    if (shayri_documentation != null) {
                        shayari_list.add(shayri_documentation.getS());
                    }


                }

                shayari_text.setText(shayari_list.get(position));
                count_txt.setText(position + "/"+shayari_list.size());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getApplicationContext(),"error occurred", Toast.LENGTH_SHORT).show();

            }
        });




    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_next:

                next();
                break;

            case R.id.btn_previous:

                previous();
                break;

            case R.id.btn_copy:

                copy();
                break;

            case R.id.btn_share:

                share();
                break;



        }


    }

    private void previous(){

        if (position>1){

            position=(position-1)%shayari_list.size();
            shayari_text.setText(shayari_list.get(position-1));
            count_txt.setText(position +"/" +shayari_list.size());
        }
    }

    private void next() {
        if (position < shayari_list.size()) {
            position = (position + 1);
            shayari_text.setText(shayari_list.get(position - 1));
            count_txt.setText(position + "/" + shayari_list.size());
        }
    }

    private void copy(){

        ClipboardManager clipboardManager= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("text",shayari_text.getText());
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(),"text copied",Toast.LENGTH_SHORT).show();

    }

    private void share(){

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,shayari_text.getText());
        startActivity(Intent.createChooser(intent,"share by"));



    }

}
