<%-- 
    Document   : po
    Created on : 02 8, 18, 7:51:34 PM
    Author     : BavarianHotdog
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Office"%>
<%ArrayList<Office> offices = (ArrayList<Office>)request.getAttribute("offices");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | PO</title>
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
                        Purchase Order - Form
                        <small>Choices</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                  <div class="container-fluid">
                <div class="panel panel-default">

        <!-- ...................APPROVE FORM................................................................. -->
                <!-- P1 -->
        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Purchase Order</STRONG></p></div> 
            <div class="panel-body">
                <%if(session.getAttribute("formMode").equals("approve")){%>
                <form>
            <!-- First Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

              <!-- Entity Name Dropdown -->
                              <div class="col-sm-2">
                               <div class="btn-group">
                                <select class="form-control" name="entity">
                                    <option>Entity</option>
                                </select>
                              </div>
                              </div> 
             
              <!-- Entity Name Dropdown script for JS-->
              
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

              <div class="col-sm-2"><label align= "text-center">PO No.</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="PR No."></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Supplier</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Supplier"></div>
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

              <div class="col-sm-2"><label align= "text-center">Address</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Address"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Mode of Procurement</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Mode of Procurement"></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Fourth Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">TIN</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="TIN"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

          </div>

      <!-- P2 -->
      <!--Gentlemen -->
      <div class = "panel-heading panel-heading-custom">
        <div class= "row">
            <div class="col-sm-2"><label align= "text-left">Gentlemen</label></div>
        </div>
      </div>

      <div class="panel-body">
          <div class= "row">
            <div class="col-sm-4"><textarea rows="3" cols="170" placeholder="Gentlemen"></textarea> </div>              
        </div>     
      </div>

      <div class="panel-body">
          <!-- First Row -->
          <div class= "row">
            <div class="col-sm-2"><label align= "text-center">Place of Delivery</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Place of Delivery"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
              
              <div class="col-sm-2"><label align= "text-center">Mode of Procurement</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Mode of Procurement"></div>  
            </div>

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

          <!-- Second Row -->
          <div class= "row">
            <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Date of Delivery</label></div>
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

              <div class="col-sm-2"><label align= "text-center"></label></div>
              
              <div class="col-sm-2"><label align= "text-center">Payment Term</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Payment Term"></div>  

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

        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
            <div class= "row">
              <div class="col-sm-2"><label align= "text-center">Stock Property No.</label></div>
              <div class="col-sm-2"><label align= "text-center">Unit</label></div>
              <div class="col-sm-2"><label align= "text-center">Description</label></div>
              <div class="col-sm-2"><label align= "text-center">Quantity</label></div>
              <div class="col-sm-2"><label align= "text-center">Unit Cost</label></div>
              <div class="col-sm-2"><label align= "text-center">Amount</label></div>
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
			                <div><input type="text"  name="itemDescription" align= "text-center" placeholder="Description"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="quantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="unitCost" align= "text-center" placeholder="Unit Cost"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="totalCost" align= "text-center" placeholder="Amount"></div>
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
					        cols += '<td><input type="text" placeholder="Unit" 				      name="unit' 		       + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Description"       name="description'     + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Quantity" 			    name="quantity' 	     + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Unit Cost" 		    name="unitCost' 	     + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Amount" 		        name="totalCost' 	     + counter + '"/></td>';

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
			              <div class="col-sm-2"><label align= "text-center">Total Amount in Words</label></div>
                    <div class="col-sm-4"><textarea rows="1" cols="148" placeholder="Total Amount in Words"></textarea> </div>
			              
			            </div>
			          </div>

		    <!-- P3 -->
      		<!--Letter -->
      		<div class = "panel-heading panel-heading-custom">
      			<div class= "row">
      			    <div class="col-sm-2"><label align= "text-left"> </label></div>
      			</div>
      		</div>

      		<div class="panel-body">
      		    <div class= "row">
      			    <div class="col-sm-12"><label align= "text-center">In case of failure to make the full delivery within the time specified above, a penalty of one-tenth (1/10) of one percent for every day shae be imposed on the undelivered item/s. </label></div>
      			    </div>     
      		</div>
  

          <div class="panel-body">

            <div class = "row">

                    <div class="col-sm-2"><label align= "text-center">Conforme</label></div>              
                    <div class="col-sm-2"><label align= "text-center"></label></div>                   

                    <!-- Blank text for spacing --> 
                    <div class="col-sm-2"><label align= "text-center"></label></div>              

                    <div class="col-sm-2"><label align= "text-center">Very yours Truly,</label></div>
                    <div class="col-sm-2"><label align= "text-center"></label></div> 

             </div> 

             <!-- Blank Row -->
                  <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">

                    <div class="col-sm-2"><label align= "text-center">Name</label></div>              
                    <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>                    

                    <!-- Blank text for spacing --> 
                    <div class="col-sm-2"><label align= "text-center"></label></div>              

                    <div class="col-sm-2"><label align= "text-center">Name</label></div>
                    <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>

             </div> 

                  <!-- Blank Row -->
                  <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                  <!-- Second Row -->
                  <div class= "row">
                  <!-- Date -->
                    <div class="col-sm-2"><label align= "text-center">Date of Delivery</label></div>
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

                    <div class="col-sm-2"><label align= "text-center"></label></div>
                    
                    <div class="col-sm-2"><label align= "text-center">Payment Term</label></div>
                    <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Payment Term"></div>  

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
              <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Cluster"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">ORS/BURS No</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="ORS/BURS No"></div>
            </div>

        	<!-- Blank Row -->
        	<div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Fund Available</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Available"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Date of ORS/BURS No</label></div>
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
            </div>

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Name</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Amount</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Amount"></div>
            </div>
        </div> 

          </div>         
        </div>
                       <!-- .............CREATE FORM...............................................................................--> 
                <%}else if(session.getAttribute("formMode").equals("create")){%> 
                
                <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Purchase Order</STRONG></p></div> 
            <div class="panel-body">
                <%if(session.getAttribute("formMode").equals("approve")){%>
                <form>
            <!-- First Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

              <!-- Entity Name Dropdown -->
                              <div class="col-sm-2">
                               <div class="btn-group">
                                <select class="form-control" name="entity">
                                    <option>Entity</option>
                                </select>
                              </div>
                              </div> 
             
              <!-- Entity Name Dropdown script for JS-->
              
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

              <div class="col-sm-2"><label align= "text-center">PO No.</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="PR No."></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Second Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Supplier</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Supplier"></div>
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

              <div class="col-sm-2"><label align= "text-center">Address</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Address"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Mode of Procurement</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Mode of Procurement"></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <!-- Fourth Row -->
            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">TIN</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="TIN"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

            </div> 

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

          </div>

      <!-- P2 -->
      <!--Gentlemen -->
      <div class = "panel-heading panel-heading-custom">
        <div class= "row">
            <div class="col-sm-2"><label align= "text-left">Gentlemen</label></div>
        </div>
      </div>

      <div class="panel-body">
          <div class= "row">
            <div class="col-sm-4"><textarea rows="3" cols="170" placeholder="Gentlemen"></textarea> </div>              
        </div>     
      </div>

      <div class="panel-body">
          <!-- First Row -->
          <div class= "row">
            <div class="col-sm-2"><label align= "text-center">Place of Delivery</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Place of Delivery"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>
              
              <div class="col-sm-2"><label align= "text-center">Mode of Procurement</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Mode of Procurement"></div>  
            </div>

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

          <!-- Second Row -->
          <div class= "row">
            <!-- Date -->
              <div class="col-sm-2"><label align= "text-center">Date of Delivery</label></div>
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

              <div class="col-sm-2"><label align= "text-center"></label></div>
              
              <div class="col-sm-2"><label align= "text-center">Payment Term</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Payment Term"></div>  

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

        <!-- P2 --> 
        <div class = "panel-heading panel-heading-custom">
            <div class= "row">
              <div class="col-sm-2"><label align= "text-center">Stock Property No.</label></div>
              <div class="col-sm-2"><label align= "text-center">Unit</label></div>
              <div class="col-sm-2"><label align= "text-center">Description</label></div>
              <div class="col-sm-2"><label align= "text-center">Quantity</label></div>
              <div class="col-sm-2"><label align= "text-center">Unit Cost</label></div>
              <div class="col-sm-2"><label align= "text-center">Amount</label></div>
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
			                <div><input type="text"  name="itemDescription" align= "text-center" placeholder="Description"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="quantity" align= "text-center" placeholder="Quantity"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="unitCost" align= "text-center" placeholder="Unit Cost"></div>
			            </td>
			            <td>
			                <div><input type="text"  name="totalCost" align= "text-center" placeholder="Amount"></div>
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
					        cols += '<td><input type="text" placeholder="Unit" 				      name="unit' 		       + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Description"       name="description'     + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Quantity" 			    name="quantity' 	     + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Unit Cost" 		    name="unitCost' 	     + counter + '"/></td>';
					        cols += '<td><input type="text" placeholder="Amount" 		        name="totalCost' 	     + counter + '"/></td>';

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
			              <div class="col-sm-2"><label align= "text-center">Total Amount in Words</label></div>
                    <div class="col-sm-4"><textarea rows="1" cols="148" placeholder="Total Amount in Words"></textarea> </div>
			              
			            </div>
			          </div>

		    <!-- P3 -->
      		<!--Letter -->
      		<div class = "panel-heading panel-heading-custom">
      			<div class= "row">
      			    <div class="col-sm-2"><label align= "text-left"> </label></div>
      			</div>
      		</div>

      		<div class="panel-body">
      		    <div class= "row">
      			    <div class="col-sm-12"><label align= "text-center">In case of failure to make the full delivery within the time specified above, a penalty of one-tenth (1/10) of one percent for every day shae be imposed on the undelivered item/s. </label></div>
      			    </div>     
      		</div>
  

          <div class="panel-body">

            <div class = "row">

                    <div class="col-sm-2"><label align= "text-center">Conforme</label></div>              
                    <div class="col-sm-2"><label align= "text-center"></label></div>                   

                    <!-- Blank text for spacing --> 
                    <div class="col-sm-2"><label align= "text-center"></label></div>              

                    <div class="col-sm-2"><label align= "text-center">Very yours Truly,</label></div>
                    <div class="col-sm-2"><label align= "text-center"></label></div> 

             </div> 

             <!-- Blank Row -->
                  <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">

                    <div class="col-sm-2"><label align= "text-center">Name</label></div>              
                    <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>                    

                    <!-- Blank text for spacing --> 
                    <div class="col-sm-2"><label align= "text-center"></label></div>              

                    <div class="col-sm-2"><label align= "text-center">Name</label></div>
                    <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>

             </div> 

                  <!-- Blank Row -->
                  <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                  <!-- Second Row -->
                  <div class= "row">
                  <!-- Date -->
                    <div class="col-sm-2"><label align= "text-center">Date of Delivery</label></div>
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

                    <div class="col-sm-2"><label align= "text-center"></label></div>
                    
                    <div class="col-sm-2"><label align= "text-center">Payment Term</label></div>
                    <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Payment Term"></div>  

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
              <div class="col-sm-2"><label align= "text-center">Fund Cluster</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Cluster"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">ORS/BURS No</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="ORS/BURS No"></div>
            </div>

        	<!-- Blank Row -->
        	<div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">

              <div class="col-sm-2"><label align= "text-center">Fund Available</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Fund Available"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Date of ORS/BURS No</label></div>
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
            </div>

            <!-- Blank Row -->
            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

            <div class = "row">
              <div class="col-sm-2"><label align= "text-center">Name</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Name"></div>
              <div class="col-sm-2"><label align= "text-center"></label></div>

              <div class="col-sm-2"><label align= "text-center">Amount</label></div>
              <div class="col-sm-2"><input type="text"  align= "text-center" placeholder="Amount"></div>
            </div>
        </div>
        
            <button name="submit" type="submit" value="submit">Submit</button>
                </form>

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

