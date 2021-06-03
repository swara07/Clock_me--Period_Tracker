package com.example.periodtracker.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.periodtracker.R;
import com.example.periodtracker.remedi1;
import com.example.periodtracker.remedi2;
import com.example.periodtracker.remedi3;
import com.example.periodtracker.ui.Settings.SettingsFragment;

public class SlideshowFragment extends Fragment {
    CardView card1,card2,card3;

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        card1=(CardView)root.findViewById(R.id.colormatch);
        card2=(CardView)root.findViewById(R.id.findmatch);
        card3=(CardView)root.findViewById(R.id.findmatch2);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent= new Intent(new Intent(SlideshowFragment.this.getActivity(), remedi1.class));
                startActivity(homeIntent);
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent= new Intent(new Intent(SlideshowFragment.this.getActivity(), remedi2.class));
                startActivity(homeIntent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent= new Intent(new Intent(SlideshowFragment.this.getActivity(), remedi3.class));
                startActivity(homeIntent);
            }
        });

        return root;
    }
}