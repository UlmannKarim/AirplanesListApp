package com.example.airplanelist;



import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiParser extends AsyncTask<Void, Void, Void> {

    ProgressDialog progress;
    String link;
    Boolean success;
    String extractedWords;
    Context context;
    TextView targetTextView;

    //constructor
    protected WikiParser(Context context, String url, TextView targetTextView){
        link=url;
        this.context=context;
        this.targetTextView=targetTextView;
        progress=new ProgressDialog(context);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress.show();
    }

    @Override
    protected Void doInBackground(Void... input) {
        try {
            Connection.Response response = Jsoup.connect(link)
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .timeout(4000)
                    .ignoreHttpErrors(true)
                    .execute();

                success = true;
                Document doc = Jsoup.connect(link).get();
                org.jsoup.select.Elements allPars = doc.select(".mw-content-ltr p");
                Elements targetPar = allPars.eq(1);
                extractedWords = targetPar.text();
                } catch (IOException ex) {
            ex.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void ans) {
        progress.dismiss();
            targetTextView.setText(extractedWords);
    }

}