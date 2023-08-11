package com.example.zhcetapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zhcetapp.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.animation.type.SlideAnimation;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment {

private SliderView sliderView;
private ImageView map;
private  int[] images;
private  String[] text;
private SliderAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = view.findViewById(R.id.slider);
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.FILL);
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setScrollTimeInSec(1);
        images = new int[]{R.drawable.zhcet_image, R.drawable.zhcet2, R.drawable.zhcet3, R.drawable.zhcet4};
        text = new String[]{"1/4","2/4","3/4","4/4"};
        adapter = new SliderAdapter(images,text);
        sliderView.setSliderAdapter(adapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.SLIDE);
        sliderView.startAutoCycle();



        map = view.findViewById(R.id.map);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Zakir Hussain College of Engineering and Technology,AMU,Aligarh");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }


}