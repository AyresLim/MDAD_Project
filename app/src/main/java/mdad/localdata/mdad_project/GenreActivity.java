package mdad.localdata.mdad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GenreActivity extends AppCompatActivity {

    Button btnEDM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        btnEDM = (Button)findViewById(R.id.btnEdm);

        btnEDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GenreActivity.this, EDMActivity.class));
            }
        });
    }
}