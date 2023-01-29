package mdad.localdata.mdad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mdad.localdata.mdad_project.edmfragments.DarrenStylesFragment;
import mdad.localdata.mdad_project.edmfragments.MarshmelloFragment;
import mdad.localdata.mdad_project.edmfragments.MartinGarrixFragment;
import mdad.localdata.mdad_project.edmfragments.WarriyoFragment;

public class EDMActivity extends AppCompatActivity {

    Button btnWarriyo;
    Button btnMarshmello;
    Button btnMG;
    Button btnDS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edmactivity);

        btnWarriyo = (Button)findViewById(R.id.btnWarriyo);
        btnMarshmello = (Button)findViewById(R.id.btnMarshmello);
        btnMG = (Button)findViewById(R.id.btnMG);
        btnDS = (Button)findViewById(R.id.btnDS);

        btnWarriyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EDMActivity.this, WarriyoFragment.class));
            }
        });

        btnMarshmello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EDMActivity.this, MarshmelloFragment.class));
            }
        });

        btnMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EDMActivity.this, MartinGarrixFragment.class));
            }
        });

        btnDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EDMActivity.this, DarrenStylesFragment.class));
            }
        });

    }
}