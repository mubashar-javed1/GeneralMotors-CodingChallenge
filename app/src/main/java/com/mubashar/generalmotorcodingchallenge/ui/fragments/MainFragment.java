package com.mubashar.generalmotorcodingchallenge.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mubashar.generalmotorcodingchallenge.databinding.FragmentMainBinding;
import com.mubashar.generalmotorcodingchallenge.network.ApiResponse;
import com.mubashar.generalmotorcodingchallenge.network.Status;
import com.mubashar.generalmotorcodingchallenge.ui.activities.MainActivity;
import com.mubashar.generalmotorcodingchallenge.ui.adapter.CommitAdapter;
import com.mubashar.generalmotorcodingchallenge.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainFragment extends Fragment {
    @Inject
    MainViewModel mainViewModel;
    FragmentMainBinding binding;
    @Inject
    CommitAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() != null)
            ((MainActivity)getActivity()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.rvCommits.setAdapter(adapter);
        binding.tvRefresh.setOnClickListener(v -> getAllCommits());
        mainViewModel.getResponseLiveData().observe(getViewLifecycleOwner(), this::consumeResponse);
        getAllCommits();
    }

    private void getAllCommits() {
        mainViewModel.getAllCommits();
    }


    private void consumeResponse(ApiResponse response) {
        updateViewsVisibility(response.status);
        switch (response.status) {
            case SUCCESS:
                adapter.setCommitResponses(response.data);
                break;
            case ERROR:
                if (response.error != null)
                    binding.tvError.setText(response.error.getMessage());
                break;
            default:
        }
    }

    private void updateViewsVisibility(Status status) {
        binding.progressBar.setVisibility(status == Status.LOADING ? View.VISIBLE : View.GONE);
        binding.rvCommits.setVisibility(status == Status.SUCCESS ? View.VISIBLE : View.GONE);
        binding.tvError.setVisibility(status == Status.ERROR ? View.VISIBLE : View.GONE);
        binding.tvRefresh.setVisibility(status == Status.ERROR ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}