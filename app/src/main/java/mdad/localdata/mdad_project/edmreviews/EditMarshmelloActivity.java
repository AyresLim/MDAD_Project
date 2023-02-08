package mdad.localdata.mdad_project.edmreviews;

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

import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.edmfragments.FirstMarshmelloFragment;

public class EditMarshmelloActivity extends AppCompatActivity {



    // url to get selected product details
    private static final String url_review_details =
            FirstMarshmelloFragment.ipBaseAddress+"/get_review_detailsJson.php";
    // url to update product
    private static final String url_update_review =
            FirstMarshmelloFragment.ipBaseAddress+"/update_reviewJson.php";
    // url to delete product
    private static final String url_delete_review =
            FirstMarshmelloFragment.ipBaseAddress+"/delete_reviewJson.php";

    //store the value of product id
    String pid;
    //define the type of volley request to be used to distinguish different volley response.
    private final int get_review_details = 1;
    private final int update_delete_review = 2;
    //variables to store resource ids of EditText & Buttons

    EditText inputUsername;
    EditText inputReview;
    Button btnSave;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_marshmello);

        //get the resource ids
        inputUsername = (EditText) findViewById(R.id.inputUsername);
        inputReview = (EditText) findViewById(R.id.inputReview);
        btnSave = (Button) findViewById(R.id.btnCreate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
// create an Intent to receive pid sent from AllProductsActivity
        Intent i = getIntent();
// getting product id (pid) from intent
        pid = i.getStringExtra("product_id");
// encode pid into JSONObject
        JSONObject dataJson = new JSONObject();
        try{
            dataJson.put("pid", pid);
        }catch(JSONException e){
            Toast.makeText(getApplicationContext(),"Error in JSON Encoding of pid",Toast.LENGTH_LONG);
        }
//postData method to use Volley to retrieve selected product details from database
        postData(url_review_details,dataJson,get_review_details);

        // Delete button click event
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
//Encode pid in JSON object
                JSONObject dataJson = new JSONObject();
                try{
                    dataJson.put("pid", pid);
                }catch(JSONException e){
                    Toast.makeText(getApplicationContext(),"Error in JSON Encoding",Toast.LENGTH_LONG);
                }
//postData method to use Volley to delete the product in database
                postData(url_delete_review,dataJson,update_delete_review);
            }
        });


        // save button click event
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// getting updated data from EditTexts
                String username = inputUsername.getText().toString();
                String review = inputReview.getText().toString();
// encode into JSONObject
                JSONObject dataJson = new JSONObject();
                try{
                    dataJson.put("pid", pid);
                    dataJson.put("username", username);
                    dataJson.put("review", review);
                }catch(JSONException e){
                    Toast.makeText(getApplicationContext(),"Error in JSON Encoding",Toast.LENGTH_LONG);
                }
//postData method to use Volley to update new product details in database
                postData(url_update_review,dataJson,update_delete_review);
            }
        });
    }
    public void checkResponseSave_delete_Product(JSONObject response) {
        try {
            //check if the response if successful
            if (response.getInt("success") == 1) {
                Toast.makeText(getApplicationContext(), "Update / Delete Success", Toast.LENGTH_LONG).show();
                //call finish() to destroy this activity and return to calling activity (AllProductsActivity)
                finish();
                //load the AllProductActivity with updated ListView
                Intent i = new Intent(this, FirstMarshmelloFragment.class);
                startActivity(i);
            } else {
                //Error Response from server
                Toast.makeText(getApplicationContext(), "Error in updating / deleting", Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e) {
            Toast.makeText(getApplicationContext(), "Error in JSON", Toast.LENGTH_LONG).show();
        }
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
                    case get_review_details:checkResponseProductDetails(response); break;
                    //case for updating or deleting the product
                    case update_delete_review:checkResponseSave_delete_Product(response); break;
                }
            }



            public void checkResponseProductDetails(JSONObject response)
            {
                try {
//check if the response if successful
                    if(response.getInt("success")==1) {
// get the product JSONArray
                        JSONArray productObj = response.getJSONArray("product");
// get first product object from JSON Array.
// In this case, there is only one element in the array
                        JSONObject product = productObj.getJSONObject(0);
//retreive the details of the product from JSONObject
                        String prodUsername=product.getString("username");
                        String prodReview=product.getString("review");

                        // display product details in EditText
                        inputUsername.setText(prodUsername);
                        inputReview.setText(prodReview);
                    }else{
//Error Response from server
                        Toast.makeText(getApplicationContext(),"Fail to retrieve the product details",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
//Error in JSON
                    Toast.makeText(getApplicationContext(),"Error in JSON decoding",
                            Toast.LENGTH_LONG).show();
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
}