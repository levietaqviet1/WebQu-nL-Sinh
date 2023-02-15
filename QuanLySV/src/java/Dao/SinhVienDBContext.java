/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.DBContext;
import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SinhVienDBContext {

    private Connection connection;

    public SinhVienDBContext() {
        try {
            DBContext db = new DBContext();
            connection = db.getConnection();
            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SinhVienDBContext bContext = new SinhVienDBContext();
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SinhVien");
            while (resultSet.next()) {
                int id = resultSet.getInt("MaSV");
                String name = resultSet.getString("HoTen");
                Date dateOfBirth = resultSet.getDate("NgaySinh");
                boolean gender = resultSet.getBoolean("GioiTinh");
                float averageScore = resultSet.getFloat("DiemTB");

                Student student = new Student(id, name, dateOfBirth, gender, averageScore);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentById(int id) {
        try ( PreparedStatement statement = connection.prepareStatement("SELECT * FROM SinhVien WHERE MaSV = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("HoTen");
                Date dateOfBirth = resultSet.getDate("NgaySinh");
                boolean gender = resultSet.getBoolean("GioiTinh");
                float averageScore = resultSet.getFloat("DiemTB");

                return new Student(id, name, dateOfBirth, gender, averageScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addStudent(String name, Date dateOfBirth, boolean gender, float averageScore) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO SinhVien (HoTen, NgaySinh, GioiTinh, DiemTB) VALUES (?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setDate(2, (java.sql.Date) dateOfBirth);
            statement.setBoolean(3, gender);
            statement.setFloat(4, averageScore);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE [dbo].SinhVien\n"
                + "   SET [HoTen] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[DiemTB] = ?\n"
                + " WHERE [MaSV] = ?";
        try ( PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setString(1, student.getHoTen());
            java.sql.Date DateSql = new java.sql.Date(student.getNgaySinh().getTime());
            pre.setDate(2, DateSql);
            pre.setBoolean(3, student.isGioiTinh());
            pre.setFloat(4, student.getDiemTB());
            pre.setInt(5, student.getMaSV());
            pre.executeUpdate();

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    public void deleteStudent(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM SinhVien WHERE MaSV = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
