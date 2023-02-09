package mdad.localdata.mdad_project.warriyosongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
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

public class MortalsActivity extends AppCompatActivity {


    private MediaPlayer mediaPlayer;


    TextView tvAbout;
    ImageView imgSpotify;
    ImageView imgApple;
    ImageView imgDeezer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortals);

        imgSpotify = (ImageView) findViewById(R.id.imgSpotify);
        imgApple = (ImageView) findViewById(R.id.imgApple);
        imgDeezer = (ImageView) findViewById(R.id.imgDeezer);

//        Song: Warriyo - Mortals (feat. Laura Brehm) [NCS Release]
//        Music provided by NoCopyrightSounds
//        Free Download/Stream: http://ncs.io/mortals
//        Watch: http://youtu.be/yJg-Y5byMMw

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.mortals);

//        Song: Warriyo - Mortals (feat. Laura Brehm) [NCS Release]
//        Music provided by NoCopyrightSounds
//        Free Download/Stream: http://ncs.io/mortals
//        Watch: http://youtu.be/yJg-Y5byMMw

        tvAbout = (TextView) findViewById(R.id.tvAbout);
        new NetworkTask().execute("http://172.30.68.237/songs/warriyo/mortals.txt");

        imgSpotify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://open.spotify.com/track/3Fg5uhtWBlW0es8GSqQ6Ff?autoplay=true");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgApple.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://music.apple.com/sg/album/mortals/1184999732?i=1184999926");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgDeezer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.deezer.com/track/1733699537?autoplay=true");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();
        // Your code to start the playback here

        mediaPlayer.start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        // Your code to release the MediaPlayer here

        mediaPlayer.release();

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

