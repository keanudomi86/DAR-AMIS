<%-- 
    Document   : rpcppe
    Created on : 03 19, 18, 5:12:44 PM
    Author     : BavarianHotdog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | RPCPPE</title>
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
                        Report on Physical Count of Property, Plant and Equipment
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                 <div class="container-fluid">
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Report on Physical Count of Property, Plant and Equipment</STRONG></p></div> 
            <div class="panel-body"> 
            <!-- First Row -->
			
			
			<div class= "row">
			<!-- Blank text for spacing --> 
              <div class="col-sm-3"><label align= "text-center"></label></div>
			  <!-- Blank text for spacing --> 
              <div class="col-sm-2"><label align= "text-center">Type of Property,Plant and Equipment: </label></div>
              <div class="col-sm-1"><input type="text" size ="45" align= "text-center" placeholder="Type of Inventory Item"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			</div>
			
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div> 
			
			<div class= "row">
			<!-- Blank text for spacing --> 
              <div class="col-sm-4"><label align= "text-center"></label></div>
			  <!-- Blank text for spacing --> 
              <div class="col-sm-2"><label align= "text-center">Date: </label></div>
              <div class="col-sm-1"><input type="date" size ="45" align= "text-center" placeholder="Date"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			</div>
			
			
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>              
               <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Cluster"></div>
                     
            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-1"><label align= "text-center">For which:</label></div>
              <div class="col-sm-2"><input type="text"  size="30" align= "text-center" placeholder="Accountable officer"></div>
			  <div class="col-sm-2"><input type="text"  size="30" align= "text-center" placeholder=" Office Designation"></div>
			  <div class="col-sm-2"><input type="text"  size="30" align= "text-center" placeholder=" Entity Name"></div>
			  </div>
			  <div class = "row">
              <div class="col-sm-6"><label align= "text-center">This person is accountable, having assumed such accountability on:</label></div>
			  </div>
			  <div class= "row">
			  
			  <div class="col-sm-2"><label align= "text-center">Date:</label></div>
              <div class="col-sm-2"><input type="date" size ="45" align= "text-center" placeholder="Date"></div>
            </div>
		  

             

       </div>


        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
		<div class= "row">
		
		<div class = "row"><div class="col-sm-2"><label align= "text-center"></label></div></div>

            <div class="row"><div class="col-sm-3"><label align="text-center"></label></div>		
			<div class="col-sm-3"><label align="text-center"></label></div>
			
			<div class="col-sm-1"><label align="text-center"></label></div></label>
			<div class="col-sm-1"><label align="text-center"> <label></div></label>
			<div class="col-sm-1"><label align="text-center"> <label>Shortage/Overage</div></label>
			</div>
			
		<div class = "col-sm-1"><label align="text-left">Article</label></div>
		<div class = "col-sm-2"><label align="text-left">Description</label></div>
		<div class = "col-sm-1"><label align="text-left">Property Number</label></div>
		<div class = "col-sm-1"><label align="text-left">Unit of measure</label></div>
		<div class = "col-sm-1"><label align="text-left">Unit Value</label></div>
		<div class = "col-sm-1"><label align="text-left">Quantity per Property Card</label></div>
		<div class = "col-sm-1"><label align="text-left">Quantity per Physical Count</label></div>
		<div class = "col-sm-1"><label align="text-left">Quantity</label></div>
		<div class = "col-sm-1"><label align="text-left">Value</label></div>
		<div class = "col-sm-2"><label align="text-left">Remarks</label></div>
		</div>
		
	

           </div>

        <div class="panel-body">

          	<!-- Input for Repeating Section -->
			<table id="myTable" class=" table order-list">
			    
			    <tbody>
			        <tr>
			            <td>
			                <div><input type="text"  size="5"name ="Article" align= "text-center" placeholder="Article"></div>
			            </td>
			            <td>
			                <div><textarea type="text"  size="25" name="Description" align= "text-center" placeholder="Description"></textarea></div>
			            </td>
			            <td>
			                <div><input type="text"  size="10" name="PropertyNum" align= "text-center" placeholder="Property No."></div>
			            </td>
			            <td>
			                <div><input type="text" size="10"  name="UnitMeasure" align= "text-center" placeholder="Unit of Measure"></div>
			            </td>
						<td>
			                <div><input type="text" size="10" name="UnitValue" align= "text-center" placeholder="Unit Value"></div>
			            </td>
			            <td>
			                <div><input type="text"  size="10"name="PropCardQuantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td>
			                <div><input type="text"  size="10" name="PhysicalCountQuantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
						 <td>
			                <div><input type="text"  size="7" name="SAQuantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
						 <td>
			                <div><input type="text"  size="7" name="Value" align= "text-center" placeholder="Value"></div>
			            </td>
			            <td>
			                <div><textarea type="text"  name="Remarks" align= "text-center" placeholder="Remarks"></textarea></div>
			            </td>
			          
			            <td><a class="deleteRow"></a>

			            </td>
			        </tr>
			    </tbody>
			    <tfoot>
			        <tr>
			            <td colspan="10" style="text-align: left;">
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
							

					        cols += '<td><input type="text" size="5" placeholder="Article" name="Article' + counter + '"/></td>';
					        cols += '<td><textarea type="text" size="25" placeholder="Description" 	name="Description' + counter + '"/></td>';
					        cols += '<td><input type="text" size="10" placeholder="Property No."  name="PropertyNum' + counter + '"/></td>';
					        cols += '<td><input type="text"size="10"  placeholder="Unit of Measure" name="UnitMeasure' + counter + '"/></td>';
						cols += '<td><input type="text" size="10" placeholder="Unit Value" name="UnitValue' + counter + '"/></td>';
					        cols += '<td><input type="text" size="10" placeholder="Quantity"  name="PropCardQuantity' + counter + '"/></td>';
					        cols += '<td><input type="text" size="10" placeholder="Quantity" name="PhysicalCountQuantity' + counter + '"/></td>';
					        cols += '<td><input type="text" size="7" placeholder="Quantity" name="SAQuantity' + counter + '"/></td>';
					        cols += '<td><input type="text" size="7"placeholder="Value" name="Value' + counter + '"/></td>';
					        cols += '<td><textarea type="text" placeholder="Remarks" name="Remarks' + counter + '"/></td>';
							
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
			    <div class="col-sm-2"><label align= "text-left">Certified Correct:</label></div>
			</div>
		</div>

		<div class="panel-body">
		    <div class = "row">
			
              <div class="col-sm-2"><label align= "text-center"><b></b></label></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  		  
			  
			   <!-- Blank text for spacing --> 
              <div class="col-sm-2"><label align= "text-center"></label></div>              

           
			  </div>
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class = "row">
			
              <div class="col-sm-2"><label align= "text-center">Name:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name of checker:"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
		
              
		</div>
		<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"></label></div></div>
			
			<div class = "row">
			
			<div class="col-sm-2"><label align= "text-center">Designation:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Position of Signatory"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  
			  </div>
			
			
			
		</div>
			
			<!--Inspection -->
		<div class = "panel-heading panel-heading-custom">
			<div class= "row">
			    <div class="col-sm-2"><label align= "text-center">Approved By:</label></div>
				
			</div>
		</div>
			
			<div class="panel-body">


		<div class="panel-body">
		    <div class = "row">
			
              <div class="col-sm-2"><label align= "text-center"><b>Certified Correct:</b></label></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  		  
			  
			 </div>
           
		
			
			
			<div class = "row">
			
              <div class="col-sm-2"><label align= "text-center">Name:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name of checker:"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			
		</div>
		<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class = "row">
			
			<div class="col-sm-2"><label align= "text-center">Designation:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Position of Signatory"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
		
			  
			  </div>
			
			
			
		</div>
			
		</div>
			<div class = "panel-heading panel-heading-custom">
			<div class= "row">
			    <div class="col-sm-2"><label align= "text-left">Verified By:</label></div>
			</div>
		</div>

		<div class="panel-body">
		    <div class = "row">
			
              <div class="col-sm-2"><label align= "text-center"><b></b></label></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  		  
			  
			 </div>
           
		
			
			
			<div class = "row">
			
              <div class="col-sm-2"><label align= "text-center">Name:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name of checker:"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			
		</div>
		<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class = "row">
			
			<div class="col-sm-2"><label align= "text-center">Designation:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Position of Signatory"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
		
			  
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

