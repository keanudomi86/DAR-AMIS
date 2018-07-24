<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <jsp:include page="WEB-INF/header.jsp" />       
            <title>DAR-AMIS | Responsive Table Report</title>
  </head>

  <body>

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <body>
     <section id="container">
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.jsp" class="logo"><b>DAR-AMIS</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <!-- -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            </ul>
                    </li>
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                        </ul>
                </ul>            
                            
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="index.jsp">Logout</a></li>
            	</ul>
            </div>
        </header>
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
          	<h3><i class="fa fa-angle-right"></i> Responsive Table - Forms</h3>
		  		<div class="row mt">
			  		<div class="col-lg-12"> <!-- RPCPPE -->
                      <div class="content-panel">
                      <h4><i class="fa fa-angle-right"></i> Report of Physical Count of Plant and Property Equipment</h4>
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed">
                              <thead>
                              <tr>
                                  <th>Article</th>
                                  <th>Description</th>
                                  <th class="numeric">Property Number</th>
                                  <th class="numeric">Unit of Measure</th>
                                  <th class="numeric">Unit Value</th>
                                  <th class="numeric">QUANTITY per Property Card</th>
                                  <th class="numeric">QUANTITY per Physical Count</th>
                                  <th class="numeric">S/O Quantity</th>
                                  <th class="numeric">S/O Value</th>
                                  <th>Remarks</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td>AAC</td>
                                  <td>AUSTRALIAN AGRICULTURAL COMPANY LIMITED.</td>
                                  <td class="numeric">$1.38</td>
                                  <td class="numeric">-0.01</td>
                                  <td class="numeric">-0.36%</td>
                                  <td class="numeric">$1.39</td>
                                  <td class="numeric">$1.39</td>
                                  <td class="numeric">$1.38</td>
                                  <td class="numeric">9,395</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>AAD</td>
                                  <td>ARDENT LEISURE GROUP</td>
                                  <td class="numeric">$1.15</td>
                                  <td class="numeric">  +0.02</td>
                                  <td class="numeric">1.32%</td>
                                  <td class="numeric">$1.14</td>
                                  <td class="numeric">$1.15</td>
                                  <td class="numeric">$1.13</td>
                                  <td class="numeric">56,431</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>AAX</td>
                                  <td>AUSENCO LIMITED</td>
                                  <td class="numeric">$4.00</td>
                                  <td class="numeric">-0.04</td>
                                  <td class="numeric">-0.99%</td>
                                  <td class="numeric">$4.01</td>
                                  <td class="numeric">$4.05</td>
                                  <td class="numeric">$4.00</td>
                                  <td class="numeric">90,641</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>ABC</td>
                                  <td>ADELAIDE BRIGHTON LIMITED</td>
                                  <td class="numeric">$3.00</td>
                                  <td class="numeric">  +0.06</td>
                                  <td class="numeric">2.04%</td>
                                  <td class="numeric">$2.98</td>
                                  <td class="numeric">$3.00</td>
                                  <td class="numeric">$2.96</td>
                                  <td class="numeric">862,518</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>ABP</td>
                                  <td>ABACUS PROPERTY GROUP</td>
                                  <td class="numeric">$1.91</td>
                                  <td class="numeric">0.00</td>
                                  <td class="numeric">0.00%</td>
                                  <td class="numeric">$1.92</td>
                                  <td class="numeric">$1.93</td>
                                  <td class="numeric">$1.90</td>
                                  <td class="numeric">595,701</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>ABY</td>
                                  <td>ADITYA BIRLA MINERALS LIMITED</td>
                                  <td class="numeric">$0.77</td>
                                  <td class="numeric">  +0.02</td>
                                  <td class="numeric">2.00%</td>
                                  <td class="numeric">$0.76</td>
                                  <td class="numeric">$0.77</td>
                                  <td class="numeric">$0.76</td>
                                  <td class="numeric">54,567</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>ACR</td>
                                  <td>ACRUX LIMITED</td>
                                  <td class="numeric">$3.71</td>
                                  <td class="numeric">  +0.01</td>
                                  <td class="numeric">0.14%</td>
                                  <td class="numeric">$3.70</td>
                                  <td class="numeric">$3.72</td>
                                  <td class="numeric">$3.68</td>
                                  <td class="numeric">191,373</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>ADU</td>
                                  <td>ADAMUS RESOURCES LIMITED</td>
                                  <td class="numeric">$0.72</td>
                                  <td class="numeric">0.00</td>
                                  <td class="numeric">0.00%</td>
                                  <td class="numeric">$0.73</td>
                                  <td class="numeric">$0.74</td>
                                  <td class="numeric">$0.72</td>
                                  <td class="numeric">8,602,291</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>AGG</td>
                                  <td>ANGLOGOLD ASHANTI LIMITED</td>
                                  <td class="numeric">$7.81</td>
                                  <td class="numeric">-0.22</td>
                                  <td class="numeric">-2.74%</td>
                                  <td class="numeric">$7.82</td>
                                  <td class="numeric">$7.82</td>
                                  <td class="numeric">$7.81</td>
                                  <td class="numeric">148</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>AGK</td>
                                  <td>AGL ENERGY LIMITED</td>
                                  <td class="numeric">$13.82</td>
                                  <td class="numeric">  +0.02</td>
                                  <td class="numeric">0.14%</td>
                                  <td class="numeric">$13.83</td>
                                  <td class="numeric">$13.83</td>
                                  <td class="numeric">$13.67</td>
                                  <td class="numeric">846,403</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              <tr>
                                  <td>AGO</td>
                                  <td>ATLAS IRON LIMITED</td>
                                  <td class="numeric">$3.17</td>
                                  <td class="numeric">-0.02</td>
                                  <td class="numeric">-0.47%</td>
                                  <td class="numeric">$3.11</td>
                                  <td class="numeric">$3.22</td>
                                  <td class="numeric">$3.10</td>
                                  <td class="numeric">5,416,303</td>
                                  <td class="numeric">Checked and Verified</td>
                              </tr>
                              </tbody>
                          </table>
                          </section>
                  </div><!-- /content-panel -->
               </div><!-- /col-lg-4 -->			
		  	</div><!-- /row -->
		  	
		  	<div class="row mt"> <!-- RSMI -->
              <div class="col-lg-12">
                      <div class="content-panel">
						  <h4><i class="fa fa-angle-right"></i> Report of Supplies and Materials Issued</h4>
                          <section id="no-more-tables">
                              <table class="table table-bordered table-striped table-condensed cf">
                                  <thead class="cf">
                                  <tr>
                                      <th>Serial Number</th>
                                      <th>RIS No.</th>
                                      <th>Responsibility Center Code</th>
                                      <th>Stock No.</th>
                                      <th>Item/Description</th>
                                      <th>Unit</th>
                                      <th>Qty Issued</th>
                                      <th>Unit Cost</th>
                                      <th>Amount</th>
                                      <th>Recap: Stock No.</th>
                                      <th>Recap: Quantity</th>
                                      <th>Recap: Unit Cost</th>
                                      <th>Recap: Total Cost</th>
                                      <th>Recap: UACS Object Code</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <tr>
                                      <td data-title="Code">AAC</td>
                                      <td data-title="Company">AUSTRALIAN AGRICULTURAL COMPANY LIMITED.</td>
                                      <td class="numeric" data-title="Price">$1.38</td>
                                      <td class="numeric" data-title="Change">-0.01</td>
                                      <td class="numeric" data-title="Change %">-0.36%</td>
                                      <td class="numeric" data-title="Open">$1.39</td>
                                      <td class="numeric" data-title="High">$1.39</td>
                                      <td class="numeric" data-title="Low">$1.38</td>
                                      <td class="numeric" data-title="Volume">9,395</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAD</td>
                                      <td data-title="Company">ARDENT LEISURE GROUP</td>
                                      <td class="numeric" data-title="Price">$1.15</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">1.32%</td>
                                      <td class="numeric" data-title="Open">$1.14</td>
                                      <td class="numeric" data-title="High">$1.15</td>
                                      <td class="numeric" data-title="Low">$1.13</td>
                                      <td class="numeric" data-title="Volume">56,431</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAX</td>
                                      <td data-title="Company">AUSENCO LIMITED</td>
                                      <td class="numeric" data-title="Price">$4.00</td>
                                      <td class="numeric" data-title="Change">-0.04</td>
                                      <td class="numeric" data-title="Change %">-0.99%</td>
                                      <td class="numeric" data-title="Open">$4.01</td>
                                      <td class="numeric" data-title="High">$4.05</td>
                                      <td class="numeric" data-title="Low">$4.00</td>
                                      <td class="numeric" data-title="Volume">90,641</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABC</td>
                                      <td data-title="Company">ADELAIDE BRIGHTON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.00</td>
                                      <td class="numeric" data-title="Change">  +0.06</td>
                                      <td class="numeric" data-title="Change %">2.04%</td>
                                      <td class="numeric" data-title="Open">$2.98</td>
                                      <td class="numeric" data-title="High">$3.00</td>
                                      <td class="numeric" data-title="Low">$2.96</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABP</td>
                                      <td data-title="Company">ABACUS PROPERTY GROUP</td>
                                      <td class="numeric" data-title="Price">$1.91</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$1.92</td>
                                      <td class="numeric" data-title="High">$1.93</td>
                                      <td class="numeric" data-title="Low">$1.90</td>
                                      <td class="numeric" data-title="Volume">595,701</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABY</td>
                                      <td data-title="Company">ADITYA BIRLA MINERALS LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.77</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">2.00%</td>
                                      <td class="numeric" data-title="Open">$0.76</td>
                                      <td class="numeric" data-title="High">$0.77</td>
                                      <td class="numeric" data-title="Low">$0.76</td>
                                      <td class="numeric" data-title="Volume">54,567</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ACR</td>
                                      <td data-title="Company">ACRUX LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.71</td>
                                      <td class="numeric" data-title="Change">  +0.01</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$3.70</td>
                                      <td class="numeric" data-title="High">$3.72</td>
                                      <td class="numeric" data-title="Low">$3.68</td>
                                      <td class="numeric" data-title="Volume">191,373</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ADU</td>
                                      <td data-title="Company">ADAMUS RESOURCES LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.72</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$0.73</td>
                                      <td class="numeric" data-title="High">$0.74</td>
                                      <td class="numeric" data-title="Low">$0.72</td>
                                      <td class="numeric" data-title="Volume">8,602,291</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGG</td>
                                      <td data-title="Company">ANGLOGOLD ASHANTI LIMITED</td>
                                      <td class="numeric" data-title="Price">$7.81</td>
                                      <td class="numeric" data-title="Change">-0.22</td>
                                      <td class="numeric" data-title="Change %">-2.74%</td>
                                      <td class="numeric" data-title="Open">$7.82</td>
                                      <td class="numeric" data-title="High">$7.82</td>
                                      <td class="numeric" data-title="Low">$7.81</td>
                                      <td class="numeric" data-title="Volume">148</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGK</td>
                                      <td data-title="Company">AGL ENERGY LIMITED</td>
                                      <td class="numeric" data-title="Price">$13.82</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$13.83</td>
                                      <td class="numeric" data-title="High">$13.83</td>
                                      <td class="numeric" data-title="Low">$13.67</td>
                                      <td class="numeric" data-title="Volume">846,403</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGO</td>
                                      <td data-title="Company">ATLAS IRON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.17</td>
                                      <td class="numeric" data-title="Change">-0.02</td>
                                      <td class="numeric" data-title="Change %">-0.47%</td>
                                      <td class="numeric" data-title="Open">$3.11</td>
                                      <td class="numeric" data-title="High">$3.22</td>
                                      <td class="numeric" data-title="Low">$3.10</td>
                                      <td class="numeric" data-title="Volume">5,416,303</td>
                                  </tr>
                                  </tbody>
                              </table>
                          </section>
                      </div><!-- /content-panel -->
                  </div><!-- /col-lg-12 -->
              </div><!-- /row -->
              

		  	<div class="row mt"> <!-- SC -->
              <div class="col-lg-12"> 
                      <div class="content-panel"> 
						  <h4><i class="fa fa-angle-right"></i> Stock Card</h4>
                          <section id="no-more-tables">
                              <table class="table table-bordered table-striped table-condensed cf">
                                  <thead class="cf">
                                  <tr>
                                      <th>Code</th>
                                      <th>Company</th>
                                      <th class="numeric">Price</th>
                                      <th class="numeric">Change</th>
                                      <th class="numeric">Change %</th>
                                      <th class="numeric">Open</th>
                                      <th class="numeric">High</th>
                                      <th class="numeric">Low</th>
                                      <th class="numeric">Volume</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <tr>
                                      <td data-title="Code">AAC</td>
                                      <td data-title="Company">AUSTRALIAN AGRICULTURAL COMPANY LIMITED.</td>
                                      <td class="numeric" data-title="Price">$1.38</td>
                                      <td class="numeric" data-title="Change">-0.01</td>
                                      <td class="numeric" data-title="Change %">-0.36%</td>
                                      <td class="numeric" data-title="Open">$1.39</td>
                                      <td class="numeric" data-title="High">$1.39</td>
                                      <td class="numeric" data-title="Low">$1.38</td>
                                      <td class="numeric" data-title="Volume">9,395</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAD</td>
                                      <td data-title="Company">ARDENT LEISURE GROUP</td>
                                      <td class="numeric" data-title="Price">$1.15</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">1.32%</td>
                                      <td class="numeric" data-title="Open">$1.14</td>
                                      <td class="numeric" data-title="High">$1.15</td>
                                      <td class="numeric" data-title="Low">$1.13</td>
                                      <td class="numeric" data-title="Volume">56,431</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAX</td>
                                      <td data-title="Company">AUSENCO LIMITED</td>
                                      <td class="numeric" data-title="Price">$4.00</td>
                                      <td class="numeric" data-title="Change">-0.04</td>
                                      <td class="numeric" data-title="Change %">-0.99%</td>
                                      <td class="numeric" data-title="Open">$4.01</td>
                                      <td class="numeric" data-title="High">$4.05</td>
                                      <td class="numeric" data-title="Low">$4.00</td>
                                      <td class="numeric" data-title="Volume">90,641</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABC</td>
                                      <td data-title="Company">ADELAIDE BRIGHTON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.00</td>
                                      <td class="numeric" data-title="Change">  +0.06</td>
                                      <td class="numeric" data-title="Change %">2.04%</td>
                                      <td class="numeric" data-title="Open">$2.98</td>
                                      <td class="numeric" data-title="High">$3.00</td>
                                      <td class="numeric" data-title="Low">$2.96</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABP</td>
                                      <td data-title="Company">ABACUS PROPERTY GROUP</td>
                                      <td class="numeric" data-title="Price">$1.91</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$1.92</td>
                                      <td class="numeric" data-title="High">$1.93</td>
                                      <td class="numeric" data-title="Low">$1.90</td>
                                      <td class="numeric" data-title="Volume">595,701</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABY</td>
                                      <td data-title="Company">ADITYA BIRLA MINERALS LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.77</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">2.00%</td>
                                      <td class="numeric" data-title="Open">$0.76</td>
                                      <td class="numeric" data-title="High">$0.77</td>
                                      <td class="numeric" data-title="Low">$0.76</td>
                                      <td class="numeric" data-title="Volume">54,567</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ACR</td>
                                      <td data-title="Company">ACRUX LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.71</td>
                                      <td class="numeric" data-title="Change">  +0.01</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$3.70</td>
                                      <td class="numeric" data-title="High">$3.72</td>
                                      <td class="numeric" data-title="Low">$3.68</td>
                                      <td class="numeric" data-title="Volume">191,373</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ADU</td>
                                      <td data-title="Company">ADAMUS RESOURCES LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.72</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$0.73</td>
                                      <td class="numeric" data-title="High">$0.74</td>
                                      <td class="numeric" data-title="Low">$0.72</td>
                                      <td class="numeric" data-title="Volume">8,602,291</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGG</td>
                                      <td data-title="Company">ANGLOGOLD ASHANTI LIMITED</td>
                                      <td class="numeric" data-title="Price">$7.81</td>
                                      <td class="numeric" data-title="Change">-0.22</td>
                                      <td class="numeric" data-title="Change %">-2.74%</td>
                                      <td class="numeric" data-title="Open">$7.82</td>
                                      <td class="numeric" data-title="High">$7.82</td>
                                      <td class="numeric" data-title="Low">$7.81</td>
                                      <td class="numeric" data-title="Volume">148</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGK</td>
                                      <td data-title="Company">AGL ENERGY LIMITED</td>
                                      <td class="numeric" data-title="Price">$13.82</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$13.83</td>
                                      <td class="numeric" data-title="High">$13.83</td>
                                      <td class="numeric" data-title="Low">$13.67</td>
                                      <td class="numeric" data-title="Volume">846,403</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGO</td>
                                      <td data-title="Company">ATLAS IRON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.17</td>
                                      <td class="numeric" data-title="Change">-0.02</td>
                                      <td class="numeric" data-title="Change %">-0.47%</td>
                                      <td class="numeric" data-title="Open">$3.11</td>
                                      <td class="numeric" data-title="High">$3.22</td>
                                      <td class="numeric" data-title="Low">$3.10</td>
                                      <td class="numeric" data-title="Volume">5,416,303</td>
                                  </tr>
                                  </tbody>
                              </table>
                          </section>
                      </div><!-- /content-panel -->
                  </div><!-- /col-lg-12 -->
              </div><!-- /row -->
              
              
		  	<div class="row mt"> <!-- PC -->
              <div class="col-lg-12">
                      <div class="content-panel">
						  <h4><i class="fa fa-angle-right"></i> Property Card</h4>
                          <section id="no-more-tables">
                              <table class="table table-bordered table-striped table-condensed cf">
                                  <thead class="cf">
                                  <tr>
                                      <th>Code</th>
                                      <th>Company</th>
                                      <th class="numeric">Price</th>
                                      <th class="numeric">Change</th>
                                      <th class="numeric">Change %</th>
                                      <th class="numeric">Open</th>
                                      <th class="numeric">High</th>
                                      <th class="numeric">Low</th>
                                      <th class="numeric">Volume</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <tr>
                                      <td data-title="Code">AAC</td>
                                      <td data-title="Company">AUSTRALIAN AGRICULTURAL COMPANY LIMITED.</td>
                                      <td class="numeric" data-title="Price">$1.38</td>
                                      <td class="numeric" data-title="Change">-0.01</td>
                                      <td class="numeric" data-title="Change %">-0.36%</td>
                                      <td class="numeric" data-title="Open">$1.39</td>
                                      <td class="numeric" data-title="High">$1.39</td>
                                      <td class="numeric" data-title="Low">$1.38</td>
                                      <td class="numeric" data-title="Volume">9,395</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAD</td>
                                      <td data-title="Company">ARDENT LEISURE GROUP</td>
                                      <td class="numeric" data-title="Price">$1.15</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">1.32%</td>
                                      <td class="numeric" data-title="Open">$1.14</td>
                                      <td class="numeric" data-title="High">$1.15</td>
                                      <td class="numeric" data-title="Low">$1.13</td>
                                      <td class="numeric" data-title="Volume">56,431</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAX</td>
                                      <td data-title="Company">AUSENCO LIMITED</td>
                                      <td class="numeric" data-title="Price">$4.00</td>
                                      <td class="numeric" data-title="Change">-0.04</td>
                                      <td class="numeric" data-title="Change %">-0.99%</td>
                                      <td class="numeric" data-title="Open">$4.01</td>
                                      <td class="numeric" data-title="High">$4.05</td>
                                      <td class="numeric" data-title="Low">$4.00</td>
                                      <td class="numeric" data-title="Volume">90,641</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABC</td>
                                      <td data-title="Company">ADELAIDE BRIGHTON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.00</td>
                                      <td class="numeric" data-title="Change">  +0.06</td>
                                      <td class="numeric" data-title="Change %">2.04%</td>
                                      <td class="numeric" data-title="Open">$2.98</td>
                                      <td class="numeric" data-title="High">$3.00</td>
                                      <td class="numeric" data-title="Low">$2.96</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABP</td>
                                      <td data-title="Company">ABACUS PROPERTY GROUP</td>
                                      <td class="numeric" data-title="Price">$1.91</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$1.92</td>
                                      <td class="numeric" data-title="High">$1.93</td>
                                      <td class="numeric" data-title="Low">$1.90</td>
                                      <td class="numeric" data-title="Volume">595,701</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABY</td>
                                      <td data-title="Company">ADITYA BIRLA MINERALS LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.77</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">2.00%</td>
                                      <td class="numeric" data-title="Open">$0.76</td>
                                      <td class="numeric" data-title="High">$0.77</td>
                                      <td class="numeric" data-title="Low">$0.76</td>
                                      <td class="numeric" data-title="Volume">54,567</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ACR</td>
                                      <td data-title="Company">ACRUX LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.71</td>
                                      <td class="numeric" data-title="Change">  +0.01</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$3.70</td>
                                      <td class="numeric" data-title="High">$3.72</td>
                                      <td class="numeric" data-title="Low">$3.68</td>
                                      <td class="numeric" data-title="Volume">191,373</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ADU</td>
                                      <td data-title="Company">ADAMUS RESOURCES LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.72</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$0.73</td>
                                      <td class="numeric" data-title="High">$0.74</td>
                                      <td class="numeric" data-title="Low">$0.72</td>
                                      <td class="numeric" data-title="Volume">8,602,291</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGG</td>
                                      <td data-title="Company">ANGLOGOLD ASHANTI LIMITED</td>
                                      <td class="numeric" data-title="Price">$7.81</td>
                                      <td class="numeric" data-title="Change">-0.22</td>
                                      <td class="numeric" data-title="Change %">-2.74%</td>
                                      <td class="numeric" data-title="Open">$7.82</td>
                                      <td class="numeric" data-title="High">$7.82</td>
                                      <td class="numeric" data-title="Low">$7.81</td>
                                      <td class="numeric" data-title="Volume">148</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGK</td>
                                      <td data-title="Company">AGL ENERGY LIMITED</td>
                                      <td class="numeric" data-title="Price">$13.82</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$13.83</td>
                                      <td class="numeric" data-title="High">$13.83</td>
                                      <td class="numeric" data-title="Low">$13.67</td>
                                      <td class="numeric" data-title="Volume">846,403</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGO</td>
                                      <td data-title="Company">ATLAS IRON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.17</td>
                                      <td class="numeric" data-title="Change">-0.02</td>
                                      <td class="numeric" data-title="Change %">-0.47%</td>
                                      <td class="numeric" data-title="Open">$3.11</td>
                                      <td class="numeric" data-title="High">$3.22</td>
                                      <td class="numeric" data-title="Low">$3.10</td>
                                      <td class="numeric" data-title="Volume">5,416,303</td>
                                  </tr>
                                  </tbody>
                              </table>
                          </section>
                      </div><!-- /content-panel -->
                  </div><!-- /col-lg-12 -->
              </div><!-- /row -->
              
              <div class="row mt"> <!-- WMR -->
              <div class="col-lg-12">
                      <div class="content-panel">
						  <h4><i class="fa fa-angle-right"></i> Waste Management Report</h4>
                          <section id="no-more-tables">
                              <table class="table table-bordered table-striped table-condensed cf">
                                  <thead class="cf">
                                  <tr>
                                      <th>Code</th>
                                      <th>Company</th>
                                      <th class="numeric">Price</th>
                                      <th class="numeric">Change</th>
                                      <th class="numeric">Change %</th>
                                      <th class="numeric">Open</th>
                                      <th class="numeric">High</th>
                                      <th class="numeric">Low</th>
                                      <th class="numeric">Volume</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <tr>
                                      <td data-title="Code">AAC</td>
                                      <td data-title="Company">AUSTRALIAN AGRICULTURAL COMPANY LIMITED.</td>
                                      <td class="numeric" data-title="Price">$1.38</td>
                                      <td class="numeric" data-title="Change">-0.01</td>
                                      <td class="numeric" data-title="Change %">-0.36%</td>
                                      <td class="numeric" data-title="Open">$1.39</td>
                                      <td class="numeric" data-title="High">$1.39</td>
                                      <td class="numeric" data-title="Low">$1.38</td>
                                      <td class="numeric" data-title="Volume">9,395</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAD</td>
                                      <td data-title="Company">ARDENT LEISURE GROUP</td>
                                      <td class="numeric" data-title="Price">$1.15</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">1.32%</td>
                                      <td class="numeric" data-title="Open">$1.14</td>
                                      <td class="numeric" data-title="High">$1.15</td>
                                      <td class="numeric" data-title="Low">$1.13</td>
                                      <td class="numeric" data-title="Volume">56,431</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAX</td>
                                      <td data-title="Company">AUSENCO LIMITED</td>
                                      <td class="numeric" data-title="Price">$4.00</td>
                                      <td class="numeric" data-title="Change">-0.04</td>
                                      <td class="numeric" data-title="Change %">-0.99%</td>
                                      <td class="numeric" data-title="Open">$4.01</td>
                                      <td class="numeric" data-title="High">$4.05</td>
                                      <td class="numeric" data-title="Low">$4.00</td>
                                      <td class="numeric" data-title="Volume">90,641</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABC</td>
                                      <td data-title="Company">ADELAIDE BRIGHTON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.00</td>
                                      <td class="numeric" data-title="Change">  +0.06</td>
                                      <td class="numeric" data-title="Change %">2.04%</td>
                                      <td class="numeric" data-title="Open">$2.98</td>
                                      <td class="numeric" data-title="High">$3.00</td>
                                      <td class="numeric" data-title="Low">$2.96</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABP</td>
                                      <td data-title="Company">ABACUS PROPERTY GROUP</td>
                                      <td class="numeric" data-title="Price">$1.91</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$1.92</td>
                                      <td class="numeric" data-title="High">$1.93</td>
                                      <td class="numeric" data-title="Low">$1.90</td>
                                      <td class="numeric" data-title="Volume">595,701</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABY</td>
                                      <td data-title="Company">ADITYA BIRLA MINERALS LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.77</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">2.00%</td>
                                      <td class="numeric" data-title="Open">$0.76</td>
                                      <td class="numeric" data-title="High">$0.77</td>
                                      <td class="numeric" data-title="Low">$0.76</td>
                                      <td class="numeric" data-title="Volume">54,567</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ACR</td>
                                      <td data-title="Company">ACRUX LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.71</td>
                                      <td class="numeric" data-title="Change">  +0.01</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$3.70</td>
                                      <td class="numeric" data-title="High">$3.72</td>
                                      <td class="numeric" data-title="Low">$3.68</td>
                                      <td class="numeric" data-title="Volume">191,373</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ADU</td>
                                      <td data-title="Company">ADAMUS RESOURCES LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.72</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$0.73</td>
                                      <td class="numeric" data-title="High">$0.74</td>
                                      <td class="numeric" data-title="Low">$0.72</td>
                                      <td class="numeric" data-title="Volume">8,602,291</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGG</td>
                                      <td data-title="Company">ANGLOGOLD ASHANTI LIMITED</td>
                                      <td class="numeric" data-title="Price">$7.81</td>
                                      <td class="numeric" data-title="Change">-0.22</td>
                                      <td class="numeric" data-title="Change %">-2.74%</td>
                                      <td class="numeric" data-title="Open">$7.82</td>
                                      <td class="numeric" data-title="High">$7.82</td>
                                      <td class="numeric" data-title="Low">$7.81</td>
                                      <td class="numeric" data-title="Volume">148</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGK</td>
                                      <td data-title="Company">AGL ENERGY LIMITED</td>
                                      <td class="numeric" data-title="Price">$13.82</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$13.83</td>
                                      <td class="numeric" data-title="High">$13.83</td>
                                      <td class="numeric" data-title="Low">$13.67</td>
                                      <td class="numeric" data-title="Volume">846,403</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGO</td>
                                      <td data-title="Company">ATLAS IRON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.17</td>
                                      <td class="numeric" data-title="Change">-0.02</td>
                                      <td class="numeric" data-title="Change %">-0.47%</td>
                                      <td class="numeric" data-title="Open">$3.11</td>
                                      <td class="numeric" data-title="High">$3.22</td>
                                      <td class="numeric" data-title="Low">$3.10</td>
                                      <td class="numeric" data-title="Volume">5,416,303</td>
                                  </tr>
                                  </tbody>
                              </table>
                          </section>
                      </div><!-- /content-panel -->
                  </div><!-- /col-lg-12 -->
              </div><!-- /row -->
              
              <div class="row mt"> <!-- DV -->
              <div class="col-lg-12">
                      <div class="content-panel">
						  <h4><i class="fa fa-angle-right"></i> Disbursement Voucher</h4>
                          <section id="no-more-tables">
                              <table class="table table-bordered table-striped table-condensed cf">
                                  <thead class="cf">
                                  <tr>
                                      <th>Code</th>
                                      <th>Company</th>
                                      <th class="numeric">Price</th>
                                      <th class="numeric">Change</th>
                                      <th class="numeric">Change %</th>
                                      <th class="numeric">Open</th>
                                      <th class="numeric">High</th>
                                      <th class="numeric">Low</th>
                                      <th class="numeric">Volume</th>
                                  </tr>
                                  </thead>
                                  <tbody>
                                  <tr>
                                      <td data-title="Code">AAC</td>
                                      <td data-title="Company">AUSTRALIAN AGRICULTURAL COMPANY LIMITED.</td>
                                      <td class="numeric" data-title="Price">$1.38</td>
                                      <td class="numeric" data-title="Change">-0.01</td>
                                      <td class="numeric" data-title="Change %">-0.36%</td>
                                      <td class="numeric" data-title="Open">$1.39</td>
                                      <td class="numeric" data-title="High">$1.39</td>
                                      <td class="numeric" data-title="Low">$1.38</td>
                                      <td class="numeric" data-title="Volume">9,395</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAD</td>
                                      <td data-title="Company">ARDENT LEISURE GROUP</td>
                                      <td class="numeric" data-title="Price">$1.15</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">1.32%</td>
                                      <td class="numeric" data-title="Open">$1.14</td>
                                      <td class="numeric" data-title="High">$1.15</td>
                                      <td class="numeric" data-title="Low">$1.13</td>
                                      <td class="numeric" data-title="Volume">56,431</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AAX</td>
                                      <td data-title="Company">AUSENCO LIMITED</td>
                                      <td class="numeric" data-title="Price">$4.00</td>
                                      <td class="numeric" data-title="Change">-0.04</td>
                                      <td class="numeric" data-title="Change %">-0.99%</td>
                                      <td class="numeric" data-title="Open">$4.01</td>
                                      <td class="numeric" data-title="High">$4.05</td>
                                      <td class="numeric" data-title="Low">$4.00</td>
                                      <td class="numeric" data-title="Volume">90,641</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABC</td>
                                      <td data-title="Company">ADELAIDE BRIGHTON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.00</td>
                                      <td class="numeric" data-title="Change">  +0.06</td>
                                      <td class="numeric" data-title="Change %">2.04%</td>
                                      <td class="numeric" data-title="Open">$2.98</td>
                                      <td class="numeric" data-title="High">$3.00</td>
                                      <td class="numeric" data-title="Low">$2.96</td>
                                      <td class="numeric" data-title="Volume">862,518</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABP</td>
                                      <td data-title="Company">ABACUS PROPERTY GROUP</td>
                                      <td class="numeric" data-title="Price">$1.91</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$1.92</td>
                                      <td class="numeric" data-title="High">$1.93</td>
                                      <td class="numeric" data-title="Low">$1.90</td>
                                      <td class="numeric" data-title="Volume">595,701</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ABY</td>
                                      <td data-title="Company">ADITYA BIRLA MINERALS LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.77</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">2.00%</td>
                                      <td class="numeric" data-title="Open">$0.76</td>
                                      <td class="numeric" data-title="High">$0.77</td>
                                      <td class="numeric" data-title="Low">$0.76</td>
                                      <td class="numeric" data-title="Volume">54,567</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ACR</td>
                                      <td data-title="Company">ACRUX LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.71</td>
                                      <td class="numeric" data-title="Change">  +0.01</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$3.70</td>
                                      <td class="numeric" data-title="High">$3.72</td>
                                      <td class="numeric" data-title="Low">$3.68</td>
                                      <td class="numeric" data-title="Volume">191,373</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">ADU</td>
                                      <td data-title="Company">ADAMUS RESOURCES LIMITED</td>
                                      <td class="numeric" data-title="Price">$0.72</td>
                                      <td class="numeric" data-title="Change">0.00</td>
                                      <td class="numeric" data-title="Change %">0.00%</td>
                                      <td class="numeric" data-title="Open">$0.73</td>
                                      <td class="numeric" data-title="High">$0.74</td>
                                      <td class="numeric" data-title="Low">$0.72</td>
                                      <td class="numeric" data-title="Volume">8,602,291</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGG</td>
                                      <td data-title="Company">ANGLOGOLD ASHANTI LIMITED</td>
                                      <td class="numeric" data-title="Price">$7.81</td>
                                      <td class="numeric" data-title="Change">-0.22</td>
                                      <td class="numeric" data-title="Change %">-2.74%</td>
                                      <td class="numeric" data-title="Open">$7.82</td>
                                      <td class="numeric" data-title="High">$7.82</td>
                                      <td class="numeric" data-title="Low">$7.81</td>
                                      <td class="numeric" data-title="Volume">148</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGK</td>
                                      <td data-title="Company">AGL ENERGY LIMITED</td>
                                      <td class="numeric" data-title="Price">$13.82</td>
                                      <td class="numeric" data-title="Change">  +0.02</td>
                                      <td class="numeric" data-title="Change %">0.14%</td>
                                      <td class="numeric" data-title="Open">$13.83</td>
                                      <td class="numeric" data-title="High">$13.83</td>
                                      <td class="numeric" data-title="Low">$13.67</td>
                                      <td class="numeric" data-title="Volume">846,403</td>
                                  </tr>
                                  <tr>
                                      <td data-title="Code">AGO</td>
                                      <td data-title="Company">ATLAS IRON LIMITED</td>
                                      <td class="numeric" data-title="Price">$3.17</td>
                                      <td class="numeric" data-title="Change">-0.02</td>
                                      <td class="numeric" data-title="Change %">-0.47%</td>
                                      <td class="numeric" data-title="Open">$3.11</td>
                                      <td class="numeric" data-title="High">$3.22</td>
                                      <td class="numeric" data-title="Low">$3.10</td>
                                      <td class="numeric" data-title="Volume">5,416,303</td>
                                  </tr>
                                  </tbody>
                              </table>
                          </section>
                      </div><!-- /content-panel -->
                  </div><!-- /col-lg-12 -->
              </div><!-- /row -->
              




		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <jsp:include page="WEB-INF/copyright.jsp" />
      <!--footer end-->
  </section>
  <jsp:include page="WEB-INF/footer.jsp" />
  </body>
</html>
