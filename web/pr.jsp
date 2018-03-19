<%-- 
    Document   : pr
    Created on : 02 8, 18, 6:51:34 PM
    Author     : BavarianHotdog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | PR</title>
  </head>
    <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }

    </style>
  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.jsp" class="logo"><b>DAR-AMIS</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <!-- -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            </ul>
                    </li>
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                        </ul>
                </ul>            
                            
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="index.jsp">Logout</a></li>
            	</ul>
            </div>
        </header>
      
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
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                  <div class="container-fluid">
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Purchase Request</STRONG></p></div> 
            <div class="panel-body"> 
            
            <!-- First Row -->
            <div class = "row">

                <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

	              <!-- Entity Name Dropdown -->
	              <div class="col-sm-2">
	               <div class="btn-group">
	                <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="options"> 
	                	<span id="opt">Choose Entity</span> <span class="caret"></span>
	                </button>
	                  <ul class="dropdown-menu">
	                    <li><a class="dropdown-item" id="1" href="#" >DARCO</a></li>
	                    <li><a class="dropdown-item" id="2" href="#">Other</a></li>    
	                  </ul>
	              </div>
	              </div> 

	              <Script>
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
	              </Script>                              

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
                <!-- <form method="post"> 
                 <div class="form-group "> -->
                  
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
                          autoclose: true,
                      })
                  })
                </script>

            

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Third Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Cluster"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Responsibility Center Code</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Responsibility Center Code"></div>

            </div> 
            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

          </div>

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
			                <div><input type="text"  name ="stockPropertyNo" align= "text-center" placeholder="Stock Property No"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="unit" align= "text-center" placeholder="Unit"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="itemDescription" align= "text-center" placeholder="Item Description"></div>
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

					        cols += '<td><input type="text" placeholder="Stock Property No" name="stockPropertyNo' + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Unit" 				name="unit' 		   + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Item Description"  name="itemDescription' + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Quantity" 			name="quantity' 	   + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Unit Cost" 		name="unitCost' 	   + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Total Cost" 		name="totalCost' 	   + counter + '"/></td>';

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
			    <div class="col-sm-4"><textarea rows="3" cols="170" placeholder="Purpose"></textarea> </div>              
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

          </div>         
        </div>
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

