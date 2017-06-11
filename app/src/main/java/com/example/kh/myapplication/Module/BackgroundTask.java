package com.example.kh.myapplication.Module;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kh on 6/11/2017.
 */

public class BackgroundTask  {
    private List<Contact> list = new ArrayList<Contact>();
    private String url = "http://192.168.1.12/DuLieu/josn.php";
    private static Context context;
    public  BackgroundTask(Context mcontext){
        Onattach(mcontext);
    }
    public static   void Onattach(Context mcontext){
       context  =mcontext;
    }

    public static void OnDetach(){
        context =null;
    }
    public List<Contact> getlist(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, new Response.Listener<JSONArray>() {
            public static final String TAG ="vvvvvvvvvvvv" ;

            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                Log.i(TAG, "onResponse: "+"aa");
                while (count<response.length()){
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Contact contact = new Contact(jsonObject.getString("Name"),jsonObject.getString("Email"),jsonObject.getString("Phone"));
                        list.add(contact);
                        count++;
                    } catch (JSONException e) {

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getMySingleton(context).AddVolley(jsonArrayRequest);
        return list;
    }

}
