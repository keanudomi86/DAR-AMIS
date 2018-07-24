<%-- 
    Document   : pr
    Created on : 02 8, 18, 6:51:34 PM
    Author     : BavarianHotdog
--%>
<%@page import="dao.Pr"%>
<%@page import="dao.Wfp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Office"%>
<%Wfp wfp = (Wfp)request.getAttribute("wfp");%>
<%ArrayList<Office> offices = (ArrayList<Office>)request.getAttribute("offices");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | PR</title>
    
  </head>
  <body>
      <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }
      .ibtnDel{
          cursor: pointer;
      }

    </style>
    
    <script>
        function createPR(){
            if(confirm("Submit this form?")){
                url = "<%=root%>/CreatePR";
                $.post(url, $("#prForm").serialize(), function(data){
                    alert(data);
                });
            }
        }
    </script>
      

  <section id="container" >
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
                        Purchase Request - Form
                    </h1>
                    
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    
                        <%if(session.getAttribute("formMode").equals("create")){%>
                        <h3 class="text-right text-bold"><div name="idNum">Form ID: <%=request.getAttribute("newFormId") %></div></h3>
                        <%}else if(session.getAttribute("formMode").equals("view") || session.getAttribute("formMode").equals("approve")){%>
                        <h3 class="text-right text-bold"><div name="idNum">Form ID: <%=((Pr)request.getAttribute("prData")).getIdPr() %></div></h3>
                        <%}%>
               <!-- ...................APPROVE FORM................................................................. -->
                <!-- P1 -->
                
                
               <div class="panel panel-default">
                <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Purchase Request</STRONG></p></div> 
                    <div class="panel-body"> 
                    <%if(session.getAttribute("formMode").equals("approve")){%>
                    <a href="approve_forms.jsp" class="previous" align="left">&laquo; Previous</a>
                <form>
                    <!-- First Row -->
                    <div class = "row">

                        <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

                              <!-- Entity Name Dropdown -->
                              <div class="col-sm-2">
                               <div class="btn-group">
                                <select class="form-control" name="entity">
                                    <option>Entity</option>
                                    <option>DAR</option>
                                </select>
                              </div>
                              </div> 

                              <script>
                                $(function(){
                                                    $("#1").click(function () {
                                                    $("#opt").text($(this).text());
                                                    });
                                                    $("#2").click(function () {
                                                    $("#opt").text($(this).text());
                                                    });
                                                    $("#3").click(function () {
                                                    $("#opt").text($(this).text());
                                                    });
                                                    $("#4").click(function () {
                                                    $("#opt").text($(this).text());
                                                    });
                                                });
                              </script>                              

                      <!-- Blank text for spacing --> 
                      <div class="col-sm-2"><label align= "text-center"></label></div>              

                      <div class="col-sm-2"><label align= "text-center">PR No.</label></div>
                      <div class="col-sm-2" class="form-group"> <input type="text"  align= "text-center" placeholder="PR No."></div>


                    </div> 

                    <!-- Blank Row -->
                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                    <!-- Second Row -->
                    <div class = "row">

                      <div class="col-sm-2"><label align= "text-center">Office/Section</label></div>
                      <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Office/Section"></div>
                      <div class="col-sm-2"><label align= "text-center"></label></div>

                      <!-- Date -->
                      <div class="col-sm-2"><label align= "text-center">Date</label></div>
                      <div class="col-sm-2">
                        <div class="form-group "> -->

                          <div class="input-group">
                            <!-- This comment out adds an icon at the left side of the date text-->
                            <!--<div class="input-group-addon">
                              <i class="fa fa-calendar"></i>
                            </div> -->
                           <input class="form-control" id="date" name="date" placeholder="MM/DD/YYYY" type="text">
                          </div>
                         </div>
                         
                        </div>
                    </div>

                        <!-- Date script for JS -->
                        <script>
                          $(document).ready(function(){
                              var date_input=$('input[name="date"]'); //our date input has the name "date"
                              var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                              date_input.datepicker({
                                  format: 'mm/dd/yyyy',
                                  container: container,
                                  todayHighlight: true,
                                  autoclose: true
                              })
                          })
                        </script>



                    <!-- Blank Row -->
                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                    <!-- Third Row -->
                    <div class = "row">

                      <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
                      <div class="col-sm-2"><input name="fund_cluster" type="text"  align= "text-center" placeholder="Fund Cluster"></div>
                      <div class="col-sm-2"><label align= "text-center"></label></div>

                      <div class="col-sm-2"><label align= "text-center">Responsibility Center Code</label></div>
                      <div class="col-sm-2"><input name="rcc" type="text"  align= "text-center" placeholder="Responsibility Center Code"></div>

                    </div> 
                    <!-- Blank Row -->
                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                  

                <!-- P2 --> 
                <div class = "panel-heading panel-heading-custom">
                    <div class= "row">
                      <div class="col-sm-2"><label align= "text-center">Stock Property No.</label></div>
                      <div class="col-sm-2"><label align= "text-center">Unit</label></div>
                      <div class="col-sm-2"><label align= "text-center">Item Description</label></div>
                      <div class="col-sm-2"><label align= "text-center">Quantity</label></div>
                      <div class="col-sm-2"><label align= "text-center">Unit Cost</label></div>
                      <div class="col-sm-2"><label align= "text-center">Total Cost</label></div>
                    </div>
                </div>

                <div class="panel-body">

                        <!-- Input for Repeating Section -->
                                <table id="myTable" class=" table order-list">

                                    <tbody>
                                        <tr>
                                            <td>
                                                <div><input type="text"  name="unit" align= "text-center" placeholder="Unit"></div>
                                            </td>
                                            <td>
                                                <div><input type="text"  name="description" align= "text-center" placeholder="Item Description"></div>
                                            </td>
                                            <td>
                                                <div><input type="text"  name="quantity" align= "text-center" placeholder="Quantity"></div>
                                            </td>
                                            <td>
                                                <div><input type="text"  name="cost" align= "text-center" placeholder="Unit Cost"></div>
                                            </td>
                                            <td><a class="deleteRow"></a>

                                            </td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td colspan="7" style="text-align: left;">
                                                <input type="button" class="btn btn-lg btn-block " id="addrow" value="Add Row" />
                                            </td>
                                        </tr>
                                        <tr>
                                        </tr>
                                    </tfoot>
                                </table>

                                                <!-- Repeating section script for JS -->
                                                <script>
                                                $(document).ready(function () {
                                                    var counter = 0;

                                                    $("#addrow").on("click", function () {
                                                        var newRow = $("<tr>");
                                                        var cols = "";

                                                        cols += '<td><input type="text" placeholder="Stock Property No" name="stockPropertyNo' + counter + '"/></td>';
                                                        cols += '<td><input type="text" placeholder="Unit" name="unit' 	+ counter + '"/></td>';
                                                        cols += '<td><input type="text" placeholder="Item Description"  name="description' + counter + '"/></td>';
                                                        cols += '<td><input type="text" placeholder="Quantity" 	name="quantity' + counter + '"/></td>';
                                                        cols += '<td><input type="text" placeholder="Unit Cost" name="cost' + counter + '"/></td>';
                                                        cols += '<td><input type="text" placeholder="Total Cost" name="totalCost' + counter + '"/></td>';

                                                        cols += '<td><input type="button" class="ibtnDel btn btn-md btn-danger "  value="Delete"></td>';
                                                        newRow.append(cols);
                                                        $("table.order-list").append(newRow);
                                                        counter++;
                                                    });



                                                    $("table.order-list").on("click", ".ibtnDel", function (event) {
                                                        $(this).closest("tr").remove();       
                                                        counter -= 1
                                                    });


                                                });



                                                function calculateRow(row) {
                                                    var price = +row.find('input[name^="price"]').val();

                                                }

                                                function calculateGrandTotal() {
                                                    var grandTotal = 0;
                                                    $("table.order-list").find('input[name^="price"]').each(function () {
                                                        grandTotal += +$(this).val();
                                                    });
                                                    $("#grandtotal").text(grandTotal.toFixed(2)); 
                                                }
                                                </script>



                                            <div class= "row">
                                              <div class="col-sm-2"><label align= "text-left"> </label></div>

                                            </div>
                </div>

                        <!-- P3 -->
                        <!--Purpose -->
                        <div class = "panel-heading panel-heading-custom">
                                <div class= "row">
                                    <div class="col-sm-2"><label align= "text-left">Purpose</label></div>
                                </div>
                        </div>

                        <div class="panel-body">
                            <div class= "row">
                                    <div class="col-sm-4"><textarea rows="2" cols="150" placeholder="Purpose"></textarea> 
                                    </div>              
                            </div>     
                        </div>

                <!-- P4 -->
                <!-- Requested by -->

                <div class = "panel-heading panel-heading-custom">
                    <div class= "row">
                      <div class="col-sm-2"><label align= "text-left">Requested By</label></div>
                    </div>
                </div>

                <div class="panel-body">
                    <div class = "row">
                      <div class="col-sm-2"><label align= "text-center">Name</label></div>
                      <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>
                    </div>

                        <!-- Blank Row -->
                        <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                    <div class = "row">

                      <div class="col-sm-2"><label align= "text-center">Designation</label></div>
                      <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Designation"></div>
                    </div>
                </div> 


                <!-- P5 -->
                <!-- Approved by -->
                <div class = "panel-heading panel-heading-custom">
                    <div class= "row">
                      <div class="col-sm-2"><label align= "text-left">Approved By</label></div>
                    </div>
                </div>

                <div class="panel-body">
                    <div class = "row">
                      <div class="col-sm-2"><label align= "text-center">Name</label></div>
                      <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>
                    </div>

                     <!-- Blank Row -->
                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                    <div class = "row">
                      <div class="col-sm-2"><label align= "text-center">Designation</label></div>
                      <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Designation"></div>
                    </div>            
                </div> 
                </form>
                </div>
                </div>
        <!-- .............CREATE FORM...............................................................................--> 
        <%}else if(session.getAttribute("formMode").equals("create")){%>
        <a href="/DAR-AMIS/CreateForms" class="previous" align="left">&laquo; Previous</a>
        <script>
            function submitPR(){
                if(confirm("Submit this form?")){

                    $.post("<%=root%>/CreatePR", $("#createPrForm").serialize(), function(data){
                        alert(data);
                        
                        //redirect to approve forms page
                        window.location = "<%=root%>/CreateForms";
                    });
                }
            }
        </script>
         
          <div class="panel panel-default">
              
                    <form id="createPrForm">
                                <!-- First Row -->
                                <div class = "row">

                                    <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

                                          <!-- Entity Name Dropdown -->
                                          <div class="col-sm-2">
                                            <div class="btn-group">
                                                <select class="form-control" name="entity">
                                                <option>Entity</option>
                                                <option>Department of Agrarian Reform</option>        
                                                </select>
                                            </div>
                                          </div> 

                                          <script>
                                            $(function(){
                                                                $("#1").click(function () {
                                                                $("#opt").text($(this).text());
                                                                });
                                                                $("#2").click(function () {
                                                                $("#opt").text($(this).text());
                                                                });
                                                                $("#3").click(function () {
                                                                $("#opt").text($(this).text());
                                                                });
                                                                $("#4").click(function () {
                                                                $("#opt").text($(this).text());
                                                                });
                                                            });
                                          </script>                              
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label>Choose Office</div>
                                        <!-- Entity Name Dropdown -->
                                        <div class="col-sm-2">
                                            <select class="form-control" name="office" onclick="test()">
                                                <%int ctr = 1;%>
                                                <%for(Office o: offices){%>
                                                <option><%=o.getIdOffice()%> - <%=o.getDepartment()%></option>
                                                <%ctr++;%>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div> 
                                </div>


                                <!-- Blank text for spacing --> 
                                <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div>
                                </div> 

                                <!-- Second Row -->
                                <div class = "row">

                                    <!-- Date -->
                                    <div class="col-sm-2"><label align= "text-center">Date</label></div>
                                    <div class="col-sm-2">
                                    <div class="form-group"> 

                                        <div class="input-group">
                                            <!-- This comment out adds an icon at the left side of the date text-->
                                            <!--<div class="input-group-addon">
                                              <i class="fa fa-calendar"></i>
                                            </div> -->
                                            <input class="form-control" id="date" name="date" placeholder="MM/DD/YYYY" type="text">
                                        </div>
                                    </div>
                                     <!--<div class="form-group">
                                      <div>
                                       <button class="btn btn-primary " name="submit" type="submit">Submit</button>  
                                      </div>
                                     </div>
                                     </form> 
                                    </div> -->
                                    </div>

                                    <!-- Date script for JS -->
                                    <script>
                                      $(document).ready(function(){
                                          var date_input=$('input[name="date"]'); //our date input has the name "date"
                                          var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                                          date_input.datepicker({
                                              format: 'mm/dd/yyyy',
                                              container: container,
                                              todayHighlight: true,
                                              autoclose: true
                                          })
                                      })
                                    </script>
                                </div> <!--end of 2nd row-->

                                <!-- Blank Row -->
                                <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                                <!-- Third Row -->
                                <div class = "row">

                                    <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
                                    <!-- Entity Name Dropdown -->
                                          <div class="col-sm-2">
                                              <select class="form-control" name="fundCluster">

                                                    <option>N/A</option>
                                                </select>
                                          </div>
                                  <div class="col-sm-2"><label align= "text-center"></label></div>

                                  <div class="col-sm-2"><label align= "text-center">Responsibility Center Code</label></div>
                                  <!-- Entity Name Dropdown -->
                                    <div class="col-sm-2">
                                        <select class="form-control" name="rcc">
                                        <option>N/A</option>
                                        </select>
                                    </div>

                                </div> <!-- end of 3rd row -->
                                <!-- Blank Row -->
                                <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                            <!-- P2 --> 
                            <div class = "panel-heading panel-heading-custom">
                                <div class= "row">
                                  <div class="col-sm-2"><label align= "text-center">Stock Property No.</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Unit</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Item Description</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Quantity</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Unit Cost</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Total Cost</label></div>
                                </div>
                            </div>
                            <div class="panel-body">

                                    <!-- Input for Repeating Section -->
                                            <table id="myTable" class="table order-list">

                                                <tbody>
                                                    <tr>
                                                        <td>
                                                            <div><input type="text"  name ="stockPropertyNo" align= "text-center" placeholder="Stock Property No"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="unit" align= "text-center" placeholder="Unit"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="description" align= "text-center" placeholder="Item Description"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="quantity" align= "text-center" placeholder="Quantity"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="unitCost" align= "text-center" placeholder="Unit Cost"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="totalCost" align= "text-center" placeholder="Total Cost"></div>
                                                        </td>
                                                        <td>
                                                            <a class="deleteRow"></a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <td colspan="7" style="text-align: left;">
                                                            <input name="addRow" type="button" class="btn btn-lg btn-block " id="addrow" value="Add Row" />
                                                        </td>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                    <script>
                                                            $(document).ready(function () {
                                                                var counter = 0;

                                                                $("#addrow").on("click", function () {
                                                                    var newRow = $("tbody");
                                                                    var cols = "";

                                                                    cols += '<tr><td><div><input type="text"  name ="stockPropertyNo" align= "text-center" placeholder="Stock Property No"></div></td>';
                                                                    cols += '<td><div><input type="text"  name="unit" align= "text-center" placeholder="Unit"></div></td>';
                                                                    cols += '<td><div><input type="text"  name="description" align= "text-center" placeholder="Item Description"></div></td>';
                                                                    cols += '<td><div><input type="text"  name="quantity" align= "text-center" placeholder="Quantity"></td>';
                                                                    cols += '<td><div><input type="text"  name="cost" align= "text-center" placeholder="Unit Cost"></div></td>';
                                                                    cols += '<td><div><input type="text"  name="totalCost" align= "text-center" placeholder="Total Cost"></div></td>';

                                                                    cols += '<td><div class="ibtnDel">&times;</div></td></tr>';
                                                                    newRow.append(cols);
                                                                    $("table.order-list").append(newRow);
                                                                    counter++;
                                                                });



                                                                $("table.order-list").on("click", ".ibtnDel", function (event) {
                                                                    $(this).closest("tr").remove();       
                                                                    counter -= 1;
                                                                });


                                                            });



                                                            function calculateRow(row) {
                                                                var price = +row.find('input[name^="cost"]').val();

                                                            }

                                                            function calculateGrandTotal() {
                                                                var grandTotal = 0;
                                                                $("table.order-list").find('input[name^="cost"]').each(function () {
                                                                    grandTotal += +$(this).val();
                                                                });
                                                                $("#grandtotal").text(grandTotal.toFixed(2)); 
                                                            }
                                                         </script>



                                                        <div class= "row">
                                                          <div class="col-sm-2"><label align= "text-left"> </label></div>

                                                        </div>
                            </div>

                                    <!-- P3 -->
                                    <!--Purpose -->
                                    <div class = "panel-heading panel-heading-custom">
                                            <div class= "row">
                                                <div class="col-sm-2"><label align= "text-left">Purpose</label></div>
                                            </div>
                                    </div>

                                    <div class="panel-body">
                                        <div class= "row">
                                            <div class="col-sm-4"><textarea name="purpose" rows="3" cols="140" placeholder="Purpose"></textarea> </div>              
                                        </div>
                                    </div>

                            <!-- P4 -->
                            <!-- Requested by -->

                            <div class = "panel-heading panel-heading-custom">
                                <div class= "row">
                                  <div class="col-sm-2"><label align= "text-left">Requested By</label></div>
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class = "row">
                                  <div class="col-sm-2"><label align= "text-center">Name</label></div>
                                  <div class="col-sm-2"><input name="rq_name" type="text"  align= "text-center" placeholder="Name"></div>
                                </div>

                                    <!-- Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                                <div class = "row">

                                  <div class="col-sm-2"><label align= "text-center">Designation</label></div>
                                  <div class="col-sm-2"><input name="rq_desig" type="text"  align= "text-center" placeholder="Designation"></div>
                                </div>
                            </div>
                    </form>
                    <p align="center">                         
                        <button onclick="submitPR()">Submit</button>
                    </p>
              
         </div>
        <!-- .............VIEW FORM...............................................................................-->
           <%}else if(session.getAttribute("formMode").equals("view")){%>
           <%Pr prData = (Pr) request.getAttribute("prData");%>
           <a href="view_forms.jsp" class="previous" align="left">&laquo; Previous</a>
          <div class="panel panel-default">
              
                    <form id="createPrForm">
                                <!-- First Row -->
                                <div class = "row">

                                    <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

                                          <!-- Entity Name Dropdown -->
                                          <div class="col-sm-2">
                                            <div class="btn-group">
                                                <select class="form-control" name="entity">
                                                    <option><%=prData.getEntityName() %></option>        
                                                </select>
                                            </div>
                                          </div> 

                                          <script>
                                            $(function(){
                                                                $("#1").click(function () {
                                                                $("#opt").text($(this).text());
                                                                });
                                                                $("#2").click(function () {
                                                                $("#opt").text($(this).text());
                                                                });
                                                                $("#3").click(function () {
                                                                $("#opt").text($(this).text());
                                                                });
                                                                $("#4").click(function () {
                                                                $("#opt").text($(this).text());
                                                                });
                                                            });
                                          </script>                              
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label>Office</div>
                                        <!-- Entity Name Dropdown -->
                                        <div class="col-sm-2">
                                            <%=prData.getIdOffice().getIdOffice() + " - " + prData.getIdOffice().getDepartment() %>
                                        </div>
                                    </div> 
                                </div>


                                <!-- Blank text for spacing --> 
                                <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div>
                                </div> 

                                <!-- Second Row -->
                                <div class = "row">

                                    <!-- Date -->
                                    <div class="col-sm-2"><label align= "text-center">Date</label></div>
                                    <div class="col-sm-2">
                                    <div class="form-group"> 

                                        <div class="input-group">
                                            <!-- This comment out adds an icon at the left side of the date text-->
                                            <!--<div class="input-group-addon">
                                              <i class="fa fa-calendar"></i>
                                            </div> -->
                                            <%=prData.getIdOffice().getIdOffice() + " - " + prData.getIdOffice().getDepartment() %>
                                        </div>
                                    </div>
                                     <!--<div class="form-group">
                                      <div>
                                       <button class="btn btn-primary " name="submit" type="submit">Submit</button>  
                                      </div>
                                     </div>
                                     </form> 
                                    </div> -->
                                    </div>

                                    <!-- Date script for JS -->
                                    <script>
                                      $(document).ready(function(){
                                          var date_input=$('input[name="date"]'); //our date input has the name "date"
                                          var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                                          date_input.datepicker({
                                              format: 'mm/dd/yyyy',
                                              container: container,
                                              todayHighlight: true,
                                              autoclose: true
                                          })
                                      })
                                    </script>
                                </div> <!--end of 2nd row-->

                                <!-- Blank Row -->
                                <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                                <!-- Third Row -->
                                <div class = "row">

                                    <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
                                    <!-- Entity Name Dropdown -->
                                          <div class="col-sm-2">
                                              <select class="form-control" name="fundCluster">

                                                    <option>hi</option>
                                                </select>
                                          </div>
                                  <div class="col-sm-2"><label align= "text-center"></label></div>

                                  <div class="col-sm-2"><label align= "text-center">Responsibility Center Code</label></div>
                                  <!-- Entity Name Dropdown -->
                                    <div class="col-sm-2">
                                        <select class="form-control" name="rcc">
                                        <option>hi</option>
                                        </select>
                                    </div>

                                </div> <!-- end of 3rd row -->
                                <!-- Blank Row -->
                                <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                            <!-- P2 --> 
                            <div class = "panel-heading panel-heading-custom">
                                <div class= "row">
                                  <div class="col-sm-2"><label align= "text-center">Stock Property No.</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Unit</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Item Description</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Quantity</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Unit Cost</label></div>
                                  <div class="col-sm-2"><label align= "text-center">Total Cost</label></div>
                                </div>
                            </div>
                            <div class="panel-body">

                                    <!-- Input for Repeating Section -->
                                            <table id="myTable" class="table order-list">

                                                <tbody>
                                                    <tr>
                                                        <td>
                                                            <div><input type="text"  name ="stockPropertyNo" align= "text-center" placeholder="Stock Property No"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="unit" align= "text-center" placeholder="Unit"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="description" align= "text-center" placeholder="Item Description"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="quantity" align= "text-center" placeholder="Quantity"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="cost" align= "text-center" placeholder="Unit Cost"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="totalCost" align= "text-center" placeholder="Total Cost"></div>
                                                        </td>
                                                        <td>
                                                            <a class="deleteRow"></a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <td colspan="7" style="text-align: left;">
                                                            <input name="addRow" type="button" class="btn btn-lg btn-block " id="addrow" value="Add Row" />
                                                        </td>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                    <script>
                                                            $(document).ready(function () {
                                                                var counter = 0;

                                                                $("#addrow").on("click", function () {
                                                                    var newRow = $("tbody");
                                                                    var cols = "";

                                                                    cols += '<tr><td><div><input type="text"  name ="stockPropertyNo" align= "text-center" placeholder="Stock Property No"></div></td>';
                                                                    cols += '<td><div><input type="text"  name="unit" align= "text-center" placeholder="Unit"></div></td>';
                                                                    cols += '<td><div><input type="text"  name="description" align= "text-center" placeholder="Item Description"></div></td>';
                                                                    cols += '<td><div><input type="text"  name="quantity" align= "text-center" placeholder="Quantity"></td>';
                                                                    cols += '<td><div><input type="text"  name="cost" align= "text-center" placeholder="Unit Cost"></div></td>';
                                                                    cols += '<td><div><input type="text"  name="totalCost" align= "text-center" placeholder="Total Cost"></div></td>';

                                                                    cols += '<td><div class="ibtnDel">&times;</div></td></tr>';
                                                                    newRow.append(cols);
                                                                    $("table.order-list").append(newRow);
                                                                    counter++;
                                                                });



                                                                $("table.order-list").on("click", ".ibtnDel", function (event) {
                                                                    $(this).closest("tr").remove();       
                                                                    counter -= 1;
                                                                });


                                                            });



                                                            function calculateRow(row) {
                                                                var price = +row.find('input[name^="cost"]').val();

                                                            }

                                                            function calculateGrandTotal() {
                                                                var grandTotal = 0;
                                                                $("table.order-list").find('input[name^="cost"]').each(function () {
                                                                    grandTotal += +$(this).val();
                                                                });
                                                                $("#grandtotal").text(grandTotal.toFixed(2)); 
                                                            }
                                                         </script>



                                                        <div class= "row">
                                                          <div class="col-sm-2"><label align= "text-left"> </label></div>

                                                        </div>
                            </div>

                                    <!-- P3 -->
                                    <!--Purpose -->
                                    <div class = "panel-heading panel-heading-custom">
                                            <div class= "row">
                                                <div class="col-sm-2"><label align= "text-left">Purpose</label></div>
                                            </div>
                                    </div>

                                    <div class="panel-body">
                                        <div class= "row">
                                            <div class="col-sm-4"><textarea name="purpose" rows="3" cols="140" placeholder="Purpose"></textarea> </div>              
                                        </div>
                                    </div>

                            <!-- P4 -->
                            <!-- Requested by -->

                            <div class = "panel-heading panel-heading-custom">
                                <div class= "row">
                                  <div class="col-sm-2"><label align= "text-left">Requested By</label></div>
                                </div>
                            </div>

                            <div class="panel-body">
                                <div class = "row">
                                  <div class="col-sm-2"><label align= "text-center">Name</label></div>
                                  <div class="col-sm-2"><input name="requestedByName" type="text"  align= "text-center" placeholder="Name"></div>
                                </div>

                                    <!-- Blank Row -->
                                    <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                                <div class = "row">

                                  <div class="col-sm-2"><label align= "text-center">Designation</label></div>
                                  <div class="col-sm-2"><input name="designation" type="text"  align= "text-center" placeholder="Designation"></div>
                                </div>
                            </div>
                    </form>
              
         </div>
           <%}%>
                    
        
                 <!-- <tr><button type="button" class="btn btn-default">Create</button></tr><tr><button type="button" class="btn btn-default">Edit</button></tr><tr><button type="button" class="btn btn-default">View List</button></tr> -->
		</section><! --/wrapper -->
      </section>
     </section>
             <!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <jsp:include page="WEB-INF/copyright.jsp" />
      <!--footer end-->
  </section>
      <jsp:include page="WEB-INF/footer.jsp" /> 
  </body>
</html>

