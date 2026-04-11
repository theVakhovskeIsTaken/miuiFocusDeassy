/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  T0.a
 *  c1.c
 *  kotlin.jvm.internal.A
 *  kotlin.jvm.internal.o
 *  miui.systemui.notification.NotificationUtil
 *  org.json.JSONObject
 */
package miui.systemui.notification.focus.template;

import T0.a;
import c1.c;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.o;
import miui.systemui.notification.NotificationUtil;
import miui.systemui.notification.focus.template.FocusTemplate;
import miui.systemui.notification.focus.template.TemplateBase;
import miui.systemui.notification.focus.template.TemplateBaseProgress;
import miui.systemui.notification.focus.template.TemplateRevert;
import miui.systemui.notification.focus.template.TemplateRevertOversize;
import miui.systemui.notification.focus.template.TemplateRevertProgress;
import org.json.JSONObject;

public final class FocusTemplateKt {
    private static boolean isFlipDevice;
    private static final Map<String, c> templateMaps;

    static {
        templateMaps = new LinkedHashMap<String, c>();
    }

    public static final /* synthetic */ boolean access$isFlipDevice$p() {
        return isFlipDevice;
    }

    public static final FocusTemplate covert(JSONObject object, boolean bl) {
        o.g((Object)object, (String)"focusParam");
        Constructor constructor = object.optString("scene");
        isFlipDevice = bl;
        FocusTemplateKt.initTemplateMap();
        constructor = templateMaps.get(constructor);
        object = constructor != null && (constructor = a.a((c)constructor)) != null && (constructor = ((Class)((Object)constructor)).getConstructor(JSONObject.class)) != null ? (FocusTemplate)constructor.newInstance(object) : null;
        return object;
    }

    public static final Map<String, c> getTemplateMaps() {
        return templateMaps;
    }

    public static final void initTemplateMap() {
        Map<String, c> map = templateMaps;
        if (!map.isEmpty()) {
            return;
        }
        map.put("templateBaseScene", A.b(TemplateBase.class));
        map.put("smartHomeAlert", A.b(TemplateBase.class));
        map.put("sos", A.b(TemplateBase.class));
        map.put("missedCalls", A.b(TemplateBase.class));
        map.put("templateBaseProgressScene", A.b(TemplateBaseProgress.class));
        map.put("carHailing", A.b(TemplateBaseProgress.class));
        map.put("events", A.b(TemplateBaseProgress.class));
        map.put("templateRevertScene", A.b(TemplateRevert.class));
        map.put("verifyCode", A.b(TemplateRevert.class));
        map.put("recorder", A.b(TemplateRevert.class));
        map.put("alarm", A.b(TemplateRevert.class));
        map.put("timer", A.b(TemplateRevert.class));
        map.put("templateRevertProgressScene", A.b(TemplateRevertProgress.class));
        map.put("foodDelivery", A.b(TemplateRevertProgress.class));
        map.put("templateRevertOversizeScene", A.b(TemplateRevertOversize.class));
        int n = map.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("v1 all temp=");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(map);
        NotificationUtil.debugLog((String)"FocusPlugin", (String)stringBuilder.toString());
    }
}
