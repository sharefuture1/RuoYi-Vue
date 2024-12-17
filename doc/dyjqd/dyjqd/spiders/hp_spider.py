import scrapy


class HpSpider(scrapy.Spider):
    name = 'hp_spider'
    allowed_domains = ['dyjqd.com']
    start_urls = ['https://www.dyjqd.com/hp/']

    def parse(self, response):
        # 遍历每页的十个数据项
        for i in range(1, 11):
            printer_xpath = f'/html/body/div/div[5]/div[1]/div[2]/div[2]/div/ul[{i}]/div[2]/ul/li[1]/a'
            # printer_name = response.xpath(f'{printer_xpath}/text()').get()
            driver_download_url = response.xpath(f'{printer_xpath}/@href').get()

            if printer_name and driver_download_url:
                yield {
                    # 'printer_name': printer_name.strip(),
                    'driver_download_url': response.urljoin(driver_download_url)
                }

        # 如果页面有分页，可以继续爬取下一页
        next_page = response.xpath('//a[@class="next-page"]/@href').get()
        if next_page is not None:
            yield response.follow(next_page, self.parse)
