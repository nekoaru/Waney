package com.ecom.fintech.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecom.fintech.R;
import com.ecom.fintech.domain.Fintech;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FintechAdapter extends RecyclerView.Adapter<FintechAdapter.FintechViewHolder> {
    private ArrayList<Fintech> finteches;
    private Context context;
    private OnNoteClickListener onNoteClickListener;

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    public FintechAdapter(ArrayList<Fintech> finteches, Context context) {
        this.finteches = finteches;
        this.context = context;
    }

    public void setFinteches(ArrayList<Fintech> finteches) {
        this.finteches = finteches;
        notifyDataSetChanged();
    }


    interface OnNoteClickListener {
        void onNoteClick(int position);
        void onLongClick(int position);
    }
    public FintechViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fintech_item, parent, false);
        return new FintechViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FintechAdapter.FintechViewHolder holder, int position) {
        Fintech fintech = finteches.get(position);
        holder.textViewCategory.setText(fintech.getCategory());
        holder.textViewComment.setText(fintech.getComment());
        holder.textViewCash.setText(fintech.getCash());
        holder.textViewDate.setText(fintech.getDate());

    }

    @Override
    public int getItemCount() {
        return finteches.size();
    }

    class FintechViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCategory;
        private TextView textViewComment;
        private TextView textViewCash;
        private TextView textViewDate;
        public FintechViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            textViewComment = itemView.findViewById(R.id.textViewComment);
            textViewCash = itemView.findViewById(R.id.textViewCash);
            textViewDate = itemView.findViewById(R.id.textViewDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNoteClickListener != null) {
                        onNoteClickListener.onNoteClick(getAdapterPosition());
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onNoteClickListener != null) {
                        onNoteClickListener.onLongClick(getAdapterPosition());
                    }
                    return true;
                }
            });
        }
    }
}
