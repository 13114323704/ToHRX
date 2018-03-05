package com.hq.tohrx.sample;

/**
 * Created by 黄庆 on 2018/2/13.
 */

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.ChangeColor;
import su.levenetc.android.textsurface.animations.Circle;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Parallel;
import su.levenetc.android.textsurface.animations.Rotate3D;
import su.levenetc.android.textsurface.animations.Sequential;
import su.levenetc.android.textsurface.animations.ShapeReveal;
import su.levenetc.android.textsurface.animations.SideCut;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.animations.TransSurface;
import su.levenetc.android.textsurface.contants.Direction;
import su.levenetc.android.textsurface.contants.Pivot;
import su.levenetc.android.textsurface.contants.Side;

/**
 * Created by Eugene Levenetc.
 */
public class CookieThumperSample {

    public static void play(TextSurface textSurface, AssetManager assetManager) {

        final Typeface robotoBlack = Typeface.createFromAsset(assetManager, "fonts/Roboto-Black.ttf");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTypeface(robotoBlack);

        Text textDaai = TextBuilder
                .create("老婆")
                .setPaint(paint)
                .setSize(30)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.SURFACE_CENTER).build();

        Text textBraAnies = TextBuilder
                .create("老婆老婆")
                .setPaint(paint)
                .setSize(35)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF, textDaai).build();

        Text textFokkenGamBra = TextBuilder
                .create("摸摸老婆")
                .setPaint(paint)
                .setSize(40)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(Align.RIGHT_OF, textBraAnies).build();

        Text textHaai = TextBuilder
                .create("捏捏老婆   ")
                .setPaint(paint)
                .setSize(45)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF, textFokkenGamBra).build();

        Text textDaaiAnies = TextBuilder
                .create("亲亲老婆")
                .setPaint(paint)
                .setSize(50)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.RIGHT_OF | Align.CENTER_OF, textHaai).build();

        Text texThyLamInnie = TextBuilder
                .create("抱抱老婆")
                .setPaint(paint)
                .setSize(55)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.RIGHT_OF, textDaaiAnies).build();

        Text textThrowDamn = TextBuilder
                .create("大口亲亲老婆")
                .setPaint(paint)
                .setSize(35)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texThyLamInnie).build();

        Text textDevilishGang = TextBuilder
                .create("大口亲亲抱抱老婆")
                .setPaint(paint)
                .setSize(35)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textThrowDamn).build();

        Text textSignsInTheAir = TextBuilder
                .create("超大口亲亲最爱的老婆")
                .setPaint(paint)
                .setSize(35)
                .setAlpha(0)
                .setColor(Color.RED)
                .setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textDevilishGang).build();

        textSurface.play(
                new Sequential(
                        ShapeReveal.create(textDaai, 1500, SideCut.show(Side.LEFT), false),
                        new Parallel(ShapeReveal.create(textDaai, 1200, SideCut.hide(Side.LEFT), false), new Sequential(Delay.duration(600), ShapeReveal.create(textDaai, 1200, SideCut.show(Side.LEFT), false))),
                        new Parallel(new TransSurface(1000, textBraAnies, Pivot.CENTER), ShapeReveal.create(textBraAnies, 2600, SideCut.show(Side.LEFT), false)),
                        Delay.duration(1000),
                        new Parallel(new TransSurface(1500, textFokkenGamBra, Pivot.CENTER), Slide.showFrom(Side.LEFT, textFokkenGamBra, 1500), ChangeColor.to(textFokkenGamBra, 1500, Color.RED)),
                        Delay.duration(1000),
                        new Parallel(TransSurface.toCenter(textHaai, 1000), Rotate3D.showFromSide(textHaai, 1500, Pivot.TOP)),
                        new Parallel(TransSurface.toCenter(textDaaiAnies, 1000), Slide.showFrom(Side.TOP, textDaaiAnies, 1000)),
                        new Parallel(TransSurface.toCenter(texThyLamInnie, 1500), Slide.showFrom(Side.LEFT, texThyLamInnie, 1000)),
                        Delay.duration(1000),
                        new Parallel(
                                new TransSurface(6000, textSignsInTheAir, Pivot.CENTER),
                                new Sequential(
                                        new Sequential(ShapeReveal.create(textThrowDamn, 2000, Circle.show(Side.CENTER, Direction.OUT), false)),
                                        new Sequential(ShapeReveal.create(textDevilishGang, 2000, Circle.show(Side.CENTER, Direction.OUT), false)),
                                        new Sequential(ShapeReveal.create(textSignsInTheAir, 2000, Circle.show(Side.CENTER, Direction.OUT), false))
                                )
                        ),
                        Delay.duration(2500),
                        new Parallel(
                                ShapeReveal.create(textThrowDamn, 6000, SideCut.hide(Side.LEFT), true),
                                new Sequential(Delay.duration(500), ShapeReveal.create(textDevilishGang, 6000, SideCut.hide(Side.LEFT), true)),
                                new Sequential(Delay.duration(1000), ShapeReveal.create(textSignsInTheAir, 6000, SideCut.hide(Side.LEFT), true)),
                                Alpha.hide(texThyLamInnie, 3000),
                                Alpha.hide(textDaaiAnies, 3000)
                        )
                )
        );

    }

}