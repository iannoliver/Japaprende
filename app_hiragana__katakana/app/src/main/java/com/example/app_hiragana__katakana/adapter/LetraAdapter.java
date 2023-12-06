package com.example.app_hiragana__katakana.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_hiragana__katakana.databinding.LetraItemBinding;
import com.example.app_hiragana__katakana.model.Letra;

import java.util.ArrayList;

public class LetraAdapter extends RecyclerView.Adapter<LetraAdapter.LetraViewHolder> {

    private final ArrayList<Letra> letraList;
    private final Context context;

    public LetraAdapter(ArrayList<Letra> letraList, Context context) {
        this.letraList = letraList;
        this.context = context;
    }

    @NonNull
    @Override
    public LetraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LetraItemBinding listItem;
        listItem = LetraItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new LetraViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull LetraViewHolder holder, int position) {
        holder.binding.letraHiragana.setText(letraList.get(position).getHiragana_letra());
        holder.binding.letraPtBr.setText(letraList.get(position).getPt_br_letra());

    }

    @Override
    public int getItemCount() {
        return letraList.size();
    }

    public static class LetraViewHolder extends RecyclerView.ViewHolder{

        LetraItemBinding binding;

        public LetraViewHolder(LetraItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
