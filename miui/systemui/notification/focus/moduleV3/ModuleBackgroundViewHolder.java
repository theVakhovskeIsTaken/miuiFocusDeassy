/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Icon
 *  android.service.notification.StatusBarNotification
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  androidx.core.graphics.ColorUtils
 *  androidx.palette.graphics.Palette$Swatch
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.PaletteUtils
 */
package miui.systemui.notification.focus.moduleV3;

import U0.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.service.notification.StatusBarNotification;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.BgInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.b;
import miui.systemui.util.PaletteUtils;

public final class ModuleBackgroundViewHolder
extends ModuleViewHolder {
    private static final int COLOR_ALPHA = 255;
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private BgInfo bgInfo;

    public ModuleBackgroundViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    public static final /* synthetic */ void access$createPartBg(ModuleBackgroundViewHolder moduleBackgroundViewHolder, Icon icon, StatusBarNotification statusBarNotification) {
        moduleBackgroundViewHolder.createPartBg(icon, statusBarNotification);
    }

    public static final /* synthetic */ BgInfo access$getBgInfo$p(ModuleBackgroundViewHolder moduleBackgroundViewHolder) {
        return moduleBackgroundViewHolder.bgInfo;
    }

    private static final void bind$lambda$1(ImageView imageView, Icon icon) {
        ViewGroup.LayoutParams layoutParams;
        Integer n = imageView != null ? Integer.valueOf(imageView.getMeasuredHeight()) : null;
        if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null && n != null && n > 0) {
            layoutParams.height = n;
        }
        if (imageView != null) {
            imageView.setImageIcon(icon);
        }
    }

    public static /* synthetic */ void c(ImageView imageView, Icon icon) {
        ModuleBackgroundViewHolder.bind$lambda$1(imageView, icon);
    }

    private final void createPartBg(Icon object, StatusBarNotification statusBarNotification) {
        statusBarNotification.getNotification().extras.putBoolean("miui.focus.hasCustomBg", true);
        Object object2 = this.getView();
        object2 = object2 != null ? (ImageView)object2.findViewById(R.id.focus_notify_bg_image) : null;
        Object object3 = object != null ? object.loadDrawable(this.getCtx()) : null;
        object = object3 != null ? Bitmap.createBitmap((int)object3.getIntrinsicWidth(), (int)object3.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888) : null;
        Object object4 = object != null ? new Canvas((Bitmap)object) : null;
        if (object4 != null) {
            object3.setBounds(0, 0, object4.getWidth(), object4.getHeight());
        }
        if (object4 != null) {
            object3.draw(object4);
        }
        if ((object3 = object != null ? this.resizeAndCrop((Bitmap)object) : null) == null) {
            statusBarNotification.getNotification().extras.putBoolean("miui.focus.hasCustomBg", false);
            return;
        }
        Bitmap bitmap = Bitmap.createBitmap((int)object3.getWidth(), (int)object3.getHeight(), (Bitmap.Config)object3.getConfig());
        Palette.Swatch swatch = PaletteUtils.findBackgroundSwatch((Bitmap)object);
        int n = ModuleBackgroundViewHolder.darkenColor$default(this, ColorUtils.setAlphaComponent((int)swatch.getRgb(), (int)255), 0.3f, 0.0f, 4, null);
        if (object4 != null) {
            object4.drawColor(n);
        }
        if ((object4 = bitmap != null ? new Canvas(bitmap) : null) != null) {
            object4.drawBitmap((Bitmap)object3, 0.0f, 0.0f, null);
        }
        Paint paint = new Paint();
        paint.setShader((Shader)new LinearGradient(0.0f, 0.0f, (float)object3.getWidth(), 0.0f, n, this.darkenColor(ColorUtils.setAlphaComponent((int)swatch.getRgb(), (int)255), 0.3f, 0.5f), Shader.TileMode.CLAMP));
        float f2 = object3.getWidth();
        if (object4 != null) {
            object4.drawRect(0.0f, 0.0f, f2, (float)object3.getHeight(), paint);
        }
        o.d((Object)object2);
        o.d((Object)bitmap);
        this.setPartBg((ImageView)object2, bitmap, (Bitmap)object, statusBarNotification);
    }

    private final int darkenColor(int n, float f2, float f3) {
        int n2 = (int)((float)Color.alpha((int)n) * f3);
        int n3 = Color.red((int)n);
        int n4 = Color.green((int)n);
        n = Color.blue((int)n);
        return Color.argb((int)n2, (int)Math.max((int)((float)n3 * f2), 0), (int)Math.max((int)((float)n4 * f2), 0), (int)Math.max((int)((float)n * f2), 0));
    }

    public static /* synthetic */ int darkenColor$default(ModuleBackgroundViewHolder moduleBackgroundViewHolder, int n, float f2, float f3, int n2, Object object) {
        if ((n2 & 4) != 0) {
            f3 = 1.0f;
        }
        return moduleBackgroundViewHolder.darkenColor(n, f2, f3);
    }

    private final Bitmap resizeAndCrop(Bitmap bitmap) {
        int n = (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_part_bg_width);
        int n2 = (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_extend_height);
        if (bitmap.getWidth() < bitmap.getHeight()) {
            float f2 = (float)n / (float)bitmap.getWidth();
            bitmap = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n, (int)((int)((float)bitmap.getHeight() * f2)), (boolean)true);
            o.f((Object)bitmap, (String)"createScaledBitmap(...)");
            return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)((bitmap.getHeight() - n2) / 2), (int)n, (int)n2);
        }
        float f3 = (float)n2 / (float)bitmap.getHeight();
        bitmap = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)((int)((float)bitmap.getWidth() * f3)), (int)n2, (boolean)true);
        o.f((Object)bitmap, (String)"createScaledBitmap(...)");
        if (bitmap.getWidth() < n) {
            return null;
        }
        return Bitmap.createBitmap((Bitmap)bitmap, (int)((bitmap.getWidth() - n) / 2), (int)0, (int)n, (int)n2);
    }

    private final void setPartBg(ImageView imageView, Bitmap bitmap, Bitmap bitmap2, StatusBarNotification statusBarNotification) {
        if (imageView.getWidth() != 0 && imageView.getHeight() != 0) {
            if (bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
                statusBarNotification = Bitmap.createBitmap((int)(imageView.getWidth() - bitmap.getWidth()), (int)imageView.getHeight(), (Bitmap.Config)bitmap2.getConfig());
                Matrix matrix = new Matrix();
                matrix.setScale((float)(imageView.getWidth() - bitmap.getWidth()) / (float)bitmap2.getWidth(), (float)imageView.getHeight() / (float)bitmap2.getHeight());
                new Canvas((Bitmap)statusBarNotification).drawBitmap(bitmap2, matrix, null);
                bitmap2 = Bitmap.createBitmap((int)bitmap.getWidth(), (int)imageView.getHeight(), (Bitmap.Config)bitmap.getConfig());
                matrix = new Matrix();
                matrix.setScale(1.0f, (float)imageView.getHeight() / (float)bitmap.getHeight());
                new Canvas(bitmap2).drawBitmap(bitmap, matrix, null);
                matrix = Bitmap.createBitmap((int)imageView.getWidth(), (int)imageView.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas((Bitmap)matrix);
                canvas.drawBitmap((Bitmap)statusBarNotification, 0.0f, 0.0f, null);
                canvas.drawBitmap(bitmap2, (float)(imageView.getWidth() - bitmap.getWidth()), 0.0f, null);
                imageView.setImageBitmap((Bitmap)matrix);
                return;
            }
            imageView.setImageBitmap(null);
            statusBarNotification.getNotification().extras.putBoolean("miui.focus.hasCustomBg", false);
            return;
        }
        imageView.setImageBitmap(null);
        statusBarNotification.getNotification().extras.putBoolean("miui.focus.hasCustomBg", false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void bind(Template object, StatusBarNotification statusBarNotification) {
        Error error2;
        block13: {
            Exception exception3;
            block12: {
                Object object2;
                block11: {
                    o.g((Object)object, (String)"template");
                    o.g((Object)statusBarNotification, (String)"sbn");
                    super.bind((Template)object, statusBarNotification);
                    object2 = ((Template)object).getBgInfo();
                    this.bgInfo = object2;
                    object2 = object2 != null ? ((BgInfo)object2).getPicBg() : null;
                    Icon icon = this.getIcon((String)object2, statusBarNotification);
                    try {
                        object = ((Template)object).getBgInfo();
                        object = object != null ? ((BgInfo)object).getColorBg() : null;
                        object = Color.parseColor((String)object);
                    }
                    catch (Exception exception2) {
                        object = null;
                    }
                    Object object3 = this.getBitmapBundle();
                    if (object3 != null && object3.containsKey((String)(object2 = (object2 = this.bgInfo) != null ? ((BgInfo)object2).getPicBg() : null)) && icon == null) {
                        return;
                    }
                    object2 = this.getView();
                    object2 = object2 != null ? (ImageView)object2.findViewById(R.id.focus_notify_bg_image) : null;
                    object3 = this.bgInfo;
                    if (object3 != null && ((BgInfo)object3).getType() == 2) {
                        this.notifyDataChanged();
                        return;
                    }
                    if (icon != null) {
                        if (object2 != null) {
                            object2.setImageIcon(null);
                        }
                        statusBarNotification.getNotification().extras.putBoolean("miui.focus.hasCustomBg", true);
                        if (object2 != null) {
                            object2.post((Runnable)new b((ImageView)object2, icon));
                        }
                        statusBarNotification.getNotification().extras.putInt("miui.focus.bgImageId", R.id.focus_notify_bg_image);
                        return;
                    }
                    if (object == null) return;
                    try {
                        statusBarNotification.getNotification().extras.putBoolean("miui.focus.hasCustomBg", true);
                        if (object2 == null) break block11;
                        object2.setBackgroundColor(((Integer)object).intValue());
                    }
                    catch (Exception exception3) {
                        break block12;
                    }
                    catch (Error error2) {
                        break block13;
                    }
                }
                if (object2 != null) {
                    object2.setImageIcon(null);
                }
                statusBarNotification.getNotification().extras.putInt("miui.focus.bgImageId", R.id.focus_notify_bg_image);
                return;
            }
            statusBarNotification.getNotification().extras.putBoolean("miui.focus.hasCustomBg", false);
            exception3.printStackTrace();
            return;
        }
        statusBarNotification.getNotification().extras.putBoolean("miui.focus.hasCustomBg", false);
        error2.printStackTrace();
    }

    public final int getScreenWidth() {
        return this.getCtx().getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_background, this.getRootView()));
        this.registerCompressChanged(new a(this){
            final ModuleBackgroundViewHolder this$0;
            {
                this.this$0 = moduleBackgroundViewHolder;
                super(0);
            }

            public final void invoke() {
                Object object = ModuleBackgroundViewHolder.access$getBgInfo$p(this.this$0);
                if (object != null && ((BgInfo)object).getType() == 2) {
                    StatusBarNotification statusBarNotification = this.this$0.getSbn();
                    object = null;
                    StatusBarNotification statusBarNotification2 = null;
                    if (statusBarNotification != null) {
                        ModuleBackgroundViewHolder moduleBackgroundViewHolder = this.this$0;
                        BgInfo bgInfo = ModuleBackgroundViewHolder.access$getBgInfo$p(moduleBackgroundViewHolder);
                        object = statusBarNotification2;
                        if (bgInfo != null) {
                            object = bgInfo.getPicBg();
                        }
                        object = moduleBackgroundViewHolder.getIcon((String)object, statusBarNotification);
                    }
                    if ((statusBarNotification2 = this.this$0.getSbn()) != null) {
                        ModuleBackgroundViewHolder.access$createPartBg(this.this$0, (Icon)object, statusBarNotification2);
                    }
                }
            }
        });
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
