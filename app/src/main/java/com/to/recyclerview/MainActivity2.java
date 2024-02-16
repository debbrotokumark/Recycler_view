package com.to.recyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<HashMap<String, String>> arrayList;
    HashMap<String, String> hashMap;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Myadapter myadapter = new Myadapter();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));

        arrayList = new ArrayList<>();
        hashMap = new HashMap<>();
        hashMap.put("videoid", "701a7hcD2Xg");
        hashMap.put("title", "KAHANI SUNO");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("videoid", "fWT81vH3Lkg");
        hashMap.put("title", "Pee Loon - Mohit Chauhan");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("videoid", "ZZbvLaHyIyw");
        hashMap.put("title", "Pee Lon Slow + Reverb");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("videoid", "iJT66B_qhRM");
        hashMap.put("title", "Saware (Slowed + Reverb)");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("videoid", "fXalXuLJGJY");
        hashMap.put("title", "Ei Obelay | (Lyrics) | এই অবেলায় ");
        arrayList.add(hashMap);


    }

    private class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> {


        @NonNull
        @Override
        public Myadapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.sample, parent, false);
            return new Myviewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Myadapter.Myviewholder holder, int position) {
            hashMap = arrayList.get(position);
            String title = hashMap.get("title");

            String videoid = hashMap.get("videoid");
            String imageid = "https://img.youtube.com/vi/" + videoid + "/0.jpg";
            holder.textView.setText(title);
            Picasso.get()
                    .load(imageid)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imageView);

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class Myviewholder extends RecyclerView.ViewHolder {
            TextView textView;
            ImageView imageView;

            public Myviewholder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView);
                imageView = itemView.findViewById(R.id.imageView);


            }
        }
    }


}