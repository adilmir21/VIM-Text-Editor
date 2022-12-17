package DB;

import BL.DataBaseConnection;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.sql.*;

public class DataBase implements BL.DataBase {

    @Override
    public  void loadfile(TextArea textArea, String command)
    {
        DataBaseConnection connection = new DataBaseConnection();
    Connection connect = connection.getConnection();

    String check = "select Texts from projects where name = '" + command + "'";

       try
    {
        Statement statement = connect.createStatement();
        ResultSet queryResult = statement.executeQuery(check);
        while (queryResult.next()) {
            String x = queryResult.getString(1);
            textArea.appendText(x);
        }
        // textArea.setText(String.valueOf(queryResult));

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
    public void savetodb(TextArea textArea, String command) {
        DataBaseConnection connection = new DataBaseConnection();
        Connection connect = connection.getConnection();
        PreparedStatement statement = null;
        PreparedStatement checkuser = null;
        ResultSet resultSet = null;
        try
        {
            checkuser = connect.prepareStatement("select* from projects where name = '" + command + "'");
            //checkuser.setString(1,command);
            resultSet = checkuser.executeQuery();
            if(resultSet.isBeforeFirst())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("File Exists!");
                alert.show();
            }
            else
            {
                String texts = textArea.getText();
                statement = connect.prepareStatement("insert into projects values(?,?)");
                statement.setString(1,command);
                statement.setString(2,texts);
                int status = statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void savetoDB(String textArea, String command) {
        DataBaseConnection connection = new DataBaseConnection();
        Connection connect = connection.getConnection();
        PreparedStatement statement = null;
        PreparedStatement checkuser = null;
        ResultSet resultSet = null;
        try
        {
            checkuser = connect.prepareStatement("select* from projects where name = '" + command + "'");
            //checkuser.setString(1,command);
            resultSet = checkuser.executeQuery();
            if(resultSet.isBeforeFirst())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("File Exists!");
                alert.show();
            }
            else
            {
                String texts = textArea;
                statement = connect.prepareStatement("insert into projects values(?,?)");
                statement.setString(1,command);
                statement.setString(2,texts);
                int status = statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  String load(String command) {
        DataBaseConnection connection = new DataBaseConnection();
        Connection connect = connection.getConnection();

        String check = "select Texts from projects where name = '" + command + "'";
        String output = null;

        try {
            Statement statement = connect.createStatement();
            ResultSet queryResult = statement.executeQuery(check);
            while (queryResult.next()) {
                String x = queryResult.getString(1);
                output = output+x;
                System.out.println(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  output;
    }
}

