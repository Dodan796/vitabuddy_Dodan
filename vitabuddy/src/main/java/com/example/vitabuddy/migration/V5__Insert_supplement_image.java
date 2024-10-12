package com.example.vitabuddy.migration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V5__Insert_supplement_image extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        // C 드라이브 이미지 폴더 경로
        String imagePath = "C:/supplement_images/";
        
        // 시작 SupID와 이미지 파일의 개수 설정 (예: 1000번부터 1199번까지)
        int startSupID = 1000;
        int endSupID = 1200;  // 총 200개의 이미지를 처리

        // 데이터베이스 연결 & SQL 쿼리
        try (Connection connection = context.getConnection()) {
            String sql = "UPDATE supplement SET SupImg = ? WHERE SupID = ?";
            
            // SupID와 이미지 파일명을 자동으로 처리
            for (int SupID = startSupID; SupID <= endSupID; SupID++) {
                // SupID에 해당하는 이미지 파일명 생성
                String fileName = SupID + ".png";
                
                File imgFile = new File(imagePath + fileName);
                
                // 파일 경로 및 파일 읽기 확인
                if (imgFile.exists() && imgFile.canRead()) {
                    System.out.println("이미지 파일 경로: " + imgFile.getAbsolutePath());
                    try (FileInputStream fis = new FileInputStream(imgFile);
                         PreparedStatement pstmt = connection.prepareStatement(sql)) {
                         
                        // 이미지 파일을 바이트 배열로 변환하여 BLOB에 저장
                        pstmt.setBinaryStream(1, fis, (int) imgFile.length());
                        pstmt.setInt(2, SupID);
                        
                        // 쿼리 실행
                        int rowsAffected = pstmt.executeUpdate();
                        System.out.println("업데이트된 행 수: " + rowsAffected);

                        // 트랜잭션 커밋 (필요한 경우)
                        connection.commit();
                    } catch (IOException | SQLException e) {
                        e.printStackTrace();
                        throw new Exception("이미지 삽입 중 오류 발생: " + fileName, e);
                    }
                } else {
                    System.out.println("파일을 읽을 수 없거나 존재하지 않음: " + fileName);
                }
            }
        }
    }
}
