<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="headerDashboard.jsp"%>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<br>

				<button onclick="show1()">Job Type/ Skills</button>
				<br> <br> <br>
				<button onclick="show3()">ERI Salaries</button>
			</div>
			<div class="col-md-10">


				<div class='tableauPlaceholder' id='viz1522874831378'
					style='position: relative'>
					<noscript>
						<a href='#'><img alt='Dashboard 2 '
							src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;wo&#47;workbook_39&#47;Dashboard2&#47;1_rss.png'
							style='border: none' /></a>
					</noscript>
					<object class='tableauViz' style='display: none;'>
						<param name='host_url' value='https%3A%2F%2Fpublic.tableau.com%2F' />
						<param name='embed_code_version' value='3' />
						<param name='site_root' value='' />
						<param name='name' value='workbook_39&#47;Dashboard2' />
						<param name='tabs' value='no' />
						<param name='toolbar' value='yes' />
						<param name='static_image'
							value='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;wo&#47;workbook_39&#47;Dashboard2&#47;1.png' />
						<param name='animate_transition' value='yes' />
						<param name='display_static_image' value='yes' />
						<param name='display_spinner' value='yes' />
						<param name='display_overlay' value='yes' />
						<param name='display_count' value='yes' />
					</object>
				</div>
				<div class='tableauPlaceholder' id='viz1524771298130'
					style='position: relative'>
					<noscript>
						<a href='#'><img alt='ERI '
							src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;ER&#47;ERIv2&#47;ERI&#47;1_rss.png'
							style='border: none' /></a>
					</noscript>
					<object class='tableauViz' style='display: none;'>
						<param name='host_url' value='https%3A%2F%2Fpublic.tableau.com%2F' />
						<param name='embed_code_version' value='3' />
						<param name='site_root' value='' />
						<param name='name' value='ERIv2&#47;ERI' />
						<param name='tabs' value='no' />
						<param name='toolbar' value='yes' />
						<param name='static_image'
							value='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;ER&#47;ERIv2&#47;ERI&#47;1.png' />
						<param name='animate_transition' value='yes' />
						<param name='display_static_image' value='yes' />
						<param name='display_spinner' value='yes' />
						<param name='display_overlay' value='yes' />
						<param name='display_count' value='yes' />
					</object>
				</div>


			</div>
		</div>
	</div>
</body>
<div style="float: right; padding-right: 8px;">
	<a
		href="http://www.tableausoftware.com/public?ref=http://public.tableausoftware.com/views/Book2_673/Dashboard1"
		target="_blank">Powered by Tableau</a>
</div>
<%@include file="footer.jsp"%>
<script type='text/javascript'>
	function show1() {
		document.getElementById('viz1524771298130').style.display = "none"

		document.getElementById('viz1522874831378').style.display = "block"

	}

	function show3() {

		document.getElementById('viz1522874831378').style.display = "none"
		document.getElementById('viz1524771298130').style.display = "block"
	}

	var divElement = document.getElementById('viz1524771298130');
	var vizElement = divElement.getElementsByTagName('object')[0];
	vizElement.style.width = '1000px';
	vizElement.style.height = '827px';
	var scriptElement = document.createElement('script');
	scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';
	vizElement.parentNode.insertBefore(scriptElement, vizElement);
</script>
<script type='text/javascript'>
	var divElement = document.getElementById('viz1522874831378');
	var vizElement = divElement.getElementsByTagName('object')[0];
	vizElement.style.width = '1000px';
	vizElement.style.height = '827px';
	var scriptElement = document.createElement('script');
	scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';
	vizElement.parentNode.insertBefore(scriptElement, vizElement);
</script>
<script type='text/javascript'>
	var divElement = document.getElementById('viz1523568828126');
	var vizElement = divElement.getElementsByTagName('object')[0];
	vizElement.style.width = '1000px';
	vizElement.style.height = '827px';
	var scriptElement = document.createElement('script');
	scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';
	vizElement.parentNode.insertBefore(scriptElement, vizElement);
</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjXJvTfiEhXy3lySeyc9F6XqQWeaAbjyE&callback=myMap"></script>