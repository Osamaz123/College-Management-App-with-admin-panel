package com.example.zhcetapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhcetapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

private ViewPager viewPager;
private  BranchAdapter adapter;
private List<BranchModel> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);
//       list = new ArrayList<>();
//       list.add(new BranchModel(R.drawable.ic_computer_24,"Computer Engineering", "The Department of Computer Engineering was "));
//        list.add(new BranchModel(R.drawable.ic_settings_24,"Mechanical Engineering", "The Department of Mechanical Engineeh a student strength of about 700"));
//
//        adapter = new BranchAdapter(getContext(),list);
//        viewPager = view.findViewById(R.id.viewPager);
//        viewPager.setAdapter(adapter);
//
//        ImageView imageView = view.findViewById(R.id.collegeImage);
//        Glide.with(getContext())
//  .load("https://firebasestorage.googleapis.com/v0/b/college-management-app-c31a2.appspot.com/o/zhcet2.jpg?alt=media&token=07117d23-faab-4a50-b3f4-17c4b17b624e")
//                .into(imageView);

        return view;
    }
}