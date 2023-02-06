package mdad.localdata.mdad_project.metalfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.swssongs.BKActivity;
import mdad.localdata.mdad_project.swssongs.BODActivity;
import mdad.localdata.mdad_project.swssongs.CCActivity;
import mdad.localdata.mdad_project.swssongs.IYCHActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondSWSFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondSWSFragment extends Fragment {

    Button btnIYCH;
    Button btnBOD;
    Button btnBK;
    Button btnCC;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondSWSFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondSWSFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondSWSFragment newInstance(String param1, String param2) {
        SecondSWSFragment fragment = new SecondSWSFragment();
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
        return inflater.inflate(R.layout.fragment_second_s_w_s, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnIYCH = (Button)view.findViewById(R.id.btnIYCH);
        btnBOD = (Button)view.findViewById(R.id.btnBOD);
        btnBK = (Button)view.findViewById(R.id.btnBK);
        btnCC = (Button)view.findViewById(R.id.btnCC);

        btnIYCH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), IYCHActivity.class));
            }
        });

        btnBOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BODActivity.class));
            }
        });

        btnBK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BKActivity.class));
            }
        });

        btnCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CCActivity.class));
            }
        });

    }
}