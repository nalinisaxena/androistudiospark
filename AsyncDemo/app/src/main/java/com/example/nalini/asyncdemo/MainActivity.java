package com.example.nalini.asyncdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog=new ProgressDialog(MainActivity.this);

        progressDialog.setMessage("A Message");

        progressDialog.setIndeterminate(true);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog.setCancelable(true);

        final DownloadTask downloadTask=new DownloadTask(MainActivity.this);
        downloadTask.execute("https://pdfbookforus.files.wordpress.com/2016/11/five-point-someone-chetan-bhagat_ebook.pdf");

        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

                downloadTask.cancel(true);
            }
        });
    }


    public class DownloadTask extends AsyncTask<String,Integer,String>

    {

        private Context context;
        private PowerManager.WakeLock mWakeLock;


        public DownloadTask(Context context)
        {
            this.context=context;

        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            PowerManager pm=(PowerManager)context.getSystemService(Context.POWER_SERVICE);

            mWakeLock=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,getClass().getName());

            mWakeLock.acquire();

            progressDialog.show();


        }

        @Override
        protected String doInBackground(String... params)
        {
            InputStream input=null;
            OutputStream output=null;
            HttpURLConnection connection=null;

           try {
               URL url = new URL(params[0]);
               connection = (HttpURLConnection) url.openConnection();
               connection.connect();

               if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                   return "Server returned Http " + connection.getResponseCode() + " " + connection.getResponseMessage();
               }

               int fileLength = connection.getContentLength();

               input = connection.getInputStream();

               output = new FileOutputStream("/data/local/novel.pdf");

               byte data[] = new byte[4096];

               long total = 0;

               int count;

               while ((count = input.read(data)) != -1) {
                   if (isCancelled()) {
                       input.close();
                       return null;
                   }
                   total += count;

                   if (fileLength > 0) {
                       publishProgress((int) (total * 100 / fileLength));

                       output.write(data, 0, count);
                   }

               }
           }

               catch(Exception e)
               {
                   return e.toString();
               }

               finally {

               try
               {
                   if(output!=null)

                       output.close();

                   if(input !=null)
                       input.close();


               }

               catch (IOException ioe)
               {

               }

               if(connection!=null)

                   connection.disconnect();
           }

            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {

            progressDialog.setIndeterminate(false);

            progressDialog.setMax(100);

            progressDialog.setProgress(values[0]);

            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {

            mWakeLock.release();

            super.onPostExecute(result);

            progressDialog.dismiss();

            if(result!=null)

                Toast.makeText(MainActivity.this,"Download error"+result,Toast.LENGTH_LONG).show();

            else

                Toast.makeText(MainActivity.this,"File Downloaded",Toast.LENGTH_SHORT).show();


        }
    }
}
