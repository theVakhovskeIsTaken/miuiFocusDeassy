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
 *  android.os.SystemClock
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.util.Log
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.TextView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.notification.HyperChronometerPlugin
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.FolmeObject
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 *  miuix.animation.property.FloatProperty
 *  miuix.colorful.texteffect.HyperChronometer
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
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.IslandParamsException;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.SameWidthDigitInfo;
import miui.systemui.dynamicisland.model.TimerInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;
import miui.systemui.dynamicisland.module.i;
import miui.systemui.notification.HyperChronometerPlugin;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.FloatProperty;
import miuix.colorful.texteffect.HyperChronometer;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class IslandSameWidthDigitViewHolder
extends BaseIslandModuleViewHolder {
    private static final CONTENT_TRANS_X.1 CONTENT_TRANS_X;
    public static final Companion Companion;
    private static final DIGIT_SCALE_X.1 DIGIT_SCALE_X;
    private static final DIGIT_SCALE_Y.1 DIGIT_SCALE_Y;
    private static final DIGIT_TRANS_X.1 DIGIT_TRANS_X;
    private static final String TAG = "IslandSameWidthDigitViewHolder";
    private Choreographer choreographer;
    private TimerTextEffectView content;
    private float contentTransX;
    private float digitScaleX;
    private float digitScaleY;
    private float digitTransX;
    private final Choreographer.FrameCallback frameCallback;
    private DynamicIslandData lastData;
    private int lastLength;
    private HyperChronometer sameWidthDigit;
    private SameWidthDigitInfo sameWidthDigitInfo;
    private View textShade;
    private final textWatcher.1 textWatcher;
    private boolean timerInitialized;
    private TimerTextEffectView title;
    private ViewGroup titleContainer;
    private boolean updateScheduled;

    static {
        Companion = new Object(null){
            {
                this();
            }
        };
        DIGIT_TRANS_X = new FloatProperty<IslandSameWidthDigitViewHolder>(){

            public float getValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
                o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
                return IslandSameWidthDigitViewHolder.access$getDigitTransX$p(islandSameWidthDigitViewHolder);
            }

            public void setValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f2) {
                o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandSameWidthDigitViewHolder.access$setDigitTransX$p(islandSameWidthDigitViewHolder, f2);
            }
        };
        CONTENT_TRANS_X = new FloatProperty<IslandSameWidthDigitViewHolder>(){

            public float getValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
                o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
                return IslandSameWidthDigitViewHolder.access$getContentTransX$p(islandSameWidthDigitViewHolder);
            }

            public void setValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f2) {
                o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandSameWidthDigitViewHolder.access$setContentTransX$p(islandSameWidthDigitViewHolder, f2);
            }
        };
        DIGIT_SCALE_X = new FloatProperty<IslandSameWidthDigitViewHolder>(){

            public float getValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
                o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
                return IslandSameWidthDigitViewHolder.access$getDigitScaleX$p(islandSameWidthDigitViewHolder);
            }

            public void setValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f2) {
                o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandSameWidthDigitViewHolder.access$setDigitScaleX$p(islandSameWidthDigitViewHolder, f2);
            }
        };
        DIGIT_SCALE_Y = new FloatProperty<IslandSameWidthDigitViewHolder>(){

            public float getValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
                o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
                return IslandSameWidthDigitViewHolder.access$getDigitScaleY$p(islandSameWidthDigitViewHolder);
            }

            public void setValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f2) {
                o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandSameWidthDigitViewHolder.access$setDigitScaleY$p(islandSameWidthDigitViewHolder, f2);
            }
        };
    }

    public IslandSameWidthDigitViewHolder(Context context, ViewGroup viewGroup, U0.o o2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        super(context, viewGroup, o2);
        this.textWatcher = new TextWatcher(this){
            final IslandSameWidthDigitViewHolder this$0;
            {
                this.this$0 = islandSameWidthDigitViewHolder;
            }

            public void afterTextChanged(Editable editable) {
                int n;
                int n2;
                if (IslandSameWidthDigitViewHolder.access$getTimerInitialized$p(this.this$0) && (n2 = IslandSameWidthDigitViewHolder.access$getLastLength$p(this.this$0)) != (n = editable != null ? editable.length() : 0)) {
                    IslandSameWidthDigitViewHolder.access$getEmitEvent$s-1412796221(this.this$0).invoke((Object)IslandSameWidthDigitViewHolder.access$getLastData$p(this.this$0), (Object)DynamicIslandEvent.UpdateDynamicIsland.INSTANCE);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
                IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder = this.this$0;
                n = charSequence != null ? charSequence.length() : 0;
                IslandSameWidthDigitViewHolder.access$setLastLength$p(islandSameWidthDigitViewHolder, n);
            }

            public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
            }
        };
        this.digitScaleX = 1.0f;
        this.digitScaleY = 1.0f;
        this.frameCallback = new i(this);
    }

    public static /* synthetic */ void a(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, long l) {
        IslandSameWidthDigitViewHolder.frameCallback$lambda$1(islandSameWidthDigitViewHolder, l);
    }

    public static final /* synthetic */ float access$getContentTransX$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        return islandSameWidthDigitViewHolder.contentTransX;
    }

    public static final /* synthetic */ float access$getDigitScaleX$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        return islandSameWidthDigitViewHolder.digitScaleX;
    }

    public static final /* synthetic */ float access$getDigitScaleY$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        return islandSameWidthDigitViewHolder.digitScaleY;
    }

    public static final /* synthetic */ float access$getDigitTransX$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        return islandSameWidthDigitViewHolder.digitTransX;
    }

    public static final /* synthetic */ U0.o access$getEmitEvent$s-1412796221(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        return super.getEmitEvent();
    }

    public static final /* synthetic */ DynamicIslandData access$getLastData$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        return islandSameWidthDigitViewHolder.lastData;
    }

    public static final /* synthetic */ int access$getLastLength$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        return islandSameWidthDigitViewHolder.lastLength;
    }

    public static final /* synthetic */ boolean access$getTimerInitialized$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        return islandSameWidthDigitViewHolder.timerInitialized;
    }

    public static final /* synthetic */ void access$setContentTransX$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f) {
        islandSameWidthDigitViewHolder.contentTransX = f;
    }

    public static final /* synthetic */ void access$setDigitScaleX$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f) {
        islandSameWidthDigitViewHolder.digitScaleX = f;
    }

    public static final /* synthetic */ void access$setDigitScaleY$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f) {
        islandSameWidthDigitViewHolder.digitScaleY = f;
    }

    public static final /* synthetic */ void access$setDigitTransX$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f) {
        islandSameWidthDigitViewHolder.digitTransX = f;
    }

    public static final /* synthetic */ void access$setLastLength$p(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, int n) {
        islandSameWidthDigitViewHolder.lastLength = n;
    }

    private final void contentAnimation(float f2) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)CONTENT_TRANS_X, f2, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandSameWidthDigitViewHolder this$0;
            {
                this.this$0 = islandSameWidthDigitViewHolder;
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
            final IslandSameWidthDigitViewHolder this$0;
            {
                this.this$0 = islandSameWidthDigitViewHolder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    private final void digitScheduleUpdate() {
        Object object = this.title;
        object = object != null && object.getVisibility() == 0 ? this.title : this.sameWidthDigit;
        if (object != null) {
            object.setTranslationX(this.digitTransX);
        }
        if (object != null) {
            object.setScaleX(this.digitScaleX);
        }
        if (object != null) {
            object.setScaleY(this.digitScaleY);
        }
    }

    private static final void frameCallback$lambda$1(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, long l) {
        o.g((Object)islandSameWidthDigitViewHolder, (String)"this$0");
        islandSameWidthDigitViewHolder.updateScheduled = false;
        islandSameWidthDigitViewHolder.digitScheduleUpdate();
        islandSameWidthDigitViewHolder.contentScheduleUpdate();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static /* synthetic */ Object initLayout$suspendImpl(IslandSameWidthDigitViewHolder var0, View var1_1, String var2_2, d var3_3) {
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
                final IslandSameWidthDigitViewHolder this$0;
                {
                    this.this$0 = islandSameWidthDigitViewHolder;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return IslandSameWidthDigitViewHolder.initLayout$suspendImpl(this.this$0, null, null, (d)this);
                }
            };
        }
        var7_6 = var3_3 /* !! */ .result;
        var8_7 = c.c();
        var4_5 = var3_3 /* !! */ .label;
        if (var4_5 == 0) ** GOTO lbl19
        if (var4_5 == 1) {
            var6_8 = (View)var3_3 /* !! */ .L$1;
            var5_4 /* !! */  = (IslandSameWidthDigitViewHolder)var3_3 /* !! */ .L$0;
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
        var5_4 /* !! */ .titleContainer = (ViewGroup)var6_8.findViewById(R.id.island_container_module_same_width_digit);
        var5_4 /* !! */ .sameWidthDigit = (HyperChronometer)var6_8.findViewById(R.id.island_chronometer);
        var5_4 /* !! */ .title = (TimerTextEffectView)var6_8.findViewById(R.id.island_title);
        var5_4 /* !! */ .content = (TimerTextEffectView)var6_8.findViewById(R.id.island_content);
        var5_4 /* !! */ .textShade = var6_8.findViewById(R.id.island_text_shade);
        return s.a;
    }

    @Override
    public void bind(IslandTemplate islandTemplate, DynamicIslandData object) {
        boolean bl;
        o.g((Object)islandTemplate, (String)"template");
        super.bind(islandTemplate, (DynamicIslandData)object);
        this.lastData = object;
        Object object2 = islandTemplate.getBigIslandArea();
        Object var9_4 = null;
        object2 = object2 != null ? ((BigIslandArea)object2).getSameWidthDigitInfo() : null;
        this.sameWidthDigitInfo = object2;
        Object object3 = object2 != null ? ((SameWidthDigitInfo)object2).getTimerInfo() : null;
        this.setFixedFont((TextView)this.sameWidthDigit);
        object2 = this.sameWidthDigitInfo;
        Object object4 = object2 != null ? ((SameWidthDigitInfo)object2).getDigit() : null;
        object2 = this.sameWidthDigitInfo;
        object2 = object2 != null ? ((SameWidthDigitInfo)object2).getContent() : null;
        Object object5 = this.sameWidthDigitInfo;
        object5 = object5 != null ? ((SameWidthDigitInfo)object5).getDigit() : null;
        if (object5 == null && (object5 = (object5 = this.sameWidthDigitInfo) != null ? ((SameWidthDigitInfo)object5).getTimerInfo() : null) == null) {
            throw new IslandParamsException("digit is empty");
        }
        int n = 8;
        if (object4 != null) {
            object = this.sameWidthDigit;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.title;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.sameWidthDigitInfo;
            object = object != null ? ((SameWidthDigitInfo)object).getShowHighlightColor() : null;
            this.setTitleHighlightColor(islandTemplate, (Boolean)object, this.title, (String)object4);
        } else if (object3 != null) {
            object4 = this.title;
            if (object4 != null) {
                object4.setVisibility(8);
            }
            object4 = this.sameWidthDigit;
            if (object4 != null) {
                object4.setVisibility(0);
            }
            object4 = ((TimerInfo)object3).getTimerSystemCurrent();
            object5 = ((TimerInfo)object3).getTimerWhen();
            if (object4 != null && object5 != null) {
                bl = ((TimerInfo)object3).getTimerType() < 0;
                HyperChronometer hyperChronometer = this.sameWidthDigit;
                if ((hyperChronometer == null || bl != hyperChronometer.isCountDown()) && (hyperChronometer = this.sameWidthDigit) != null) {
                    hyperChronometer.setCountDown(bl);
                }
                if (!this.timerInitialized) {
                    hyperChronometer = this.sameWidthDigit;
                    if (hyperChronometer != null) {
                        hyperChronometer.setBase(SystemClock.elapsedRealtime() + (Long)object5 - (Long)object4);
                    }
                    this.timerInitialized = true;
                }
            } else {
                object4 = this.sameWidthDigit;
                if (object4 != null) {
                    object4.setVisibility(8);
                }
            }
            this.setupTimer((DynamicIslandData)object, ((TimerInfo)object3).getTimerType(), ((TimerInfo)object3).getTimerWhen(), ((TimerInfo)object3).getTimerTotal(), ((TimerInfo)object3).getTimerSystemCurrent());
        }
        if (object2 != null) {
            object = this.content;
            if (object != null) {
                object3 = this.sameWidthDigitInfo;
                bl = object3 != null && (object3 = ((SameWidthDigitInfo)object3).getTurnAnim()) != null ? (Boolean)object3 : false;
                object.enableEffect(bl);
            }
            object3 = this.sameWidthDigitInfo;
            object = var9_4;
            if (object3 != null) {
                object = ((SameWidthDigitInfo)object3).getShowHighlightColor();
            }
            this.setContentHighlightColor(islandTemplate, (Boolean)object, this.content, (String)object2);
        } else {
            islandTemplate = this.content;
            if (islandTemplate != null) {
                islandTemplate.setText(null);
            }
        }
        islandTemplate = this.content;
        if (islandTemplate != null) {
            if (object2 != null) {
                n = 0;
            }
            islandTemplate.setVisibility(n);
        }
    }

    @Override
    public void diff(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.diff(islandTemplate, dynamicIslandData);
    }

    public final SameWidthDigitInfo getSameWidthDigitInfo() {
        return this.sameWidthDigitInfo;
    }

    @Override
    public Object initLayout(View view, String string, d d2) {
        return IslandSameWidthDigitViewHolder.initLayout$suspendImpl(this, view, string, d2);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        string = this.title;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.sameWidthDigit;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.content;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.title;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.content) != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.titleContainer) != null) {
            FolmeKt.cleanWhenViewDetached((FolmeObject)this, (View)string);
        }
        if ((string = this.sameWidthDigit) != null) {
            string.addTextChangedListener((TextWatcher)this.textWatcher);
        }
        this.choreographer = Choreographer.getInstance();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        HyperChronometer hyperChronometer = this.sameWidthDigit;
        if (hyperChronometer != null) {
            hyperChronometer.removeTextChangedListener((TextWatcher)this.textWatcher);
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

    public final void setSameWidthDigitInfo(SameWidthDigitInfo sameWidthDigitInfo) {
        this.sameWidthDigitInfo = sameWidthDigitInfo;
    }

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        Object object = this.title;
        Object var4_4 = null;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            object.width = -2;
        }
        object = this.sameWidthDigit;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            object.width = -2;
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

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @Override
    public void updateWidth(int n) {
        Object object;
        void var10_9;
        float f2;
        int n2;
        int n3;
        DynamicIslandUtils dynamicIslandUtils;
        Object object2;
        block32: {
            block31: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("updateWidth: ");
                ((StringBuilder)object2).append(n);
                Log.d((String)TAG, (String)((StringBuilder)object2).toString());
                dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
                if (dynamicIslandUtils.isDynamicIslandPadNoPropOnce(this.getDynamicIslandData())) {
                    n3 = n - this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding) - this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding_pad);
                    n = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding_cutout);
                } else {
                    n3 = n - this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding) - this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding);
                    n = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding_cutout);
                }
                n2 = n3 - n;
                f2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_padding_inner);
                object2 = this.title;
                if (object2 != null && object2.getVisibility() == 0) {
                    TimerTextEffectView timerTextEffectView = this.title;
                } else {
                    HyperChronometer hyperChronometer = this.sameWidthDigit;
                }
                this.setFixedFont((TextView)this.sameWidthDigit);
                object2 = var10_9 instanceof HyperChronometerPlugin ? (HyperChronometerPlugin)var10_9 : null;
                if (object2 == null || (object2 = object2.getTargetDisplayText()) == null) break block31;
                object2 = object = object2.toString();
                if (object != null) break block32;
            }
            object2 = var10_9 != null && (object2 = var10_9.getText()) != null ? object2.toString() : null;
        }
        int n4 = this.getTextViewWidth((TextView)var10_9, (String)object2);
        TimerTextEffectView timerTextEffectView = this.content;
        object = this.sameWidthDigitInfo;
        object = object != null ? ((SameWidthDigitInfo)object).getContent() : null;
        n3 = this.getTextViewWidth((TextView)timerTextEffectView, (String)object);
        float f3 = n4 + n3;
        float f4 = n3 > 0 ? f2 : 0.0f;
        float f5 = f3 + f4;
        object = new StringBuilder();
        ((StringBuilder)object).append("totalWidth: ");
        ((StringBuilder)object).append(f5);
        ((StringBuilder)object).append("\uff0ctargetStr: ");
        ((StringBuilder)object).append((String)object2);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        if (var10_9 != null) {
            f4 = !CommonUtils.isLayoutRtl((Context)this.getContext()) ? (float)n4 : 0.0f;
            var10_9.setPivotX(f4);
        }
        if (var10_9 != null && var10_9.getVisibility() == 0 && ((object2 = this.content) == null || object2.getVisibility() != 0)) {
            var10_9.setPivotY((float)var10_9.getHeight() / 2.0f);
        } else {
            n = var10_9 != null ? var10_9.getHeight() : this.getContext().getResources().getDimensionPixelSize(R.dimen.island_title_height);
            f4 = n;
            if (var10_9 != null) {
                var10_9.setPivotY(f4 - (float)this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_content_margin_bottom));
            }
        }
        f3 = n2;
        if (f5 > f3) {
            void var10_13;
            f4 = 0.0f;
            this.digitAnimation(0.79f, f4);
            this.contentAnimation(f4);
            if (var10_9 != null) {
                f4 = !CommonUtils.isLayoutRtl((Context)this.getContext()) ? (float)n4 : 0.0f;
                var10_9.setPivotX(f4);
            }
            if (var10_9 != null) {
                var10_9.setPivotY((float)var10_9.getHeight() - (float)this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_content_margin_bottom));
            }
            f4 = n4;
            f5 = n3;
            if (n3 <= 0) {
                f2 = 0.0f;
            }
            f2 = (float)Math.floor(f4 * 0.79f + f5 + f2);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("newTotal: ");
            ((StringBuilder)object2).append(f2);
            ((StringBuilder)object2).append(" ");
            ((StringBuilder)object2).append(n2);
            Log.d((String)TAG, (String)((StringBuilder)object2).toString());
            if (f2 > f3) {
                f2 -= f3;
                if (CommonUtils.isLayoutRtl((Context)this.getContext())) {
                    f2 = -f2;
                }
                this.digitAnimation(0.79f, f2);
                this.contentAnimation(f2);
                object2 = this.textShade;
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                this.setTextShade(this.textShade);
            } else {
                object2 = this.textShade;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
            }
            object2 = this.content;
            object2 = object2 != null ? object2.getLayoutParams() : null;
            if (object2 != null) {
                ((ViewGroup.LayoutParams)object2).width = n3;
            }
            object2 = var10_9 != null ? var10_9.getLayoutParams() : null;
            if (object2 != null) {
                ((ViewGroup.LayoutParams)object2).width = n4;
            }
            object2 = this.content;
            if (object2 != null) {
                object2.requestLayout();
            }
            if (var10_9 != null) {
                var10_9.requestLayout();
            }
            object2 = (object2 = this.getView()) != null ? Integer.valueOf(object2.getWidth()) : null;
            ViewGroup viewGroup = this.titleContainer;
            if (viewGroup != null) {
                Integer n5 = viewGroup.getWidth();
            } else {
                Object var10_12 = null;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("updateWidth: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(" ");
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append(" ");
            ((StringBuilder)object).append(var10_13);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            n = dynamicIslandUtils.dpToPx(8, this.getContext());
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("updateWidth1: ");
            ((StringBuilder)object2).append(n4);
            ((StringBuilder)object2).append(" ");
            ((StringBuilder)object2).append(n3);
            ((StringBuilder)object2).append(" ");
            ((StringBuilder)object2).append(n);
            Log.d((String)TAG, (String)((StringBuilder)object2).toString());
            super.updateWidth(n2);
            return;
        }
        this.digitAnimation(1.0f, 0.0f);
        this.contentAnimation(0.0f);
        object2 = this.textShade;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.content;
        object2 = object2 != null ? object2.getLayoutParams() : null;
        if (object2 != null) {
            ((ViewGroup.LayoutParams)object2).width = n3;
        }
        object2 = var10_9 != null ? var10_9.getLayoutParams() : null;
        if (object2 != null) {
            ((ViewGroup.LayoutParams)object2).width = n4;
        }
        object2 = this.content;
        if (object2 != null) {
            object2.requestLayout();
        }
        if (var10_9 != null) {
            var10_9.requestLayout();
        }
    }
}
