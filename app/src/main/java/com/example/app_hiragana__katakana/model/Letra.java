package com.example.app_hiragana__katakana.model;

public class Letra {
    String pt_br_letra;
    String hiragana_letra;
    String katakana_letra;

    public Letra(String pt_br_letra, String hiragana_letra, String katakana_letra) {
        this.pt_br_letra = pt_br_letra;
        this.hiragana_letra = hiragana_letra;
        this.katakana_letra = katakana_letra;
    }

    public String getPt_br_letra() {
        return pt_br_letra;
    }

    public void setPt_br_letra(String pt_br_letra) {
        this.pt_br_letra = pt_br_letra;
    }

    public String getHiragana_letra() {
        return hiragana_letra;
    }

    public void setHiragana_letra(String hiragana_letra) {
        this.hiragana_letra = hiragana_letra;
    }

    public String getKatakana_letra() {
        return katakana_letra;
    }

    public void setKatakana_letra(String katakana_letra) {
        this.katakana_letra = katakana_letra;
    }
}
