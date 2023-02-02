package mdad.localdata.mdad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mdad.localdata.mdad_project.popfragments.ColdplayFragment;
import mdad.localdata.mdad_project.popfragments.IDFragment;
import mdad.localdata.mdad_project.popfragments.M5Fragment;
import mdad.localdata.mdad_project.popfragments.ORFragment;

public class PopActivity extends AppCompatActivity {

    Button btnOR;
    Button btnCold;
    Button btnM5;
    Button btnID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        btnOR = (Button)findViewById(R.id.btnOR);
        btnCold = (Button)findViewById(R.id.btnCold);
        btnM5 = (Button)findViewById(R.id.btnM5);
        btnID = (Button)findViewById(R.id.btnID);

        btnOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopActivity.this, ORFragment.class));
            }
        });

        btnCold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopActivity.this, ColdplayFragment.class));
            }
        });

        btnM5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopActivity.this, M5Fragment.class));
            }
        });

        btnID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopActivity.this, IDFragment.class));
            }
        });

    }

}