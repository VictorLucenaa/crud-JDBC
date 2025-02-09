package Service;

import Database.DatabaseConnect;
import Domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    public static void createPerson(Person person) throws Exception{
        String SQL = "INSERT INTO pessoas (name, age) VALUES (?, ?)";

        try{
           Connection conn = DatabaseConnect.getConnection();

            PreparedStatement statement = conn.prepareStatement(SQL);
                statement.setString(1, person.getName());
                statement.setInt(2, person.getAge());
                statement.executeUpdate();
                System.out.println("Pessoa criada com sucesso!");
            statement.close();
            conn.close();

        } catch (SQLException e){
            System.out.println("Erro no cadastro de nova pessoa: " + e.getMessage());
        }
    }

    public static List<Person> readPersons() throws Exception {
        String SQL = "SELECT * FROM pessoas";
        List<Person> people = new ArrayList<>();

        try{
            Connection conn = DatabaseConnect.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Person person = new Person(id, name, age);
                people.add(person);
            }
            statement.close();
            rs.close();
            conn.close();

        }catch (SQLException e){
            System.out.println("Pessoas não encontradas no banco de dados: " + e.getMessage());
        }
        return people;
    }


    public static void updatePerson(int id, String name, int age) throws Exception{
    String SQL = "UPDATE pessoas SET name = ?, age = ? where id = ?";

    try{
        Connection conn = DatabaseConnect.getConnection();
        PreparedStatement statement = conn.prepareStatement(SQL);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setInt(3, id);
        statement.executeUpdate();
        statement.close();
        conn.close();
        System.out.println("Pessoa alterada com sucesso");
    } catch (SQLException e) {
        System.out.println("Erro ao alterar a pessoa: " + e.getMessage());
    }
    }

    public static void deletePerson(int id) throws Exception{
        String SQL = "DELETE FROM pessoas where id = ?";

        try{
            Connection conn = DatabaseConnect.getConnection();
            PreparedStatement statement = conn.prepareStatement(SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.printf("Usuário com id: %d removido com sucesso!", id);
            statement.close();
            conn.close();
        }catch (SQLException exception){
            System.out.println("Erro ao excluir usuário: " + exception.getMessage());
        }
    }

}
