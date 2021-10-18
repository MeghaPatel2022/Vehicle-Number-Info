package com.mobilicos.howtotieknotspro;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLItemParser {
    static final String DESCRIPTION = "description";
    static final String FRAME = "frame";
    static final String LINK = "link";
    static final String PUB_DATE = "pubDate";
    static final String STEP = "step";
    static final String TITLE = "title";
    final URL feedUrl;
    private ItemDetails itemDetails;

    protected XMLItemParser(String feedUrl2, ItemDetails item) {
        try {
            this.itemDetails = new ItemDetails(item.getItem());
            this.feedUrl = new URL(feedUrl2);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public InputStream getInputStream() {
        try {
            HttpURLConnection urlConn = (HttpURLConnection) this.feedUrl.openConnection();
            urlConn.setConnectTimeout(15000);
            urlConn.connect();
            return urlConn.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ItemDetails parse() {
        try {
            NodeList steps = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getInputStream()).getDocumentElement().getElementsByTagName(STEP);
            Log.d("XMLITEMDETAILS", "ITEM DETAILS LOADED");
            for (int i = 0; i < steps.getLength(); i++) {
                Node item = steps.item(i);
                if (item.hasChildNodes()) {
                    Log.e("ITEM HAS CHILD NODES", "YES!");
                    ItemStep itemStep = new ItemStep();
                    NodeList properties = item.getChildNodes();
                    for (int j = 0; j < properties.getLength(); j++) {
                        Node property = properties.item(j);
                        if (property.hasChildNodes()) {
                            Log.e("XML NODE INFO", "" + property.getNodeName() + " = " + property.getFirstChild().getNodeValue());
                            if (property.getNodeName().equalsIgnoreCase("description")) {
                                itemStep.description = property.getFirstChild().getNodeValue();
                            } else if (property.getNodeName().equalsIgnoreCase("id")) {
                                itemStep.f72id = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("step_number")) {
                                itemStep.step_number = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("sort_order")) {
                                itemStep.sort_order = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("frames_count")) {
                                itemStep.frames_count = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("frames")) {
                                NodeList frames = ((Element) item).getElementsByTagName(FRAME);
                                for (int k = 0; k < frames.getLength(); k++) {
                                    Node frame = frames.item(k);
                                    if (frame.hasChildNodes()) {
                                        StepFrame stepFrame = new StepFrame();
                                        NodeList frameProperties = frame.getChildNodes();
                                        for (int n = 0; n < frameProperties.getLength(); n++) {
                                            Node frameProperty = frameProperties.item(n);
                                            if (frameProperty.hasChildNodes()) {
                                                if (frameProperty.getNodeName().equalsIgnoreCase("id")) {
                                                    stepFrame.f75id = Integer.parseInt(frameProperty.getFirstChild().getNodeValue());
                                                } else if (frameProperty.getNodeName().equalsIgnoreCase("sort_order")) {
                                                    stepFrame.sort_order = Integer.parseInt(frameProperty.getFirstChild().getNodeValue());
                                                } else if (frameProperty.getNodeName().equalsIgnoreCase("is_active")) {
                                                    stepFrame.is_active = Integer.parseInt(frameProperty.getFirstChild().getNodeValue());
                                                } else if (frameProperty.getNodeName().equalsIgnoreCase("image")) {
                                                    stepFrame.image = frameProperty.getFirstChild().getNodeValue();
                                                    this.itemDetails.addImage("i_" + this.itemDetails.getItem().ident + "_" + itemStep.sort_order + "_" + stepFrame.sort_order + ".png", frameProperty.getFirstChild().getNodeValue());
                                                    this.itemDetails.increaseProgressMaxValue();
                                                }
                                            }
                                        }
                                        itemStep.addFrame(stepFrame);
                                    }
                                }
                            }
                        }
                    }
                    this.itemDetails.addStep(itemStep);
                }
            }
            return this.itemDetails;
        } catch (Exception e) {
            RuntimeException runtimeException = new RuntimeException(e);
            throw runtimeException;
        }
    }
}
