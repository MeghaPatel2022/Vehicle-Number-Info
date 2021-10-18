package com.google.android.gms.vision;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import java.io.IOException;
import java.lang.Thread.State;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CameraSource {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Size zzaUA;
    /* access modifiers changed from: private */
    public float zzaUB;
    /* access modifiers changed from: private */
    public int zzaUC;
    /* access modifiers changed from: private */
    public int zzaUD;
    private SurfaceView zzaUE;
    private SurfaceTexture zzaUF;
    private boolean zzaUG;
    /* access modifiers changed from: private */
    public Thread zzaUH;
    /* access modifiers changed from: private */
    public zzb zzaUI;
    /* access modifiers changed from: private */
    public Map<byte[], ByteBuffer> zzaUJ;
    /* access modifiers changed from: private */
    public final Object zzaUx;
    /* access modifiers changed from: private */
    public Camera zzaUy;
    /* access modifiers changed from: private */
    public int zzaUz;
    /* access modifiers changed from: private */
    public int zzzS;

    public static class Builder {
        private final Detector<?> zzaUK;
        private CameraSource zzaUL = new CameraSource();

        public Builder(Context context, Detector<?> detector) {
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            } else {
                this.zzaUK = detector;
                this.zzaUL.mContext = context;
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzaUL;
            CameraSource cameraSource2 = this.zzaUL;
            cameraSource2.getClass();
            cameraSource.zzaUI = new zzb(this.zzaUK);
            return this.zzaUL;
        }

        public Builder setFacing(int facing) {
            if (facing == 0 || facing == 1) {
                this.zzaUL.zzaUz = facing;
                return this;
            }
            throw new IllegalArgumentException("Invalid camera: " + facing);
        }

        public Builder setRequestedFps(float fps) {
            if (fps <= 0.0f) {
                throw new IllegalArgumentException("Invalid fps: " + fps);
            }
            this.zzaUL.zzaUB = fps;
            return this;
        }

        public Builder setRequestedPreviewSize(int width, int height) {
            if (width <= 0 || width > 1000000 || height <= 0 || height > 1000000) {
                throw new IllegalArgumentException("Invalid preview size: " + width + "x" + height);
            }
            this.zzaUL.zzaUC = width;
            this.zzaUL.zzaUD = height;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    private class zza implements PreviewCallback {
        private zza() {
        }

        public void onPreviewFrame(byte[] data, Camera camera) {
            CameraSource.this.zzaUI.zza(data, camera);
        }
    }

    private class zzb implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = (!CameraSource.class.desiredAssertionStatus());
        private long zzMS = SystemClock.elapsedRealtime();
        private Detector<?> zzaUK;
        private boolean zzaUN = true;
        private long zzaUO;
        private int zzaUP = 0;
        private ByteBuffer zzaUQ;
        private final Object zzpc = new Object();

        zzb(Detector<?> detector) {
            this.zzaUK = detector;
        }

        /* access modifiers changed from: 0000 */
        public void release() {
            if ($assertionsDisabled || CameraSource.this.zzaUH.getState() == State.TERMINATED) {
                this.zzaUK.release();
                this.zzaUK = null;
                return;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r6.zzaUK.receiveFrame(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            android.util.Log.e("CameraSource", "Exception thrown from receiver.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
            com.google.android.gms.vision.CameraSource.zzb(r6.zzaUM).addCallbackBuffer(r2.array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
            throw r0;
         */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                java.lang.Object r1 = r6.zzpc
                monitor-enter(r1)
                boolean r0 = r6.zzaUN     // Catch:{ all -> 0x0020 }
                if (r0 == 0) goto L_0x0010
                java.nio.ByteBuffer r0 = r6.zzaUQ     // Catch:{ all -> 0x0020 }
                if (r0 != 0) goto L_0x0010
                java.lang.Object r0 = r6.zzpc     // Catch:{ InterruptedException -> 0x0016 }
                r0.wait()     // Catch:{ InterruptedException -> 0x0016 }
            L_0x0010:
                boolean r0 = r6.zzaUN     // Catch:{ all -> 0x0020 }
                if (r0 != 0) goto L_0x0023
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
            L_0x0015:
                return
            L_0x0016:
                r0 = move-exception
                java.lang.String r2 = "CameraSource"
                java.lang.String r3 = "Frame processing loop terminated."
                android.util.Log.d(r2, r3, r0)     // Catch:{ all -> 0x0020 }
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
                goto L_0x0015
            L_0x0020:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
                throw r0
            L_0x0023:
                com.google.android.gms.vision.Frame$Builder r0 = new com.google.android.gms.vision.Frame$Builder     // Catch:{ all -> 0x0020 }
                r0.<init>()     // Catch:{ all -> 0x0020 }
                java.nio.ByteBuffer r2 = r6.zzaUQ     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.CameraSource r3 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0020 }
                com.google.android.gms.common.images.Size r3 = r3.zzaUA     // Catch:{ all -> 0x0020 }
                int r3 = r3.getWidth()     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.CameraSource r4 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0020 }
                com.google.android.gms.common.images.Size r4 = r4.zzaUA     // Catch:{ all -> 0x0020 }
                int r4 = r4.getHeight()     // Catch:{ all -> 0x0020 }
                r5 = 17
                com.google.android.gms.vision.Frame$Builder r0 = r0.setImageData(r2, r3, r4, r5)     // Catch:{ all -> 0x0020 }
                int r2 = r6.zzaUP     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Frame$Builder r0 = r0.setId(r2)     // Catch:{ all -> 0x0020 }
                long r2 = r6.zzaUO     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Frame$Builder r0 = r0.setTimestampMillis(r2)     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.CameraSource r2 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0020 }
                int r2 = r2.zzzS     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Frame$Builder r0 = r0.setRotation(r2)     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Frame r0 = r0.build()     // Catch:{ all -> 0x0020 }
                java.nio.ByteBuffer r2 = r6.zzaUQ     // Catch:{ all -> 0x0020 }
                r3 = 0
                r6.zzaUQ = r3     // Catch:{ all -> 0x0020 }
                monitor-exit(r1)     // Catch:{ all -> 0x0020 }
                com.google.android.gms.vision.Detector<?> r1 = r6.zzaUK     // Catch:{ Throwable -> 0x0077 }
                r1.receiveFrame(r0)     // Catch:{ Throwable -> 0x0077 }
                com.google.android.gms.vision.CameraSource r0 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r0 = r0.zzaUy
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x0077:
                r0 = move-exception
                java.lang.String r1 = "CameraSource"
                java.lang.String r3 = "Exception thrown from receiver."
                android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x008e }
                com.google.android.gms.vision.CameraSource r0 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r0 = r0.zzaUy
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x008e:
                r0 = move-exception
                com.google.android.gms.vision.CameraSource r1 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r1 = r1.zzaUy
                byte[] r2 = r2.array()
                r1.addCallbackBuffer(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb.run():void");
        }

        /* access modifiers changed from: 0000 */
        public void setActive(boolean active) {
            synchronized (this.zzpc) {
                this.zzaUN = active;
                this.zzpc.notifyAll();
            }
        }

        /* access modifiers changed from: 0000 */
        public void zza(byte[] bArr, Camera camera) {
            synchronized (this.zzpc) {
                if (this.zzaUQ != null) {
                    camera.addCallbackBuffer(this.zzaUQ.array());
                    this.zzaUQ = null;
                }
                this.zzaUO = SystemClock.elapsedRealtime() - this.zzMS;
                this.zzaUP++;
                this.zzaUQ = (ByteBuffer) CameraSource.this.zzaUJ.get(bArr);
                this.zzpc.notifyAll();
            }
        }
    }

    private class zzc implements android.hardware.Camera.PictureCallback {
        /* access modifiers changed from: private */
        public PictureCallback zzaUR;

        private zzc() {
        }

        public void onPictureTaken(byte[] data, Camera camera) {
            if (this.zzaUR != null) {
                this.zzaUR.onPictureTaken(data);
            }
            synchronized (CameraSource.this.zzaUx) {
                if (CameraSource.this.zzaUy != null) {
                    CameraSource.this.zzaUy.startPreview();
                }
            }
        }
    }

    private class zzd implements android.hardware.Camera.ShutterCallback {
        /* access modifiers changed from: private */
        public ShutterCallback zzaUS;

        private zzd() {
        }

        public void onShutter() {
            if (this.zzaUS != null) {
                this.zzaUS.onShutter();
            }
        }
    }

    private static class zze {
        private Size zzaUT;
        private Size zzaUU;

        public zze(Camera.Size size, Camera.Size size2) {
            this.zzaUT = new Size(size.width, size.height);
            this.zzaUU = new Size(size2.width, size2.height);
        }

        public Size zzCa() {
            return this.zzaUT;
        }

        public Size zzCb() {
            return this.zzaUU;
        }
    }

    private CameraSource() {
        this.zzaUx = new Object();
        this.zzaUz = 0;
        this.zzaUB = 30.0f;
        this.zzaUC = 1024;
        this.zzaUD = 768;
        this.zzaUJ = new HashMap();
    }

    private Camera zzBZ() {
        int zzjn = zzjn(this.zzaUz);
        if (zzjn == -1) {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera open = Camera.open(zzjn);
        zze zza2 = zza(open, this.zzaUC, this.zzaUD);
        if (zza2 == null) {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size zzCb = zza2.zzCb();
        this.zzaUA = zza2.zzCa();
        int[] zza3 = zza(open, this.zzaUB);
        if (zza3 == null) {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        }
        Parameters parameters = open.getParameters();
        parameters.setPictureSize(zzCb.getWidth(), zzCb.getHeight());
        parameters.setPreviewSize(this.zzaUA.getWidth(), this.zzaUA.getHeight());
        parameters.setPreviewFpsRange(zza3[0], zza3[1]);
        parameters.setPreviewFormat(17);
        zza(open, parameters, zzjn);
        open.setParameters(parameters);
        open.setPreviewCallbackWithBuffer(new zza());
        open.addCallbackBuffer(zza(this.zzaUA));
        open.addCallbackBuffer(zza(this.zzaUA));
        open.addCallbackBuffer(zza(this.zzaUA));
        open.addCallbackBuffer(zza(this.zzaUA));
        return open;
    }

    private static zze zza(Camera camera, int i, int i2) {
        int i3;
        zze zze2;
        zze zze3 = null;
        int i4 = Integer.MAX_VALUE;
        for (zze zze4 : zza(camera)) {
            Size zzCa = zze4.zzCa();
            int abs = Math.abs(zzCa.getHeight() - i2) + Math.abs(zzCa.getWidth() - i);
            if (abs < i4) {
                int i5 = abs;
                zze2 = zze4;
                i3 = i5;
            } else {
                i3 = i4;
                zze2 = zze3;
            }
            i4 = i3;
            zze3 = zze2;
        }
        return zze3;
    }

    private static List<zze> zza(Camera camera) {
        Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = ((float) size.width) / ((float) size.height);
            int size2 = supportedPictureSizes.size() - 1;
            while (true) {
                if (size2 < 0) {
                    break;
                }
                Camera.Size size3 = (Camera.Size) supportedPictureSizes.get(size2);
                if (Math.abs(f - (((float) size3.width) / ((float) size3.height))) < 0.01f) {
                    arrayList.add(new zze(size, size3));
                    break;
                }
                size2--;
            }
        }
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            for (Camera.Size zze2 : supportedPreviewSizes) {
                arrayList.add(new zze(zze2, null));
            }
        }
        return arrayList;
    }

    private void zza(Camera camera, Parameters parameters, int i) {
        int i2;
        int i3;
        int i4;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        switch (rotation) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                Log.e("CameraSource", "Bad rotation value: " + rotation);
                i2 = 0;
                break;
        }
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i4 = (i2 + cameraInfo.orientation) % 360;
            i3 = (360 - i4) % 360;
        } else {
            i3 = ((cameraInfo.orientation - i2) + 360) % 360;
            i4 = i3;
        }
        this.zzzS = i4 / 90;
        camera.setDisplayOrientation(i3);
        parameters.setRotation(i4);
    }

    private byte[] zza(Size size) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((int) Math.ceil(((double) ((long) (ImageFormat.getBitsPerPixel(17) * (size.getHeight() * size.getWidth())))) / 8.0d)) + 1);
        this.zzaUJ.put(allocateDirect.array(), allocateDirect);
        return allocateDirect.array();
    }

    private int[] zza(Camera camera, float f) {
        int i;
        int[] iArr;
        int i2 = (int) (1000.0f * f);
        int[] iArr2 = null;
        int i3 = Integer.MAX_VALUE;
        for (int[] iArr3 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int abs = Math.abs(i2 - iArr3[0]) + Math.abs(i2 - iArr3[1]);
            if (abs < i3) {
                int i4 = abs;
                iArr = iArr3;
                i = i4;
            } else {
                i = i3;
                iArr = iArr2;
            }
            i3 = i;
            iArr2 = iArr;
        }
        return iArr2;
    }

    private static int zzjn(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getCameraFacing() {
        return this.zzaUz;
    }

    public Size getPreviewSize() {
        return this.zzaUA;
    }

    public void release() {
        synchronized (this.zzaUx) {
            stop();
            this.zzaUI.release();
        }
    }

    public CameraSource start() throws IOException {
        synchronized (this.zzaUx) {
            if (this.zzaUy == null) {
                this.zzaUy = zzBZ();
                if (VERSION.SDK_INT >= 11) {
                    this.zzaUF = new SurfaceTexture(100);
                    this.zzaUy.setPreviewTexture(this.zzaUF);
                    this.zzaUG = true;
                } else {
                    this.zzaUE = new SurfaceView(this.mContext);
                    this.zzaUy.setPreviewDisplay(this.zzaUE.getHolder());
                    this.zzaUG = false;
                }
                this.zzaUy.startPreview();
                this.zzaUH = new Thread(this.zzaUI);
                this.zzaUI.setActive(true);
                this.zzaUH.start();
            }
        }
        return this;
    }

    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzaUx) {
            if (this.zzaUy == null) {
                this.zzaUy = zzBZ();
                this.zzaUy.setPreviewDisplay(surfaceHolder);
                this.zzaUy.startPreview();
                this.zzaUH = new Thread(this.zzaUI);
                this.zzaUI.setActive(true);
                this.zzaUH.start();
                this.zzaUG = false;
            }
        }
        return this;
    }

    public void stop() {
        synchronized (this.zzaUx) {
            this.zzaUI.setActive(false);
            if (this.zzaUH != null) {
                try {
                    this.zzaUH.join();
                } catch (InterruptedException e) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzaUH = null;
            }
            if (this.zzaUy != null) {
                this.zzaUy.stopPreview();
                this.zzaUy.setPreviewCallbackWithBuffer(null);
                try {
                    if (this.zzaUG) {
                        this.zzaUy.setPreviewTexture(null);
                    } else {
                        this.zzaUy.setPreviewDisplay(null);
                    }
                } catch (Exception e2) {
                    Log.e("CameraSource", "Failed to clear camera preview: " + e2);
                }
                this.zzaUy.release();
                this.zzaUy = null;
            }
        }
        return;
    }

    public void takePicture(ShutterCallback shutter, PictureCallback jpeg) {
        synchronized (this.zzaUx) {
            if (this.zzaUy != null) {
                zzd zzd2 = new zzd();
                zzd2.zzaUS = shutter;
                zzc zzc2 = new zzc();
                zzc2.zzaUR = jpeg;
                this.zzaUy.takePicture(zzd2, null, null, zzc2);
            }
        }
    }
}
