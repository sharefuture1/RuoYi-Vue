from pyspider.libs.base_handler import *

# 定义一个处理页面的处理器类
class Handler(BaseHandler):
    # 爬虫配置项，用于全局配置爬虫行为
    crawl_config = {
    }

    # 定义一个每24小时运行一次的方法，用于启动爬虫
    @every(minutes=24 * 60)
    def on_start(self):
        # 从您网站的打印机页面开始爬取，回调方法为index_page
        self.crawl('https://www.dyjqd.com/hp/', callback=self.index_page)

    # 定义一个方法，处理打印机列表页面
    @config(age=10 * 24 * 60 * 60)
    def index_page(self, response):
        # 遍历页面中所有打印机链接，对每个链接进行爬取，回调方法为detail_page
        for each in response.doc('a[href^="/hp/"]').items():
            self.crawl(each.attr.href, callback=self.detail_page)

    # 定义一个方法，处理详细页面
    def detail_page(self, response):
        # 提取打印机名称
        printer_name = response.doc('h1').text()

        # 提取驱动下载地址
        driver_url = response.doc('a[href$=".exe"]').attr.href

        # 返回一个字典，包含打印机名称和驱动下载地址
        return {
            "printer_name": printer_name,
            "driver_url": driver_url
        }






# scrapy crawl dyjqd