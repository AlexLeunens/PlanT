window.onload = function() {
	const options = {
		weekday : 'long',
		month : 'long',
		day : 'numeric'
	};
	var d = new Date();
	var fd = d.toLocaleDateString("fr-FR", options);
	var fdf = fd[0].toUpperCase() + fd.slice(1);
	var f = "Planning JardISEP 📅🧐 - ".concat(fdf)
	
	document.getElementById("date").innerHTML = f;
}