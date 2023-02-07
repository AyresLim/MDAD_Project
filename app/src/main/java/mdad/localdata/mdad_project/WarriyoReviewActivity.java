package mdad.localdata.mdad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import mdad.localdata.mdad_project.edmfragments.FirstWarriyoFragment;

public class WarriyoReviewActivity extends AppCompatActivity {

    private static final String url_create_product = FirstWarriyoFragment.ipBaseAddress+"/create_reviewJson.php";
    String pid;
    EditText inputUsername;
    EditText inputReview;
    Button btnAdd;
    private final int create_product = 1;
    private final int update_create_product = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warriyo_review);
        //get the resource ids
        inputUsername = (EditText) findViewById(R.id.inputUsername);
        inputReview = (EditText) findViewById(R.id.inputReview);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// getting updated data from EditTexts
                String username = inputUsername.getText().toString();
                String review = inputReview.getText().toString();

// encode into JSONObject
                JSONObject dataJson = new JSONObject();
                try{
                    //dataJson.put("pid", pid);
                    dataJson.put("username", username);
                    dataJson.put("review", review);

                }catch(JSONException e){
                    Toast.makeText(getApplicationContext(),"Error in JSON Encoding",Toast.LENGTH_LONG);
                }
//postData method to use Volley to update new product details in database
                postData(url_create_product,dataJson,update_create_product);
            }
        });
    }
    public void postData(String url, final JSONObject json, final int requestType){
        //create a RequestQueue for Volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //define JSONObjectRequest for http post web request, and send pid in JSON
        JsonObjectRequest json_obj_req = new JsonObjectRequest(
                Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //check the type of volley request
                switch (requestType){
                    //case for getting selected product details
                    //case get_product_details:checkResponseProductDetails(response); break;
                    //case for updating or deleting the product
                    case update_create_product:checkResponseSave_create_Product(response); break;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG);
            }
        });
        //execute the JSONObject Request defined above
        requestQueue.add(json_obj_req);
    }
    public void checkResponseSave_create_Product(JSONObject response) {
        try {
//check if the response if successful
            if (response.getInt("success") == 1) {
                Toast.makeText(getApplicationContext(), "Create Product Success",
                        Toast.LENGTH_LONG).show();
//call finish() to destroy this activity and return to calling activity (AllProductsActivity)
                finish();
//load the AllProductActivity with updated ListView
                Intent i = new Intent(this, FirstWarriyoFragment.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Created Product",
                        Toast.LENGTH_LONG).show();
            } else {
//Error Response from server
                Toast.makeText(getApplicationContext(), "Error in Creating Product",
                        Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "Error in JSON",
                    Toast.LENGTH_LONG).show();
        }
    }
}