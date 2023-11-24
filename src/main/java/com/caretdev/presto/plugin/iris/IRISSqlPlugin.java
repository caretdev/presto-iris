package com.caretdev.presto.plugin.iris;

import com.facebook.presto.plugin.jdbc.JdbcPlugin;

public class IRISSqlPlugin extends JdbcPlugin {
    public IRISSqlPlugin() {
        super("iris", new IRISSqlClientModule());
    }
}
