<%-- 
    Document   : profile
    Created on : 02 20, 18, 5:27:21 PM
    Author     : BavarianHotdog
--%>
<%@page import="java.time.ZoneOffset"%>
<%@page import="dao.Division"%>
<%@page import="dao.Employee"%>
<%@page import="dao.Tier"%>
<%@page import="java.time.LocalDateTime"%>
<%Employee emp = (Employee) session.getAttribute("userData");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="WEB-INF/header.jsp" />       
        <title>DAR-AMIS | Profile</title>
    </head>

    <body>

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <jsp:include page="WEB-INF/sidebarcheck.jsp" />
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper site-min-height">
                    <div class="row mt">
                        <div class="col-lg-12">
                            <div class="row content-panel">
                                <div class="col-md-4 profile-text mt mb centered">
                                </div><! --/col-md-4 -->

                                <div class="col-md-4 profile-text">
                                    <h2 class="centered"><%= emp.getFirstName()%> <%= emp.getLastName()%></h2>
                                    <h4 class="centered"><%= emp.getIdDivision().getDivision()%> - <%= emp.getIdTier().getPosition()%></h4>
                                    <%LocalDateTime ldt = LocalDateTime.ofInstant(emp.getDob().toInstant(), ZoneOffset.systemDefault());%>
                                    <h4 class="centered"><%=ldt.getMonth()%> <%=ldt.getDayOfMonth()%>, <%=ldt.getYear()%> - <%= emp.getEmail()%> - <%= emp.getMobileNum()%></h4>
                                    <br>
                                </div><! --/col-md-4 -->

                                <div class="col-md-4 centered">
                                    <div class="profile-pic">
                                        <p><img src="img/ui-sam.jpg" class="img-circle"></p>
                                        <!--<p>
                                                <button class="btn btn-theme"><i class="fa fa-check"></i> Edit</button>
                                        </p> -->
                                    </div>
                                </div><! --/col-md-4 -->
                            </div><!-- /row -->	   
                        </div><! --/col-lg-12 -->		
                    </div><! --/panel-heading -->

                    </div><!-- /col-lg-12 -->
                    </div><! --/row -->
                    </div><! --/container -->

                </section><! --/wrapper -->
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <jsp:include page="WEB-INF/copyright.jsp" /> 
            <!--footer end-->
        </section>
        <jsp:include page="WEB-INF/footer.jsp" />
    </body>
</html>