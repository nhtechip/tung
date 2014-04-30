
package com.nhtechip.andriod.myapp;

import android.accounts.AccountsException;
import android.app.Activity;

import com.nhtechip.andriod.myapp.authenticator.ApiKeyProvider;
import com.nhtechip.andriod.myapp.core.BootstrapService;
import com.nhtechip.andriod.myapp.core.UserAgentProvider;

import java.io.IOException;

import javax.inject.Inject;

/**
 * Provider for a {@link com.nhtechip.andriod.myapp.core.BootstrapService} instance
 */
public class BootstrapServiceProvider {

    @Inject ApiKeyProvider keyProvider;
    @Inject UserAgentProvider userAgentProvider;

    /**
     * Get service for configured key provider
     * <p/>
     * This method gets an auth key and so it blocks and shouldn't be called on the main thread.
     *
     * @return bootstrap service
     * @throws IOException
     * @throws AccountsException
     */
    public BootstrapService getService(final Activity activity)
            throws IOException, AccountsException {
        return new BootstrapService(keyProvider.getAuthKey(activity), userAgentProvider);
    }
}
