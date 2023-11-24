package com.caretdev.presto.plugin.iris;

import com.facebook.presto.spi.Plugin;
import com.facebook.presto.spi.connector.ConnectorFactory;
import com.facebook.presto.testing.TestingConnectorContext;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.Test;

import static com.google.common.collect.Iterables.getOnlyElement;

public class TestIRISSqlPlugin {

    @Test
    public void testCreateConnector()
    {
        Plugin plugin = new IRISSqlPlugin();
        ConnectorFactory factory = getOnlyElement(plugin.getConnectorFactories());
        factory.create("test", ImmutableMap.of("connection-url", "jdbc:IRIS://test"), new TestingConnectorContext());
    }
}
