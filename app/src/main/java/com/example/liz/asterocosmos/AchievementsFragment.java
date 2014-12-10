package com.example.liz.asterocosmos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by eliza on 8/12/2014.
 */
public class AchievementsFragment extends Fragment {

/*for starting the details activity onClick */
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

    public AchievementsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.achievements_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        achievement_1 = (TextView) rootView.findViewById(R.id.achievement_1);
        achievement_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_2 = (TextView) rootView.findViewById(R.id.achievement_2);
        achievement_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_3 = (TextView) rootView.findViewById(R.id.achievement_3);
        achievement_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_4 = (TextView) rootView.findViewById(R.id.achievement_4);
        achievement_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_5 = (TextView) rootView.findViewById(R.id.achievement_5);
        achievement_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_6 = (TextView) rootView.findViewById(R.id.achievement_6);
        achievement_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_7 = (TextView) rootView.findViewById(R.id.achievement_7);
        achievement_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_8 = (TextView) rootView.findViewById(R.id.achievement_8);
        achievement_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_9 = (TextView) rootView.findViewById(R.id.achievement_9);
        achievement_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        achievement_10 = (TextView) rootView.findViewById(R.id.achievement_10);
        achievement_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                        .putExtra(Intent.EXTRA_TEXT, ((TextView) v).getText());
                startActivity(intent);
            }
        });

        return rootView;
    }
}
