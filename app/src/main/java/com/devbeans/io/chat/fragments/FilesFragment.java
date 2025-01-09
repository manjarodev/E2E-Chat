package com.devbeans.io.chat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devbeans.io.chat.adapters.FilesAdapter;
import com.devbeans.io.chat.databinding.FragmentFilesBinding;
import com.devbeans.io.chat.viewmodels.FileViewModel;

import java.util.Objects;

//************************************************************
public class FilesFragment
        extends Fragment
//************************************************************
{
    private FragmentFilesBinding mBinding;
    private NavController mNavController;
    private FileViewModel mViewModel;
    private FilesAdapter mAdapter;


    //************************************************************
    public FilesFragment()
    //************************************************************
    {
        // Required empty public constructor
    }


    //************************************************************
    public static FilesFragment newInstance()
    //************************************************************
    {
        return new FilesFragment();
    }

    //************************************************************
    @Override
    public void onCreate(Bundle savedInstanceState)
    //************************************************************
    {
        super.onCreate(savedInstanceState);

        mViewModel = new ViewModelProvider(requireActivity()).get(FileViewModel.class);
    }

    //************************************************************
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    //************************************************************
    {
        mBinding = FragmentFilesBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        setToolBar(mBinding.toolbar);
        populateRecyclerView();
        getNavController();
        listeners();
        observers();
        return mBinding.getRoot();
    }

    //************************************************************
    private void observers()
    //************************************************************
    {
        mViewModel.getChatRoomList().observe(requireActivity(), chatRooms -> {
            if (chatRooms != null)
                mAdapter.setChatRoomLists(chatRooms);

        });
    }

    //************************************************************
    private void listeners()
    //************************************************************
    {

        mBinding.toolbar.setNavigationOnClickListener(view -> mNavController.navigateUp());
    }


    //************************************************************
    private void setToolBar(Toolbar toolbar)
    //************************************************************
    {
        AppCompatActivity activity = (AppCompatActivity) requireActivity();
        assert getArguments() != null;
        mBinding.title.setText(getArguments().getString("title"));
        activity.setSupportActionBar(toolbar);
        Objects.requireNonNull(activity.getSupportActionBar()).setDisplayShowTitleEnabled(false);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    //************************************************************
    private void getNavController()
    //************************************************************
    {
            mNavController = NavHostFragment.findNavController(this);
    }

    //************************************************************
    private void populateRecyclerView()
    //************************************************************
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        mBinding.rvFiles.setLayoutManager(layoutManager);
        mAdapter = new FilesAdapter();
        mBinding.rvFiles.setAdapter(mAdapter);
    }
}