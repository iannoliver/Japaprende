package com.example.app_hiragana__katakana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.app_hiragana__katakana.adapter.LetraAdapter;
import com.example.app_hiragana__katakana.databinding.ActivityFormPrincipalBinding;
import com.example.app_hiragana__katakana.model.Letra;

import java.util.ArrayList;




public class activity_form_principal extends AppCompatActivity {

    private ActivityFormPrincipalBinding binding;
    private LetraAdapter letraAdapter;
    private ArrayList<Letra> letraList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerViewLetra = binding.RecyclerViewLetra;
        recyclerViewLetra.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewLetra.setHasFixedSize(true);
        letraAdapter = new LetraAdapter(letraList, this);
        recyclerViewLetra.setAdapter(letraAdapter);
        getLetra();

    }

    private void getLetra() {
        Letra letra1 = new Letra(
                "A",
                "あ",
                "n/d"
        );

        letraList.add(letra1);

        Letra letra2 = new Letra(
                "I",
                "い",
                "n/d"
        );

        letraList.add(letra2);

        Letra letra3 = new Letra(
                "U",
                "う",
                "n/d"
        );

        letraList.add(letra3);

        Letra letra4 = new Letra(
                "E",
                "え",
                "n/d"
        );

        letraList.add(letra4);

        Letra letra5 = new Letra(
                "O",
                "お",
                "n/d"
        );

        letraList.add(letra5);

        Letra letra6 = new Letra(
                "KA",
                "か",
                "n/d"
        );

        letraList.add(letra6);

        Letra letra7 = new Letra(
                "KI",
                "き",
                "n/d"
        );

        letraList.add(letra7);

        Letra letra8 = new Letra(
                "KU",
                "く",
                "n/d"
        );

        letraList.add(letra8);

        Letra letra9 = new Letra(
                "KE",
                "け",
                "n/d"
        );

        letraList.add(letra9);

        Letra letra10 = new Letra(
                "KO",
                "こ",
                "n/d"
        );

        letraList.add(letra10);

        Letra letra11 = new Letra(
                "SA",
                "さ",
                "n/d"
        );

        letraList.add(letra11);

        Letra letra12 = new Letra(
                "SHI",
                "し",
                "n/d"
        );

        letraList.add(letra12);

        Letra letra13 = new Letra(
                "SU",
                "す",
                "n/d"
        );

        letraList.add(letra13);

        Letra letra14 = new Letra(
                "SE",
                "せ",
                "n/d"
        );

        letraList.add(letra14);

        Letra letra15 = new Letra(
                "SO",
                "そ",
                "n/d"
        );

        letraList.add(letra15);

        Letra letra16 = new Letra(
                "TA",
                "た",
                "n/d"
        );

        letraList.add(letra16);

        Letra letra17 = new Letra(
                "CHI",
                "ち",
                "n/d"
        );

        letraList.add(letra17);

        Letra letra18 = new Letra(
                "TSU",
                "つ",
                "n/d"
        );

        letraList.add(letra18);

        Letra letra19 = new Letra(
                "TE",
                "て",
                "n/d"
        );

        letraList.add(letra19);

        Letra letra20 = new Letra(
                "TO",
                "と",
                "n/d"
        );

        letraList.add(letra20);

        Letra letra21 = new Letra(
                "NA",
                "な",
                "n/d"
        );

        letraList.add(letra21);

        Letra letra22 = new Letra(
                "NI",
                "に",
                "n/d"
        );

        letraList.add(letra22);

        Letra letra23 = new Letra(
                "NU",
                "ぬ",
                "n/d"
        );

        letraList.add(letra23);

        Letra letra24 = new Letra(
                "NE",
                "ね",
                "n/d"
        );

        letraList.add(letra24);

        Letra letra25 = new Letra(
                "NO",
                "の",
                "n/d"
        );

        letraList.add(letra25);

        Letra letra26 = new Letra(
                "HA",
                "は",
                "n/d"
        );

        letraList.add(letra26);

        Letra letra27 = new Letra(
                "HI",
                "ひ",
                "n/d"
        );

        letraList.add(letra27);

        Letra letra28 = new Letra(
                "FU",
                "ふ",
                "n/d"
        );

        letraList.add(letra28);

        Letra letra29 = new Letra(
                "HE",
                "へ",
                "n/d"
        );

        letraList.add(letra29);

        Letra letra30 = new Letra(
                "HO",
                "ほ",
                "n/d"
        );

        letraList.add(letra30);

        Letra letra31 = new Letra(
                "MA",
                "ま",
                "n/d"
        );

        letraList.add(letra31);

        Letra letra32 = new Letra(
                "MI",
                "み",
                "n/d"
        );

        letraList.add(letra32);

        Letra letra33 = new Letra(
                "MU",
                "む",
                "n/d"
        );

        letraList.add(letra33);

        Letra letra34 = new Letra(
                "ME",
                "め",
                "n/d"
        );

        letraList.add(letra34);

        Letra letra35 = new Letra(
                "MO",
                "も",
                "n/d"
        );

        letraList.add(letra35);

        Letra letra36 = new Letra(
                "YA",
                "や",
                "n/d"
        );

        letraList.add(letra36);

        Letra letra37 = new Letra(
                "YU",
                "ゆ",
                "n/d"
        );

        letraList.add(letra37);

        Letra letra38 = new Letra(
                "YO",
                "よ",
                "n/d"
        );

        letraList.add(letra38);

        Letra letra39 = new Letra(
                "RA",
                "ら",
                "n/d"
        );

        letraList.add(letra39);

        Letra letra40 = new Letra(
                "RI",
                "り",
                "n/d"
        );

        letraList.add(letra40);

        Letra letra41 = new Letra(
                "RU",
                "る",
                "n/d"
        );

        letraList.add(letra41);

        Letra letra42 = new Letra(
                "RE",
                "れ",
                "n/d"
        );

        letraList.add(letra42);

        Letra letra43 = new Letra(
                "RO",
                "ろ",
                "n/d"
        );

        letraList.add(letra43);

        Letra letra44 = new Letra(
                "WA",
                "わ",
                "n/d"
        );

        letraList.add(letra44);


        Letra letra45 = new Letra(
                "WO",
                "を",
                "n/d"
        );

        letraList.add(letra45);

        Letra letra46 = new Letra(
                "N",
                "ん",
                "n/d"
        );

        letraList.add(letra46);
    }
}