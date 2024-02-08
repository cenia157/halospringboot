let empdata = null;

function getAllCustomerInfo() {
	const selectDate = document.querySelector('#monthSelect');

	fetch('CustomerInfo')
		.then(response => response.json())

		.then(data => {
			empdata = data;
			console.log(data);

			console.log(selectDate.value);
			for (let i = 0; i < data.length; i++) {
				let formattedmonth = data[i].month < 10 ? `0${data[i].month}` : data[i].month;
				if (selectDate.value != data[i].year + '-' + formattedmonth) {
					continue;
				}

				let addr = `連絡先 : ${data[i].addr} <br> 出発先* : ${data[i].startPlace} `;
				if (!data[i].startPlace) {
					addr = `連絡先 : ${data[i].addr}`;
				} else if (!data[i].addr) {
					addr = ` 出発先* : ${data[i].startPlace}`;
				}
				document.querySelector(".content-dataWrapDiv").innerHTML += `<div class="content-dataOneRowDiv"><div class="content-dataOneRowDiv-innerDiv columnName-no"><span>${data[i].pkNo}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-customer"><span>${data[i].userName}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-address"><span>${addr}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-number"><span>${data[i].phoneNumber}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-service"><span>${data[i].service}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-note"><span>${data[i].feedBack}</span></div></div>`;
			}
		})
}


document.addEventListener('DOMContentLoaded', function() {
	// 여기에 코드 작성
	const selectDate = document.querySelector('#monthSelect');
	console.log("selectDate.value: " + selectDate.value);
	selectDate.value = new Date().toISOString().slice(0, 7);

	// getAllCustomerInfo()

	// 날짜 선택
	selectDate.addEventListener('change', function(event) {
		// List 초기화
		const list = document.querySelector(".content-dataWrapDiv");
		list.innerHTML = '';
		getAllCustomerInfo();
	})

	getAllCustomerInfo();
});





