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

public class ByteActivity extends AppCompatActivity {

    TextView tvAbout;
    ImageView imgSpotify;
    //ImageView imgApple;
    //ImageView imgDeezer;
    //ImageView imgYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_byte);

        imgSpotify = (ImageView) findViewById(R.id.imgSpotify);
        //imgApple = (ImageView) findViewById(R.id.imgApple);
        //imgDeezer = (ImageView) findViewById(R.id.imgDeezer);
        //imgYoutube = (ImageView) findViewById(R.id.imgYoutube);

        tvAbout = (TextView) findViewById(R.id.tvAbout);
        new ByteActivity.NetworkTask().execute("http://172.30.46.118/songs/martin/byte.txt");

        imgSpotify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://open.spotify.com/track/20hsdn8oITBsuWNLhzr5eh?si=8f34e3fcd89f4609");
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
