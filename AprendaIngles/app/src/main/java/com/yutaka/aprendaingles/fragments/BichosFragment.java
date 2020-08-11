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
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageButtonCao, imageButtonGato, imageButtonLeao,
                        imageButtonMacaco, imageButtonOvelha, imageButtonVaca;
    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        imageButtonCao      = view.findViewById(R.id.imageButtonCao);
        imageButtonGato     = view.findViewById(R.id.imageButtonGato);
        imageButtonLeao     = view.findViewById(R.id.imageButtonLeao);
        imageButtonMacaco   = view.findViewById(R.id.imageButtonMacaco);
        imageButtonOvelha   = view.findViewById(R.id.imageButtonOvelha);
        imageButtonVaca     = view.findViewById(R.id.imageButtonVaca);

        // Aplica eventos de click
        imageButtonCao.setOnClickListener(this);
        imageButtonGato.setOnClickListener(this);
        imageButtonLeao.setOnClickListener(this);
        imageButtonMacaco.setOnClickListener(this);
        imageButtonOvelha.setOnClickListener(this);
        imageButtonVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageButtonCao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                reproduzirSom();
                break;
            case R.id.imageButtonGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                reproduzirSom();
                break;
            case R.id.imageButtonLeao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                reproduzirSom();
                break;
            case R.id.imageButtonMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                reproduzirSom();
                break;
            case R.id.imageButtonOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                reproduzirSom();
                break;
            case R.id.imageButtonVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
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