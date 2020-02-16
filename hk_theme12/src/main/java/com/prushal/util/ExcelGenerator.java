package com.prushal.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.prushal.model.Merchant;
import com.prushal.model.PaymentDueReport;
import com.prushal.model.Project;
import com.prushal.model.Terminal;

public class ExcelGenerator {

	public static ByteArrayInputStream noDataFound() throws IOException {
		String[] COLUMNs = { "NO", "DATA", "AVAILABLE", "TO", "DOWNLOAD" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("Projects");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.RED.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}

	}

	public static ByteArrayInputStream projectsToExcel(List<Project> projects) throws IOException {
		String[] COLUMNs = { "PId", "Project Name", "Project ID", "Contact Person", "Mobile Number", "Email Id",
				"Abbrv", "Legal Name", "City", "State", "Pincode", "Country", "Is Transfer Allowed Within Project",
				"Is Corporate", "Project Type", "Created At", "Updated At" };

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("Projects");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			int rowIdx = 1;
			for (Project project : projects) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(project.getpId());
				row.createCell(1).setCellValue(project.getProjectName());
				row.createCell(2).setCellValue(project.getProjectID());
				row.createCell(3).setCellValue(project.getContactPerson());
				row.createCell(4).setCellValue(project.getMobileNumber());
				row.createCell(5).setCellValue(project.getEmailId());
				row.createCell(6).setCellValue(project.getAbbrv());
				row.createCell(7).setCellValue(project.getLegalName());
				row.createCell(8).setCellValue(project.getAddress().getCity());
				row.createCell(9).setCellValue(project.getAddress().getState());
				row.createCell(10).setCellValue(project.getAddress().getPin());
				row.createCell(11).setCellValue(project.getAddress().getCountry());
				row.createCell(12).setCellValue(project.getIsTransferAllowedWithinProject());
				row.createCell(13).setCellValue(project.getIsCorporate());
				row.createCell(14).setCellValue(project.getProjectType());
				row.createCell(15).setCellValue(project.getCreatedAt().toString());
				row.createCell(16).setCellValue(project.getUpdatedAt().toString());
			}

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			sheet.autoSizeColumn(7);
			sheet.autoSizeColumn(8);
			sheet.autoSizeColumn(9);
			sheet.autoSizeColumn(10);
			sheet.autoSizeColumn(11);
			sheet.autoSizeColumn(12);
			sheet.autoSizeColumn(13);
			sheet.autoSizeColumn(14);
			sheet.autoSizeColumn(15);
			sheet.autoSizeColumn(16);
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	public static ByteArrayInputStream merchantsToExcel(List<Merchant> merchants) throws IOException {
		String[] COLUMNs = { "MId", "Project ID", "Merchant ID", "Contact Person", "Mobile Number", "Email Id",
				"Gst Number", "Aadhaar Number", "Pan Number", "Shop Name", "Legal Name", "Shop No", "Lane No",
				"Lane Name", "Area Name", "Landmark", "City", "State", "Pincode", "Country", "Status", "Created At",
				"Updated At" };

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("Merchants");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			int rowIdx = 1;
			for (Merchant merchant : merchants) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(merchant.getmId());
				row.createCell(1).setCellValue(merchant.getProjectID());
				row.createCell(2).setCellValue(merchant.getMerchantID());
				row.createCell(3).setCellValue(merchant.getContactPerson());
				row.createCell(4).setCellValue(merchant.getMobileNumber());
				row.createCell(5).setCellValue(merchant.getEmailId());
				row.createCell(6).setCellValue(merchant.getGstNumber());
				row.createCell(7).setCellValue(merchant.getAadharNumber());
				row.createCell(8).setCellValue(merchant.getPanNumber());
				row.createCell(9).setCellValue(merchant.getShopName());
				row.createCell(10).setCellValue(merchant.getLegalName());
				row.createCell(11).setCellValue(merchant.getAddress().getShopNo());
				row.createCell(12).setCellValue(merchant.getAddress().getLaneNo());
				row.createCell(13).setCellValue(merchant.getAddress().getLaneName());
				row.createCell(14).setCellValue(merchant.getAddress().getAreaName());
				row.createCell(15).setCellValue(merchant.getAddress().getLandmark());
				row.createCell(16).setCellValue(merchant.getAddress().getCity());
				row.createCell(17).setCellValue(merchant.getAddress().getState());
				row.createCell(18).setCellValue(merchant.getAddress().getPin());
				row.createCell(19).setCellValue(merchant.getAddress().getCountry());
				row.createCell(20).setCellValue(merchant.getStatus());
				row.createCell(21).setCellValue(merchant.getCreatedAt().toString());
				row.createCell(22).setCellValue(merchant.getUpdatedAt().toString());
			}

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			sheet.autoSizeColumn(7);
			sheet.autoSizeColumn(8);
			sheet.autoSizeColumn(9);
			sheet.autoSizeColumn(10);
			sheet.autoSizeColumn(11);
			sheet.autoSizeColumn(12);
			sheet.autoSizeColumn(13);
			sheet.autoSizeColumn(14);
			sheet.autoSizeColumn(15);
			sheet.autoSizeColumn(16);
			sheet.autoSizeColumn(17);
			sheet.autoSizeColumn(18);
			sheet.autoSizeColumn(19);
			sheet.autoSizeColumn(20);
			sheet.autoSizeColumn(21);
			sheet.autoSizeColumn(22);

			String[] COLUMNs2 = { "tId", "ProjectID", "MerchantID", "TerminalID", "Password", "Pin", "Created At",
					"Updated At" };
			Sheet sheet1 = workbook.createSheet("Terminals");

			// Row for Header
			Row headerRow1 = sheet1.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs2.length; col++) {
				Cell cell = headerRow1.createCell(col);
				cell.setCellValue(COLUMNs2[col]);
				cell.setCellStyle(headerCellStyle);
			}

			int row2Idx = 1;
			for (Merchant merchant : merchants) {
				for (Terminal terminal : merchant.getTerminals()) {
					Row row = sheet1.createRow(row2Idx++);
					row.createCell(0).setCellValue(terminal.gettId());
					row.createCell(1).setCellValue(terminal.getProjectID());
					row.createCell(2).setCellValue(terminal.getMerchantID());
					row.createCell(3).setCellValue(terminal.getTerminalID());
					row.createCell(4).setCellValue(terminal.getPassword());
					row.createCell(5).setCellValue(terminal.getPin());
					row.createCell(6).setCellValue(terminal.getCreatedAt().toString());
					row.createCell(7).setCellValue(terminal.getUpdatedAt().toString());
				}
			}
			sheet1.autoSizeColumn(0);
			sheet1.autoSizeColumn(1);
			sheet1.autoSizeColumn(2);
			sheet1.autoSizeColumn(3);
			sheet1.autoSizeColumn(4);
			sheet1.autoSizeColumn(5);
			sheet1.autoSizeColumn(6);
			sheet1.autoSizeColumn(7);

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	public static ByteArrayInputStream uploadLimitFormat() throws IOException {
		String[] COLUMNs = { "Project ID", "Project Name", "MerchantID", "Agreed Top-Up Amount", "Actual Top-Up Paid",
				"Bank Name", "Cheque Number", "Cheque Date(dd-mm-yyyy)", "Cheque Clearance Date(dd-mm-yyyy)",
				"Transation ID", "City" };

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("Redeems");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			sheet.autoSizeColumn(7);
			sheet.autoSizeColumn(8);
			sheet.autoSizeColumn(9);
			sheet.autoSizeColumn(10);
			sheet.autoSizeColumn(11);

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	public static ByteArrayInputStream paymentDueReport(List<PaymentDueReport> reports) throws IOException {
		String[] COLUMNs = { "Sr No.", "MerchantID", "Project ID", "Contact Person", "Mobile Number", "Email ID",
				"Due Date", "Merchant Limit" };

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("Payment Due");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			int rowIdx = 1;
			int rowCount = 1;
			for (PaymentDueReport report : reports) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(rowCount);
				row.createCell(1).setCellValue(report.getMerchantID());
				row.createCell(2).setCellValue(report.getProjectID());
				row.createCell(3).setCellValue(report.getContactPerson());
				row.createCell(4).setCellValue(report.getMobileNumber());
				row.createCell(5).setCellValue(report.getEmailId());
				row.createCell(6).setCellValue(report.getDueDate().toString());
				row.createCell(7).setCellValue(report.getMerchantLimit().doubleValue());

				rowCount++;
			}
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			sheet.autoSizeColumn(7);

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}

	}
}
