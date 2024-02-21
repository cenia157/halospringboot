

function getAllStaffList() {
	fetch('/admin/manager/staff/list')
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
			let inputName = document.querySelector('#s_name');
			let inputPos = document.querySelector('#s_position');
			let inputPhonnum = document.querySelector('#s_phone_num');
			let inputEntryDate = document.querySelector('#s_entry_date');
			let inputColor = document.querySelector('#s_color');
			let inputAddr = document.querySelector('#s_addr');
			let inputSeq = document.querySelector('#s_no');



			inputName.value = empdata[indexVal].s_name;
			inputPos.value = empdata[indexVal].s_position;
			inputPhonnum.value = empdata[indexVal].s_phone_num;
			inputEntryDate.value = empdata[indexVal].s_entry_date;
			inputAddr.value = empdata[indexVal].s_addr;
			inputColor.value = empdata[indexVal].s_color;
			inputSeq.value = empdata[indexVal].s_no;

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

	let Name = document.querySelector('#s_name');
	let Pos = document.querySelector('#s_position');
	let Phonnum = document.querySelector('#s_phone_num');
	let EntryDate = document.querySelector('#s_entry_date');
	let Color = document.querySelector('#s_color');
	let Addr = document.querySelector('#s_addr');
	let Seq = document.querySelector('#s_no');

	Name.value = '';
	Pos.value = '';
	Phonnum.value = '';
	EntryDate.value = '';
	Addr.value = '';
	Color.value = '#FFD700';
	Seq.value = '';
}



window.onload = function() {
	let inputName = document.querySelector('#s_name');
	let inputPos = document.querySelector('#s_position');
	let inputPhonnum = document.querySelector('#s_phone_num');
	let inputEntryDate = document.querySelector('#s_entry_date');
	let inputColor = document.querySelector('#s_color');
	let inputAddr = document.querySelector('#s_addr');
	let inputSeq = document.querySelector('#s_no');


	const staffReg = document.querySelector("#staff-reg");
	staffReg.addEventListener('click', function(e) {
					console.log(inputName.value);
			console.log(inputPos.value);
			console.log(inputPhonnum.value);
			console.log(inputEntryDate.value);
			console.log(inputColor.value);
			console.log(inputAddr.value);
		if (!inputName.value || !inputPos.value || !inputPhonnum.value || !inputEntryDate.value || !inputColor.value || !inputAddr.value) {
			alert('すべての値を入力します。');
			return; // 함수 종료
		}
		e.preventDefault(); // 기본 동작(페이지 이동 등)을 막습니다.

		fetch('/admin/manager/staff', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				s_position: inputPos.value,
				s_name: inputName.value,
				s_phone_num: inputPhonnum.value,
				s_entry_date: inputEntryDate.value,
				s_color: inputColor.value,
				s_addr: inputAddr.value,
				s_no: inputSeq.value
			}),
		})
			.then(response => response.json())
			.then(data => {
				if (data == 1) {
					alert('登録完了です。');
					location.reload(); // 현재 위치를 다시 로드하면 페이지가 새로고침됩니다.
				}
			})
			.catch(error => {
				console.error('Error:', error);
			});
	});


	let empdata = null;

	getAllStaffList();




	let updateBtn = document.querySelector('#staff-update');
	updateBtn.addEventListener('click', function(event) {

		if (!inputName.value || !inputPos.value || !inputPhonnum.value || !inputEntryDate.value || !inputColor.value || !inputAddr.value || !inputSeq.value) {
			alert('すべての値を入力します。');
			return; // 함수 종료
		}

		fetch('/admin/manager/staff', {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({
				s_position: inputPos.value,
				s_name: inputName.value,
				s_phone_num: inputPhonnum.value,
				s_entry_date: inputEntryDate.value,
				s_color: inputColor.value,
				s_addr: inputAddr.value,
				s_no: inputSeq.value
			}),
		})
			.then(response => response.json())
			.then(data => {
				if (data == 1) {
					alert('変更完了です。')
					const staffUpdata = document.querySelector(".staff-table");
					staffUpdata.innerHTML = '';
					getAllStaffList()
				}
			})
			.catch(error => {
				console.error('Error:', error);
			});

	});

	let updateCBtn = document.querySelector('#staff-update-c');
	updateCBtn.addEventListener('click', regPage);

	let deleteBtn = document.querySelector('#staff-delete');
	deleteBtn.addEventListener('click', function(event) {
		let inputSeq = document.querySelector('#s_no');

		// 삭제 전 확인 메시지 표시
		let confirmDelete = confirm('本当に削除しますか？');

		// 사용자가 '확인'을 클릭했을 때만 삭제 실행
		if (confirmDelete) {
			fetch('/admin/manager/staff', {
				method: 'DELETE',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify({
					s_no: inputSeq.value
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



