package com.mubashar.generalmotorcodingchallenge.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.mubashar.generalmotorcodingchallenge.R;
import com.mubashar.generalmotorcodingchallenge.databinding.ItemCommitBinding;
import com.mubashar.generalmotorcodingchallenge.model.CommitResponse;

import java.util.List;

import javax.inject.Inject;

public class CommitAdapter extends RecyclerView.Adapter<CommitAdapter.CommitViewHolder> {

    private List<CommitResponse> commitResponses;

    @Inject
    public CommitAdapter() {
        // constructor
    }

    @NonNull
    @Override
    public CommitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CommitViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.item_commit, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommitViewHolder commitViewHolder, int i) {
        commitViewHolder.itemCommitBinding.setCommitResponse(commitResponses.get(i));
    }

    @Override
    public int getItemCount() {
        if (commitResponses != null) {
            return commitResponses.size();
        } else {
            return 0;
        }
    }

    public void setCommitResponses(List<CommitResponse> commitResponses) {
        this.commitResponses = commitResponses;
        notifyDataSetChanged();
    }

     static class CommitViewHolder extends RecyclerView.ViewHolder {
        private final ItemCommitBinding itemCommitBinding;
        public CommitViewHolder(@NonNull ItemCommitBinding binding) {
            super(binding.getRoot());
            itemCommitBinding = binding;
            itemCommitBinding.executePendingBindings();
        }
    }
}