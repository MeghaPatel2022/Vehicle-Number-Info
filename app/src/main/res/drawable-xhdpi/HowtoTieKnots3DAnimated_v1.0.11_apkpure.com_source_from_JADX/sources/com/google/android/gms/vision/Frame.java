package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.nio.ByteBuffer;

public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    /* access modifiers changed from: private */
    public Bitmap mBitmap;
    private Metadata zzaVd;
    /* access modifiers changed from: private */
    public ByteBuffer zzaVe;

    public static class Builder {
        private Frame zzaVf = new Frame();

        public Frame build() {
            if (this.zzaVf.zzaVe != null || this.zzaVf.mBitmap != null) {
                return this.zzaVf;
            }
            throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
        }

        public Builder setBitmap(Bitmap image) {
            int width = image.getWidth();
            int height = image.getHeight();
            this.zzaVf.mBitmap = image;
            Metadata metadata = this.zzaVf.getMetadata();
            metadata.zznP = width;
            metadata.zznQ = height;
            return this;
        }

        public Builder setId(int id) {
            this.zzaVf.getMetadata().mId = id;
            return this;
        }

        public Builder setImageData(ByteBuffer data, int width, int height, int format) {
            if (data == null) {
                throw new IllegalArgumentException("Null image data supplied.");
            } else if (!data.isDirect()) {
                throw new IllegalArgumentException("Image byte buffer must be allocated as 'direct'. See ByteBuffer.allocateDirect().");
            } else if (data.array() == null || data.array().length < width * height) {
                throw new IllegalArgumentException("Invalid image data size.");
            } else {
                switch (format) {
                    case 16:
                    case 17:
                    case 842094169:
                        this.zzaVf.zzaVe = data;
                        Metadata metadata = this.zzaVf.getMetadata();
                        metadata.zznP = width;
                        metadata.zznQ = height;
                        return this;
                    default:
                        throw new IllegalArgumentException("Unsupported image format: " + format);
                }
            }
        }

        public Builder setRotation(int rotation) {
            this.zzaVf.getMetadata().zzzS = rotation;
            return this;
        }

        public Builder setTimestampMillis(long timestampMillis) {
            this.zzaVf.getMetadata().zzaxC = timestampMillis;
            return this;
        }
    }

    public static class Metadata {
        /* access modifiers changed from: private */
        public int mId;
        /* access modifiers changed from: private */
        public long zzaxC;
        /* access modifiers changed from: private */
        public int zznP;
        /* access modifiers changed from: private */
        public int zznQ;
        /* access modifiers changed from: private */
        public int zzzS;

        public Metadata() {
        }

        public Metadata(Metadata metadata) {
            this.zznP = metadata.getWidth();
            this.zznQ = metadata.getHeight();
            this.mId = metadata.getId();
            this.zzaxC = metadata.getTimestampMillis();
            this.zzzS = metadata.getRotation();
        }

        public int getHeight() {
            return this.zznQ;
        }

        public int getId() {
            return this.mId;
        }

        public int getRotation() {
            return this.zzzS;
        }

        public long getTimestampMillis() {
            return this.zzaxC;
        }

        public int getWidth() {
            return this.zznP;
        }

        public void zzCd() {
            if (this.zzzS % 2 != 0) {
                int i = this.zznP;
                this.zznP = this.zznQ;
                this.zznQ = i;
            }
            this.zzzS = 0;
        }
    }

    private Frame() {
        this.zzaVd = new Metadata();
        this.zzaVe = null;
        this.mBitmap = null;
    }

    private ByteBuffer zzCc() {
        int width = this.mBitmap.getWidth();
        int height = this.mBitmap.getHeight();
        int[] iArr = new int[(width * height)];
        this.mBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[(width * height)];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) ((int) ((((float) Color.red(iArr[i])) * 0.299f) + (((float) Color.green(iArr[i])) * 0.587f) + (((float) Color.blue(iArr[i])) * 0.114f)));
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        System.arraycopy(bArr, 0, allocateDirect.array(), 0, bArr.length);
        return allocateDirect;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ByteBuffer getGrayscaleImageData() {
        return this.mBitmap != null ? zzCc() : this.zzaVe;
    }

    public Metadata getMetadata() {
        return this.zzaVd;
    }
}
