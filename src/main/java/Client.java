import org.sql2o.*;

import java.util.List;

public class Client {
    private int id;
    private String name, phone, gender, email;
    private int stylist_id;

    public Client(String name, String phone, String gender, String email, int stylist_id) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.stylist_id = stylist_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public int getStylist_id() {
        return stylist_id;
    }

    public static List<Client> all() {
        String sql = "SELECT * FROM clients";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Client.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open())  {
            String sql = "INSERT INTO clients (name, phone, gender, email, stylist_id) VALUES (:name, :phone, :gender, :email, :stylist_id)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("phone",this.phone)
                    .addParameter("gender", this.gender)
                    .addParameter("email", this.email)
                    .addParameter("stylist_id", this.stylist_id)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Client find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM clients where id=:id";
            Client client= con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Client.class);
            return client;
        }
    }

    @Override
    public boolean equals(Object otherClient){
        if (!(otherClient instanceof Client)) {
            return false;
        } else {
            Client newClient = (Client) otherClient;
            return this.email.equals(((Client) otherClient).email) &&
                    this.getId() == newClient.id;
        }
    }

//    public void delete() {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "DELETE FROM clients WHERE id = :id;";
//            con.createQuery(sql)
//                    .addParameter("id", id)
//                    .executeUpdate();
//        }
//    }
//
//    public void update(String name, String phone, String email, String gender, int stylist_id) {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "UPDATE clients SET name = :name, phone = :phone, email = :email, stylist_id = :stylist_id  WHERE id = :id";
//            con.createQuery(sql)
//                    .addParameter("id", id)
//                    .addParameter("name",name )
//                    .addParameter("phone",phone )
//                    .addParameter("gender",gender)
//                    .addParameter("email",email )
//                    .addParameter("stylist_id", stylist_id)
//                    .executeUpdate();
//        }
//    }
}