package mdad.localdata.mdad_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    //private static final String ROOT_URL = "http://192.168.50.67//LoginRegister/";

    //public static final String URL_REGISTER = ROOT_URL+"registerUser.php";

    private EditText etrUser, etrPassword, etrConPassword;
    private String user, password, confirmpassword;
    private Button btnRegister;

    private String URL = "http://192.168.0.163//LoginRegister2/register.php";
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etrUser = (EditText) findViewById(R.id.etrUsername);
        etrPassword = (EditText) findViewById(R.id.etrPassword);
        etrConPassword = (EditText) findViewById(R.id.etrConPassword);

        btnRegister = (Button) findViewById(R.id.btnSignup);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        user = password = confirmpassword = "";

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    public void save(View view) {
        user = etrUser.getText().toString().trim();
        password = etrPassword.getText().toString().trim();
        confirmpassword = etrConPassword.getText().toString().trim();
        if(!password.equals(confirmpassword)){
            Toast.makeText(this,"Password Mismatch",Toast.LENGTH_SHORT).show();
        }
        else if(!user.equals("") && !password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("success")) {
                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        btnRegister.setClickable(false);

                    } else if (response.equals("failure")) {
                        Toast.makeText(RegisterActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("username", user);
                    data.put("password", password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }
}