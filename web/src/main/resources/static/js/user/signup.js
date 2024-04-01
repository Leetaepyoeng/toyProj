window.addEventListener("DOMContentLoaded", function(){
    var emailBtn = document.getElementById("emailbutton");
    
    emailBtn.onclick = function(e){
        // 현재 클릭되는 태그를 반환해줌
        console.log(e.target);

        //버튼 태그가 아닌건 실행되지 않게
        if(e.target.tagName != "BUTTON")
            return;

        var email = document.getElementById("emailinput").value;
        if (email) {
            sendVerificationEmail(email);
        } else {
            alert("이메일 주소를 입력해주세요.");
        }
    };

    function sendVerificationEmail(email) {
        // AJAX를 사용하여 서버로 이메일 주소 전송
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/sendVerificationEmail", true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                // 요청이 완료되면 중복 요청 변수를 재설정합니다.
                isRequestInProgress = false;

                if (xhr.status === 200) {
                    alert("인증 이메일이 전송되었습니다.");
                } else {
                    alert("이메일 전송에 실패했습니다.");
                }
            }
        };
        xhr.send(JSON.stringify({ email: email }));
    }

});