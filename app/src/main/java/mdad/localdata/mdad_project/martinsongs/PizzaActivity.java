package mdad.localdata.mdad_project.martinsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import mdad.localdata.mdad_project.R;

public class PizzaActivity extends AppCompatActivity {

    TextView tvAbout;
    ImageView imgSpotify;
    ImageView imgApple;
    ImageView imgDeezer;
    ImageView imgYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        imgSpotify = (ImageView) findViewById(R.id.imgSpotify);
        imgApple = (ImageView) findViewById(R.id.imgApple);
        imgDeezer = (ImageView) findViewById(R.id.imgDeezer);
        imgYoutube = (ImageView) findViewById(R.id.imgYoutube);

        tvAbout = (TextView) findViewById(R.id.tvAbout);
        new PizzaActivity.NetworkTask().execute("http://172.30.46.96/songs/martin/pizza.txt");

        imgSpotify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://open.spotify.com/track/5oAgI7Pzg6vxuKrfapg3Pi?autoplay=true");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgYoutube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://music.youtube.com/watch?v=JZrRKIRiCeM&feature=gws_kp_track");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgApple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://music.apple.com/sg/album/pizza/1272651881?i=1272651891");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgDeezer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.deezer.com/track/395627872?autoplay=true");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }

    private class NetworkTask extends AsyncTask<String, Void, String> {
        String  testMsg="";
        protected String doInBackground(String... params) {

            try{

                System.out.println("NetworkTask started??????");
                URL url = new URL(params[0]);

                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestProperty("Accept", "text/plain");
                BufferedReader br =new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                int i=0;
                while((line=br.readLine())!=null) {
                    testMsg+=line+"\n";
                }
                con.disconnect();
            }
            catch(IOException e){ Log.e("error", "error in reading", e); }
            return testMsg;

        }
        protected void onPostExecute(String result) {
            tvAbout.setText(result);

        }
    }

}
