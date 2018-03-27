<%-- 
    Document   : approve_forms
    Created on : 02 13, 18, 6:04:28 PM
    Author     : BavarianHotdog

    TRANSFORM INTO VIEW ONLY

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <jsp:include page="WEB-INF/header.jsp" />       
            <title>DAR-AMIS | Approve Forms</title>
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
                        Department of Agrarian Reform 
                        <small>- Approve Forms</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                   <div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			 Forms
                     <span class="caret"></span>
                     </button>			    
                          <ul class="dropdown-menu">
                          <li><a href="po.jsp">Purchase Order</a></li>
                          <li><a href="par.jsp">Property Acknowledgement Receipt</a></li>
                          <li><a href="rfi.jsp">Request For Inspection</a></li>
                          <li><a href="aif.jsp">Assignment of Inspector Form</a></li>
                          <li><a href="ics.jsp">Inventory Custodian Slip</a></li>
                          <li><a href="ris.jsp">Requisition and Issuance Slip</a></li>
                          <li><a href="sc.jsp">Stock Card</a></li>
						    </ul>
						  </div>
                  
                  <div class="content-panel">
                          <table class="table table-striped table-advance table-hover">
	                  	  	  <h4><i class="fa fa-angle-right"></i> Approval of Forms</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th>Form ID</th>
                                  <th>Form Type</th>
                                <th></i>Created By</th>
                                <th></i>Created Date</th>
                                <th>View Form</th>
                                <th>Status</th>
                                <th>Action</th>

                                  
                                  <!--<th><i class="fa fa-envelope-o"></i> Type</th>
                                  <th class="hidden-phone"><i class="fa fa-pencil"></i> Description</th>
                                  <th><i class="fa fa-bookmark"></i> Person Responsible</th>
                                  <th><i class=" fa fa-edit"></i> Status</th>
                                  <th></th>-->
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td><a href="basic_table.html#">0001</a></td>
                                  <td class="hidden-phone">Purchase Request</td>
                                  <td>Maria Rowena Bilog </td>
                                  <td>November 10, 2017</td>
                                  <td><button>WFP</button><button>APP</button></td>
                                  <td><span class="label label-info label-mini">Pending</span></td>
                                  <td>
                                      <button class="btn btn-success btn-s"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-danger btn-s"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td><a href="basic_table.html#">2190</a></td>
                                  <td class="hidden-phone">Request Inquisition Slip</td>
                                  <td>Jonie Abante </td>
                                  <td>January 29, 2017</td>
                                  <td><button><a href="wfp.jsp">WFP</a></button><button><a href="app.jsp">APP</a></button></td>
                                  <td><span class="label label-info label-mini">Due</span></td>
                                  <td>
                                      <button class="btn btn-success btn-s"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-s"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-s"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td><a href="basic_table.html#">3124</a></td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>12000.00$ </td>
                                  <td>November 10, 2017</td>
                                  <td><button><a href="wfp.jsp">WFP</a></button><button><a href="app.jsp">APP</a></button></td>
                                  <td><span class="label label-info label-mini">Due</span></td>
                                  <td>
                                      <button class="btn btn-success btn-s"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-s"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-s"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td><a href="basic_table.html#">Company Ltd</a></td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>12000.00$ </td>
                                  <td>November 10, 2017</td>
                                  <td><button>WFP</button><button>APP</button></td>
                                  <td><span class="label label-info label-mini">Due</span></td>
                                  <td>
                                      <button class="btn btn-success btn-s"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-s"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-s"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td><a href="basic_table.html#">Company Ltd</a></td>
                                  <td class="hidden-phone">Lorem Ipsum dolor</td>
                                  <td>12000.00$ </td>
                                  <td>November 10, 2017</td>
                                  <td><button><a href="wfp.jsp"></a>WFP</button><button><a href="app.jsp">APP</button></td>
                                  <td><span class="label label-info label-mini">Due</span></td>
                                  <td>
                                      <button class="btn btn-success btn-s"><i class="fa fa-check"></i></button>
                                      <button class="btn btn-primary btn-s"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-s"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                      </div><!-- /content-panel -->
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
