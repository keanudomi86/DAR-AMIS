<%-- 
    Document   : po
    Created on : 02 8, 18, 7:51:34 PM
    Author     : BavarianHotdog
--%>
<%@page import="dao.PrDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Pr"%>
<%Pr pr = (Pr)request.getAttribute("pr");%>
<%String root = request.getContextPath();%>
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
    <script>
        function createPO(){
            if(confirm("Submit this form?")){
                url = "<%=root%>/CreatePO";
                $.post(url, $("#poForm").serialize(), function(data){
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
      
         <section id="main-content">
          <section class="wrapper">
              <section class="content-header">
                  <form id="poForm">
                    <h1>
                        Purchase Order - Form
                        <small>Choices</small>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                    </h1>
                  <div class="container-fluid">
                      <a href="/DAR-AMIS/CreateForms" class="previous" align="left">&laquo; Previous</a>
        <script>
            function submitPO(){
                if(confirm("Submit this form?")){

                    $.post("<%=root%>/CreatePO", $("#createPoForm").serialize(), function(data){
                        alert(data);
                        
                        //redirect to approve forms page
                        window.location = "<%=root%>/CreateForms";
                    });
                }
            }
        </script>
                <div class="panel panel-default">
                    
                        <!-- P1 -->
                        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Purchase Order</STRONG></p></div> 
                            <div class="panel-body"> 
                            <!-- First Row -->
                            <div class = "row">

                              <div class="col-sm-2"><label align= "text-center">Entity Name</label></div>              

                              <!-- Entity Name Dropdown -->
                              <div class="col-sm-2">
                                  <input type="text" value="<%=pr.getEntityName()%>" class="form-control" name="entityName">
                                </div> 
                              <!-- Entity Name Dropdown script for JS-->


                              <!-- Blank text for spacing --> 
                              <div class="col-sm-2"><label align= "text-center"></label></div>              

                              <div class="col-sm-2"><label align= "text-center">PR Reference No.</label></div>
                              <div class="col-sm-2"><input type="text"  value="<%=pr.getIdPr()%>" align= "text-center" name="prID" placeholder="PR Reference No."></div>

                            </div> 

                            <!-- Blank Row -->
                            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                            <!-- Second Row -->
                            <div class = "row">

                              <div class="col-sm-2"><label align= "text-center">Supplier</label></div>
                              <div class="col-sm-2"><input name="supplier" type="text"  align= "text-center" placeholder="Supplier"></div>
                              <div class="col-sm-2"><label align= "text-center"></label></div>

                              <!-- Date -->
                              <div class="col-sm-2"><label align= "text-center">Date</label></div>
                              <div class="col-sm-2">
                                  
                                  <div class="input-group">
                                    <!-- This comment out adds an icon at the left side of the date text-->
                                    <!--<div class="input-group-addon">
                                      <i class="fa fa-calendar"></i>
                                    </div> -->
                                    <script>
                                        $(document).ready(function(){
                                            var today = new Date();
                                            
                                            $("[name='datePosted']").val(today.getMonth()+1 + "/" + today.getDate() + "/" + today.getFullYear());
                                        });
                                    </script>
                                   <input class="form-control" id="date" name="datePosted" placeholder="MM/DD/YYYY" type="text">
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
                              <div class="col-sm-2"><input name="address" type="text"  align= "text-center" placeholder="Address"></div>
                              <div class="col-sm-2"><label align= "text-center"></label></div>

                              <div class="col-sm-2"><label align= "text-center">Mode of Procurement</label></div>
                              <div class="col-sm-2"><input name="mode" type="text"  align= "text-center" placeholder="Mode of Procurement"></div>

                            </div> 

                            <!-- Blank Row -->
                            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                            <!-- Fourth Row -->
                            <div class = "row">

                              <div class="col-sm-2"><label align= "text-center">TIN</label></div>
                              <div class="col-sm-2"><input name="tin" type="text"  align= "text-center" placeholder="TIN"></div>
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
                            <div class="col-sm-4"><textarea name="gentlemen" rows="3" cols="170" placeholder="Gentlemen"></textarea> </div>              
                        </div>     
                      </div>

                      <div class="panel-body">
                          <!-- First Row -->
                          <div class= "row">
                            <div class="col-sm-2"><label align= "text-center">Place of Delivery</label></div>
                              <div class="col-sm-2"><input name="place_delivery" type="text"  align= "text-center" placeholder="Place of Delivery"></div>
                              <div class="col-sm-2"><label align= "text-center"></label></div>

                              <div class="col-sm-2"><label align= "text-center">Mode of Procurement</label></div>
                              <div class="col-sm-2"><input name="mode2" type="text"  align= "text-center" placeholder="Mode of Procurement"></div>  
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
                                   <input class="form-control" id="date" name="date_delivery" placeholder="MM/DD/YYYY" type="text">
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
                              <div class="col-sm-2"><input name="pay_term" type="text"  align= "text-center" placeholder="Payment Term"></div>  

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
                                                <%for(PrDetails details: pr.getPrDetailsList()){%>
                                                    <tr>
                                                        <td>
                                                            <div><input type="text"  name ="stock_no" align= "text-center" value="<%=details.getIdPrDetails()%>" placeholder="Stock Property No"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="unit" align= "text-center" placeholder="Unit" value="<%=details.getUnit()%>"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="description" align= "text-center" placeholder="Description" value="<%=details.getDescription()%>"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="quantity" align= "text-center" placeholder="Quantity" value="<%=details.getQuantity()%>"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="cost" align= "text-center" placeholder="Unit Cost" value="<%=details.getUnitCost()%>"></div>
                                                        </td>
                                                        <td>
                                                            <div><input type="text"  name="total_cost" align= "text-center" placeholder="Amount" value="<%=details.getQuantity() * details.getTotalCost()%>"></div>
                                                        </td>
                                                    </tr>
                                                <%}%>
                                            </tbody>
                                        </table>



                                                    <div class= "row">
                                                      <div class="col-sm-2"><label align= "text-center">Total Amount in Words</label></div>
                                                        <div class="col-sm-4">
                                                            <textarea name="amount_words" rows="1" cols="130" placeholder="Total Amount in Words"></textarea> 
                                                        </div>

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
                                    <div class="col-sm-2"><input name="name_conforme" type="text"  align= "text-center" placeholder="Name"></div>                    

                                    <!-- Blank text for spacing --> 
                                    <div class="col-sm-2"><label align= "text-center"></label></div>              

                                    <div class="col-sm-2"><label align= "text-center">Name</label></div>
                                    <div class="col-sm-2"><input name="name_truly" type="text"  align= "text-center" placeholder="Name"></div>

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
                                         <input class="form-control" id="date" name="date2" placeholder="MM/DD/YYYY" type="text">
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
                                    <div class="col-sm-2"><input name="payment_term" type="text"  align= "text-center" placeholder="Payment Term"></div>  

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
                              <div class="col-sm-2"><input name="fund_cluster" value="<%=pr.getFundCluster()%>" type="text"  align= "text-center" placeholder="Fund Cluster"></div>
                              <div class="col-sm-2"><label align= "text-center"></label></div>

                              <div class="col-sm-2"><label align= "text-center">ORS/BURS No</label></div>
                              <div class="col-sm-2"><input name="ors/burs_no" type="text"  align= "text-center" placeholder="ORS/BURS No"></div>
                            </div>

                                <!-- Blank Row -->
                                <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                            <div class = "row">

                              <div class="col-sm-2"><label align= "text-center">Fund Available</label></div>
                              <div class="col-sm-2"><input name="fund_avail" type="text"  align= "text-center" placeholder="Fund Available"></div>
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
                                         <input class="form-control" id="date" name="date_ors/burs" placeholder="MM/DD/YYYY" type="text">
                                        </div>
                                       </div>
                            </div>

                            <!-- Blank Row -->
                            <div class = "row"><div class="col-sm-2"><label align= "text-center"> </label></div></div>

                            <div class = "row">
                              <div class="col-sm-2"><label align= "text-center">Name</label></div>
                              <div class="col-sm-2"><input name="name_req" type="text"  align= "text-center" placeholder="Name"></div>
                              <div class="col-sm-2"><label align= "text-center"></label></div>

                              <div class="col-sm-2"><label align= "text-center">Amount</label></div>
                              <div class="col-sm-2"><input name="amount2" type="text"  align= "text-center" placeholder="Amount"></div>
                            </div>
                            <br>
                            <br>
                            <p align="center">                         
                                <button onclick="submitPO()">Submit</button>
                            </p>
                        </div> 
                          </div>
                        </div>
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

