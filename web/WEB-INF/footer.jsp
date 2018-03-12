    <!-- js placed at the end of the document so the pages load faster -->
    
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="js/jquery.ui.touch-punch.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
    
    <script type="text/javascript" src="js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="js/sparkline-chart.js"></script>    
	<script src="js/zabuto_calendar.js"></script>
      <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

      </script>
          <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASm3CwaK9qtcZEWYa-iQwHaGi3gcosAJc&sensor=false"></script>

	<script>    
	$('.contact-map').click(function(){
	
	    //google map in tab click initialize
	    function initialize() {
	        var myLatlng = new google.maps.LatLng(40.6700, -73.9400);
	        var mapOptions = {
	            zoom: 11,
	            scrollwheel: false,
	            center: myLatlng,
	            mapTypeId: google.maps.MapTypeId.ROADMAP
	        }
	        var map = new google.maps.Map(document.getElementById('map'), mapOptions);
	        var marker = new google.maps.Marker({
	            position: myLatlng,
	            map: map,
	            title: 'DashGum Admin Theme!'
	        });
	    }
	    google.maps.event.addDomListener(window, 'click', initialize);
	});
	</script>