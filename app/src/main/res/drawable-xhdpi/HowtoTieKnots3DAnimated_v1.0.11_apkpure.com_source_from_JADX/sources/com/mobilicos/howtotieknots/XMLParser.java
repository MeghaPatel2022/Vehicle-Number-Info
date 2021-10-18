package com.mobilicos.howtotieknots;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
    static final String DESCRIPTION = "description";
    static final String ITEM = "item";
    static final String LINK = "link";
    static final String PUB_DATE = "pubDate";
    static final String TITLE = "title";
    final URL feedUrl;

    protected XMLParser(String feedUrl2) {
        try {
            this.feedUrl = new URL(feedUrl2);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public InputStream getInputStream() {
        try {
            return this.feedUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItemDetails> parse(int items_limit) {
        int limit;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<ItemDetails> itemDetailsList = new ArrayList<>();
        try {
            NodeList items = factory.newDocumentBuilder().parse(getInputStream()).getDocumentElement().getElementsByTagName(ITEM);
            Log.e("ITEMS COUNT", "" + items.getLength());
            if (items_limit > 0) {
                limit = items_limit;
            } else {
                limit = items.getLength();
            }
            for (int i = 0; i < limit; i++) {
                Node item = items.item(i);
                if (item.hasChildNodes()) {
                    Log.e("ITEM HAS CHILD NODES", "YES!");
                    Item lessonItem = new Item();
                    NodeList properties = item.getChildNodes();
                    for (int j = 0; j < properties.getLength(); j++) {
                        Node property = properties.item(j);
                        if (property.hasChildNodes()) {
                            Log.e("XML NODE INFO", "" + property.getNodeName() + " = " + property.getFirstChild().getNodeValue());
                            if (property.getNodeName().equalsIgnoreCase("name")) {
                                lessonItem.name = property.getFirstChild().getNodeValue();
                            } else if (property.getNodeName().equalsIgnoreCase("description")) {
                                lessonItem.description = property.getFirstChild().getNodeValue();
                            } else if (property.getNodeName().equalsIgnoreCase("slug")) {
                                lessonItem.slug = property.getFirstChild().getNodeValue();
                            } else if (property.getNodeName().equalsIgnoreCase("id")) {
                                lessonItem.f64id = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("ident")) {
                                lessonItem.ident = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("category_ident")) {
                                lessonItem.category_ident = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("sort_order")) {
                                lessonItem.sort_order = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("steps_count")) {
                                lessonItem.steps_count = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("level")) {
                                lessonItem.level = property.getFirstChild().getNodeValue();
                            } else if (property.getNodeName().equalsIgnoreCase("icon")) {
                                lessonItem.icon = property.getFirstChild().getNodeValue();
                            } else if (property.getNodeName().equalsIgnoreCase("image")) {
                                lessonItem.image = property.getFirstChild().getNodeValue();
                            } else if (property.getNodeName().equalsIgnoreCase("is_active")) {
                                lessonItem.is_active = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("is_base")) {
                                lessonItem.is_base = Integer.parseInt(property.getFirstChild().getNodeValue());
                            } else if (property.getNodeName().equalsIgnoreCase("is_paid")) {
                                lessonItem.is_paid = Integer.parseInt(property.getFirstChild().getNodeValue());
                            }
                        }
                    }
                    itemDetailsList.add(new ItemDetails(lessonItem));
                }
            }
            return itemDetailsList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
