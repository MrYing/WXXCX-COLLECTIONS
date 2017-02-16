var util = require('../../utils/util.js');
Page({
  data: {
    // selected:null,
    selectedid: null
  },
  onLoad: function () {

  },
  submitAdvice: function (e) {
    console.log(e.detail.value)
    var advice = e.detail.value.myadvice;
    wx.showModal({
      title: '提示',
      content: '确定要提交信息么?',
      success: function (res) {
        if (res.confirm) {
          console.log(advice);
          wx.request({
            url: 'https://wx.excecard.com/xcxdemo/xcx/advice/submit.do',
            data: {
              advice: e.detail.value.myadvice
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded;charset=UTF-8'
            },
            method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
            // header: {}, // 设置请求的 header
            success: function (res) {
              console.log(JSON.stringify(res)) //{"errMsg":"request:ok","data":0,"statusCode":200}
              var ret = parseInt(res.data);
              if (ret == 1) {
                wx.showToast({
                  title: '成功',
                  icon: 'success',
                  duration: 2000,
                  success: function () {
                  }
                })

                setTimeout(function () {
                  wx.navigateBack({
                    delta: 1, // 回退前 delta(默认为1) 页面
                    success: function (res) {
                      // success
                    }
                  })
                }, 2000)


              }
            },
            fail: function () {
              // fail
              //  console.log('request result:'+res)
              //  wx.redirectTo({
              //   url: '../../pages/index/index'
              // })
              wx.showToast({
                title: '失败',
                icon: 'success',
                duration: 2000
              })
            },
            complete: function (res) {
              // complete
              if (res == null || res.data == null) {
                console.error('网络请求失败');
                return;
              }
            }
          }, 2000);
        }
      }
    })
  }
})
