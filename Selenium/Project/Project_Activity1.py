# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
def get_website_title(url):
    service = FirefoxService(GeckoDriverManager().install())
    with webdriver.Firefox(service=service) as driver:
        driver.get(url)
        title = driver.title
        return title
def teardown():
    driver.quit

url = 'http://alchemy.hguy.co/orangehrm'
title = get_website_title(url)
print("Page title is:", title)
