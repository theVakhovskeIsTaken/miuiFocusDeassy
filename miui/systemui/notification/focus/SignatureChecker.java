/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.d
 *  G0.e
 *  H0.i
 *  U0.a
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$PackageInfoFlags
 *  android.content.pm.Signature
 *  android.util.Log
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus;

import G0.d;
import G0.e;
import H0.i;
import U0.a;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.SignatureChecker;

public final class SignatureChecker {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final int FIXED_CACHE_SIZE = 50;
    private static final String PKG_SYSTEM_UI = "com.android.systemui";
    private static final String TAG = "SignatureUtils";
    private final d packageManager$delegate;
    private Map<String, Boolean> resultCacheMap;
    private final d sysUISignature$delegate;

    public SignatureChecker(Context context) {
        o.g((Object)context, (String)"sysUiContext");
        this.packageManager$delegate = e.b((a)new a(context){
            final Context $sysUiContext;
            {
                this.$sysUiContext = context;
                super(0);
            }

            public final PackageManager invoke() {
                return this.$sysUiContext.getPackageManager();
            }
        });
        this.sysUISignature$delegate = e.b((a)new a(this){
            final SignatureChecker this$0;
            {
                this.this$0 = signatureChecker;
                super(0);
            }

            public final Set<String> invoke() {
                SignatureChecker signatureChecker = this.this$0;
                return SignatureChecker.access$getSysUISignatures(signatureChecker, SignatureChecker.access$getPackageManager(signatureChecker));
            }
        });
        this.resultCacheMap = new LinkedHashMap<String, Boolean>(){

            public boolean removeEldestEntry(Map.Entry<String, Boolean> entry) {
                boolean bl = this.size() > 50;
                return bl;
            }
        };
    }

    public static final /* synthetic */ PackageManager access$getPackageManager(SignatureChecker signatureChecker) {
        return signatureChecker.getPackageManager();
    }

    public static final /* synthetic */ Set access$getSysUISignatures(SignatureChecker signatureChecker, PackageManager packageManager) {
        return signatureChecker.getSysUISignatures(packageManager);
    }

    private final boolean checkSignatures(PackageManager signatureArray, String object, Set<String> set) {
        boolean bl;
        signatureArray = this.getSignatures((PackageManager)signatureArray, (String)object);
        boolean bl2 = bl = false;
        if (signatureArray != null) {
            int n = signatureArray.length;
            int n2 = 0;
            while (true) {
                bl2 = bl;
                if (n2 >= n) break;
                object = signatureArray[n2];
                object = object.toByteArray();
                o.f((Object)object, (String)"toByteArray(...)");
                object = this.toSHA256((byte[])object);
                bl2 = object != null ? set.contains(object) : false;
                if (bl2) {
                    bl2 = true;
                    break;
                }
                ++n2;
            }
        }
        return bl2;
    }

    private final PackageInfo getPackageInfo(PackageManager packageManager2, String string, int n) {
        PackageInfo packageInfo;
        PackageInfo packageInfo2 = packageInfo = null;
        if (packageManager2 != null) {
            long l = n;
            try {
                packageInfo2 = packageManager2.getPackageInfo(string, PackageManager.PackageInfoFlags.of((long)l));
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"getPackageInfo exception", (Throwable)exception);
                packageInfo2 = packageInfo;
            }
        }
        return packageInfo2;
    }

    public static /* synthetic */ PackageInfo getPackageInfo$default(SignatureChecker signatureChecker, PackageManager packageManager, String string, int n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = 0;
        }
        return signatureChecker.getPackageInfo(packageManager, string, n);
    }

    private final PackageManager getPackageManager() {
        Object object = this.packageManager$delegate.getValue();
        o.f((Object)object, (String)"getValue(...)");
        return (PackageManager)object;
    }

    private final Signature[] getSignatures(PackageManager object, String string) {
        object = (object = this.getPackageInfo((PackageManager)object, string, 0x8000000)) != null && (object = object.signingInfo) != null ? object.getApkContentsSigners() : null;
        return object;
    }

    private final Set<String> getSysUISignature() {
        return (Set)this.sysUISignature$delegate.getValue();
    }

    private final Set<String> getSysUISignatures(PackageManager signatureArray) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        if ((signatureArray = this.getSignatures((PackageManager)signatureArray, PKG_SYSTEM_UI)) != null) {
            int n = signatureArray.length;
            for (int i = 0; i < n; ++i) {
                Object object = signatureArray[i].toByteArray();
                o.f((Object)object, (String)"toByteArray(...)");
                object = this.toSHA256((byte[])object);
                if (object == null) continue;
                linkedHashSet.add((String)object);
            }
        }
        return linkedHashSet;
    }

    private final String toSHA256(byte[] object) {
        try {
            object = MessageDigest.getInstance("SHA-256").digest((byte[])object);
            o.d((Object)object);
            object = i.G((byte[])object, (CharSequence)"", null, null, (int)0, null, (Function1)toSHA256.1.INSTANCE, (int)30, null);
            return object;
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"ByteArray.toSHA256 error.", (Throwable)exception);
            return null;
        }
    }

    public final boolean checkSignatures(String string) {
        o.g((Object)string, (String)"packageName");
        boolean bl = this.getSysUISignature().isEmpty();
        boolean bl2 = false;
        if (bl) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("checkSignatures: ");
            stringBuilder.append(string);
            stringBuilder.append(" , sysUISignature is invalid");
            Log.d((String)TAG, (String)stringBuilder.toString());
            return false;
        }
        if (this.resultCacheMap.containsKey(string)) {
            Comparable<Boolean> comparable = this.resultCacheMap.get(string);
            if (comparable != null) {
                bl2 = (Boolean)comparable;
            }
            comparable = new StringBuilder();
            ((StringBuilder)comparable).append("getCacheResult: ");
            ((StringBuilder)comparable).append(string);
            ((StringBuilder)comparable).append(", result: ");
            ((StringBuilder)comparable).append(bl2);
            Log.d((String)TAG, (String)((StringBuilder)comparable).toString());
            return bl2;
        }
        bl2 = this.checkSignatures(this.getPackageManager(), string, this.getSysUISignature());
        this.resultCacheMap.put(string, bl2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("checkSignatures: ");
        stringBuilder.append(string);
        stringBuilder.append(", result: ");
        stringBuilder.append(bl2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        return bl2;
    }
}
