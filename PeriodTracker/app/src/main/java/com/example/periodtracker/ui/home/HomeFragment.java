package com.example.periodtracker.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.periodtracker.Cal;
import com.example.periodtracker.R;
import com.example.periodtracker.RegisterActivity;
import com.example.periodtracker.SessionManagement;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button cal=root.findViewById(R.id.cal);
        Button logout=root.findViewById(R.id.logout);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(HomeFragment.this.getActivity(), Cal.class);
                startActivity(in);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionManagement  ss=new SessionManagement(HomeFragment.this.getActivity());
                ss.removeSession();
                Intent in=new Intent(HomeFragment.this.getActivity(), RegisterActivity.class);
                startActivity(in);
            }
        });

        return root;


    }
}