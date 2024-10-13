package com.example.contactapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arr = new ArrayList<>();
    RecyclerContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.contact);
        FloatingActionButton btnOpenDialog = findViewById(R.id.btnOpenDialog);

        // Add Contact Logic
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name ="", number="";

                        if(!edtName.getText().toString().isEmpty()) {
                            name = edtName.getText().toString();
                        } else{
                            Toast.makeText(MainActivity.this, "Please Enter the Name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtNumber.getText().toString().isEmpty()){
                            number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter the Number", Toast.LENGTH_SHORT).show();
                        }


                        arr.add(new ContactModel(R.drawable.user ,name, number));
                        adapter.notifyItemInserted(arr.size() - 1);
                        recyclerView.scrollToPosition(arr.size() - 1);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arr.add(new ContactModel(R.drawable.user,"Dipesh", "6260646298"));
        arr.add(new ContactModel(R.drawable.user,"Royal", "9870646298"));
        arr.add(new ContactModel(R.drawable.user,"Pass", "2340646298"));
        arr.add(new ContactModel(R.drawable.user,"Bgmi", "53260646298"));
        arr.add(new ContactModel(R.drawable.user,"Pubg", "56260646298"));
        arr.add(new ContactModel(R.drawable.user,"TrueCaller", "9130646298"));
        arr.add(new ContactModel(R.drawable.user,"A", "4320646298"));
        arr.add(new ContactModel(R.drawable.user,"B", "1340646298"));
        arr.add(new ContactModel(R.drawable.user,"C", "6320646298"));
        arr.add(new ContactModel(R.drawable.user,"D", "1230646298"));
        arr.add(new ContactModel(R.drawable.user,"E", "6430646298"));
        arr.add(new ContactModel(R.drawable.user,"F", "2340646298"));
        arr.add(new ContactModel(R.drawable.user,"G", "3550646298"));
        arr.add(new ContactModel(R.drawable.user,"H", "2220646298"));
        arr.add(new ContactModel(R.drawable.user,"I", "2220646298"));
        arr.add(new ContactModel(R.drawable.user,"J", "6530646298"));
        arr.add(new ContactModel(R.drawable.user,"Dipesh", "0960646298"));

        adapter = new RecyclerContactAdapter(this, arr);
        recyclerView.setAdapter(adapter);

    }
}