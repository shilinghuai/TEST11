from selenium import webdriver
from bs4 import BeautifulSoup
import requests
import os
import re
import types

dic = {}
url = "http://gkcx.eol.cn/soudaxue/queryschool.html?page=2"
# 请求腾讯新闻的URL，获取其text文本
driver = webdriver.PhantomJS(executable_path=r'D:\Users\shilh\AppData\Local\Continuum\phantomjs-2.1.1-windows\bin\phantomjs.exe');
driver.get(url)
# wbdata = requests.get(url).text
wbdata = driver.page_source
# print(wbdata)
all_tr = BeautifulSoup(wbdata, 'lxml').find_all(class_='lin-gettr')

for tr in all_tr:
    a = tr.find('a')['href']
    b = tr.find('a')['title']
    c = "http://gkcx.eol.cn" + a
    # 继续爬学校简介
    # driver1 = webdriver.PhantomJS();
    # driver1.get(c)
    # wbdata = requests.get(url).text
    # data = driver1.page_source
    # print(wbdata)
    # print(data)
    # d = BeautifulSoup(data, 'lxml').find(text="学校简介")

    # print(d)
    mode = re.compile(r'\d+')
    e = mode.findall(a)
    f = e[0]
    urlj = "http://gkcx.eol.cn/schoolhtm/schoolInfo/" + f + "/10056/detail.htm"
    driver.get(urlj)
    data = driver.page_source
    all_divv = BeautifulSoup(data, 'lxml').find_all(class_='content news')
    print("-----1")
    for divv in all_divv:

        pp = divv.find_all('p')
        print("------2")
        # print(pp)
        asz = [0 for x in range(0, 100)]
        bbl = -1
        for pl in pp:
            bbl = bbl + 1
            pa = re.compile(r'\d{4}年')
            pnr = pl.get_text()
            #  print("---3")
            #  print(pnr)
            # print(bbl)
            asz[bbl] = pa.findall(pnr)
        # print(asz[bbl])

    print(asz)
    qz = [10000, 10000, 10000, 10000, 10000]
    xia = -1;
    for iasz in asz:
        if isinstance(iasz, list):  # 是否是list
            if xia == 2:
                break
            if len(iasz):  # 如果list非空
                for basz in iasz:
                    xia = xia + 1
                    basz1 = basz[0:4]
                    print(basz1)

                    qz[xia] = int(basz1)

                    print(basz)
                    if xia == 2:
                        break
                print("下面一行很重要")
                print(qz)
                print(min(qz))
                dic[b] = min(qz)

    dic[b] = min(qz)

    # print(asz.shape)
    print(e[0])
    print(c)
    print(b)

    #  ab  = td.find('a')
    # print(ab)
    #   ac = ab.text;
    # print(ac)
    # print(ab.get("href"))
# 对获取到的文本进行解析
# soup = BeautifulSoup(wbdata,'lxml')
# 从解析文件中通过select选择器定位指定的元素，返回一个列表
# news_titles = soup.select("div.lin-searchcol-table > table.lin-sechple-table > tbody.lin-seachtable >tr.lin-gettr>td>a")
sorted(dic.items(), key=lambda dic: dic[1])
iaslhg = 0
for b in dic:
    iaslhg = iaslhg + 1
    print(b)
    print(dic[b])
    print(iaslhg)


