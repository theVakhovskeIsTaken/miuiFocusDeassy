/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Action
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Outline
 *  android.graphics.drawable.Icon
 *  android.os.Process
 *  android.os.UserHandle
 *  android.service.notification.StatusBarNotification
 *  android.text.Spanned
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  android.widget.ImageView
 *  androidx.core.text.HtmlCompat
 *  com.android.systemui.miui.notification.R$dimen
 *  e1.n
 *  kotlin.jvm.internal.o
 *  miui.systemui.dynamicisland.DynamicIslandUtils
 *  miui.systemui.dynamicisland.R$id
 *  miui.systemui.notification.NotificationUtil
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.FocusNotificationUtil
 */
package miui.systemui.notification.focus.moduleV3.ext;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Icon;
import android.os.Process;
import android.os.UserHandle;
import android.service.notification.StatusBarNotification;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.core.text.HtmlCompat;
import com.android.systemui.miui.notification.R;
import e1.n;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.notification.NotificationUtil;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.FocusNotificationUtil;

public final class ModuleViewHolderExtKt {
    public static final String TAG = "ActionClickLog";

    public static final boolean containsHTML(String string) {
        o.g((Object)string, (String)"<this>");
        boolean bl = n.n((CharSequence)string);
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        Spanned spanned = HtmlCompat.fromHtml((String)string, (int)0);
        Object[] objectArray = spanned.getSpans(0, spanned.length(), Object.class);
        o.f((Object)objectArray, (String)"getSpans(...)");
        boolean bl3 = objectArray.length == 0;
        if (!bl3 || !o.c((Object)spanned.toString(), (Object)string)) {
            bl2 = true;
        }
        return bl2;
    }

    public static final int customLength(String string) {
        o.g((Object)string, (String)"<this>");
        int n2 = string.length();
        int n3 = 0;
        for (int i = 0; i < n2; ++i) {
            int n4;
            char c = string.charAt(i);
            boolean bl = Character.isDigit(c);
            int n5 = 1;
            if (bl) {
                n4 = n5;
            } else if (Character.isLetter(c) && c < '\u0080') {
                n4 = n5;
            } else {
                n4 = n5;
                if ('\u4e00' <= c) {
                    n4 = n5;
                    if (c < '\ua000') {
                        n4 = 2;
                    }
                }
            }
            n3 += n4;
        }
        return n3;
    }

    public static final int dpToPx(Context context, int n2) {
        if (context == null) {
            return (int)(Resources.getSystem().getDisplayMetrics().density * (float)n2);
        }
        float f = context.getResources().getDisplayMetrics().density;
        return (int)((float)n2 * f);
    }

    public static final boolean findViewByTagId(View view, int n2) {
        o.g((Object)view, (String)"view");
        Object object = view.getTag(n2);
        boolean bl = false;
        if (object != null && object instanceof Boolean) {
            if (((Boolean)object).booleanValue() || view.getVisibility() != 0 || view.getAlpha() == 0.0f) {
                bl = true;
            }
            return bl;
        }
        if (view.getParent() != null && view.getParent() instanceof View) {
            view = view.getParent();
            o.e((Object)view, (String)"null cannot be cast to non-null type android.view.View");
            return ModuleViewHolderExtKt.findViewByTagId(view, n2);
        }
        return false;
    }

    public static final Context getContextAsUser(UserHandle userHandle, Context context) {
        o.g((Object)userHandle, (String)"user");
        o.g((Object)context, (String)"context");
        if (o.c((Object)Process.myUserHandle(), (Object)userHandle)) {
            return context;
        }
        userHandle = context.createContextAsUser(userHandle, 0);
        o.f((Object)userHandle, (String)"createContextAsUser(...)");
        return userHandle;
    }

    public static final ViewOutlineProvider roundedCornerOutlineProvider(View view, int n2) {
        o.g((Object)view, (String)"<this>");
        return new ViewOutlineProvider(view.getContext().getResources().getDimension(n2)){
            final float $cornerRadius;
            {
                this.$cornerRadius = f2;
            }

            public void getOutline(View view, Outline outline) {
                if (outline != null && view != null) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$cornerRadius);
                }
            }
        };
    }

    public static final void sendCollapseBroadcast(Context context) {
        o.g((Object)context, (String)"ctx");
        Intent intent = new Intent();
        intent.setAction("com.miui.action.ACTION_COLLAPSE_ISLAND");
        context.sendBroadcast(intent);
    }

    public static final boolean sendWithCollapse(PendingIntent pendingIntent, Notification.Action action, Context context, View object, boolean bl, StatusBarNotification statusBarNotification) {
        o.g((Object)pendingIntent, (String)"<this>");
        o.g((Object)action, (String)"action");
        o.g((Object)context, (String)"ctx");
        o.g((Object)object, (String)"view");
        o.g((Object)statusBarNotification, (String)"sbn");
        boolean bl2 = pendingIntent.isActivity();
        int n2 = object.getVisibility();
        float f2 = object.getAlpha();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("island action clicked: ");
        stringBuilder.append(bl);
        stringBuilder.append(", isActivity:");
        stringBuilder.append(bl2);
        stringBuilder.append(", vis:");
        stringBuilder.append(n2);
        stringBuilder.append(" alpha:");
        stringBuilder.append(f2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (ModuleViewHolder.Companion.isContinuousClick(statusBarNotification.getKey())) {
            return false;
        }
        if (bl) {
            bl = ModuleViewHolderExtKt.findViewByTagId((View)object, R.id.dynamic_island_animating_tag);
            object = new StringBuilder();
            ((StringBuilder)object).append("island animating: ");
            ((StringBuilder)object).append(bl);
            Log.e((String)TAG, (String)((StringBuilder)object).toString());
            if (bl) {
                return false;
            }
        } else if (ModuleViewHolderExtKt.findViewByTagId((View)object, R.id.dynamic_island_modal_tag)) {
            CommonUtils.INSTANCE.exitModal();
        }
        FocusNotificationUtil.onActionClick((PendingIntent)pendingIntent);
        if (pendingIntent.isActivity() || action.getExtras().getBoolean("click_with_collapse", false)) {
            CommonUtils.INSTANCE.collapseControlCenter();
            ModuleViewHolderExtKt.sendCollapseBroadcast(context);
        }
        return true;
    }

    public static /* synthetic */ boolean sendWithCollapse$default(PendingIntent pendingIntent, Notification.Action action, Context context, View view, boolean bl, StatusBarNotification statusBarNotification, int n, Object object) {
        if ((n & 8) != 0) {
            bl = false;
        }
        return ModuleViewHolderExtKt.sendWithCollapse(pendingIntent, action, context, view, bl, statusBarNotification);
    }

    public static final void showAppIcon(ImageView imageView, StatusBarNotification statusBarNotification, Context context) {
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)context, (String)"ctx");
        String string = NotificationUtil.getSbnTargetPkg((Context)context, (StatusBarNotification)statusBarNotification);
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(DynamicIslandUtils.INSTANCE.getAppIcon(context, string, Integer.valueOf(statusBarNotification.getUser().getIdentifier())));
            imageView.setOutlineProvider(ModuleViewHolderExtKt.roundedCornerOutlineProvider((View)imageView, R.dimen.notification_custom_icon_corner_radius));
            imageView.setClipToOutline(true);
            imageView.invalidate();
        }
    }

    public static final void showMarkIcon(ImageView imageView, Icon icon, Context context) {
        o.g((Object)context, (String)"ctx");
        if (icon != null) {
            if (imageView != null) {
                imageView.setVisibility(0);
                imageView.setImageIcon(icon);
                imageView.setOutlineProvider(ModuleViewHolderExtKt.roundedCornerOutlineProvider((View)imageView, R.dimen.notification_custom_icon_corner_radius));
                imageView.setClipToOutline(true);
                imageView.invalidate();
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
