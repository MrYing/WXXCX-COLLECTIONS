//index.js
//获取应用实例
// var app = getApp();
Page({
  data: {
    indexmenu:[],
    imgUrls: []
  },
  onLoad:function(){
    this.initMenu();
  },
  initMenu:function(){
    this.setData({
      indexmenu:[
        {
          'icon':'./../../images/icon_01.png',
          'text':'产品介绍',
          'url':'introduce'
        },
        {
          'icon':'./../../images/icon_03.png',
          'text':'产品详情',
          'url':'productdetail'
        },
        {
          'icon':'./../../images/icon_05.png',
          'text':'热点新闻',
          'url':'news'
        },
        {
          'icon':'./../../images/icon_07.png',
          'text':'音频卡体验',
          'url':'voice'
        },
        {
          'icon':'./../../images/icon_09.png',
          'text':'银行卡科普',
          'url':'cardknowledge'
        },
        {
          'icon':'./../../images/icon_11.png',
          'text':'意见反馈',
          'url':'advice'
        }
  
      ],
      imgUrls: [
        '../../images/swiper_1.jpg',
        '../../images/swiper_2.jpg',
        '../../images/swiper_3.jpg'
      ]
    })
  },
  changeRoute:function(url){
    wx.navigateTo({
      url: `../${url}/${url}`
    })
  },
  onReady:function(){
    //生命周期函数--监听页面初次渲染完成
    // console.log('onReady');
  },
  onShow :function(){
    //生命周期函数--监听页面显示
    // console.log('onShow');
  },
  onHide :function(){
    //生命周期函数--监听页面隐藏
    // console.log('onHide');
  },
  onUnload :function(){
    //生命周期函数--监听页面卸载
    // console.log('onUnload');
  },
  onPullDownRefresh:function(){
    //页面相关事件处理函数--监听用户下拉动作
    // console.log('onPullDownRefresh');
  },
  onReachBottom:function(){
    //页面上拉触底事件的处理函数
    // console.log('onReachBottom');
  },
  onShareAppMessage: function () {
    return {
      title: '分享',
      path: 'pages/gongzonghao/gongzonghao'
    }
  }
})
