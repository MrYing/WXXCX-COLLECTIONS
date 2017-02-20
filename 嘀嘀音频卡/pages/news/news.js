// pages/news/news.js
Page({
  data: {
    newslist: [],
    scrolltop: null, //滚动位置
    page: 0 //分页
  },
  onLoad: function (options) {
    //后台查询新闻列表数据、分页
    this.fetchNewsData();
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
  },
  fetchNewsData: function () { //获取新闻列表
    var that = this
    const perpage = 5;
    this.setData({
      page: this.data.page + 1
    })
    const page = this.data.page;
    var nnews = [];
    // for (var i = (page - 1) * perpage; i < page * perpage; i++) {
    //每次查询一条新闻信息数据
    //wx.request
    // }
    //或者每次直接查询10条新闻
    wx.showNavigationBarLoading()
    wx.request({
      url: 'https://wx.excecard.com/xcxdemo/xcx/news/newslist.do',
      data: {
        "page": page,
        "perpage": perpage
      },
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function (res) {
        // success
        nnews = res.data
        // console.log('nnews:' + JSON.stringify(nnews))
      },
      fail: function () {
        // fail
      },
      complete: function () {
        wx.hideNavigationBarLoading()
        // complete
        if (nnews.length > 0) {
          that.setData({
            newslist: that.data.newslist.concat(nnews)
          })
          console.log('this.data.newslist>> ' + that.data.newslist)
        }

      }
    })


  },
  scrollLoading: function () {   //滚动加载
    this.fetchNewsData();
  },
  scrollHandle: function (e) {  //滚动事件
    this.setData({
      scrolltop: e.detail.scrollTop
    })
  },
  goToTop: function () { //回到顶部
    this.setData({
      scrolltop: 0
    })
  },
  // onPullDownRefresh: function () {  //下拉刷新
  //   console.log('onPullDownRefresh invoke..')
  //   //清空重置已加载的数据
  //   this.setData({
  //     page: 0,
  //     newslist: []
  //   })
  //   this.fetchNewsData();
  //   //设置请求时间
  //   setTimeout(() => {
  //     wx.stopPullDownRefresh();
  //   }, 1000)

  // },
  // onPullDownRefresh: function () {
  //   // Do something when pull down.
  //   console.log('刷新');
  // },

  onReachBottom: function (e) {
    // this.setData({
    //   page: 0,
    //   newslist: []
    // })
    this.fetchNewsData();
  },

})
