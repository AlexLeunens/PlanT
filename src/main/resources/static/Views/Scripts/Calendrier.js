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
		fact = ['Le vent de novembre arrache la dernière feuille.','Gelée de novembre, adieu l\'herbe tendre.'];
		break;
	case 11:
		fact = ['Décembre prend et ne rend.',' Si décembre est sous la neige, la récolte se protège.'];
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

}
