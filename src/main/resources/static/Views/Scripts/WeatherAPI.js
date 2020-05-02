var request = new XMLHttpRequest()

request
		.open(
				'GET',
				'https://api.openweathermap.org/data/2.5/onecall?lat=48.823071&lon=2.273390&appid=5582ef0be94efc6f5ec6e218b422f74f',
				true)
request.onload = function() {
	var data = JSON.parse(this.response)

	var temp = data.current.temp;
	var temp2 = Math.round(temp - 273);
	var temp3 = temp2.toString();
	var tempF = (temp3.concat(" °C"));

	var humi = data.current.humidity.toString();
	var humiF = (humi.concat(" %"));

	var wind = data.current.wind_speed.toString();
	var windF = (wind.concat(" m/s"));

	var sunrise = (getTimeString(data.current.sunrise));
	var sunset = (getTimeString(data.current.sunset));

	var tomorrowtemp = (Math.round(data.daily[1].temp.day - 273)).toString()
			.concat(" °C");
	var tomorrowWeather = tomorrowtemp
			.concat(" + ", data.daily[1].weather[0].description);

	var J2temp = (Math.round(data.daily[2].temp.day - 273)).toString().concat(
			" °C");
	var J2Weather = J2temp.concat(" + ", data.daily[2].weather[0].description);
	
	function getTimeString(sun) {
		var date = new Date(sun * 1000);
		var hours = date.getHours();
		var minutes = "0" + date.getMinutes();
		return hours + 'h' + minutes.substr(-2);
	}

	var iconName = data.current.weather[0].description;
	var iconURL = getWeatherIcon(iconName);
	function getWeatherIcon(description) {
		switch (description) {
		case "clear sky":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/sun-with-face_1f31e.png";
			break;
		case "overcast clouds":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/sun-with-face_1f31e.png";
			break;
		case "few clouds":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/sun-behind-cloud_26c5.png"
			break;
		case "scattered clouds":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/cloud_2601.png"
			break;
		case "broken clouds":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/cloud_2601.png"
			break;
		case "shower rain":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/cloud-with-rain_1f327.png"
			break;
		case "rain":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/cloud-with-rain_1f327.png"
			break;
		case "thunderstorm":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/thunder-cloud-and-rain_26c8.png"
			break;
		case "snow":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/cloud-with-snow_1f328.png"
			break;
		case "mist":
			return "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/microsoft/209/fog_1f32b.png"
			break;
		}
	}

	if (request.status >= 200 && request.status < 400) {
		document.getElementById("weatherIcon").src = iconURL;
		document.getElementById("temp").innerHTML = tempF;
		document.getElementById("humi").innerHTML = humiF;
		document.getElementById("wind").innerHTML = windF;
		document.getElementById("sunrise").innerHTML = sunrise;
		document.getElementById("sunset").innerHTML = sunset;

		document.getElementById("tomorrowTemp").innerHTML = tomorrowWeather;
		document.getElementById("J2Temp").innerHTML = J2Weather;

	} else {
		console.log('error with weather API')
	}
}
request.send()