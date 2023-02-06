package mdad.localdata.mdad_project.metalfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.bosongs.DethroneActivity;
import mdad.localdata.mdad_project.bosongs.JPActivity;
import mdad.localdata.mdad_project.bosongs.MercyActivity;
import mdad.localdata.mdad_project.bosongs.NKActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondBOFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondBOFragment extends Fragment {

    Button btnJP;
    Button btnDethrone;
    Button btnNK;
    Button btnMercy;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondBOFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondBOFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondBOFragment newInstance(String param1, String param2) {
        SecondBOFragment fragment = new SecondBOFragment();
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
        return inflater.inflate(R.layout.fragment_second_b_o, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnJP = (Button)view.findViewById(R.id.btnJP);
        btnDethrone = (Button)view.findViewById(R.id.btnDethrone);
        btnNK = (Button)view.findViewById(R.id.btnNK);
        btnMercy = (Button)view.findViewById(R.id.btnMercy);

        btnJP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), JPActivity.class));
            }
        });

        btnDethrone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DethroneActivity.class));
            }
        });

        btnNK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NKActivity.class));
            }
        });

        btnMercy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MercyActivity.class));
            }
        });

    }
}