const options = { weekday: 'long', month: 'long', day: 'numeric' };
var d = new Date();
var fd = d.toLocaleDateString("fr-FR", options);
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


