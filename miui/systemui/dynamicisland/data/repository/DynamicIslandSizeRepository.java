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
 *  f1.E
 *  i1.E
 *  i1.I
 *  i1.K
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.u
 *  kotlin.jvm.internal.o
 *  miui.systemui.ui.data.repository.ConfigurationRepository
 */
package miui.systemui.dynamicisland.data.repository;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import f1.E;
import i1.I;
import i1.K;
import i1.f;
import i1.g;
import i1.h;
import i1.u;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository$padContentViewDimensions$lambda$4$;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository$phoneContentViewDimensions$lambda$1$;
import miui.systemui.ui.data.repository.ConfigurationRepository;

@DynamicIslandScope
public final class DynamicIslandSizeRepository {
    private final u _cutoutHeight;
    private final u _cutoutY;
    private final u _expandedIslandWidth;
    private final u _headsUpStatusBarPadding;
    private final u _islandWidthParams;
    private final u _statusBarDatePosX;
    private final ConfigurationRepository configRepository;
    private final Context context;
    private final I cutoutHeight;
    private final I cutoutY;
    private final I expandedIslandWidth;
    private final I headsUpStatusBarPadding;
    private final I islandWidthParams;
    private final I padContentViewDimensions;
    private final I phoneContentViewDimensions;
    private final E scope;
    private int statusBarDateMarginTop;
    private final I statusBarDatePosX;

    public DynamicIslandSizeRepository(@DynamicIsland E e, Context object, ConfigurationRepository configurationRepository) {
        u u2;
        o.g((Object)e, (String)"scope");
        o.g((Object)object, (String)"context");
        o.g((Object)configurationRepository, (String)"configRepository");
        this.scope = e;
        this.context = object;
        this.configRepository = configurationRepository;
        Float f2 = Float.valueOf(0.0f);
        this._cutoutY = u2 = K.a((Object)f2);
        this.cutoutY = h.b((u)u2);
        f2 = K.a((Object)f2);
        this._cutoutHeight = f2;
        this.cutoutHeight = h.b((u)f2);
        f2 = K.a((Object)0);
        this._statusBarDatePosX = f2;
        this.statusBarDatePosX = h.b((u)f2);
        f2 = K.a((Object)object.getResources().getDimensionPixelSize(R.dimen.expanded_max_width));
        this._expandedIslandWidth = f2;
        this.expandedIslandWidth = h.b((u)f2);
        object = K.a((Object)DynamicIslandUtils.INSTANCE.dpToPx(8, (Context)object));
        this._headsUpStatusBarPadding = object;
        this.headsUpStatusBarPadding = h.b((u)object);
        object = K.a((Object)new Object(0.0f, 0.0f, 0.0f){
            private final float batteryWidth;
            private final float clockWidth;
            private final float maxWidth;
            {
                this.maxWidth = f;
                this.clockWidth = f2;
                this.batteryWidth = f3;
            }

            public static /* synthetic */ IslandWidthParams copy$default(IslandWidthParams islandWidthParams, float f, float f2, float f3, int n, Object object) {
                if ((n & 1) != 0) {
                    f = islandWidthParams.maxWidth;
                }
                if ((n & 2) != 0) {
                    f2 = islandWidthParams.clockWidth;
                }
                if ((n & 4) != 0) {
                    f3 = islandWidthParams.batteryWidth;
                }
                return islandWidthParams.copy(f, f2, f3);
            }

            public final float component1() {
                return this.maxWidth;
            }

            public final float component2() {
                return this.clockWidth;
            }

            public final float component3() {
                return this.batteryWidth;
            }

            public final IslandWidthParams copy(float f, float f2, float f3) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (!(object instanceof IslandWidthParams)) {
                    return false;
                }
                object = object;
                if (Float.compare(this.maxWidth, object.maxWidth) != 0) {
                    return false;
                }
                if (Float.compare(this.clockWidth, object.clockWidth) != 0) {
                    return false;
                }
                return Float.compare(this.batteryWidth, object.batteryWidth) == 0;
            }

            public final float getBatteryWidth() {
                return this.batteryWidth;
            }

            public final float getClockWidth() {
                return this.clockWidth;
            }

            public final float getMaxWidth() {
                return this.maxWidth;
            }

            public int hashCode() {
                return (Float.hashCode(this.maxWidth) * 31 + Float.hashCode(this.clockWidth)) * 31 + Float.hashCode(this.batteryWidth);
            }

            public String toString() {
                float f = this.maxWidth;
                float f2 = this.clockWidth;
                float f3 = this.batteryWidth;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("IslandWidthParams(maxWidth=");
                stringBuilder.append(f);
                stringBuilder.append(", clockWidth=");
                stringBuilder.append(f2);
                stringBuilder.append(", batteryWidth=");
                stringBuilder.append(f3);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        });
        this._islandWidthParams = object;
        this.islandWidthParams = h.b((u)object);
        object = new f(h.y((f)configurationRepository.getOnConfigChanged(), (U0.o)new U0.o(null){
            private Object L$0;
            int label;

            public final d create(Object object, d object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(g g2, d d2) {
                return (this.create(g2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    object = (g)this.L$0;
                    s s2 = s.a;
                    this.label = 1;
                    if (object.emit((Object)s2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }), this){
            final f $this_unsafeTransform$inlined;
            final DynamicIslandSizeRepository this$0;
            {
                this.$this_unsafeTransform$inlined = f2;
                this.this$0 = dynamicIslandSizeRepository;
            }

            public Object collect(g object, d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object, this.this$0){
                    final g $this_unsafeFlow;
                    final DynamicIslandSizeRepository this$0;
                    {
                        this.$this_unsafeFlow = g2;
                        this.this$0 = dynamicIslandSizeRepository;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, d var2_2) {
                        if (!(var2_2 /* !! */  instanceof phoneContentViewDimensions$lambda$1$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var4_3 /* !! */  = var2_2 /* !! */ ;
                        var3_4 = var4_3 /* !! */ .label;
                        if ((var3_4 & -2147483648) != 0) {
                            var4_3 /* !! */ .label = var3_4 + -2147483648;
                            var2_2 /* !! */  = var4_3 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final phoneContentViewDimensions$lambda$1$$inlined$map$1$2 this$0;
                                {
                                    this.this$0 = var1_1;
                                    super(d2);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (d)this);
                                }
                            };
                        }
                        var5_5 = var2_2 /* !! */ .result;
                        var4_3 /* !! */  = c.c();
                        var3_4 = var2_2 /* !! */ .label;
                        if (var3_4 == 0) ** GOTO lbl17
                        if (var3_4 == 1) {
                            k.b((Object)var5_5);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                            // 1 sources

                            k.b((Object)var5_5);
                            var5_5 = this.$this_unsafeFlow;
                            var1_1 = (s)var1_1;
                            var1_1 = DynamicIslandSizeRepository.access$phoneContentViewDimensions$lambda$1$load(this.this$0);
                            var2_2 /* !! */ .label = 1;
                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                return var4_3 /* !! */ ;
                            }
                        }
                        return s.a;
                    }
                }, d2)) == c.c()) {
                    return object;
                }
                return s.a;
            }
        };
        f2 = i1.E.a;
        this.phoneContentViewDimensions = h.B((f)object, (E)e, (i1.E)f2.c(), (Object)DynamicIslandSizeRepository.phoneContentViewDimensions$lambda$1$load(this));
        this.padContentViewDimensions = h.B((f)new f(h.y((f)configurationRepository.getOnConfigChanged(), (U0.o)new U0.o(null){
            private Object L$0;
            int label;

            public final d create(Object object, d object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(g g2, d d2) {
                return (this.create(g2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    object = (g)this.L$0;
                    s s2 = s.a;
                    this.label = 1;
                    if (object.emit((Object)s2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }), this){
            final f $this_unsafeTransform$inlined;
            final DynamicIslandSizeRepository this$0;
            {
                this.$this_unsafeTransform$inlined = f2;
                this.this$0 = dynamicIslandSizeRepository;
            }

            public Object collect(g object, d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object, this.this$0){
                    final g $this_unsafeFlow;
                    final DynamicIslandSizeRepository this$0;
                    {
                        this.$this_unsafeFlow = g2;
                        this.this$0 = dynamicIslandSizeRepository;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, d var2_2) {
                        if (!(var2_2 /* !! */  instanceof padContentViewDimensions$lambda$4$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var4_3 /* !! */  = var2_2 /* !! */ ;
                        var3_4 = var4_3 /* !! */ .label;
                        if ((var3_4 & -2147483648) != 0) {
                            var4_3 /* !! */ .label = var3_4 + -2147483648;
                            var2_2 /* !! */  = var4_3 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final padContentViewDimensions$lambda$4$$inlined$map$1$2 this$0;
                                {
                                    this.this$0 = var1_1;
                                    super(d2);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (d)this);
                                }
                            };
                        }
                        var5_5 = var2_2 /* !! */ .result;
                        var4_3 /* !! */  = c.c();
                        var3_4 = var2_2 /* !! */ .label;
                        if (var3_4 == 0) ** GOTO lbl17
                        if (var3_4 == 1) {
                            k.b((Object)var5_5);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                            // 1 sources

                            k.b((Object)var5_5);
                            var5_5 = this.$this_unsafeFlow;
                            var1_1 = (s)var1_1;
                            var1_1 = DynamicIslandSizeRepository.access$padContentViewDimensions$lambda$4$load$2(this.this$0);
                            var2_2 /* !! */ .label = 1;
                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                return var4_3 /* !! */ ;
                            }
                        }
                        return s.a;
                    }
                }, d2)) == c.c()) {
                    return object;
                }
                return s.a;
            }
        }, (E)e, (i1.E)f2.c(), (Object)DynamicIslandSizeRepository.padContentViewDimensions$lambda$4$load$2(this));
    }

    public static final /* synthetic */ PadContentViewDimensions access$padContentViewDimensions$lambda$4$load$2(DynamicIslandSizeRepository dynamicIslandSizeRepository) {
        return DynamicIslandSizeRepository.padContentViewDimensions$lambda$4$load$2(dynamicIslandSizeRepository);
    }

    public static final /* synthetic */ PhoneContentViewDimensions access$phoneContentViewDimensions$lambda$1$load(DynamicIslandSizeRepository dynamicIslandSizeRepository) {
        return DynamicIslandSizeRepository.phoneContentViewDimensions$lambda$1$load(dynamicIslandSizeRepository);
    }

    private static final PadContentViewDimensions padContentViewDimensions$lambda$4$load$2(DynamicIslandSizeRepository dynamicIslandSizeRepository) {
        return new Object(dynamicIslandSizeRepository.context.getResources().getDimensionPixelSize(R.dimen.island_height_pad), dynamicIslandSizeRepository.context.getResources().getDimensionPixelSize(R.dimen.big_island_min_width_pad), dynamicIslandSizeRepository.context.getResources().getDimensionPixelSize(R.dimen.big_island_max_width_pad), dynamicIslandSizeRepository.context.getResources().getDimensionPixelSize(R.dimen.big_island_fixed_margin_width_pad), dynamicIslandSizeRepository.context.getResources().getDimensionPixelSize(R.dimen.big_island_reduced_width_pad)){
            private final int bigIslandFixedMarginWidth;
            private final int bigIslandMaxWidth;
            private final int bigIslandMinWidth;
            private final int bigIslandReducedWidth;
            private final int islandViewHeight;
            {
                this.islandViewHeight = n;
                this.bigIslandMinWidth = n2;
                this.bigIslandMaxWidth = n3;
                this.bigIslandFixedMarginWidth = n4;
                this.bigIslandReducedWidth = n5;
            }

            public static /* synthetic */ PadContentViewDimensions copy$default(PadContentViewDimensions padContentViewDimensions, int n, int n2, int n3, int n4, int n5, int n6, Object object) {
                if ((n6 & 1) != 0) {
                    n = padContentViewDimensions.islandViewHeight;
                }
                if ((n6 & 2) != 0) {
                    n2 = padContentViewDimensions.bigIslandMinWidth;
                }
                if ((n6 & 4) != 0) {
                    n3 = padContentViewDimensions.bigIslandMaxWidth;
                }
                if ((n6 & 8) != 0) {
                    n4 = padContentViewDimensions.bigIslandFixedMarginWidth;
                }
                if ((n6 & 0x10) != 0) {
                    n5 = padContentViewDimensions.bigIslandReducedWidth;
                }
                return padContentViewDimensions.copy(n, n2, n3, n4, n5);
            }

            public final int component1() {
                return this.islandViewHeight;
            }

            public final int component2() {
                return this.bigIslandMinWidth;
            }

            public final int component3() {
                return this.bigIslandMaxWidth;
            }

            public final int component4() {
                return this.bigIslandFixedMarginWidth;
            }

            public final int component5() {
                return this.bigIslandReducedWidth;
            }

            public final PadContentViewDimensions copy(int n, int n2, int n3, int n4, int n5) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (!(object instanceof PadContentViewDimensions)) {
                    return false;
                }
                object = object;
                if (this.islandViewHeight != object.islandViewHeight) {
                    return false;
                }
                if (this.bigIslandMinWidth != object.bigIslandMinWidth) {
                    return false;
                }
                if (this.bigIslandMaxWidth != object.bigIslandMaxWidth) {
                    return false;
                }
                if (this.bigIslandFixedMarginWidth != object.bigIslandFixedMarginWidth) {
                    return false;
                }
                return this.bigIslandReducedWidth == object.bigIslandReducedWidth;
            }

            public final int getBigIslandFixedMarginWidth() {
                return this.bigIslandFixedMarginWidth;
            }

            public final int getBigIslandMaxWidth() {
                return this.bigIslandMaxWidth;
            }

            public final int getBigIslandMinWidth() {
                return this.bigIslandMinWidth;
            }

            public final int getBigIslandReducedWidth() {
                return this.bigIslandReducedWidth;
            }

            public final int getIslandViewHeight() {
                return this.islandViewHeight;
            }

            public int hashCode() {
                return (((Integer.hashCode(this.islandViewHeight) * 31 + Integer.hashCode(this.bigIslandMinWidth)) * 31 + Integer.hashCode(this.bigIslandMaxWidth)) * 31 + Integer.hashCode(this.bigIslandFixedMarginWidth)) * 31 + Integer.hashCode(this.bigIslandReducedWidth);
            }

            public String toString() {
                int n = this.islandViewHeight;
                int n2 = this.bigIslandMinWidth;
                int n3 = this.bigIslandMaxWidth;
                int n4 = this.bigIslandFixedMarginWidth;
                int n5 = this.bigIslandReducedWidth;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("PadContentViewDimensions(islandViewHeight=");
                stringBuilder.append(n);
                stringBuilder.append(", bigIslandMinWidth=");
                stringBuilder.append(n2);
                stringBuilder.append(", bigIslandMaxWidth=");
                stringBuilder.append(n3);
                stringBuilder.append(", bigIslandFixedMarginWidth=");
                stringBuilder.append(n4);
                stringBuilder.append(", bigIslandReducedWidth=");
                stringBuilder.append(n5);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    private static final PhoneContentViewDimensions phoneContentViewDimensions$lambda$1$load(DynamicIslandSizeRepository dynamicIslandSizeRepository) {
        return new Object(dynamicIslandSizeRepository.context.getResources().getDimensionPixelSize(R.dimen.island_height), dynamicIslandSizeRepository.context.getResources().getDimensionPixelSize(R.dimen.big_island_min_width)){
            private final int bigIslandMinWidth;
            private final int islandViewHeight;
            {
                this.islandViewHeight = n;
                this.bigIslandMinWidth = n2;
            }

            public static /* synthetic */ PhoneContentViewDimensions copy$default(PhoneContentViewDimensions phoneContentViewDimensions, int n, int n2, int n3, Object object) {
                if ((n3 & 1) != 0) {
                    n = phoneContentViewDimensions.islandViewHeight;
                }
                if ((n3 & 2) != 0) {
                    n2 = phoneContentViewDimensions.bigIslandMinWidth;
                }
                return phoneContentViewDimensions.copy(n, n2);
            }

            public final int component1() {
                return this.islandViewHeight;
            }

            public final int component2() {
                return this.bigIslandMinWidth;
            }

            public final PhoneContentViewDimensions copy(int n, int n2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public boolean equals(Object object) {
                if (this == object) {
                    return true;
                }
                if (!(object instanceof PhoneContentViewDimensions)) {
                    return false;
                }
                object = object;
                if (this.islandViewHeight != object.islandViewHeight) {
                    return false;
                }
                return this.bigIslandMinWidth == object.bigIslandMinWidth;
            }

            public final int getBigIslandMinWidth() {
                return this.bigIslandMinWidth;
            }

            public final int getIslandViewHeight() {
                return this.islandViewHeight;
            }

            public int hashCode() {
                return Integer.hashCode(this.islandViewHeight) * 31 + Integer.hashCode(this.bigIslandMinWidth);
            }

            public String toString() {
                int n = this.islandViewHeight;
                int n2 = this.bigIslandMinWidth;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("PhoneContentViewDimensions(islandViewHeight=");
                stringBuilder.append(n);
                stringBuilder.append(", bigIslandMinWidth=");
                stringBuilder.append(n2);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    public final I getCutoutHeight() {
        return this.cutoutHeight;
    }

    public final I getCutoutY() {
        return this.cutoutY;
    }

    public final I getExpandedIslandWidth() {
        return this.expandedIslandWidth;
    }

    public final I getHeadsUpStatusBarPadding() {
        return this.headsUpStatusBarPadding;
    }

    public final I getIslandWidthParams() {
        return this.islandWidthParams;
    }

    public final I getPadContentViewDimensions() {
        return this.padContentViewDimensions;
    }

    public final I getPhoneContentViewDimensions() {
        return this.phoneContentViewDimensions;
    }

    public final int getStatusBarDateMarginTop() {
        return this.statusBarDateMarginTop;
    }

    public final I getStatusBarDatePosX() {
        return this.statusBarDatePosX;
    }

    public final void setStatusBarDateMarginTop(int n) {
        this.statusBarDateMarginTop = n;
    }

    public final void updateCutoutHeight(float f2) {
        this._cutoutHeight.setValue((Object)Float.valueOf(f2));
    }

    public final void updateCutoutY(float f2) {
        this._cutoutY.setValue((Object)Float.valueOf(f2));
    }

    public final void updateExpandedIslandWidth(int n) {
        this._expandedIslandWidth.setValue((Object)n);
    }

    public final void updateHeadsUpStatusBarPadding(int n) {
        this._headsUpStatusBarPadding.setValue((Object)n);
    }

    public final void updateIslandMaxWidth(float f2, float f3, float f4) {
        this._islandWidthParams.setValue(new /* invalid duplicate definition of identical inner class */);
    }

    public final void updateStatusBarDatePos(int n) {
        this._statusBarDatePosX.setValue((Object)n);
    }
}
