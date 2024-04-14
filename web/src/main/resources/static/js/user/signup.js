window.addEventListener("DOMContentLoaded", function(){
    const emailBtn = document.getElementById("emailbutton");
    const sbmit = document.querySelector(".signup-block-button");
    const emailState = document.querySelector(".state");
    const emailPrintState = document.querySelector(".printstate");

    sbmit.onclick = function(e){
        //버튼 태그가 아닌건 실행되지 않게
        if(e.target.tagName != "INPUT")
            return;

        if(emailState.value === ""){
            alert("이메일 인증을 완료해주세요.");
            e.preventDefault();
            return;
        }

    }
    
    emailBtn.onclick = function(e){
        // 현재 클릭되는 태그를 반환해줌
        console.log(e.target);

        //버튼 태그가 아닌건 실행되지 않게
        if(e.target.tagName != "BUTTON")
            return;

        let email = document.getElementById("emailinput").value;
        if (email) {
            sendVerificationEmail(email);
        } else {
            alert("이메일 주소를 입력해주세요.");
        }
    };

    function sendVerificationEmail(email) {
        // AJAX를 사용하여 서버로 이메일 주소 전송
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "/sendVerificationEmail", true);
        xhr.setRequestHeader("Content-Type", "application/json");

        // CSRF 토큰 가져오기
        let csrfToken = document.querySelector(".token").getAttribute("value");
        xhr.setRequestHeader("X-CSRF-TOKEN", csrfToken); // CSRF 토큰 설정
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                // 요청이 완료되면 중복 요청 변수를 재설정합니다.
                isRequestInProgress = false;

                if (xhr.status === 200) {
                    // 서버에서 정상적인 응답을 받았을 때
                    let responseData = xhr.responseText;
                    alert("인증 이메일이 전송되었습니다.\n3분 안에 인증키를 입력해주세요.");

                    //버튼 박스 선택
                    const emailBtn = document.querySelector(".email_button");

                    // 새로운 div 엘리먼트 생성
                    const div = document.createElement("div");
                    // 오른쪽 정렬을 위해 스타일을 설정
                    div.style.textAlign = "right";

                    // 새로운 인풋 엘리먼트 생성
                    const input = document.createElement("input");
                    input.type = "text";
                    input.placeholder = "인증키 입력";

                    // 현재 시간을 보여줄 span 엘리먼트 생성
                    const timeSpan = document.createElement("span");

                    // 새로운 button 엘리먼트 생성
                    const button = document.createElement("button");
                    button.type = "button";
                    button.textContent = "확인";

                    // div 안에 input과 button을 추가
                    div.appendChild(timeSpan);
                    div.appendChild(input);
                    div.appendChild(button);



                    // 버튼에 클릭 이벤트 추가
                    button.addEventListener("click", function() {
                        if(input.value == responseData){
                            alert("이메일 인증이 완료되었습니다.");
                            emailPrintState.innerHTML = "인증완료";
                            emailPrintState.style="color:green";
                            emailState.value = "true";
                            div.parentNode.removeChild(div);
                        }
                        else
                            alert("코드를 다시 한 번 확인해주세요.");
                    });

                    // email_button 요소의 다음 형제로 div 추가
                    // emailBtn.parentNode.insertBefore(div, emailBtn.nextSibling);

                    // email_button 요소에 새로운 div를 자식으로 추가
                    emailBtn.appendChild(div);

                    // 3분 후에 타임아웃을 실행하여 인증을 완료하지 않은 경우 처리.
                    let time = 60;
                    startTimer(time, timeSpan, div); //초와 초가 나올 노드와, 삭제할 노드
                    
                
                } else {
                    alert("이메일 전송에 실패했습니다.");
                }
            }
        };
        xhr.send(JSON.stringify({ email: email }));

    }

    // 타이머 설정 인자값으로 초, 노드를 실행
    function startTimer(sec, span, delDiv) {
        let timeLeft = sec;

        const timerInterval = setInterval(() => {
            const minutes = Math.floor(timeLeft / 60);
            const seconds = timeLeft % 60;
            const formattedTime = `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
            span.textContent = formattedTime;

            // 시간이 다 되면 타이머 중지 및 div 제거
            if (timeLeft === 0) {
                clearInterval(timerInterval);
                delDiv.parentNode.removeChild(delDiv);
            }

            timeLeft--;
        }, 1000);
    }

});