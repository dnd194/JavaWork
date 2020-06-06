<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.sql.*"%>
    
  
<!-- 	String SQL_INSERT_MENU = "insert into demo_menu_table values (uid_seq.nextval, ?, ?)"; -->
	<% int cnt = (Integer)request.getAttribute("result"); 
	int mem_uid = (Integer)session.getAttribute("mem_uid");%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .modal-notify .modal-header {
            border-radius: 3px 3px 0 0;
        }

        .modal-notify .modal-content {
            border-radius: 3px;
        }

        table tr td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        td {
            width: 100px;
        }
    </style>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.0/css/mdb.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js">
    </script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.0/js/mdb.min.js">
    </script>
</head>

<body>
    <div id="orangeModalSubscription" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-notify modal-warning" role="document">
            <!--Content-->
            <div class="modal-content">
                <!--Header-->
                <div class="modal-header text-center" style="background: rgba(17, 101, 175, 0.788);">
                    <h4 class="modal-title white-text w-100 font-weight-bold py-2">Add menu</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" class="white-text">&times;</span>
                    </button>
                </div>

                <!--Body-->
                <form method="post" action="addmenutest.do">
                <div class="modal-body">
                    <div class="md-form mb-5">
                        <i class="fas fa-bars prefix grey-text"></i>
                        <input type="text" class="form-control validate" name="menu_name">
                        <label data-error="wrong" data-success="right">메뉴를 입력하세요</label>
                    </div>

                    <div class="md-form">
                        <i class="fas fa-won-sign prefix grey-text"></i>
                        <input type="number"  class="form-control validate" name="menu_price">
                        <label data-error="wrong" data-success="right">가격을 입력하세요</label>
                    </div>
                </div>

                <!--Footer-->
                <div class="modal-footer justify-content-center">
                    <input type="submit" class="btn btn-outline-primary waves-effect" value='추가하기'></input>
                </div>
                </form>
            </div>
            <!--/.Content-->
        </div>
    </div>
    <br><br><br><br><br><br>
    <div>
        <table>
            <tr>
                <td>#</td>
                <td>메뉴이름</td>
                <td>가격</td>
            </tr>
            <tbody id="addable">

            </tbody>
        </table>
    </div>
    <div class="text-center">
  <a class="btn btn-default btn-rounded" data-toggle="modal" data-target="#orangeModalSubscription">Launch
    modal Subscription</a>
</div>
    <script>
    
        var i = 1;
        // var $button = $('a[type:button]');
        $("input[type='submit']").click(function () {
            var html = '';
            var menu = $('input[type="text"]').val();
            var price = $('input[type="number"]').val();
            html += '<tr>';
            html += '<td>'+i+'</td>';
            html += '<td>' + menu + '</td>';
            html += '<td>' + parseInt(price) + '</td>';
            html += '</tr>';
            $("#addable").append(html);
            
            i++;
//         $('input[type="text"]').val("");
//         $('input[type="number"]').val("");
        })
    </script>

</body>

</html>