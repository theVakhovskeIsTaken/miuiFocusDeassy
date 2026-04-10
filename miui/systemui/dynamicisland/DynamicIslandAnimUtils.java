/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.os.Handler
 *  android.os.SystemProperties
 *  android.provider.MiuiSettings$Global
 *  android.provider.Settings$Global
 *  android.util.Log
 *  android.util.MiuiMultiWindowUtils
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.MetadataUtils
 */
package miui.systemui.dynamicisland;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.MiuiSettings;
import android.provider.Settings;
import android.util.Log;
import android.util.MiuiMultiWindowUtils;
import kotlin.jvm.internal.o;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.MetadataUtils;

public final class DynamicIslandAnimUtils {
    private static final boolean ELEMENT_TRANSITION_SUPPORTED;
    public static final DynamicIslandAnimUtils INSTANCE;
    private static final String KEY_HOME_SUPPORT_DYNAMIC_ISLAND_HIGH = "support_dynamic_island";
    private static final String KEY_HOME_SUPPORT_DYNAMIC_ISLAND_MIDDLE = "support_dynamic_island_middle";
    public static final String TAG = "DynamicIslandAnimUtils";
    private static final boolean notSupportInterruptAnim;
    private static ContentObserver sHomeElementContentObserverForHigh;
    private static ContentObserver sHomeElementContentObserverForMiddle;
    private static boolean sHomeSupportedDynamicIslandForHigh;
    private static boolean sHomeSupportedDynamicIslandForMiddle;

    static {
        INSTANCE = new DynamicIslandAnimUtils();
        ELEMENT_TRANSITION_SUPPORTED = SystemProperties.getBoolean((String)"persist.sys.element_transition_supported", (boolean)false);
        notSupportInterruptAnim = CommonUtils.INSTANCE.getIS_TABLET();
    }

    private DynamicIslandAnimUtils() {
    }

    public static final /* synthetic */ boolean access$getSHomeSupportedDynamicIslandForHigh$p() {
        return sHomeSupportedDynamicIslandForHigh;
    }

    public static final /* synthetic */ boolean access$getSHomeSupportedDynamicIslandForMiddle$p() {
        return sHomeSupportedDynamicIslandForMiddle;
    }

    public static final /* synthetic */ void access$setSHomeSupportedDynamicIslandForHigh$p(boolean bl) {
        sHomeSupportedDynamicIslandForHigh = bl;
    }

    public static final /* synthetic */ void access$setSHomeSupportedDynamicIslandForMiddle$p(boolean bl) {
        sHomeSupportedDynamicIslandForMiddle = bl;
    }

    public final boolean featureDynamicIslandIsMiddle() {
        return sHomeSupportedDynamicIslandForMiddle;
    }

    public final boolean featureDynamicIslandNoElement() {
        boolean bl = !sHomeSupportedDynamicIslandForHigh && !sHomeSupportedDynamicIslandForMiddle;
        return bl;
    }

    public final boolean featureDynamicIslandNoElementButFreeform() {
        boolean bl = !sHomeSupportedDynamicIslandForHigh && !sHomeSupportedDynamicIslandForMiddle && this.getSUPPORT_FREEFORM();
        return bl;
    }

    public final boolean featureDynamicIslandNoNeedFakeView() {
        boolean bl = ELEMENT_TRANSITION_SUPPORTED;
        boolean bl2 = sHomeSupportedDynamicIslandForHigh;
        boolean bl3 = sHomeSupportedDynamicIslandForMiddle;
        boolean bl4 = this.getSUPPORT_FREEFORM();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ELEMENT_TRANSITION_SUPPORTED: ");
        stringBuilder.append(bl);
        stringBuilder.append(", sHomeSupportedDynamicIslandForHigh: ");
        stringBuilder.append(bl2);
        stringBuilder.append(", sHomeSupportedDynamicIslandForMiddle: ");
        stringBuilder.append(bl3);
        stringBuilder.append(", SUPPORT_FREEFORM: ");
        stringBuilder.append(bl4);
        Log.d((String)TAG, (String)stringBuilder.toString());
        bl3 = !sHomeSupportedDynamicIslandForHigh && !sHomeSupportedDynamicIslandForMiddle && !this.getSUPPORT_FREEFORM();
        return bl3;
    }

    public final boolean getNotSupportInterruptAnim() {
        return notSupportInterruptAnim;
    }

    public final boolean getSUPPORT_FREEFORM() {
        return MiuiMultiWindowUtils.supportFreeform();
    }

    public final boolean getSupportMediaFreeForm(Context context) {
        o.g((Object)context, (String)"<this>");
        return MetadataUtils.isMediaIslandSupportFreeForm((Context)context);
    }

    public final void registerHomeDynamicIslandContentObserver(Context context) {
        ContentObserver contentObserver;
        o.g((Object)context, (String)"context");
        Log.d((String)TAG, (String)"registerHomeDynamicIslandContentObserver");
        if (sHomeElementContentObserverForHigh == null) {
            sHomeElementContentObserverForHigh = new ContentObserver(context, new Handler()){
                final Context $context;
                {
                    this.$context = context;
                    super(handler);
                }

                public void onChange(boolean bl) {
                    Object object = DynamicIslandAnimUtils.INSTANCE;
                    DynamicIslandAnimUtils.access$setSHomeSupportedDynamicIslandForHigh$p(MiuiSettings.Global.getBoolean((ContentResolver)this.$context.getContentResolver(), (String)"support_dynamic_island"));
                    bl = DynamicIslandAnimUtils.access$getSHomeSupportedDynamicIslandForHigh$p();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("onChange: sHomeSupportedDynamicIslandForHigh: ");
                    ((StringBuilder)object).append(bl);
                    Log.d((String)"DynamicIslandAnimUtils", (String)((StringBuilder)object).toString());
                }
            };
            context.getContentResolver().registerContentObserver(Settings.Global.getUriFor((String)KEY_HOME_SUPPORT_DYNAMIC_ISLAND_HIGH), false, sHomeElementContentObserverForHigh, -1);
        }
        if ((contentObserver = sHomeElementContentObserverForHigh) != null) {
            contentObserver.onChange(false);
        }
        if (sHomeElementContentObserverForMiddle == null) {
            sHomeElementContentObserverForMiddle = new ContentObserver(context, new Handler()){
                final Context $context;
                {
                    this.$context = context;
                    super(handler);
                }

                public void onChange(boolean bl) {
                    Object object = DynamicIslandAnimUtils.INSTANCE;
                    DynamicIslandAnimUtils.access$setSHomeSupportedDynamicIslandForMiddle$p(MiuiSettings.Global.getBoolean((ContentResolver)this.$context.getContentResolver(), (String)"support_dynamic_island_middle"));
                    bl = DynamicIslandAnimUtils.access$getSHomeSupportedDynamicIslandForMiddle$p();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("onChange: sHomeSupportedDynamicIslandForMiddle: ");
                    ((StringBuilder)object).append(bl);
                    Log.d((String)"DynamicIslandAnimUtils", (String)((StringBuilder)object).toString());
                }
            };
            context.getContentResolver().registerContentObserver(Settings.Global.getUriFor((String)KEY_HOME_SUPPORT_DYNAMIC_ISLAND_MIDDLE), false, sHomeElementContentObserverForMiddle, -1);
        }
        if ((context = sHomeElementContentObserverForMiddle) != null) {
            context.onChange(false);
        }
    }

    public final boolean supportFreeformNotHigh() {
        boolean bl = !sHomeSupportedDynamicIslandForHigh && this.getSUPPORT_FREEFORM();
        return bl;
    }

    public final boolean supportShowElementAndFreeformAnim() {
        boolean bl = ELEMENT_TRANSITION_SUPPORTED && sHomeSupportedDynamicIslandForHigh && this.getSUPPORT_FREEFORM();
        return bl;
    }

    public final boolean supportShowElementAnim() {
        boolean bl = ELEMENT_TRANSITION_SUPPORTED && sHomeSupportedDynamicIslandForHigh;
        return bl;
    }
}
