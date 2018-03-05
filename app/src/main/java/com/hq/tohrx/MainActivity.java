package com.hq.tohrx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hq.tohrx.hearttree.TreeView;
import com.hq.tohrx.sample.AlignSample;
import com.hq.tohrx.sample.ColorSample;
import com.hq.tohrx.sample.CookieThumperSample;
import com.hq.tohrx.sample.Rotation3DSample;
import com.hq.tohrx.sample.ScaleTextSample;
import com.hq.tohrx.sample.ShapeRevealLoopSample;
import com.hq.tohrx.sample.ShapeRevealSample;
import com.hq.tohrx.sample.SlideSample;
import com.hq.tohrx.sample.SurfaceScaleSample;
import com.hq.tohrx.sample.SurfaceTransSample;
import com.hq.tohrx.service.MusicService;
import com.linroid.filtermenu.library.FilterMenu;
import com.linroid.filtermenu.library.FilterMenuLayout;

import su.levenetc.android.textsurface.Debug;
import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Sequential;
import su.levenetc.android.textsurface.animations.ShapeReveal;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.contants.Side;

public class MainActivity extends AppCompatActivity {

    private TextSurface textSurface;
    private FrameLayout line1;
    private LinearLayout line_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        line_container=this.findViewById(R.id.line_container);
        line1 = this.findViewById(R.id.line2);

        textSurface = findViewById(R.id.text_surface);
        textSurface.postDelayed(new Runnable() {
            @Override
            public void run() {
                show();
            }
        }, 14000);
        View treeview = new TreeView(this);

        FilterMenuLayout layout = findViewById(R.id.filter_menu);
        FilterMenu menu = new FilterMenu.Builder(this)
                .addItem(R.mipmap.emoji1)
                .addItem(R.mipmap.emoji2)
                .addItem(R.mipmap.emoji3)
                .addItem(R.mipmap.emoji4)
                .addItem(R.mipmap.emoji5)
                .addItem(R.mipmap.emoji6)
                .addItem(R.mipmap.emoji7)

                //.inflate(R.menu....)//inflate  menu resource
                .attach(layout)
                .withListener(new FilterMenu.OnMenuChangeListener() {
                    @Override
                    public void onMenuItemClick(View view, int position) {
                        switch (position) {
                            case 0:
                                textSurface.reset();
                                Rotation3DSample.play(textSurface);
                                break;

                            case 1:
                                textSurface.reset();
                                ShapeRevealSample.play(textSurface);
                                break;

                            case 2:
                                textSurface.reset();
                                SlideSample.play(textSurface);
                                 break;

                            case 3:
                                textSurface.reset();
                                CookieThumperSample.play(textSurface,getAssets());
                                break;
                            case 4:
                                textSurface.reset();
                                SurfaceScaleSample.play(textSurface);
                                break;

                            case 5:
                                textSurface.reset();
                                AlignSample.play(textSurface);
                                break;

                            case 6:
                                textSurface.reset();
                                ColorSample.play(textSurface);
                                Intent intent=new Intent(getApplicationContext(),MusicService.class);
                                intent.putExtra("operate",0);
                                startService(intent);
                                 break;

                            default:
                                break;
                        }
                    }

                    @Override
                    public void onMenuCollapse() {

                    }

                    @Override
                    public void onMenuExpand() {

                    }
                })
                .build();

        line1.removeView(line_container);
        line1.addView(treeview);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                line1.addView(line_container);
                line_container.setVisibility(View.VISIBLE);
                line_container.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_alphe));
            }
        },16000);
    }

    private void show() {
        textSurface.reset();
        ScaleTextSample.play(textSurface);
    }
}
