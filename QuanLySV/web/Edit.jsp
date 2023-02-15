<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Edit
    Created on : Feb 15, 2023, 2:47:00 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chỉnh sửa sinh viên</title>
        <style>
            form {
                display: inline-block;
                margin: 20px;
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 5px;
                background-color: #f5f5f5;
            }
            label {
                display: inline-block;
                margin: 5px 0;
                font-weight: bold;
            }
            input[type=text], select {
                display: block;
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
            }
            input[type=submit]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <h1>Chỉnh sửa sinh viên</h1>
        <form action="EditController" method="post">
            <label for="hoTen">Họ tên:</label>
            <input type="text" id="idSt" name="idSt" hidden value="${student.getMaSV()}">
            <input type="text" id="hoTen" name="hoTen" value="${student.getHoTen()}">

                   <label for="ngaySinh">Ngày sinh:</label>
            <input type="text" id="ngaySinh" name="ngaySinh" value="${student.getNgaySinh()}">

            <label for="gioiTinh">Giới tính:</label>
            <select id="gioiTinh" name="gioiTinh">
                <option 
                    <c:if test="${iteam.isGioiTinh()}">
                        selected
                    </c:if> value="Nam">Nam</option>
                <option 
                     <c:if test="${!iteam.isGioiTinh()}">
                        selected
                    </c:if>
                    value="Nữ">Nữ</option>
            </select>

            <label for="diemTB">Điểm trung bình:</label>
            <input type="text" id="diemTB" name="diemTB" value="${student.getDiemTB()}">

            <input type="submit" value="Lưu">
        </form>
    </body>
</html>
