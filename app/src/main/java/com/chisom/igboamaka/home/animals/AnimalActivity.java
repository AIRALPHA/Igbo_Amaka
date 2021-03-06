package com.chisom.igboamaka.home.animals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.chisom.igboamaka.R;

import java.util.ArrayList;
import java.util.List;

public class AnimalActivity extends AppCompatActivity {
    List<Animals> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Animals");

        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);

        setSupportActionBar(toolbar);

        animals = new ArrayList<>();

        animals.add(new Animals("Dog", "nkịta", R.drawable.dog_image,Color.parseColor("#B13254"), R.raw.dog));
        animals.add(new Animals("Cat", "pusi/ nwologbo", R.drawable.cat_image,Color.parseColor("#FF5449"), R.raw.cat));
        animals.add(new Animals("Monkey", "enwe", R.drawable.monkey_image,Color.parseColor("#FF9249"), R.raw.monkey));

        animals.add(new Animals("Goat", "mkpi", R.drawable.goat_image,Color.parseColor("#FF7349"), R.raw.goat));
        animals.add(new Animals("Chicken", "ọkụkọ", R.drawable.chicken_image,Color.parseColor("#471437"), R.raw.chicken));
        animals.add(new Animals("Squirrel", "Osa", R.drawable.squirrel,Color.parseColor("#B13254"), R.raw.squirrel));

        animals.add(new Animals("Cow", "Ehi", R.drawable.cow_image,Color.parseColor("#FF9249"), R.raw.cow));
        animals.add(new Animals("Bird", "Nnụnụ", R.drawable.bird_image,Color.parseColor("#FF5449"), R.raw.bird));
        animals.add(new Animals("Snake", "Agwo", R.drawable.snake_image,Color.parseColor("#FF9249"), R.raw.snake));

        AnimalAdapter.RecyclerViewClickListener listener = new AnimalAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), animals.get(position).getAudio());
                mediaPlayer.start();
            }
        };



        RecyclerView recyclerView = findViewById(R.id.animal_recycler_view);
        AnimalAdapter adapter = new AnimalAdapter(AnimalActivity.this, animals, listener);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}