<%-- 
    Document   : wmr
    Created on : 03 19, 18, 5:13:45 PM
    Author     : BavarianHotdog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | RPCI</title>
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
                        Waste Material Report
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                 <div class="container-fluid">
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Waste Material Report</STRONG></p></div> 
            <div class="panel-body"> 
            <!-- First Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

              <!-- Entity Name Dropdown -->
              <div class="col-sm-2">
               <div class="btn-group">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" id="options"> <span id="opt">Choose Entity</span> <span class="caret"></span>
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

              <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="RIS No."></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Place of Storage</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Cluster"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  
		  

              <div class="col-sm-2"><label align= "text-center">Date</label></div>
              <div class="col-sm-2"><input type="Date"  align= "text-center" placeholder="Date"></div>

            </div> 
			</div>
        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
		<div class= "row"><label align="text-left">Items for Disposal</label></div>
		
		 <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"></label></div></div>

            <div class="row"><div class="col-sm-4"><label align="text-center"></label></div>		
			<div class="col-sm-4"><label align="text-center"></label></div>
			
			<div class="col-sm-4"><label align="text-center"></label>Record of Sales</div>
			</div>
			<div class="row"><div class="col-sm-4"><label align="text-center"></label></div>		
			<div class="col-sm-4"><label align="text-center"></label></div>
			
			<div class="col-sm-4"><label align="text-center"></label>Official Receipt</div>
			</div>

			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"></label></div></div>

			
            <div class= "row">
			
              <div class="col-sm-2"><label align= "text-center">Item No.</label></div>
              <div class="col-sm-1"><label  align= "text-center">Quantity </label></div>
			  <div class="col-sm-2"><label align= "text-center">Unit</label></div>
              <div class="col-sm-2"><label align= "text-center">Description</label></div>
              <div class="col-sm-1"><label  align= "text-center">Number </label></div>
			  <div class="col-sm-2"><label align= "text-center">Date</label></div>
              <div class="col-sm-2"><label align= "text-center">Amount</label></div>
            </div>
        </div>

        <div class="panel-body">

          	<!-- Input for Repeating Section -->
			<table id="myTable" class=" table order-list">
			    
			    <tbody>
			        <tr>
			            <td>
			                <div><input type="text"  name ="Item" align= "text-center" placeholder="Item No."></div>
			            </td>
			            <td>
			                <div><input type="text" size="10" name="Quantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="Unit" align= "text-center" placeholder="Unit"></div>
			            </td>
			            <td>
			                <div><textarea type="text"  name="Description" align= "text-center" placeholder="Description"></textarea></div>
			            </td>
						<td>
			                <div><input type="text"  name="Number" align= "text-center" placeholder="No."></div>
			            </td>
			            <td>
			                <div><input type="Date"  name="Date" align= "text-center" placeholder="Date"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="Amount" align= "text-center" placeholder="Amount"></div>
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
							

					        cols += '<td><input type="text" placeholder="Item No." name="Item' + counter + '"/></td>';
					        cols += '<td><input type="text" size="10" placeholder="Quantity" 	name="Quantity' 		   + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Unit"  name="Unit' + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Description" 	name="Description' 	   + counter + '"/></td>';
							cols += '<td><input type="text" placeholder="No." 	name="Number' 		   + counter + '"/></td>';
					        cols += '<td><input type="Date" placeholder="Date"  name="Date' + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Amount" 	name="Amount' 	   + counter + '"/></td>';
					       
  
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
		<!--Inspection -->
		<div class = "panel-heading panel-heading-custom">
			<div class= "row">
			    <div class="col-sm-2"><label align= "text-left">Inspection</label></div>
			</div>
		</div>

		<div class="panel-body">
		    <div class = "row">
			
              <div class="col-sm-2"><label align= "text-center">Date Inspected:</label></div>
              <div class="col-sm-2"><input type="date"  align= "text-center" placeholder="Date Inspected"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  </div>			  
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class= "row">
			 <div class="col-sm-2"></div>
			<div class="col-sm-4"><input type="checkbox" name="inspected" value="inspected">Inspected, verified, and found in order as to quantity and specification</div>
			</div>
			
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
		    <div class="col-sm-2"><label align= "text-center">Inspection Office/Committee:</label></div>
              <div class="col-sm-2"><input type="text" size="25" align= "text-center" placeholder="Inspection Office/Committee"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			</div>
			
			
			<!--Inspection -->
		<div class = "panel-heading panel-heading-custom">
			<div class= "row">
			    <div class="col-sm-2"><label align= "text-left">Acceptance</label></div>
			</div>
		</div>
			
			<div class="panel-body">
		    <div class = "row">
			
              <div class="col-sm-2"><label align= "text-center">Date Received:</label></div>
              <div class="col-sm-2"><input type="date"  align= "text-center" placeholder="Date Inspected"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  </div>			  
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class= "row">
			 <div class="col-sm-2"></div>
			<div class="col-sm-4"><input type="checkbox" name="Complete" value="complete">Complete</div>
			</div>
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class= "row">
			 <div class="col-sm-2"></div>
			<div class="col-sm-1"><input type="checkbox" name="Complete" value="complete">Partial</div>
			<div class="col-sm-2"><label align= "text-center">Specific Quantity:</label></div>
              <div class="col-sm-1"><input type="text" size="30" align= "text-center" placeholder="Specific Quantity of Partial"></div>
              <div class="col-sm-1"><label align= "text-center"></label></div>
			</div>
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
		    <div class="col-sm-2"><label align= "text-center">Supply Officer:</label></div>
              <div class="col-sm-2"><input type="text" size="40" align= "text-center" placeholder="Supply Officer"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
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
