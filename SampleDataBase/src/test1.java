import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test1 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

		try {
			// ドライバーに登録
			Class.forName("org.sqlite.JDBC");

			// データベースに接続
			connection = DriverManager.getConnection("jdbc:sqlite:data.db");
			System.out.println("接続成功");

			// statementオブジェクトの生成
			statement = connection.createStatement();

			// SampleTableのnameにhaluを追加
			statement.executeUpdate("INSERT INTO SampleTable(name) VALUES('halu')");

			// ResultSetオブジェクトにname列のデータを格納
			ResultSet resultSet = statement.executeQuery("SELECT name FROM SampleTable WHERE id = 1");
			//表示
			System.out.println(resultSet.getString("name"));
			
			//１行目をhaluからtanakaに変更
			statement.executeUpdate("UPDATE SampleTable set name = 'tanaka' WHERE id = 1");
			
			// ResultSetオブジェクトにname列のデータを格納
			resultSet = statement.executeQuery("SELECT name FROM SampleTable WHERE id = 1");
			//表示
			System.out.println(resultSet.getString("name"));

			// リソースの解放（メモリの解放）
			resultSet.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					
					//データベースとJDBCとのconnectionの解除
					connection.close();
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
