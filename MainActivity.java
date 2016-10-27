package com.munnasoft.munna.gcat.gcat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MainActivity extends Activity implements View.OnClickListener {
    private WebView webview;
    private WebView webview1;
    String str = "";
    String strr = "";
    String ssr="";
    String flag;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    int flags=0;
    static final int RB=2500;
    @SuppressWarnings("deprecation")
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        webview = (WebView)findViewById(R.id.webView1);
        webview1 = (WebView)findViewById(R.id.webView2);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        webview.setWebChromeClient(new WebChromeClient());
        webview1.setWebChromeClient(new WebChromeClient());
        WebViewClient client = new ChildBrowserClient();
        webview.setWebViewClient(client);
        webview1.setWebViewClient(client);
        WebSettings settings = webview.getSettings();
        WebSettings settings1 = webview1.getSettings();
        settings.setJavaScriptEnabled(true);
        settings1.setJavaScriptEnabled(true);
        webview.setInitialScale(1);
        webview.getSettings().setUseWideViewPort(true);
        webview1.setInitialScale(1);
        webview1.getSettings().setUseWideViewPort(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setBuiltInZoomControls(true);
        settings.setPluginState(PluginState.ON);
        settings.setDomStorageEnabled(true);
        settings1.setJavaScriptCanOpenWindowsAutomatically(false);
        settings1.setBuiltInZoomControls(true);
        settings1.setPluginState(PluginState.ON);
        settings1.setDomStorageEnabled(true);
        webview.loadUrl("http://www.gpsvisualizer.com/draw");
        //webview.loadUrl("http://www.gpsvisualizer.com/draw/download_file.php?file=392830203-90323.txt&download=1");
        webview.setInitialScale(0);
        webview.requestFocus();
        webview.requestFocusFromTouch();
        webview1.setInitialScale(0);
        webview1.requestFocus();
        webview1.requestFocusFromTouch();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        webview1.setVisibility(View.INVISIBLE);
        webview.setVisibility(View.VISIBLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {

        int id=v.getId();
        switch(id) {
            case R.id.button1:
                webview.loadUrl("http://www.gpsvisualizer.com/draw");
                webview.setInitialScale(0);
                webview.requestFocus();
                webview.requestFocusFromTouch();
                Toast.makeText(MainActivity.this, "Cache Cleared", Toast.LENGTH_SHORT).show();
                    webview.setVisibility(View.VISIBLE);
                    webview1.setVisibility(View.INVISIBLE);
                break;
            case R.id.button2:

                if(flags==0){
                    webview1.setVisibility(View.VISIBLE);
                    webview.setVisibility(View.INVISIBLE);
                    flags=1;
                }else if(flags==1){
                    webview.setVisibility(View.VISIBLE);
                    webview1.setVisibility(View.INVISIBLE);
                    flags=0;
                }
                break;
            case R.id.button3:
                String ss = btn3.getText().toString();
                if (ss.equals("ON")) {
                    Toast.makeText(MainActivity.this, "Tractor OFF Commad", Toast.LENGTH_SHORT).show();
                    btn3.setText("OFF");
                } else if (ss.equals("OFF")) {
                    Toast.makeText(MainActivity.this, "Tractor ON Commad", Toast.LENGTH_SHORT).show();
                    btn3.setText("ON");
                }
                break;
            case R.id.button4:
                String rr = btn4.getText().toString();
                if (rr.equals("OFF")) {
                    Toast.makeText(MainActivity.this, "Tractor TILLING State", Toast.LENGTH_SHORT).show();
                    btn4.setText("TILL");
                } else if (rr.equals("TILL")) {
                    Toast.makeText(MainActivity.this, "Tractor SOWING State", Toast.LENGTH_SHORT).show();
                    btn4.setText("SOW");
                } else if (rr.equals("SOW")) {
                    Toast.makeText(MainActivity.this, "Tractor idle State", Toast.LENGTH_SHORT).show();
                    btn4.setText("OFF");
                }
                break;
            case R.id.button5:

                Toast.makeText(MainActivity.this, "Data Binded", Toast.LENGTH_SHORT).show();
                try {
                    String rs="";
                    str="";
                    String fq1="";
                    String mf1="";
                    strr="";
                     fq1 = "/Mytractor/GPSdata.gpx" ;
                    mf1 = Environment.getExternalStorageDirectory() + fq1;
                    FileInputStream file = new FileInputStream(mf1);
                    InputStreamReader ir = new InputStreamReader(file);
                    char[] inputbuffer = new char[RB];

                    int chR;
                    while ((chR = ir.read(inputbuffer)) > 0) {
                        //char to String Conversion
                        rs = String.copyValueOf(inputbuffer, 0, chR);
                        str += rs;
                    }
                    ir.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ssr="";
                token();
               String bt33= btn3.getText().toString();
                String bt44=btn4.getText().toString();
                String t=" ";
                ssr +=t+"brk:";
                ssr+="_";
                ssr+=bt33;
                ssr+="_";
                ssr+="\n"+t;
                ssr+="_";
                ssr+=bt44;
                ssr+="_";
                ssr+="\n"+t;
                ssr +=strr;
                ssr +="\n"+t;
                if (bt44.equals("SOW")||bt44.equals("TILL")) {
                    btn4.setText("OFF");
                    String bt444= btn4.getText().toString();
                    ssr+="_";
                    ssr+=bt444;
                    ssr+="_";
                    ssr+="\n"+t;
                }else{
                    String bt444= btn4.getText().toString();
                    ssr+="_";
                    ssr+=bt444;
                    ssr+="_";
                    ssr+="\n"+t;
                }
                if (bt33.equals("ON")) {
                     btn3.setText("OFF");
                    String bt333= btn3.getText().toString();
                    ssr+="_";
                    ssr+=bt333;
                    ssr+="_brk:";
                   }else{
                    String bt333= btn3.getText().toString();
                    ssr+="_";
                    ssr+=bt333;
                    ssr+="_brk:";
                }
                Toast.makeText(MainActivity.this, ssr, Toast.LENGTH_LONG).show();
                    break;
            case R.id.button6:
                webview1.setVisibility(View.VISIBLE);
                webview.setVisibility(View.INVISIBLE);
               webview1.loadUrl("http://data.sparkfun.com/input/o81GAKqy6WI5VXpZA8r7/clear?private_key=yzRBMXN7JyUBP6nYW9ox");
                new CountDownTimer(5000, 1000) {
                    public void onFinish() {
                        webview1.loadUrl("http://data.sparkfun.com/input/o81GAKqy6WI5VXpZA8r7?private_key=yzRBMXN7JyUBP6nYW9ox&_data_t="+ssr);
                        Toast.makeText(MainActivity.this,"Sending to Tractor..."+ssr,Toast.LENGTH_SHORT).show();
                    }
                    public void onTick(long millisUntilFinished) {
                    }
                }.start();
                break;
            default:
                break;
        }
    }

    private void token() {
        StringTokenizer h1 = new StringTokenizer(str, "s");
        int ar = 0;
        String toke1 = "";
        while (h1.hasMoreTokens()) {
            toke1 = h1.nextToken();
            ar = ar + 1;
            if (ar == 16) {
                String s=toke1;
                String[] sp=s.split(String.valueOf('"'));
                strr="";
                int ax=0;
                for(int i=0;i<sp.length;i++) {
                    if (i% 2 == 1){
                        strr += sp[i];
                        ax=ax+1;
                        if(ax!=2)
                        strr +=",";
                        if(ax==2) {
                            strr += "?";
                            ax=0;
                        }
                    }


                }
//                StringTokenizer h11 = new StringTokenizer(toke1,"t=");
//                int alr = 0;
//                String toke2 = "";
//                strr="";
//                StringTokenizer h111 = new StringTokenizer(toke1,"n=");
//                int allr = 0;
//                String toke3 = "";
//                strr="";
//                while (h111.hasMoreTokens()) {
//                    toke2 = h11.nextToken();
//                    alr = alr + 1;
//                    if(alr%2!=1)
//                    strr += toke2;
//                    allr = allr + 1;
//                    toke3=h111.nextToken();
//                    if(alr%2!=1)
//                        strr += toke3;
//                }
            }
        }
    }
    void deleteExternalStoragePrivateFile() {
        // Get path for the file on external storage.  If external
        // storage is not currently mounted this will fail.
         //  for (int i=1;i<4;i++) {
               String f1 = "/Mytractor/GPSdata.txt";
               String f2 = "/Mytractor/GPSdata.gpx";
               String f3 = "/Mytractor/GPSdata.kml";
               String mf1 = Environment.getExternalStorageDirectory() +f1;
               String mf2= Environment.getExternalStorageDirectory() +f2;
               String mf3= Environment.getExternalStorageDirectory() +f3;
               File file1 = new File(mf1);
               Boolean ff1 = file1.delete();
               File file2 = new File(mf2);
               Boolean ff2 = file2.delete();
               File file3 = new File(mf3);
               Boolean ff3 = file3.delete();
               if (ff1||ff2||ff3) {
                   Toast.makeText(MainActivity.this, "GPSdata Deleting..", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(MainActivity.this, "GPSdata Not Found", Toast.LENGTH_SHORT).show();
               }
         //  }
    }
    /**
     * The webview client receives notifications about appView
     */
    public class ChildBrowserClient extends WebViewClient {

        @SuppressLint("InlinedApi")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            boolean value = true;
           // url = "http://www.gpsvisualizer.com/draw/download_file.php?file=392830203-90323.txt&download=1";
            StringTokenizer h = new StringTokenizer(url, "&");
            int aa=0;
            while (h.hasMoreTokens()) {
                String token = h.nextToken();
                aa=aa+1;
                if (aa == 1) {
                    StringTokenizer m = new StringTokenizer(token, "=");
                    int aaa = 0;
                    while (m.hasMoreTokens()) {
                        String token1 = m.nextToken();
                        aaa = aaa + 1;
                        if (aaa == 2) {
                            StringTokenizer hh = new StringTokenizer(token1, ".");
                            int aaaa = 0;
                            while (hh.hasMoreTokens()) {
                                String token2 = hh.nextToken();
                                aaaa = aaaa + 1;
                                if (aaaa == 2) {
                                    try {
                                        deleteExternalStoragePrivateFile();

                                    } catch (Exception e) {
                                        Toast.makeText(MainActivity.this, "No data found..", Toast.LENGTH_SHORT).show();
                                    }
                                    flag = token2;
                                    DownloadManager mdDownloadManager = (DownloadManager) MainActivity.this
                                            .getSystemService(Context.DOWNLOAD_SERVICE);
                                    DownloadManager.Request request = new DownloadManager.Request(
                                            Uri.parse(url));
                                    //		File destinationFile = new File(
                                    //		Environment.getExternalStorageDirectory(),getFileName(url));
                                    request.setDescription("GPS Data Downloading...");
                                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                    //		request.setDestinationUri(Uri.fromFile(destinationFile));
                                    request.setDestinationInExternalPublicDir("/Mytractor","GPSdata."+flag);
                                    Toast.makeText(MainActivity.this, "\t\t   Downloading..\n" +"GPSdata."+flag, Toast.LENGTH_SHORT).show();
                                    mdDownloadManager.enqueue(request);
                                    value = false;
                                }}}}}}
                if (value) {
                    view.loadUrl(url);
                }

            return value;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
        /**
         * Notify the host application that a page has started loading.  
         *
         * @param view
         *      The webview initiating the callback.  
         * @param url
         *      The url of the page.  
         */
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
    }



}