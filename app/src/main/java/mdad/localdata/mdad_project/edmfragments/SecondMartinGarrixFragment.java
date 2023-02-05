package mdad.localdata.mdad_project.edmfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.martinsongs.AnimalsActivity;
import mdad.localdata.mdad_project.martinsongs.ByteActivity;
import mdad.localdata.mdad_project.martinsongs.PizzaActivity;
import mdad.localdata.mdad_project.martinsongs.VirusActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondMartinGarrixFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondMartinGarrixFragment extends Fragment {

    Button btnVirus;
    Button btnByte;
    Button btnPizza;
    Button btnAnimals;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondMartinGarrixFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondMartinGarrixFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondMartinGarrixFragment newInstance(String param1, String param2) {
        SecondMartinGarrixFragment fragment = new SecondMartinGarrixFragment();
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
        return inflater.inflate(R.layout.fragment_second_martin_garrix, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnVirus = (Button)view.findViewById(R.id.btnVirus);
        btnByte = (Button)view.findViewById(R.id.btnByte);
        btnAnimals = (Button)view.findViewById(R.id.btnAnimals);
        btnPizza = (Button)view.findViewById(R.id.btnPizza);

        btnVirus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VirusActivity.class));
            }
        });

        btnByte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ByteActivity.class));
            }
        });

        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AnimalsActivity.class));
            }
        });

        btnPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PizzaActivity.class));
            }
        });

    }

}