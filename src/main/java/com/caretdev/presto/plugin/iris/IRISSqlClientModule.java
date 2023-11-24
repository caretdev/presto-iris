package com.caretdev.presto.plugin.iris;

import com.facebook.presto.plugin.jdbc.BaseJdbcConfig;
import com.facebook.presto.plugin.jdbc.JdbcClient;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

import static com.facebook.airlift.configuration.ConfigBinder.configBinder;
public class IRISSqlClientModule implements Module {

    @Override
    public void configure(Binder binder)
    {
        binder.bind(JdbcClient.class).to(IRISSqlClient.class).in(Scopes.SINGLETON);
        configBinder(binder).bindConfig(BaseJdbcConfig.class);
    }
}
