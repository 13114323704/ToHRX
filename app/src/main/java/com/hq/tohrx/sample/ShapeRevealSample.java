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
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.Circle;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Rotate3D;
import su.levenetc.android.textsurface.animations.ShapeReveal;
import su.levenetc.android.textsurface.animations.SideCut;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.animations.TransSurface;
import su.levenetc.android.textsurface.contants.Axis;
import su.levenetc.android.textsurface.contants.Direction;
import su.levenetc.android.textsurface.contants.Pivot;
import su.levenetc.android.textsurface.contants.Side;

/**
 * Created by Eugene Levenetc.
 */
public class ShapeRevealSample {
    public static void play(TextSurface textSurface) {

        Text textA = TextBuilder.create("I don't have a lot of fancy words").setPosition(Align.SURFACE_CENTER).build();
        Text textB = TextBuilder.create("happiness comes to me in many ways").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textA).build();
        Text textC = TextBuilder.create("but now , happiness is").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textB).build();
        Text textD = TextBuilder.create("I have you").setSize(30).setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textC).build();

        final int flash = 3000;

        textSurface.play(TYPE.SEQUENTIAL,
                Rotate3D.showFromCenter(textA, 2000, Direction.CLOCK, Axis.X),
                new AnimationsSet(TYPE.PARALLEL,
                        ShapeReveal.create(textA, flash, SideCut.hide(Side.LEFT), false),
                        new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(flash / 4), ShapeReveal.create(textA, flash, SideCut.show(Side.LEFT), false))
                ),
                new AnimationsSet(TYPE.PARALLEL,
                        Rotate3D.showFromSide(textB, 2000, Pivot.TOP),
                        new TransSurface(2000, textB, Pivot.CENTER)
                ),
                Delay.duration(2000),
                new AnimationsSet(TYPE.PARALLEL,
                        Slide.showFrom(Side.TOP, textC, 2000),
                        new TransSurface(4000, textC, Pivot.CENTER)
                ),
                Delay.duration(2000),
                new AnimationsSet(TYPE.PARALLEL,
                        ShapeReveal.create(textD, 2000, Circle.show(Side.CENTER, Direction.OUT), false),
                        new TransSurface(6000, textD, Pivot.CENTER)
                ),
                Delay.duration(2000),
                new AnimationsSet(TYPE.PARALLEL,
                        new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textD, 2800), ShapeReveal.create(textD, 4000, SideCut.hide(Side.LEFT), true)),
                        new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(2000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textC, 2800), ShapeReveal.create(textC, 4000, SideCut.hide(Side.LEFT), true))),
                        new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(4000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textB, 2800), ShapeReveal.create(textB, 4000, SideCut.hide(Side.LEFT), true))),
                        new AnimationsSet(TYPE.SEQUENTIAL, Delay.duration(6000), new AnimationsSet(TYPE.PARALLEL, Alpha.hide(textA, 2800), ShapeReveal.create(textA, 4000, SideCut.hide(Side.LEFT), true))),
                        new TransSurface(16000, textA, Pivot.CENTER)
                )

        );
    }
}
