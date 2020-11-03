package com.mubashar.generalmotorcodingchallenge.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mubashar.generalmotorcodingchallenge.R;
import com.mubashar.generalmotorcodingchallenge.databinding.FragmentMainBinding;
import com.mubashar.generalmotorcodingchallenge.network.ApiResponse;
import com.mubashar.generalmotorcodingchallenge.ui.activities.MainActivity;
import com.mubashar.generalmotorcodingchallenge.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainFragment extends Fragment {
    @Inject
    MainViewModel mainViewModel;
    FragmentMainBinding binding;

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
        mainViewModel.getResponseLiveData().observe(getViewLifecycleOwner(), this::consumeResponse);
        mainViewModel.getAllCommits();
    }

    private void consumeResponse(ApiResponse response) {
        Log.d("response", response.toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}