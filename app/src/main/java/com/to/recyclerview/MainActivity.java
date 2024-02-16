package com.to.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Myadapter myadapter =new Myadapter();
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private class Myadapter extends RecyclerView.Adapter<Myadapter.myviewholder> {


        @NonNull
        @Override
        public Myadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View myview = inflater.inflate(R.layout.sample, parent, false);

            return new myviewholder(myview);
        }

        @Override
        public void onBindViewHolder(@NonNull Myadapter.myviewholder holder, int position) {
holder.textView.setText("Item position"+position);

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class myviewholder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;

            public myviewholder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textView);


            }
        }
    }


}