let empdata = null;

function getAllCustomerInfo() {
	const selectDate = document.querySelector('#monthSelect');

	fetch('/admin/customerCare/customerInfoMgmt', {
			method: 'POST',})
		.then(response => response.json())

		.then(data => {
			empdata = data;
			console.log(data);

			console.log(selectDate.value);
			for (let i = 0; i < data.length; i++) {
				let formattedmonth = data[i].sa_month < 10 ? `0${data[i].sa_month}` : data[i].sa_month;
				if (selectDate.value != data[i].sa_year + '-' + formattedmonth) {
					continue;
				}

				let addr = `出発先 : ${data[i].sa_start_place} <br> 到着先* : ${data[i].sa_end_place} `;
				if (data[i].sa_start_place == "undefined") {
					addr = `出張先 : ${data[i].sa_addr}`;
				} 
				let feedback = `${data[i].sa_feedback}`;
				let feedbackFix = feedback.split('\n')[0] + '<br> ' + feedback.split('\n')[1];
				
				
				document.querySelector(".content-dataWrapDiv").innerHTML += `<div class="content-dataOneRowDiv"><div class="content-dataOneRowDiv-innerDiv columnName-no"><span>${data[i].sa_seq}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-customer"><span>${data[i].sa_user_name}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-address"><span>${addr}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-number"><span>${data[i].sa_phone_number}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-service"><span>${data[i].sa_service}</span></div><div class="content-dataOneRowDiv-innerDiv columnName-note"><div>${feedbackFix}</div></div></div>`;
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





