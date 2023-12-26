package main.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import main.java.dto.SignUpRequestDto;
import main.java.model.DiscountInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
    private static final String filePath = "/Users/jaehyun/Documents/IdeaProjects/KaKaoCloud/IntegratedDiscountSystem/src/main/resources/static/IntegratedDiscountSystem.xlsx";

    public static void writeExcel(SignUpRequestDto signUpRequestDto) {
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.createRow(sheet.getLastRowNum() + 1);

            // Create cells and set their values with signUpRequestDto
            row.createCell(0).setCellValue(signUpRequestDto.getName());
            row.createCell(1).setCellValue(signUpRequestDto.getLoginId());
            row.createCell(2).setCellValue(signUpRequestDto.getPassword());
            row.createCell(3).setCellValue(signUpRequestDto.getAge());
            row.createCell(4).setCellValue(signUpRequestDto.getMembership().toString());

            Map<DiscountInfo, String> discounts = signUpRequestDto.getDiscounts();
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                String headerName = cell.getStringCellValue();
                // 속성값 찾기 (e.g. 국민카드, kt)
                for (DiscountInfo discountInfo : DiscountInfo.values()) {
                    if (headerName.contains(discountInfo.getDiscountInfo())) {
                        int cellIndex = cell.getColumnIndex();
                        row.createCell(cellIndex).setCellValue(discounts.get(discountInfo));
                        break;
                    }
                }
            }

            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);

            fis.close();
            fos.close();
            workbook.close();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
