package mdad.localdata.mdad_project.popfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.idsongs.BelieverActivity;
import mdad.localdata.mdad_project.idsongs.BonesActivity;
import mdad.localdata.mdad_project.idsongs.DemonsActivity;
import mdad.localdata.mdad_project.idsongs.ThunderActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondIDFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondIDFragment extends Fragment {

    Button btnBones;
    Button btnBeliever;
    Button btnDemons;
    Button btnThunder;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondIDFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondIDFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondIDFragment newInstance(String param1, String param2) {
        SecondIDFragment fragment = new SecondIDFragment();
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
        return inflater.inflate(R.layout.fragment_second_i_d, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnBones = (Button)view.findViewById(R.id.btnBones);
        btnBeliever = (Button)view.findViewById(R.id.btnBeliever);
        btnDemons = (Button)view.findViewById(R.id.btnDemons);
        btnThunder = (Button)view.findViewById(R.id.btnThunder);

        btnBones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BonesActivity.class));
            }
        });

        btnBeliever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BelieverActivity.class));
            }
        });

        btnDemons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DemonsActivity.class));
            }
        });

        btnThunder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ThunderActivity.class));
            }
        });

    }
}