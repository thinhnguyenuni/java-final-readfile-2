/**
 * 
 */
package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fa.training.entities.KhaGioi;
import fa.training.entities.Students;
import fa.training.entities.TrungBinh;
import fa.training.utils.ConnectionUtil;

/**
 * @author Van Thinh
 *
 */
public class Test {

	/**
	 * THINHNV30 1993-03-03 Lấy thông tin từ database
	 */
	public static void getPassengersFullNameDESC(Connection connection) {

		ArrayList<Students> passengers = new ArrayList<>();
		try {
			String query = "SELECT * FROM SINHVIEN ORDER BY fullName DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// Tạo đối tượng Passenger từ dữ liệu ResultSet
				String fullName = resultSet.getString("fullName");
				String birthdate = resultSet.getString("birthday");
				String sex = resultSet.getString("sex");
				String phoneNumber = resultSet.getString("phoneNumber");
				String universityName = resultSet.getString("universityName");
				String gradeLevel = resultSet.getString("gradeLevel");
				double diemTB = resultSet.getDouble("diemTB");
				String bestRewardName = resultSet.getString("bestRewardName");

				int englishScore = resultSet.getInt("englishScore");
				double entryTestScore = resultSet.getDouble("entryTestScore");

				if (diemTB != 0) {
					KhaGioi kg = new KhaGioi(fullName, birthdate, sex, phoneNumber, universityName, gradeLevel, diemTB,
							bestRewardName);
					passengers.add(kg);
				}

				if (englishScore != 0) {
					TrungBinh tb = new TrungBinh(fullName, birthdate, sex, phoneNumber, universityName, gradeLevel,
							englishScore, entryTestScore);
					passengers.add(tb);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		StudentDAO.showInformation(passengers);
	}

	public static void main(String[] args) {
		Connection connection = ConnectionUtil.getConnection();
		getPassengersFullNameDESC(connection);
	}
}
