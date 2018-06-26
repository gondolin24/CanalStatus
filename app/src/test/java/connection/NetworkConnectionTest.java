package connection;

import junit.framework.Assert;

import org.junit.Test;

public class NetworkConnectionTest {

    @Test
    public void testInternetConnection() {
        NetworkConnection connection = new NetworkConnection();
        boolean validConnection = connection.testConnection();
        Assert.assertTrue(validConnection);
    }


}