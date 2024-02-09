function getAllStaffList() {
	fetch('StaffList')
		.then(response => response.json())
		.then(data => {
			empdata = data;
			for (let i = 0; i < data.length; i++) {
				document.querySelector(".staff-table").innerHTML += `<input type="hidden" value="${i}"><div class="table-row"><div class="cell steff-num">${data[i].s_no}</div><div class="cell steff-pos">${data[i].s_position}</div><div class="cell steff-name">${data[i].s_name}</div><div class="cell steff-callnum">${data[i].s_phone_num}</div><div class="cell steff-addr">${data[i].s_addr}</div><div class="cell steff-entryDate">${data[i].s_entry_date}</div><input type="hidden" value="${data[i].s_color}">`;
			}
		})
		.catch(error => {
			console.error('There was a problem with the fetch operation:', error);
		});

	const staffUpdata = document.querySelector(".staff-table");
	staffUpdata.addEventListener('click', function(event) {
		if (event.target.parentNode.previousElementSibling && event.target.parentNode.previousElementSibling.value != null) {
				const indexVal = event.target.parentNode.previousElementSibling.value;
				let updateName = document.querySelector('#input-staff-name');
				let updatePos = document.querySelector('#input-staff-pos');
				let updatePhonnum = document.querySelector('#input-staff-callNum');
				let updateEntryDate = document.querySelector('#input-staff-entryDate');
				let updateColor = document.querySelector('#input-staff-color');
				let updateAddr = document.querySelector('#input-steff-addr');
				let updateSeq = document.querySelector('#staff-seq');

				updateName.value = empdata[indexVal].s_name;
				updatePos.value = empdata[indexVal].s_position;
				updatePhonnum.value = empdata[indexVal].s_phone_num;
				updateEntryDate.value = empdata[indexVal].s_entry_date;
				updateAddr.value = empdata[indexVal].s_addr;
				updateColor.value = empdata[indexVal].s_color;
				updateSeq.value = empdata[indexVal].s_no;

				let regBtn = document.querySelector('#staff-reg');
				let updateBtn = document.querySelector('#staff-update');
				let updateCBtn = document.querySelector('#staff-update-c');
				let deleteBtn = document.querySelector('#staff-delete');
				let regTitle = document.querySelector('#reg-title');
				let updateTitle = document.querySelector('#update-title');

				regBtn.style.display = 'none';
				updateBtn.style.display = 'block';
				updateCBtn.style.display = 'block';
				deleteBtn.style.display = 'block';
				regTitle.style.display = 'none';
				updateTitle.style.display = 'block';
			}
		});
}


function regPage() {
	let regBtn = document.querySelector('#staff-reg');
	let updateBtn = document.querySelector('#staff-update');
	let deleteBtn = document.querySelector('#staff-delete');
	let updateCBtn = document.querySelector('#staff-update-c');
	let regTitle = document.querySelector('#reg-title');
	let updateTitle = document.querySelector('#update-title');
	regBtn.style.display = 'block';
	updateBtn.style.display = 'none';
	updateCBtn.style.display = 'none';
	deleteBtn.style.display = 'none';
	regTitle.style.display = 'block';
	updateTitle.style.display = 'none';

	let updateName = document.querySelector('#input-staff-name');
	let updatePos = document.querySelector('#input-staff-pos');
	let updatePhonnum = document.querySelector('#input-staff-callNum');
	let updateEntryDate = document.querySelector('#input-staff-entryDate');
	let updateColor = document.querySelector('#input-staff-color');
	let updateAddr = document.querySelector('#input-steff-addr');
	let updateSeq = document.querySelector('#staff-seq');

	updateName.value = '';
	updatePos.value = '';
	updatePhonnum.value = '';
	updateEntryDate.value = '';
	updateAddr.value = '';
	updateColor.value = '#FFD700';
	updateSeq.value = '';
}



window.onload = function() {
	let empdata = null;

	getAllStaffList()




	let updateBtn = document.querySelector('#staff-update');
	updateBtn.addEventListener('click', function(event) {
		let updateName = document.querySelector('#input-staff-name');
		let updatePos = document.querySelector('#input-staff-pos');
		let updatePhonnum = document.querySelector('#input-staff-callNum');
		let updateEntryDate = document.querySelector('#input-staff-entryDate');
		let updateColor = document.querySelector('#input-staff-color');
		let updateAddr = document.querySelector('#input-steff-addr');
		let updateSeq = document.querySelector('#staff-seq');

		if (!updateName.value || !updatePos.value || !updatePhonnum.value || !updateEntryDate.value || !updateColor.value || !updateAddr.value || !updateSeq.value) {
			alert('すべての値を入力します。');
			return; // 함수 종료
		}

		fetch('StaffUpdate', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				s_position: updatePos.value,
				s_name: updateName.value,
				s_phone_num: updatePhonnum.value,
				s_entry_date: updateEntryDate.value,
				s_color: updateColor.value,
				s_addr: updateAddr.value,
				s_no: updateSeq.value
			}),
		})
		alert('수정 완료')
		const staffUpdata = document.querySelector(".staff-table");
		staffUpdata.innerHTML = '';
		getAllStaffList()

	});

	let updateCBtn = document.querySelector('#staff-update-c');
	updateCBtn.addEventListener('click', regPage);

	let deleteBtn = document.querySelector('#staff-delete');
	deleteBtn.addEventListener('click', function(event) {
		let updateSeq = document.querySelector('#staff-seq');

		// 삭제 전 확인 메시지 표시
		let confirmDelete = confirm('本当に削除しますか？');

		// 사용자가 '확인'을 클릭했을 때만 삭제 실행
		if (confirmDelete) {
			fetch('StaffDelete', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({
					s_no: updateSeq.value
				}),
			}).then(() => {
				// 삭제 완료 메시지 표시
				alert('削除完了です。');

				// 삭제 후 필요한 작업 수행
				const staffUpdate = document.querySelector(".staff-table");
				staffUpdate.innerHTML = '';
				regPage();
				getAllStaffList();
			}).catch(error => {
				console.error('삭제 중 오류 발생:', error);
			});
		} else {
			// '취소'를 클릭한 경우
			alert('削除が取り消されました。');
		}
	});


}



