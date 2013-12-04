/**
 * Copyright (c) 2005-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Eclipse Public License (EPL).
 * Please see the license.txt included with this distribution for details.
 * Any modifications to this file must keep this entire header intact.
 */
/*
 * Author: atotic
 * Created: Jul 29, 2003
 */
package pl.poznan.put.cs.gui4pddl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import pl.poznan.put.cs.gui4pddl.log.Log;


/**
 * Caches images, releases all on dispose
 * From PyDev
 */
public class ImageCache {


    private final Map<Object, Image> imageHash = new HashMap<Object, Image>(10);
    private final Map<Object, ImageDescriptor> descriptorHash = new HashMap<Object, ImageDescriptor>(10);

    private final URL baseURL;
    private Image missing = null;
    private final Object lock = new Object();
    private final Object descriptorLock = new Object();

    public ImageCache(URL baseURL) {
        this.baseURL = baseURL;
    }

    public void dispose() {
        synchronized (lock) {
            Iterator<Image> e = imageHash.values().iterator();
            while (e.hasNext())
                ((Image) e.next()).dispose();
            if (missing != null) {
                missing.dispose();
            }
        }
    }

    /**
     * @param key - relative path to the plugin directory
     * @return the image
     */
    public Image get(String key) {
        synchronized (lock) {
            Image image = (Image) imageHash.get(key);
            if (image == null) {
                ImageDescriptor desc;
                try {
                    desc = getDescriptor(key);
                    image = desc.createImage();
                    imageHash.put(key, image);
                } catch (NoClassDefFoundError e) {
                    //we're in tests...
                    return null;
                } catch (UnsatisfiedLinkError e) {
                    //we're in tests...
                    return null;
                } catch (Exception e) {
                    // If image is missing, create a default missing one
                    Log.log("ERROR: Missing image: " + key);
                    if (missing == null) {
                        desc = ImageDescriptor.getMissingImageDescriptor();
                        missing = desc.createImage();
                    }
                    image = missing;
                }
            }
            return image;
        }
    }


    /**
     * like get, but returns ImageDescription instead of image
     */
    public ImageDescriptor getDescriptor(String key) {
        synchronized (descriptorLock) {
            if (!descriptorHash.containsKey(key)) {
                URL url;
                ImageDescriptor desc;
                try {
                    url = new URL(baseURL, key);
                    desc = ImageDescriptor.createFromURL(url);
                } catch (MalformedURLException e) {
                    Log.log("ERROR: Missing image: " + key);
                    desc = ImageDescriptor.getMissingImageDescriptor();
                }
                descriptorHash.put(key, desc);
                return desc;
            }
            return descriptorHash.get(key);
        }
    }
}
