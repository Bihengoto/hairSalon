import org.junit.Rule;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

    @After
    public void tearDown() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM clients *;";
            con.createQuery(sql).executeUpdate();
        }
    }

    @Test
    public void newClient_instantiatesCorrectly() {
        Client newClient = new Client("dorcas", "0708437712", "F","dorcas@gmail.com", 3 );
        assertTrue(newClient instanceof Client);
    }

//    @Test
//    public void newClient_getName_dorcas() {
//        Client newClient = new Client("dorcas", "0708437712", "F","dorcas@gmail.com", 3 );
//        assertEquals("dorcas", newClient.getName());
//    }
//
//    @Test
//    public void newClient_getPhone_0708437712() {
//        Client newClient = new Client("dorcas", "0708437712", "F","dorcas@gmail.com", 3 );
//        assertEquals("0708437712", newClient.getPhone());
//    }
//
//    @Test
//    public void newClient_getEmail_dorcasgmailcom() {
//        Client newClient = new Client("dorcas", "0708437712", "F","dorcas@gmail.com", 3 );
//        assertEquals("dorcas@gmail.com", newClient.getEmail());
//    }
//
//    @Test
//    public void newClient_getGender_F() {
//        Client newClient = new Client("dorcas", "0708437712", "F","dorcas@gmail.com", 3 );
//        assertEquals("F", newClient.getGender());
//    }
//
//    @Test
//    public void newClient_getStylist_id_3() {
//        Client newClient = new Client("dorcas", "0708437712", "F","dorcas@gmail.com", 3 );
//        assertEquals(3, newClient.getStylist_id());
//    }

    @Test
    public void all_returnsAllInstancesOfClients_true() {
        Client newClient = new Client("dorcas", "0708437712", "F", "dorcas@gmail.com", 3 );
        newClient.save();
        Client newClient2 = new Client("dorcas", "0708447347", "F","dorcasy@gmail.com", 2 );
        newClient2.save();

        assertEquals(true, Client.all().get(0).equals(newClient));
        assertEquals(true, Client.all().get(1).equals(newClient2));
    }

    @Test
    public void save_assignsIdToObject() {
        Client newClient = new Client("dorcas", "0708437712", "F", "dorcas@gmail.com", 3 );
        newClient.save();
        Client savedClient = Client.all().get(0);
        assertEquals(newClient.getId(), savedClient.getId());
    }

    @Test
    public void getId_clientInstantiateWithAnID() {
        Client newClient = new Client("dorcas", "0708437712", "F", "dorcas@gmail.com", 3 );
        newClient.save();
        assertTrue(newClient.getId() > 0);
    }

    @Test
    public void find_returnsClientWithSameId_newClient2() {
        Client newClient = new Client("dorcas", "0708437712", "F", "dorcas@gmail.com", 3 );
        newClient.save();
        Client newClient2 = new Client("dorcas", "0708447347", "F","dorcasy@gmail.com", 2 );
        newClient2.save();

        assertEquals(Client.find(newClient2.getId()), newClient2);
    }

}
