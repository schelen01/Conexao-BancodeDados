import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import static org.apache.log4j.Logger.*;


public class Main {

    //CRIAR A TABELA NO BANCO DE DADOS. Se não existir ele cria para gente.
    //Repassa as instruções e atributos

    private static final String sqlCreateTable = "DROP TABLE IF EXISTIS Usuario; CREATE TABLE Usuário"
            + "("
            + "Id INT PRIMARY KEY,"
            + "Nome VARCHAR(100) NOT NULL,"
            + "Sobrenome VARCHAR(100) NOT NULL,"
            + "Idade INT NOT NULL,"
            + ")";

    //cria as queries de insert
    private static final String sqlInsert1 = "INSERT INTO Usuario (Id, Nome, Sobrenome, Idade) VALUE (1, 'Suelen', 'Alves', 25)";
    private static final String sqlInsert2 = "INSERT INTO Usuario (Id, Nome, Sobrenome, Idade) VALUE (2, 'Claudia', 'Silva', 22)";
    private static final String sqlInsert3 = "INSERT INTO Usuario (Id, Nome, Sobrenome, Idade) VALUE (3, 'Sheila', 'Perez', 31)";
    private static final String sqlInsert4 = "INSERT INTO Usuario (Id, Nome, Sobrenome, Idade) VALUE (4, 'Arnaldo', 'Gonçalvez', 27)";

    //o exercício pede para deletar uma dado
    private static final String sqlDelete = "DELETE FROM Usuario WHERE id = 1";

    //PRECISO LOGAR COM A BIBLIOTECA DO jar
    private static final  Logger logger = getLogger(Main.class);

    public static void main(String[] args) {
        //simula a conexão com o Banco de dados
        Connection connection = null;
        //se a conexão for nula tente isso..

        try{

        connection =getConnection();
        //vamos executar a tabela
        Statement statement = connection.createStatement();
        statement.execute(sqlCreateTable);

        statement.execute(sqlInsert1);
        statement.execute(sqlInsert2);
        statement.execute(sqlInsert3);
        statement.execute(sqlInsert4);

        statement.execute(sqlDelete);


        Logger.info("Excluindo o usuário de id 1");

        connection.close();


        } catch (Exception e){
            e.printStackTrace();
        }

    }
    //Primeiro montamos a conexão com o Banco de dados
    public static Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

    }
}