window.onload=function(){
	


let selectedYear = document.getElementById("getYear").value;
let selectedMonth = document.getElementById("getMonth").value;
let selectedDay = document.getElementById("getDay").value;

console.log(selectedYear);
console.log(selectedMonth);
console.log(selectedDay);

let yearSelect = document.getElementById("userYear");
let currentYear = new Date().getFullYear();
for (let year = currentYear; year >= 1900; year--) {
    let option = document.createElement("option");
    option.text = year;
    option.value = year;
    if (year === parseInt(selectedYear)) {
        option.selected = true;
    }
    yearSelect.appendChild(option);
}

let monthSelect = document.getElementById("userMonth");
for (let month = 1; month <= 12; month++) {
	let option = document.createElement("option");
    option.text = month;
    option.value = month;
    if (month === parseInt(selectedMonth)) {
        option.selected = true;
    }
    monthSelect.appendChild(option);
}

let daySelect = document.getElementById("userDay");
for (let day = 1; day <= 31; day++) {
	let option = document.createElement("option");
    option.text = day;
    option.value = day;
    if (day === parseInt(selectedDay)) {
        option.selected = true;
    }
    daySelect.appendChild(option);
}
}