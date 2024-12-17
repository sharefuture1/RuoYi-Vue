import scrapy


class HpSpider(scrapy.Spider):
    name = 'hp_spider'
    allowed_domains = ['dyjqd.com']
    start_urls = ['https://www.dyjqd.com/hp/']
    def parse(self, response):
        pass
