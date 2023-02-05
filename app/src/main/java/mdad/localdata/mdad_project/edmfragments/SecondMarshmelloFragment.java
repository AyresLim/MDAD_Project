package mdad.localdata.mdad_project.edmfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.darrensongs.DLMDActivity;
import mdad.localdata.mdad_project.darrensongs.DYSLYMActivity;
import mdad.localdata.mdad_project.darrensongs.SwitchActivity;
import mdad.localdata.mdad_project.darrensongs.UAWActivity;
import mdad.localdata.mdad_project.marshmellosongs.HappierActivity;
import mdad.localdata.mdad_project.marshmellosongs.NumbActivity;
import mdad.localdata.mdad_project.marshmellosongs.ShockwaveActivity;
import mdad.localdata.mdad_project.marshmellosongs.SilenceActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondMarshmelloFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondMarshmelloFragment extends Fragment {

    Button btnNumb;
    Button btnHappier;
    Button btnSilence;
    Button btnShockwave;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondMarshmelloFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondMarshmelloFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondMarshmelloFragment newInstance(String param1, String param2) {
        SecondMarshmelloFragment fragment = new SecondMarshmelloFragment();
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
        return inflater.inflate(R.layout.fragment_second_marshmello, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnNumb = (Button)view.findViewById(R.id.btnNumb);
        btnHappier = (Button)view.findViewById(R.id.btnHappier);
        btnSilence = (Button)view.findViewById(R.id.btnSilence);
        btnShockwave = (Button)view.findViewById(R.id.btnShockwave);

        btnNumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NumbActivity.class));
            }
        });

        btnHappier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HappierActivity.class));
            }
        });

        btnSilence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SilenceActivity.class));
            }
        });

        btnShockwave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShockwaveActivity.class));
            }
        });

    }

}