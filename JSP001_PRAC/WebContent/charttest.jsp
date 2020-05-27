<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*"
    import = "java.text.*"%>
    <%!
	// JDBC 관련 기본 객체 객체변수 선언
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // SELECT 결과, executeQuery() 
	int cnt = 0;   // DML 결과, executeUpdate()
	
	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";  // JDBC 드라이버 클래스
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";  // DB 접속 URL
	final String USERID = "scott0316";  // DB 접속 계정 정보
	final String USERPW = "tiger0316";
%>
<%
	//쿼리문 준비
	// 게시글 읽어오기
	int uid = 20;   //일부러 고정시켜준 값
	final String SQL_WRITE_SELECT_BY_UID = "SELECT * FROM test_write WHERE wr_uid = ?";
%>
<%
// 	변수를 담을 공간 준비
	String name = "";
	String subject = "";
	String content ="";
	String regdate = "";
	int viewcnt = 0;
%>
<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" +"<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW );
		out.println("conn 성공 "+ "<br><br>");
		
		//트랜잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		
		//많아야 한개의 record 만 select 된다
		// 한개만 있기때문에 while 돌리지 않는다
		
		if(rs.next()){
			subject = rs.getString("wr_subject");
			content = rs.getString("wr_content");  //이친구는 null 을 허용함
			if(content == null) content ="";  //null 일때의 값을 처리
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t =rs.getTime("wr_regdate");
			//위에 Date, Time 은  java.sql 걸로 돌아감
			regdate="";
			if(d != null){
				regdate = new SimpleDateFormat("yyyyMMdd").format(d)+" "+
							new SimpleDateFormat("hhmmss").format(t);
			}
		}else{
			//wr_uid 값의 레코드가 없는 뜻
%>
			<script>
				alert("해당정보가 삭제되었거나 없다리");
				history.back();
			</script>
<%
			return;   //더이상 jsp 가 프로세싱하지 않고 종료
		}//end if
		
		
		
	}catch(Exception e){
		e.printStackTrace();
		//예외처리
	}finally{
		//리소트 해제
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<%-- 
  	int num = 10; 
--%>
<canvas id="myChart" width="400px" height="400px"></canvas>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js" integrity="sha256-R4pqcOYV8lt7snxMQO/HSbVCFRPMdrhAFMH+vr9giYI=" crossorigin="anonymous"></script>
	<script>
		var ctx = document.getElementById('myChart').getContext('2d');
		var myChart = new Chart(ctx,
				{
					type : 'line',			//line 형태   bar 한번 바꾸고 fill 값 true 로 주면 bar chart 가 됨
										//현재 type이 line이라 bordercolor 는 'rgba(255, 99, 132, 1)' 이거만 먹히는중
					data : {
						labels : [ 'Red', 'Blue', 'Yellow', 'Green', 'Purple',   //아래 데이터들 라벨
								'Orange' ],
						datasets : [ {
							fill : false,		// 채워줄지 말지 정해주는 attr  (Default : true)
							label : '# of Votes',    		//위에 라벨
							data : [ 12, 19, 3, 5, 2, <%= viewcnt%> ],    //데이터 수치   현재 uid는 20으로 고정시켜준 값
							backgroundColor : [ 'rgba(255, 99, 132, 0.2)',   //동그라미 친구들 색갈
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [ 'rgba(255, 99, 132, 1)',
									'rgba(54, 162, 235, 1)',             
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
							borderWidth : 1
						} ]
					},
					options : {
						responsive: false,  //jquery 가 자동으로 max 해주는 걸 막아줌
						scales : {
							yAxes : [ {
								ticks : {
									beginAtZero : true
								}
							} ]
						}
					}
				});
		
		
	</script>
	<canvas id="myChart2" width="400px" height="400px"></canvas>
	<script>
	var ctx = document.getElementById('myChart2').getContext('2d');
	var myDoughnutChart = new Chart(ctx, {
		    type: 'doughnut',
		    data: data = {
		    	    datasets: [{    
		    	        data: [10, 20, 30],			//데이터 셋의 개수만큼 배경색 배열안에 추가해주면됨 아래 labels도 추가해줘야함
		    	        backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 206, 86, 0.2)',
							]
		    	    }],

		    	    // These labels appear in the legend and in the tooltips when hovering different arcs
		    	    labels: [
		    	        'Red',
		    	        'Yellow',
		    	        'Blue'
		    	    ]
		    	},
		    	options : {
					responsive: false,  //jquery 가 자동으로 max 해주는 걸 막아줌
		    	}
		});
	</script>
</body>
</html>