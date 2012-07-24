package com.qmetric.utility;

import org.apache.commons.lang.StringUtils;

public enum Browser
{
    FIREFOX("firefox"),

    GOOGLE_CHROME("chrome"),

    INTERNET_EXPLORER("internet explorer");

    private final String id;

    Browser(final String id)
    {
        this.id = id;
    }

    public static Browser lookupBrowserBy(final String id)
    {
        for (final Browser browser : Browser.values())
        {
            if (StringUtils.equals(id, browser.getId()))
            {
                return browser;
            }
        }

        throw new IllegalArgumentException("Unknown browser with id: " + id);
    }

    public String getId()
    {
        return id;
    }
}
