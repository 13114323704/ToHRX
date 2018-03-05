package com.hq.tohrx.sample;

/**
 * Created by 黄庆 on 2018/2/13.
 */

import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.animations.AnimationsSet;
import su.levenetc.android.textsurface.contants.TYPE;
import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Rotate3D;
import su.levenetc.android.textsurface.contants.Axis;
import su.levenetc.android.textsurface.contants.Direction;
import su.levenetc.android.textsurface.contants.Pivot;

/**
 * Created by Eugene Levenetc.
 */
public class Rotation3DSample {
    public static void play(TextSurface textSurface) {
        Text textA = TextBuilder.create("from 2017.5.20,you know").setPosition(Align.SURFACE_CENTER).build();
        Text textB = TextBuilder.create("267 days have passed!").setPosition(Align.SURFACE_CENTER, textA).build();
        Text textC = TextBuilder.create("267 days full of my care to you!").setPosition(Align.SURFACE_CENTER, textB).build();
        int duration = 6000;

        textSurface.play(TYPE.SEQUENTIAL,
                new AnimationsSet(TYPE.SEQUENTIAL,
                        Rotate3D.showFromCenter(textA, duration, Direction.CLOCK, Axis.X),
                        Rotate3D.hideFromCenter(textA, duration, Direction.CLOCK, Axis.Y)
                ),
                new AnimationsSet(TYPE.SEQUENTIAL,
                        Rotate3D.showFromSide(textB, duration, Pivot.LEFT),
                        Rotate3D.hideFromSide(textB, duration, Pivot.RIGHT)
                ),
                new AnimationsSet(TYPE.SEQUENTIAL,
                        Rotate3D.showFromSide(textC, duration, Pivot.TOP),
                        Rotate3D.hideFromSide(textC, duration, Pivot.BOTTOM)
                )
        );
    }
}