<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <!--<title>DAR-AMIS | User Dashboard</title> -->

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

    <script src="js/chart-master/Chart.js"></script>
    <script src="js/jquery.js"></script>
    <script>
                $(document).ready(function () {
                    var cur = new Date();

                    var date = cur.toDateString();
                    var time = cur.toLocaleTimeString();

                    $("[name='curDate']").text(date);
                    $("[name='curTime']").text(time);
                });
            </script>
            <script>
                $(document).ready(function () {
                    setInterval(function () {
                        var cur = new Date();

                        var date = cur.toDateString();
                        var time = cur.toLocaleTimeString();

                        $("[name='curDate']").text(date);
                        $("[name='curTime']").text(time);
                    }, 500);
                });
            </script>
            
                <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    