window.onload = function() {
	const options = {
		weekday : 'long',
		month : 'long',
		day : 'numeric'
	};
	var d = new Date();
	var fd = d.toLocaleDateString("fr-FR", options);
	var fdf = fd[0].toUpperCase() + fd.slice(1);

	fact = [ 'This is a fact', "This is another fact" ];

	var n = d.getMonth();
	switch (n) {
	case 0:
		fact = [ 'Mois de janvier laisse la terre se reposer !',
				"Sécheresse de janvier, richesse de fermier.",
				"Gelées en janvier, blé au grenier." ];
		break;
	case 1:
		fact = [ 'Février de tous les mois le plus froid et le plus matois !',
				"Gelées en janvier, blé au grenier.",
				"Qui taille en février met du raisin dans son panier." ];
		break;
	case 2:
		fact = [ 'Mars venteux, verger pommeux !',
				'Si mars commence en courroux, il finira tout doux.' ];
		break;
	case 3:
		fact = [
				'Avril et mai sont les clés de l\'année !',
				"Avril a 30 jours. Si 31 il avait, personne ne s'en plaindrait.",
				"Avril, un de bon sur mille." ];
		break;
	case 4:
		fact = [ 'Averse de mai a plus de pouvoir que dix arrosoirs !',
				'Mai fleuri, an réjoui !', 'Mai sans rose rend l\'âme morose !' ];
		break;
	case 5:
		fact = [ 'Juin bien fleuri, vrai paradis',
				'Qui en juin se porte bien, au temps chaud ne craindra rien.',
				'En juin brume obscure trois jours seulement dure.' ];
		break;
	case 6:
		fact = [ 'Juillet ensoleillé remplit cave et grenier !',
				'Chaud juillet sur frais juin, peu de blé mais bon vin.',
				'Soleil de juillet donne la fortune.' ];
		break;
	case 7:
		fact = [ 'Quand août est bon, abondance à la maison.',
				'Quand il pleut au mois d\'août, les truffes sont au bout.' ];
		break;
	case 8:
		fact = [
				'Septembre humide, pas de tonneau vide.',
				'Septembre se montre souvent comme un second et court printemps.',
				'Mois de septembre pluvieux, an fructueux.' ];
		break;
	case 9:
		fact = [ 'Octobre en brumes, mois à rhumes.',
				'En octobre, tonnerre, vendange prospère.' ];
		break;
	case 10:
		fact = [ 'Le vent de novembre arrache la dernière feuille.',
				'Gelée de novembre, adieu l\'herbe tendre.' ];
		break;
	case 11:
		fact = [ 'Décembre prend et ne rend.', ];
		break;
	}
	document.getElementById("messageMois").innerHTML = fact[Math.floor(Math
			.random()
			* fact.length)];

	const options2 = {
		weekday : 'long',
		month : 'long',
		day : 'numeric'
	};
	var d = new Date();
	var fd = d.toLocaleDateString("fr-FR", options2);
	var fdf = fd[0].toUpperCase() + fd.slice(1);

	season = 'a';
	var n = d.getMonth();
	switch (n) {
	case 11:
	case 0:
	case 1:
		season = ' - ❄️  Hiver';
		break;
	case 2:
	case 3:
	case 4:
		season = ' - 🌸  Printemps';
		break;
	case 5:
	case 6:
	case 7:
		season = ' - 🌴  Eté';
		break;
	case 8:
	case 9:
	case 10:
		season = ' - 🍂  Automne';
		break;
	}
	document.getElementById("date").innerHTML = fdf;
	document.getElementById("season").innerHTML = season;

	fact = [
			'Les premières serres de l\'histoire ont été construites à Rome en l\'an 30 après JC sous les ordres de l\'empereur Tibère qui voulait manger un concombre par jour. ',
			"Les pastèques sont en fait des légumes et sont liées à la courge, aux concombres et aux citrouilles.",
			"Près de 1000 fleurs de jasmin et une douzaine de roses se retrouvent dans un seul flacon de parfum Chanel n ° 5.",
			"Les premiers jardins étaient strictement pratiques et étaient utilisés pour cultiver de la nourriture et des herbes médicinales. Vers 1500 avant JC en Egypte , les premiers jardins décoratifs sont apparus. ",
			"La Journée mondiale du jardinage nu est célébrée le premier samedi de mai. Il vise à promouvoir l'harmonie et la paix avec la nature.",
			"Selon Sir Francis Bacon, les jardins sont «les plaisirs humains les plus purs».",
			"Il existe au moins 10 000 variétés de tomates. Plus de 60 millions de tonnes de tomates sont produites chaque année, ce qui en fait le fruit le plus populaire au monde.",
			"Les jardins et la philosophie sont souvent considérés comme liés. Les philosophes notent la contribution du jardinage à la «bonne vie». ",
			"Les jardins suspendus de Babylone étaient l'une des sept merveilles du monde antique. Ils auraient été construits par le roi néo-babylonien Nabuchodonosor II en actuel Irak."];
	var index = Math.floor(Math.random() * fact.length)
	document.getElementById("factAnnouncer").innerHTML = "Fact #" + index;
	document.getElementById("dayFact").innerHTML = fact[index];

}
