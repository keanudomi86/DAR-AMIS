<%-- 
    Document   : sc
    Created on : 03 19, 18, 5:09:10 PM
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
                        Stock Card
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                 <div class="container-fluid">
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Stock Card</STRONG></p></div> 
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
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Cluster"></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Item</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Item"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Stock Number</label></div>
			  <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Stock No."></div>
              
              </div>

            

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Third Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Description</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Description"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Re-order point</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Re-order point"></div>

            </div> 
            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>
			
		   <!-- Third Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Unit of Measurement</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Unit of Measurement"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
</div>
</div>
        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
		<div class= "row">
		
		<div class = "row"><div class="col-sm-3"><label align= "text-center"></label></div></div>

            <div class="row"><div class="col-sm-1"><label align="text-center"></label></div>		
			<div class="col-sm-3"><label align="text-center"></label></div>
			
			<div class="col-sm-1"><label align="text-center">Receipt</div></label>
		    <div class="col-sm-1"><label align="text-center"> </label></div>	
			<div class="col-sm-1"><label align="text-center">Issue</div></label>
		    <div class="col-sm-2"><label align="text-center"></label></div>		
			<div class="col-sm-1"><label align="text-center">Balance</div></label>
			</div>
			</div>
            <div class= "row">
              <div class="col-sm-2"><label align= "text-center">Date</label></div>
              <div class="col-sm-2"><label align= "text-center">References</label></div>
              <div class="col-sm-1"><label align= "text-center">Quantity</label></div>
			  <div class="col-sm-1"><label align= "text-center"></label></div>
              <div class="col-sm-1"><label align= "text-center">Quantity</label></div>
              <div class="col-sm-1"><label align= "text-center">Office</label></div>
			  <div class="col-sm-1"><label align= "text-center"></label></div>
              <div class="col-sm-1"><label align= "text-center">Quantity</label></div>
			  <div class="col-sm-1"><label align= "text-center">No. of day to Consume</label></div>
            </div>
        </div>

        <div class="panel-body">

          	<!-- Input for Repeating Section -->
			<table id="myTable" class=" table order-list">
			    
			    <tbody>
			        <tr>
			            <td width="15%">
			                <div><input type="date" name ="Date" align= "text-center" placeholder="Date"></div>
			            </td>
			            <td width="18%">
			                <div><input type="text"  size="20" name="References" align= "text-center" placeholder="References"></div>
			            </td>
			            <td width="17%">
			                <div><input type="text"  size="7" name="ReceiptQuantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td width="8%">
			                <div><input type="text" size="7" name="IssueQuantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td width="17%">
			                <div><input type="text" size="15" name="IssueOffice" align= "text-center" placeholder="Office"></div>
			            </td>
			            <td width="10%">
			                <div><input type="text" size="7" name="BalanceQuantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
						<td>
			                <div><input type="text" size="8"  name="DaysToConsume" align= "text-center" placeholder=""></div>
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

					        cols += '<td><input type="date" placeholder="" name="Date' + counter + '"/></td>';
					        cols += '<td><input size="20" type="text" placeholder="References" 				name="References' 		   + counter + '"/></td>';
					        cols += '<td><input size="7" type="text" placeholder="Quantity"  name="ReceiptQuantity' + counter + '"/></td>';
					        cols += '<td><input size="7" type="text" placeholder="Quantity" 			name="IssueQuantity' 	   + counter + '"/></td>';
					        cols += '<td><input size="15" type="text" placeholder="Office" 		name="IssueOffice' 	   + counter + '"/></td>';
					        cols += '<td><input size="7"  type="text" placeholder="Quantity" 		name="BalanceQuantity' 	   + counter + '"/></td>';
							cols += '<td><input size="8" type="text" placeholder="" 		name="DaysToConsume' 	   + counter + '"/></td>';

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

