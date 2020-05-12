window.onload = function() {
	
	for (const a of document.querySelectorAll("a")) {
		  if (a.textContent.includes("DEMO")) {
		    console.log(a.textContent)
		  }
		}

}
