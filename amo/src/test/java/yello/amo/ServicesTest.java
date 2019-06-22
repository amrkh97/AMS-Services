package yello.amo;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import yello.amo.Services;

public class ServicesTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Services.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        final String responseMsg = target().path("api").request().get(String.class);

        assertEquals("Server is Running ..!", responseMsg);
    }
}
