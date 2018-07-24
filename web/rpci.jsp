<%-- 
    Document   : rpci
    Created on : 03 19, 18, 1:33:31 PM
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
                        Report for Physical Count and Inventory
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                 <div class="container-fluid">

                    <div class="panel panel-default">

                      <!-- P1 -->
                      <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Report on Physical Count of Inventories</STRONG></p></div> 
                          <div class="panel-body"> 
                          <!-- First Row -->


                              <div class= "row"> 
                                 <div class="col-md-2"><label>Type of Inventory Item: </label></div>
                                    <div class="col-md-2"><input type="text" class="form-control" placeholder="Type of Inventory Item"></div>
                                    <div class="col-md-2"><label></label></div>
                                     <div class="col-md-2"><label></label></div>
                                    <div class="col-md-2"><label>Date: </label></div>
                                     <div class="col-md-2"><input type="date" class="form-control" placeholder="Date"></div>
                              </div>

                            <!-- Blank Row -->
                             <div class = "row"><div class="col"><label> </label></div></div> 

                             <div class = "row"><div class="col"><label> </label></div></div> 


                            <div class = "row">

                              <div class="col-md-2"><label>Fund Cluster</label></div>              
                               <div class="col-md-2"><input type="text"  class="form-control" placeholder="Fund Cluster"></div>

                            </div> 

                          <!-- Blank Row -->
                          <div class = "row"><div class="col-sm-2"><label> </label></div></div>

                          <!-- Second Row -->
                          <div class = "row">
                            <div class="col-md-2"><label align= "text-center">For which:</label></div>
                            <div class="col-md-2"><input type="text"  class="form-control" placeholder="Accountable officer"></div>
                            <div class="col-md-2"><input type="text"  class="form-control" placeholder=" Office Designation"></div>
                            <div class="col-md-2"><input type="text"  class="form-control" placeholder=" Entity Name"></div>
                          </div>
                          
                          <div class = "row"><div class="col-sm-2"><label> </label></div></div>
                          <div class = "row"><div class="col-sm-2"><label> </label></div></div>
                          
                          <div class = "row">
                            <div class="col-md-8"><label>This person is accountable, having assumed such accountability on:</label></div>
                          </div>      
                          
                          <div class = "row">
                            <div class="col-md-2"><label>Date:</label></div>
                            <div class="col-md-2"><input type="date" class="form-control" placeholder="Date"></div>
                          </div>   
                          
                          




              </div>


                      <!-- P2 --> 
                      <div class = "panel-heading panel-heading-custom">
                              <div class= "row">

                              <div class = "row"><div class="col-sm-2"><label align= "text-center"></label></div></div>

                          <div class="row"><div class="col-sm-3"><label align="text-center"></label></div>		
                                      <div class="col-sm-3"><label align="text-center"></label></div>

                                      <div class="col-sm-1"><label align="text-center"></label>Balance per card</div></label>
                                      <div class="col-sm-1"><label align="text-center"> <label>On hand per count</div></label>
                                      <div class="col-sm-1"><label align="text-center"> <label>Shortage/Overage</div></label>
                                      </div>

                              <div class = "col-sm-1"><label align="text-left">Article</label></div>
                              <div class = "col-sm-2"><label align="text-left">Description</label></div>
                              <div class = "col-sm-1"><label align="text-left">Stock No.</label></div>
                              <div class = "col-sm-2"><label align="text-left">Unit of measure</label></div>
                              <div class = "col-sm-1"><label align="text-left">Quantity</label></div>
                              <div class = "col-sm-1"><label align="text-left">Quantity</label></div>
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
                                                      <div><textarea type="text"  size="30" name="Description" align= "text-center" placeholder="Description"></textarea></div>
                                                  </td>
                                                  <td>
                                                      <div><input type="text"  size="5" name="StockNum" align= "text-center" placeholder="Stock No."></div>
                                                  </td>
                                                  <td>
                                                      <div><input type="text" size="20"  name="UnitMeasure" align= "text-center" placeholder="Unit of Measure"></div>
                                                  </td>
                                                              <td>
                                                      <div><input type="text" size="10" name="QuantityBalance" align= "text-center" placeholder="Quantity"></div>
                                                  </td>
                                                  <td>
                                                      <div><input type="text"  size="10"name="OnHandQuantity" align= "text-center" placeholder="Quantity"></div>
                                                  </td>
                                                  <td>
                                                      <div><input type="text"  size="10" name="SAQuantity" align= "text-center" placeholder="Quantity"></div>
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
                                            <br>
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
                                                              cols += '<td><textarea type="text" size="30" placeholder="Description" 	name="Description' 		   + counter + '"/></td>';
                                                              cols += '<td><input type="text" size="5" placeholder="Stock No."  name="StockNum' + counter + '"/></td>';
                                                              cols += '<td><input type="text"size="20"  placeholder="Unit of Measure" 	name="UnitMeasure' 	   + counter + '"/></td>';
                                                                      cols += '<td><input type="text" size="10" placeholder="Quantity" 	name="QuantityBalance' 		   + counter + '"/></td>';
                                                              cols += '<td><input type="text" size="10" placeholder="Quantity"  name="OnHandQuantity' + counter + '"/></td>';
                                                              cols += '<td><input type="text" size="10" placeholder="Quantity" 	name="SAQuantity' 	   + counter + '"/></td>';
                                                              cols += '<td><input type="text" size="7" placeholder="Quantity" 	name="QuantityBalance' 		   + counter + '"/></td>';
                                                              cols += '<td><textarea type="text" placeholder="Remarks"  name="Remarks' + counter + '"/></td>';


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


                                      <!--Inspection -->
                              <div class = "panel-heading panel-heading-custom">
                                      <div class= "row">
                                          <div class="col-sm-2"><label align= "text-center">Certified Correct:</label></div>

                                      </div>
                              </div>

                                      <div class="panel-body">


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
                                      <div class = "panel-heading panel-heading-custom">
                                      <div class= "row">
                                          <div class="col-sm-2"><label align= "text-left">Approved By:</label></div>
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

