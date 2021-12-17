package com.lab;

import windows.MainWindow;
import java.sql.*;

public class Database {

    public Database(){
        String host ="jdbc:mysql://localhost:3306/touristvoucher?serverTimezone=UTC";
        String user_name ="root";
        String user_pass ="root";
        try {

            Connection connection = DriverManager.getConnection(host, user_name, user_pass);
            Statement statement = connection.createStatement();

            String sql1 = "CREATE TABLE TouristVoucher (\n" +
                    "ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"+
                    "NameOfVoucher VARCHAR(30) NOT NULL,\n" +
                    "TypeOfTransport VARCHAR(30) NOT NULL,\n" +
                    "TypeOfResidence VARCHAR(30) NOT NULL,\n" +
                    "TypeOfFood VARCHAR(30) NOT NULL,\n" +
                    "NumberOfDays INT NOT NULL,\n" +
                    "NumberOfPeople INT NOT NULL,\n" +
                    "Coefficient FLOAT NOT NULL\n" +
                    ");\n";

                    String sql2 ="INSERT INTO TouristVoucher(NameOfVoucher, TypeOfTransport, TypeOfResidence, TypeOfFood, NumberOfDays, NumberOfPeople, Coefficient)\n" +
                    "VALUES \n" +
                    "('Відпочинок', 'літак', 'готель', 'все включено', 7, 2, 1.0),\n" +
                    "('Екскурсія', 'автобус', 'хостел', 'тільки сніданок', 4, 1, 1.4),\n" +
                    "('Лікування', 'літак', 'готель', 'все включено', 14, 1, 3.0),\n" +
                    "('Шопінг', 'літак', 'апартаменти', 'немає', 3, 4, 1.2),\n" +
                    "('Круїз', 'поїзд', 'готель', 'все включено', 10, 2, 2.0)";

            statement.execute(sql1);
            statement.execute(sql2);
            ResultSet result = statement.executeQuery("SELECT * FROM touristvoucher.TouristVoucher");

            int count = 0;
            while (result.next()){
                String name=result.getString("NameOfVoucher");
                String type_of_transport=result.getString("TypeOfTransport");
                String type_of_residence=result.getString("TypeOfResidence");
                String type_of_food=result.getString("TypeOfFood");
                int number_of_days=result.getInt("NumberOfDays");
                int number_of_people=result.getInt("NumberOfPeople");
                double coefficient=result.getDouble("Coefficient");
                MainWindow.voucher.makeVoucher(count, name, type_of_transport, type_of_residence, type_of_food, number_of_days, number_of_people, coefficient);
                count++;
            }

            //statement.execute("DROP TABLE touristvoucher;");
            connection.close();

        } catch (SQLException e) {
            System.out.printf("\nError\n");
            e.printStackTrace();
        }
    }

}
