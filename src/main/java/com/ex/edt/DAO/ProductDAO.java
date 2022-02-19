package com.ex.edt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ex.edt.VO.ProductVO;
import com.ex.edt.util.DBConnector;

public class ProductDAO {
	ProductVO pVo;
	
	public ProductDAO () {}
	
	public ProductVO getVO() {
		pVo = new ProductVO();
		return pVo;
	}
	
	public List<ProductVO> getProductsList(String brand, String filter, String gender) {
		List<ProductVO> pVos = new ArrayList<ProductVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM product3";
		
		System.out.println(brand + " / " + filter + " / " + gender);
		
		if ( brand != null && gender != null ) {
			sql += " WHERE p_brand=" + brand + " AND p_gender=" + gender ; 
		} if ( brand != null && gender == null) {
			sql += " WHERE p_brand=" + brand; 
		} else if ( brand == null && gender != null ) { 
			sql += " WHERE p_gender=" + gender; 
		}

		if ( filter != null ) { 
			sql += " ORDER BY " + filter;
		}
		System.out.println(sql);
		try {
			conn = DBConnector.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pVo.setpId(rs.getString(1));
				pVo.setpBrand(rs.getString(2));
				pVo.setpCollection(rs.getString(3));
				pVo.setpEname(rs.getString(4));
				pVo.setpKname(rs.getString(5));
				pVo.setpImage(rs.getString(6));
				pVo.setpGender(rs.getString(7));
				pVo.setpSize(rs.getInt(8));
				pVo.setpPrice(rs.getInt(9));
				pVo.setpStock(rs.getInt(10));
				pVo.setpDate(rs.getTimestamp(11));
				pVo.setpHit(rs.getInt(12));
				pVos.add(pVo);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			DBConnector.queryClose(conn, pstmt, rs);
		}
		return pVos;
	}
}
