package com.example.secondapphelloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

public class TestActivity02 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test02);


        Button buttonND = findViewById(R.id.button_NewData); // get by id the button
         buttonND.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show(); //test button w/ toast
                 String url="https://antiabbandono.herokuapp.com/api/v0/getAllarme"; //url2
                 GetDataFromUrl2(url);
             }
         });

    }

    private void GetDataFromUrl2(String url){
        RecyclerView RViewF1 = findViewById(R.id.RecycleList1); // get by id the recyclerview from f1
      //  TextView textChild = (TextView) RViewF1.getChildAt(0);
        TextView t = findViewById(R.id.textView3);
        RequestQueue queue = Volley.newRequestQueue(this);      // Instantiate the RequestQueue.
        queue.start();
/*
// Request a string response from the provided URL. ----------------------------------
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       Toast.makeText(getApplicationContext(),response.get,Toast.LENGTH_LONG);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"That didn't work!",Toast.LENGTH_LONG);
            }
        });

        queue.add(stringRequest);       // Add the request to the RequestQueue.
*/
/*
//JSON obj request POST ----------------------------------
        JsonObjectRequest jobReq = new JsonObjectRequest(Request.Method.POST, url, jObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });

        queue.add(jobReq);*/

        //Json obj GET from url2 for recyclerview
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //translate JSON to data
                    try {
                        JSONObject data= response.getJSONObject("type");
                        t.setText(data.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Error! request fail", Toast.LENGTH_LONG).show();
                }
            });

        queue.add(jsonObjectRequest);
    }

}

   /* private void jsonParse(){
        String url ="url2";
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("args");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //toast error
            }
        });
    }*/
