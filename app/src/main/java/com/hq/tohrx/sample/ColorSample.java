package com.hq.tohrx.sample;

/**
 * Created by 黄庆 on 2018/2/13.
 */

import android.graphics.Color;

import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.contants.TYPE;
import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.ChangeColor;

/**
 * Created by Eugene Levenetc.
 */
public class ColorSample {
    public static void play(TextSurface textSurface) {

        Text textA = TextBuilder
                .create("情人节快乐！")
                .setPosition(Align.SURFACE_CENTER)
                .setSize(40)
                .setAlpha(0)
                .build();

        textSurface.play(TYPE.SEQUENTIAL,
                Alpha.show(textA, 1000),
                ChangeColor.to(textA, 1000, Color.YELLOW),
                ChangeColor.fromTo(textA, 1000, Color.BLUE, Color.RED)
                //Alpha.hide(textA, 1000)
        );
    }
}
