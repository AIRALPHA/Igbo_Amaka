package com.chisom.igboamaka.home.sentences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.chisom.igboamaka.R;
import com.google.android.material.tabs.TabLayout;

public class SentencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentences);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Simple Sentences");

        toolbar.setNavigationIcon(R.drawable.ic_baseline_keyboard_backspace_24);

        setSupportActionBar(toolbar);

        SentencesPagerAdapter sentencesPagerAdapter = new SentencesPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager =  findViewById(R.id.sentences_pager);
        viewPager.setAdapter(sentencesPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}