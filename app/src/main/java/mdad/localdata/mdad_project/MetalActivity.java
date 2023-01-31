package mdad.localdata.mdad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mdad.localdata.mdad_project.metalfragments.BOFragment;
import mdad.localdata.mdad_project.metalfragments.IPFragment;
import mdad.localdata.mdad_project.metalfragments.MIWFragment;
import mdad.localdata.mdad_project.metalfragments.SWSFragment;

public class MetalActivity extends AppCompatActivity {

    Button btnBO;
    Button btnMIW;
    Button btnSWS;
    Button btnIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metal);

        btnBO = (Button)findViewById(R.id.btnBO);
        btnIP = (Button)findViewById(R.id.btnIP);
        btnMIW = (Button)findViewById(R.id.btnMIW);
        btnSWS = (Button)findViewById(R.id.btnSWS);


        btnBO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MetalActivity.this, BOFragment.class));
            }
        });

        btnIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MetalActivity.this, IPFragment.class));
            }
        });

        btnMIW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MetalActivity.this, MIWFragment.class));
            }
        });

        btnSWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MetalActivity.this, SWSFragment.class));
            }
        });
    }
}