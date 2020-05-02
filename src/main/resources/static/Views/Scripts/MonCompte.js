
function switchOnOff() {
	var s1 = document.getElementsByClassName('switchs');
	var s2 = document.getElementsByClassName('switchs2');
	var s3 = document.getElementById('editButton');
	for (let i = 0; i < 100; i++) {
		if (s1[i].style.display === "block") {
			s1[i].style.display = "none";
			s2[i].style.display = "block";
			document.getElementById("editButton").innerHTML = "Edit";
			document.getElementById("myForm").reset();
		} else {
			s1[i].style.display = "block";
			s2[i].style.display = "none";
			document.getElementById("editButton").innerHTML = "Cancel";

		}
	}

}
function mouseoverPass() {
	document.getElementById('pwd1').type = "text";
	document.getElementById('pwd2').type = "text";

}
function mouseoutPass(obj) {
	document.getElementById('pwd1').type = "password";
	document.getElementById('pwd2').type = "password";
}

window.onload = function() {

if (this.getField("pwd1").value == this.getField("pwd2").value) {
	document.getElementById("same").src = "Views/Images/check.png";
    var context = [[@{/}]];
    document.getElementById("same").src=context + 'Views/Images/check.png' ;

} else {
	document.getElementById("same").src = "Views/Images/cross.png";
    var context = [[@{/}]];
    document.getElementById("same").src=context + 'Views/Images/cross.png' ;

}
}