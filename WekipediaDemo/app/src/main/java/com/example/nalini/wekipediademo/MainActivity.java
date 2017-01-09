package com.example.nalini.wekipediademo;

import android.os.AsyncTask;
import android.os.Build;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText etxSearch;
    private ProgressBar progressBar;
    private TextView txtWekipedia;
    private Button btnFatch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etxSearch=(EditText)findViewById(R.id.etxSearch);

        progressBar=(ProgressBar)findViewById(R.id.progressbar);

        txtWekipedia=(TextView)findViewById(R.id.txtwikidata);

        btnFatch=(Button)findViewById(R.id.btnSearch);

        btnFatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  String keyword= etxSearch.getText().toString();

                String WIKIPEDIA_URL = "https://en.wikipedia.org/w/api.php?action=query&titles=" +
                        keyword +
                        "&prop=revisions&rvprop=content&format=json&prop=extracts";

                FetchWekiDataAsych fetchWekiDataAsych=new FetchWekiDataAsych();

                fetchWekiDataAsych.execute(WIKIPEDIA_URL);
            }
        });
    }

    private class FetchWekiDataAsych extends AsyncTask<String,Void,String>

    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressBar.setVisibility(View.VISIBLE);

            Toast.makeText(MainActivity.this,"fetching data,pls wait",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String[] params) {

            try
            {
                String sUrl=params[0];

                URL url=new URL(sUrl);

                HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");

                urlConnection.connect();


                InputStream inputStream=urlConnection.getInputStream();

                InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");

                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

                StringBuilder stringBuilder=new StringBuilder();

                String line;

                while ((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line);
                }


               String wikidata= stringBuilder.toString();

                String formattedData=parseJSONData(wikidata);

                return formattedData;

            }

            catch (IOException io)
            {
              io.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(String formattedData) {
            super.onPostExecute(formattedData);

            progressBar.setVisibility(View.GONE);

            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
            {
                txtWekipedia.setText(Html.fromHtml(formattedData,Html.FROM_HTML_MODE_LEGACY));

            }

            else
            {
                txtWekipedia.setText(Html.fromHtml(formattedData));
            }
        }
    }


    private String parseJSONData(String wikidata)
    {
        try
        {
            JSONObject rootJson=new JSONObject(wikidata);

            JSONObject query = rootJson.getJSONObject("query");
            JSONObject pages = query.getJSONObject("pages");
            JSONObject number = pages.getJSONObject(pages.keys().next());
            String formattedData = number.getString("extract");

            return formattedData;
        }

        catch(JSONException json)
        {
            json.printStackTrace();

        }
        return null;

    }
}
