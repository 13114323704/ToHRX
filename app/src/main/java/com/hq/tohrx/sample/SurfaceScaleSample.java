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
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.ScaleSurface;
import su.levenetc.android.textsurface.contants.Fit;

/**
 * Created by Eugene Levenetc.
 */
public class SurfaceScaleSample {
    public static void play(TextSurface textSurface) {

        Text textA = TextBuilder.create("亲亲老婆").setPosition(Align.SURFACE_CENTER).build();
        Text textB = TextBuilder.create("我才不会告诉你我想").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textA).build();
        Text textC = TextBuilder.create("mua~").setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textB).build();


        textSurface.play(TYPE.SEQUENTIAL,
                Alpha.show(textA, 1000),
                new AnimationsSet(TYPE.PARALLEL,
                        new AnimationsSet(TYPE.PARALLEL, Alpha.show(textB, 500), Alpha.hide(textA, 500)),
                        new ScaleSurface(500, textB, Fit.WIDTH)
                ),
                Delay.duration(1000),
                new AnimationsSet(TYPE.PARALLEL,
                        new AnimationsSet(TYPE.PARALLEL, Alpha.show(textC, 500), Alpha.hide(textB, 500)),
                        new ScaleSurface(500, textC, Fit.WIDTH)
                )
        );
    }
}