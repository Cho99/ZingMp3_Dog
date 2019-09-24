package com.example.appmusicv2.Fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_disk extends Fragment {
    View view;
    CircleImageView circleImageView;
    ObjectAnimator objectAnimator;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_disk,container, false);
        circleImageView = view.findViewById(R.id.imageviewCircleDisk);
        objectAnimator = ObjectAnimator.ofFloat(circleImageView, "rotation", 0f, 360f);
        objectAnimator.setDuration(100000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.start();
        return view;
    }

    public void PlaySong(String img) {
        Picasso.get().load(img).into(circleImageView);

    }


}
