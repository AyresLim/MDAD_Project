package mdad.localdata.mdad_project.hiphopfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.pmsongs.BNActivity;
import mdad.localdata.mdad_project.pmsongs.CirclesActivity;
import mdad.localdata.mdad_project.pmsongs.RockActivity;
import mdad.localdata.mdad_project.pmsongs.WowActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondPMFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondPMFragment extends Fragment {

    Button btnRock;
    Button btnCircles;
    Button btnWow;
    Button btnBN;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondPMFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondPMFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondPMFragment newInstance(String param1, String param2) {
        SecondPMFragment fragment = new SecondPMFragment();
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
        return inflater.inflate(R.layout.fragment_second_p_m, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnRock = (Button)view.findViewById(R.id.btnRock);
        btnCircles = (Button)view.findViewById(R.id.btnCircles);
        btnWow = (Button)view.findViewById(R.id.btnWow);
        btnBN = (Button)view.findViewById(R.id.btnBN);

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RockActivity.class));
            }
        });

        btnCircles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CirclesActivity.class));
            }
        });

        btnWow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WowActivity.class));
            }
        });

        btnBN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BNActivity.class));
            }
        });

    }

}