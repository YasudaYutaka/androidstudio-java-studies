package com.yutaka.abas.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yutaka.abas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InscricoesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InscricoesFragment extends Fragment {

    public InscricoesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inscricoes, container, false);
    }
}