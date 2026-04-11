/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;
import miui.systemui.util.CommonUtils;

public final class ModuleMarkViewHolder
extends ModuleViewHolder {
    private View buttonContainer;
    private View container;
    private final boolean island;
    private ImageView mark;
    private String pic;

    public ModuleMarkViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void bind(Template var1_1, StatusBarNotification var2_2) {
        block19: {
            o.g((Object)var1_1, (String)"template");
            o.g((Object)var2_2, (String)"sbn");
            super.bind(var1_1, var2_2);
            var3_3 = this.isDark();
            var5_4 = null;
            if (!var3_3) ** GOTO lbl14
            var4_5 = var1_1.getPicInfo();
            if (var4_5 != null) {
                var4_5 = var4_5.getPicDark();
            } else {
                while (true) {
                    var4_5 = null;
                    break block19;
                    break;
                }
lbl14:
                // 1 sources

                if ((var4_5 = var1_1.getPicInfo()) == null) ** continue;
                var4_5 = var4_5.getPic();
            }
        }
        this.pic = var4_5;
        var4_5 = this.container;
        if (var4_5 != null) {
            var4_5.setVisibility(0);
        }
        if (o.c((Object)this.getModule(), (Object)"moduleMark1")) {
            var1_1 = this.mark;
            if (var1_1 != null) {
                var1_1.setVisibility(0);
            }
            var1_1 = this.mark;
            if (var1_1 != null) {
                if (this.getIcon(this.pic, var2_2) != null) {
                    ModuleViewHolderExtKt.showMarkIcon((ImageView)var1_1, this.getIcon(this.pic, var2_2), this.getContext(this.island));
                } else {
                    ModuleViewHolderExtKt.showAppIcon((ImageView)var1_1, var2_2, this.getContext(this.island));
                }
            }
        } else if (!o.c((Object)this.getModule(), (Object)"moduleMark2") && !o.c((Object)this.getModule(), (Object)"moduleMark3")) {
            var4_5 = this.buttonContainer;
            if (var4_5 != null) {
                var4_5.setVisibility(0);
            }
            ModuleViewHolder.setActionData$default(this, var1_1, var2_2, false, 4, null);
        } else {
            var4_5 = this.getView();
            var1_1 = var5_4;
            if (var4_5 != null) {
                var1_1 = (ImageView)var4_5.findViewById(R.id.focus_mark_large_icon);
            }
            if (var1_1 != null) {
                ModuleViewHolderExtKt.showMarkIcon((ImageView)var1_1, this.getIcon(this.pic, var2_2), this.getContext(this.island));
            }
        }
        if (CommonUtils.isLayoutRtl((Context)this.getCtx())) {
            var1_1 = this.getView();
            if (var1_1 != null) {
                var1_1.setLayoutDirection(1);
            }
        } else {
            var1_1 = this.getView();
            if (var1_1 != null) {
                var1_1.setLayoutDirection(0);
            }
        }
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        block6: {
            block7: {
                o.g((Object)string, (String)"module");
                super.initView(string);
                this.setModule(string);
                switch (string.hashCode()) {
                    default: {
                        break;
                    }
                    case -1211998214: {
                        if (!string.equals("moduleMark3")) break;
                        this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_mark_3, this.getRootView()));
                        break block6;
                    }
                    case -1211998215: {
                        if (!string.equals("moduleMark2")) break;
                        this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_mark_2, this.getRootView()));
                        break block6;
                    }
                    case -1211998216: {
                        if (string.equals("moduleMark1")) break block7;
                    }
                }
                this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_mark_4, this.getRootView()));
                break block6;
            }
            this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_mark_1, this.getRootView()));
        }
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? string.findViewById(R.id.focus_container_module_mark) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.focus_mark_small_icon) : null;
        this.mark = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = view.findViewById(R.id.focus_button_container);
        }
        this.buttonContainer = string;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
