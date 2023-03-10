package mdad.localdata.mdad_project.popfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.orsongs.ApologizeActivity;
import mdad.localdata.mdad_project.orsongs.CSActivity;
import mdad.localdata.mdad_project.orsongs.IAWActivity;
import mdad.localdata.mdad_project.orsongs.RunActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondORFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondORFragment extends Fragment {

    Button btnIAW;
    Button btnCS;
    Button btnApologize;
    Button btnRun;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondORFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondORFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondORFragment newInstance(String param1, String param2) {
        SecondORFragment fragment = new SecondORFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_o_r, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnIAW = (Button)view.findViewById(R.id.btnIAW);
        btnCS = (Button)view.findViewById(R.id.btnCS);
        btnApologize = (Button)view.findViewById(R.id.btnApologize);
        btnRun = (Button)view.findViewById(R.id.btnRun);

        btnIAW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), IAWActivity.class));
            }
        });

        btnCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CSActivity.class));
            }
        });

        btnApologize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ApologizeActivity.class));
            }
        });

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RunActivity.class));
            }
        });

    }
}