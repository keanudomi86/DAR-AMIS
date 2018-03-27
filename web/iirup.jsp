<%-- 
    Document   : iirup
    Created on : 03 19, 18, 5:12:53 PM
    Author     : BavarianHotdog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | IIRUP</title>
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
                        Inventory and Inspection Report of Unserviceable Property
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                            
                        <div class="container-fluid">
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Inventory and Inspection Report of Unserviceable Property</STRONG></p></div> 
            <div class="panel-body"> 
            <!-- First Row -->
			
			
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div> 
			
			<div class= "row">
			<!-- Blank text for spacing --> 
              <div class="col-sm-4"><label align= "text-center"></label></div>
			  <!-- Blank text for spacing --> 
              <div class="col-sm-1"><label align= "text-center">Date: </label></div>
             <div><input style="width:300px;" type="Date" name ="Date" align= "text-center" placeholder=""></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			</div>
			
			
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
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


            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-2"><input type="text"  size="30" align= "text-center" placeholder="Name of Accountable officer"></div>
			  <div class="col-sm-2"><input type="text"  size="30" align= "text-center" placeholder="Designation"></div>
			  <div class="col-sm-2"><input type="text"  size="30" align= "text-center" placeholder="Station"></div>
			  </div>
			 
		  

             
</div>
.

        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
		<div class= "row">
		
		<div class = "row"><div class="col-sm-2"><label align= "text-center"></label></div></div>

            <div class="row"><div class="col-sm-3"><label align="text-center"></label></div>		
			<div class="col-sm-3"><label align="text-center"></label></div>
			
			<div class="col-sm-1"><label align="text-center"></label>Inventory</div></label>
			<div class="col-sm-2"><label align="text-center"></label></div>
			
			<div class="col-sm-1"><label align="text-center"></label>Disposal</div></label>
			
			</div>
			
		<div class = "col-sm-1"><label align="text-left">Type of Equipment</label></div>
		<div class = "col-sm-1"><label align="text-left">Date Acquired</label></div>
		
		<div class = "col-sm-1"><label align="text-left">Particulars /Articles</label></div>
		<div class = "col-sm-1"><label align="text-left">Property No.</label></div>
		<div class = "col-sm-1"><label align="text-left">Quantity</label></div>
		<div class = "col-sm-1"><label align="text-left">Unit Cost</label></div>
		<div class = "col-sm-1"><label align="text-left">Total Cost</label></div>
		<div class = "col-sm-2"><label align="text-left">Remarks</label></div>
		<div class = "col-sm-1"><label align="text-left">Type of Disposal</label></div>
		<div class = "col-sm-1"><label align="text-left">Apprasied Value</label></div>

		</div>
		
	

           </div>

        <div class="panel-body">

          	<!-- Input for Repeating Section -->
			<table id="myTable" class=" table order-list">
			    
			    <tbody>
			        <tr>
					<td width="5%">
			                <div><input type="text"  size="10" name="EquipmentType" align= "text-center" placeholder="Equipment Type"></textarea></div>
			            </td>
			            <td width="5%">
			                <div><input style="width:130px;" type="Date" name ="DateAcquired" align= "text-center" placeholder=""></div>
			            </td>
						
			            <td width="5%">
			                <div><input type="text"  size="12" name="Particulars" align= "text-center" placeholder="Particulars/Articles"></textarea></div>
			            </td>
			            <td width="5%">
			                <div><input type="text"  size="7" name="PropertyNum" align= "text-center" placeholder="Property No."></div>
			            </td>
			            <td width="5%">
			                <div><input type="text" size="5"  name="Quantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
						<td width="5%">
			                <div><input type="text" size="10" name="UnitCost" align= "text-center" placeholder="Unit Cost"></div>
			            </td>
			            <td width="5%">
			                <div><input type="text"  size="10"name="TotalCost" align= "text-center" placeholder="Total Cost"></div>
			            </td>
			            <td width="18%">
			                <div><textarea type="text"  size="20" name="Remarks" align= "text-center" placeholder="Remarks"></textarea></div>
			            </td>
						 <td width="5%">
			                <div><input type="text"  size="11" name="TypeOfDisposal" align= "text-center" placeholder="Type of Disposal"></div>
			            </td>
			            <td width="5%">
			                <div><input type="text"  name="AppraisedValue" align= "text-center" placeholder="Appraised Value"></textarea></div>
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
							

					        cols += '<td><input type="text" size="10" placeholder="Equipment Type" name="EquipmentType' + counter + '"/></td>';
					        cols += '<td><Input type="date"  placeholder="" 	name="DateAcquired' 		   + counter + '"/></td>';
					        cols += '<td><input type="text" size="12" placeholder="Particulars/Articles"  name="Particulars' + counter + '"/></td>';
					       	cols += '<td><input type="text"size="7"  placeholder="Property No." 	name="PropertyNum' 	   + counter + '"/></td>';
						    cols += '<td><input type="text"size="5"  placeholder="Quantity" 	name="Quantity' 	   + counter + '"/></td>';
							cols += '<td><input type="text" size="10" placeholder="Unit Cost" 	name="UnitCost' 		   + counter + '"/></td>';
					        cols += '<td><input type="text" size="10" placeholder="Total Cost"  name="TotalCost' + counter + '"/></td>';
					        cols += '<td><textarea type="text" size="20" placeholder="Remarks" 	name="Remarks' 	   + counter + '"/></td>';
					        cols += '<td><input type="text" size="11" placeholder="Type of Disposal" 	name="TypeOfDisposal' 		   + counter + '"/></td>';
					        cols += '<td><textarea type="text" placeholder="Appraised Value"  name="AppraisedValue' + counter + '"/></td>';
					        
							
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
		<!--Inspection -->
	
			
			<!--Inspection -->
		<div class = "panel-heading panel-heading-custom">
			<div class= "row">
			    <div class="col-sm-2"><label align= "text-center"></label></div>
			
			</div>
		</div>
			
			
			<div class="panel-body">
						<div class= "row">
			    <div class="col-sm-7"><label align= "text-center">I hereby request inspection and disposition, pursuant to Section 79 of PD 1445, of the property enumerated above.</label></div>
		
			</div>
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class="row">
			
			<div class="col-sm-2"><label align= "text-center">Requested By:</label></div>
			
			 <!-- Blank text for spacing --> 
              <div class="col-sm-3"><label align= "text-center"></label></div>
			  
			  <div class="col-sm-2"><label align= "text-center">Approved By:</label></div>
			 
			</div>
			
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

		    <div class = "row">
			
              <div class="col-sm-2"><label align= "text-center"><b></b></label></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  		  
			  
			 </div>
           
		
			
			
			<div class = "row">
			
              <div class="col-sm-2"><label align= "text-center">Name:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name of checker:"></div>
              
			  
			   <!-- Blank text for spacing --> 
              <div class="col-sm-1"><label align= "text-center"></label></div>
			  
			  <div class="col-sm-2"><label align= "text-center">Name:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name of checker:"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  
			  
			
		</div>
		<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			<div class = "row">
			
			<div class="col-sm-2"><label align= "text-center">Designation:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Position of Signatory"></div>
            
			  
			   <!-- Blank text for spacing --> 
              <div class="col-sm-1"><label align= "text-center"></label></div>
			 <div class="col-sm-2"><label align= "text-center">Designation:</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Position of Signatory"></div>
             
			  
			  
		
			  
			  </div>
			
			

		</div>
			<div class = "panel-heading panel-heading-custom">
			<div class= "row">
			    <div class="col-sm-2"><label align= "text-left"></label></div>
			</div>
		</div>

		<div class="panel-body">
		
		<div class= "row">
			    <div class="col-sm-10"><label align= "text-center">I CERTIFY  that I have inspected each and every article enumerated in this report, and this the disposition made thereof was, in my judgement, the best for the public interest</label></div>
		
			</div>
		
				
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
			

			<div class = "panel-heading panel-heading-custom">
			<div class= "row">
			    <div class="col-sm-2"><label align= "text-left"></label></div>
			</div>
		</div>

		<div class="panel-body">
		    <div class = "row">
			
              <div class="col-sm-9"><label align= "text-center"><b>I CERTIFY  that I have witnessed the disposition of the articles enumerated on this </b></label></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
			  		  <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
			  
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