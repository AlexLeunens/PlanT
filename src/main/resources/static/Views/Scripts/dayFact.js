window.onload = function() {

	facts = ['Les jardins suspendus de Babylone étaient l\'une des sept merveilles du monde antique. Ils auraient été construits par le roi néo-babylonien Nabuchodonosor II près de l\'actuel Irak',
			"Le plus beau jardin du monde a été",
			"Près de 1000 fleurs de jasmin et une douzaine de roses se retrouvent dans un seul flacon de parfum Chanel n ° 5.",
			"Les premiers jardins étaient strictement pratiques et étaient utilisés pour cultiver de la nourriture et des herbes médicinales. Vers 1500 avant JC en Egypte , les premiers jardins décoratifs sont apparus.",
			"Les premières serres de l'histoire ont été construites à Rome en l'an 30 après JC sous les ordres de l'empereur Tibère qui voulait manger un concombre par jour."
			];

	document.getElementById("randomFact").innerHTML = fact[Math.floor(Math
			.random()
			* facts.length)];

}