
package com.example.igboamaka.home.bodyparts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.igboamaka.R;
import com.example.igboamaka.home.household.HouseHold;
import com.example.igboamaka.home.household.HouseholdCategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class BodyPartsActivity extends AppCompatActivity {

    List<BodyParts> bodyParts;
    private BodyPartAdapter.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Body Parts");

        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);

        setSupportActionBar(toolbar);


        bodyParts = new ArrayList<>();
        bodyParts.add(new BodyParts("Ear", "Ntị", Color.parseColor("#B13254"), R.raw.number_two));
        bodyParts.add(new BodyParts("Eye", "Anya",Color.parseColor("#FF5449"), R.raw.number_two));
        bodyParts.add(new BodyParts("Face", "Ihu",Color.parseColor("#FF9249"), R.raw.number_two));

        bodyParts.add(new BodyParts("Nose", "Imi",Color.parseColor("#FF7349"), R.raw.number_two));
        bodyParts.add(new BodyParts("Teeth", "Eze",Color.parseColor("#471437"), R.raw.number_two));
        bodyParts.add(new BodyParts("Mouth", "Ọnụ",Color.parseColor("#B13254"), R.raw.number_two));

        bodyParts.add(new BodyParts("Tongue", "Ire",Color.parseColor("#B13254"), R.raw.number_two));
        bodyParts.add(new BodyParts("Neck", "Olu",Color.parseColor("#FF5449"), R.raw.number_two));
        bodyParts.add(new BodyParts("Finger", "Mkpịsị aka",Color.parseColor("#FF9249"), R.raw.number_two));

        bodyParts.add(new BodyParts("Toe", "Mkpịsị ụkwụ",Color.parseColor("#FF7349"), R.raw.number_two));
        bodyParts.add(new BodyParts("Foot", "Ụkwụ/Ọkpa",Color.parseColor("#471437"), R.raw.number_two));



        bodyParts.add(new BodyParts("Hand", "Aka", Color.parseColor("#B13254"), R.raw.number_two));
        bodyParts.add(new BodyParts("Arm", "Ogwe aka",Color.parseColor("#FF5449"), R.raw.number_two));
        bodyParts.add(new BodyParts("Hair", "Ntutu isi",Color.parseColor("#FF9249"), R.raw.number_two));

        bodyParts.add(new BodyParts("Head", "Isi",Color.parseColor("#FF7349"), R.raw.number_two));
        bodyParts.add(new BodyParts("Chin", "Agba",Color.parseColor("#471437"), R.raw.number_two));
        bodyParts.add(new BodyParts("Shoulder", "Ubu",Color.parseColor("#B13254"), R.raw.number_two));

        bodyParts.add(new BodyParts("Chest", "Obi",Color.parseColor("#B13254"), R.raw.number_two));
        bodyParts.add(new BodyParts("Stomach", "Afọ",Color.parseColor("#FF5449"), R.raw.number_two));


        bodyParts.add(new BodyParts("Buttocks", "Ike",Color.parseColor("#B13254"), R.raw.number_two));

        bodyParts.add(new BodyParts("Elbow", "Ikpere aka",Color.parseColor("#B13254"), R.raw.number_two));
        bodyParts.add(new BodyParts("Heel", "Ọba ụkwụ",Color.parseColor("#FF5449"), R.raw.number_two));
        bodyParts.add(new BodyParts("Nail", "Mbọ",Color.parseColor("#FF9249"), R.raw.number_two));

        bodyParts.add(new BodyParts("EyeBrows", "Iku anya",Color.parseColor("#FF7349"), R.raw.number_two));
        bodyParts.add(new BodyParts("EyeLids", "Igbirigbe anya",Color.parseColor("#471437"), R.raw.number_two));






        listener = new BodyPartAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), bodyParts.get(position).getAudio());
                mediaPlayer.start();
            }
        };

        RecyclerView recyclerView = findViewById(R.id.bodyparts_recycler_view);
        BodyPartAdapter adapter = new BodyPartAdapter(BodyPartsActivity.this, bodyParts,listener);

        recyclerView.setLayoutManager(new GridLayoutManager(BodyPartsActivity.this, 2));
        recyclerView.setAdapter(adapter);



    }
}