paypal
  .Buttons({

    style: {
      shape: 'pill',
      color: 'gold',
      layout: 'vertical',
      label: 'paypal',

    },


    createOrder: function (data, actions) {
      return actions.order.create({
        purchase_units: [{
          amount: {
            value: document.getElementById('price').selectedOptions[0].value
          }
        }]
      });
    },


    onCancel: function (data) {
      window.location.href = 'payment.jsp';
    },

    //   onApprove: function (data, actions) {
    //     return fetch('/KLPR/paymentSuccess.jsp', {
    //       headers: {
    //         'content-type': 'application/json'
    //       },
    //       body: JSON.stringify({
    //         orderID: data.orderID
    //       })
    //     }).then(function (res) {
    //       return res.json();
    //     }).then(function (details) {
    //       alert('Transaction approved by ' + details.payer_given_name);

    //     })
    //   }
    // }).render('#paypal-button-container');



    onApprove: function (data, actions) {
      return actions.order.capture().then(function (details) {
        alert('Transaction completed by ' + details.payer.name.given_name);

        // console.log(data);
        // 여기서 이 data.orderID, data.payerID, 유저넘버, 결제날짜, 결제금액 디비에 넣는 작업 빌요

        buildSuccessPage(data);
      });
    }
  }).render('#paypal-button-container');




function buildSuccessPage(data) {

  // const orderInfo = JSON.stringify(data);
  // console.log(orderInfo);

  //아니면 여기서 처리하던가
  let success = `
    <div class="col-12">
      <div class="mypage-post p-2">
        <h3>Thank you for you purchasement!</h3>
        <div class="pt-1">orderID: ${JSON.stringify(data.orderID)}, payerID: ${JSON.stringify(data.payerID)}</div>
      </duv>
    </div>
            `;
  console.log(data);
  document.getElementById('success').innerHTML = success;
}