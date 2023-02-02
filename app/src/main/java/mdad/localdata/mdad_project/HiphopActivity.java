package mdad.localdata.mdad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mdad.localdata.mdad_project.hiphopfragments.EminemFragment;
import mdad.localdata.mdad_project.hiphopfragments.KWFragment;
import mdad.localdata.mdad_project.hiphopfragments.LogicFragment;
import mdad.localdata.mdad_project.hiphopfragments.PMFragment;

public class HiphopActivity extends AppCompatActivity {

    Button btnPM;
    Button btnKW;
    Button btnLogic;
    Button btnEm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiphop);

        btnPM = (Button)findViewById(R.id.btnPM);
        btnKW = (Button)findViewById(R.id.btnKW);
        btnLogic = (Button)findViewById(R.id.btnLogic);
        btnEm = (Button)findViewById(R.id.btnEm);

        btnPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HiphopActivity.this, PMFragment.class));
            }
        });

        btnKW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HiphopActivity.this, KWFragment.class));
            }
        });

        btnLogic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HiphopActivity.this, LogicFragment.class));
            }
        });

        btnEm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HiphopActivity.this, EminemFragment.class));
            }
        });

    }
}