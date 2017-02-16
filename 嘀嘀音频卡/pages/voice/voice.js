// pages/voice/voice.js
Page({
  data: {
    poster: '/images/swiper_3.jpg',
    name: '音频卡',
    author: '卓智长天',
    src: 'https://wx.excecard.com/xcxdemo/voice.mp3',
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数

  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  }, mytouchstart: function (e) {
    console.log(e.timeStamp + '- touch start')
  },//长按事件
  mylongtap: function (e) {
    console.log('开始播放播放')
    wx.playBackgroundAudio({
      //播放地址
      dataUrl: 'https://wx.excecard.com/xcxdemo/voice2.mp3',
      //title 音乐名字
      title: '卓智长天',
      coverImgUrl: ''

    })

  },
  mytouchend: function (e) {
    console.log('结束播放')
    wx.stopBackgroundAudio()
  }
})