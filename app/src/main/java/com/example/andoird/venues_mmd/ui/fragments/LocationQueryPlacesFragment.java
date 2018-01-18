package com.example.andoird.venues_mmd.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.databinding.FragmentLocationQueryPlacesBinding;
import com.example.andoird.venues_mmd.viewmodels.fragments.LocationQueryPlacesFragmentViewModel;


public class LocationQueryPlacesFragment extends BaseFragment {

    private static final String ARG_LATITUDE = "latitude";
    private static final String ARG_LONGITUDE = "longitude";
    private static final String ARG_QUERY = "query";
    private static final String ARG_IS_GLOBAL = "isGlobal";

    private double latitude;
    private double longitude;
    private String query;
    private boolean isGlobal;

    private LocationQueryPlacesFragmentViewModel viewModel;


    public LocationQueryPlacesFragment() {
        // Required empty public constructor
    }

    public static LocationQueryPlacesFragment newInstance(double latitude, double longitude, String query, boolean isGlobal) {
        LocationQueryPlacesFragment fragment = new LocationQueryPlacesFragment();
        Bundle args = new Bundle();
        args.putDouble(ARG_LATITUDE, latitude);
        args.putDouble(ARG_LONGITUDE, longitude);
        args.putString(ARG_QUERY, query);
        args.putBoolean(ARG_IS_GLOBAL, isGlobal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            latitude = getArguments().getDouble(ARG_LATITUDE);
            longitude = getArguments().getDouble(ARG_LONGITUDE);
            query = getArguments().getString(ARG_QUERY);
            isGlobal = getArguments().getBoolean(ARG_IS_GLOBAL);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentLocationQueryPlacesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_location_query_places, container, false);
        viewModel = new LocationQueryPlacesFragmentViewModel(this.getActivity(), binding.searchRecyclerView, latitude, longitude, query, isGlobal);
        binding.setPlaceLocationQueryFragment(viewModel);
        return binding.getRoot();
    }

}
