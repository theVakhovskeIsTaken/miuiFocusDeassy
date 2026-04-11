/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import miui.systemui.notification.focus.FocusNotifPreHandler;

public final class a
implements InvocationHandler {
    public final FocusNotifPreHandler a;

    public /* synthetic */ a(FocusNotifPreHandler focusNotifPreHandler) {
        this.a = focusNotifPreHandler;
    }

    @Override
    public final Object invoke(Object object, Method method, Object[] objectArray) {
        return FocusNotifPreHandler.b(this.a, object, method, objectArray);
    }
}
