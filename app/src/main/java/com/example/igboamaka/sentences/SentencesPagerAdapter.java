package com.example.igboamaka.sentences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.igboamaka.numbers.ElevenToTwentyFragment;
import com.example.igboamaka.numbers.HundredsFragment;
import com.example.igboamaka.numbers.OneToTenFragment;
import com.example.igboamaka.numbers.TensFragment;

public class SentencesPagerAdapter extends FragmentPagerAdapter {


    public SentencesPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new GreetingsFragment();
            case 1:
                return new SentencesFragment();
        }
        return null;
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        if (position == 0) {
            title = "Greeting";
        }else{
            title = "Sentences";
        }
        return title;
    }
}
