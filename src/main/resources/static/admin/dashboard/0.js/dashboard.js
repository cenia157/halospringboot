const today = new Date();
const year = today.getFullYear();
const month = String(today.getMonth() + 1);
const day = String(today.getDate());

const formattedToday = `${year}-${month}-${day}`;

window.onload = function() {

	fetch('dashboard/list?year=' + year + '&month=' + month, {
		method: 'POST',
	})
			.then(response => response.json())
			.then(dashboardData => {
				let eachDay = null;
				console.log(dashboardData);

	//			let cnt = 1;
	//			for (let i = 0; i < dashboardData.reservationAccpectSchedule.length; i++) {
	//				// 쉼표를 기준으로 데이터 분리
	//				let dataArray = dashboardData.reservationAccpectSchedule[i].dates.split(',');
	//				for (let j = 0; j < dataArray.length; j++) {
	//					if (dataArray[j] == day) {
	//						let time = '終日';
	//						if (dashboardData.reservationAccpectSchedule[i].time == 'AM') {
	//							time = '午前';
	//						} else {
	//							time = '午後';
	//						}
	//						document.querySelector(".reservationList").innerHTML += `<div class="deshboard-todo reservation" id="${i}">
	//                        <div class="deshboard-todo-cell service">${cnt}</div>
	//                        <div class="deshboard-todo-cell name">${dashboardData.reservationAccpectSchedule[i].userName}</div>
	//                        <div class="deshboard-todo-cell phonNum">${dashboardData.reservationAccpectSchedule[i].phoneNumber}</div>
	//                        <div class="deshboard-todo-cell time">${time}</div>
	//                    </div>`;
	//						cnt++;
	//					}
	//				}
	//			}
	//			
	//			cnt = 1;
	//			for (let i = 0; i < dashboardData.unAnswered.length; i++) {
	//
	//				document.querySelector(".qalist").innerHTML += `<div class="deshboard-todo qa" id="${i}">
	//                        <div class="deshboard-todo-cell service">${cnt}</div>
	//                        <div class="deshboard-todo-cell title">${dashboardData.unAnswered[i].q_title}</div>
	//                        <div class="deshboard-todo-cell writer">${dashboardData.unAnswered[i].q_name}</div>
	//                        <div class="deshboard-todo-cell reg-date">${dashboardData.unAnswered[i].q_reg_date}</div>
	//                    </div>`;
	//				cnt++;
	//			}
	//		
	//			cnt = 1;
	//			for (let i = 0; i < dashboardData.companySchedule.length; i++) {
	//				// 쉼표를 기준으로 데이터 분리
	//				let dataArray = dashboardData.companySchedule[i].date.split(',');
	//				for (let j = 0; j < dataArray.length; j++) {
	//					if (dataArray[j] == day) {
	//						document.querySelector(".eventlist").innerHTML += `<div class="deshboard-todo company" id="${i}">
	//				                        <div class="deshboard-todo-cell service">${cnt}</div>
	//				                        <div class="deshboard-todo-cell company-title">${dashboardData.companySchedule[i].title}</div>
	//				                        <div class="deshboard-todo-cell company-txt">${dashboardData.companySchedule[i].txt}</div>
	//				                    </div>`;
	//						cnt++;
	//					}
	//				}
	//			}
	//			
	//			cnt = 1;
	//			for (let i = 0; i < dashboardData.staffSchedule.length; i++) {
	//				// 쉼표를 기준으로 데이터 분리
	//				let dataArray = dashboardData.staffSchedule[i].f_dates.split(',');
	//				for (let j = 0; j < dataArray.length; j++) {
	//					if (dataArray[j] == day) {
	//						document.querySelector(".staffList").innerHTML += `<div class="deshboard-todo staff" id="${i}">
	//				                        <div class="deshboard-todo-cell service">${cnt}</div>
	//				                        <div class="deshboard-todo-cell staff-name">${dashboardData.staffSchedule[i].s_name}</div>
	//				                        <div class="deshboard-todo-cell staff-position">${dashboardData.staffSchedule[i].s_position}</div>
	//				                        <div class="deshboard-todo-cell staff-phone">${dashboardData.staffSchedule[i].s_phone_num}</div>
	//				                    </div>`;
	//						cnt++;
	//					}
	//				}
	//			}
			});
};
