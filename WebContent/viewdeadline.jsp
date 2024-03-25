<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smart Maintaince Portal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!--js-->
<script src="js/jquery-2.1.1.min.js"></script> 
<!--icons-css-->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600' rel='stylesheet' type='text/css'>
<!--static chart-->
<script src="js/Chart.min.js"></script>
<!--//charts-->
<!-- geo chart -->
    <script src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
    <script>window.modernizr || document.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')</script>
    <!--<script src="lib/html5shiv/html5shiv.js"></script>-->
     <!-- Chartinator  -->
    <script src="js/chartinator.js" ></script>
    <!--geo chart-->

<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<body>
<div class="page-container">	
   <div class="left-content">
	   <div class="mother-grid-inner">
            <!--header start here-->
				<div class="header-main">
					<div class="header-left">
							<div class="logo-name">
									 <a href="index.html"> <h1>Smart Maintenance Portal </h1> 
									<!--<img id="logo" src="" alt="Logo"/>--> 
								  </a> 								
							</div>
							<!--search-box-->
							<!--//end-search-box-->
							<div class="clearfix"> </div>
						 </div>
						 
				     <div class="clearfix"> </div>	
				</div>
<!--heder end here-->
<!--inner block start here-->



<%@ page import="java.sql.*" %>
<%@ page import="com.project.DatabaseConnect" %>
<%Connection con=DatabaseConnect.connect();
PreparedStatement pstmt=con.prepareStatement("Select * from road ORDER BY Ddate ASC");
ResultSet rs=pstmt.executeQuery();
%>
                           <div class="work-progres">
                            <div class="chit-chat-heading">
                                  <h3>View Deadline Task</h3>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                  <thead>
 
                                    <tr>
                                      <th>Title</th>
                                      <th>Description</th>
                                      <th>Department</th>                                                                  
                                      <th>Date</th>
                                  </tr>
                              </thead>
                              <%while(rs.next()) { %>
                              <tbody>
                                <tr>
                                  <td><%=rs.getString(1)%> </td>
                                  <td><%=rs.getString(2)%></td>
                                  <td><%=rs.getString(3)%></td>
                                  <td><%=rs.getString(4)%></td>                                                            
                              </tr>
                              <%} %>
                          </tbody>
                      </table>
                  </div>

			
		   <div class="clearfix"> </div>
		</div>

<!--market updates end here-->
<!--mainpage chit-chating-->
	<div class="clearfix"> </div>
</div>
<!--climate end here-->
</div>
<!--inner block end here-->
<!--copy rights start here-->
<br>
<br>
	
<!--COPY rights end here-->
</div>
</div>
<!--slider menu-->
    <div class="sidebar-menu">
		  	<div class="logo"> <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
			      <!--<img id="logo" src="" alt="Logo"/>--> 
			  </a> </div>		  
		    <div class="menu">
		      <ul id="menu" >
		        <li id="menu-home" ><a href="index.html"><i class="fa fa-th-list"></i><span>Dashboard</span></a></li>
		         <li><a href="owndepcomplaint.jsp"><i class="fa fa-cogs"></i><span>Own department complaints</span></a>
		          
		        </li>
		        <li id="menu-comunicacao" ><a href="pending.jsp"><i class="fa fa-book nav_icon"></i><span>Pending task /Complaint</span></a>
		
		        </li>
		          <li><a href="completed.jsp"><i class="fa fa-file-text"></i><span>Completed Task</span></a></li>
		      </ul>
		    </div>
	 </div>
	<div class="clearfix"> </div>
</div>
<!--slide bar menu end here-->
<script>
var toggle = true;
            
$(".sidebar-icon").click(function() {                
  if (toggle)
  {
    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
    $("#menu span").css({"position":"absolute"});
  }
  else
  {
    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
    setTimeout(function() {
      $("#menu span").css({"position":"relative"});
    }, 400);
  }               
                toggle = !toggle;
            });
</script>
<!--scrolling js-->
		<script src="js/jquery.nicescroll.js"></script>
		<script src="js/scripts.js"></script>
		<!--//scrolling js-->
<script src="js/bootstrap.js"> </script>
<!-- mother grid end here-->
</body>
</html>