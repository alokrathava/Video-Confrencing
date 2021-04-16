package com.alok.videoconfrencing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.alok.videoconfrencing.databinding.ActivityMainBinding;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private final Context context = this;
    private ActivityMainBinding binding;
    private String meet_id;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater ( ) );
        setContentView ( binding.getRoot ( ) );

        startMeeting ( );

        try {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder ( )
                    .setServerURL ( new URL ( "" ) )
                    .setWelcomePageEnabled ( false )
                    .build ( );
        } catch ( MalformedURLException e ) {
            e.printStackTrace ( );
        }

    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed () {
        super.onBackPressed ( );
        startActivity ( new Intent ( context , SplashScreen.class ) );
    }

    private void startMeeting () {
        meet_id = String.valueOf ( Math.random ( ) );
        Log.e ( TAG , "startMeeting: " + meet_id );
        if (meet_id.length ( ) > 0) {
            JitsiMeetConferenceOptions options
                    = new JitsiMeetConferenceOptions.Builder ( )
                    .setRoom ( meet_id )
                    .build ( );
            JitsiMeetActivity.launch ( context , options );
        }
    }
}
