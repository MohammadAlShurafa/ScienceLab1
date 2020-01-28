package com.science.app.sciencelab;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowDevicesFragment extends Fragment {
    private ArrayList<Item> deviceItems;
    DevicesAdapter adapter;
    LinearLayoutManager lm;
    GridLayoutManager grid;

    public ShowDevicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_show_devices, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();

        assert bundle != null;
        deviceItems = new MyDbHelper(getContext()).getAllItemForDepartment(bundle.getInt("num"));

        RecyclerView rc = getView().findViewById(R.id.recyclerView);
        adapter = new DevicesAdapter(getContext(), deviceItems);

       /* lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rc.setLayoutManager(lm);
        rc.setAdapter(adapter);*/

        grid = new GridLayoutManager(getContext(),2);
        grid.setOrientation(GridLayoutManager.VERTICAL);
        rc.setLayoutManager(grid);
        rc.setAdapter(adapter);
    }

    public void refresh(int i) {
        grid.scrollToPosition(0);
        deviceItems = new MyDbHelper(getContext()).getAllItemForDepartment(i);
        adapter.refresh(deviceItems);
    }
}
