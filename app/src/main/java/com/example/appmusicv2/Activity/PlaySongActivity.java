package com.example.appmusicv2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmusicv2.Adapter.ViewPagerPlayListSong;
import com.example.appmusicv2.Fragment.Fragment_Play_Song;
import com.example.appmusicv2.Fragment.Fragment_disk;
import com.example.appmusicv2.Model.Song;
import com.example.appmusicv2.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class PlaySongActivity extends AppCompatActivity {

    Toolbar toolbarplay;
    TextView txtTimesong, txtTotalSong;
    ImageView imgPrview, imgNext, imgRepeat, imgPlay, imgRandom;
    SeekBar seekBar;
    ViewPager viewPager;

    public static ArrayList<Song> arrayList_song = new ArrayList<>();
    public static ViewPagerPlayListSong adapterPlaySong;

    Fragment_disk fragment_disk;
    Fragment_Play_Song fragment_play_song;
    MediaPlayer mediaPlayer;
    int position = 0;
    boolean repeat = false;
    boolean checkRandom = false;
    boolean next = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        GetDataIntent();
        init();
        eventClick();
    }

    private void eventClick() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               if (adapterPlaySong.getItem(1) != null) {
                   if (arrayList_song.size() > 0) {
                       fragment_disk.PlaySong(arrayList_song.get(0).getImgSong());
                       handler.removeCallbacks(this);
                   }else {
                       handler.postDelayed(this, 300);
                   }
               }
            }
        }, 500);
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imgPlay.setImageResource(R.drawable.iconplay);
                }else {
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.iconpause);
                }
            }
        });
        imgRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeat == false) {
                    if ( checkRandom == true ) {
                        checkRandom = false;
                        imgRepeat.setImageResource(R.drawable.iconsyned);
                        imgRandom.setImageResource(R.drawable.iconsuffle);
                    }
                    imgRepeat.setImageResource(R.drawable.iconsyned);
                    repeat = true;
                }else {
                    imgRepeat.setImageResource(R.drawable.iconrepeat);
                    repeat = false;
                }
            }
        });

        imgRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkRandom == false) {
                    if ( repeat == true ) {
                        repeat = false;
                        imgRepeat.setImageResource(R.drawable.iconrepeat);
                        imgRandom.setImageResource(R.drawable.iconshuffled);
                    }
                    imgRandom.setImageResource(R.drawable.iconshuffled);
                    checkRandom = true;
                }else {
                    imgRandom.setImageResource(R.drawable.iconsuffle);
                    checkRandom = false;
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( arrayList_song.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer!= null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (position < arrayList_song.size()) {
                        imgPlay.setImageResource(R.drawable.iconpause);
                        position++;
                        if (repeat == true) {
                            if ( position == 0) {
                                position = arrayList_song.size();
                            }
                            position -= 1;
                        }
                        if (checkRandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(arrayList_song.size());
                            if (index == position) {
                                position = index - 1 ;
                            }
                            position = index;
                        }
                        if ( position > arrayList_song.size()) {
                            position = 0;
                        }
                        new PlayMp3().execute(arrayList_song.get(position).getLinkSong());
                        fragment_disk.PlaySong(arrayList_song.get(position).getImgSong());
                        getSupportActionBar().setTitle(arrayList_song.get(position).getNameSong());
                        UpdateTime();
                    }
                }
                imgNext.setClickable(false);
                imgPrview.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgNext.setClickable(true);
                        imgPrview.setClickable(true);
                    }
                }, 5000);
            }
        });
        imgPrview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( arrayList_song.size() > 0) {
                    if (mediaPlayer.isPlaying() || mediaPlayer!= null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if (position < arrayList_song.size()) {
                        imgPlay.setImageResource(R.drawable.iconpause);
                        position--;
                        if (repeat == true) {
                            if ( position == 0) {
                                position = arrayList_song.size();
                            }
                            position -= 1;
                        }
                        if (checkRandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(arrayList_song.size());
                            if (index == position) {
                                position = index - 1 ;
                            }
                            position = index;
                        }
                        new PlayMp3().execute(arrayList_song.get(position).getLinkSong());
                        fragment_disk.PlaySong(arrayList_song.get(position).getImgSong());
                        getSupportActionBar().setTitle(arrayList_song.get(position).getNameSong());
                        UpdateTime();
                    }
                }
                imgNext.setClickable(false);
                imgPrview.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgNext.setClickable(true);
                        imgPrview.setClickable(true);
                    }
                }, 5000);
            }
        });
    }

    private void GetDataIntent() {
        Intent intent = getIntent();
        arrayList_song.clear();
        if (intent != null)
        {
            if (intent.hasExtra("song")) {
                Song song = intent.getParcelableExtra("song");
                arrayList_song.add(song);
            }
            if (intent.hasExtra("list_song")) {
                ArrayList<Song> array_song = intent.getParcelableArrayListExtra("list_song");
                for (int i = 0; i < array_song.size(); i++) {
                    arrayList_song = array_song;
                }
            }
        }

    }

    private void init() {
        toolbarplay = findViewById(R.id.toobarPlaySong);
        txtTimesong = findViewById(R.id.textviewTimeSong);
        txtTotalSong = findViewById(R.id.textviewTotalTime);
        seekBar = findViewById(R.id.seekbarPlaySong);
        imgRandom = findViewById(R.id.imageRandom);
        imgRepeat = findViewById(R.id.imageReplay);
        imgPrview = findViewById(R.id.imagePreview);
        imgPlay = findViewById(R.id.imagePlay);
        imgNext = findViewById(R.id.imageNext);
        viewPager = findViewById(R.id.viewPagerPlaySong);
        setSupportActionBar(toolbarplay);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play Song");
        toolbarplay.setTitleTextColor(Color.WHITE);
        toolbarplay.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                mediaPlayer.stop();
                arrayList_song.clear();
            }
        });
        adapterPlaySong = new ViewPagerPlayListSong(getSupportFragmentManager());
        fragment_disk = new Fragment_disk();
        fragment_play_song = new Fragment_Play_Song();
        adapterPlaySong.AddFragment(fragment_play_song);
        adapterPlaySong.AddFragment(fragment_disk);
        viewPager.setAdapter(adapterPlaySong);
        fragment_disk = (Fragment_disk) adapterPlaySong.getItem(1);
        if (arrayList_song.size() > 0) {
            getSupportActionBar().setTitle(arrayList_song.get(0).getNameSong());
            new PlayMp3().execute(arrayList_song.get(0).getLinkSong());
            imgPlay.setImageResource(R.drawable.iconpause);
        }
    }

    class PlayMp3 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String song) {
            super.onPostExecute(song);
            try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });
                mediaPlayer.setDataSource(song);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
            UpdateTime();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTotalSong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void UpdateTime() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtTimesong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this, 300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            next = true;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }, 300);
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (next == true) {
                    if (position < arrayList_song.size()) {
                        imgPlay.setImageResource(R.drawable.iconpause);
                        position++;
                        if (repeat == true) {
                            if ( position == 0) {
                                position = arrayList_song.size();
                            }
                            position -= 1;
                        }
                        if (checkRandom == true) {
                            Random random = new Random();
                            int index = random.nextInt(arrayList_song.size());
                            if (index == position) {
                                position = index - 1 ;
                            }
                            position = index;
                        }
                        if ( position > arrayList_song.size()) {
                            position = 0;
                        }
                        new PlayMp3().execute(arrayList_song.get(position).getLinkSong());
                        fragment_disk.PlaySong(arrayList_song.get(position).getImgSong());
                        getSupportActionBar().setTitle(arrayList_song.get(position).getNameSong());
                    }

                imgNext.setClickable(false);
                imgPrview.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgNext.setClickable(true);
                        imgPrview.setClickable(true);
                    }
                }, 5000);
                next = false;
                handler1.removeCallbacks(this);
                }else {
                    handler1.postDelayed(this, 1000);

                }
            }
        }, 1000);
    }
}
