package com.yutaka.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yutaka.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SobreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_sobre, container, false);

        String descricao = "A ATM Consultoria tem como missão apoiar organizações " +
                "que desejam alcançar o sucesso através da excelência e da busca pela qualidade.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@yutakayasuda.com", "Envie um e-mail")
                .addWebsite("https://www.google.com.br", "Acesse nosso site")

                .addGroup("Redes sociais")
                .addFacebook("RafaelRyy", "Facebook")
                .addInstagram("rafael.yasuda", "Instagram")
                .addTwitter("RafaelRyy", "Twitter")
                .addYoutube("RafaelRyy", "Youtube")
                .addGitHub("YutakaYasuda", "GitHub")
                .addPlayStore("com.whatsapp", "Download APP")

                .addItem(versao)

                .create();

    }
}