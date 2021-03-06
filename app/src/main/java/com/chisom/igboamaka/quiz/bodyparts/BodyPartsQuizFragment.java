package com.chisom.igboamaka.quiz.bodyparts;

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
public class BodyPartsQuizFragment extends Fragment {
    private ViewPager2 mViewPager2;
    MaterialButton nextButton, prevButton;
    private NumberQuizAdapter quizAdapter;



    public BodyPartsQuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_body_parts_quiz, container, false);


            mViewPager2 = view.findViewById(R.id.bodyparts_pager);
            nextButton = view.findViewById(R.id.next_button_bodyparts);
            prevButton = view.findViewById(R.id.prev_button_bodyparts);


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


            final List<BodyPartsQuiz> bodyPartsQuiz = new ArrayList<>();

        bodyPartsQuiz.add(new BodyPartsQuiz(
                    "Question 1/6",
                    "I just \"ate\" few hours ago",
                    Color.GREEN,
                    Color.RED,
                    Color.RED,
                    Color.RED,
                    "Ọnụ",
                    "Olu",
                    "Aka",
                    "Obi"));


        bodyPartsQuiz.add(new BodyPartsQuiz(
                    "Question 2/6",
                    "I can't \"see\" clearly",
                    Color.RED,
                    Color.RED,
                    Color.RED,
                    Color.GREEN,
                    "Mbọ",
                    "Ọba ụkwụ",
                    "Iku anya",
                    "ánya"));


        bodyPartsQuiz.add(new BodyPartsQuiz(
                    "Question 3/6",
                    "I think I should \"walk\" to her house",
                    Color.RED,
                    Color.GREEN,
                    Color.RED,
                    Color.RED,
                    "Iku anya",
                    "Ụkwụ/Ọkpa",
                    "Ike",
                    "Aka"));

        bodyPartsQuiz.add(new BodyPartsQuiz(
                    "Question 4/6",
                    "I need to \"wash\" my clothes",
                    Color.RED,
                    Color.RED,
                    Color.RED,
                    Color.GREEN,
                    "Ire",
                    "Mkpịsị ụkwụ",
                    "Olu",
                    "Aka"));

        bodyPartsQuiz.add(new BodyPartsQuiz(
                    "Question 5/6",
                    "Do you mean you can't \"hear\" me?",
                    Color.RED,
                    Color.GREEN,
                    Color.RED,
                    Color.RED,
                    "Imi",
                    "Ntị",
                    "Anya",
                    "Obi"));

        bodyPartsQuiz.add(new BodyPartsQuiz(
                    "Question 6/6",
                    "I can \"perceive\" what you're cooking",
                    Color.RED,
                    Color.GREEN,
                    Color.RED,
                    Color.RED,
                    "Olu",
                    "Imi",
                    "Afọ",
                    "Ọba ụkwụ"));




            mViewPager2.setAdapter(new BodyPartsQuizAdapter(bodyPartsQuiz, getContext()));
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
                    if (position == bodyPartsQuiz.size() - 1) {
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
