
$(function () {
  $(document).scroll(function () {
    var $nav = $("#mainNavbar");
    $nav.toggleClass("scrolled", $(this).scrollTop() > $nav.height());
  });
});


// password confirm
function check() {
  if (document.getElementById('signupPassword').value !==
    document.getElementById('passwordConfirm').value) {
    document.getElementById('message').innerHTML = "<div class='alert alert-danger mt-1' role='alert'>Password not matched</div>";
  }
}



// reed more btn
const readBtn = document.getElementsByClassName('read-more-trigger');
const wrap = document.getElementsByClassName('read-more-wrap');
const target = document.getElementsByClassName('read-more-target');

for (let i = 0; i < readBtn.length; i++) {
  readBtn[i].addEventListener('click', function (e) {
    if (readBtn[i].textContent === 'Read more') {
      readBtn[i].innerText = "Read less";
      wrap[i].classList.add('show');
      target[i].classList.add('show');
    }
    else if (readBtn[i].textContent === 'Read less') {
      readBtn[i].innerText = "Read more";
      wrap[i].classList.remove('show');
      target[i].classList.remove('show');
    }
  })
};





// for (let i = 0; i < readBox.length; i++) {
//   readBtn[i].addEventListener('click', (e) => {
//     readBox.checked = true;

//   });
// }



// service 선택(이사, 병원, 출입국사무소)
$('button').click(function () {
  inputs = $('.service');
  inputs.each(function () {
    var value;
    if ($(this).attr('type') === 'checkbox') {
      value = $(this).is(':checked') ? 1 : 0;
    }
  });
});

