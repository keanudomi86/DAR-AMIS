<%-- 
    Document   : par
    Created on : 02 8, 18, 6:54:15 PM
    Author     : BavarianHotdog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | PAR</title>
  </head>

  <body>
     
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
                        PAR
                        <small>Choices</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
			<div class="container-fluid">
      <h2>DAR</h2>
      <div class="panel panel-default">

        <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Property Acknowledgement Receipt</STRONG></p></div> 
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

              <div class="col-sm-2"><label align= "text-center">PAR No.</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="RIS No."></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Cluster"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              
            </div> 
            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

          </div>

        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
            <div class= "row seven-cols">
              <div class="col-sm-2"><label align= "text-center">Quantity.</label></div>
              <div class="col-sm-2"><label align= "text-center">Unit</label></div>
              <div class="col-sm-2"><label align= "text-center">Description</label></div>
              <div class="col-sm-2"><label align= "text-center">Property No.</label></div>
              <div class="col-sm-2"><label align= "text-center">Date Acquired</label></div>
              <div class="col-sm-2"><label align= "text-center">Amount</label></div>
			  
            </div>
        </div>

        <div class="panel-body">

          	<!-- Input for Repeating Section -->
			<table id="myTable" class=" table order-list">
			    
			    <tbody>
			        <tr>
			            <td>
			                <div><input type="text"  name ="Quantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="Unit" align= "text-center" placeholder="Unit"></div>
			            </td>
			            <td>
			                <div><input type="text"  size="40" name="Description" align= "text-center" placeholder="Description"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="PropertyNum" align= "text-center" placeholder="Property No."></div>
			            </td>
			            <td>
			             
              
                  <div class="input-group">
                    <!-- This comment out adds an icon at the left side of the date text-->
                    <!--<div class="input-group-addon">
                      <i class="fa fa-calendar"></i>
                    </div> -->
                   <input  id="date" name="DateAcquired" placeholder="MM/DD/YYYY" type="date">
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
							

					        cols += '<td><input type="text" placeholder="Quantity" name="Quantity' + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Unit" 	name="unit' 		   + counter + '"/></td>';
					        cols += '<td><input type="text" size="40" placeholder="Description"  name="Description' + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Property No." 	name="PropertyNum' 	   + counter + '"/></td>';
					        cols += '<td><input type="date" placeholder="MM/DD/YYYY" id="date" name="DateAcquired'  + counter + '"/></td>';
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
              <div class="col-sm-2"><label align= "text-left">Received By</label></div>
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

              <div class="col-sm-2"><label align= "text-center">Position</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Position"></div>
            </div>
			<!-- Blank Row -->
        	<div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Office</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Office"></div>
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
        </div> 


        <!-- P5 -->
        <!-- Approved by -->
        <div class = "panel-heading panel-heading-custom">
            <div class= "row">
              <div class="col-sm-2"><label align= "text-left">Issued By</label></div>
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
              <div class="col-sm-2"><label align= "text-center">Position</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Position"></div>
            </div>            
			
			<!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Office</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Office"></div>
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
       </div>

          </div>         
        </div>
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
