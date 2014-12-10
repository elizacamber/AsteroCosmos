package com.example.liz.asterocosmos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private TextView achievement_1;
    private TextView achievement_2;
    private TextView achievement_3;
    private TextView achievement_4;
    private TextView achievement_5;
    private TextView achievement_6;
    private TextView achievement_7;
    private TextView achievement_8;
    private TextView achievement_9;
    private TextView achievement_10;
    int flag1_key;
    int flag2_key;
    int flag3_key;
    int flag4_key;
    int flag5_key;
    int flag6_key;
    int flag7_key;
    int flag8_key;
    int flag9_key;
    int flag10_key;

    private final String LOG_TAG = MainActivity.class.getSimpleName();
    public static String contents;
    public static final int KRequsetCode_BARCODE = 2;
    private AchievementsFragment acFragment;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Preferences bucket
        sharedpreferences = this.getSharedPreferences("myachivements", Context.MODE_PRIVATE);

        acFragment = new AchievementsFragment();
        loadSavedPreferences();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, acFragment)
                    .commit();
        }
    }

    //Initialize
    private void loadSavedPreferences() {
        //if (sharedpreferences.contains("flag1_key")) {
        flag1_key = sharedpreferences.getInt("flag1_key", 0);
        flag2_key = sharedpreferences.getInt("flag2_key", 0);
        flag3_key = sharedpreferences.getInt("flag3_key", 0);
        flag4_key = sharedpreferences.getInt("flag4_key", 0);
        flag5_key = sharedpreferences.getInt("flag5_key", 0);
        flag6_key = sharedpreferences.getInt("flag6_key", 0);
        flag7_key = sharedpreferences.getInt("flag7_key", 0);
        flag8_key = sharedpreferences.getInt("flag8_key", 0);
        flag9_key = sharedpreferences.getInt("flag9_key", 0);
        flag10_key = sharedpreferences.getInt("flag10_key", 0);

            /*if (flag1_key == 1) {
                achievement_1.setText(R.string.achievement1_name);
                achievement_1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_forest, 0, 0, 0);
            } else {
                achievement_1.setText(R.string.locked);
                achievement_1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock, 0, 0, 0);
            }
        }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_map) {
            openLocationInMap();
            return true;
        }

        if (id == R.id.action_scan) {
            openQRreader();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openLocationInMap() {
        SharedPreferences sharedPrefs =
                PreferenceManager.getDefaultSharedPreferences(this);
        String location = sharedPrefs.getString(
                getString(R.string.pref_location_key),
                getString(R.string.pref_location_default));


        Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                .appendQueryParameter("q", location)
                .build();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(LOG_TAG, "Couldn't call " + location + ", no receiving apps installed!");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == KRequsetCode_BARCODE) {
            if (resultCode == RESULT_OK) {
                contents = intent.getStringExtra("SCAN_RESULT");
                if (contents.equals("Dasher")) {
                    Intent scan = new Intent(this, Scan_no1.class);
                    startActivity(scan);
                    achievement_1 = (TextView) findViewById(R.id.achievement_1);
                    achievement_1.setText(R.string.achievement1_name);
                    achievement_1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_forest, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag1_key", 1).commit();
                }
                if (contents.equals("Dancer")) {
                    Intent scan = new Intent(this, Scan_no2.class);
                    startActivity(scan);
                    achievement_2 = (TextView) findViewById(R.id.achievement_2);
                    achievement_2.setText(R.string.achievement2_name);
                    achievement_2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_star, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag2_key", 1).commit();
                }
                if (contents.equals("Prancer")) {
                    Intent scan = new Intent(this, Scan_no3.class);
                    startActivity(scan);
                    achievement_3 = (TextView) findViewById(R.id.achievement_3);
                    achievement_3.setText(R.string.achievement3_name);
                    achievement_3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_santa, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag3_key", 1).commit();
                }
                if (contents.equals("Vixen")) {
                    Intent scan = new Intent(this, Scan_no4.class);
                    startActivity(scan);
                    achievement_4 = (TextView) findViewById(R.id.achievement_4);
                    achievement_4.setText(R.string.achievement4_name);
                    achievement_4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_books, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag4_key", 1).commit();
                }
                if (contents.equals("Comet")) {
                    Intent scan = new Intent(this, Scan_no5.class);
                    startActivity(scan);
                    achievement_5 = (TextView) findViewById(R.id.achievement_5);
                    achievement_5.setText(R.string.achievement5_name);
                    achievement_5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_elves, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag5_key", 1).commit();
                }
                if (contents.equals("Cupid")) {
                    Intent scan = new Intent(this, Scan_no6.class);
                    startActivity(scan);
                    achievement_6 = (TextView) findViewById(R.id.achievement_6);
                    achievement_6.setText(R.string.achievement6_name);
                    achievement_6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_box, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag6_key", 1).commit();
                }
                if (contents.equals("Donder")) {
                    Intent scan = new Intent(this, Scan_no7.class);
                    startActivity(scan);
                    achievement_7 = (TextView) findViewById(R.id.achievement_7);
                    achievement_7.setText(R.string.achievement7_name);
                    achievement_7.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_fairies, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag7_key", 1).commit();
                }
                if (contents.equals("Blitzen")) {
                    Intent scan = new Intent(this, Scan_no8.class);
                    startActivity(scan);
                    achievement_8 = (TextView) findViewById(R.id.achievement_8);
                    achievement_8.setText(R.string.achievement8_name);
                    achievement_8.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_skate, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag8_key", 1).commit();
                }
                if (contents.equals("Rudolph")) {
                    Intent scan = new Intent(this, Scan_no9.class);
                    startActivity(scan);
                    achievement_9 = (TextView) findViewById(R.id.achievement_9);
                    achievement_9.setText(R.string.achievement9_name);
                    achievement_9.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_village, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag9_key", 1).commit();
                }
                if (contents.equals("Sugarplum_Mary")) {
                    Intent scan = new Intent(this, Scan_no10.class);
                    startActivity(scan);
                    achievement_10 = (TextView) findViewById(R.id.achievement_10);
                    achievement_10.setText(R.string.achievement10_name);
                    achievement_10.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_chocolate, 0, 0, 0);
                    SharedPreferences.Editor editor=sharedpreferences.edit();
                    editor.putInt("flag10_key", 1).commit();
                }
            }
        }
    }

    public void openQRreader() {
        final String zxing = "com.google.zxing.client.android";
        Intent intent = new Intent(zxing + ".SCAN");
        intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        final PackageManager pManager = this.getPackageManager();
        List resolveInfo = pManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo.size() > 0) {
            startActivityForResult(intent, KRequsetCode_BARCODE);
        } else {
            new AlertDialog.Builder(this).setTitle("Barcode Scanner not installed")
                    .setMessage("Would you like to install Barcode Scanner?")
                    .setPositiveButton("Install", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                String market = "market://details?id=" + zxing;
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(market)));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                String play = "http://play.google.com/store/apps/details?id=" + zxing;
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(play)));
                            }
                        }
                    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
            }).setIcon(android.R.drawable.ic_dialog_alert).show();
        }
    }

}

