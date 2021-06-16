<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join Us</title>
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
    <link href="css/style1.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <div class="box">
        <img class="avatar" src="img/user-avatar.png">
        <h1>Login Account</h1>
        <form action="Controller" method="post">
            <p>Username</p>
            <input type="text" placeholder="Username" name="email" required>
            <p>Password</p>
            <input type="password" placeholder="Password" name="password" required>
            <input formaction="Controller?command=logination" type="submit" value="Login">
            <a href="#">Forget Password?</a><br>
            <a href="Controller?command=registration">Create New Account</a>
        </form>
    </div>


</div>
</body>
</html>
