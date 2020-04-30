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
	var obj1 = document.getElementById('pwd1');
	var obj2 = document.getElementById('pwd2');
	obj1.type = "text";
	obj2.type = "text";

}
function mouseoutPass(obj) {
	var obj1 = document.getElementById('pwd1');
	var obj2 = document.getElementById('pwd2');
	obj1.type = "password";
	obj2.type = "password";
}
if (this.getField("pwd1").value == this.getField("pwd2").value) {
	document.getElementById("same").src = "../Images/check.png";
} else {
	document.getElementById("same").src = "../Images/cross.png";

}