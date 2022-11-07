/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxexample2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Topchilo;
 */
public class RepositoryImpl implements Repository{
      @Override
    public List<User> getUsers(){
        List<User> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM users")){
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                User user = new User(id, name, password);
                list.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
        @Override
    public List<Person> getPersons() {
        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person")){
            while(rs.next()){
                int id = rs.getInt(1);
                String jobtitle = rs.getString(2);
                String fullname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                Person person = new Person(id, jobtitle, fullname, phone, email);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Person getPersonById(int id) {
        List<Person> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM person WHERE id=" + id)){
            while(rs.next()){
                int personid = rs.getInt(1);
                String jobtitle = rs.getString(2);
                String fullname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                Person person = new Person(personid, jobtitle, fullname, phone, email);
                list.add(person);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Domain> getDomain() {
        List<Domain> list = new ArrayList<>();
        try(Connection connection = getConnection();
                Statement stm = connection.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM domains")){
            while(rs.next()){
                int id = rs.getInt(1);
                String webname = rs.getString(2);
                String domainName = rs.getString(3);
                String IP = rs.getString(4);
                Date dateReg = rs.getDate(5);
                String country = rs.getString(6);
                Person person = getPersonById(id);
                Domain domain = new Domain(id, webname, domainName, IP, dateReg, country, person);
                list.add(domain);
           
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Domain> getDomainByPerson(Person person) {
        List<Domain> list = new ArrayList<>();
        if(person!=null){
            try(Connection connection = getConnection();
                    Statement stm = connection.createStatement();
                    ResultSet rs = stm.executeQuery("SELECT * FROM domains WHERE personid=" + person.getId())){
                while(rs.next()){
                    int id = rs.getInt(1);
                    String webname = rs.getString(2);
                    String domainName = rs.getString(3);
                    String IP = rs.getString(4);
                    Date dateReg = rs.getDate(5);
                    String country = rs.getString(6);
                    Domain domain = new Domain(id, webname, domainName, IP, dateReg, country, person);
                    list.add(domain);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }
 
    //Метод создает соединение с БД
    private Connection getConnection() throws SQLException{
        String url = ApplicationProperties.get().getProperty("db.url");
        String dbUser = ApplicationProperties.get().getProperty("db.user");
        String dbPassword = ApplicationProperties.get().getProperty("db.password");
        return DriverManager.getConnection(url, dbUser, dbPassword);
    }
}
