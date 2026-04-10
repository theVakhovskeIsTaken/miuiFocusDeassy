/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  U0.o
 *  android.content.Context
 *  android.util.Log
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.FolmeObject
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 *  miuix.animation.property.FloatProperty
 *  miuix.colorful.texteffect.TextChangeHelper
 *  miuix.colorful.texteffect.TextChangeProcessor
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.IslandParamsException;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.FixedWidthDigitInfo;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;
import miui.systemui.dynamicisland.module.a;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.FloatProperty;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public class IslandFixedWidthDigitViewHolder
extends BaseIslandModuleViewHolder {
    private static final CONTENT_TRANS_X.1 CONTENT_TRANS_X;
    public static final Companion Companion;
    private static final DIGIT_SCALE_X.1 DIGIT_SCALE_X;
    private static final DIGIT_SCALE_Y.1 DIGIT_SCALE_Y;
    private static final DIGIT_TRANS_X.1 DIGIT_TRANS_X;
    private static final String PLACE_HOLDER = "---";
    private static final String TAG = "IslandFixedWidthDigitViewHolder";
    private Choreographer choreographer;
    private TimerTextEffectView content;
    private float contentTransX;
    private float digitScaleX;
    private float digitScaleY;
    private float digitTransX;
    private TimerTextEffectView fixedWidthDigit;
    private FixedWidthDigitInfo fixedWidthDigitInfo;
    private final Choreographer.FrameCallback frameCallback;
    private View textShade;
    private ViewGroup titleContainer;
    private boolean updateScheduled;

    static {
        Companion = new Object(null){
            {
                this();
            }
        };
        DIGIT_TRANS_X = new FloatProperty<IslandFixedWidthDigitViewHolder>(){

            public float getValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
                o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
                return IslandFixedWidthDigitViewHolder.access$getDigitTransX$p(islandFixedWidthDigitViewHolder);
            }

            public void setValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f2) {
                o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandFixedWidthDigitViewHolder.access$setDigitTransX$p(islandFixedWidthDigitViewHolder, f2);
            }
        };
        CONTENT_TRANS_X = new FloatProperty<IslandFixedWidthDigitViewHolder>(){

            public float getValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
                o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
                return IslandFixedWidthDigitViewHolder.access$getContentTransX$p(islandFixedWidthDigitViewHolder);
            }

            public void setValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f2) {
                o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandFixedWidthDigitViewHolder.access$setContentTransX$p(islandFixedWidthDigitViewHolder, f2);
            }
        };
        DIGIT_SCALE_X = new FloatProperty<IslandFixedWidthDigitViewHolder>(){

            public float getValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
                o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
                return IslandFixedWidthDigitViewHolder.access$getDigitScaleX$p(islandFixedWidthDigitViewHolder);
            }

            public void setValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f2) {
                o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandFixedWidthDigitViewHolder.access$setDigitScaleX$p(islandFixedWidthDigitViewHolder, f2);
            }
        };
        DIGIT_SCALE_Y = new FloatProperty<IslandFixedWidthDigitViewHolder>(){

            public float getValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
                o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
                return IslandFixedWidthDigitViewHolder.access$getDigitScaleY$p(islandFixedWidthDigitViewHolder);
            }

            public void setValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f2) {
                o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandFixedWidthDigitViewHolder.access$setDigitScaleY$p(islandFixedWidthDigitViewHolder, f2);
            }
        };
    }

    public IslandFixedWidthDigitViewHolder(Context context, ViewGroup viewGroup, U0.o o2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        super(context, viewGroup, o2);
        this.digitScaleX = 1.0f;
        this.digitScaleY = 1.0f;
        this.frameCallback = new a(this);
    }

    public static /* synthetic */ void a(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, long l) {
        IslandFixedWidthDigitViewHolder.frameCallback$lambda$6(islandFixedWidthDigitViewHolder, l);
    }

    public static final /* synthetic */ float access$getContentTransX$p(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
        return islandFixedWidthDigitViewHolder.contentTransX;
    }

    public static final /* synthetic */ float access$getDigitScaleX$p(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
        return islandFixedWidthDigitViewHolder.digitScaleX;
    }

    public static final /* synthetic */ float access$getDigitScaleY$p(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
        return islandFixedWidthDigitViewHolder.digitScaleY;
    }

    public static final /* synthetic */ float access$getDigitTransX$p(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
        return islandFixedWidthDigitViewHolder.digitTransX;
    }

    public static final /* synthetic */ void access$setContentTransX$p(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f) {
        islandFixedWidthDigitViewHolder.contentTransX = f;
    }

    public static final /* synthetic */ void access$setDigitScaleX$p(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f) {
        islandFixedWidthDigitViewHolder.digitScaleX = f;
    }

    public static final /* synthetic */ void access$setDigitScaleY$p(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f) {
        islandFixedWidthDigitViewHolder.digitScaleY = f;
    }

    public static final /* synthetic */ void access$setDigitTransX$p(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f) {
        islandFixedWidthDigitViewHolder.digitTransX = f;
    }

    private final void contentAnimation(float f2) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)CONTENT_TRANS_X, f2, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandFixedWidthDigitViewHolder this$0;
            {
                this.this$0 = islandFixedWidthDigitViewHolder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    private final void contentScheduleUpdate() {
        TimerTextEffectView timerTextEffectView = this.content;
        if (timerTextEffectView != null) {
            timerTextEffectView.setTranslationX(this.contentTransX);
        }
    }

    private final void digitAnimation(float f2, float f3) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)DIGIT_SCALE_X, f2, new long[0]).add((FloatProperty)DIGIT_SCALE_Y, f2, new long[0]).add((FloatProperty)DIGIT_TRANS_X, f3, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandFixedWidthDigitViewHolder this$0;
            {
                this.this$0 = islandFixedWidthDigitViewHolder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    private final void digitScheduleUpdate() {
        TimerTextEffectView timerTextEffectView = this.fixedWidthDigit;
        if (timerTextEffectView != null) {
            timerTextEffectView.setTranslationX(this.digitTransX);
        }
        timerTextEffectView = this.fixedWidthDigit;
        if (timerTextEffectView != null) {
            timerTextEffectView.setScaleX(this.digitScaleX);
        }
        timerTextEffectView = this.fixedWidthDigit;
        if (timerTextEffectView != null) {
            timerTextEffectView.setScaleY(this.digitScaleY);
        }
    }

    private static final void frameCallback$lambda$6(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, long l) {
        o.g((Object)islandFixedWidthDigitViewHolder, (String)"this$0");
        islandFixedWidthDigitViewHolder.updateScheduled = false;
        islandFixedWidthDigitViewHolder.digitScheduleUpdate();
        islandFixedWidthDigitViewHolder.contentScheduleUpdate();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static /* synthetic */ Object initLayout$suspendImpl(IslandFixedWidthDigitViewHolder var0, View var1_1, String var2_2, d var3_3) {
        if (!(var3_3 /* !! */  instanceof initLayout.1)) ** GOTO lbl-1000
        var5_4 /* !! */  = var3_3 /* !! */ ;
        var4_5 = var5_4 /* !! */ .label;
        if ((var4_5 & -2147483648) != 0) {
            var5_4 /* !! */ .label = var4_5 + -2147483648;
            var3_3 /* !! */  = var5_4 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 /* !! */  = new M0.d(var0, var3_3 /* !! */ ){
                Object L$0;
                Object L$1;
                int label;
                Object result;
                final IslandFixedWidthDigitViewHolder this$0;
                {
                    this.this$0 = islandFixedWidthDigitViewHolder;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return IslandFixedWidthDigitViewHolder.initLayout$suspendImpl(this.this$0, null, null, (d)this);
                }
            };
        }
        var7_6 = var3_3 /* !! */ .result;
        var8_7 = c.c();
        var4_5 = var3_3 /* !! */ .label;
        if (var4_5 == 0) ** GOTO lbl19
        if (var4_5 == 1) {
            var6_8 = (View)var3_3 /* !! */ .L$1;
            var5_4 /* !! */  = (IslandFixedWidthDigitViewHolder)var3_3 /* !! */ .L$0;
            k.b((Object)var7_6);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl19:
            // 1 sources

            k.b((Object)var7_6);
            var3_3 /* !! */ .L$0 = var0;
            var3_3 /* !! */ .L$1 = var1_1;
            var3_3 /* !! */ .label = 1;
            var5_4 /* !! */  = var0;
            var6_8 = var1_1;
            if (super.initLayout(var1_1, var2_2, var3_3 /* !! */ ) == var8_7) {
                return var8_7;
            }
        }
        var5_4 /* !! */ .titleContainer = (ViewGroup)var6_8.findViewById(R.id.island_container_module_fix_width_digit);
        var5_4 /* !! */ .fixedWidthDigit = (TimerTextEffectView)var6_8.findViewById(R.id.island_digit);
        var5_4 /* !! */ .content = (TimerTextEffectView)var6_8.findViewById(R.id.island_content);
        var5_4 /* !! */ .textShade = var6_8.findViewById(R.id.island_text_shade);
        return s.a;
    }

    private final boolean isValidNumber(String string) {
        boolean bl;
        block8: {
            int n;
            int n2;
            int n3;
            boolean bl2 = false;
            for (n3 = 0; n3 < string.length(); ++n3) {
                char c2 = string.charAt(n3);
                if (Character.isDigit(c2)) continue;
                bl = bl2;
                if (c2 == '.') {
                    continue;
                }
                break block8;
            }
            n3 = 0;
            for (n2 = 0; n2 < string.length(); ++n2) {
                n = n3;
                if (Character.isDigit(string.charAt(n2))) {
                    n = n3 + 1;
                }
                n3 = n;
            }
            bl = bl2;
            if (n3 <= 3) {
                n2 = 0;
                for (n = 0; n < string.length(); ++n) {
                    n3 = n2;
                    if (string.charAt(n) == '.') {
                        n3 = n2 + 1;
                    }
                    n2 = n3;
                }
                bl = bl2;
                if (n2 <= 1) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    private final String validateAndFormat(String string) {
        if (string == null || !this.isValidNumber(string)) {
            string = PLACE_HOLDER;
        }
        return string;
    }

    @Override
    public void bind(IslandTemplate islandTemplate, DynamicIslandData object) {
        o.g((Object)islandTemplate, (String)"template");
        super.bind(islandTemplate, (DynamicIslandData)object);
        this.setFixedFont((TextView)this.fixedWidthDigit);
        object = islandTemplate.getBigIslandArea();
        Object var6_3 = null;
        object = object != null ? ((BigIslandArea)object).getFixedWidthDigitInfo() : null;
        this.fixedWidthDigitInfo = object;
        object = islandTemplate.getBigIslandArea();
        Object object2 = object != null && (object = ((BigIslandArea)object).getFixedWidthDigitInfo()) != null ? ((FixedWidthDigitInfo)object).getDigit() : null;
        object = islandTemplate.getBigIslandArea();
        object = object != null && (object = ((BigIslandArea)object).getFixedWidthDigitInfo()) != null ? ((FixedWidthDigitInfo)object).getContent() : null;
        if (object2 != null) {
            Object object3 = this.fixedWidthDigitInfo;
            object3 = object3 != null ? ((FixedWidthDigitInfo)object3).getShowHighlightColor() : null;
            this.setTitleHighlightColor(islandTemplate, (Boolean)object3, this.fixedWidthDigit, this.validateAndFormat((String)object2));
            object3 = this.fixedWidthDigitInfo;
            object2 = var6_3;
            if (object3 != null) {
                object2 = ((FixedWidthDigitInfo)object3).getShowHighlightColor();
            }
            this.setContentHighlightColor(islandTemplate, (Boolean)object2, this.content, (String)object);
            islandTemplate = this.fixedWidthDigit;
            int n = 0;
            if (islandTemplate != null) {
                islandTemplate.setVisibility(0);
            }
            islandTemplate = this.content;
            if (islandTemplate != null) {
                if (object == null) {
                    n = 8;
                }
                islandTemplate.setVisibility(n);
            }
            return;
        }
        Log.d((String)TAG, (String)"digitText is null");
        throw new IslandParamsException("digitText is null");
    }

    @Override
    public void diff(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.diff(islandTemplate, dynamicIslandData);
    }

    @Override
    public Object initLayout(View view, String string, d d2) {
        return IslandFixedWidthDigitViewHolder.initLayout$suspendImpl(this, view, string, d2);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.choreographer = Choreographer.getInstance();
        string = this.fixedWidthDigit;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.content;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.fixedWidthDigit;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.content) != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.titleContainer) != null) {
            FolmeKt.cleanWhenViewDetached((FolmeObject)this, (View)string);
        }
    }

    public final void scheduleUpdate() {
        if (this.updateScheduled) {
            return;
        }
        this.updateScheduled = true;
        Choreographer choreographer = this.choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this.frameCallback);
        }
    }

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        Object object = this.fixedWidthDigit;
        Object var4_4 = null;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            object.width = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_fixed_width);
        }
        TimerTextEffectView timerTextEffectView = this.content;
        object = var4_4;
        if (timerTextEffectView != null) {
            object = timerTextEffectView.getLayoutParams();
        }
        if (object != null) {
            object.width = -2;
        }
        this.bind(islandTemplate, dynamicIslandData);
    }

    @Override
    public void updateWidth(int n) {
        int n2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding);
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        int n3 = dynamicIslandUtils.isDynamicIslandPadNoPropOnce(this.getDynamicIslandData()) ? this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding_pad) : this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding);
        float f2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_padding_inner);
        Object object = this.content;
        Object object2 = this.fixedWidthDigitInfo;
        Object var14_8 = null;
        Object var13_9 = null;
        object2 = object2 != null ? ((FixedWidthDigitInfo)object2).getContent() : null;
        int n4 = this.getTextViewWidth((TextView)object, (String)object2);
        int n5 = dynamicIslandUtils.isDynamicIslandPadNoPropOnce(this.getDynamicIslandData()) ? this.getContext().getResources().getDimensionPixelSize(R.dimen.island_fixed_width_pad) : this.getContext().getResources().getDimensionPixelSize(R.dimen.island_fixed_width);
        float f3 = n5 + n4;
        float f4 = n4 > 0 ? f2 : 0.0f;
        float f5 = n2;
        float f6 = n3;
        object = this.fixedWidthDigit;
        object2 = this.fixedWidthDigitInfo;
        object2 = object2 != null ? ((FixedWidthDigitInfo)object2).getDigit() : null;
        this.getTextViewWidth((TextView)object, (String)object2);
        this.setFixedFont((TextView)this.fixedWidthDigit);
        if (f3 + f4 + f5 + f6 > (float)n) {
            object2 = this.textShade;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            if (!CommonUtils.isLayoutRtl((Context)this.getContext())) {
                object2 = this.textShade;
                object = object2 != null ? object2.getLayoutParams() : null;
                object2 = var13_9;
                if (object instanceof FrameLayout.LayoutParams) {
                    object2 = (FrameLayout.LayoutParams)object;
                }
                if (object2 != null) {
                    ((FrameLayout.LayoutParams)object2).gravity = 8388629;
                    object = this.textShade;
                    if (object != null) {
                        object.setLayoutParams((ViewGroup.LayoutParams)object2);
                    }
                }
                if ((object2 = this.textShade) != null) {
                    object2.setTranslationX(0.0f);
                }
            } else {
                object2 = this.textShade;
                object = object2 != null ? object2.getLayoutParams() : null;
                object2 = var14_8;
                if (object instanceof FrameLayout.LayoutParams) {
                    object2 = (FrameLayout.LayoutParams)object;
                }
                if (object2 != null) {
                    ((FrameLayout.LayoutParams)object2).gravity = 8388627;
                    object = this.textShade;
                    if (object != null) {
                        object.setLayoutParams((ViewGroup.LayoutParams)object2);
                    }
                }
                if ((object2 = this.textShade) != null) {
                    object2.setTranslationX(-(f2 + (float)n5));
                }
            }
        } else {
            object2 = this.textShade;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        object2 = this.content;
        if (object2 != null) {
            object2.requestLayout();
        }
        if ((object2 = this.fixedWidthDigit) != null) {
            object2.requestLayout();
        }
        super.updateWidth(n);
    }
}
