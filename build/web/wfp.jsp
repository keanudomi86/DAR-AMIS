<%-- 
    Document   : wfp
    Created on : 03 19, 18, 5:09:10 PM
    Author     : BavarianHotdog
--%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | WFP</title>
  </head>
    <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }

    </style>
    <script>
        function submitWFP(){
            if(confirm("Submit form?"))
            {
                $.post("<%=root%>/CreateWFP", $("[name='wfpForm']").serialize(), function(data){
                    alert(data);
                });
            }
        }
    </script>
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
                    <h1>Work and Financial Plan</h1>

                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>             
                  <!--<button type="submit" class="btn btn-default">Create</button>
                  <button type="submit" class="btn btn-default">Edit</button>
                  <button type="submit" class="btn btn-default">View List</button> -->
                 
                 <div class="container-fluid">
                    <div class="panel panel-default">
                        <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Quarterly Budget</STRONG></p></div> 

                        <form name="wfpForm">
                          <!-- P1 -->
                          
                          <!-- P2 --> 
                          <div class = "panel-heading panel-heading-custom">
                              <div class= "row">
                                  <div class = "row">
                                      <div class="col-sm-3">
                                          <label align= "text-center"></label>
                                      </div>
                                  </div>
                              </div>


                              <div class= "row">
                                <div class="col-sm-2"><label align= "text-center">Object of Expenditure</label></div>
                                <div class="col-sm-2"><label align= "text-center">Q1</label></div>
                                <div class="col-sm-2"><label align= "text-center">Q2</label></div>
                                <div class="col-sm-2"><label align= "text-center">Q3</label></div>
                                <div class="col-sm-2"><label align= "text-center">Q4</label></div>
                                <div class="col-sm-2"><label align= "text-center">Total Budget</label></div>
                              </div>
                          </div>

                          <div class="panel-body">

                                  <!-- Input for Repeating Section -->
                                          <table id="myTable" class=" table order-list">

                                              <tbody>
                                                  <tr>

                                                      <td width="30%">
                                                          <select name="obj" class="form-control">
                                                              <option>Supplies & Materials</option>
                                                              <option>Assets</option>
                                                          </select>
                                                      </td>
                                                      <td width="15%">
                                                          <div><input type="text"  size="15" name="q1" align= "text-center" placeholder="Q1"></div>
                                                      </td>
                                                      <td width="17%">
                                                          <div><input type="text"  size="15" name="q2" align= "text-center" placeholder="Q2"></div>
                                                      </td>
                                                      <td width="17%">
                                                          <div><input type="text"  size="15" name="q3" align= "text-center" placeholder="Q3"></div>
                                                      </td>
                                                      <td width="20%">
                                                          <div><input type="text"  size="15" name="q4" align= "text-center" placeholder="Q4"></div>
                                                      </td>
                                                      <td width="15%">
                                                          <div><input type="text"  size="15" name="total_qty" align= "text-center" placeholder="Total Quantity"></div>
                                                      </td>
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
                                                          <script>
                                                          $(document).ready(function () {
                                                              var counter = 0;

                                                              $("#addrow").on("click", function () {
                                                                  var newRow = $("<tr>");
                                                                  var cols = "";


                                                                  cols += '<td width="30%"><div><select name="obj" class="form-control"><option>Supplies & Materials</option><option>Assets</option></select></td>'+ counter + '"/></td>';
                                                                  cols += '<td width="15%"><div><input size="15" type="text" placeholder="Q1" name="q1"/></div></td>';
                                                                  cols += '<td width="17%"><div><input size="15" type="text" placeholder="Q2" name="q2"/></div></td>';
                                                                  cols += '<td width="17%"><div><input size="15" type="text" placeholder="Q3" name="q3"/></div></td>';
                                                                  cols += '<td width="20%"><div><input size="15" type="text" placeholder="Q4" name="q4"/></div></td>';
                                                                  cols += '<td width="15%"><div><input size="15" type="text" placeholder="Total Quantity" name="total_qty"/></div></td>';
                                                                  cols += '<td><div class="ibtnDel">&times;</div></td></tr>';
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
                        </form>


                        
                        <p class="text-center"><button class="btn btn-default" onclick="submitWFP()">Submit</button></p>
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

