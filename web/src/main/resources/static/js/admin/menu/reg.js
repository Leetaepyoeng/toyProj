
document.addEventListener('DOMContentLoaded', function() {
    // DOM이 완전히 로드된 후에 실행되는 코드
    document.getElementById('imageUpload').addEventListener('change', function(event) {
        const files = event.target.files;
        const imagePreview = document.getElementById('imagePreview');
        imagePreview.innerHTML = ''; // 기존에 표시된 미리보기 초기화

        for (let i = 0; i < files.length; i++) {
            const file = files[i];
            const reader = new FileReader();

            reader.onload = function(e) {
                const img = document.createElement('img');
                img.src = e.target.result;
                img.alt = `미리보기 이미지 ${i + 1}`;
                img.style.width = '100px'; // 이미지 크기 조정
                img.style.height = '100px';
                imagePreview.appendChild(img);
            };

            reader.readAsDataURL(file);
        }
    });
});