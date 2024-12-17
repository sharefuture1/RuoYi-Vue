import scrapy


class HpSpider1Spider(scrapy.Spider):
    name = 'ym'
    allowed_domains = ['dyjqd.com']
    start_urls = ['https://www.dyjqd.com/jolimark']
    # 映美
    # start_urls = ['http://dyjqd.com/canon']
    # start_urls = ['http://dyjqd.com/hp']
    page_number = 1  # 初始化页码
    results = []  # 用于存储收集到的数据

    def parse(self, response):
        # 遍历每页的十个数据项
        for i in range(1, 11):
            printer_li = response.css(f'#left > div.bk > div.ucontent > div > ul:nth-child({i}) > div.downdes > ul > li.dtitle')
            if printer_li:
                printer_li = printer_li[0]
                printer_name = printer_li.css('a::text').get()
                driver_download_url = printer_li.css('a::attr(href)').get()

                if printer_name and driver_download_url:
                    print(f"Found printer name: {printer_name}")
                    item = {
                        'printer_name': printer_name.strip().replace('驱动', ''),
                        'driver_download_url': response.urljoin(driver_download_url)
                    }
                    self.results.append(item)  # 将数据项添加到结果列表中
                    yield scrapy.Request(item['driver_download_url'], callback=self.parse_detail, meta={'item': item})
                else:
                    print(f"Could not find printer name or driver download url for item {i}")
            else:
                print(f"No printer information found for item {i}")

        # 尝试获取下一页的URL
        next_page_url = response.css('a:contains("下一页")::attr(href)').get()
        if next_page_url:
            self.page_number += 1
            yield response.follow(next_page_url, callback=self.parse)
        else:
            print("获取完毕，结束运行")
            self.crawler.engine.close_spider(self, reason='finished')

    def parse_detail(self, response):
        # 从meta中获取之前构造的item字典
        item = response.meta['item']

        # 使用CSS选择器从详细页面中提取更多信息
        # 例如，假设驱动程序名称位于某个特定的元素中



        # driver_name = response.css('.driver-name::text').get()
        #
        # # 将提取的驱动程序名称添加到item字典中
        # item['driver_name'] = driver_name
        #
        # # 打印提取的驱动程序名称
        # print(f"Found driver name: {driver_name}")

        # 返回包含所有信息的item
        yield item

    def closed(self, reason):
        # 在爬虫关闭时，将数据写入到TXT文件
        with open('printerYm.txt', 'a', encoding='utf-8') as f:
            for item in self.results:
                f.write(f"{item['printer_name']}\t{item['driver_download_url']}\n")


# 初始化结果列表
HpSpider1Spider.results = []
