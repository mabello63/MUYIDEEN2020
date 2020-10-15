package com.example.Gads2020Project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    Toolbar mToolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome );
        mToolbar = findViewById( R.id.toolbar );
        mToolbar.getOverflowIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.DST);
        setSupportActionBar(mToolbar  );

    }
    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar( toolbar );
    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate( R.menu.new_menu, menu );
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            switch (item.getItemId()) {
                case R.id.About:
                    startActivity( new Intent( this, ActivityAbout.class ) );
                    return true;
                case R.id.leaders_board:
                    startActivity( new Intent( this, LeaderBoardActivity.class ) );
                    return true;
                case R.id.menuSubmit:
                    startActivity( new Intent( this, SubmitActivity.class ) );
                    return true;
                                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }
