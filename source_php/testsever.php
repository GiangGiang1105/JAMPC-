 <html>
<head>
   <meta charset="utf-8">
   <title>POST</title>
</head> 
<body>
   <form  method = "POST">
       Username: <input type="text" name="username"></br></br>
       Password: <input type="password" name="password"></br></br>
   <input type="submit" value="Login" name ="click">
   <?php
	$u=$_POST['username'];
	$p=$_POST['password'];
	echo "Username vừa nhập là: ".$_POST['username'] ;
	echo "</br>Password  vừa nhập là: ".$_POST['password'] ;
?>
</form>
</body>
</html>