package com.yutaka.aprendaingles.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yutaka.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VogaisFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VogaisFragment extends Fragment {

    public VogaisFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vogais, container, false);
    }
}