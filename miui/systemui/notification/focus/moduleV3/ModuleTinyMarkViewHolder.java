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

public final class ModuleTinyMarkViewHolder
extends ModuleViewHolder {
    private View buttonContainer;
    private View container;
    private ImageView mark;
    private String pic;

    public ModuleTinyMarkViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    @Override
    public void bind(Template var1_1, StatusBarNotification var2_2) {
        block17: {
            block16: {
                o.g((Object)var1_1 /* !! */ , (String)"template");
                o.g((Object)var2_2, (String)"sbn");
                super.bind(var1_1 /* !! */ , var2_2);
                if (!this.isDark()) break block16;
                var3_3 = var1_1 /* !! */ .getPicInfo();
                if (var3_3 == null) ** GOTO lbl-1000
                var3_3 = var3_3.getPicDark();
                break block17;
            }
            var3_3 = var1_1 /* !! */ .getPicInfo();
            if (var3_3 != null) {
                var3_3 = var3_3.getPic();
            } else lbl-1000:
            // 2 sources

            {
                var3_3 = null;
            }
        }
        this.pic = var3_3;
        var3_3 = this.container;
        if (var3_3 != null) {
            var3_3.setVisibility(0);
        }
        var3_3 = this.getModule();
        if (var3_3 != null) {
            tmp = -1;
            switch (var3_3.hashCode()) {
                case -1211998214: {
                    if (!var3_3.equals("moduleMark3")) break;
                    tmp = 1;
                    break;
                }
                case -1211998215: {
                    if (!var3_3.equals("moduleMark2")) break;
                    tmp = 1;
                    break;
                }
                case -1211998216: {
                    if (!var3_3.equals("moduleMark1")) break;
                    tmp = 2;
                    break;
                }
            }
            switch (tmp) {
                default: {
                    break;
                }
                case 1: {
                    var1_1 /* !! */  = this.getView();
                    var1_1 /* !! */  = var1_1 /* !! */  != null ? (ImageView)var1_1 /* !! */ .findViewById(R.id.focus_mark_large_icon) : null;
                    if (var1_1 /* !! */  == null) return;
                    ModuleViewHolderExtKt.showMarkIcon((ImageView)var1_1 /* !! */ , this.getIcon(this.pic, var2_2), ModuleViewHolder.getContext$default(this, false, 1, null));
                    return;
                }
                case 2: {
                    var1_1 /* !! */  = this.mark;
                    if (var1_1 /* !! */  != null) {
                        var1_1 /* !! */ .setVisibility(0);
                    }
                    var1_1 /* !! */  = this.mark;
                    if (var1_1 /* !! */  == null) return;
                    if (this.getIcon(this.pic, var2_2) != null) {
                        ModuleViewHolderExtKt.showMarkIcon((ImageView)var1_1 /* !! */ , this.getIcon(this.pic, var2_2), ModuleViewHolder.getContext$default(this, false, 1, null));
                        return;
                    }
                    ModuleViewHolderExtKt.showAppIcon((ImageView)var1_1 /* !! */ , var2_2, ModuleViewHolder.getContext$default(this, false, 1, null));
                    return;
                }
            }
        }
        if ((var3_3 = this.buttonContainer) != null) {
            var3_3.setVisibility(0);
        }
        ModuleViewHolder.setActionData$default(this, var1_1 /* !! */ , var2_2, false, 4, null);
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
                        this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_tiny_mark_3, this.getRootView()));
                        break block6;
                    }
                    case -1211998215: {
                        if (!string.equals("moduleMark2")) break;
                        this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_tiny_mark_2, this.getRootView()));
                        break block6;
                    }
                    case -1211998216: {
                        if (string.equals("moduleMark1")) break block7;
                    }
                }
                this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_tiny_mark_4, this.getRootView()));
                break block6;
            }
            this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_tiny_mark_1, this.getRootView()));
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
