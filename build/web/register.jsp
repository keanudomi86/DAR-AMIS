<%-- 
    Document   : register
    Created on : 03 13, 18, 1:11:28 AM
    Author     : BavarianHotdog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="WEB-INF/header.jsp" />       
        <title>DAR-AMIS - Sign Up</title>
    </head>
<body class="hold-transition register-page">
        <div class="register-box">
            <div class="login-logo"><h2>Department of Agrarian Reform</h2>
                <h3> Asset Management Information System </h3>
            </div>

            <div class="register-box-body">
                <p class="login-box-msg">Register</p>
                <form action="Register" method="post">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="lastname" placeholder="Last Name" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="firstname" placeholder="First Name" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="middlename" placeholder="Middle Name" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="civilstatus" placeholder="Civil Status" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="gender" placeholder="Gender" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="address" placeholder="Address" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="birthday" placeholder="Date of Birthday (yyyy-MM-dd)" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="division" placeholder="Division" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="position" placeholder="Position" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="email" class="form-control" name="email" placeholder="Email" required>
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="cellno" placeholder="Cellphone Number" required>
                        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="empstatus" placeholder="Employee Status" required>
                        <span class="glyphicon glyphicon-circle-arrow-left form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="email" class="form-control" name="username" placeholder="Username" required>
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" name="pass1" placeholder="Password" required>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" name="pass2" placeholder="Verify Password" required>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox"> I agree to the <a href="#">terms and conditions.</a>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                        </div>
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="WEB-INF/copyright.jsp" /> 
      <jsp:include page="WEB-INF/footer.jsp" />
      <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>
    </body>
</html>
