package mdad.localdata.mdad_project.edmfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.EDMActivity;
import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.darrensongs.DLMDActivity;
import mdad.localdata.mdad_project.darrensongs.DYSLYMActivity;
import mdad.localdata.mdad_project.darrensongs.SwitchActivity;
import mdad.localdata.mdad_project.darrensongs.UAWActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondDarrenStylesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondDarrenStylesFragment extends Fragment {

    Button btnUAW;
    Button btnSwitch;
    Button btnDLMD;
    Button btnDYSLYM;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondDarrenStylesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondDarrenStylesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondDarrenStylesFragment newInstance(String param1, String param2) {
        SecondDarrenStylesFragment fragment = new SecondDarrenStylesFragment();
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
        return inflater.inflate(R.layout.fragment_second_darren_styles, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnUAW = (Button)view.findViewById(R.id.btnUAW);
        btnSwitch = (Button)view.findViewById(R.id.btnSwitch);
        btnDLMD = (Button)view.findViewById(R.id.btnDLMD);
        btnDYSLYM = (Button)view.findViewById(R.id.btnDYSLYM);

        btnUAW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UAWActivity.class));
            }
        });

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SwitchActivity.class));
            }
        });

        btnDLMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DLMDActivity.class));
            }
        });

        btnDYSLYM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DYSLYMActivity.class));
            }
        });

    }

}