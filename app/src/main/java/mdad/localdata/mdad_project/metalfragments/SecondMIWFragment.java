package mdad.localdata.mdad_project.metalfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.miwsongs.ALActivity;
import mdad.localdata.mdad_project.miwsongs.CActivity;
import mdad.localdata.mdad_project.miwsongs.CyberActivity;
import mdad.localdata.mdad_project.miwsongs.VoicesActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondMIWFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondMIWFragment extends Fragment {

    Button btnC;
    Button btnVoices;
    Button btnAL;
    Button btnCyber;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondMIWFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondMIWFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondMIWFragment newInstance(String param1, String param2) {
        SecondMIWFragment fragment = new SecondMIWFragment();
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
        return inflater.inflate(R.layout.fragment_second_m_i_w, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnC = (Button)view.findViewById(R.id.btnC);
        btnVoices = (Button)view.findViewById(R.id.btnVoices);
        btnAL = (Button)view.findViewById(R.id.btnAL);
        btnCyber = (Button)view.findViewById(R.id.btnCyber);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CActivity.class));
            }
        });

        btnVoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VoicesActivity.class));
            }
        });

        btnAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ALActivity.class));
            }
        });

        btnCyber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CyberActivity.class));
            }
        });

    }


}