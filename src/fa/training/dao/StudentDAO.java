
package fa.training.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import fa.training.entities.KhaGioi;
import fa.training.entities.Students;
import fa.training.entities.TrungBinh;
import fa.training.exception.InvalidDOBException;
import fa.training.exception.InvalidFullNameException;
import fa.training.exception.InvalidPhoneNumberException;
import fa.training.utils.ConnectionUtil;

public class StudentDAO {

	public static int numberRecords = 0;

	/**
	 * THINHNV30 1993-03-03 THÊM THÔNG TIN HÀNH KHÁCH TỪ FILE
	 * 
	 * @throws Exception
	 */

	public static void insertKG() throws Exception {

		File f = new File("D:\\HOC_TAP\\FILE_FULLSTACK\\JPE\\JAVA CODE\\JPE_1\\STUDENTS\\src\\KHAGIOI_1.csv");
		String line = "";

		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO SINHVIEN (fullName, birthday, sex, phoneNumber, universityName, gradeLevel, diemTB, bestRewardName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				String fullName = data[0];
				String birthDateStr = data[1];
				String sex = data[2];
				String phoneNumber = data[3];
				String universityName = data[4];
				String gradeLevel = data[5];
				double diemTB = Double.parseDouble(data[6]);
				String bestRewardName = data[7];

				// Đây là biến boolean cho biết bản ghi có hợp lệ hay không
				boolean isValid = true;
				try {
					// Kiểm tra fullName
					if (!fullName.matches("^[A-Za-z ]{10,50}$")) {
						throw new InvalidFullNameException("Nhập tên không đúng vui lòng nhập lại:" + fullName);
					}

					// Kiểm tra birthDate
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					dateFormat.setLenient(false);
					try {
						dateFormat.parse(birthDateStr);
					} catch (ParseException e) {
						throw new InvalidDOBException("Nhập birthday không đúng vui lòng nhập lại: " + birthDateStr);
					}

					// Kiểm tra phoneNumber
					if (!phoneNumber.matches("^(090|098|091|031|035|038)\\d{7}$")) {
						throw new InvalidPhoneNumberException(
								"Nhập phoneNumber không đúng vui lòng nhập lại: " + phoneNumber);
					}

				} catch (InvalidFullNameException e) { // Đây là một lớp ngoại lệ cho biết lỗi xác thực

					isValid = false;
					// Đây là câu lệnh in thông báo lỗi ra bàn điều khiển
					System.out.println(e.getMessage());

				} catch (InvalidDOBException i) {
					isValid = false;
					System.out.println(i.getMessage());

				} catch (InvalidPhoneNumberException i) {
					isValid = false;
					System.out.println(i.getMessage());

				} catch (Exception i) {
					i.printStackTrace();
					isValid = false;
				}
				if (isValid) {

					// Nếu tất cả kiểm tra đều qua, thì thực hiện insert
					preparedStatement.setString(1, fullName);
					preparedStatement.setString(2, birthDateStr);
					preparedStatement.setString(3, sex);
					preparedStatement.setString(4, phoneNumber);
					preparedStatement.setString(5, universityName);
					preparedStatement.setString(6, gradeLevel);
					preparedStatement.setDouble(7, diemTB);
					preparedStatement.setString(8, bestRewardName);

					preparedStatement.executeUpdate();
					numberRecords++;

				}
			}

			br.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert that bai");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Insert that bai");

		} catch (Exception e) {
			System.out.println("Program have an unexpected error occurred !!!");
			e.printStackTrace();
		}
		if (numberRecords == 0) {
			System.out.println("Insert that bai");
		}
		System.out.println("Số dòng được insert là :" + numberRecords);
	}

	/**
	 * THINHNV30 1993-03-03 THÊM THÔNG TIN HÀNH KHÁCH TỪ FILE
	 * 
	 * @throws Exception
	 */

	public static void insertTB() throws Exception {

		File f = new File("D:\\HOC_TAP\\FILE_FULLSTACK\\JPE\\JAVA CODE\\JPE_1\\STUDENTS\\src\\TrungBinh1.csv");
		String line = "";

		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO SINHVIEN (fullName, birthday, sex, phoneNumber, universityName, gradeLevel, englishScore, entryTestScore ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

				String fullName = data[0];
				String birthDateStr = data[1];
				String sex = data[2];
				String phoneNumber = data[3];
				String universityName = data[4];
				String gradeLevel = data[5];
				int englishScore = Integer.parseInt(data[6]);
				double entryTestScore = Double.parseDouble(data[7]);

				// Đây là biến boolean cho biết bản ghi có hợp lệ hay không
				boolean isValid = true;

				try {
					// Kiểm tra fullName
					if (!fullName.matches("^[A-Za-z ]{10,50}$")) {
						throw new InvalidFullNameException("Nhập tên không đúng vui lòng nhập lại:" + fullName);
					}

					// Kiểm tra TestDate
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					try {
						dateFormat.parse(birthDateStr);
					} catch (ParseException e) {
						throw new InvalidDOBException("Nhập birthday không đúng vui lòng nhập lại: " + birthDateStr);
					}

					// Kiểm tra phoneNumber
					if (!phoneNumber.matches("^(090|098|091|031|035|038)\\d{7}$")) {
						throw new InvalidPhoneNumberException(
								"Nhập phoneNumber không đúng vui lòng nhập lại: " + phoneNumber);
					}

				} catch (InvalidFullNameException e) {
					// Đây là một lớp ngoại lệ cho biết lỗi xác thực
					isValid = false;
					// Đây là câu lệnh in thông báo lỗi ra bàn điều khiển
					System.out.println(e.getMessage());

				} catch (InvalidDOBException i) {
					isValid = false;
					System.out.println(i.getMessage());

				} catch (InvalidPhoneNumberException i) {
					isValid = false;
					System.out.println(i.getMessage());

				} catch (Exception i) {
					i.printStackTrace();
					isValid = false;
				}

				if (isValid) {

					// Nếu tất cả kiểm tra đều qua, thì thực hiện insert
					preparedStatement.setString(1, fullName);
					preparedStatement.setString(2, birthDateStr);
					preparedStatement.setString(3, sex);
					preparedStatement.setString(4, phoneNumber);
					preparedStatement.setString(5, universityName);
					preparedStatement.setString(6, gradeLevel);
					preparedStatement.setInt(7, englishScore);
					preparedStatement.setDouble(8, entryTestScore);

					preparedStatement.executeUpdate();
					numberRecords++;
				}
			}

			br.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert that bai");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Insert that bai");

		} catch (Exception e) {
			System.out.println("Program have an unexpected error occurred !!!");
			e.printStackTrace();
		}
		if (numberRecords == 0) {
			System.out.println("Insert that bai");
		}
		System.out.println("Số dòng được insert là :" + numberRecords);
		System.out.println();
	}

	/**
	 * THINHNV30 1993-03-03 Lấy thông tin từ database
	 */
	public static ArrayList<Students> getPassengersFromDatabase(Connection connection) {

		ArrayList<Students> passengers = new ArrayList<>();
		try {
			String query = "SELECT * FROM SINHVIEN";
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

				if (gradeLevel.equals("KHA")) {
					KhaGioi kg = new KhaGioi(fullName, birthdate, sex, phoneNumber, universityName, gradeLevel, diemTB,
							bestRewardName);
					passengers.add(kg);
				}

				if (gradeLevel.equals("TRUNG BINH KHA")) {
					TrungBinh tb = new TrungBinh(fullName, birthdate, sex, phoneNumber, universityName, gradeLevel,
							englishScore, entryTestScore);
					passengers.add(tb);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passengers;
	}

	/**
	 * THINHNV30 1993-03-03 GIỚI THIỆU THÔNG TIN CỦA CÁC HÀNH KHÁCH HIỆN CÓ
	 */
	public static void showInformation(ArrayList<Students> kgList) {
		for (Students kg : kgList) {
			kg.showMyInfo();
			System.out.println(); // In một dòng trống để phân tách giữa các hành khách
		}
	}

	/**
	 * THINHNV30 1993-03-03 GIỚI THIỆU THÔNG TIN CỦA CÁC HÀNH KHÁCH HIỆN CÓ
	 */
	public static void getInformationKhaGioi() {

		Connection conn = ConnectionUtil.getConnection();
		// Tạo một danh sách hành khách
		ArrayList<Students> passengers = new ArrayList<Students>();
		passengers = getPassengersFromDatabase(conn);

		// Gọi phương thức showInformation để hiển thị thông tin của hành khách
		showInformation(passengers);
	}

	/**
	 * THINHNV30 1993-03-03 SẮP XẾP DANH SÁCH HÀNH KHÁCH
	 */
	public static void sortKhaGioi() {
		try {
			Connection connection = ConnectionUtil.getConnection();

			// Truy vấn dữ liệu hành khách từ cơ sở dữ liệu
			ArrayList<Students> passengers = getPassengersFromDatabase(connection);

			// Sắp xếp danh sách hành khách theo yêu cầu
//			Collections.sort(passengers, new Comparator<Students>() {
//				@Override
//				public int compare(Students p1, Students p2) {
//					try {
//						// So sánh theo getFullName giảm dần
//
//						if (p1.getFullName().equals(p2.getFullName())) {
//							return p1.getPhoneNumber().compareTo(p2.getPhoneNumber());
//						}
//						return (-1) * p1.getFullName().compareTo(p2.getFullName());
//
//						// So sánh theo PassengerID tăng dần
////						return p1.getPassengerID().compareTo(p2.getPassengerID());
//					} catch (Exception e) {
//						e.printStackTrace();
//						return 0;
//					}
//				}
//			});

			Collections.sort(passengers,
					Comparator.comparing(Students::getFullName).reversed().thenComparing(Students::getPhoneNumber));
			// Hiển thị danh sách đã sắp xếp
			showInformation(passengers);

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * THINHNV30 1993-03-03 XÓA THÔNG TIN HÀNH KHÁCH
	 */
//		public static void deleteHK(String maHocSinh) {
	public static void deleteHK() {
		try {
			Connection connection = ConnectionUtil.getConnection();

			// Xóa hành khách chưa tiến hành test Covid (TestDate có giá trị null)
			String query = "DELETE FROM SINHVIEN WHERE fullName = 'NGUYEN VAN C' ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

//			preparedStatement.setString(1, maHocSinh);
//			preparedStatement.setString(1, "%" + tenHocSinh);
			preparedStatement.executeUpdate();

			// Đóng kết nối
			connection.close();

			System.out.println("Deleted passengers with null fullName.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
//			insertKG();
//			insertTB();
//			sortKhaGioi();
			getInformationKhaGioi();
//			deleteHK();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
