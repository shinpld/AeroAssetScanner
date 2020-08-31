package com.example.aeroassetscanner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    TextInputLayout asset_id, asset_description,asset_serial,asset_desc2,asset_location,
            asset_building,asset_sup,asset_room,asset_remark,asset_rack;
    Button btn_post,btn_search,btn_clear;
    Spinner spinner;


    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("AeroAsset");



        asset_description = findViewById(R.id.asset_Description);
        asset_id = findViewById(R.id.asset_Id);
        asset_serial = findViewById(R.id.asset_Serial);
        asset_desc2 = findViewById(R.id.asset_Description2);
        asset_location = findViewById(R.id.asset_Location);
        asset_building = findViewById(R.id.Building_Fl);
        asset_sup = findViewById(R.id.asset_Sup);
        asset_room = findViewById(R.id.asset_room);
        asset_remark = findViewById(R.id.asset_Remark);
        asset_rack = findViewById(R.id.asset_Rack);

        btn_post = findViewById(R.id.btn_post);
        btn_search = findViewById(R.id.btn_Search);
        btn_clear = findViewById(R.id.btn_Clear);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA} , PackageManager.PERMISSION_GRANTED);


        btn_post.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                postItem();

            }
        });
        btn_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                findItem();

            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clearForm();

            }
        });

    }
    public void ScanButton(View view){
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.initiateScan();
    }

    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof TextInputLayout) {
                ((TextInputLayout)view).getEditText().setText("");
            }

            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }

    private void clearForm(){
        clearForm((ViewGroup) findViewById(R.id.formContainer));
    }





    public void postItem(){
        if (!asset_id.getEditText().getText().toString().matches("") ){
            final String id = asset_id.getEditText().getText().toString();
            final Date currentTime = Calendar.getInstance().getTime();
            final String rem = asset_remark.getEditText().getText().toString();
            final String room = asset_room.getEditText().getText().toString();
            final String assetSup = asset_sup.getEditText().getText().toString();
            final String building = asset_building.getEditText().getText().toString();
            final String desc = asset_description.getEditText().getText().toString();
            final String desc2 = asset_desc2.getEditText().getText().toString();

            databaseReference.child(id).addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue() != null) {
                                // dataSnapshot is the "issue" node with all children with id
                                AItem contact = dataSnapshot.getValue(AItem.class);

                                contact.setRemark(rem);
                                contact.setRoom(room);
                                contact.setAsset_Sup(assetSup);
                                contact.setBuilding_Fl(building);
                                contact.setAsset_description(desc);
                                contact.setDescription2(desc2);

                                contact.setUpdated(currentTime.toString());




                                databaseReference.child(id).setValue(contact).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        createResultAlert("Result", "Item Updated");
                                    }
                                })
                                ;


                            } else {

                                createResultAlert("Result", "Invalid Asset id");

                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

            clearForm((ViewGroup) findViewById(R.id.formContainer));
       }

    }
    private void createResultAlert(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void findItem(){
        String s = asset_id.getEditText().getText().toString();
        findItem(s);
    }


    public void findItem(String searchText){
        if(!asset_id.getEditText().getText().toString().matches("")) {
            databaseReference.child(searchText).addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.getValue() != null) {
                                // dataSnapshot is the "issue" node with all children with id 0
                                AItem contact = dataSnapshot.getValue(AItem.class);
                                asset_description.getEditText().setText(contact.Asset_description);
                                asset_desc2.getEditText().setText(contact.Description2);
                                asset_serial.getEditText().setText(contact.Serial_number);
                                asset_location.getEditText().setText(contact.Location);
                                asset_building.getEditText().setText(contact.Building_Fl);
                                asset_room.getEditText().setText(contact.Room);
                                asset_sup.getEditText().setText(contact.Asset_Sup);
                                asset_rack.getEditText().setText(contact.Rack);
                                asset_remark.getEditText().setText(contact.Remark);


                                createResultAlert("Result", "Item found");
                            } else {
                                clearForm();
                                createResultAlert("Result", "Item not found");

                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        } else {
            clearForm();
        }

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(intentResult != null){
            if(intentResult.getContents() == null){
                asset_id.getEditText().setText("Cancelled");
            }else{
                String res = intentResult.getContents();
                asset_id.getEditText().setText(res);

                findItem(res);

                Toast.makeText(MainActivity.this, "Scanned", Toast.LENGTH_SHORT).show();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}