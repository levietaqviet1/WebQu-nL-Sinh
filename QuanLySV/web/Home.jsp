<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Home
    Created on : Feb 15, 2023, 2:37:41 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Danh sách sinh viên</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }
            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            tr:hover {
                background-color: #f5f5f5;
            }
        </style>
    </head>
    <body>
        <h1>Danh sách sinh viên</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Họ tên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Điểm trung bình</th>
                <th></th>
                <th></th>
       <c:forEach var="iteam" items="${listStudent}">
                </tr>
                <!-- Dòng này sẽ được tạo bằng cách lặp qua danh sách sinh viên từ code Java hoặc JavaScript -->
                <td>${iteam.getMaSV()}</td>
                <td>${iteam.getHoTen()}</td>
                <td>${iteam.getNgaySinh()}</td>
                <td>${iteam.isGioiTinh()}</td>
                <td>${iteam.getDiemTB()}</td>
                <td><a href="EditController?id=${iteam.getMaSV()}">Chỉnh sửa</a></td>
                <td><a href="DeleteController?id=${iteam.getMaSV()}">Xóa</a></td>
            </tr>
        </c:forEach><tr>

    </table>
</body>
</html>
