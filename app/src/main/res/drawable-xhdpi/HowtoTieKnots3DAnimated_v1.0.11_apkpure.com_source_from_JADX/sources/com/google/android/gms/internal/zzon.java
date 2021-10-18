package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzon extends zzod<zzon> {
    private ProductAction zzKC;
    private final Map<String, List<Product>> zzKD = new HashMap();
    private final List<Promotion> zzKE = new ArrayList();
    private final List<Product> zzKF = new ArrayList();

    public String toString() {
        HashMap hashMap = new HashMap();
        if (!this.zzKF.isEmpty()) {
            hashMap.put("products", this.zzKF);
        }
        if (!this.zzKE.isEmpty()) {
            hashMap.put("promotions", this.zzKE);
        }
        if (!this.zzKD.isEmpty()) {
            hashMap.put("impressions", this.zzKD);
        }
        hashMap.put("productAction", this.zzKC);
        return zzA(hashMap);
    }

    public void zza(Product product, String str) {
        if (product != null) {
            if (str == null) {
                str = "";
            }
            if (!this.zzKD.containsKey(str)) {
                this.zzKD.put(str, new ArrayList());
            }
            ((List) this.zzKD.get(str)).add(product);
        }
    }

    public void zza(zzon zzon) {
        zzon.zzKF.addAll(this.zzKF);
        zzon.zzKE.addAll(this.zzKE);
        for (Entry entry : this.zzKD.entrySet()) {
            String str = (String) entry.getKey();
            for (Product zza : (List) entry.getValue()) {
                zzon.zza(zza, str);
            }
        }
        if (this.zzKC != null) {
            zzon.zzKC = this.zzKC;
        }
    }

    public ProductAction zzxM() {
        return this.zzKC;
    }

    public List<Product> zzxN() {
        return Collections.unmodifiableList(this.zzKF);
    }

    public Map<String, List<Product>> zzxO() {
        return this.zzKD;
    }

    public List<Promotion> zzxP() {
        return Collections.unmodifiableList(this.zzKE);
    }
}
