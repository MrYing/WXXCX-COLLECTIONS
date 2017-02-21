// pages/news/news.js
Page({
  data: {
    "currentid": null,  //当前new详情页的新闻id
    "currentnew": null,
    "contentlist": []
  },
  onLoad: function (options) {
    var that = this
    // 页面初始化 options为页面跳转所带来的参数
    console.log('新闻id:>>' + options.id)
    this.setData({
      "currentid": options.id
    })
    //根据新闻id请求后台，查询对应新闻内容
    wx.showNavigationBarLoading()
    wx.request({
      url: 'https://wx.excecard.com/xcxdemo/xcx/newsdetail/getContent.do',
      data: {
        "newId": that.data.currentid
      },
      method: 'GET', 
      // header: {}, // 设置请求的 header
      success: function (res) {
        that.setData({
          currentnew: res.data[0]
        })
        // console.log('请求新闻内容得到内容:>>' + JSON.stringify(that.data.currentnew))
      },
      fail: function () {
        // fail
      },
      complete: function () {
        // complete
        wx.hideNavigationBarLoading()
      }
    })
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
  }
})