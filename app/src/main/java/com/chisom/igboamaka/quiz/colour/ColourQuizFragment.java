package com.chisom.igboamaka.quiz.colour;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chisom.igboamaka.R;
import com.chisom.igboamaka.quiz.QuizFragment;
import com.chisom.igboamaka.quiz.numbers.NumberQuizAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@SuppressWarnings("ALL")
public class ColourQuizFragment extends Fragment {
    private ViewPager2 mViewPager2;
    MaterialButton nextButton, prevButton;
    private NumberQuizAdapter quizAdapter;



    public ColourQuizFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_colour_quiz, container, false);


        mViewPager2 = view.findViewById(R.id.colour_pager);
        nextButton = view.findViewById(R.id.next_button_colour);
        prevButton = view.findViewById(R.id.prev_button_colour);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager2.setCurrentItem(getItem(+1), true);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager2.setCurrentItem(getItem(-1), true);
            }
        });


        final List<ColourQuiz> colourQuiz = new ArrayList<>();

        colourQuiz.add(new ColourQuiz(
                "Question 1/15",
                "I have five fingers",
                Color.GREEN,
                Color.RED,
                Color.RED,
                Color.RED,

                Color.RED,
                "ọbara ọbara",
                "oji",
                "oroma",
                "Olaedo"));


        colourQuiz.add(new ColourQuiz(
                "Question 2/5",
                "My neighbour just won a thousand dollars",
                Color.RED,
                Color.RED,
                Color.RED,
                Color.GREEN,

                Color.GREEN,
                "ododo",
                "ọcha",
                "Olaedo",
                "ndụ-ndụ"));


        colourQuiz.add(new ColourQuiz(
                "Question 3/5",
                "I have four siblings",
                Color.RED,
                Color.GREEN,
                Color.RED,
                Color.RED,

                Color.YELLOW,
                "uri",
                "edo",
                "asato",
                "Olaocha"));

        colourQuiz.add(new ColourQuiz(
                "Question 4/5",
                "I bought fourteen bags of rice",
                Color.RED,
                Color.RED,
                Color.RED,
                Color.GREEN,

                Color.BLUE,
                "oji",
                "oroma",
                "edo",
                "amaloji"));

        colourQuiz.add(new ColourQuiz(
                "Question 5/5",
                "I just took two gallons \nof palm wine",
                Color.RED,
                Color.GREEN,
                Color.RED,
                Color.RED,

                Color.BLACK,
                "amaloji",
                "oji",
                "Uhie ocha",
                "Olaedo"));




        mViewPager2.setAdapter(new ColourQuizAdapter(colourQuiz, getContext()));
        mViewPager2.setClipToPadding(false);
        mViewPager2.setClipChildren(false);
        mViewPager2.setOffscreenPageLimit(3);
        mViewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        mViewPager2.setPageTransformer(compositePageTransformer);
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == colourQuiz.size() - 1) {
                    nextButton.setBackgroundColor(Color.parseColor("#FF9249"));
                    nextButton.setText("FINISH");
                    prevButton.setVisibility(View.INVISIBLE);
                    nextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Fragment fragment = new QuizFragment();
                            FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.fragment_container, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });
                }

            }
        });


        return view;
    }

    private int getItem(int i) {
        return mViewPager2.getCurrentItem() + i;
    }

}
