/**
 * 
 */
package fa.training.main;

import java.util.Scanner;

import fa.training.dao.StudentDAO;

/**
 * @author Van Thinh
 *
 */
public class Menu {

	public static void menu() {

		Scanner sc = new Scanner(System.in);

		String st = null;
		int choice;
		do {
			System.out.println("----- Chào mừng bạn đến với chương trình quản lí bài tập của THINHNV30 -----");
			System.out.println("-----CHÚC BẠN NGÀY MỚI TỐT LÀNH-------");
			System.out.println(" 1.Chức năng insert students kha gioi ");
			System.out.println(" 2.Sắp xếp khá giỏi theo tên giảm dần và sdt tăng dần ");
			System.out.println(" 3.Chức năng insert students trung bình ");
			System.out.println(" 4.Sắp xếp danh sách trung bình tên giảm dần và sdt tăng dần ");
			System.out.println(" 5.Xóa những hành khách chưa tiến hành test covid ");
			System.out.println("======Nhập vào số nguyên tương ứng với bài tập bạn muốn chạy :");
			System.out.println();

			while (true) {
				try {
					st = sc.nextLine();
					choice = Integer.parseInt(st);
					System.out.println("Số bạn nhập là : " + choice);
					break;
				} catch (Exception ex) {
					System.out.println(st + "Không phải số nguyên");
					System.out.println("Vui lòng nhập lại ");
				}
			}
			switch (choice) {
			case 1:// Cau 1
				try {
					StudentDAO.insertKG();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:// Cau 2
				StudentDAO.sortKhaGioi();
				break;

			case 3:// Cau 3
				try {
					StudentDAO.insertTB();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 4:// Cau 4
//				TrungBinhDAO.sortTrungBinh();
				break;

			case 5:// Cau 5
//				Methods_HanhKhach.deleteHK();
				break;

			case 0:
				// 0. Thoát
				System.out.println("====Kết thúc chương trình======");
				break;

			default:
				System.out.println("Lựa chọn không hợp lệ");
				break;
			}
		} while (choice != 0);

	}

	public static void main(String[] args) {

		try {
			menu();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Program have an unexpected error occurred !!!");
			System.out.println("Program is Exit");

		}
	}

}
