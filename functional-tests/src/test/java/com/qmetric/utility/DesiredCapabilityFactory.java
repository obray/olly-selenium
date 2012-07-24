package com.qmetric.utility;

import com.qmetric.utility.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;

public final class DesiredCapabilityFactory
{
    public DesiredCapabilities create(final Browser browser)
    {
        if (browser == Browser.FIREFOX)
        {
            return DesiredCapabilities.firefox();
        }
        else if (browser == Browser.GOOGLE_CHROME)
        {
            return DesiredCapabilities.chrome();
        }
        else if (browser == Browser.INTERNET_EXPLORER)
        {
            return DesiredCapabilities.internetExplorer();
        }

        throw new IllegalArgumentException("Unknown browser: " + browser);
    }
}
