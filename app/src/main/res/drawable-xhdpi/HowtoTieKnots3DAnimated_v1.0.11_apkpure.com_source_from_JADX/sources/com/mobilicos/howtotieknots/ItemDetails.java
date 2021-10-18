package com.mobilicos.howtotieknots;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemDetails {
    private List<HashMap<String, String>> allImages;
    private boolean isLoaded;
    private boolean isLoading = false;
    private boolean isWrongLoading = false;
    private Item item;
    private int progressCurrentValue = 0;
    private int progressMaxValue = 0;
    private List<ItemStep> steps;
    private View view;

    public ItemDetails(Item item2) {
        this.item = item2;
        this.steps = new ArrayList();
        this.allImages = new ArrayList();
        addImage("i_" + item2.ident + "_icon.png", item2.icon);
        increaseProgressMaxValue();
        addImage("i_" + item2.ident + "_image.png", item2.image);
        increaseProgressMaxValue();
    }

    public void addStep(ItemStep step) {
        this.steps.add(step);
    }

    public void addImage(String localName, String imageUrl) {
        if (imageUrl.length() > 0 && localName.length() > 0) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(localName, imageUrl);
            this.allImages.add(hashMap);
        }
    }

    public Item getItem() {
        return this.item;
    }

    public View getView() {
        return this.view;
    }

    public void setView(View view2) {
        this.view = view2;
    }

    public boolean getIsWrongLoading() {
        return this.isWrongLoading;
    }

    public void setIsWrongLoading(boolean value) {
        this.isWrongLoading = value;
    }

    public void setIsLoading(boolean value) {
        this.isLoading = value;
    }

    public void setIsLoaded(boolean value) {
        this.isLoaded = value;
    }

    public void setProgressMaxValue(int value) {
        this.progressMaxValue = value;
    }

    public void setProgressCurrent(int value) {
        this.progressCurrentValue = value;
    }

    public List<ItemStep> getSteps() {
        return this.steps;
    }

    public List<HashMap<String, String>> getAllImages() {
        return this.allImages;
    }

    public void increaseProgressMaxValue() {
        this.progressMaxValue++;
    }

    public void increaseProgressCurrent() {
        this.progressCurrentValue++;
    }

    public boolean getIsLoading() {
        return this.isLoading;
    }

    public boolean getIsLoaded() {
        return this.isLoaded;
    }

    public int getProgressMaxValue() {
        return this.progressMaxValue;
    }

    public int getProgressCurrentValue() {
        return this.progressCurrentValue;
    }
}
