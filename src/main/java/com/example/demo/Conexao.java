
package com.example.demo;


import java.sql.*;
import java.util.Scanner;

public class Conexao {
    public static void inserirDados(String cidades,Integer habitantes,Integer casos,Integer infectados) throws ClassNotFoundException {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/projeto01";
            String usuario = "root";
            String senha = "password";
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Dengue(Cidades,Habitantes,Casos,Infectados) VALUES (?,?,?,?)");
            pstmt.setString(1, cidades);
            pstmt.setInt(2, habitantes);
            pstmt.setInt(3, casos);
            pstmt.setInt(4, infectados);

            pstmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso!");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Teste");

        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira a cidade:   ");
        String valorColuna1= scanner.nextLine();
        System.out.println("Insira o total habitantes:  ");
        Integer valorColuna2= scanner.nextInt();
        System.out.println("Insira o total casos:  ");
        Integer valorColuna3= scanner.nextInt();
        System.out.println("Insira infectados dessa cidade:  ");
        Integer valorColuna4= scanner.nextInt();

        Conexao conexao = new Conexao();
        Conexao.inserirDados(valorColuna1,valorColuna2,valorColuna3,valorColuna4);
        scanner.close();
    }

}
