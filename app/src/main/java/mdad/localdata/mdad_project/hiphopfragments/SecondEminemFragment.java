package mdad.localdata.mdad_project.hiphopfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.eminemsongs.GodActivity;
import mdad.localdata.mdad_project.eminemsongs.MockingbirdActivity;
import mdad.localdata.mdad_project.eminemsongs.SupermanActivity;
import mdad.localdata.mdad_project.eminemsongs.WMActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondEminemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondEminemFragment extends Fragment {

    Button btnMockingbird;
    Button btnWM;
    Button btnSuperman;
    Button btnGod;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondEminemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondEminemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondEminemFragment newInstance(String param1, String param2) {
        SecondEminemFragment fragment = new SecondEminemFragment();
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
        return inflater.inflate(R.layout.fragment_second_eminem, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnMockingbird = (Button)view.findViewById(R.id.btnMockingbird);
        btnWM = (Button)view.findViewById(R.id.btnWM);
        btnSuperman = (Button)view.findViewById(R.id.btnSuperman);
        btnGod = (Button)view.findViewById(R.id.btnGod);

        btnMockingbird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MockingbirdActivity.class));
            }
        });

        btnWM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WMActivity.class));
            }
        });

        btnSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SupermanActivity.class));
            }
        });

        btnGod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GodActivity.class));
            }
        });

    }

}