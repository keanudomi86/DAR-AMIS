<%-- 
    Document   : app
    Created on : 03 19, 18, 5:09:10 PM
    Author     : BavarianHotdog
--%>

<%List<String> offices = (List<String>)request.getAttribute("offices");%>
<%String root = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="WEB-INF/header.jsp" /> 
    <title>DAR-AMIS | APP</title>
  </head>
    <style>
      .panel-default > .panel-heading-custom{

        background-color: #10572b;
        color: #ffffff ;     
      }

    </style>
    <script>
        function submitAPP(){
            alert($("[name='appForm']").serialize());
            
            if(confirm("Submit form?"))
            {
                $.post("<%=root%>/CreateAPP", $("[name='appForm']").serialize(), function(data){
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
                    <h1>Annual Procurement Plan</h1>
                        <h4 class="text-right text-bold"><div name="curDate">00:00:00</div></h4> 
                        <h4 class="text-right text-bold"><div name="curTime">00:00:00</div></h4>
                 <div class="container-fluid">
                    <div class="panel panel-default">

                      <!-- P1 -->
                      <div class = "panel-heading panel-heading-custom"><p class="text-center"><STRONG>Quantity Requirement</STRONG></p></div> 

                      <div>
                            <form name="appForm">
                              <!-- Input for Repeating Section -->
                                      <table id="myTable" class="table order-list">
                                          <thead class="thead-custom">
                                              <tr>
                                                  <td><label align= "text-center">Item & Specifications</label></td>
                                                  <td><label align= "text-center">Q1</label></div>
                                                  <td><label align= "text-center">Q2</label></div>
                                                  <td><label align= "text-center">Q3</label></div>
                                                  <td><label align= "text-center">Q4</label></div>
                                                  <td><label align= "text-center">Total Quantity</label></div>
                                                  <td><label align= "text-center">Price Total as of</label></div>
                                                  <td><label align= "text-center">Office</label></div>
                                                  <td></td>
                                              </tr>
                                          </thead>

                                          <tbody name="tableBody">
                                          
                                              <tr>
                                                  <td width="10%">
                                                      <div><input type="text"  size="20" name="itemspec" align= "text-center" placeholder="Item & Specifications"></div>
                                                  </td>
                                                  <td width="10%">
                                                      <div><input type="text"  size="10" name="q1" align= "text-center" placeholder="Q1"></div>
                                                  </td>
                                                  <td width="10%">
                                                      <div><input type="text"  size="10" name="q2" align= "text-center" placeholder="Q2"></div>
                                                  </td>
                                                  <td width="10%">
                                                      <div><input type="text"  size="10" name="q3" align= "text-center" placeholder="Q3"></div>
                                                  </td>
                                                  <td width="10%">
                                                      <div><input type="text"  size="10" name="q4" align= "text-center" placeholder="Q4"></div>
                                                  </td>
                                                  <td width="10%">
                                                      <div><input type="text"  size="15" name="tq" align= "text-center" placeholder="Total Quantity"></div>
                                                  </td>
                                                  <td width="10%">
                                                      <div><input type="text"  size="15" name="pt" align= "text-center" placeholder="Price Total as of "></div>
                                                  </td>
                                                  <td width="10%">
                                                      <div>
                                                          <select name="office">
                                                              <%if(offices != null && offices.size() != 0) {%>
                                                              <%for(String s: offices){%>
                                                                  <option><%=s%></option>
                                                                  <%}%>
                                                              <%}%>
                                                          </select>
                                                      </div>
                                                  </td>
                                                  <td>
                                                      <a class="deleteRow"></a>
                                                  </td>
                                              </tr>
                                          </tbody>
                                          <tfoot>
                                              <tr>
                                                  <td colspan="10" style="text-align: left;">
                                                      <input type="button" class="btn btn-lg btn-block " id="addrow" value="Add Row" />
                                                  </td>
                                              </tr>
                                          </tfoot>
                                      </table>
                            </form>
                                                      <!-- Repeating section script for JS -->
                                                      <script>
                                                      $(document).ready(function () {
                                                          var counter = 0;

                                                          $("#addrow").on("click", function () {
                                                              var newRow = $("<tr>");
                                                              var cols = "";


                                                              cols += '<td width="10%"><div><input type="text"  size="20" name="itemspec" align= "text-center" placeholder="Item & Specifications"></div></td>';
                                                              cols += '<td width="10%"><div><input type="text"  size="10" name="q1" align= "text-center" placeholder="Q1"></div></td>';
                                                              cols += '<td width="10%"><div><input type="text"  size="10" name="q2" align= "text-center" placeholder="Q2"></div></td>';
                                                              cols += '<td width="10%"><div><input type="text"  size="10" name="q3" align= "text-center" placeholder="Q3"></div></td>';
                                                              cols += '<td width="10%"><div><input type="text"  size="10" name="q4" align= "text-center" placeholder="Q4"></div></td>';
                                                              cols += '<td width="10%"><div><input type="text"  size="15" name="tq" align= "text-center" placeholder="Total Quantity"></div></td>';
                                                              cols += '<td width="10%"><div><input type="text"  size="15" name="pt" align= "text-center" placeholder="Price Total as of "></div></td>';
                                                              cols += '<td width="10%"><div><select name="office"><%for(String s: offices){%><option><%=s%></option><%}%></select></div></td>';

                                                              cols += '<td><div class="ibtnDel">&times;</div></td></tr>';
                                                              newRow.append(cols);
                                                              
                                                              $("[name='tableBody']").append(newRow);
                                                              counter++;
                                                          });



                                                          $("table.order-list").on("click", ".ibtnDel", function (event) {
                                                               $("[name='tableBody'] > tr").last().remove();       
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
                           <p class="text-center"><button class="btn btn-default" onclick="submitAPP()">Submit</button></p>         
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

