package com.nhtechip.andriod.myapp;

import android.accounts.AccountManager;
import android.content.Context;

import com.nhtechip.andriod.myapp.authenticator.BootstrapAuthenticatorActivity;
import com.nhtechip.andriod.myapp.authenticator.LogoutService;
import com.nhtechip.andriod.myapp.core.TimerService;
import com.nhtechip.andriod.myapp.ui.BootstrapTimerActivity;
import com.nhtechip.andriod.myapp.ui.MainActivity;
import com.nhtechip.andriod.myapp.ui.CheckInsListFragment;
import com.nhtechip.andriod.myapp.ui.NavigationDrawerFragment;
import com.nhtechip.andriod.myapp.ui.NewsActivity;
import com.nhtechip.andriod.myapp.ui.NewsListFragment;
import com.nhtechip.andriod.myapp.ui.UserActivity;
import com.nhtechip.andriod.myapp.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                MainActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NavigationDrawerFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }
)
public class BootstrapModule {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
