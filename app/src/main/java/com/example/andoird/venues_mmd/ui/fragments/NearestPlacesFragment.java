package com.example.andoird.venues_mmd.ui.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.databinding.FragmentNearestPlacesBinding;
import com.example.andoird.venues_mmd.viewmodels.fragments.NearestPlacesFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearestPlacesFragment extends BaseFragment {

    private static final String ARG_LATITUDE = "latitude";
    private static final String ARG_LONGITUDE = "longitude";

    private double latitude;
    private double longitude;

    private NearestPlacesFragmentViewModel viewModel;


    public NearestPlacesFragment() {
        // Required empty public constructor
    }

    public static NearestPlacesFragment newInstance(double latitude, double longitude) {
        NearestPlacesFragment fragment = new NearestPlacesFragment();
        Bundle args = new Bundle();
        args.putDouble(ARG_LATITUDE, latitude);
        args.putDouble(ARG_LONGITUDE, longitude);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            latitude = getArguments().getDouble(ARG_LATITUDE);
            longitude = getArguments().getDouble(ARG_LONGITUDE);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentNearestPlacesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nearest_places, container, false);
        viewModel = new NearestPlacesFragmentViewModel(this.getActivity(),
                binding.searchRecyclerView, latitude, longitude);
        binding.setNearestPlacesFragment(viewModel);
        return binding.getRoot();

    }

}
