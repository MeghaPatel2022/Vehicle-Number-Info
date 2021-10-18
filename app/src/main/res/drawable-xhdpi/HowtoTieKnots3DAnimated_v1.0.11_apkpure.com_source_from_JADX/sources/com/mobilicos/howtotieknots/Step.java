package com.mobilicos.howtotieknots;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.plus.PlusShare;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Step extends Activity implements OnClickListener, OnTouchListener {
    static final int DRAG = 1;
    static final int NONE = 0;
    static final int ZOOM = 2;
    /* access modifiers changed from: private */
    public ArrayList<String> allFrameFiles;
    /* access modifiers changed from: private */
    public ImageView bgImage;
    private BackgroundSound bgSound;
    private TextView counter;
    /* access modifiers changed from: private */
    public int currentFrame = 0;
    private int currentStep = 0;

    /* renamed from: db */
    private SQLiteDatabase f67db;
    private TextView descriptionView;
    private int duration = 150;
    private ImageView extraTechImage;
    private HashMap<Integer, List<Integer>> framesData = new HashMap<>();
    private int ident;
    private InterstitialAd interstitial;
    /* access modifiers changed from: private */
    public Item item;
    private ImageView itemExtraTechImage;
    Matrix matrix = new Matrix();
    PointF mid = new PointF();
    int mode = 0;
    private Cursor myCursor;
    private ImageButton next_button;
    float oldDist = 1.0f;
    private ImageButton preview_button;
    private ImageButton replay_button;
    Matrix savedMatrix = new Matrix();
    private boolean soundStatus;
    PointF start = new PointF();
    private List<HashMap<String, String>> stepsData = new ArrayList();
    private ImageView techImage;
    /* access modifiers changed from: private */
    public Timer timer;
    private TextView title;

    public class BackgroundSound extends AsyncTask<Void, Void, Void> {
        MediaPlayer mMediaPlayer;

        public BackgroundSound() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.mMediaPlayer = MediaPlayer.create(Step.this, C1295R.raw.music);
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            this.mMediaPlayer.setLooping(true);
            this.mMediaPlayer.setVolume(100.0f, 100.0f);
            this.mMediaPlayer.start();
            return null;
        }

        /* access modifiers changed from: protected */
        public void stopMusic() {
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(C1295R.layout.step_info);
        this.ident = getIntent().getIntExtra("ident", 0);
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this);
        dbOpenHelper.createDataBase();
        this.f67db = dbOpenHelper.getReadableDatabase();
        selectItem();
        selectSteps();
        selectFrames();
        this.myCursor.close();
        dbOpenHelper.close();
        this.preview_button = (ImageButton) findViewById(C1295R.C1297id.preview);
        this.next_button = (ImageButton) findViewById(C1295R.C1297id.next);
        this.replay_button = (ImageButton) findViewById(C1295R.C1297id.replay);
        this.counter = (TextView) findViewById(C1295R.C1297id.steps_counter);
        this.title = (TextView) findViewById(C1295R.C1297id.title);
        this.bgImage = (ImageView) findViewById(C1295R.C1297id.img);
        this.itemExtraTechImage = (ImageView) findViewById(C1295R.C1297id.item_extra_tech_img);
        this.techImage = (ImageView) findViewById(C1295R.C1297id.tech_img);
        this.extraTechImage = (ImageView) findViewById(C1295R.C1297id.extra_tech_img);
        this.descriptionView = (TextView) findViewById(C1295R.C1297id.description);
        this.preview_button.setOnClickListener(this);
        this.next_button.setOnClickListener(this);
        this.replay_button.setOnClickListener(this);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        this.duration = Integer.parseInt(sharedPref.getString("speed", Integer.toString(this.duration)));
        this.soundStatus = sharedPref.getBoolean("sound", false);
        float dpWidth = (float) getResources().getDisplayMetrics().widthPixels;
        LayoutParams params = this.bgImage.getLayoutParams();
        params.width = (int) dpWidth;
        params.height = (int) dpWidth;
        this.bgImage.setLayoutParams(params);
        this.itemExtraTechImage.setLayoutParams(params);
        this.techImage.setLayoutParams(params);
        this.extraTechImage.setLayoutParams(params);
        this.title.setText(this.item.name);
        this.bgImage.setOnTouchListener(this);
        if (this.item.is_base == 1) {
            int resId = getResources().getIdentifier("i_" + this.ident + "_eti", "drawable", getPackageName());
            if (resId > 0) {
                this.itemExtraTechImage.setImageResource(resId);
            }
        } else {
            if (new File(Utils.getStoragePath(this), "i_" + this.ident + "_eti" + ".png").exists()) {
                this.itemExtraTechImage.setImageBitmap(BitmapFactory.decodeFile(new File(Utils.getStoragePath(this), "i_" + this.ident + "_eti" + ".png").getAbsolutePath()));
            }
        }
        changeStepContent(0);
        animateStepContent();
        int AppOfTheDayUser = getSharedPreferences("AppOfTheDayUser", 0).getInt("AppOfTheDayUser", -1);
        Log.e("AppOfTheDayUser", "" + AppOfTheDayUser);
        if (AppOfTheDayUser != 1) {
            ((AdView) findViewById(C1295R.C1297id.adView)).loadAd(new Builder().build());
            InterstitialAd interstitialAd = new InterstitialAd(this);
            this.interstitial = interstitialAd;
            this.interstitial.setAdUnitId("ca-app-pub-4372843726984628/1904348594");
            this.interstitial.loadAd(new Builder().build());
        }
    }

    public void displayInterstitial() {
        if (getSharedPreferences("AppOfTheDayUser", 0).getInt("AppOfTheDayUser", -1) != 1 && this.interstitial.isLoaded()) {
            this.interstitial.show();
        }
    }

    private void selectItem() {
        this.myCursor = this.f67db.rawQuery("SELECT id, ident, name, is_base FROM lesson_item WHERE is_active=1 AND ident=" + this.ident, null);
        this.myCursor.moveToFirst();
        this.item = new Item();
        this.item.name = this.myCursor.getString(this.myCursor.getColumnIndex("name")).replace("&amp;", "&").replace("&#39;", "'");
        this.item.f64id = this.myCursor.getInt(this.myCursor.getColumnIndex("id"));
        this.item.ident = this.myCursor.getInt(this.myCursor.getColumnIndex("ident"));
        this.item.is_base = this.myCursor.getInt(this.myCursor.getColumnIndex("is_base"));
    }

    private void selectSteps() {
        this.myCursor = this.f67db.rawQuery("SELECT id, step_number, description, sort_order, frames_count FROM lesson_step WHERE item_id=" + this.item.f64id + " ORDER BY sort_order ASC", null);
        while (this.myCursor.moveToNext()) {
            HashMap<String, String> stepData = new HashMap<>();
            stepData.put("id", "" + this.myCursor.getInt(this.myCursor.getColumnIndex("id")));
            stepData.put("step_number", "" + this.myCursor.getInt(this.myCursor.getColumnIndex("step_number")));
            stepData.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "" + this.myCursor.getString(this.myCursor.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)).replace("&amp;", "&").replace("&#39;", "'").replace("<br />", ""));
            stepData.put("sort_order", "" + this.myCursor.getInt(this.myCursor.getColumnIndex("sort_order")));
            stepData.put("frames_count", "" + this.myCursor.getInt(this.myCursor.getColumnIndex("frames_count")));
            this.stepsData.add(stepData);
        }
    }

    private void selectFrames() {
        this.myCursor = this.f67db.rawQuery("SELECT sort_order, step_id FROM lesson_frame WHERE item_id=" + this.item.f64id + " ORDER BY sort_order ASC", null);
        while (this.myCursor.moveToNext()) {
            if (!this.framesData.keySet().contains(Integer.valueOf(this.myCursor.getInt(this.myCursor.getColumnIndex("step_id"))))) {
                this.framesData.put(Integer.valueOf(this.myCursor.getInt(this.myCursor.getColumnIndex("step_id"))), new ArrayList());
            }
            ((List) this.framesData.get(Integer.valueOf(this.myCursor.getInt(this.myCursor.getColumnIndex("step_id"))))).add(Integer.valueOf(this.myCursor.getInt(this.myCursor.getColumnIndex("sort_order"))));
        }
    }

    private void changeStepContent(int next) {
        Resources resources = getResources();
        HashMap<String, String> stepData = (HashMap) this.stepsData.get(next);
        this.allFrameFiles = new ArrayList<>();
        List<Integer> allFrames = (List) this.framesData.get(new Integer((String) stepData.get("id")));
        if (allFrames != null && allFrames.size() > 0) {
            for (int i = 0; i < allFrames.size(); i++) {
                if (this.item.is_base == 1) {
                    this.allFrameFiles.add("i_" + this.ident + "_" + ((String) stepData.get("step_number")) + "_" + allFrames.get(i));
                } else {
                    this.allFrameFiles.add(new File(Utils.getStoragePath(this), "i_" + this.ident + "_" + ((String) stepData.get("step_number")) + "_" + allFrames.get(i) + ".png").getAbsolutePath());
                }
            }
        }
        this.counter.setText((next + 1) + " of " + this.stepsData.size());
        if (this.item.is_base == 1) {
            int resId = resources.getIdentifier("i_" + this.ident + "_" + ((String) stepData.get("step_number")) + "_ti", "drawable", getPackageName());
            if (resId > 0) {
                this.techImage.setImageResource(resId);
            }
        } else if (new File(Utils.getStoragePath(this), "i_" + this.ident + "_" + ((String) stepData.get("step_number")) + "_ti" + ".png").exists()) {
            this.techImage.setImageBitmap(BitmapFactory.decodeFile(new File(Utils.getStoragePath(this), "i_" + this.ident + "_" + ((String) stepData.get("step_number")) + "_ti" + ".png").getAbsolutePath()));
        }
        if (this.item.is_base == 1) {
            int resId2 = resources.getIdentifier("i_" + this.ident + "_" + ((String) stepData.get("step_number")) + "_eti", "drawable", getPackageName());
            if (resId2 > 0) {
                this.extraTechImage.setImageResource(resId2);
            }
        } else if (new File(Utils.getStoragePath(this), "i_" + this.ident + "_" + ((String) stepData.get("step_number")) + "_eti" + ".png").exists()) {
            this.extraTechImage.setImageBitmap(BitmapFactory.decodeFile(new File(Utils.getStoragePath(this), "i_" + this.ident + "_" + ((String) stepData.get("step_number")) + "_eti" + ".png").getAbsolutePath()));
        }
        if (((String) stepData.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)).length() > 3) {
            this.descriptionView.setText(((String) stepData.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)).trim());
            this.descriptionView.setVisibility(0);
            return;
        }
        this.descriptionView.setVisibility(4);
    }

    public void onClick(View v) {
        if (this.timer != null) {
            this.timer.cancel();
        }
        if (v == this.next_button) {
            if (this.stepsData.size() > this.currentStep + 1) {
                this.currentStep++;
            } else {
                this.currentStep = 0;
                displayInterstitial();
                new RateDialog(this).showIfChecked();
            }
            changeStepContent(this.currentStep);
        }
        if (v == this.preview_button) {
            if (this.currentStep > 0) {
                this.currentStep--;
                changeStepContent(this.currentStep);
            } else {
                finish();
            }
        }
        if (v == this.replay_button) {
            changeStepContent(this.currentStep);
        }
        this.currentFrame = 0;
        animateStepContent();
    }

    public void animateStepContent() {
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Step.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if (Step.this.currentFrame < Step.this.allFrameFiles.size()) {
                            if (Step.this.item.is_base == 1) {
                                Step.this.bgImage.setImageResource(Step.this.getResources().getIdentifier((String) Step.this.allFrameFiles.get(Step.this.currentFrame), "drawable", Step.this.getPackageName()));
                            } else if (new File((String) Step.this.allFrameFiles.get(Step.this.currentFrame)).exists()) {
                                Step.this.bgImage.setImageBitmap(BitmapFactory.decodeFile((String) Step.this.allFrameFiles.get(Step.this.currentFrame)));
                            }
                            Step.this.currentFrame = Step.this.currentFrame + 1;
                        } else if (Step.this.timer != null) {
                            Step.this.timer.cancel();
                            Step.this.timer = null;
                        }
                    }
                });
            }
        }, 0, (long) this.duration);
    }

    public void onResume() {
        super.onResume();
        if (this.soundStatus) {
            this.bgSound = new BackgroundSound();
            this.bgSound.execute(new Void[0]);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.soundStatus) {
            this.bgSound.stopMusic();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        view.setScaleType(ScaleType.MATRIX);
        this.techImage.setScaleType(ScaleType.MATRIX);
        this.extraTechImage.setScaleType(ScaleType.MATRIX);
        this.itemExtraTechImage.setScaleType(ScaleType.MATRIX);
        switch (event.getAction() & 255) {
            case 0:
                this.mode = 1;
                this.matrix.set(view.getImageMatrix());
                this.savedMatrix.set(this.matrix);
                this.start.set(event.getX(), event.getY());
                break;
            case 1:
                this.mode = 0;
                break;
            case 2:
                if (this.mode != 1) {
                    if (this.mode == 2) {
                        float newDist = spacing(event);
                        if (newDist > 5.0f) {
                            float scale = newDist / this.oldDist;
                            this.matrix.set(this.savedMatrix);
                            this.matrix.postScale(scale, scale, this.mid.x, this.mid.y);
                            break;
                        }
                    }
                } else {
                    this.matrix.set(this.savedMatrix);
                    this.matrix.postTranslate(event.getX() - this.start.x, event.getY() - this.start.y);
                    break;
                }
                break;
            case 5:
                this.oldDist = spacing(event);
                if (this.oldDist > 5.0f) {
                    this.mode = 2;
                    midPoint(this.mid, event);
                    this.savedMatrix.set(this.matrix);
                    break;
                }
                break;
            case 6:
                this.mode = 0;
                break;
        }
        view.setImageMatrix(this.matrix);
        this.extraTechImage.setImageMatrix(this.matrix);
        this.itemExtraTechImage.setImageMatrix(this.matrix);
        this.techImage.setImageMatrix(this.matrix);
        return true;
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    private void midPoint(PointF point, MotionEvent event) {
        point.set((event.getX(0) + event.getX(1)) / 2.0f, (event.getY(0) + event.getY(1)) / 2.0f);
    }

    private void dumpEvent(MotionEvent event) {
        String[] names = {"DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"};
        StringBuilder sb = new StringBuilder();
        int action = event.getAction();
        int actionCode = action & 255;
        sb.append("event ACTION_").append(names[actionCode]);
        if (actionCode == 5 || actionCode == 6) {
            sb.append("(pid ").append(action >> 8);
            sb.append(")");
        }
        sb.append("[");
        for (int i = 0; i < event.getPointerCount(); i++) {
            sb.append("#").append(i);
            sb.append("(pid ").append(event.getPointerId(i));
            sb.append(")=").append((int) event.getX(i));
            sb.append(",").append((int) event.getY(i));
            if (i + 1 < event.getPointerCount()) {
                sb.append(";");
            }
        }
        sb.append("]");
        Log.d("Touch Events ---------", sb.toString());
    }
}
