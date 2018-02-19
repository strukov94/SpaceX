package com.strukov.spacexlaunches.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.strukov.spacexlaunches.R;
import com.strukov.spacexlaunches.SpaceXApp;
import com.strukov.spacexlaunches.main.adapters.LaunchesAdapter;
import com.strukov.spacexlaunches.media.MediaActivity;
import com.strukov.spacexlaunches.constants.Constants;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemSelectedListener, LaunchesAdapter.OnClickLaunchListener {

    private MainPresenter mPresenter;
    private JsonLaunchesBroadcastReceiver mBroadcastReceiver;
    private RecyclerView mRecyclerLaunches;
    private LaunchesAdapter mLaunchesAdapter;
    private Toolbar mToolbar;
    private Spinner mSpinner;
    private View mViewNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar_main);
        mSpinner = findViewById(R.id.spinner_launch_year);
        mViewNetwork = findViewById(R.id.view_network_conn);

        setSupportActionBar(mToolbar);

        mBroadcastReceiver = new JsonLaunchesBroadcastReceiver();
        mPresenter = SpaceXApp.getApp(this).getMainPresenter();

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.launches, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(this);

        mRecyclerLaunches = findViewById(R.id.rv_launches);
        mLaunchesAdapter = new LaunchesAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerLaunches.setLayoutManager(layoutManager);
        mRecyclerLaunches.setHasFixedSize(true);
        mRecyclerLaunches.setAdapter(mLaunchesAdapter);

        mPresenter.onCreate(this);
    }

    @Override
    public void swapAdapter(Cursor launches) {
        mLaunchesAdapter.swapAdapter(launches);
    }

    @Override
    protected void onResume() {
        IntentFilter intentFilter = new IntentFilter(Constants.BROADCAST_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, intentFilter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (isFinishing()) {
            mPresenter.onDestroy();
            SpaceXApp.getApp(this).releaseMainPresenter();
        }
        super.onDestroy();
    }

    @Override
    public void onNetworkUnavailable() {
        mRecyclerLaunches.setVisibility(View.GONE);
        mViewNetwork.setVisibility(View.VISIBLE);
        Button buttonNetwork = findViewById(R.id.button_network_conn);
        buttonNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPresenter.updateLaunches(mSpinner.getSelectedItem().toString())) {
                    mViewNetwork.setVisibility(View.GONE);
                    mRecyclerLaunches.setVisibility(View.VISIBLE);
                }
            }
        });

        Snackbar.make(findViewById(R.id.main_layout), R.string.network_unavailable, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mPresenter.updateLaunches(getResources().getStringArray(R.array.launches)[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClickLaunch(String[] links) {
        Intent intent = new Intent(this, MediaActivity.class);
        intent.putExtra(Constants.LAUNCH_ARTICLE_LINK, links[0]);
        intent.putExtra(Constants.LAUNCH_VIDEO_LINK, links[1]);
        startActivity(intent);
    }

    private class JsonLaunchesBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            mPresenter.onReceive(intent.getStringExtra(Constants.EXTENDED_JSON));
        }
    }
}
