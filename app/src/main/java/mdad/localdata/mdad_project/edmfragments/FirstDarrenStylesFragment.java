package mdad.localdata.mdad_project.edmfragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import mdad.localdata.mdad_project.edmreviews.EditDarrenStylesActivity;
import mdad.localdata.mdad_project.R;
import mdad.localdata.mdad_project.edmreviews.DarrenStylesReviewActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstDarrenStylesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstDarrenStylesFragment extends Fragment {

    public static String ipBaseAddress = "http://172.30.68.237/products/reviews/darren";

    Button btnCreate;

    ImageView imgTwitter;
    ImageView imgIG;
    ImageView imgFacebook;

    //variable to store ListView
    ListView lv;
    //ArrayLisr to store product list from database
    ArrayList<HashMap<String, String>> productsList;
    // url to get all products list via the php file get_all_productsJson.php
    private static String url_all_products = FirstDarrenStylesFragment.ipBaseAddress+"/get_all_reviewJson.php";
    // products JSONArray to store decoded JSON Array
    JSONArray products = null;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstDarrenStylesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstDarrenStylesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstDarrenStylesFragment newInstance(String param1, String param2) {
        FirstDarrenStylesFragment fragment = new FirstDarrenStylesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_darren_styles, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        btnCreate = (Button) view.findViewById(R.id.btnCreate);
        imgTwitter = (ImageView) view.findViewById(R.id.imgTwitter);
        imgFacebook = (ImageView) view.findViewById(R.id.imgFacebook);
        imgIG = (ImageView) view.findViewById(R.id.imgIG);

        imgTwitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://twitter.com/warriyo");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgFacebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.facebook.com/WarriyoMusic");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        imgIG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Uri uri = Uri.parse("https://www.instagram.com/warriyo");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // ArrayList to store product info in Hashmap for ListView
        productsList = new ArrayList<HashMap<String, String>>();
        // re-usable method to use Volley to retrieve products from database
        postData(url_all_products,null );
        // get resource id of ListView
        lv = (ListView)view.findViewById(R.id.list);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create New Product Activity
                Intent i = new Intent(getActivity(), DarrenStylesReviewActivity.class);
                startActivity(i);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting pid value from selected ListItem
                String pid = ((TextView) view.findViewById(R.id.pid)).getText().toString();
                // Starting new intent
                Intent in = new Intent(getActivity(), EditDarrenStylesActivity.class);
                // sending pid to next activity
                in.putExtra("product_id", pid);
                // starting new activity EditProductActivity
                startActivity(in);
            }
        });
    }

    public void postData(String url, final JSONObject json){
//create a RequestQueue for Volley
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
//define JSONObject Request for http post web request
        JsonObjectRequest json_obj_req = new JsonObjectRequest(
                Request.Method.POST, url, json, new Response.Listener<JSONObject>() {
            @Override
            //response from web request
            public void onResponse(JSONObject response) {
                //method to process the response results in JSONObject from web request
                checkResponse(response, json);
            }

            private void checkResponse(JSONObject response, JSONObject creds) {
                try {
//check the response JSONObject has success == 1
                    if (response.getInt("success") == 1) {
// Get the Array of Products from the received JSONObject
                        products = response.getJSONArray("products");
// looping through All Products in the array
                        for (int i = 0; i < products.length(); i++) {
//get the JSONObject of each product from the array
                            JSONObject c = products.getJSONObject(i);
// Storing each product info in variable
                            String id = c.getString("pid");
                            String username = c.getString("username");
                            String review = c.getString("review");

// creating new HashMap
                            HashMap<String, String> map = new HashMap<String, String>();
// adding each product info to HashMap key => value
                            map.put("product_id", id);
                            map.put("product_username", username);
                            map.put("product_review", review);

// adding map HashList to ArrayList
                            productsList.add(map);
                        }
/**
 * Updating parsed JSON data into ListView by using SimpleAdapter, which links the
 data to the ListView
 * */
                        ListAdapter adapter = new SimpleAdapter(
                                getActivity(), productsList,
                                R.layout.list_item, new String[]{"product_id", "product_username","product_review"},
                                new int[]{R.id.pid,R.id.username, R.id.review});
// updating listview
                        lv.setAdapter(adapter);
                    } else {
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        }, new Response.ErrorListener() {
            @Override
//for any volley network error
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
//execute the JSONObject Request defined above
        requestQueue.add(json_obj_req);
    }

}

