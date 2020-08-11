package com.yutaka.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.yutaka.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageButtonUm, imageButtonDois, imageButtonTres,
                        imageButtonQuatro, imageButtonCinco, imageButtonSeis;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_numeros, container, false);

        imageButtonUm       = view.findViewById(R.id.imageButtonUm);
        imageButtonDois     = view.findViewById(R.id.imageButtonDois);
        imageButtonTres     = view.findViewById(R.id.imageButtonTres);
        imageButtonQuatro   = view.findViewById(R.id.imageButtonQuatro);
        imageButtonCinco    = view.findViewById(R.id.imageButtonCinco);
        imageButtonSeis     = view.findViewById(R.id.imageButtonSeis);

        imageButtonUm.setOnClickListener(this);
        imageButtonDois.setOnClickListener(this);
        imageButtonTres.setOnClickListener(this);
        imageButtonQuatro.setOnClickListener(this);
        imageButtonCinco.setOnClickListener(this);
        imageButtonSeis.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageButtonUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                reproduzirSom();
                break;
            case R.id.imageButtonDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                reproduzirSom();
                break;
            case R.id.imageButtonTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                reproduzirSom();
                break;
            case R.id.imageButtonQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                reproduzirSom();
                break;
            case R.id.imageButtonCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                reproduzirSom();
                break;
            case R.id.imageButtonSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                reproduzirSom();
                break;
        }

    }

    public void reproduzirSom() {

        if(mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    
}