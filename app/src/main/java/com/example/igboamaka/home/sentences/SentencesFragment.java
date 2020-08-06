package com.example.igboamaka.home.sentences;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.igboamaka.R;

import java.util.ArrayList;
import java.util.List;


public class SentencesFragment extends Fragment {
    List<Sentences> sentences;
    private SentenceCategoryAdapter.RecyclerViewClickListener listener;


    public SentencesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sentences, container, false);

        sentences = new ArrayList<>();

        sentences.add(new Sentences("What is your name?", "Gịnị bu aha gị?", Color.parseColor("#B13254"),R.raw.number_one));
        sentences.add(new Sentences("My name is Chisom", "Aha mu bu Chisom",Color.parseColor("#FF5449"),R.raw.number_two));
        sentences.add(new Sentences("How are they doing?", "Kedu ka ha melu?",Color.parseColor("#FF9249"),R.raw.number_one));

        sentences.add(new Sentences("They are doing fine", "Ha dị mma",Color.parseColor("#FF7349"),R.raw.number_one));
        sentences.add(new Sentences("Who is this?", "Kedu onye bụ nke a? ",Color.parseColor("#471437"),R.raw.number_one));
        sentences.add(new Sentences("I don’t know", "Amaghị m", Color.parseColor("#B13254"),R.raw.number_one));

        sentences.add(new Sentences("Do you speak Igbo", "I na-asu Igbo", Color.parseColor("#B13254"),R.raw.number_one));
        sentences.add(new Sentences("What is she doing?", "Kedu ka o na-eme?",Color.parseColor("#FF5449"),R.raw.number_one));
        sentences.add(new Sentences("Where are you from?", "Ị bu onye ebe?",Color.parseColor("#FF9249"),R.raw.number_one));

        sentences.add(new Sentences("I am from Anambra", "A bu m onye Anambra",Color.parseColor("#FF7349"),R.raw.number_one));
        sentences.add(new Sentences("Who is this?", "Kedu onye bụ nke a? ",Color.parseColor("#471437"),R.raw.number_one));
        sentences.add(new Sentences("I don’t know", "Amaghị m", Color.parseColor("#B13254"),R.raw.number_one));

        sentences.add(new Sentences("I remember", "Echetara m",Color.parseColor("#B13254"),R.raw.number_one));
        sentences.add(new Sentences("He/She is a nice person", "Ọ bụ ezigbo mmadụ",Color.parseColor("#FF5449"),R.raw.number_one));
        sentences.add(new Sentences("You are pretty", "Ị mara mma nwanyị", Color.parseColor("#FF9249"),R.raw.number_one));
        sentences.add(new Sentences("My strength is finished", "ike gwuru",Color.parseColor("#FF5449"),R.raw.number_one));

        listener = new SentenceCategoryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), sentences.get(position).getAudio());
                mediaPlayer.start();
            }
        };

        RecyclerView recyclerView = view.findViewById(R.id.sentence_recycler_view);
        SentenceCategoryAdapter adapter = new SentenceCategoryAdapter(getContext(), sentences, listener);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}