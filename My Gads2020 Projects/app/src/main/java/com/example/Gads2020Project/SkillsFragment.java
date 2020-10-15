package com.example.Gads2020Project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillsFragment extends Fragment {
    private ProgressBar mLoadingProgress;
    private RecyclerView  rvSkills;
    private ArrayList<SkillsData> skillsArray = new ArrayList<>(  );
    private TextView tvError;
    private static final String BASE_API_URL = "https://gadsapi.herokuapp.com/api/";
    private static final String SKIILS_SCORES = "skilliq";

   private class SkillsQueryTask  extends AsyncTask<URL, Void, String>{

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            try{
                return GadsApiUtil.getJASON(searchUrl);
            }
            catch(IOException e){
                Log.e("Error", e.getMessage());
            }
            return null;

       }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
         }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute( result );
            if (result == null) {
                rvSkills.setVisibility(View.INVISIBLE);
                tvError.setVisibility(View.VISIBLE);
            } else {
                rvSkills.setVisibility(View.VISIBLE);
            }
            skillsArray = GadsApiUtil.getSkillsFromJason( result );
            SkillsAdapter adapter = new SkillsAdapter(skillsArray);
            rvSkills.setAdapter(adapter);

        }
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkillsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HoursFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillsFragment newInstance(String param1, String param2) {
        SkillsFragment fragment = new SkillsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String query_parameter = SKIILS_SCORES;
        URL  queryUrl = GadsApiUtil.buildUrl( query_parameter );

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        rvSkills = view.findViewById( R.id.rvSkills );
        SkillsQueryTask skillTask = new SkillsQueryTask();
        skillTask.execute( queryUrl );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager( getActivity() );
        rvSkills.setLayoutManager( mLayoutManager );
        return view;

    }
}

