package main.java.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import main.java.model.AgeInfo;
import main.java.model.DiscountInfo;
import main.java.model.Member;
import main.java.model.Membership;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
    private static final String filePath = "./src/main/resources/static/IntegratedDiscountSystem.xlsx";

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
                int age = Integer.parseInt(dataFormatter.formatCellValue(row.getCell(1)));
                LocalDate createPayDate = LocalDate.parse(dataFormatter.formatCellValue(row.getCell(2)),
                        DateTimeFormatter.ofPattern("MM/d/yy"));
                int cumulativeAmount = Integer.parseInt(dataFormatter.formatCellValue(row.getCell(3)));

                /**
                 * DB로 바꾼다면...
                 * TODO cumulativeAmount, create_paid_date 묶어서 결제 관련 테이블(객체)로 만들기
                 */

                int feeByAge = AgeInfo.getFeeByAge(age);

                String membership = Membership.getMembership(cumulativeAmount);

                Map<DiscountInfo, String> discounts = new HashMap<>();

                for (int i = 4; i < row.getLastCellNum(); i++) {
                    String cellValue = dataFormatter.formatCellValue(row.getCell(i));
                    if ("o".equals(cellValue) || "x".equals(cellValue)) {
                        String discountInfoName = dataFormatter.formatCellValue(sheet.getRow(0).getCell(i));
                        DiscountInfo discountInfo = DiscountInfo.getInstance(discountInfoName);
                        discounts.put(discountInfo, cellValue);
                    }
                }

                // SignUpRequestDto를 생성할 때 멤버십 정보도 전달합니다.
                members.add(Member.createMember(name, feeByAge, discounts, membership, createPayDate));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return members;
    }
}
