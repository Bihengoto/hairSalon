import java.util.Arrays;
//import org.junit.*;
//import static org.junit.Assert.*;
//
//
//public class StylistTest {
//
//
//    @Test
//    public void newStylist_instantiatesCorrectly() {
//        Stylist newStyList = new Stylist("isaac", "M", "isaacben@gmail.com",  20);
//        assertTrue(newStyList instanceof Stylist);
//    }
//
//    @Test
//    public void newStylist_getName_isaac() {
//        Stylist newStyList = new Stylist("isaac", "M", "isaacben@gmail.com",  20);
//        assertEquals("isaac", newStyList.getName());
//    }
//
//    @Test
//    public void newStylist_getGender_M() {
//        Stylist newStyList = new Stylist("isaac", "M", "isaacben@gmail.com",  20);
//        assertEquals("M", newStyList.getGender());
//    }
//
//    @Test
//    public void newStylist_getEmail_mail() {
//        Stylist newStyList = new Stylist("isaac", "M", "isaacben@gmail.com",  20);
//        assertEquals("isaacben@gmail.com", newStyList.getEmail());
//    }
//
//    @Test
//    public void newStylist_getAge_20() {
//        Stylist newStyList = new Stylist("isaac", "M", "isaacben@gmail.com",  20);
//        assertEquals(20, newStyList.getAge());
//    }
//
//    @Test
//    public void delete_deletesStylist_true() {
//        Stylist firstStyList = new Stylist("isaac", "M", "isaacben@gmail.com",  20);
//        firstStyList.save();
//        int newStylistId = firstStyList.getId();
//        firstStyList.delete();
//        assertEquals(null, Client.find(newStylistId));
//    }
//
//    @Test
//    public void update_updatesStylist_true() {
//        Stylist firstStyList = new Stylist("isaac", "M", "isaacben@gmail.com",  20);
//        firstStyList.save();
//        firstStyList.update("isaac", "M", "isaacben@gmail.com",  20);
//        assertEquals("isaac", Stylist.find(firstStyList.getId()).getName());
//    }
//}
