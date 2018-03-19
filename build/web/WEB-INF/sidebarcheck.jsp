<%-- 
    Document   : sidebarcheck
    Created on : 02 13, 18, 5:13:40 PM
    Author     : BavarianHotdog
getAttribute ("userData").getIdTier().getIdTier()
--%>

<%@page import="dao.Employee"%>
<%@page import="dao.Tier"%>
<%
    int id_Tier = ( ((Employee)session.getAttribute("userData")).getIdTier().getIdTier());
    if (id_Tier == 1) {
%>
<jsp:include page="sidebar_dir.jsp" />
<%} else if (id_Tier == 2) {%>
<jsp:include page="sidebar_ap.jsp" />
<%} else if (id_Tier == 3) {%>
<jsp:include page="sidebar_gsdc.jsp" />
<%} else if (id_Tier == 4) {%>
<jsp:include page="sidebar_gsds.jsp" />
<%} else if (id_Tier == 5) {%>
<jsp:include page="sidebar_pc.jsp" />
<%} else if (id_Tier == 6) {%>
<jsp:include page="sidebar_mgt.jsp" />
<%} else if (id_Tier == 7) {%>
<jsp:include page="sidebar_user.jsp" />
<%} else if (id_Tier == 8) {%>
<jsp:include page="sidebar_rec.jsp" />
<%} else if (id_Tier == 9) {%>
<jsp:include page="sidebar_def.jsp" />
<%}%>