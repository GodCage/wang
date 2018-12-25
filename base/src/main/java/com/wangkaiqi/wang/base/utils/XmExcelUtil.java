package com.wangkaiqi.wang.base.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Excel操作工具
 *
 * @author wangkaiqi
 * @date 2018/11/22 10:04
 */
@Slf4j
public class XmExcelUtil {
	/**
	 * 生成excel并发送
	 *
	 * @param response, fileName, notes, titles
	 */
	public static void sendExcel(HttpServletResponse response, String fileName, String[][] notes, String[][] titles) throws IOException {
		XSSFWorkbook xssfSheets = null;
		try {
			try {
				//生成excel
				xssfSheets = XmExcelUtil.creatExcel(titles, notes, fileName);
				fileName = new String(fileName.getBytes(), "ISO8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			
			OutputStream os = response.getOutputStream();
			assert xssfSheets != null;
			xssfSheets.write(os);
			os.flush();
			os.close();
			xssfSheets.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 创建excel
	 *
	 * @param titles, notes, sheetName
	 * @return org.apache.poi.xssf.usermodel.XSSFWorkbook
	 */
	private static XSSFWorkbook creatExcel(String[][] titles, String[][] notes, String sheetName) throws Exception {
		try
		
		{
			//1.创建工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			//1.1创建合并单元格对象
			//	CellRangeAddress callRangeAddress = new CellRangeAddress(0, 0, 0, 4);//起始行,结束行,起始列,结束列
			//1.2头标题样式
			//	XSSFCellStyle headStyle = createCellStyle(workbook, (short) 16);
			//1.3（必填）列标题样式(黑色字体)
			XSSFCellStyle colStyleMust = createCellStyle(workbook, IndexedColors.PALE_BLUE.getIndex());
			//1.3（非必填）列标题样式(黑色字体)
			XSSFCellStyle colStyleNotMust = createCellStyle(workbook, IndexedColors.PALE_BLUE.getIndex());
			//1.4正文样式
			XSSFCellStyle testStyle = createTestStyle(workbook);
			//2.创建工作表
			XSSFSheet sheet = workbook.createSheet(sheetName);
			
			//设置默认列宽
			sheet.setDefaultColumnWidth(25);
			//3.创建行
			
			//3.2创建列标题;并且设置列标题
			XSSFRow row2 = sheet.createRow(0);
			//
			for (int i = 0; i < titles.length; i++) {
				XSSFCell cell2 = row2.createCell(i);
				//加载单元格样式
				if ("1".equals(titles[i][1])) {
					cell2.setCellStyle(colStyleMust);
				} else {
					cell2.setCellStyle(colStyleNotMust);
				}
				cell2.setCellValue(titles[i][0]);
			}
			
			//4.操作单元格;将用户列表写入excel
			for (int j = 0; j < notes.length; j++) {
				XSSFRow row3 = sheet.createRow(j + 1);
				for (int i = 0; i < titles.length; i++) {
					//创建数据行,前面有一行,列标题行
					XSSFCell cellTest = row3.createCell(i);
					cellTest.setCellStyle(testStyle);
					cellTest.setCellValue(notes[j][i]);
				}
			}
			
			//5.输出
//		out = new FileOutputStream(new File("E:\\hello.xlsx"));
//		workbook.write(out);
//		workbook.close();
//		out.close();
			return workbook;
		} catch (Exception e) {
			log.info("生成Excel文件失败:{}", e.getMessage());
			throw new Exception("生成Excel文件失败");
		}
		
	}
	
	/**
	 * @param workbook excel表
	 * @param color    背景色
	 * @return 单元格标题样式
	 */
	private static XSSFCellStyle createCellStyle(XSSFWorkbook workbook, short color) {
		XSSFCellStyle style = workbook.createCellStyle();
		//设置颜色
		style.setFillForegroundColor(color);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		//创建字体
		XSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 16);
		font.setColor(Font.COLOR_NORMAL);
		//加载字体
		style.setFont(font);
		return commonStyle(style);
	}
	
	/**
	 * @param workbook excel表
	 * @return 单元格正文样式
	 */
	private static XSSFCellStyle createTestStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();
		return commonStyle(style);
		
	}
	
	private static XSSFCellStyle commonStyle(XSSFCellStyle style) {
		//水平居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//垂直居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//设置边框
		//下边框
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		//左边框
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		//上边框
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		//右边框
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		return style;
	}
	
}
