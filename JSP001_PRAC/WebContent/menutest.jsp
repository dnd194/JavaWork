<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>메뉴 테스트 입니다.</title>
<style>
        table,
        tr,
        td {
            border: 1px solid blue;
            border-collapse: collapse;
        }

        td {
            width: 100px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

</head>
<body>
<button id="adder" onclick="tableCreate();" name="menu1" value="아아">아아<br>4500원</button>
    <br><br><br><br>
    <table>
        <tr>
            <td>메뉴</td>
            <td>가격</td>

        </tr>
        <tbody id="addable">

        </tbody>
    </table>
    <%
    	int cnt = 0;
    %>
<script>
    function tableCreate() {

        var tc = new Array();
        var html = '';

        tc.push({
            name: '아아',
            price: '4500'
        });
        
        for (key in tc) {
            html += '<tr>';
            html += '<td>' + tc[key].name + '</td>';
            html += '<td>' + tc[key].price + '</td>';
            html += '</tr>';
        }

        // $("#addable").empty();
        $("#addable").append(html);

    }
</script>


</body>
</html>