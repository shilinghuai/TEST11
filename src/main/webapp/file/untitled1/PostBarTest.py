import requests
import shutil
from time import ctime, sleep
from bs4 import BeautifulSoup
import re
import faker
from jieba import analyse

# 引入TF-IDF关键词抽取接口
tfidf = analyse.extract_tags

from datashape import basestring


def praseList(withTag):
  a = 9


# 爬一个块的内容
def reCrawling(withTag):
  strLevel = ""
  ias = 0
  flag = 0
  for w in withTag:
    a = type(w)
    # 如果是字符串
    if (isinstance(w, basestring)):
      # 去空格加换行符
      strLevel += w.strip() + "\n\n"
    else:
      flag = 1
  return strLevel


postBar = "http://tieba.baidu.com"


def crawlingDetail(url):
  url1 = "?see_lz=1"
  url2 = url + url1
  r = requests.get(url2)
  pageAndReply = BeautifulSoup(r.text, 'lxml').find_all("span", {'class': 'red'})
  page = 0
  Reply = 0
  for content in pageAndReply:
    if (len(content.attrs) == 2):
      Reply = int(content.contents[0])
    else:
      # 获取页码
      page = int(content.contents[0])

  strSlh = ""
  list_1 = []
  # 获取页数，进行爬这个帖子的所有页
  for i in range(page):
    parm = "?see_lz=1&pn="
    i = i + 1
    url = url + parm + str(i)
    crawlingContent = requests.get(url)
    contentS = BeautifulSoup(crawlingContent.text, 'lxml').select("div.d_post_content.j_d_post_content.clearfix")
    # 爬当前页的所有内容
    for contS in contentS:
      content = reCrawling(contS.contents)
      # 去重
      if content not in list_1:
        list_1.append(content)
        strSlh += reCrawling(contS.contents)
  return strSlh


def crawlingAllA(url):
  headers = {
    'User-Agent': faker.Faker().user_agent(),
  }
  for i in range(16):

    urlI = url + str(i * 50)

    r = requests.get(urlI, allow_redirects=False)
    pageA = BeautifulSoup(r.text, 'lxml').find_all("a", {'class': 'j_th_tit'})
    print("第" + str(i + 1) + "页,")
    s = 0
    for a in pageA:
      # 爬每一页的50条帖子
      href = a['href']
      tittle = a['title']
      print("第" + str(i + 1) + "页,")
      print("第" + str(s + 1) + "个,爬取这页的五十个帖子")
      print("连接为：" + postBar + href)
      s = s+1
      # 爬这个帖子的详情



crawlingAllA(postBar + '/f?kw=戒色&ie=utf-8&tab=good&cid=2&pn=')
