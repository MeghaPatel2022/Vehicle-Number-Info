package com.mobilicos.howtotieknots;

import java.util.ArrayList;
import java.util.List;

public class ItemStep {
    public String description;
    public List<StepFrame> frames = new ArrayList();
    public int frames_count;

    /* renamed from: id */
    public int f65id;
    public int is_active = 1;
    public int sort_order;
    public int step_number;

    public void addFrame(StepFrame frame) {
        this.frames.add(frame);
    }

    public List<StepFrame> getFrames() {
        return this.frames;
    }
}
