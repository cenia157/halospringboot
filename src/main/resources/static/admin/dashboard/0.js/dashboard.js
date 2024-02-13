const today = new Date();
const year = today.getFullYear();
const month = String(today.getMonth() + 1);
const day = String(today.getDate());

const formattedToday = `${year}-${month}-${day}`;

window.onload = function() {
	let params = {
		year : year,
		month : month
	}

	fetch('/admin/dashboard/list', {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(params),
	})
		.then(response => response.json())
		.then(dashboardData => {
			let eachDay = null;
			console.log(dashboardData);

							let cnt = 1;
							for (let i = 0; i < dashboardData.reservationAccpectSchedule.length; i++) {
								// 쉼표를 기준으로 데이터 분리
								let dataArray = dashboardData.reservationAccpectSchedule[i].sa_days.split(',');
								for (let j = 0; j < dataArray.length; j++) {
									if (dataArray[j] == day) {
										let time = '終日';
										if (dashboardData.reservationAccpectSchedule[i].sa_time == 'AM') {
											time = '午前';
										} else {
											time = '午後';
										}
										document.querySelector(".reservationList").innerHTML += `<div class="deshboard-todo reservation" id="${i}">
				                        <div class="deshboard-todo-cell service">${cnt}</div>
				                        <div class="deshboard-todo-cell name">${dashboardData.reservationAccpectSchedule[i].sa_user_name}</div>
				                        <div class="deshboard-todo-cell phonNum">${dashboardData.reservationAccpectSchedule[i].sa_phone_number}</div>
				                        <div class="deshboard-todo-cell time">${time}</div>
				                    </div>`;
										cnt++;
									}
								}
							}

			//				cnt = 1;
			//				for (let i = 0; i < dashboardData.unAnswered.length; i++) {
			//	
			//					document.querySelector(".qalist").innerHTML += `<div class="deshboard-todo qa" id="${i}">
			//	                        <div class="deshboard-todo-cell service">${cnt}</div>
			//	                        <div class="deshboard-todo-cell title">${dashboardData.unAnswered[i].q_title}</div>
			//	                        <div class="deshboard-todo-cell writer">${dashboardData.unAnswered[i].q_name}</div>
			//	                        <div class="deshboard-todo-cell reg-date">${dashboardData.unAnswered[i].q_reg_date}</div>
			//	                    </div>`;
			//					cnt++;
			//				}

							cnt = 1;
							for (let i = 0; i < dashboardData.companySchedule.length; i++) {
								// 쉼표를 기준으로 데이터 분리
								let dataArray = dashboardData.companySchedule[i].cs_date.split(',');
								for (let j = 0; j < dataArray.length; j++) {
									if (dataArray[j] == day) {
										document.querySelector(".eventlist").innerHTML += `<div class="deshboard-todo company" id="${i}">
								                        <div class="deshboard-todo-cell service">${cnt}</div>
								                        <div class="deshboard-todo-cell company-title">${dashboardData.companySchedule[i].cs_title}</div>
								                        <div class="deshboard-todo-cell company-txt">${dashboardData.companySchedule[i].cs_txt}</div>
								                    </div>`;
										cnt++;
									}
								}
							}
							
							cnt = 1;
							for (let i = 0; i < dashboardData.staffSchedule.length; i++) {
								// 쉼표를 기준으로 데이터 분리
								let dataArray = dashboardData.staffSchedule[i].f_dates.split(',');
								for (let j = 0; j < dataArray.length; j++) {
									if (dataArray[j] == day) {
										document.querySelector(".staffList").innerHTML += `<div class="deshboard-todo staff" id="${i}">
								                        <div class="deshboard-todo-cell service">${cnt}</div>
								                        <div class="deshboard-todo-cell staff-name">${dashboardData.staffSchedule[i].s_name}</div>
								                        <div class="deshboard-todo-cell staff-position">${dashboardData.staffSchedule[i].s_position}</div>
								                        <div class="deshboard-todo-cell staff-phone">${dashboardData.staffSchedule[i].s_phone_num}</div>
								                    </div>`;
										cnt++;
									}
								}
							}
		});
};
