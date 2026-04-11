/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.GradientDrawable$Orientation
 *  android.graphics.drawable.Icon
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ScaleDrawable
 *  android.service.notification.StatusBarNotification
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  b1.d
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Icon;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.service.notification.StatusBarNotification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import b1.d;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.util.CommonUtils;

public final class ModuleDecoPortProgressViewHolder
extends ModuleViewHolder {
    private View container;
    private ProgressBar progressBar;
    private ImageView progressIcon;
    private ImageView progressPoint1Se;
    private ImageView progressPoint1Un;
    private ImageView progressPoint2Se;
    private ImageView progressPoint2Un;
    private ImageView progressPointEnd;
    private ImageView progressPointMiddle;

    public ModuleDecoPortProgressViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    private final boolean hasProgressIcon(Template object, StatusBarNotification statusBarNotification) {
        Object object2 = ((Template)object).getProgressInfo();
        Object var5_4 = null;
        object2 = object2 != null ? ((ProgressInfo)object2).getPicForward() : null;
        Icon icon = this.getIcon((String)object2, statusBarNotification);
        object2 = ((Template)object).getProgressInfo();
        object2 = object2 != null ? ((ProgressInfo)object2).getPicEnd() : null;
        object2 = this.getIcon((String)object2, statusBarNotification);
        ProgressInfo progressInfo = ((Template)object).getProgressInfo();
        object = var5_4;
        if (progressInfo != null) {
            object = progressInfo.getPicMiddle();
        }
        object = this.getIcon((String)object, statusBarNotification);
        boolean bl = icon != null || object2 != null || object != null;
        return bl;
    }

    private final void setProgressColor(ProgressBar progressBar, Integer n, Integer n2) {
        Drawable drawable;
        if (n != null && n2 != null && n != -1 && n2 != -1 && (drawable = progressBar != null ? progressBar.getProgressDrawable() : null) instanceof LayerDrawable) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float)progressBar.getContext().getResources().getDimensionPixelSize(R.dimen.notification_custom_progress_view_corner_radius));
            if (CommonUtils.isLayoutRtl((Context)this.getCtx())) {
                gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
            } else {
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            }
            gradientDrawable.setColors(new int[]{n, n2});
            n = new ScaleDrawable((Drawable)gradientDrawable, 0x800003, 1.0f, -1.0f);
            n.setLevel(progressBar.getProgress() * 100);
            ((LayerDrawable)drawable).setDrawableByLayerId(16908301, (Drawable)n);
            progressBar.setProgressDrawable(drawable);
        }
    }

    @Override
    public void bind(Template object, StatusBarNotification statusBarNotification) {
        Object object2;
        Icon icon;
        Object var10_7;
        Object object3;
        Object var11_5;
        Object object4;
        block54: {
            block53: {
                block52: {
                    block51: {
                        o.g((Object)object, (String)"template");
                        o.g((Object)statusBarNotification, (String)"sbn");
                        super.bind((Template)object, statusBarNotification);
                        object4 = this.getView();
                        if (object4 != null) {
                            object4.setLayoutDirection(CommonUtils.isLayoutRtl((Context)this.getCtx()) ? 1 : 0);
                        }
                        var11_5 = null;
                        object3 = null;
                        var10_7 = null;
                        icon = null;
                        object4 = ((Template)object).getProgressInfo();
                        if (object4 == null) break block51;
                        object4 = ((ProgressInfo)object4).getColorProgress();
                        break block52;
                    }
                    object4 = null;
                }
                try {
                    object4 = Color.parseColor((String)object4);
                }
                catch (Exception exception) {
                    object4 = null;
                }
                object2 = ((Template)object).getProgressInfo();
                if (object2 == null) break block53;
                object2 = ((ProgressInfo)object2).getColorProgressEnd();
                break block54;
            }
            object2 = null;
        }
        try {
            object2 = Color.parseColor((String)object2);
        }
        catch (Exception exception) {
            object2 = null;
        }
        Object object5 = ((Template)object).getProgressInfo();
        object5 = object5 != null ? Integer.valueOf(((ProgressInfo)object5).getProgress()) : null;
        if (object5 != null) {
            Object object6 = this.container;
            if (object6 != null) {
                object6.setVisibility(0);
            }
            int n = this.hasProgressIcon((Template)object, statusBarNotification) ? R.id.focus_progress_info1 : R.id.focus_progress_info2;
            object6 = this.getView();
            object6 = object6 != null ? (ProgressBar)object6.findViewById(n) : null;
            this.progressBar = object6;
            if (object6 != null) {
                object6.setVisibility(0);
            }
            object6 = this.progressBar;
            if (object6 != null) {
                object6.setMax(100);
            }
            object6 = this.progressBar;
            if (object6 != null) {
                object6.setProgress(((Integer)object5).intValue(), false);
            }
            if (object2 == null) {
                ProgressBar progressBar = this.progressBar;
                if (progressBar != null) {
                    object6 = object4 != null ? ColorStateList.valueOf((int)((Number)object4).intValue()) : null;
                    progressBar.setProgressTintList((ColorStateList)object6);
                }
            } else {
                if (object4 != null) {
                    n = ((Number)object4).intValue();
                    statusBarNotification.getNotification().extras.putInt("colorProgress", n);
                }
                statusBarNotification.getNotification().extras.putInt("colorProgressEnd", ((Integer)object2).intValue());
            }
            if ((Integer)object5 < 50) {
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddleUnselected() : null;
                object6 = object3 = this.getIcon((String)object6, statusBarNotification);
                if (object3 == null) {
                    object6 = ((Template)object).getProgressInfo();
                    object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddle() : null;
                    object6 = this.getIcon((String)object6, statusBarNotification);
                }
                if (this.getIcon((String)(object3 = (object3 = ((Template)object).getProgressInfo()) != null ? ((ProgressInfo)object3).getPicEndUnselected() : null), statusBarNotification) == null) {
                    object3 = ((Template)object).getProgressInfo();
                    object = icon;
                    if (object3 != null) {
                        object = ((ProgressInfo)object3).getPicEnd();
                    }
                    this.getIcon((String)object, statusBarNotification);
                }
                if ((object = this.progressPoint1Un) != null) {
                    object.setVisibility(0);
                }
                object = this.progressPoint1Un;
                if (object != null) {
                    object.setImageIcon((Icon)object6);
                }
                if (object6 != null && (object = this.progressPointEnd) != null) {
                    object.setVisibility(0);
                }
                if (new d(1, 20).h(((Integer)object5).intValue()) && (object = this.progressBar) != null) {
                    object.setProgress((Integer)object5 + 10, false);
                }
            } else if ((Integer)object5 == 50) {
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicMiddle() : null;
                object6 = object3 = this.getIcon((String)object6, statusBarNotification);
                if (object3 == null) {
                    object6 = ((Template)object).getProgressInfo();
                    object = var11_5;
                    if (object6 != null) {
                        object = ((ProgressInfo)object6).getPicMiddleUnselected();
                    }
                    object6 = this.getIcon((String)object, statusBarNotification);
                }
                if ((object = this.progressPoint1Se) != null) {
                    object.setVisibility(0);
                }
                object = this.progressPoint1Se;
                if (object != null) {
                    object.setImageIcon((Icon)object6);
                }
                if (object6 != null) {
                    object = this.progressPointMiddle;
                    if (object != null) {
                        object.setVisibility(0);
                    }
                    object = this.progressPointEnd;
                    if (object != null) {
                        object.setVisibility(0);
                    }
                }
                if ((object = this.progressBar) != null) {
                    object.setProgress((Integer)object5 + 10, false);
                }
            } else if (new d(51, 99).h(((Integer)object5).intValue())) {
                object6 = ((Template)object).getProgressInfo();
                object6 = object6 != null ? ((ProgressInfo)object6).getPicEndUnselected() : null;
                icon = this.getIcon((String)object6, statusBarNotification);
                object6 = icon;
                if (icon == null) {
                    object = (object = ((Template)object).getProgressInfo()) != null ? ((ProgressInfo)object).getPicEnd() : null;
                    object6 = this.getIcon((String)object, statusBarNotification);
                }
                if (object6 != null && (object = this.progressPointMiddle) != null) {
                    object.setVisibility(0);
                }
                if ((object = this.progressPoint2Un) != null) {
                    object.setVisibility(0);
                }
                object = this.progressPoint2Un;
                if (object != null) {
                    object.setImageIcon((Icon)object6);
                }
                statusBarNotification = this.progressBar;
                object = object3;
                if (statusBarNotification != null) {
                    object = statusBarNotification.getLayoutParams();
                }
                o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                object = (FrameLayout.LayoutParams)object;
                object.setMarginEnd((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_template_deco_progress_area_a_margin));
                statusBarNotification = this.progressBar;
                if (statusBarNotification != null) {
                    statusBarNotification.setLayoutParams((ViewGroup.LayoutParams)object);
                }
                if (new d(51, 70).h(((Integer)object5).intValue()) && (object = this.progressBar) != null) {
                    object.setProgress((Integer)object5 + 10, false);
                }
            } else {
                object5 = ((Template)object).getProgressInfo();
                object5 = object5 != null ? ((ProgressInfo)object5).getPicEnd() : null;
                object5 = object6 = this.getIcon((String)object5, statusBarNotification);
                if (object6 == null) {
                    object = (object = ((Template)object).getProgressInfo()) != null ? ((ProgressInfo)object).getPicEndUnselected() : null;
                    object5 = this.getIcon((String)object, statusBarNotification);
                }
                if ((object = this.progressPoint2Se) != null) {
                    object.setVisibility(0);
                }
                object = this.progressPoint2Se;
                if (object != null) {
                    object.setImageIcon((Icon)object5);
                }
                statusBarNotification = this.progressBar;
                object = var10_7;
                if (statusBarNotification != null) {
                    object = statusBarNotification.getLayoutParams();
                }
                o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                statusBarNotification = (FrameLayout.LayoutParams)object;
                statusBarNotification.setMarginEnd((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_template_deco_area_a_margin));
                object = this.progressBar;
                if (object != null) {
                    object.setLayoutParams((ViewGroup.LayoutParams)statusBarNotification);
                }
            }
            this.setProgressColor(this.progressBar, (Integer)object4, (Integer)object2);
        }
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_port_progress, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.progressbar_container) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.progress_point_middle) : null;
        this.progressPointMiddle = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.progress_point_end) : null;
        this.progressPointEnd = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.progress_point1_se) : null;
        this.progressPoint1Se = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.progress_point2_se) : null;
        this.progressPoint2Se = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.progress_point1_un) : null;
        this.progressPoint1Un = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.progress_point2_un) : null;
        this.progressPoint2Un = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (ImageView)view.findViewById(R.id.progress_icon);
        }
        this.progressIcon = string;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
