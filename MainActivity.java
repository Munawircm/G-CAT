package com.munnasoft.munna.gcat.gcat;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
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
    String ss ="OFF";
    String rr = "OFF";
    String flag;
    int bnd=1;
    ImageView btn1;
    ImageView btn2;
    ImageView btn3;
    ImageView btn4;
    ImageView btn5;
    ImageView btn6;
    ImageView btn7;
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
        btn1 = (ImageView)findViewById(R.id.imageView1);
        btn2 = (ImageView)findViewById(R.id.imageView2);
        btn3 = (ImageView)findViewById(R.id.imageView3);
        btn4 = (ImageView)findViewById(R.id.imageView4);
        btn5 = (ImageView)findViewById(R.id.imageView5);
        btn6 = (ImageView)findViewById(R.id.imageView6);
        btn7 = (ImageView)findViewById(R.id.imageView7);
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
        btn7.setOnClickListener(this);
        webview1.setVisibility(View.INVISIBLE);
        webview.setVisibility(View.VISIBLE);
        super.onCreate(savedInstanceState);


    }


    @Override
    public void onClick(View v) {

        int id=v.getId();
        switch(id) {
            case R.id.imageView1:
                webview.loadUrl("http://www.gpsvisualizer.com/draw");
                webview.setInitialScale(0);
                webview.requestFocus();
                webview.requestFocusFromTouch();
                Toast.makeText(MainActivity.this, "Cache Cleared", Toast.LENGTH_SHORT).show();
                    webview.setVisibility(View.VISIBLE);
                    webview1.setVisibility(View.INVISIBLE);
                Animation animation= AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.rotateanti);
                btn1.startAnimation(animation);
                break;
            case R.id.imageView2:

                if(flags==0){
                    webview1.setVisibility(View.VISIBLE);
                    webview.setVisibility(View.INVISIBLE);
                    Animation animation1= AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotateanti1);
                    btn2.startAnimation(animation1);
                    flags=1;
                }else if(flags==1){
                    webview.setVisibility(View.VISIBLE);
                    webview1.setVisibility(View.INVISIBLE);
                    Animation animation3= AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.rotate);
                    btn2.startAnimation(animation3);
                    flags=0;
                }
                break;
            case R.id.imageView3:

                if (ss.equals("ON")) {
                    Toast.makeText(MainActivity.this, "Tractor OFF Commad", Toast.LENGTH_SHORT).show();
                    ss="OFF";
                    Drawable offf=getResources().getDrawable(R.drawable.off);
                    btn3.setImageDrawable(offf);

                } else if (ss.equals("OFF")) {
                    Drawable onn=getResources().getDrawable(R.drawable.onss);
                    ss="ON";
                    btn3.setImageDrawable(onn);
                    Toast.makeText(MainActivity.this, "Tractor ON Commad", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.imageView4:

                if (rr.equals("OFF")) {
                    Toast.makeText(MainActivity.this, "Tractor TILLING State", Toast.LENGTH_SHORT).show();
                    rr="TILL";
                    Drawable till=getResources().getDrawable(R.drawable.tills);
                    btn4.setImageDrawable(till);
                } else if (rr.equals("TILL")) {
                    Toast.makeText(MainActivity.this, "Tractor SOWING State", Toast.LENGTH_SHORT).show();
                    rr="SOW";
                    Drawable sow=getResources().getDrawable(R.drawable.sow);
                    btn4.setImageDrawable(sow);
                } else if (rr.equals("SOW")) {
                    Toast.makeText(MainActivity.this, "Tractor idle State", Toast.LENGTH_SHORT).show();
                    rr="OFF";
                    Drawable off=getResources().getDrawable(R.drawable.offs);
                    btn4.setImageDrawable(off);
                }
                break;
            case R.id.imageView5:

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
               String bt33= ss;
                String bt44=rr;
                String t=" ";
                ssr +=t+"brk:";
                ssr+="_";
                ssr+=ss;
                ssr+="_";
                ssr+="\n"+t;
                ssr+="_";
                ssr+=rr;
                ssr+="_";
                ssr+="\n"+t;
                ssr +=strr;
                ssr +="\n"+t;
                if (bt44.equals("SOW")||bt44.equals("TILL")) {
                    rr="OFF";
                    Drawable off=getResources().getDrawable(R.drawable.offs);
                    btn4.setImageDrawable(off);
                    String bt444= rr;
                    ssr+="_";
                    ssr+=bt444;
                    ssr+="_";
                    ssr+="\n"+t;
                }else{
                    String bt444= rr;
                    ssr+="_";
                    ssr+=bt444;
                    ssr+="_";
                    ssr+="\n"+t;
                }
                if (bt33.equals("ON")) {
                    Drawable offf=getResources().getDrawable(R.drawable.off);
                    btn3.setImageDrawable(offf);
                     ss="OFF";
                    String bt333=ss;
                    ssr+="_";
                    ssr+=bt333;
                    ssr+="_brk:";
                   }else{
                    String bt333=ss;
                    ssr+="_";
                    ssr+=bt333;
                    ssr+="_brk:";
                }

                if(bnd==1) {
                    Drawable bn=getResources().getDrawable(R.drawable.bind2);
                    btn5.setImageDrawable(bn);
                    bnd=0;
                    Toast.makeText(MainActivity.this, "Data Binded", Toast.LENGTH_SHORT).show();

                    Toast.makeText(MainActivity.this, ssr, Toast.LENGTH_LONG).show();

                }else if(bnd==0){
                Drawable bn1=getResources().getDrawable(R.drawable.bind);
                    Toast.makeText(MainActivity.this, "Data UnBinded", Toast.LENGTH_SHORT).show();
                    ssr="";
                btn5.setImageDrawable(bn1);
                    bnd=1;
                 }

                    break;
            case R.id.imageView6:
                Toast.makeText(MainActivity.this, "Getting Current Tractor Location", Toast.LENGTH_SHORT).show();
                ImageView imgView1 = (ImageView)findViewById(R.id.imageView9);
                imgView1.setVisibility(ImageView.VISIBLE);
                imgView1.setBackgroundResource(R.drawable.frmr);

                AnimationDrawable frameAnimation1 =
                        (AnimationDrawable) imgView1.getBackground();
                frameAnimation1.stop();
                frameAnimation1.start();
                  break;
            case R.id.imageView7:
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
                ImageView imgView = (ImageView)findViewById(R.id.imageView8);
                imgView.setVisibility(ImageView.VISIBLE);
                imgView.setBackgroundResource(R.drawable.frms);

                AnimationDrawable frameAnimation =
                        (AnimationDrawable) imgView.getBackground();
                                 frameAnimation.stop();
                                frameAnimation.start();

//                btn7.setBackgroundResource(R.drawable.frms);
//                AnimationDrawable fsend=(AnimationDrawable) btn7.getBackground();
//                fsend.start();
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
            int aa = 0;
            while (h.hasMoreTokens()) {
                String token = h.nextToken();
                aa = aa + 1;
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
                                    request.setDestinationInExternalPublicDir("/Mytractor", "GPSdata." + flag);
                                    Toast.makeText(MainActivity.this, "\t\t   Downloading..\n" + "GPSdata." + flag, Toast.LENGTH_SHORT).show();
                                    mdDownloadManager.enqueue(request);
                                    value = false;
                                }
                            }
                        }
                    }
                }
            }
            if (value) {
                view.loadUrl(url);
            }

            return value;
        }

    }}
