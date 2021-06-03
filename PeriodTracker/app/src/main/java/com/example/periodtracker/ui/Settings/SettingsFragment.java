package com.example.periodtracker.ui.Settings;

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

import com.example.periodtracker.MainActivity;
import com.example.periodtracker.R;
import com.example.periodtracker.navBar;
import com.example.periodtracker.remedi1;
import com.example.periodtracker.remedi2;
import com.example.periodtracker.remedi3;

public class SettingsFragment extends Fragment {
    CardView card1,card2,card3;


    private SettingsViewModel settingsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_settings, container, false);




        return root;
    }
}
