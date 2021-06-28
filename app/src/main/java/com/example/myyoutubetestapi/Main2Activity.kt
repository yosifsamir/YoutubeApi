package com.example.myyoutubetestapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.myyoutubetestapi.model.VideoYT
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.android.youtube.player.internal.d
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T





class Main2Activity : YouTubeBaseActivity() , YouTubePlayer.OnInitializedListener {

    private var youTubeView: YouTubePlayerView? = null
    private val RECOVERY_REQUEST = 1

    private var fullScreen = false
    private var isPlaying: Boolean = false
    private var lastVideo: Int = 0
    private var currentVideoMilisec: Int = 0
    private var video: VideoYT? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
     if (savedInstanceState != null ) {
         fullScreen = savedInstanceState.getBoolean("fullScreen");
         isPlaying = savedInstanceState.getBoolean("isPlaying");
         lastVideo = savedInstanceState.getInt("lastVideo");
         currentVideoMilisec = savedInstanceState.getInt("currentVideoMilisec");
        }



        val title = findViewById<TextView>(R.id.title)
        val description = findViewById<TextView>(R.id.description)
        val channel = findViewById<TextView>(R.id.channel)

        video = intent.getSerializableExtra("Video_details") as VideoYT
        title.setText(video!!.snippet!!.title)
        description.setText(video!!.snippet!!.description)
//        channel.setText(video!!.snippet!!.channelId)

        youTubeView = findViewById(R.id.youtube_view) as YouTubePlayerView
        youTubeView!!.initialize(resources.getString(R.string.youtube_api), this)


    }

    override fun onSaveInstanceState(bundle: Bundle) {
        bundle.putBoolean("fullScreen", fullScreen)
        bundle.putBoolean("isPlaying", isPlaying)
        bundle.putInt("lastVideo", lastVideo)
        bundle.putInt("currentVideoMilisec", currentVideoMilisec)
        super.onSaveInstanceState(bundle)
    }


    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        b: Boolean
    ) {
        player!!.cueVideo(video!!.videoId!!.videoId.toString())
//        player!!.cueVideo("xrYXsWF3t8I")

        player.setOnFullscreenListener(object : YouTubePlayer.OnFullscreenListener {
            override fun onFullscreen(p0: Boolean) {
                fullScreen = b;
                isPlaying = player.isPlaying();
                currentVideoMilisec = player.getCurrentTimeMillis();
            }
        })


//                if (b && isPlaying){
//                    player.loadVideo(playlist.get(lastVideo).getYoutubeLink(),currentVideoMilisec);
//                }

    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        errorReason: YouTubeInitializationResult?
    ) {
        if (errorReason!!.isUserRecoverableError()) {
            errorReason!!.getErrorDialog(this, RECOVERY_REQUEST).show()
        } else {
            val error = String.format("Error", errorReason.toString())
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(resources.getString(R.string.youtube_api), this)
        }
    }

    protected fun getYouTubePlayerProvider(): YouTubePlayer.Provider {
        return this!!.youTubeView!!
    }
}
