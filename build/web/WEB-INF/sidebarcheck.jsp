<%-- 
    Document   : sidebarcheck
    Created on : 02 13, 18, 5:13:40 PM
    Author     : BavarianHotdog
--%>


<%
    int userType = Integer.parseInt(session.getAttribute("userType").toString());
    if (userType == 1) {
%>
<jsp:include page="sidebar_dir.jsp" />
<%} else if (userType == 2) {%>
<jsp:include page="sidebar_gsdc.jsp" />
<%} else if (userType == 3) {%>
<jsp:include page="sidebar_gsds.jsp" />
<%} else if (userType == 4) {%>
<jsp:include page="sidebar_pc.jsp" />
<%} else if (userType == 5) {%>
<jsp:include page="sidebar_ap.jsp" />
<%} else if (userType == 6) {%>
<jsp:include page="sidebar_mgt.jsp" />
<%} else if (userType == 7) {%>
<jsp:include page="sidebar_user.jsp" />
<%} else if (userType == 8) {%>
<jsp:include page="sidebar_rec.jsp" />
<%} else if (userType == 9) {%>
<jsp:include page="sidebar_def.jsp" />
<%}%>