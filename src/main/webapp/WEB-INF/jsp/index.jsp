<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enterprise Skills Management System</title>

<script src="http://code.jquery.com/jquery-2.1.4.min.js"
	type="text/javascript"></script>
<script src="https://code.jquery.com/ui/1.11.3/jquery-ui.min.js"
	type="text/javascript"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">

<script src="resources/js/main.js" type="text/javascript"></script>
</head>
<body>

	<h1>Enterprise Skills Management System</h1>

	<div>
		<label>Enter Employee Name : </label> <input type="text" id="name" />
	</div>

	<div class="skill_field_wrap">
		<button class="add_more_skill_button">Add More Skills</button>
		<div>
			<label>Enter Skill : </label><input type="text" name="mytext">
		</div>
	</div>

	<div>
		<button type="submit" id="submit">Submit</button>
	</div>
	<div>
		<a href="/esm/search">go to search page</a>
	</div>

	<div id="dialog" title="Success dialog" style="display:none">
		<p>Registration Success.</p>
	</div>

</body>
</html>