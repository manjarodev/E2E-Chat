package com.devbeans.io.chat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.databinding.FragmentFileStorageBinding;


//************************************************************
public class FileStorageFragment
        extends Fragment
//************************************************************
{
    FragmentFileStorageBinding mBinding;
    NavController mNavController;
    Bundle mBundle;

    //************************************************************
    public FileStorageFragment()
    //************************************************************
    {
        // Required empty public constructor
    }

    //************************************************************
    public static FileStorageFragment newInstance()
    //************************************************************
    {
        return new FileStorageFragment();
    }

    //************************************************************
    @Override
    public void onCreate(Bundle savedInstanceState)
    //************************************************************
    {
        super.onCreate(savedInstanceState);


    }

    //************************************************************
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    //************************************************************
    {
        mBinding = FragmentFileStorageBinding.inflate(inflater, container, false);
        listeners();
        getNavController();
        return mBinding.getRoot();
    }

    //************************************************************
    private void listeners()
    //************************************************************
    {
        mBinding.layoutGroupChat.setOnClickListener(view -> {
            mBundle = new Bundle();
            mBundle.putString("title", mBinding.tvGroupChats.getText().toString());
            mNavController.navigate(R.id.action_fileStorageFragment_to_foldersFragment, mBundle);
        });

        mBinding.layoutOneToOneChat.setOnClickListener(view -> {
            mBundle = new Bundle();
            mBundle.putString("title", mBinding.tvChats.getText().toString());
            mNavController.navigate(R.id.action_fileStorageFragment_to_foldersFragment, mBundle);
        });
    }

    //************************************************************
    private void getNavController()
    //************************************************************
    {
        mNavController = NavHostFragment.findNavController(this);
    }


}