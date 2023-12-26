package main.java.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import main.java.model.DiscountInfo;
import main.java.model.Member;
import main.java.model.MemberShip;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
    private static final String filePath = "/Users/jaehyun/Documents/IdeaProjects/KaKaoCloud/IntegratedDiscountSystem/src/main/resources/static/IntegratedDiscountSystem.xlsx";

    public static List<Member> readExcel() {
        File file = new File(filePath);
        List<Member> members = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next(); // 속성 값 스킵
            while (rowIterator.hasNext()) {
                Map<DiscountInfo, String> userDiscounts = new HashMap<>();
                Row row = rowIterator.next();
                String name = dataFormatter.formatCellValue(row.getCell(0));
                String loginId = dataFormatter.formatCellValue(row.getCell(1));
                String password = dataFormatter.formatCellValue(row.getCell(2));
                int age = Integer.parseInt(dataFormatter.formatCellValue(row.getCell(3)));
                String membership = dataFormatter.formatCellValue(row.getCell(4));

                Map<DiscountInfo, String> discounts = new HashMap<>();

                for (int i = 5; i < row.getLastCellNum(); i++) {
                    String cellValue = dataFormatter.formatCellValue(row.getCell(i));
                    if ("o".equals(cellValue) || "x".equals(cellValue)) {
                        String discountInfoName = dataFormatter.formatCellValue(sheet.getRow(0).getCell(i));
                        DiscountInfo discountInfo = DiscountInfo.getInstance(discountInfoName);
                        discounts.put(discountInfo, cellValue);
                    }
                }

                MemberShip memberShip = MemberShip.getInstance(membership);

                // SignUpRequestDto를 생성할 때 멤버십 정보도 전달합니다.
                members.add(Member.createMember(name, loginId, password, age, discounts, memberShip));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return members;
    }
}
