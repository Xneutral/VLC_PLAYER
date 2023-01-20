package com.example.vlcplayer

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import org.videolan.libvlc.LibVLC
import org.videolan.libvlc.Media
import org.videolan.libvlc.MediaPlayer
import org.videolan.libvlc.media.VideoView
import org.videolan.libvlc.util.VLCVideoLayout

class MainActivity : AppCompatActivity() {

    private lateinit var vlc: VLCVideoLayout
    private lateinit var videoView: VideoView
    private lateinit var libvlc: LibVLC
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setupPlayer()
    }

    private fun setupPlayer() {
        vlc = findViewById(R.id.video_layout)
        videoView = findViewById(R.id.video)
        libvlc = LibVLC(this)
        mediaPlayer = MediaPlayer(libvlc)
        mediaPlayer.attachViews(vlc,null, true,false)
        val url = Uri.parse("https://imob.dunyanews.tv/livehd/_definst_/ngrp:dunyalivehd_2_all/playlist.m3u8")
        val media = Media(libvlc,url)
        mediaPlayer.media = media
        mediaPlayer.play()

    }

    override fun onStart() {
        super.onStart()
        setupPlayer()
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.release()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }
}
