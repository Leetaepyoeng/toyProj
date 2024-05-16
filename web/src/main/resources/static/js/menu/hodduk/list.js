window.addEventListener("load", function(){
    // 좋아요 버튼을 모두 선택
    let likeButtons = document.querySelectorAll(".like-block .icon");

    // 각 버튼에 대해 이벤트 리스너를 추가
    likeButtons.forEach(function(button) {
        // 상태를 저장할 객체 생성
        // 초기 상태는 서버에서 가져옴
        let state = {
            userId: button.dataset.userid,
            menuId: button.dataset.menuid,
            liked: button.dataset.like
        };

        button.addEventListener("click", function(e) {
            e.preventDefault();

            // 여기에 이벤트 핸들러 코드를 추가
            let userIdtest = state.userId;
            let menuIdtest = state.menuId;

            console.log("유저 id:", userIdtest);
            console.log("메뉴 id:", menuIdtest);

            if(userIdtest == undefined || userIdtest == null){
                alert("로그인 이후 사용 가능합니다.");
                return;
            }
            let methodBox = state.liked == "false" ? "POST" : "DELETE";

            // e.preventDefault();
            // icon-heart handler
            {
                fetch('http://localhost:80/api/hodduk-likes', {
                    method: methodBox,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        hoddukId: menuIdtest,
                        userId: userIdtest,
                    })
                })
                .then(response => response.json())
                .then(data => console.log(data))
                .catch(error => console.error('Error:', error));
            }
        });
    });


})

