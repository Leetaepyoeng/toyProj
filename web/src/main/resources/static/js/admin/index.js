function toggleSubMenu(event) {
    

    event.preventDefault();
    var target = event.currentTarget.parentElement;
    target.classList.toggle("active");

    // 이벤트의 target을 통해 클릭된 요소를 가져옵니다.
    var clickedLink = event.target;
    
    // 클릭된 링크의 부모인 <li> 요소를 찾습니다.
    var parentListItem = clickedLink.parentNode;

    // topLevelListItem의 높이가 0이면 200px로, 그렇지 않으면 0으로 설정
    parentListItem.style.height = parentListItem.offsetHeight === 40 ? '124px' : '40px';
}