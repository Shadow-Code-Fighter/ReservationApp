package com.reservationapp.util;

import com.reservationapp.entity.Passenger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelGeneratorService {

    /**
     * Generates an Excel file containing passenger data.
     *
     * @param passengers The list of passengers to include in the Excel file.
     * @return The byte array representing the generated Excel file.
     * @throws IOException If an I/O error occurs while writing the Excel file.
     */
    public byte[] generateExcel(List<Passenger> passengers) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) { // Create a new Excel workbook
            Sheet sheet = workbook.createSheet("Passenger Data"); // Create a sheet named "Passenger Data"

            // Create header row with column names
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("First Name");
            headerRow.createCell(2).setCellValue("Last Name");
            headerRow.createCell(3).setCellValue("Email");
            headerRow.createCell(4).setCellValue("Mobile");
            headerRow.createCell(5).setCellValue("Bus ID");
            headerRow.createCell(6).setCellValue("Route ID");

            // Populate data rows with passenger information
            int rowNum = 1;
            for (Passenger p : passengers) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(p.getId());
                row.createCell(1).setCellValue(p.getFirstName());
                row.createCell(2).setCellValue(p.getLastName());
                row.createCell(3).setCellValue(p.getEmail());
                row.createCell(4).setCellValue(p.getMobile());
                row.createCell(5).setCellValue(p.getBusId());
                row.createCell(6).setCellValue(p.getRouteId());
            }

            // Write workbook to a byte array
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            outputStream.close();
            return outputStream.toByteArray();
        }
    }
}
