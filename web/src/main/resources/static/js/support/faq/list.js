window.addEventListener("load", function(){
    const test = document.querySelector(".faq-list-body");
    const liList = test.querySelectorAll(".content");

    liList.forEach(function(li) {
        li.onclick = function(e){
            e.preventDefault();

            // 클릭한 요소의 데이터 가져오기
            const datasetId = e.target.dataset.id;
            // 클릭한 요소가 이미 열려있는지 확인
            const isOpen = li.querySelector(".content-description") !== null;


            // 패치 사용
            if (isOpen) {
                const contentDescription = li.querySelector(".content-description");
                contentDescription.remove();
            } else {
                const url = `http://localhost/api/fqa/list?id=${datasetId}`;
                const options = {
                    method: 'GET',
                    credentials: 'include'
                };

                fetch(url, options)
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok');
                        }
                        return response.json();
                    })
                    .then(menu => {
                        const sectionHtml = `
                            <div class="content-description">
                                <p>${menu.content}</p>
                            </div>
                        `;
                        li.insertAdjacentHTML("beforeend", sectionHtml);
                    })
                    .catch(error => {
                        console.error('There was a problem with the fetch operation:', error);
                    });
            }
            

            // 온로드 사용
            // // 이미 열려있는 경우 닫음
            // if (isOpen) {
            //     const contentDescription = li.querySelector(".content-description");
            //     contentDescription.remove();
            // } else {
            //     let url = `http://localhost/api/fqa/list?id=${datasetId}`;
            //     let method = "GET";
            
            //     let xhr = new XMLHttpRequest();
            //     xhr.withCredentials = true;
            //     xhr.onload = function(){
            //         let menu = JSON.parse(this.responseText);
                    
            //         let sectionHtml = `
            //             <div class="content-description">
            //                 <p>${menu.content}</p>
            //             </div>
            //         `;
            
            //         li.insertAdjacentHTML("beforeend", sectionHtml);
            //     };
            
            //     xhr.open(method, url);
            //     xhr.send();
            // }
        }
    });
});