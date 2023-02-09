package mdad.localdata.mdad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GenreActivity extends AppCompatActivity {

    Button btnEDM;
    Button btnMetal;
    Button btnHiphop;
    Button btnPop;

    Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        btnEDM = (Button)findViewById(R.id.btnEdm);
        btnMetal = (Button)findViewById(R.id.btnMetal);
        btnHiphop = (Button)findViewById(R.id.btnHiphop);
        btnPop = (Button)findViewById(R.id.btnPop);
        btnLogout = (Button)findViewById(R.id.btnLogout);

        btnEDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GenreActivity.this, EDMActivity.class));
            }
        });

        btnMetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GenreActivity.this, MetalActivity.class));
            }
        });

        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GenreActivity.this, PopActivity.class));
            }
        });

        btnHiphop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GenreActivity.this, HiphopActivity.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GenreActivity.this, LoginActivity.class));
                Toast.makeText(GenreActivity.this, "User has successfully logged out", Toast.LENGTH_SHORT).show();
            }
        });

    }
}