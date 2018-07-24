<%-- 
    Document   : ris
    Created on : 03 19, 18, 5:08:57 PM
    Author     : BavarianHotdog
--%>
<%@page import="dao.Ris"%>
<%@page import="dao.RisDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Pr"%>
<%@page import="dao.Po"%>
<%Pr pr = (Pr)request.getAttribute("pr");%>
<%Ris ris = (Ris) request.getAttribute("ris");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | RIS</title>
    <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }

    </style>
    <script>
        function createRIS(){
            if(confirm("Submit this form?")){
                url = "<%=root%>/CreateRIS";
                $.post(url, $("#risForm").serialize(), function(data){
                    alert(data);
                });
            }
        }
    </script>
  </head>

  <body>

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
      <form action="CreateRIS" method="POST">
         <section id="main-content">
          <section class="wrapper">
              <section class="content-header">
                    <h1>
                        Requisition and Issuance Slip
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                  
    
    <!-- .............CREATE FORM...............................................................................--> 
    
    <div class="container-fluid">
                       <a href="/DAR-AMIS/CreateForms" class="previous" align="left">&laquo; Previous</a>
                                <script>
                                    function submitRIS(){
                                        if(confirm("Submit this form?")){

                                            $.post("<%=root%>/CreateRIS", $("#createRisForm").serialize(), function(data){
                                                alert(data);

                                                //redirect to approve forms page
                                                window.location = "<%=root%>/CreateForms";
                                            });
                                        }
                                    }
                                </script>
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Requisition and Issuance Slip</STRONG></p></div> 
            <div class="panel-body"> 
            <!-- First Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

              <!-- Entity Name Dropdown -->
              <div class="col-sm-2">
               <div class="btn-group">
                   <button class="btn btn-secondary dropdown-toggle" name="entity" type="button" data-toggle="dropdown" id="options"> <span id="opt">Choose Entity</span> <span class="caret"></span>
                </button>
                  <ul class="dropdown-menu">
                    <li><a class="dropdown-item" id="1" href="#" >DARCO</a></li>
                    <li><a class="dropdown-item" id="2" href="#">Other</a></li>    
                  </ul>
              </div>
              </div>
              <!-- Entity Name Dropdown script for JS-->
              <script type="text/javascript">
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

              <div class="col-sm-2"><label align= "text-center">RIS No.</label></div>
              <div class="col-sm-2"><input type="text" name="ris_no" align= "text-center" placeholder="RIS No."></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Office/Section</label></div>
              <div class="col-sm-2"><input type="text" name="office" align= "text-center" placeholder="Office/Section"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
              <div class="col-sm-2"><input type="text" name="fund_cluster" align= "text-center" placeholder="Fund Cluster">
              </div>
			  </div>

            

            

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Third Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Division</label></div>
              <div class="col-sm-2"><input type="text" name="division" align= "text-center" placeholder="Division"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Responsibility Center Code</label></div>
              <div class="col-sm-2"><input type="text" name="responsibility_code" align= "text-center" placeholder="Responsibility Center Code"></div>

            </div> 
            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

          </div>

        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
            <div class= "row seven-cols">
              <div class="col-sm-2"><label align= "text-center">Stock No.</label></div>
              <div class="col-sm-2"><label align= "text-center">Unit</label></div>
              <div class="col-sm-1"><label align= "text-center">Item Description</label></div>
              <div class="col-sm-2"><label align= "text-center">Quantity</label></div>
              <div class="col-sm-2"><label align= "text-center">Stock Available</label></div>
              <div class="col-sm-1"><label align= "text-center">Quantity</label></div>
			  <div class="col-sm-2"><label align= "text-center">Remarks</label></div>
            </div>
        </div>

        <div class="panel-body">

          	<!-- Input for Repeating Section -->
			<table id="myTable" class=" table order-list">
			    
			    <tbody>
			        <tr>
			            <td>
			                <div><input type="text"  name ="stock_no" align= "text-center" size="12" placeholder="Stock No"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="unit" align= "text-center" placeholder="Unit"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="description" align= "text-center" placeholder="Item Description"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="req_quantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="stock_avail" align= "text-center" placeholder="Stock Availability"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="issuance_quantity" align= "text-center" placeholder="Qantity"></div>
			            </td>
                                    <td>
			                <div><input type="text"  name="remarks" align= "text-center" placeholder="Remarks"></div>
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
					<Script>
					$(document).ready(function () {
					    var counter = 0;

					    $("#addrow").on("click", function () {
					        var newRow = $("<tr>");
					        var cols = "";

					        cols += '<td><div><input type="text"  name ="stock_no" align= "text-center" size="12" placeholder="Stock No"></div></td>';
					        cols += '<td><div><input type="text"  name="unit" align= "text-center" placeholder="Unit"></div></td>';
					        cols += '<td><div><input type="text"  name="description" align= "text-center" placeholder="Item Description"></div></td>';
					        cols += '<td><div><input type="text"  name="req_quantity" align= "text-center" placeholder="Quantity"></div></td>';
					        cols += '<td><div><input type="text"  name="stock_avail" align= "text-center" placeholder="Stock Availability"></div></td>';
					        cols += '<td><div><input type="text"  name="issuance_quantity" align= "text-center" placeholder="Qantity"></div></td>';
                                                cols += '<td><div><input type="text"  name="remarks" align= "text-center" placeholder="Remarks"></div></td>';
  
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
					</Script>



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
                        <div class="col-sm-4"><textarea rows="3" name="purpose" cols="170" placeholder="Purpose"></textarea> </div>              
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
              <div class="col-sm-2"><input type="text" name="name_req" align= "text-center" placeholder="Name"></div>
            </div>

        	<!-- Blank Row -->
        	<div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Designation</label></div>
              <div class="col-sm-2"><input type="text" name="designation_req" align= "text-center" placeholder="Designation"></div>
            </div>
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class = "row">
              <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Date</label></div>
              <div class="col-sm-2">
                <!-- <form method="post"> 
                 <div class="form-group "> -->
                  
                  <div class="input-group">
                    <!-- This comment out adds an icon at the left side of the date text-->
                    <!--<div class="input-group-addon">
                      <i class="fa fa-calendar"></i>
                    </div> -->
                   <input class="form-control" id="date" name="date_req" placeholder="MM/DD/YYYY" type="text">
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
                          autoclose: true,
                      })
                  })
                </script>
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
              <div class="col-sm-2"><input type="text" name="name_app" align= "text-center" placeholder="Name"></div>
            </div>

             <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Designation</label></div>
              <div class="col-sm-2"><input type="text" name="designation_app" align= "text-center" placeholder="Designation"></div>
            </div>            
			
			 <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class = "row">
              <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Date</label></div>
              <div class="col-sm-2">
                <!-- <form method="post"> 
                 <div class="form-group "> -->
                  
                  <div class="input-group">
                    <!-- This comment out adds an icon at the left side of the date text-->
                    <!--<div class="input-group-addon">
                      <i class="fa fa-calendar"></i>
                    </div> -->
                   <input class="form-control" id="date" name="date_app" placeholder="MM/DD/YYYY" type="text">
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
                          autoclose: true,
                      })
                  })
                </script>
        </div> 
		<div class = "panel-heading panel-heading-custom">
            <div class= "row">
              <div class="col-sm-2"><label align= "text-left">Issued By</label></div>
            </div>
        </div>
		<div class="panel-body">
            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Name</label></div>
              <div class="col-sm-2"><input type="text" name="name_issued" align= "text-center" placeholder="Name"></div>
            </div>

             <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Designation</label></div>
              <div class="col-sm-2"><input type="text" name="designation_issued" align= "text-center" placeholder="Designation"></div>
            </div>      
			
			
			 <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class = "row">
              <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Date</label></div>
              <div class="col-sm-2">
                <!-- <form method="post"> 
                 <div class="form-group "> -->
                  
                  <div class="input-group">
                    <!-- This comment out adds an icon at the left side of the date text-->
                    <!--<div class="input-group-addon">
                      <i class="fa fa-calendar"></i>
                    </div> -->
                   <input class="form-control" id="date" name="date_issued" placeholder="MM/DD/YYYY" type="text">
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
                          autoclose: true,
                      })
                  })
                </script>
            

		
        </div> 
		<div class = "panel-heading panel-heading-custom">
            <div class= "row">
              <div class="col-sm-2"><label align= "text-left">Received By</label></div>
            </div>
        </div>
		<div class="panel-body">
            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Name</label></div>
              <div class="col-sm-2"><input type="text" name="name_rec" align= "text-center" placeholder="Name"></div>
            </div>

             <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Designation</label></div>
              <div class="col-sm-2"><input type="text" name="designation_rec" align= "text-center" placeholder="Designation"></div>
            </div>      
			
			 <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class = "row">
              <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Date</label></div>
              <div class="col-sm-2">
                <!-- <form method="post"> 
                 <div class="form-group "> -->
                  
                  <div class="input-group">
                    <!-- This comment out adds an icon at the left side of the date text-->
                    <!--<div class="input-group-addon">
                      <i class="fa fa-calendar"></i>
                    </div> -->
                   <input class="form-control" id="date" name="date_rec" placeholder="MM/DD/YYYY" type="text">
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
                          autoclose: true,
                      })
                  })
                </script>
            </div>   
                         <p align="center">                         
                            <button onclick="submitRIS()">Submit</button>
                        </p>
                        <br>
                        <br>
          </div>         
        </div>
		</section><! --/wrapper -->
      </section>
     </section>
             <!-- /MAIN CONTENT -->
      </form>
      <!--main content end-->
      <!--footer start-->
      <jsp:include page="WEB-INF/copyright.jsp" />
      <!--footer end-->
  </section>
      <jsp:include page="WEB-INF/footer.jsp" /> 
  </body>
</html>


