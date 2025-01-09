package com.devbeans.io.chat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devbeans.io.chat.R;
import com.devbeans.io.chat.adapters.FoldersAdapter;
import com.devbeans.io.chat.callBacks.OnItemTouchCallBack;
import com.devbeans.io.chat.databinding.FragmentFoldersBinding;
import com.devbeans.io.chat.viewmodels.FoldersFragmentViewModel;

import java.util.Objects;

//************************************************************
public class FoldersFragment
        extends Fragment
        implements OnItemTouchCallBack
//************************************************************
{
    FragmentFoldersBinding mBinding;
    NavController mNavController;
    private FoldersAdapter mAdapter;
    private FoldersFragmentViewModel mViewModel;
    private Bundle mBundle = new Bundle();

    //************************************************************
    public FoldersFragment()
    //************************************************************
    {
        // Required empty public constructor
    }

    //************************************************************
    public static FoldersFragment newInstance()
    //************************************************************
    {
        return new FoldersFragment();
    }

    //************************************************************
    @Override
    public void onCreate(Bundle savedInstanceState)
    //************************************************************
    {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(FoldersFragmentViewModel.class);
    }

    //************************************************************
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    //************************************************************
    {
        // Inflate the layout for this fragment
        mBinding = FragmentFoldersBinding.inflate(inflater, container, false);
        setToolBar(mBinding.toolbar);
        getNavController();
        listeners();
        populateRecyclerView();
        observers();
        return mBinding.getRoot();
    }

    //************************************************************
    private void observers()
    //************************************************************
    {
        mViewModel.getChatRoomList().observe(requireActivity(), chatRooms -> {
            if (chatRooms != null)
                mAdapter.setChatRoomList(chatRooms);
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
        mBinding.searchBar.setQueryHint(getArguments().getString("title").contains("one") ?
                "Search Chat name" : "Search group name");
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
        mBinding.rvFolders.setLayoutManager(layoutManager);
        mAdapter = new FoldersAdapter(this);
        mBinding.rvFolders.setAdapter(mAdapter);
    }


    //************************************************************
    @Override
    public void onTouch(String title)
    //************************************************************
    {
        mBundle.putString("title", title);
        mNavController.navigate(R.id.action_foldersFragment_to_filesFragment, mBundle);
    }
}