<%-- 
    Document   : pc
    Created on : 03 19, 18, 5:13:36 PM
    Author     : BavarianHotdog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | PTR</title>
    <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }

    </style>
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
         <section id="main-content">
          <section class="wrapper">
              <section class="content-header">
                    <h1>
                        Property Card
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
			<div class="container-fluid">
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Property Card</STRONG></p></div> 
            <div class="panel-body"> 
            <!-- First Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Property, Plant And Equipment</label></div>              
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name of PPE"></div>

                           

              <!-- Blank text for spacing --> 
              <div class="col-sm-2"><label align= "text-center"></label></div>              

              <div class="col-sm-2"><label align= "text-center">Property Number</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Property No."></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Description</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Description"></div>
             

			 
            
              </div>
			   <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>


            

            
</div>
        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
		<div class= "row">
		
		<div class = "row"><div class="col-sm-3"><label align= "text-center"></label></div></div>

            <div class="row"><div class="col-sm-1"><label align="text-center"></label></div>		
			<div class="col-sm-3"><label align="text-center"></label></div>
			
			<div class="col-sm-1"><label align="text-center"></div></label>
		  
			
		    <div class="col-sm-3"><label align="text-center"></label></div>		
			<div class="col-sm-2"><label align="text-center">Historical Data</div></label>
			</div>
			</div>
			   <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class= "row">
              <div class="col-sm-2"><label align= "text-center">Supplier</label></div>
              <div class="col-sm-1"><label align= "text-center">DR/SI No.</label></div>
              <div class="col-sm-1"><label align= "text-center">Quantity</label></div>
			  <div class="col-sm-1"><label align= "text-center">Amount</label></div>
			  <div class="col-sm-1"><label align= "text-center"></label></div>
              <div class="col-sm-1"><label align= "text-center">Nature of Repair</label></div>
              <div class="col-sm-1"><label align= "text-center">Date</label></div>
			  <div class="col-sm-1"><label align= "text-center">Remarks</label></div>
              <div class="col-sm-1"><label align= "text-center">Office</label></div>
			  <div class="col-sm-1"><label align= "text-center">End-user</label></div>
            </div>
        </div>

        <div class="panel-body">

          	<!-- Input for Repeating Section -->
			<table id="myTable" class=" table order-list">
			    
			    <tbody>
			        <tr>
			            <td width="28%">
			                <div><input type="text" size="18" name ="Supplier" align= "text-center" placeholder="Supplier"></div>
			            </td>
			            <td width="15%">
			                <div><input type="text"  size="13" name="DRSI" align= "text-center" placeholder="DR/SI No."></div>
			            </td>
			            <td width="15%">
			                <div><input type="text"  size="7" name="Quantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td width="30%">
			                <div><input type="text" size="9" name="Amount" align= "text-center" placeholder="Amount"></div>
			           
			            <td width="10%">
			                <div><textarea type="text" size="25" name="RepairNature" align= "text-center" placeholder="Nature of Repair"></textarea></div>
			            </td>
			            <td width="10%">
			                <div><input type="date" name="Date" align= "text-center" placeholder=""></div>
			            </td>
						<td>
			                <div><textarea type="text" size="20"  name="Remarks" align= "text-center" placeholder="Remarks"></textarea></div>
			            </td>
						 <td width="10%">
			                <div><input type="text" size="7" name="Date" align= "text-center" placeholder="Office"></div>
			            </td>
						<td>
			                <div><input type="text" size="15"  name="EndUser" align= "text-center" placeholder="End-User"></div>
			            </td>
			            <td><a class="deleteRow"></a>

			            </td>
			        </tr>
			    </tbody>
			    <tfoot>
			        <tr>
			            <td colspan="12" style="text-align: left;">
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

					        cols += '<td><input size="18" type="text" placeholder="Supplier" name="Supplier' + counter + '"/></td>';
					        cols += '<td><input size="13" type="text" placeholder="DR/SI No." 				name="DRSI' 		   + counter + '"/></td>';
					        cols += '<td><input size="7" type="text" placeholder="Quantity"  name="Quantity' + counter + '"/></td>';
					        cols += '<td><input size="9" type="text" placeholder="Amount" 			name="Amount' 	   + counter + '"/></td>';
					        cols += '<td><textarea size="25" type="text" placeholder="Nature of Repair" 		name="RepairNature' 	   + counter + '"/></td>';
					        cols += '<td><input  type="date" placeholder="Date" 		name="Date' 	   + counter + '"/></td>';
							cols += '<td><textarea size="20" type="text" placeholder="Remarks" 		name="Remarks' 	   + counter + '"/></td>';
                            cols += '<td><input size="7"  type="text" placeholder="Office" 		name="Office' 	   + counter + '"/></td>';
							cols += '<td><input size="15" type="text" placeholder="End-User" 		name="EndUser' 	   + counter + '"/></td>';

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
	       
        </div>
      </div>
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


