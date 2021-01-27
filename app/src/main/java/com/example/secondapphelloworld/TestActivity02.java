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

public class TestActivity02 extends AppCompatActivity {
   // private RecyclerView mTextViewResult;
  //  private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test02);

    //    mTextViewResult = findViewById(R.id.RecycleList1); // get by id the recycleview from f1
        Button buttonND = findViewById(R.id.button_NewData); // get by id the button
         buttonND.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show(); //test button w/ toast
                 String url="https://antiabbandono.herokuapp.com/api/v0/getAllarme";
                 GetDataFromUrl2(url);
             }
         });

    }

    private void GetDataFromUrl2(String url){
        RecyclerView textView= findViewById(R.id.RecycleList1); // get by id the recycleview from f1
        View textChild = textView.getChildAt(0);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

/*
// Request a string response from the provided URL.
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

// Add the request to the RequestQueue.
        queue.add(stringRequest);
*/


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
                //TODO error toast here
            }
        });
    }*/
