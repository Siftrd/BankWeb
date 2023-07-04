package dao;

import java.util.ArrayList;

import javax.annotation.Generated;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.KhachHang;
import model.TK_TietKiem;

@Generated(value = "org.junit-tools-1.1.0")
public class TK_TietKiemDAOTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	private TK_TietKiemDAO createTestSubject() {
		return new TK_TietKiemDAO();
	}

	@Test
	public void testSearch() throws Exception {
		String fromDate = "2023-01-01";
		String toDate = "2024-05-30";
		Double minValue = null;
		String status = "";
		ArrayList<TK_TietKiem> result;
		ArrayList<TK_TietKiem> expected = new ArrayList<>();
		KhachHang kh1 = new KhachHang(1, "Pham Hong Nhung", "987654321000", "0123456789", "Nữ", "2003-04-08");
		expected.add(new TK_TietKiem(1, "1", "456123", "2023-04-01", 3000000.500, 5.5, kh1, "Lãi nhập gốc"));
		
		KhachHang kh2 = new KhachHang(2, "Pham Hong Nam", "778978978978", "8529637401", "Nam", "2001-04-30");
		expected.add(new TK_TietKiem(2, "2", "000002", "2023-03-07", 15000000.000, 5.5, kh2, "Lãi nhập gốc"));

		// test 1
		minValue = 0.0;
		result = TK_TietKiemDAO.search(fromDate, toDate, minValue, status);
		Assert.assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void testGetRecords_GetRecordFrom1to3() throws Exception {
		int start = 1;
		int total = 3;
		ArrayList<TK_TietKiem> result;
		ArrayList<TK_TietKiem> expected = new ArrayList<>();
		KhachHang kh1 = new KhachHang(1, "Pham Hong Nhung", "987654321000", "0123456789", "Nữ", "2003-04-08");
		expected.add(new TK_TietKiem(1, "1", "456123", "2023-04-01", 3000000.500, 5.5, kh1, "Lãi nhập gốc"));
		
		KhachHang kh2 = new KhachHang(2, "Pham Hong Nam", "778978978978", "8529637401", "Nam", "2001-04-30");
		expected.add(new TK_TietKiem(2, "2", "000002", "2023-03-07", 15000000.000, 5.5, kh2, "Lãi nhập gốc"));
		
		KhachHang kh3 = new KhachHang(3, "Bùi Nhật Minh", "987654321000", "0123456789", "Nam", "2001-12-01");
		expected.add(new TK_TietKiem(3, "3", "895646", "2023-04-01", 5000000.000, 6.5, kh3, "Lãi nhập gốc"));
		
		
		// default test
		result = TK_TietKiemDAO.getRecords(start, total);
		Assert.assertEquals(expected.toString(), result.toString());
	}
	
	@Test
	public void testGetRecords_GetRecordFrom2to3() throws Exception {
		int start = 2;
		int total = 3;
		ArrayList<TK_TietKiem> result;
		ArrayList<TK_TietKiem> expected = new ArrayList<>();
		KhachHang kh2 = new KhachHang(2, "Pham Hong Nam", "778978978978", "8529637401", "Nam", "2001-04-30");
		expected.add(new TK_TietKiem(2, "2", "000002", "2023-03-07", 15000000.000, 5.5, kh2, "Lãi nhập gốc"));
		
		KhachHang kh3 = new KhachHang(3, "Bùi Nhật Minh", "987654321000", "0123456789", "Nam", "2001-12-01");
		expected.add(new TK_TietKiem(3, "3", "895646", "2023-04-01", 5000000.000, 6.5, kh3, "Lãi nhập gốc"));
		KhachHang kh4 = new KhachHang(1, "Pham Hong Nhung", "987654321000", "0123456789", "Nữ", "2003-04-08");
		expected.add(new TK_TietKiem(6, "4", "852369", "2023-01-01", 10000000.000, 5.5, kh4, "Lãi nhập gốc"));
		
//		KhachHang kh2 = new KhachHang(2, "Pham Hong Nam", "778978978978", "8529637401", "Nam", "2001-04-30");
//		expected.add(new TK_TietKiem(1, "5", "753159", "2023-04-24", 5000000.000, 5.5, kh2, "Lãi trả vào tài khoản tiền gửi khi đến hạn"));
//		
//		expected.add(new TK_TietKiem(4, "6", "951233", "2022-12-01", 20000000.000, 5.5, kh4, "Lãi nhập gốc"));
		
		
		// default test
		result = TK_TietKiemDAO.getRecords(start, total);
		Assert.assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void testGetTKTKById_1() throws Exception {
		int id = 1;
		TK_TietKiem result;
		KhachHang kh1 = new KhachHang(1, "Pham Hong Nhung", "987654321000", "0123456789", "Nữ", "2003-04-08");
		TK_TietKiem expected = new TK_TietKiem(1, "1", "456123", "2023-04-01", 3000000.500, 5.5, kh1, "Lãi nhập gốc");
		 
		// default test
		result = TK_TietKiemDAO.getTKTKById(id);
		Assert.assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void testGetTKTKById_0() throws Exception {
		int id = 0;
		TK_TietKiem result;
		TK_TietKiem expected = null;
		 
		// default test
		result = TK_TietKiemDAO.getTKTKById(id);

		Assert.assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void testGetTKTKByMaKH_0() throws Exception {
		int id = 0;
		ArrayList<TK_TietKiem> result;

		ArrayList<TK_TietKiem> expected = null;

		// default test
		result = TK_TietKiemDAO.getTKTKByMaKH(id);
		Assert.assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void testGetTKTKByMaKH_2() throws Exception {
		int id = 2;
		ArrayList<TK_TietKiem> result;

		ArrayList<TK_TietKiem> expected = new ArrayList<>();
		KhachHang kh2 = new KhachHang(2, "Pham Hong Nam", "778978978978", "8529637401", "Nam", "2001-04-30");

		expected.add(new TK_TietKiem(2, "2", "000002", "2023-03-07", 15000000.000, 5.5, kh2, "Lãi nhập gốc"));
		expected.add(new TK_TietKiem(1, "5", "753159", "2023-04-24", 5000000.000, 5.5, kh2, "Lãi trả vào tài khoản tiền gửi khi đến hạn"));

		// default test
		result = TK_TietKiemDAO.getTKTKByMaKH(id);
		Assert.assertEquals(expected.toString(), result.toString());
	}
}