package mdad.localdata.mdad_project.darrensongs;

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
import mdad.localdata.mdad_project.martinsongs.AnimalsActivity;

public class DYSLYMActivity extends AppCompatActivity {

    TextView tvAbout;
    ImageView imgSpotify;
    ImageView imgApple;
    ImageView imgDeezer;
    ImageView imgYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dyslymactivity);

        imgSpotify = (ImageView) findViewById(R.id.imgSpotify);
        imgApple = (ImageView) findViewById(R.id.imgApple);
        imgDeezer = (ImageView) findViewById(R.id.imgDeezer);
        imgYoutube = (ImageView) findViewById(R.id.imgYoutube);

        tvAbout = (TextView) findViewById(R.id.tvAbout);
        new DYSLYMActivity.NetworkTask().execute("http://172.30.68.237/songs/darren/dyslym.txt");

        imgSpotify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://open.spotify.com/track/4tV6ku4jEYw9L5gZuNpCbP?autoplay=true");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgYoutube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://music.youtube.com/watch?v=2dF9aze4Ts4&feature=gws_kp_track");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgApple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://music.apple.com/sg/album/dysylm/1514520496?i=1514520497");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgDeezer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.deezer.com/track/989933182?autoplay=true");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }

    private class NetworkTask extends AsyncTask<String, Void, String> {
        String  testMsg="";
        protected String doInBackground(String... params) {

            try{

                System.out.println("NetworkTask started……");
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
