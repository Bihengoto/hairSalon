import org.sql2o.Connection;
import java.util.List;

public class Stylist {
    private int id;
    private String name;
    private String gender;
    private String email;
    private int age;

    public Stylist(String name, String gender, String email, int age) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public String getEmail(){
        return email;
    }
    public int getAge(){
        return age;
    }

    public static List<Stylist> all() {
        String sql = "SELECT id, name, gender, email FROM stylists ORDER BY name";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Stylist.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open())  {
            String sql = "INSERT INTO stylists (name, gender, email, age) VALUES (:name, :gender, :email, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("gender", this.gender)
                    .addParameter("email",this.email)
                    .addParameter("age",this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM stylists WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public static Stylist find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM stylists where id=:id";
            Stylist stylist= con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Stylist.class);
            return stylist;
        }
    }


    public void update(String name,String gender, String email,int age) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE stylists SET name = :name, gender = :gender, email = :email, age = :age WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name",name )
                    .addParameter("gender",gender )
                    .addParameter("email",email )
                    .addParameter("age",age )
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


}
