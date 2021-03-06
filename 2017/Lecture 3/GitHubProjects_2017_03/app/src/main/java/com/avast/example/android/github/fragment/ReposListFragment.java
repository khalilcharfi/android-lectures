package com.avast.example.android.github.fragment;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.avast.example.android.github.R;
import com.avast.example.android.github.data.Storage;
import com.avast.example.android.github.model.Repo;

/**
 * @author Lukas Prokop (prokop@avast.com)
 */
public class ReposListFragment extends Fragment {

    private static final String ARG_USERNAME = "username";

    private ListView vReposListView;

    public static ReposListFragment newInstance(String username) {
        ReposListFragment fragment = new ReposListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, username);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repos_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        vReposListView = view.findViewById(R.id.list_repos);
        vReposListView.setAdapter(new ReposAdapter(getActivity(), R.layout.item_repo, R.id.txt_repo_name, Storage
            .getRepos()));

        super.onViewCreated(view, savedInstanceState);
    }

    //TODO 3 Better item + recycling
    private static class ReposAdapter extends ArrayAdapter<Repo> {

        public ReposAdapter(Context context, int resource, int textViewResourceId, List<Repo> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        private static class ViewHolder {
            TextView vTxtRepoName;
            TextView vTxtRepoDescription;
        }
    }
}
