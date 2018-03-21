<%-- 
    Document   : activate_accounts
    Created on : 03 7, 18, 7:00:18 PM
    Author     : BavarianHotdog
--%>

<%@page import="dao.Tier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Employee"%>
<%ArrayList<Employee> employees = (ArrayList<Employee>)request.getAttribute("employees");%>
<%ArrayList<Tier> tiers = (ArrayList<Tier>)request.getAttribute("tiers");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <jsp:include page="WEB-INF/header.jsp" />       
            <title>DAR-AMIS | Activate Accounts</title>
      <script>
            function activateUser(empID, position){
                if(confirm("Activate this user?")){
                    var posID = position.split("- ")[0];
                    var url = "<%=root%>/ActivateUser?id=" + empID + "&position=" + posID;
                    
                    //make a POST request to server via jQuery.
                    //first parameter is the url to access
                    //second parameter is the response handler
                    $.post(url, function(data){
                        alert(data);
                        location.reload();
                    });
                }
            }
      </script>
      <script>
            function deleteUser(empID){
                if(confirm("Delete this user?")){
                    var url = "<%=root%>/DeleteUser?id=" + empID;
                    
                    //make a POST request to server via jQuery.
                    //first parameter is the url to access
                    //second parameter is the response handler
                    $.post(url, function(data){
                        alert(data);
                        location.reload();
                    });
                }
            }
      </script>

  </head>

  <body>
     <section id="container">
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <!--header end-->
      
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
        <jsp:include page="WEB-INF/sidebarcheck.jsp" />
      <!--sidebar end-->
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <section class="content-header">
                    <h1>
                        Welcome!
                        <small>Admin</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                  <!--main content start-->
                <section class="content">

                    <div class="box box-primary">

                        <div class="box-header">
                            <i class="glyphicon glyphicon-file"></i><h3 class="box-title">Activate Accounts</h3>
                        </div>

                        <div class="box-body border-radius-none">
                            <table class="table table-striped" id="example1">
                                    <thead>
                                        <tr>
                                            <th>Employee ID</th>
                                            <th>Last Name</th>
                                            <th>First Name</th>
                                            <th>Middle Initial</th>
                                            <th>Division</th>
                                            <th>Position</th>
                                            <th>Activate</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for(Employee e: employees){%>
                                        <tr>
                                            <td><%=e.getIdEmployee()%></td>
                                            <td><%=e.getLastName()%></td>
                                            <td><%=e.getFirstName()%></td>
                                            <td><%=e.getMiddleInitial()%></td>
                                            <td><%=e.getIdDivision().getDivision()%></td>
                                            <td>
                                                <select class="form-control" name="userPosition<%=e.getIdEmployee()%>">
                                                    <%for(Tier t: tiers){%>
                                                        <option><%=t.getIdTier()%> - <%=t.getPosition()%></option>
                                                    <%}%>
                                                </select>
                                            </td>
                                            <td><button onclick="activateUser(<%=e.getIdEmployee()%>, $('[name=\'userPosition<%=e.getIdEmployee()%>\']').val())"><span class="glyphicon glyphicon-ok"></span></button></td>
                                            <td><button onclick="deleteUser(<%=e.getIdEmployee()%>)"><span class="glyphicon glyphicon-remove"></span></button></td>
                                            
                                            <script>
                                            </script>
                                        </tr>
                                        <%}%>
                                        
                                     </tbody>
                                    </table>
                                </div>
                            </div>
                        </section><! --/wrapper -->
                    </section><!-- /MAIN CONTENT -->
                </section>
          </section>
      <!--main content end-->
      <!--footer start-->
      <jsp:include page="WEB-INF/copyright.jsp" /> 
      <!--footer end-->
  </section>
      <jsp:include page="WEB-INF/footer.jsp" />
  </body>
</html>
